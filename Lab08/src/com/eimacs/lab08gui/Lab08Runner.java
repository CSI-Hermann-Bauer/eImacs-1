package com.eimacs.lab08gui;

import com.eimacs.elevens.*;
//import com.eimacs.lab08.*;

/**
 * 
 * @author IMACS Curriculum Developer Group
 * @version 2.0 January 14, 2015
 */

public class Lab08Runner
{
    public static void main( String[] args )
    {
        /* Play the game */
        Board board = new ElevensBoard();
        CardGameGUI gui = new CardGameGUI(board);
        gui.displayGame();
    }
}
