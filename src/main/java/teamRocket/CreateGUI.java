package teamRocket;

import java.awt.BorderLayout;
import javax.swing.*;

public class CreateGUI {
	private JFrame frame;
	private JPanel panel;
	private JPanel btnPanel;
	
	public CreateGUI() {
		
		frame = new JFrame();
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		btnPanel = new JPanel();
		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
		
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Rocket Search");
		
		
		
		
		
		JButton searchButton = new JButton("Search");
		
		JButton fileManagerButton = new JButton("File Manager");
		
		JTextField searchField = new JTextField("Enter search here");
		
		String andSearch = "Must match ALL terms";
		String exactSearch = "Search for EXACT PHRASE";
		String anySearch = "Match ANY of the search Terms ";
		
		JRadioButton exactButton = new JRadioButton(exactSearch);
		JRadioButton andButton = new JRadioButton(andSearch);
		JRadioButton anyButton = new JRadioButton(anySearch);
		
		btnPanel.add(exactButton);
		btnPanel.add(andButton);
		btnPanel.add(anyButton);
		
		panel.add(fileManagerButton, BorderLayout.LINE_END);
		panel.add(searchField, BorderLayout.PAGE_START);
		panel.add(searchButton, BorderLayout.CENTER);
		panel.add(btnPanel, BorderLayout.LINE_START);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
}


