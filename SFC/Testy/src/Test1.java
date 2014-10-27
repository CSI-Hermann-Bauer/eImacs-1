
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String s = "SECRET";
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    int i = 0;
	    while ( i < s.length() )
	    {
	      System.out.print( alphabet.indexOf( s.substring( i, i+1 ) ) );
	      System.out.print( " " );
	      i++;
	    } 
	}

}
