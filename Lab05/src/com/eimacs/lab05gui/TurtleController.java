package com.eimacs.lab05gui;

import com.eimacs.lab05.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author IMACS Curriculum Development Group
 * @version 1.0 March 11, 2014
 */
public class TurtleController extends JPanel implements ActionListener
{
    /** This TurtleController's program display area */
    private JTextArea myProgramDisplay;
    /** This TurtleController's program */
    private TurtleProgram myTurtleProgram;
    
    /**
     * Class constructor
     */
    public TurtleController()
    {
        setLayout( new FlowLayout() );
        setBorder( BorderFactory.createRaisedBevelBorder() );
        setBackground( Color.gray );
        setPreferredSize( new Dimension( 180, 350 ) );
        
        initialize();
    }
    
    /**
     * Gets this TurtleController's program
     * 
     * @return this TurtleController's program 
     */
    public TurtleProgram getTurtleProgram()
    {
        return myTurtleProgram;
    }
    
    /**
     * Overrides ActionListener's actionPerformed method
     * 
     * @param e  the event provoking an action to be performed
     */
    public void actionPerformed( ActionEvent e )
    {
        String actionName = e.getActionCommand();
        JOptionPane.showMessageDialog( this, actionName );
    }
    
    /**
     * The class initializer
     */
    private void initialize()
    {
        myTurtleProgram = new TurtleProgram();
        
        // add action buttons
        String[] buttons = { "Forward", "Back", "Left", "Right" };
        for ( String bName : buttons )
            addButton( bName );
        
        // add text area for displaying the program
        myProgramDisplay = new JTextArea( 12, 10 );
        myProgramDisplay.setEditable( false );
        JScrollPane areaScrollPane = new JScrollPane( myProgramDisplay );
        areaScrollPane.setVerticalScrollBarPolicy( 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        add( areaScrollPane );
        
        // add control buttons
        addButton( "Execute" );
        addButton( "Reset" );
    }
    
    /**
     * Adds a button to this TurtleController
     * 
     * @param buttonName  the name (and action command) of the button
     */
    public void addButton( String buttonName )
    {
        JButton newButton = new JButton( buttonName );
        newButton.setActionCommand( buttonName );
        newButton.addActionListener( this );
        add( newButton );
    }
}
