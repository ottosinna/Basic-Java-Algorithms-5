public class Utility{
	static int[] doubleToRational(double d){
		String s = ""+d;
		int iP = s.indexOf('.');
		int length = s.length();
		int den = 1;
		for (int i = iP+1 ; i< length; i++){
			d=d*10;
			den = den * 10;}
		int num = (int)d;
		return new int[] {num,den};
	}
	static int[] doubleToRational(String sd){
		double d = Double.parseDouble(sd);
		int[] pair = doubleToRational(d);
		return pair;
	}
	public static int findGCD(int m, int n){
	if (m < 0) {
		m = m * -1;}
	while(n != m){
		if(n > m){
			n = n-m;
		}
		else {
			m = m-n;
			}
		}
		return n;
	}	
}
// End