package teamRocket;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
		removeFile.setToolTipText( "Delete selected rows from table" );
		removeFile.addActionListener(this);
		removeFile.setMnemonic(KeyEvent.VK_R);
		
		
		
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
			table.setValueAt("", table.getSelectedRow(), 0);
			table.setValueAt("", table.getSelectedRow(), 1);
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
				readFile(selectedFile);
				
				ObjectMapper mapper = new ObjectMapper();
				String json;
				// creates the json object using the hashmap index, outputs the json to index.txt in the user documents folder
				try {
					json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(index);
					Path home = Paths.get(System.getProperty("user.home") + File.separator + "Documents");
					FileWriter output = new FileWriter(home + "/index.txt");
					output.write(json);
					output.close();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
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
		
		Map<String, Integer> index = new HashMap<>();
		
		void readFile(File selectedFile) {
			// reads the file and counts the number of times each word appears in the text and enters values into a map.
			// keys are words and values are how many times they appear.
			try {
				File input = selectedFile;
				Scanner myReader = new Scanner(input);
				while (myReader.hasNextLine()) {
					String data = myReader.nextLine();
					data.trim();
					String[] words = data.split(" ");
					int i = 0;
					String x;
					int count;
					for (i = 0; i < words.length; i ++) {
						x = words[i];
						if (index.containsKey(x)) {
							count = index.get(x);
							index.put(x, count + 1);
						}
						else {
							index.put(x, 1);
						}
					}
					System.out.println(data);
				}
				myReader.close();
				index.remove("");
			} catch (FileNotFoundException e) {
				System.out.println("File not Found");
			}
		}
	 this.searchBtn.addActionListener(new ActionListener() {
            public void performance(final ActionEvent evnt) {
                switch (Main.this.selectedSearch) {
				
                    case AND: {
                        IndexUtils.doAndSearch(Main.this.searchTerms.getText(), Main.this.results);
                        break;
			    
                    }
                    case OR: {
                        IndexUtils.doOrSearch(Main.this.searchTerms.getText(), Main.this.results);
                        break;
			    
                    }
                    case PHRASE: {
                        IndexUtils.doPhraseSearch(Main.this.searchTerms.getText(), Main.this.results);
                        break;
			    
                    }
/*
 public long addFile(String fileName) {
        long document = Main.ID;
        ++Main.ID;
        file = new File(Name);
        FileItem final = new FileItem(document, Name);}*/
}
