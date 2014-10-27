package eImacs;

/**
 * Write a description of class ei2dArrtst here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ei2dArrtst
{
    // instance variables - replace the example below with your own
    public static void main(String [] args){
        /*int h[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(h[ h.length - 1 ][ h[ 0 ].length - 1 ]);
        double[] c = { 1.1, 17.9, 32.1, 96.8, 101.5 };
        double[] d = c;
        c[ 2 ] = d[ 2 ] + 1.0;
        System.out.println( d[ 2 ] );  
            int[][] a = 
        { 
          { 1, 2, 3, 4 },
          { 5, 6, 7, 8 },
          { 9, 10, 11, 12 },
          { 13, 14, 15, 16 }
        }; 
        System.out.println(a[3][2]);*/
        int a [] = {0,1};
        a[ 0 ] = a[ 0 ] - a[ 1 ];
        a[ 1 ] = a[ 0 ] + a[ 1 ];
        a[ 0 ] = a[ 1 ] - a[ 0 ];
        System.out.println(a[0]+","+a[1]);
    }
}
