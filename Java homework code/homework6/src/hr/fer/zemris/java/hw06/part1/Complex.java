package hr.fer.zemris.java.hw06.part1;

public class Complex {
	
	public static final Complex ZERO = new Complex(0,0);
	public static final Complex ONE = new Complex(1,0);
	public static final Complex ONE_NEG = new Complex(-1,0);
	public static final Complex IM = new Complex(0,1);
	public static final Complex IM_NEG = new Complex(0,-1);
	
	private double re;
	private double im;
	
	public Complex() {
		
	}
	
	public Complex(double re, double im) {
		re = this.re;
		im = this.im;
	}
	
	// returns module of complex number
	public double module() {
		return Math.sqrt((re*re + im*im));
	}
	
	// returns this*c
	public Complex multiply(Complex c) {
		Complex multipliedComplex = new Complex(this.re * c.re, this.im * c.im);
		return multipliedComplex;	
	}
	
	// returns this/c
	public Complex divide(Complex c) {
		Complex dividedComplex = new Complex(this.re / c.re, this.im / c.im);
		return dividedComplex;
	}
	
	// returns this+c
	public Complex add(Complex c) {
		Complex sumComplex = new Complex(this.re + c.re, this.im + c.im);
		return sumComplex;
	}
	
	// returns this-c
	public Complex sub(Complex c) {
		Complex subComplex = new Complex(this.re - c.re, this.im - c.im);
		return subComplex;
	}
	
	// returns -this
	public Complex negate() {
		Complex negatedComplex = new Complex(0.0 - this.re, 0.0 - this.im);
		return negatedComplex;
	}
	
	@Override
	public String toString() {
		String complexString = Double.toString(this.re) + " + (" + Double.toString(this.im) + ")i";
		return complexString;
	}
}
