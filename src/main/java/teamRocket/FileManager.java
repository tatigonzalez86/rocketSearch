package teamRocket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FileManager implements ActionListener{
	private JFrame frame;
	private JPanel contentpanel;
	private JPanel labelpanel;
	private JPanel buttonpanel;
	private JTable table;
	private JLabel label;
	private JButton addFile;
	private JButton removeFile;
	
	private enum Actions{
		ADD,
		REMOVE
	}
	
	public FileManager() {
		frame = new JFrame("File Manager");
		contentpanel = new JPanel();
		contentpanel.setLayout(new BorderLayout());
		
		labelpanel = new JPanel();
		buttonpanel = new JPanel();
		
		table = new JTable(20, 2);
		table.setValueAt("File Path", 0, 0);
		table.setValueAt("Last Editted", 0, 1);
		
		addFile = new JButton("Add Files");
		addFile.setActionCommand(Actions.ADD.name());
		addFile.addActionListener(this);
		
		removeFile = new JButton("Remove Files");
		removeFile.setActionCommand(Actions.REMOVE.name());
		removeFile.addActionListener(this);
		
		label = new JLabel("Here there be files");
		label.setFont(new Font("Times New Roman", Font.BOLD + Font.ITALIC, 24));
		
		frame.setSize(600,800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setContentPane(contentpanel);
		frame.setResizable(false);
		labelpanel.add(label);
		
		buttonpanel.add(addFile);
		buttonpanel.add(removeFile);
		
		
		
		contentpanel.add(labelpanel, BorderLayout.PAGE_START);
		contentpanel.add(buttonpanel, BorderLayout.PAGE_END);
		contentpanel.add(table, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	// Unimplemented buttons to add and remove file persistence.
	
	/*
	public void actionPerformed(ActionEvent e) {
		if (evt.getActionCommand() == Actions.ADD.name()) {
			// Add file method
		}
		if (evt.getActionCommand() == Actions.REMOVE.name()) {
			// remove file method
		}
	}
	*/
	
}
