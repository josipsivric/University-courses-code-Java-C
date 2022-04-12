package hr.fer.zemris.java.graphics.shapes;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Base abstract class that is inherited by all shapes.
 * @author Josip Sivrić
 *
 */
public abstract class GeometricShape {
	
	/**
	 * Sets corresponding pixels "on" when drawing a shape.
	 * @param r It uses raster as a parameter.
	 */
	public void draw(BWRaster r) {
		for (int row = 0; row < r.getWidth(); row++)
			for (int column = 0; column < r.getHeight(); column++ )
				if (containsPoint(row, column))
					r.turnOn(row, column);	
	}
	
	/**
	 * Checks given point if it is inside shape.
	 * 
	 * @param x X coordinates in Cartesian system.
	 * @param y Y coordinates in Cartesian system.
	 * @return Returns TRUE if it is inside shape, otherwise FALSE.
	 */
	public abstract boolean containsPoint(int x, int y);
	
}
