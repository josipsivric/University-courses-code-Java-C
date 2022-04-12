package hr.fer.zemris.java.graphics.shapes;

public class Triangle extends GeometricShape{
	
	private int pointAX;
	private int pointAY;
	
	private int pointBX;
	private int pointBY;
	
	private int pointCX;
	private int pointCY;
	
	/**
	 * @return Returns X coordinate of point A in triangle.
	 */
	public int getPointAX() {
		return pointAX;
	}
	
	/**
	 * @param pointAX Sets X coordinate of point A in triangle.
	 */
	public void setPointAX(int pointAX) {
		this.pointAX = pointAX;
	}
	
	/**
	 * @return Returns Y coordinate of point A in triangle.
	 */
	public int getPointAY() {
		return pointAY;
	}
	
	/**
	 * @param pointAY Sets Y coordinate of point A in triangle.
	 */
	public void setPointAY(int pointAY) {
		this.pointAY = pointAY;
	}
	
	/**
	 * @return Returns X coordinate of point B in triangle.
	 */
	public int getPointBX() {
		return pointBX;
	}
	
	/**
	 * @param pointBX Sets X coordinate of point B in triangle.
	 */
	public void setPointBX(int pointBX) {
		this.pointBX = pointBX;
	}
	
	/**
	 * @return Returns Y coordinate of point B in triangle.
	 */
	public int getPointBY() {
		return pointBY;
	}
	
	/**
	 * @param pointBY Sets Y coordinate of point B in triangle.
	 */
	public void setPointBY(int pointBY) {
		this.pointBY = pointBY;
	}
	
	/**
	 * @return Returns X coordinate of point C in triangle.
	 */
	public int getPointCX() {
		return pointCX;
	}
	
	/**
	 * @param pointCX Sets X coordinate of point C in triangle.
	 */
	public void setPointCX(int pointCX) {
		this.pointCX = pointCX;
	}
	
	/**
	 * @return Returns Y coordinate of point C in triangle.
	 */
	public int getPointCY() {
		return pointCY;
	}
	
	/**
	 * @param pointCY Sets Y coordinate of point C in triangle.
	 */
	public void setPointCY(int pointCY) {
		this.pointCY = pointCY;
	}

	/**
	 * Creates a triangle using given parameters
	 * @param pointAX X coordinate of point A in triangle.
	 * @param pointAY Y coordinate of point A in triangle.
	 * @param pointBX X coordinate of point B in triangle.
	 * @param pointBY Y coordinate of point B in triangle.
	 * @param pointCX X coordinate of point C in triangle.
	 * @param pointCY Y coordinate of point C in triangle.
	 */
	public Triangle(int pointAX, int pointAY, int pointBX, int pointBY,
			int pointCX, int pointCY) {
		super();
		this.pointAX = pointAX;
		this.pointAY = pointAY;
		this.pointBX = pointBX;
		this.pointBY = pointBY;
		this.pointCX = pointCX;
		this.pointCY = pointCY;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsPoint(int x, int y) {
		int checkABC = (pointBX - pointAX)*(pointCY - pointAY) - (pointBY - pointAY)*(pointCX - pointAX);
		int checkABP = (pointBX - pointAX)*(y - pointAY) - (pointBY - pointAY)*(x - pointAX);
		int checkBCP = (pointBX - x)*(pointCY - y) - (pointBY - y)*(pointCX - x);
		int checkCAP = (x - pointAX)*(pointCY - pointAY) - (y - pointAY)*(pointCX - pointAX);
		
		if (checkABC > 0)
			if ( checkABP >= 0 && checkBCP >= 0 && checkCAP >= 0)
				return true;
		if (checkABC < 0)
			if (checkABP <= 0 && checkBCP <= 0 && checkCAP <= 0)
				return true;
		return false;
	}

}
