public class Complex{
	Rational real;
	Rational imag;
	int num, den;
Complex(Rational a) {
	real = a;
	imag = new Rational(0);
	}
Complex(Rational a, Rational b){
	real = a;
	imag = b;
	}
Complex(double d){
	int[] r = Utility.doubleToRational(d);
	int g = Utility.findGCD(r[0],r[1]);
	num = r[0]/g; den = r[1]/g;
	}
Complex(String s) {
	s = s.replaceAll("\\s+", "");
	s = s.replaceAll("\\+", " +");
	s = s.replaceAll("-", "  -");
	s = s.trim();
    String[] parts = s.split("\\s+");
  	if (parts.length == 1){
	String First = parts[0];
		if (First.contains("i")){
			First = First.replace("i","");
			real = new Rational(0);
			imag = new Rational(First);
		}else{
			real = new Rational(parts[0]);
			imag = new Rational(0);
		}
		}else{
			String r = parts[0];
			String im = parts[1].replaceAll("i", "");
			real = new Rational(r);
			imag = new Rational(im);
		}			
}
public String toString() {
        String s;
        if (imag.num < 0) {
            if (real.num == 0) {
                s = "0 " + imag + "i";
            } else {
                s = real + " " + imag + "i";
            }
        } else if (imag.num == 0) {
            s = "" + real;
        } else {
            s = real + " + " + imag + "i";
        }
        return s;	
	}
}