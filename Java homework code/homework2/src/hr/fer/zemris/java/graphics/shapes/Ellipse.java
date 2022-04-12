package hr.fer.zemris.java.graphics.shapes;

/**
 * Class used for managing ellipse.
 * @author Josip Sivrić
 *
 */
public class Ellipse extends GeometricShape{
	
	private int centerX;
	private int centerY;
	private int horizontalRadius;
	private int verticalRadius;
	
	/**
	 * @return Returns X coordinate of ellipse center.
	 */
	public int getCenterX() {
		return centerX;
	}
	
	/**
	 * @param centerX Sets X coordinate of ellipse center.
	 */
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	
	/**
	 * @return Returns Y coordinate of ellipse center.
	 */
	public int getCenterY() {
		return centerY;
	}
	
	/**
	 * @param centerY Sets Y coordinate of ellipse center.
	 */
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	
	/**
	 * @return Returns horizontal radius of ellipse.
	 */
	public int getHorizontalRadius() {
		return horizontalRadius;
	}
	
	/**
	 * @param horizontalRadius Sets horizontal radius of ellipse.
	 */
	public void setHorizontalRadius(int horizontalRadius) {
		this.horizontalRadius = horizontalRadius;
	}
	
	/**
	 * @return Returns vertical radius of ellipse.
	 */
	public int getVerticalRadius() {
		return verticalRadius;
	}
	
	/**
	 * @param verticalRadius Sets vertical radius of ellipse.
	 */
	public void setVerticalRadius(int verticalRadius) {
		this.verticalRadius = verticalRadius;
	}

	/**
	 * Creates ellipse with given parameters.
	 * @param centerX X coordinate of ellipse center.
	 * @param centerY Y coordinate of ellipse center.
	 * @param horizontalRadius Horizontal radius of ellipse.
	 * @param verticalRadius Vertical radius of ellipse.
	 */
	public Ellipse(int centerX, int centerY, int horizontalRadius, int verticalRadius) {
		super();
		this.centerX = centerX;
		this.centerY = centerY;
		
		if (horizontalRadius >= 1)
			this.horizontalRadius = horizontalRadius;
		else
			throw new IllegalArgumentException("Horizontal radius cannot be smaller than 1!");
		
		if (verticalRadius >= 1)
			this.verticalRadius = verticalRadius;
		else
			throw new IllegalArgumentException("Vertical radius cannot be smaller than 1!");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsPoint(int x, int y) {
		double focusDistance = Math.sqrt(horizontalRadius*horizontalRadius + verticalRadius*verticalRadius);
		//Normal ellipse
		if (horizontalRadius > verticalRadius) {
			double focus1 = focusDistance + centerX;
			double focus2 = focusDistance - centerX;
			double vector1 = Math.sqrt((focus1 - x)*(focus1 - x) + (centerY - y)*(centerY - y));
			double vector2 = Math.sqrt((focus2 - x)*(focus2 - x) + (centerY - y)*(centerY - y));
			double sum = vector1 + vector2;
			int roundedDistance =  (int) Math.round(sum);
			if (roundedDistance > 2*horizontalRadius)
				return false;
			else
				return true;			
		} // Rotated ellipse
		else if (horizontalRadius < verticalRadius){
			
			double focus1 = focusDistance + centerY;
			double focus2 = focusDistance - centerY;
			double vector1 = Math.sqrt(((focus1 - y)*(focus1 - y) + (centerX - x)*(centerX - x)));
			double vector2 = Math.sqrt(((focus2 - y)*(focus2 - y) + (centerX - x)*(centerX - x)));
			double sum = vector1 + vector2;
			int roundedDistance =  (int) Math.round(sum);
			if (roundedDistance > 2*verticalRadius)
				return false;
			else
				return true;
		} // Special case, circle.
		else {
			if ((x - centerX)*(x - centerX) + (y - centerY)*(y - centerY) <= verticalRadius*verticalRadius)
				return true;
			else
				return false;
		}
	}
}
