package hr.fer.zemris.java.graphics.views;

import hr.fer.zemris.java.graphics.raster.BWRaster;

/**
 * Interface for producing shapes.
 * 
 * @author Josip Sivrić
 *
 */
public interface RasterView {
	
	/**
	 * Serves as interface for producing the shapes on screen.
	 * @param raster Accepts one raster as parameter.
	 */
	void produce(BWRaster raster);
}
