package hr.fer.zemris.java.graphics.shapes;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Class used for managing circle.
 * @author Josip Sivrić
 *
 */
public class Circle extends GeometricShape {
	
	private int centerX;
	private int centerY;
	private int radius;
	
	/**
	 * @return Returns X coordinate of circles center.
	 */
	public int getCenterX() {
		return centerX;
	}
	
	/**
	 * @param centerX Sets x coordinate of circles center to a given value.
	 */
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	
	/**
	 * @return Returns Y coordinate of circles center.
	 */
	public int getCenterY() {
		return centerY;
	}
	
	/**
	 * @param centerY Sets Y coordinate of circles center to a given value.
	 */
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	
	/**
	 * @return Returns radius of circle.
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * @param radius Sets radius of circle.
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 * Creates circle with given parameters.
	 * @param centerX X coordinate of circles center.
	 * @param centerY Y coordinate of circles center.
	 * @param radius Radius of circle.
	 */
	public Circle(int centerX, int centerY, int radius) {
		super();
		this.centerX = centerX;
		this.centerY = centerY;
		if (radius >= 1)
			this.radius = radius;
		else
			throw new IllegalArgumentException("Radius cannot be smaller than 1!");
	}
	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsPoint(int x, int y) {
		
		if ((x - centerX)*(x - centerX) + (y - centerY)*(y - centerY) <= radius*radius)
			return true;
		else
			return false;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	@Override
	public void draw(BWRaster r) {
		for (int row = centerX - radius; row < centerX + radius + 1; row++)
			for (int column = centerY - radius; column < centerY + radius + 1; column++ )
				if (containsPoint(row, column))
					r.turnOn(row, column);	
	}
}
