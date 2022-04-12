package hr.fer.zemris.java.graphics.views;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Implementation of RasterView interface.
 * @author Josip Sivrić
 *
 */
public class SimpleRasterView implements RasterView{
	
	private char on;
	private char off;
	
	/**
	 * Sets character for presenting pixels in text mode.
	 * @param on Text representation of working pixel (white).
	 * @param off Text representation of nonworking pixel (black).
	 */
	public SimpleRasterView(char on, char off) {		
		this.on = on;
		this.off = off;
	}
	
	/**
	 * Sends default caharacters for representing pixels in text mode.
	 */
	public SimpleRasterView() {
		this('*', '.');
	}

	/** 
	 * {@inheritDoc}
	 */
	public void produce(BWRaster raster) {
		for (int i = 0; i < raster.getWidth(); i++ ) {
			for (int j = 0; j < raster.getHeight(); j++) {
				if(raster.isTurnedOn(j, i))
					System.out.print(on);
				else
					System.out.print(off);
			}
			if(i < raster.getWidth() - 1)
				System.out.print("\n");
		}
	}
}
