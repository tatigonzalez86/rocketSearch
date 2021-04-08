package teamRocket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class FileManager implements ActionListener{
	private JFrame frame;
	private JPanel contentpanel;
	private JPanel labelpanel;
	private JPanel buttonpanel;
	private JTable table;
	private JLabel label;
	private JButton addFileBtn;
	private JButton removeFile;


	
	public FileManager() {
		frame = new JFrame("File Manager");
		contentpanel = new JPanel();
		contentpanel.setLayout(new BorderLayout());
		
		labelpanel = new JPanel();
		buttonpanel = new JPanel();
		
		table = new JTable(20, 2);
		table.setValueAt("File Path", 0, 0);
		table.setValueAt("Last Editted", 0, 1);

		
		addFileBtn = new JButton("Add Files...");
		addFileBtn.setActionCommand( "ADD" );
		addFileBtn.setToolTipText( "Select a file to add to the index" );
		addFileBtn.addActionListener(ae->{addFile();});
		addFileBtn.setMnemonic(KeyEvent.VK_A);



		removeFile = new JButton("Remove Files");
		removeFile.setActionCommand("Remove");
		removeFile.addActionListener(this);
		
		label = new JLabel("Here there be files");
		label.setFont(new Font("Times New Roman", Font.BOLD + Font.ITALIC, 24));
		
		frame.setSize(600,800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setContentPane(contentpanel);
		frame.setResizable(false);
		labelpanel.add(label);
		
		buttonpanel.add(addFileBtn);
		buttonpanel.add(removeFile);
		
		
		
		contentpanel.add(labelpanel, BorderLayout.PAGE_START);
		contentpanel.add(buttonpanel, BorderLayout.PAGE_END);
		contentpanel.add(table, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	// Unimplemented buttons to add and remove file persistence.
	

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "Remove") {
			// remove file method
		}
	}
	//this is a method that gives you the option to add a file.


	void addFile(){

			//display a jfile chooser
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName() );
		} catch (Exception e) {} // Too bad; use Java's default LaF

		SwingUtilities.invokeLater(()-> {
			//creates file chooser
				JFileChooser fileChooser = new JFileChooser(".");
				//opens file dialog
			//status indicates if user hits ok or cancel

			int status = fileChooser.showOpenDialog(null);
				File selectedFile;
				//if they clicked ok the status is approved if not it is something else. returning to file method.
				if (status == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
				} else
					return;

				addFileToList(selectedFile);


				// open file reading it one line at a time and updating index.
			});

		}


		//this method takes the selected file displaying it to the gui and adding it to the list.
		void addFileToList(File selectedFile){

			//add file  to the table

			try {
				table.setValueAt(selectedFile.getCanonicalFile(), 1,0);
				table.setValueAt(selectedFile.lastModified(),1,1);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
}
