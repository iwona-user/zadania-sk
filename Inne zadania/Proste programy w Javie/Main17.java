public
class Main17
{
	public static void main (String args[])
	{
	int A=1, B=-1, C=-6;
	System.out.println ("Parametry r�wnania:\n");
	System.out.println ("A=" +A+ "B=" +B+ "C=" +C+ "\n");
	System.out.println ("R�wnanie ma posta�: " +A+ "x^2" +B+ "x" +C +"=0"+"\n");
	if(A==0){
System.out.println ("To nie jest r�wnanie kwadratowe: A=0!");
}
else{
double delta=B*B-4*A*C;
double wynik;
if (delta<0){
System.out.println ("Delta<0");
System.out.println ("To r�wnanie nie ma rozwi�za� w zbiorze liczb rzeczywistych");}
else if(delta==0){
wynik=-B/2*A;
System.out.println ("R�wnanie ma jedno rozwi�zanie: x=" +wynik);}
else{
wynik=(-B+Math.sqrt(delta))/2*A;
System.out.println ("R�wnanie ma dwa miejsca zerowe: \n");
System.out.println ("x1 = "+wynik);
wynik= (-B-Math.sqrt(delta))/2*A;
System.out.println ("x2 =" +wynik);}
	}
}
}