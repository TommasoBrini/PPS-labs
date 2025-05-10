package tasks.adts

/*  Exercise 1: 
 *  Complete the implementation of ComplexADT trait below, so that it passes
 *  the test in ComplexTest.
 */

object Ex1ComplexNumbers:

  trait ComplexADT:
    type Complex
    def complex(re: Double, im: Double): Complex
    extension (complex: Complex)
      def re(): Double
      def im(): Double
      def sum(other: Complex): Complex
      def subtract(other: Complex): Complex
      def asString(): String

  object BasicComplexADT extends ComplexADT:

    private case class ComplexImpl(re: Double, im: Double)

    // Change assignment below: should probably define a case class and use it?
    opaque type Complex = ComplexImpl

    def complex(re: Double, im: Double): Complex = ComplexImpl(re, im)

    extension (complex: Complex)
      def re(): Double = complex.re
      def im(): Double = complex.im
      def sum(other: Complex): Complex = ComplexImpl(complex.re + other.re, complex.im + other.im)
      def subtract(other: Complex): Complex = ComplexImpl(complex.re - other.re, complex.im - other.im)
      def asString(): String = complex match
        case ComplexImpl(0, 0) => "0.0"
        case ComplexImpl(_, 0) => complex.re.toString
        case ComplexImpl(0, _) => complex.im + "i"
        case _ if complex.im < 0 => complex.re + " - " + complex.im.abs + "i"
        case _ => complex.re + " + " + complex.im + "i"
