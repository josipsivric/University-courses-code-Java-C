package hr.fer.zemris.java.graphics.shapes;

import hr.fer.zemris.java.graphics.raster.BWRaster;


/**
 * Class used for managing rectangle.
 * @author Josip Sivrić
 *
 */
public class Rectangle extends GeometricShape{

	private int topLeftX;
	private int topLeftY;
	private int rectangleWidth;
	private int rectangleHeight;

	/**
	 * @return Returns X coordinate from top left point in rectangle.
	 */
	public int getTopLeftX() {
		return topLeftX;
	}

	/**
	 * @param topLeftX Sets X coordinate from top left point in rectangle.
	 */
	public void setTopLeftX(int topLeftX) {
		this.topLeftX = topLeftX;
	}

	/**
	 * @return Returns Y coordinate from top left point in rectangle.
	 */
	public int getTopLeftY() {
		return topLeftY;
	}

	/**
	 * @param topLeftY Sets Y coordinate from top left point in rectangle.
	 */
	public void setTopLeftY(int topLeftY) {
		this.topLeftY = topLeftY;
	}

	/**
	 * @return Returns width of rectangle.
	 */
	public int getRectangleWidth() {
		return rectangleWidth;
	}

	/**
	 * @param rectangleWidth Sets width of rectangle.
	 */
	public void setRectangleWidth(int rectangleWidth) {
		this.rectangleWidth = rectangleWidth;
	}

	/**
	 * @return Returns height of rectangle.
	 */
	public int getRectangleHeight() {
		return rectangleHeight;
	}

	/**
	 * @param rectangleHeight Sets height of rectangle.
	 */
	public void setRectangleHeight(int rectangleHeight) {
		this.rectangleHeight = rectangleHeight;
	}
	
	/**
	 * Creates Rectangle with given parameters.
	 * @param topLeftX X coordinate from top left point in rectangle.
	 * @param topLeftY Y coordinate from top left point in rectangle.
	 * @param rectangleWidth Width of rectangle.
	 * @param rectangleHeight Height of rectangle.
	 */
	public Rectangle(int topLeftX, int topLeftY, int rectangleWidth, int rectangleHeight) {
		super();
		this.topLeftX = topLeftX;
		this.topLeftY = topLeftY;
		
		if (rectangleWidth <= 0)
			throw new IllegalArgumentException("Width cannot be 0 or negative!");
		else
			this.rectangleWidth = rectangleWidth;
		
		if (rectangleHeight <= 0)
			throw new IllegalArgumentException("Height cannot be 0 or negative!");
		else
			this.rectangleHeight = rectangleHeight;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsPoint(int x, int y) {
		
		if(x < topLeftX) return false;
		if(y < topLeftY) return false;
		if(x >= topLeftX + rectangleWidth) return false;
		if(y >= topLeftY + rectangleHeight) return false;
		return true;	
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void draw(BWRaster r) {
		for (int row = topLeftX; row < topLeftX + rectangleWidth; row++)
			for (int column = topLeftY; column < topLeftY + rectangleHeight; column++ )
				if (containsPoint(row, column))
					r.turnOn(row, column);	
	}
}
