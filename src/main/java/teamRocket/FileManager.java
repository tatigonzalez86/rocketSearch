package teamRocket;

import java.awt.*;

import javax.swing.*;

public class FileManager {
	private JFrame frame;
	private JPanel contentpanel;
	private JPanel labelpanel;
	private JPanel buttonpanel;
	private JLabel label;
	private JButton addFile;
	private JButton removeFile;
	
	public FileManager() {
		frame = new JFrame("File Manager");
		contentpanel = new JPanel();
		contentpanel.setLayout(new BorderLayout());
		
		labelpanel = new JPanel();
		buttonpanel = new JPanel();
		
		addFile = new JButton("Add Files");
		removeFile = new JButton("Remove Files");
		
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
		frame.setVisible(true);
	}
	
}
