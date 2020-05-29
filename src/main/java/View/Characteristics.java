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
//
public class Characteristics extends JFrame {
	private JTextField textField;
	public Characteristics() {
		setBounds(100, 100, 450, 550);
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(153, 17, 231, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCharacteristic = new JLabel("Characteristic:");
		lblCharacteristic.setForeground(Color.LIGHT_GRAY);
		lblCharacteristic.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCharacteristic.setBounds(12, 21, 129, 26);
		getContentPane().add(lblCharacteristic);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 60, 383, 188);
		getContentPane().add(panel);
	}
}
