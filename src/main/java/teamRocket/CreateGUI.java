package teamRocket;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

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
		searchButton.addActionListener(ae->{ searchButton_Click();});

		JButton fileManagerButton = new JButton("File Manager");
		fileManagerButton.addActionListener(this);
		
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
	// search button click
	//Brittany Weaver - A map was created below to represent the pseudo files to search through.
	public void searchButton_Click(){
		System.out.println("Create GUI searchButton_Click");
		HashMap<String, ArrayList<Integer>> mapFile = new HashMap<>();
		ArrayList<Integer> listNum = new ArrayList<>();
		ArrayList<ArrayList<Integer>> listFound = new ArrayList<>();
		listNum.add(2);
		mapFile.put("a", listNum);
		mapFile.put("banana", listNum);
		listNum.clear();
		listNum.add(0);
		listNum.add(1);
		listNum.add(2);
		mapFile.put("is", listNum);
		mapFile.put("it", listNum);
		listNum.clear();
		listNum.add(0);
		listNum.add(1);
		mapFile.put("what", listNum);

		String getTxt = searchField.getText();
		for(String word:mapFile.keySet()){
			if(getTxt.equals(word)){
				listFound.add(mapFile.get(word));

			}
		}
		System.out.println("getTxt" + getTxt);
		System.out.println("mapFile" + mapFile.toString());
		System.out.println("listFound" + listFound);
	}
	public void actionPerformed(ActionEvent e) {
		new FileManager();
	}
}


