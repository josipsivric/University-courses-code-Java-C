package hr.fer.zemris.java.hw06.part2;

import hr.fer.zemris.java.tecaj_06.rays.IRayTracerProducer;
import hr.fer.zemris.java.tecaj_06.rays.IRayTracerResultObserver;
import hr.fer.zemris.java.tecaj_06.rays.Point3D;
import hr.fer.zemris.java.tecaj_06.rays.Ray;
import hr.fer.zemris.java.tecaj_06.rays.RayTracerViewer;
import hr.fer.zemris.java.tecaj_06.rays.Scene;

public class RayCaster {

	public static void main(String[] args) {

		RayTracerViewer.show(getIRayTracerProducer(), newPoint3D(10, 0, 0),
				newPoint3D(0, 0, 0), newPoint3D(0, 0, 10), 20, 20);
	}

	private static Point3D newPoint3D(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	private static IRayTracerProducer getIRayTracerProducer() {
		return new IRayTracerProducer() {
			@Override
			public void produce(Point3D eye, Point3D view, Point3D viewUp,
					double horizontal, double vertical, int width, int height,
					long requestNo, IRayTracerResultObserver observer) {
				
				System.out.println("Započinjem izračune...");
				
				short[] red = new short[width * height];
				short[] green = new short[width * height];
				short[] blue = new short[width * height];
				
				Point3D zAxis; // todo
				Point3D yAxis; // todo
				Point3D xAxis; // todo
				Point3D screenCorner; // todo
				
				Scene scene = RayTracerViewer.createPredefinedScene();
				
				short[] rgb = new short[3];
				int offset = 0;
				
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						Point3D screenPoint = null;// todo
						Ray ray = Ray.fromPoints(eye, screenPoint);
						tracer(scene, ray, rgb);
						red[offset] = rgb[0] > 255 ? 255 : rgb[0];
						green[offset] = rgb[1] > 255 ? 255 : rgb[1];
						blue[offset] = rgb[2] > 255 ? 255 : rgb[2];
						offset++;
					}
				}
				
				System.out.println("Izračuni gotovi...");
				
				observer.acceptResult(red, green, blue, requestNo);
				
				System.out.println("Dojava gotova...");
			}

			private void tracer(Scene scene, Ray ray, short[] rgb) {
				// TODO Auto-generated method stub

			}
		};
	}
}
