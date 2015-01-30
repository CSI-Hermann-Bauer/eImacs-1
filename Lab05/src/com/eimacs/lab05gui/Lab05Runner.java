package com.eimacs.lab05gui;

import com.eimacs.digest.UserInfoDialog;
import com.eimacs.lab05.*;

/**
 *
 * @author |Your name|
 * @version 1.0 |Today's date|
 */
public class Lab05Runner
{
    /**
     * The main method
     * 
     * @param args the command line arguments
     */
    public static void main( String[] args )
    {
        /* 
         * When instructed to do so, uncomment the following three
         * statements and comment out the rest of the main method
         * before running the project.
        */
        //UserInfoDialog dlg = new UserInfoDialog( null, true );
        //dlg.setLocationRelativeTo( null );
        //dlg.setVisible( true );

        TurtleProgram tp = new TurtleProgram();
        tp.addAction( new TurnRight( 120 ) );
        tp.addAction( new MoveForward( 100 ) );
        tp.addAction( new MoveBack( 50 ) );
        tp.addAction( new TurnLeft( 90 ) );
        System.out.println( tp );
    }
    
}
