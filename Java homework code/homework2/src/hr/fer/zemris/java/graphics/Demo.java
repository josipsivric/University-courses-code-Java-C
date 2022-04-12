package hr.fer.zemris.java.graphics;

import hr.fer.zemris.java.graphics.raster.BWRaster;
import hr.fer.zemris.java.graphics.raster.BWRasterMem;
import hr.fer.zemris.java.graphics.shapes.Circle;
import hr.fer.zemris.java.graphics.shapes.Ellipse;
import hr.fer.zemris.java.graphics.shapes.GeometricShape;
import hr.fer.zemris.java.graphics.shapes.Rectangle;
import hr.fer.zemris.java.graphics.shapes.Square;
import hr.fer.zemris.java.graphics.shapes.Triangle;
import hr.fer.zemris.java.graphics.views.RasterView;
import hr.fer.zemris.java.graphics.views.SimpleRasterView;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Awaits user input, then prints requested shapes on the screen.
 * 
 * @author Josip Sivrić
 *
 */
public class Demo {

	/**
	 * @param args Arguments are size of the raster horizontally and vertically.
	 */
	public static void main(String[] args) {
		
		if (args.length < 1 || args.length > 2) {
			System.err.println("Number of arguments must be 1 or 2!");
			System.exit(1);
		}
		
		int first = 0;
		int second = 0;
		int numberOfShapes = 0;
		String line;
		Scanner sc = null;
		
		try {
			first = Integer.parseInt(args[0]);
			if (args.length == 2)
				second = Integer.parseInt(args[1]);
			else
				second = first;
		} catch (NumberFormatException e){
			System.err.print("Arguments must be an integer numbers!");
			System.exit(1);
		}
		
		try {
			sc = new Scanner(System.in);
			line = sc.nextLine();
			numberOfShapes = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.err.print("Parameter must be an integer number!");
			System.exit(1);
		}

		if (numberOfShapes > 7)
			numberOfShapes = 7;
		if (numberOfShapes < 1) {
			System.err.print("There must be at least one shape or flip!");
			System.exit(1);
		}

		GeometricShape[] arrayOfShapes = new GeometricShape[7];
		String nextShape;
		
		for (int i = 0; i < numberOfShapes; i++ ) {
			line = sc.nextLine();
			Scanner s = new Scanner(line).useDelimiter("\\s+");
			nextShape = s.next();
			try {
				switch (nextShape) {
					case "FLIP":
						arrayOfShapes[i] = null;
						break;
					case "RECTANGLE":
						arrayOfShapes[i] = new Rectangle(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
						break;
					case "SQUARE":
						arrayOfShapes[i] = new Square(s.nextInt(), s.nextInt(), s.nextInt());
						break;
					case "TRIANGLE":
						arrayOfShapes[i] = new Triangle(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
						break;
					case "CIRCLE":
						arrayOfShapes[i] = new Circle(s.nextInt(), s.nextInt(), s.nextInt());
						break;
					case "ELLIPSE":
						arrayOfShapes[i] = new Ellipse(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
						break;
					default:
						System.err.print("Shape must be RECTANGLE, SQUARE, TRIANGLE, CIRCLE or ELLIPSE!");
						System.exit(1);
				}
			} catch (NoSuchElementException e){
				System.err.print("Shape parameters are not valid!");
				System.exit(1);
			}
		}
		
		BWRaster r = new BWRasterMem(first, second);
		
		for (int i = 0; i < numberOfShapes; i++ ) {
			if (arrayOfShapes[i] == null) {
				if (r.flipModeStatus())
					r.disableFlipMode();
				else
					r.enableFlipMode();
				}
			else {
				arrayOfShapes[i].draw(r);
			}
		}
		
		RasterView view = new SimpleRasterView();
		view.produce(r);
	}
}
