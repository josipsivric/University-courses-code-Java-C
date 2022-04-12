package hr.fer.zemris.java.hw06.part1;

public class ComplexPolynomial {
	
	private Complex[] factors;
	// ...
	// constructor
	public ComplexPolynomial(Complex ...factors) {
		this.factors = factors;
	}
	
	// returns order of this polynom; eg. For (7+2i)z^3+2z^2+5z+1 returns 3
	public short order() {
		return 0;
	}
	
	// computes a new polynomial this*p
	public ComplexPolynomial multiply(ComplexPolynomial p) {
		return p;
	}
	
	// computes first derivative of this polynomial; for example, for
	// (7+2i)z^3+2z^2+5z+1 returns (21+6i)z^2+4z+5
	public ComplexPolynomial derive() {
		return null;
	}
	
	// computes polynomial value at given point z
	public Complex apply(Complex z) {
		return z;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
