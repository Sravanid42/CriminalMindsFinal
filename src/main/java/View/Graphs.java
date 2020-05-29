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
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;
//
public class Graphs extends JFrame {
	public Graphs() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 27));
		setBounds(100, 100, 450, 550);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel lblGraphs = new JLabel("Graphs");
		lblGraphs.setForeground(Color.WHITE);
		lblGraphs.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraphs.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblGraphs.setBounds(149, 13, 125, 30);
		getContentPane().add(lblGraphs);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(117, 54, 56, 16);
		getContentPane().add(lblNewLabel);
	}
}
