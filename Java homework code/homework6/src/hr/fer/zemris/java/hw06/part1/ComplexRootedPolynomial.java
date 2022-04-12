package hr.fer.zemris.java.hw06.part1;

public class ComplexRootedPolynomial {
	
	private Complex[] roots;
	
	// ...
	// constructor
	public ComplexRootedPolynomial(Complex ...roots) {
		this.roots = roots;
	}
	
	// computes polynomial value at given point z
	public Complex apply(Complex z) {
		return z;	
	}
	
	// converts this representation to ComplexPolynomial type
	public ComplexPolynomial toComplexPolynom() {
		return null;		
	}
	
	@Override
	public String toString() {
		return null;	
	}
	
	// finds index of closest root for given complex number z that is within treshold
	// if there is no such root, returns -1
	public int indexOfClosestRootFor(Complex z, double treshold) {
		return 0;	
	}
}
