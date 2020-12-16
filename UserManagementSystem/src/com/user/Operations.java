package com.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Operations extends JFrame{

	private JFrame frame;
	private JTextField txtUserRegistrationForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operations window = new Operations();
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
	public Operations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 701, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setVisible(true);
		JButton signUp = new JButton("Sign Up");
		signUp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		signUp.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0) {
				RegistrationForm r = new RegistrationForm();
				r.Signup();
				frame.dispose();
		}
		});
		signUp.setForeground(Color.BLUE);
		signUp.setBackground(Color.CYAN);
		signUp.setBounds(301, 205, 89, 23);
		frame.getContentPane().add(signUp);
		
		txtUserRegistrationForm = new JTextField();
		txtUserRegistrationForm.setEditable(false);
		txtUserRegistrationForm.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserRegistrationForm.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUserRegistrationForm.setForeground(Color.BLUE);
		txtUserRegistrationForm.setBackground(Color.CYAN);
		txtUserRegistrationForm.setText("  User Registration");
		txtUserRegistrationForm.setBounds(248, 30, 179, 36);
		frame.getContentPane().add(txtUserRegistrationForm);
		txtUserRegistrationForm.setColumns(10);
		
		JButton signIn = new JButton("Sign In");
		signIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Authentication a = new Authentication();
				a.Login();
				frame.dispose();
			}
		});
		signIn.setBackground(Color.CYAN);
		signIn.setForeground(Color.BLUE);
		signIn.setBounds(301, 266, 89, 23);
		frame.getContentPane().add(signIn);
		
		JLabel signUpLabel = new JLabel("Click sign up to register");
		signUpLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		signUpLabel.setBounds(273, 191, 142, 14);
		frame.getContentPane().add(signUpLabel);
		
		JLabel signInLabel = new JLabel("Already a user click sign in");
		signInLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		signInLabel.setBounds(273, 254, 153, 14);
		frame.getContentPane().add(signInLabel);
	}
}
