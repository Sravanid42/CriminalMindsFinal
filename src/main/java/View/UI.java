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
import javax.swing.JScrollPane;

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

import com.amazonaws.samples.*;

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


public class UI extends JFrame {
	/**
	 * 
	 */
	public JTextField txtFieldSearch;
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JScrollPane display;
	
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
		txtFieldSearch.setForeground(Color.BLACK);
		txtFieldSearch.setFont(new Font("Big Caslon", Font.PLAIN, 16));
		txtFieldSearch.setText("Sea");
		txtFieldSearch.setBounds(12, 156, 681, 29);
		getContentPane().add(txtFieldSearch);
		txtFieldSearch.setColumns(10);
		

		
		display = new JScrollPane();
		display.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		display.setBounds(100, 234, 646, 378);
		getContentPane().add(display);
		
		JTextPane txtpaneQuery = new JTextPane();
		//scrollPane.setViewportView(textPane);
		
		JButton btnDisplayAll = new JButton("Display all");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

              String returnText = DisplayCriminals.main();
              
              display.setToolTipText(returnText);
              txtpaneQuery.setText(returnText);
			  display.setViewportView(txtpaneQuery);

			}
			
			
		});
		btnDisplayAll.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnDisplayAll.setBounds(22, 195, 104, 26);
		btnDisplayAll.setBounds(161, 197, 104, 26);
		getContentPane().add(btnDisplayAll);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Rockwell", Font.PLAIN, 14));

		btnSearch.setBounds(701, 157, 104, 26);

		btnSearch.setBounds(12, 213, 104, 25);

		getContentPane().add(btnSearch);
	
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchString = txtFieldSearch.getText();
				String delims = "[,]";
				String [] searchStringArray = searchString.split(delims);
				
				String returnText = CriminalQuery.main(searchStringArray);
				
				
				display.setToolTipText(returnText);
				
				txtpaneQuery.setText(returnText);
				display.setViewportView(txtpaneQuery);
				
			}
			
		});


		btnSearch.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnSearch.setBounds(701, 157, 104, 26);
		getContentPane().add(btnSearch);

		btnSearch.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnSearch.setBounds(12, 195, 104, 26);
		getContentPane().add(btnSearch);


		
		
		btnSearch.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnSearch.setBounds(12, 195, 104, 26);
		getContentPane().add(btnSearch);
		
		JButton btnSK = new JButton("Serial Killers");
		btnSK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

              String returnText = DisplaySK.main();
              
              display.setToolTipText(returnText);
              txtpaneQuery.setText(returnText);
			  display.setViewportView(txtpaneQuery);

			}
			
			
		});
		btnSK.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSK.setBounds(496, 196, 125, 27);
		getContentPane().add(btnSK);
		
		JButton btnBurglars = new JButton("Burglars");
		btnBurglars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

              String returnText = DisplayBurglars.main();
              
              display.setToolTipText(returnText);
              txtpaneQuery.setText(returnText);
			  display.setViewportView(txtpaneQuery);

			}
			
			
		});
		btnBurglars.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnBurglars.setBounds(662, 196, 125, 27);
		getContentPane().add(btnBurglars);
		
		JButton btnTerrorists = new JButton("Terrorists");
		btnTerrorists.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnTerrorists.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String returnText = DisplayTerrorists.main();
	              
	            display.setToolTipText(returnText);
	            txtpaneQuery.setText(returnText);
				display.setViewportView(txtpaneQuery);
			}
		});
		btnTerrorists.setBounds(308, 196, 125, 27);
		getContentPane().add(btnTerrorists);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sravani\\Downloads\\tape2.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 38, 832, 105);
		getContentPane().add(lblNewLabel);
		

		
	}
}