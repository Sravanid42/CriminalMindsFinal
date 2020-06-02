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

import com.amazonaws.samples.DisplayCriminals;

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
		textField.setBounds(12, 156, 681, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 234, 646, 378);
		getContentPane().add(scrollPane);
		
		JButton btnDisplayAll = new JButton("Display all");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setToolTipText(DisplayCriminals.main());
			}
		});
		btnDisplayAll.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnDisplayAll.setBounds(12, 195, 104, 26);
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
		btnSortByAge.setBounds(457, 198, 125, 21);
		getContentPane().add(btnSortByAge);
		
		JButton btnSortByState = new JButton("Burglars");
		btnSortByState.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnSortByState.setBounds(680, 198, 125, 21);
		getContentPane().add(btnSortByState);
		
		JButton btnLastName = new JButton("Terrorists");
		btnLastName.setFont(new Font("Rockwell", Font.PLAIN, 14));
		btnLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLastName.setBounds(228, 198, 125, 21);
		getContentPane().add(btnLastName);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Sravani\\Downloads\\tape2.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 38, 832, 105);
		getContentPane().add(lblNewLabel);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(0, 374, 88, 25);
		getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(760, 374, 72, 25);
		getContentPane().add(btnNext);
		

		
	}
}