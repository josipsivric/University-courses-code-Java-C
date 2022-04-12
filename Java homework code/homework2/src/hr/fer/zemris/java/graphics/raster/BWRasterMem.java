package hr.fer.zemris.java.graphics.raster;

import java.util.BitSet;

/**
 * Implementation of BWRaster interfaces. Keeps all data in memory using BitSet.
 * 
 * @author Josip Sivrić
 *
 */
public class BWRasterMem implements BWRaster{
	
	private int height;
	private int width;
	private boolean flipMode;
	
	BitSet raster = new BitSet(getWidth()*getHeight());
 
	/**
	 * Creates raster.
	 * @param height Height of raster.
	 * @param width Width of raster.
	 */
	public BWRasterMem(int height, int width) {
		this.height = height;
		this.width = width;
		clear();
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public int getWidth() {	
		return width;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public int getHeight() {
		return height;
	}

	/** 
	 * {@inheritDoc}
	 */
	public void clear() {
		raster.clear();
	}

	/** 
	 * {@inheritDoc}
	 */
	public void turnOn(int x, int y) {
		if ((x >= 0 && x < getWidth()) && (y >= 0 && y < getHeight())) {
			if(flipMode)
				raster.flip(x * getWidth() + y);
			else
				raster.set(x * getWidth() + y);	
		}
		else throw new IndexOutOfBoundsException();
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public void turnOff(int x, int y) {
		if ((x >= 0 || x < getWidth()) && (y >= 0 || y < getHeight()))
			raster.clear(x * getWidth() + y);
		else throw new IndexOutOfBoundsException();
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public void enableFlipMode() {
		this.flipMode = true;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public void disableFlipMode() {
		this.flipMode = false;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public boolean flipModeStatus() {
		return this.flipMode;
	}
	
	/** 
	 * {@inheritDoc}
	 */
	public boolean isTurnedOn(int x, int y) {
		if ((x >= 0 || x < getWidth()) && (y >= 0 || y < getHeight()))
			return raster.get(x * getWidth() + y);
		else throw new IndexOutOfBoundsException();
	}
}
