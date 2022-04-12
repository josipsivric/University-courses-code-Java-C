package hr.fer.zemris.java.graphics.shapes;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Class used for managing square.
 * @author Josip Sivrić
 *
 */
public class Square extends GeometricShape{
	
		private int topLeftX;
		private int topLeftY;
		private int squareSide;

		/**
		 * @return Returns X coordinate from top left point in square.
		 */
		public int getTopLeftX() {
			return topLeftX;
		}

		/**
		 * @param topLeftX Sets X coordinate from top left point in square.
		 */
		public void setTopLeftX(int topLeftX) {
			this.topLeftX = topLeftX;
		}

		/**
		 * @return Returns Y coordinate from top left point in square.
		 */
		public int getTopLeftY() {
			return topLeftY;
		}

		/**
		 * @param topLeftY Sets Y coordinate from top left point in square.
		 */
		public void setTopLeftY(int topLeftY) {
			this.topLeftY = topLeftY;
		}
		
		/**
		 * @return Returns size of square side.
		 */
		public int getSquareSide() {
			return squareSide;
		}

		/**
		 * @param squareSide Sets size of square side.
		 */
		public void setSquareSide(int squareSide) {
			this.squareSide = squareSide;
		}

		/**
		 * Creates Square with given parameters.
		 * @param topLeftX X coordinate from top left point in square.
		 * @param topLeftY Y coordinate from top left point in square.
		 * @param squareSide size of the square side.
		 */
		public Square(int topLeftX, int topLeftY, int squareSide) {
			super();
			this.topLeftX = topLeftX;
			this.topLeftY = topLeftY;
			
			if (squareSide <= 0)
				throw new IllegalArgumentException("Size cannot be 0 or negative!");
			else
				this.squareSide = squareSide;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean containsPoint(int x, int y) {
			
			if(x < topLeftX) return false;
			if(y < topLeftY) return false;
			if(x >= topLeftX + squareSide) return false;
			if(y >= topLeftY + squareSide) return false;
			return true;	
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void draw(BWRaster r) {
			for (int row = topLeftX; row < topLeftX + squareSide; row++)
				for (int column = topLeftY; column < topLeftY + squareSide; column++ )
					if (containsPoint(row, column))
						r.turnOn(row, column);	
		}
}
