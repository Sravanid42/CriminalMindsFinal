package View;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;



import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.samples.DisplayCriminals;
<<<<<<< HEAD
import com.amazonaws.samples.*;
=======
import com.amazonaws.samples.Search;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import Util.ConsoleIO;

import javax.swing.ScrollPaneConstants;
>>>>>>> branch 'master' of https://github.com/Sravanid42/CriminalMindsFinal.git

public class UI extends JFrame {
	/**
	 * 
	 */
	public JTextField txtFieldSearch;
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public UI() {
		getContentPane().setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 700);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel lblCriminalDatabase = new JLabel("Criminal Database");
		lblCriminalDatabase.setForeground(Color.LIGHT_GRAY);
		lblCriminalDatabase.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCriminalDatabase.setBounds(329, 0, 164, 37);
		getContentPane().add(lblCriminalDatabase);
		
		
		JTextField txtFieldSearch = new JTextField();
		txtFieldSearch.setBounds(12, 156, 681, 29);
		getContentPane().add(txtFieldSearch);
		txtFieldSearch.setColumns(10);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(100, 234, 646, 378);
		getContentPane().add(scrollPane);
		
		JButton btnDisplayAll = new JButton("Display all");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setToolTipText(DisplayCriminals.main());
			}
		});
		btnDisplayAll.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnDisplayAll.setBounds(161, 197, 104, 26);
		getContentPane().add(btnDisplayAll);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSearch.setBounds(12, 213, 104, 25);
		getContentPane().add(btnSearch);
	
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchString = textField.getText();
				String delims = "[,]";
				String [] searchStringArray = searchString.split(delims);
				
				scrollPane.setToolTipText(CriminalQuery.main(searchStringArray));
				
			}
			
		});
		
		
		btnSearch.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnSearch.setBounds(12, 195, 104, 26);
		getContentPane().add(btnSearch);
		
		JButton btnSortByAge = new JButton("Serial Killers");
		btnSortByAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSortByAge.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSortByAge.setBounds(496, 196, 125, 27);
		getContentPane().add(btnSortByAge);
		
		JButton btnSortByState = new JButton("Burglars");
		btnSortByState.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSortByState.setBounds(662, 196, 125, 27);
		getContentPane().add(btnSortByState);
		
		JButton btnLastName = new JButton("Terrorists");
		btnLastName.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLastName.setBounds(308, 196, 125, 27);
		getContentPane().add(btnLastName);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sravani\\Downloads\\tape2.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 38, 832, 105);
		getContentPane().add(lblNewLabel);
		

		
	}
}