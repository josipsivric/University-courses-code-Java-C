package hr.fer.zemris.java.graphics.raster;

/**
 * Interface for Black-and-White raster with fixed width and height. 
 * 
 * @author Josip Sivrić
 *
 */
public interface BWRaster {
	
	/**
	 * Returns width of raster.
	 * 
	 * @return Returns width of raster.
	 */
	int getWidth();
	
	/**
	 * Returns height of raster.
	 * 
	 * @return Returns height of raster.
	 */
	int getHeight();
	
	/**
	 * Clears entire raster. Sets all pixels to false (black).
	 */
	void clear();
	
	/**
	 * Changes state of given pixel depending on the status of FlipMode.
	 * @param x X coordinates in Cartesian system.
	 * @param y Y coordinates in Cartesian system.
	 */
	void turnOn(int x, int y);
	
	/**
	 * Turns off pixel at given position.
	 * @param x X coordinates in Cartesian system.
	 * @param y Y coordinates in Cartesian system.
	 */
	void turnOff(int x, int y);
	
	/**
	 * Enables FlipMode. If turnOn(x, y); is called the pixel will 
	 * change it state to opposite one.
	 */
	void enableFlipMode();
	
	/**
	 * Disables FlipMode. If turnOn(x, y); is called the pixel will
	 * be turned on.
	 */
	void disableFlipMode();
	
	/**
	 * Returns Current status of FlipMode.
	 * @return Returns Current status of FlipMode.
	 */
	boolean flipModeStatus();
	
	/**
	 * Checks the state of the pixel.
	 * @param x X coordinates in Cartesian system.
	 * @param y Y coordinates in Cartesian system.
	 * @return returns FALSE if pixel is off, otherwise TRUE.
	 */
	boolean isTurnedOn(int x, int y);

}
