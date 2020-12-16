package com.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

public class Signin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel Label1;
	private JButton btnNewButton_1;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	

	/**
	 * Launch the application.
	 */
	public static void Screen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signin frame = new Signin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Signin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(77, 67, 61, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(144, 64, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(77, 111, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("SUBMIT");
		
		btnNewButton.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Label1.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Label1.setVisible(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=textField.getText();
				String password = passwordField.getText();
				
		    
				
				
				try

		        {

		   

		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3333/rform", "root", "password");

		            PreparedStatement ps = con.prepareStatement("select * from logins where username=? and password=?");

		            ps.setString(1, textField.getText());

		            ps.setString(2, passwordField.getText());

		            ResultSet rs = ps.executeQuery();

		            if (rs.next())

		            {

		                contentPane.setVisible(true);

		                contentPane.setSize(600, 600);

		                contentPane.getRootPane().setLayout(null);
		                Label1.setForeground(Color.GREEN);
		                Label1.setText("Provided username and password matched..Successfully loggedin");

		                
		 

		            } else

		            {
		            	Label1.setForeground(Color.RED);
		                Label1.setText("Incorrect username or password!..Try Again with correct detail");

		                   

		            }

		        }

		        catch (Exception ex)

		        {

		            System.out.println(ex);

		        }

		    }

			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBackground(new Color(51, 153, 255));
		btnNewButton.setBounds(48, 159, 99, 23);
		contentPane.add(btnNewButton);
		
		Label1 = new JLabel("");
		Label1.setForeground(Color.RED);
		Label1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Label1.setBounds(10, 227, 414, 23);
		contentPane.add(Label1);
		
		btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Form_button obj1 = new Form_button();
		//		obj1.setVisible(true);
				contentPane.setVisible(false);
				
				
				
				
				check();
				
			}
			
		});
		
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(302, 159, 89, 23);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 108, 139, 20);
		contentPane.add(passwordField);
		
		
		JLabel lblNewLabel_2 = new JLabel("New user sign in here -->");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(27, 193, 153, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Click here");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				project obj= new project();
	//			obj.NewScreen();
				
				
				
			}
		});
		btnNewButton_2.setBounds(165, 189, 89, 23);
		contentPane.add(btnNewButton_2);
	
		
	}
	public void check() {
		this.dispose();
	}
	
	
	
	
}
