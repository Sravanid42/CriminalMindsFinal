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
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;



import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class UI extends JFrame {
	/**
	 * 
	 */
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
		
		textField = new JTextField();
		textField.setBounds(128, 156, 565, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane display = new JTextPane();
		display.setBounds(12, 289, 793, 329);
		getContentPane().add(display);
		
		JButton btnDisplayAll = new JButton("Display all");
		btnDisplayAll.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnDisplayAll.setBounds(12, 156, 104, 26);
		getContentPane().add(btnDisplayAll);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSearch.setBounds(705, 156, 104, 26);
		getContentPane().add(btnSearch);
		
		JButton btnSortByAge = new JButton("Serial Killers");
		btnSortByAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSortByAge.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSortByAge.setBounds(366, 198, 125, 21);
		getContentPane().add(btnSortByAge);
		
		JButton btnSortByState = new JButton("Burglars");
		btnSortByState.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSortByState.setBounds(525, 198, 125, 21);
		getContentPane().add(btnSortByState);
		
		JButton btnLastName = new JButton("Terrorists");
		btnLastName.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLastName.setBounds(12, 198, 125, 21);
		getContentPane().add(btnLastName);
		
		JButton btnSortByDate = new JButton("Sort by Date");
		btnSortByDate.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSortByDate.setBounds(680, 198, 125, 21);
		getContentPane().add(btnSortByDate);
		
		JButton btnFirstName = new JButton("Murderers");
		btnFirstName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFirstName.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnFirstName.setBounds(189, 198, 125, 21);
		getContentPane().add(btnFirstName);

		JButton btnCharacteristics = new JButton("Characteristics");
		btnCharacteristics.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnCharacteristics.setBounds(12, 241, 138, 21);
		btnCharacteristics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Characteristics frame = new Characteristics();
				frame.setVisible(true);
			}
		});
		getContentPane().add(btnCharacteristics);
		
		JButton btnShowGraph = new JButton("Graphs");
		btnShowGraph.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnShowGraph.setBounds(667, 241, 138, 21);
		btnShowGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphs frame = new Graphs();
				frame.setVisible(true);
			}
		});
		getContentPane().add(btnShowGraph);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sravani\\Downloads\\tape2.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 38, 832, 105);
		getContentPane().add(lblNewLabel);
		
	}
}