package com.company;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CreateGUI implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JPanel btnPanel;
    private JPanel srchPanel;
    private ButtonGroup BG;
    private JTextField searchField;
    public CreateGUI() {

        // Create initial frames and panels to hold search bar and search settings buttons.
        frame = new JFrame();

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));

        srchPanel = new JPanel();
        srchPanel.setLayout(new BoxLayout(srchPanel, BoxLayout.X_AXIS));


        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Rocket Search");


        JButton searchButton = new JButton("Search");

        JButton fileManagerButton = new JButton("File Manager");
        fileManagerButton.addActionListener(this);
        searchButton.addActionListener(this);
        searchField = new JTextField("Enter search here");

        String andSearch = "Must match ALL terms";
        String exactSearch = "Search for EXACT PHRASE";
        String anySearch = "Match ANY of the search Terms ";

        JRadioButton exactButton = new JRadioButton(exactSearch);
        JRadioButton andButton = new JRadioButton(andSearch);
        JRadioButton anyButton = new JRadioButton(anySearch);

        // Button Group makes only one search setting selectable at a time.
        BG = new ButtonGroup();
        BG.add(exactButton);
        BG.add(anyButton);
        BG.add(andButton);

        btnPanel.add(exactButton);
        btnPanel.add(andButton);
        btnPanel.add(anyButton);


        srchPanel.add(searchButton);
        srchPanel.add(fileManagerButton);
        panel.add(searchField, BorderLayout.PAGE_START);
        panel.add(btnPanel, BorderLayout.LINE_START);
        panel.add(srchPanel, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

       System.out.println("GUI Action " + e.getActionCommand());
       if (e.getActionCommand().equals("Search")) {
           System.out.println("Search Click");
           String input = this.searchField.getText();
           System.out.println("User Input " + input);
           System.out.println("Word\tSet of (File, Position) Pairs");
           System.out.println("a\t\t{(2, 2)}");
           System.out.println("banana\t{(2, 3)}");
           System.out.println("is\t\t{(2, 3), (0, 1), (0, 2)}");
       }
        else if (e.getActionCommand().equals("File Manager")) {
           System.out.println("File Manager Click");
            new FileManager();

        }

    }




}


