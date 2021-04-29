public
class Main16
{
	public static void main (String args[])
	{
	int A=1, B=-1, C=-6;
	System.out.println ("Parametry równania: \n");
	System.out.println ("A: " +A+ "B: " +B+ "C: " +C+ "\n");
	System.out.println ("Rownanie ma postac:" +A+ "x^2" +B+ "x" +C );

	if(A==0)
	{System.out.println ("To nie jest równanie kwadratowe A=O!");}
	else{
	double delta=B*B-4*A*C;
	System.out.println ("Delta = " +delta);
	if(delta<0){
	System.out.println ("Delta<0.");
	System.out.println ("To równanie nie ma rozwi¹zania w zbiorze liczb rzeczywistych");}
	else{
	double wynik;
	if(delta==0)
	{wynik=-B/2*A;
	System.out.println ("Rozwi¹zanie: x= " +wynik);}
	else{
	wynik=(-B + Math.sqrt(delta)) / 2*A;
	System.out.println ("Rozwiazanie \n x1: " +wynik);
	wynik=(- B - Math.sqrt(delta)) / 2 *A;
	System.out.println ("x2= " +wynik);}}}
	}

}