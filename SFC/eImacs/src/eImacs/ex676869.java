package eImacs;

public class ex676869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ex676869();
	}
	public ex676869(){
		ex67();
		ex68();
		ex69();
	}
	public void ex67(){
		double[] d = { 1.1, 2.5, -3.1, 4.2 };

		 

		 double average = 0.0;

		 for(int i = 0; i < d.length ; i++){

		     average += d[i];

		 }

		 average /= (double)d.length;

		 System.out.println("The average is "+average);
	}
	public void ex68(){
		double[][] d = 

			  { 

			    { 1.1, 2.5, -3.1, 4.2 },

			    { 53.7, -64.04, 100.3, 23.6 },

			    { -1000.0, 3.13, 952.5, 14 }

			  };

			 double max = 0.0;

			 for(int i = 0; i < d.length; i++){

			     for(int j = 0; j < d[i].length; j++){

			         if(d[i][j] > max) max = d[i][j];

			     }

			 }

			 System.out.println(max);
	}
	public void ex69(){
		int n = 10;

		int factorial = 1;

		 

		 for(int i = n; i > 0; i--){

		     factorial *= i;

		 }
		 

		System.out.print( "The factorial of " + n );

		System.out.println( " is " + factorial );
	}
}
