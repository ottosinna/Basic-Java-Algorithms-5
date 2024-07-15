public class Rational{
	int num;
	int den;
	Rational(int m, int n){
		int g = Utility.findGCD(m,n);
		num = m/g; den = n/g;
	}
	Rational(){
		num = 0; den = 1;
	}
	Rational(int n){
		num = n; den = 1;
	}
	Rational(double d){
		int[] r = Utility.doubleToRational(d);
		int g = Utility.findGCD(r[0],r[1]);
		num = r[0]/g; den = r[1]/g;
	}
	Rational(String s){
		s = s.replaceAll("/\\s+", "/"); //take away space after slash
		s = s.replaceAll("\\s+/", "/");// take away space before slash
		int slash = s.indexOf("/"); //index to find slash
		int space = s.indexOf(" "); //index to find first space for mixed fraction
		String[] sA = s.split("\\s+|/"); // split string by space & slash to 3 parts	
		if (s.contains(".")){            //Code for strings with double
			double d =Double.parseDouble(s);
			int[] r = Utility.doubleToRational(d);
			int g = Utility.findGCD(r[0],r[1]);
			num = r[0]/g; den = r[1]/g;
        } else if (slash == -1 && space == -1) { // code for whole num
            num = Integer.parseInt(sA[0]);
            den = 1;
        } else if (slash > -1 && space == -1) { // code for fraction
            num = Integer.parseInt(sA[0]);
            den = Integer.parseInt(sA[1]);
        } else if (slash > -1 && space > -1) { // whole number with a fraction
            int wholeNum = Integer.parseInt(sA[0]); //renaming wholeNum as sA[0]
            int num2 = Integer.parseInt(sA[1]); //renaming num to num2 for this else if,
            int den2 = Integer.parseInt(sA[2]); //and sA[0] to sA[1], and renaming
            num = wholeNum * den2 + num2;       //den to den2 for this else if
            den = den2;                         //and sA[1] to sA[2].
		}
	}
	public String toString(){
		if (den == 0) {      //fix to error that fractions cant divide by zero
        return "undefined";
		}	
		String s;
		int wholeNum = num / den;
		int rem = num % den; //remainder from division
		if (den == 1) s = "" + num; //whole number
		else if (wholeNum < 0 && rem < 0) s = wholeNum + " " + rem*-1+ "/" + den;
		else if (wholeNum == 0) s = rem + "/" + den; //fraction
		else if (rem == 0) s = "" + wholeNum; //whole number
		else s = wholeNum + " " + rem + "/" + den; //whole number with fraction
		return s;
	}
}
