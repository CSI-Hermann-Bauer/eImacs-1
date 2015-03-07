package com.eimacs.lab07gui;

import com.eimacs.lab07.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author IMACS Curriculum Development Group
 * @version 1.0 |today's date|
 */
public class TestingInterface implements ActionListener {
	/** Instance variables */
	private JPanel mainPanel, mySetupPanel, myRunPanel, myResultsPanel;
	private JComboBox<String> mySortChoices, myInitOrders;
	private JTextField arrSizeField, nTestsField;
	private JTextArea results;
	private final String[] SORT_ALGORITHMS = { "Choose one...", "Selection",
			"Insertion", "Merge", "Merge2" };
	private final String[] INITIAL_ORDERS = { "Choose one...", "Increasing",
			"Random", "Decreasing" };

	/**
	 * Class constructor
	 */
	public TestingInterface() {
		/* Create sub-panels of main panel */
		mySetupPanel = new JPanel(new GridLayout(4, 2, 6, 6));
		myRunPanel = new JPanel();
		myResultsPanel = new JPanel();

		/* Add widgets to sub-panels */
		addWidgets();

		/* Create main panel */
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		/* Add sub-panels and horizontal separators to main panel */
		mainPanel.add(mySetupPanel);
		mainPanel.add(new JSeparator());
		mainPanel.add(myRunPanel);
		mainPanel.add(new JSeparator());
		mainPanel.add(myResultsPanel);

		/* Create the tester window and display it */
		JFrame testerFrame = new JFrame("Sort Algorithm Tester");
		testerFrame.setContentPane(mainPanel);
		testerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testerFrame.pack();
		testerFrame.setLocationRelativeTo(null);
		testerFrame.setVisible(true);
	}

	/*
	 * Code for methods
	 */
	/**
	 * Loads all the required widgets onto the sub-panels of the testing
	 * interface
	 */
	public void addWidgets() {
		/* Labels for the setup panel */
		String[] labels = { "Sorting algorithm: ", "ArrayList size: ",
				"Initial ordering: ", "Number of tests: " };

		/* Create combo box with sorting algorithm choices */
		mySortChoices = new JComboBox(SORT_ALGORITHMS);
		mySortChoices.setSelectedIndex(0);

		/* Create combo box with initial order choices */
		myInitOrders = new JComboBox(INITIAL_ORDERS);
		myInitOrders.setSelectedIndex(0);

		/*
		 * Create label for algorithm combo box; add label and combo box to
		 * mySetupPanel; activate a listener for the combo box.
		 */
		JLabel sortChoicesLabel = new JLabel(labels[0], JLabel.TRAILING);
		mySetupPanel.add(sortChoicesLabel);
		sortChoicesLabel.setLabelFor(mySortChoices);
		mySetupPanel.add(mySortChoices);
		mySortChoices.addActionListener(this);

		/*
		 * Create label and text field to specify ArrayList size; add label and
		 * text field to mySetupPanel; activate a listener for the text field.
		 */
		JLabel arrSizeLabel = new JLabel(labels[1], JLabel.TRAILING);
		mySetupPanel.add(arrSizeLabel);
		arrSizeField = new JTextField(6);
		arrSizeLabel.setLabelFor(arrSizeField);
		mySetupPanel.add(arrSizeField);
		arrSizeField.addActionListener(this);

		/*
		 * Create label for initial order combo box; add label and combo box to
		 * mySetupPanel; activate a listener for the combo box.
		 */
		JLabel initialOrderLabel = new JLabel(labels[2], JLabel.TRAILING);
		mySetupPanel.add(initialOrderLabel);
		initialOrderLabel.setLabelFor(myInitOrders);
		mySetupPanel.add(myInitOrders);
		myInitOrders.addActionListener(this);

		/*
		 * Create label and text field to specify number of tests; add label and
		 * text field to mySetupPanel; activate a listener for the text field.
		 */

		JLabel testsLabel = new JLabel(labels[3], JLabel.TRAILING);
		mySetupPanel.add(testsLabel);
		nTestsField = new JTextField(6);
		testsLabel.setLabelFor(nTestsField);
		mySetupPanel.add(nTestsField);
		nTestsField.addActionListener(this);

		mySetupPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		/*
		 * Create button for the run panel; add it to myRunPanel; activate a
		 * listener for it.
		 */
		JButton runBtn = new JButton("Run tests");
		mySetupPanel.add(runBtn);
		runBtn.addActionListener(this);

		/*
		 * Create text area for the results panel; add it to myResultsPanel.
		 */
		results = new JTextArea(2, 20);
		mySetupPanel.add(results);
	}

	/**
	 * Reacts to the testing interface's "Run Tests" button being clicked
	 * 
	 * @param e
	 *            an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		String actionName = e.getActionCommand();

		/* Erase myResultsPanel upon each action in the interface */
		results.setText("");

		/* If "Run tests" button has been clicked, ... */
		if ("Run tests".equals(actionName)) {
			/* Read user input */
			String algoName = (String) mySortChoices.getSelectedItem();
			String arrSizeStr = arrSizeField.getText();
			int initOrder = myInitOrders.getSelectedIndex();
			String nTestsStr = nTestsField.getText();

			/* Run the tests and display the result. */
			int arrSize = Integer.parseInt(arrSizeStr);
			int nTests = Integer.parseInt(nTestsStr);

			String report = runTests(algoName, nTests, arrSize, 2 - initOrder);
			results.setText(report);
		}
	}

	private String runTests(String algoName, int nTests, int arrSize, int dir) {
		APTimer timer = new APTimer();
		ArrayList<ArrayList<Integer>> a = Lab07Runner.arrayListOfArrayLists(
				nTests, arrSize, dir);
		Sort s;
		if ("Selection".equals(algoName))
			s = new SelectionSort();
		else if ("Merge".equals(algoName))
			s = new MergeSort();
		else if ("Insertion".equals(algoName))
			s = new InsertionSort();
		else if ("Merge2".equals(algoName))
			s = new MergeSort2();
		else
			return "Choose a sorting algorithm.";

		timer.start();
		for (ArrayList<Integer> aList : a)
			s.sortList(aList);
		timer.stop();

		String report = "Total time: " + timer + "\nAverage time per sort: "
				+ (timer.interval() / (double) nTests) + " ms.";
		return report;
	}
}