package hr.fer.zemris.java.tecaj.hw5.crypto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Used for encrypting and decrypting AES crypted files. Can calculate SHA-1 checksum.
 * 
 * @author Josip Sivrić
 *
 */
public class Crypto {

	/**
	 * @param args Recieves 2 or 3 arguments depending on usage.
	 * Valid first argument is checksha, crypt or decrypt. Second and third are filepaths.
	 */
	public static void main(String[] args)  {

		if (args.length < 2 || args.length > 3) {
			System.err.println("Invalid number of arguments!");
			System.exit(1);
		}

		String shaCheck = "checksha";
		String crypt = "crypt";
		String decrypt = "decrypt";
		String filePath;
		String generatedFilePath;
		String signature = null;
		String password = null;
		String initVector = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// determine command and call corresponding method

		if (args[0].equalsIgnoreCase(shaCheck)) {
			filePath = args[1];
			System.out.println("Please provide expected sha signature for " + filePath + ":");
			try {
				signature = br.readLine();
			} catch (IOException e) {
				System.err.println("Cannot read file!");
				System.exit(1);
			}
			checkSha(filePath, signature);
		} else if (args[0].equalsIgnoreCase(crypt)) {
			filePath = args[1];
			generatedFilePath = args[2];
			
			System.out.println("Please provide password as hex-encoded text:");
			try {
				password = br.readLine();
			} catch (IOException e) {
				System.err.println("Cannot read file!");
				System.exit(1);
			}
			if(password.length() != 32) {
				System.err.println("Password length is not valid!");
				System.exit(1);
			}
			
			System.out.println("Please provide initialization vector as hex-encoded text:");
			try {
				initVector = br.readLine();
			} catch (IOException e) {
				System.err.println("Cannot read file!");
				System.exit(1);
			}
			if(initVector.length() != 32) {
				System.err.println("Initialization vector length is not valid!");
				System.exit(1);
			}
			
			encrypt(true, password, initVector, filePath, generatedFilePath);
			
			System.out.println("Encryption completed. Generated file " + generatedFilePath
					+ " based on file " + filePath);
		} else if (args[0].equalsIgnoreCase(decrypt)) {
			filePath = args[1];
			generatedFilePath = args[2];
			
			System.out.println("Please provide password as hex-encoded text:");
			try {
				password = br.readLine();
			} catch (IOException e) {
				System.err.println("Cannot read file!");
				System.exit(1);
			}
			if(password.length() != 32) {
				System.err.println("Password length is not valid!");
				System.exit(1);
			}
			
			System.out.println("Please provide initialization vector as hex-encoded text:");
			try {
				initVector = br.readLine();
			} catch (IOException e) {
				System.err.println("Cannot read file!");
				System.exit(1);
			}
			if(initVector.length() != 32) {
				System.err.println("Initialization vector length is not valid!");
				System.exit(1);
			}
			
			encrypt(false, password, initVector, filePath, generatedFilePath);
			
			System.out.println("Decryption completed. Generated file " + generatedFilePath
					+ " based on file " + filePath);
		} else {
			System.err.println("Unknown command! Please use \"checksha\", \"crypt\", or \"decrypt\"!");
			System.exit(1);
		}
	}

	/**
	 * Translates HEX string to byte[].
	 * 
	 * @param hexText Recieves String object containing HEX value.
	 * 
	 * @return Returns array of bytes containing HEX value.
	 */
	private static byte[] hextobyte(String hexText) {

		int length = hexText.length();
	    byte[] data = new byte[length / 2];
	    for (int i = 0; i < length; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(hexText.charAt(i), 16) << 4)
	                             + Character.digit(hexText.charAt(i+1), 16));
	    }
	    return data;
	}

	/**
	 * Translates byte[] data to HEX string.
	 * 
	 * @param hexData Recieves byte[] data for conversion.
	 * 
	 * @return Returns String containing HEX value.
	 */
	public static String hexToString(byte[] hexData){
		  String result = "";
		  for (int i = 0; i < hexData.length; i++) {
		    result += Integer.toString( ( hexData[i] & 0xff ) + 0x100, 16).substring( 1 );
		  }
		  return result;
		}
	
	/**
	 * Calculates SHA-1 value of given file and compares it with user provided value.
	 *  
	 * @param filePath Path to the file whose SHA-1 checksum should be created.
	 * @param signature SHA checksum that will be compared against calculated checksum.
	 */
	private static void checkSha(String filePath, String signature) {
		
		byte[] hash = null;
		String hash2 = null;
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Invalid algorithm!");
			System.exit(1);
		}
		
		Path p = Paths.get(filePath);
		FileInputStream is = null;
		try {
			is = new FileInputStream(p.toFile());
		} catch (FileNotFoundException e1) {
			System.err.println("Input file not found!");
			System.exit(1);
		}
		
		byte[] buff = new byte[4096];
		try {
			while(true) {
				int r = is.read(buff);
				if(r < 1)
					break;
				md.update(buff, 0, r);
			}
			hash = md.digest();
		} catch (Exception e) {
			System.err.println("Sha exception!");
			System.exit(1);
		}
		

		hash2 = hexToString(hash);
		if(signature.equals(hash2))
			System.out.println("Digesting completed. Digest of " + filePath
					+ " matches expected digest.");
		else
			System.out.println("Digesting completed. Digest of " + filePath
					+ " does not match the expected digest. Digest was: " + signature);
	}

	/**
	 * Used for encryption or decryption of files using AES.
	 * 
	 * @param encrypt Sets mode. TRUE sets encryption and FALSE decryption
	 * @param keyText Provides a password.
	 * @param ivText Provides initialization vector.
	 * @param filePath Path to the file that will be encrypted/decrypted
	 * @param generatedFilePath Path for generated file.
	 */
	private static void encrypt(boolean encrypt, String keyText, String ivText,
			String filePath, String generatedFilePath) {

		Cipher cipher = null;

		SecretKeySpec keySpec = new SecretKeySpec(hextobyte(keyText), "AES");
		AlgorithmParameterSpec paramSpec = new IvParameterSpec(hextobyte(ivText));

		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			System.err.println("Invalid algorithm or padding!");
			System.exit(1);
		}

		try {
			cipher.init(encrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE,
					keySpec, paramSpec);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			System.err.println("Invalid key or parameter!");
			System.exit(1);
		}
		
		Path p = Paths.get(filePath);
		Path p2 = Paths.get(generatedFilePath);
		FileInputStream is = null;
		try {
			is = new FileInputStream(p.toFile());
		} catch (FileNotFoundException e1) {
			System.err.println("Input file not found!");
			System.exit(1);
		}
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(p2.toFile());
		} catch (FileNotFoundException e1) {
			System.err.println("Output file not accessible!");
			System.exit(1);
		}
		byte[] buff = new byte[4096];
		try {
			while(true) {
				int r = is.read(buff);
				if(r < 1)
					break;
				os.write(cipher.update(buff, 0, r));
			}
				try {
					os.write(cipher.doFinal());
				} catch (IllegalBlockSizeException e) {
					System.err.println("Illegal block size!");
					System.exit(1);
				} catch (BadPaddingException e) {
					System.err.println("Bad padding!");
					System.exit(1);
				}
		} catch(IOException ex) {}
		finally {
			if(is != null) {
				try { is.close(); } catch(IOException ignorable) {}
			}
		}
	}
}
