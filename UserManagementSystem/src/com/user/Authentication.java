package com.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Authentication {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textUserName;
	private JTextField Title;

	/**
	 * Launch the application.
	 */
	public static void Login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentication window = new Authentication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Authentication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton logIn = new JButton("Log In");
		logIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Username=textUserName.getText();
				String password = passwordField.getText();		    								
				try
		        {		   
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "prakash");
		            PreparedStatement ps = con.prepareStatement("select * from authentication where UserName=? and Password=?");
		            ps.setString(1, textUserName.getText());
		            ps.setString(2, passwordField.getText());
		            ResultSet rs = ps.executeQuery();
		            if (rs.next())
		            {
		            	frame.setVisible(true);
		            
		                JOptionPane.showMessageDialog(logIn, "Login sucessful :)");
		                new Operations();
		                frame.dispose();
		            } 
		            else {
		            	JOptionPane.showMessageDialog(logIn, "Login failed :(");
		            }
		           
		        }
		        catch (Exception ex)
		        {
		            System.out.println(ex);
		        }
		    }
			
		});
		logIn.setForeground(Color.BLUE);
		logIn.setBackground(Color.CYAN);
		logIn.setBounds(316, 213, 89, 23);
		frame.getContentPane().add(logIn);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordLabel.setBounds(103, 159, 103, 14);
		frame.getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(243, 156, 112, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel uNameLabel = new JLabel("User Name");
		uNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		uNameLabel.setBounds(103, 97, 103, 14);
		frame.getContentPane().add(uNameLabel);
		
		textUserName = new JTextField();
		textUserName.setBounds(243, 94, 112, 20);
		frame.getContentPane().add(textUserName);
		textUserName.setColumns(10);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Operations obj = new Operations();
                frame.setVisible(false);
				obj.setVisible(true);
				obj.dispose();
			}
		});
		back.setForeground(Color.BLUE);
		back.setBackground(Color.CYAN);
		back.setBounds(43, 213, 89, 23);
		frame.getContentPane().add(back);
		
		Title = new JTextField();
		Title.setFont(new Font("Tahoma", Font.BOLD, 12));
		Title.setEditable(false);
		Title.setText("    Sign In");
		Title.setHorizontalAlignment(SwingConstants.LEFT);
		Title.setForeground(Color.BLUE);
		Title.setBackground(Color.CYAN);
		Title.setBounds(172, 11, 86, 20);
		frame.getContentPane().add(Title);
		Title.setColumns(10);
		
		JButton Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrationForm r = new RegistrationForm();
				r.Signup();
				frame.dispose();
			}
		});
		Register.setForeground(Color.BLUE);
		Register.setBackground(Color.CYAN);
		Register.setBounds(169, 213, 89, 23);
		frame.getContentPane().add(Register);
	}
}
