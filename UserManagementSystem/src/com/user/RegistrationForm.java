package com.user;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.SystemColor;

public class RegistrationForm implements FocusListener {
	
  
	private JFrame frame;
	private JTextField textFirstName;
	private JTextField textMiddleName;
	private JTextField textLastName;
	private JTextField textUserName;
	private JTextField textNumber;
	private JTextField textEmail;
	private JTextField textCity;
	private JTextField textPinCode;
	private JTextField txtUserRegistrationForm;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JComboBox comboBoxGender;
	private JComboBox comboBoxState;
	private JLabel fNameLabel;
	private JLabel lNameLabel;
	private JLabel uNameLabel;
	private JLabel passwordLabel;
	private JLabel cpasswordLabel;
	private JLabel emailLabel;
	private JLabel cityLabel;
	private JLabel genderLabel;
	private JLabel mNameLabel;
	private JLabel mNumberLabel;
	private JLabel pCodeLabel;
	private JLabel stateLabel;
	private JButton Register;
	

	/**
	 * Launch the application.
	 */
	public static void Signup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm window = new RegistrationForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean enable() {
		if (textFirstName.getText().equals(null)&&
				textMiddleName.getText().equals(null)&&
				textLastName.getText().equals(null)&&
				textUserName.getText().equals(null)&&
				textNumber.getText().equals(null)&&
				textEmail.getText().equals(null)&&
				textCity.getText().equals(null)&&
				textPinCode.getText().equals(null)&&
				passwordField.getText().equals(null)&&
				passwordField_1.getText().equals(null)&&
				comboBoxState.getSelectedItem().toString().equals("--Select--")&&
				comboBoxGender.getSelectedItem().toString().equals("--Select--")) {
			return(false);
		}
		return(true);
	}
	public static boolean check() {
		return true;
	}
	/**
	 * Create the application.
	 */
	public RegistrationForm() {
		initialize();
	}

	/**
	 * Initializing the contents of the frame.
	 * 
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 870, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel firstName = new JLabel("First Name*");
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		firstName.setBounds(85, 64, 70, 14);
		frame.getContentPane().add(firstName);
		
		textFirstName = new JTextField();
		textFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFirstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				fNameLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				fNameLabel.setVisible(false);
			}
		});
		textFirstName.setBounds(246, 61, 86, 20);
		textFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
					fNameLabel.setText("Only charecters allowed");
					fNameLabel.setForeground(Color.red);
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				else if(textFirstName.getText().length()>=20) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
					fNameLabel.setText("Length exceeded");
					fNameLabel.setForeground(Color.red);
				 }
				else {
					fNameLabel.setText("VALID");
					fNameLabel.setForeground(Color.green);
				}
			}
		});
		textFirstName.setBackground(Color.WHITE);
		frame.getContentPane().add(textFirstName);
		textFirstName.setColumns(10);
		
		JLabel middleName = new JLabel("Middle Name");
		middleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		middleName.setBounds(530, 64, 86, 14);
		frame.getContentPane().add(middleName);
		
		textMiddleName = new JTextField();
		textMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMiddleName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				mNameLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				mNameLabel.setVisible(false);
			}
		});
		textMiddleName.setBounds(670, 61, 86, 20);
		textMiddleName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
					mNameLabel.setText("Only charecters allowed");
					mNameLabel.setForeground(Color.red);
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				else if(textMiddleName.getText().length()>=20) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
					mNameLabel.setText("Length exceeded");
					mNameLabel.setForeground(Color.red);
				 }
				else {
					mNameLabel.setText("VALID");
					mNameLabel.setForeground(Color.green);
				}
			}
		});
		frame.getContentPane().add(textMiddleName);
		textMiddleName.setColumns(10);
		
		JLabel lastName = new JLabel("Last Name*");
		lastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastName.setBounds(85, 120, 70, 14);
		frame.getContentPane().add(lastName);
		
		textLastName = new JTextField();
		textLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lNameLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				lNameLabel.setVisible(false);
			}
		});
		textLastName.setBounds(246, 117, 86, 20);
		textLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
					lNameLabel.setText("Only charecters allowed");
					lNameLabel.setForeground(Color.red);
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				else if(textLastName.getText().length()>=20) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
					lNameLabel.setText("Length exceeded");
					lNameLabel.setForeground(Color.red);
				 }
				else {
					lNameLabel.setText("VALID");
					lNameLabel.setForeground(Color.green);

				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(textLastName.getText().length()>=20) {
					lNameLabel.setText("Length exceeded");
					lNameLabel.setForeground(Color.red);
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				 }
			}
		});
		frame.getContentPane().add(textLastName);
		textLastName.setColumns(10);
		
		JLabel userName = new JLabel("User Name*");
		userName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userName.setBounds(85, 178, 86, 20);
		frame.getContentPane().add(userName);
		textUserName = new JTextField();
		textUserName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				uNameLabel.setVisible(true);;
			}
			@Override
			public void focusLost(FocusEvent e) {
				uNameLabel.setVisible(false);;
			}
		});
		textUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				boolean status = Validator.userNameValid(textUserName.getText());
				if(status) {
					uNameLabel.setText("VALID");
					uNameLabel.setForeground(Color.green);
				}
				else {
					uNameLabel.setText("INVALID");
					uNameLabel.setForeground(Color.red);
				}          
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if(textUserName.getText().length()>=20) {
					uNameLabel.setText("Length Exceeded");
					uNameLabel.setForeground(Color.red);
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				 }
			}
			@Override
			public void keyReleased(KeyEvent e) {
				try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "prakash");
						PreparedStatement ps = con.prepareStatement("select UserName from authentication where UserName=?");
						ps.setString(1, textUserName.getText());
						ResultSet rs = ps.executeQuery();
						if (rs.next())
						{
							uNameLabel.setText("username already exists");	
							uNameLabel.setForeground(Color.red);
						}						
				} catch (Exception e2) {
						return;
					} 		
			}
		});
		textUserName.setBounds(246, 178, 86, 20);
		frame.getContentPane().add(textUserName);
		textUserName.setColumns(10);
		
		JLabel mobileNumber = new JLabel("Mobile Number*");
		mobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mobileNumber.setBounds(530, 399, 107, 14);
		frame.getContentPane().add(mobileNumber);
		
		textNumber = new JTextField();
		textNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				mNumberLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textNumber.getText().toString().length()!=10) {
					mNumberLabel.setText("INVALID");
					mNumberLabel.setForeground(Color.red);
					mNumberLabel.setVisible(true);
				}
				else {
					mNumberLabel.setVisible(false);
				}
			}
		});
		textNumber.setBounds(670, 396, 86, 20);
		textNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
					mNumberLabel.setText("Only numbers allowed");
					mNumberLabel.setForeground(Color.red);
					 Toolkit.getDefaultToolkit().beep();
					 e.consume();
				}
				else if(textNumber.getText().length()==10) {
					mNumberLabel.setText("VALID");
					mNumberLabel.setForeground(Color.green);
					 Toolkit.getDefaultToolkit().beep();
					 e.consume();
				 }
				else if(textNumber.getText().length()<10) {
					mNumberLabel.setText("INVALID");
					mNumberLabel.setForeground(Color.red);
				}
			}
		});
		frame.getContentPane().add(textNumber);
		textNumber.setColumns(10);
		
		JLabel gender = new JLabel("Gender*");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gender.setBounds(85, 399, 86, 14);
		frame.getContentPane().add(gender);
		
		comboBoxGender = new JComboBox();
		comboBoxGender.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				genderLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				genderLabel.setVisible(false);
			}
		});
		comboBoxGender.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxGender.getSelectedItem().toString().equals("--Select--"))
				{
				    genderLabel.setText("Select Gender");
				    genderLabel.setForeground(Color.red);
				}
				else
				{
				    genderLabel.setText("Gender Selected");
				    genderLabel.setForeground(Color.green);
				}
			}
		});
		comboBoxGender.setBounds(246, 396, 86, 22);
		comboBoxGender.setMaximumRowCount(3);
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "Male", "Female", "Others"}));
		frame.getContentPane().add(comboBoxGender);
		
		JLabel email = new JLabel("EMAIL*");
		email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		email.setBounds(530, 120, 80, 14);
		frame.getContentPane().add(email);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				emailLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				emailLabel.setVisible(false);
			}
		});
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				boolean status = Validator.emailValid(textEmail.getText());
				if(status) {
					emailLabel.setText("VALID");
					emailLabel.setForeground(Color.green);
				}
				else {
					emailLabel.setText("INVALID");
					emailLabel.setForeground(Color.RED);
				}
			}
		});
		textEmail.setBounds(670, 117, 86, 20);
		
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel city = new JLabel("City*");
		city.setFont(new Font("Tahoma", Font.PLAIN, 12));
		city.setBounds(530, 181, 80, 14);
		city.setForeground(Color.BLACK);
		frame.getContentPane().add(city);
		
		textCity = new JTextField();
		textCity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cityLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				cityLabel.setVisible(false);
			}
		});
		textCity.setBounds(670, 175, 86, 20);
		textCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE|| c==KeyEvent.VK_SPACE)) {
					cityLabel.setText("Only letters allowed");
					cityLabel.setForeground(Color.red);
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
				else if(textCity.getText().length()>=20) {
					cityLabel.setText("Length exceted");
					cityLabel.setForeground(Color.red);
					Toolkit.getDefaultToolkit().beep();
					 e.consume();
				 }
				else {
					cityLabel.setText("VALID");
					cityLabel.setForeground(Color.green);
				}
			}
		});
		frame.getContentPane().add(textCity);
		textCity.setColumns(10);
		
		JLabel passLabel = new JLabel("Password*");
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passLabel.setBounds(85, 258, 86, 14);
		frame.getContentPane().add(passLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				passwordLabel.setVisible(false);

			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent e) {
				boolean status = Validator.passwordValid(passwordField.getText());
				if (status)
				{
					passwordLabel.setText("VALID");
					passwordLabel.setForeground(Color.green);
				}
				else {
					passwordLabel.setText("INVALID");
					passwordLabel.setForeground(Color.red);

				}
			}
		});
		passwordField.setBounds(246, 255, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel cPassLabel = new JLabel("Confirm Password*");
		cPassLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cPassLabel.setBounds(85, 326, 117, 14);
		frame.getContentPane().add(cPassLabel);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				cpasswordLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				cpasswordLabel.setVisible(false);
			}
		});
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String password = passwordField.getText().toString();
				String confirmPassword = passwordField_1.getText().toString();
				if(confirmPassword.equals(password))
				{
					cpasswordLabel.setText("VALID");
					cpasswordLabel.setForeground(Color.green);
				}
				else {
					cpasswordLabel.setText("INVALID");
					cpasswordLabel.setForeground(Color.red);
				}
			}
		});
		passwordField_1.setBounds(246, 323, 86, 20);
		frame.getContentPane().add(passwordField_1);
		
		JLabel state = new JLabel("State*");
		state.setFont(new Font("Tahoma", Font.PLAIN, 12));
		state.setBounds(530, 255, 104, 14);
		frame.getContentPane().add(state);
		
		comboBoxState = new JComboBox();
		comboBoxState.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				stateLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				stateLabel.setVisible(false);
			}
		});
		comboBoxState.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxState.getSelectedItem().toString().equals("--Select--"))
				{
					stateLabel.setText("Select Gender");
					stateLabel.setForeground(Color.red);
				}
				else
				{
					stateLabel.setText("Gender Selected");
					stateLabel.setForeground(Color.green);
				}
			}
		});
		comboBoxState.setBounds(670, 252, 137, 22);
		comboBoxState.setModel(new DefaultComboBoxModel(new String[] {"--Select--", 
				"Andhra Pradesh",
				"Arunchal Pradesh",
				"Assam",
				"Bihar",
				"Chhattisgarh",
				"Goa", 
				"Gujarat",
				"Haryana",
				"Himachal Pradesh",
				"Jharkhand",
				"Karnataka",
				"Kerala",
				"Madhaya Pradesh",
				"Maharashtra",
				"Manipur",
				"Meghalaya", 
				"Mizoram",
				"Nagaland",
				"Odisha",
				"Punjab",
				"Rajasthan",
				"Sikkim",
				"Tamil Nadu",
				"Telangana",
				"Tripura",
				"Uttar Pradesh", 
				"Uttarakhand",
				"West Bengal",
				"Andaman & Nicobar",
				"Chandigarh",
				"Dadra & Nagar Haveli & Daman & Diu",
				"Delhi", 
				"Jammu & Kashmir",
				"Ladakh",
				"Lakshadweep",
				"Puducherry"
				}));
		frame.getContentPane().add(comboBoxState);
		
		JLabel pinCode = new JLabel("Pin Code*");
		pinCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pinCode.setBounds(530, 326, 86, 14);
		frame.getContentPane().add(pinCode);
		
		textPinCode = new JTextField();
		textPinCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPinCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pCodeLabel.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textPinCode.getText().toString().length()!=6) {
					pCodeLabel.setText("INVALID");
					pCodeLabel.setForeground(Color.red);
					pCodeLabel.setVisible(true);
				}
				else {
					pCodeLabel.setVisible(false);
				}
			}
		});
		textPinCode.setBounds(670, 323, 86, 20);
		textPinCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
					pCodeLabel.setText("Only numbers allowed");
					pCodeLabel.setForeground(Color.red);
					 Toolkit.getDefaultToolkit().beep();
					 e.consume();
				}
				else if(textPinCode.getText().length()>=6) {
					pCodeLabel.setText("VALID");
					pCodeLabel.setForeground(Color.green);
					 Toolkit.getDefaultToolkit().beep();
					 e.consume();
				 }
				else if(textPinCode.getText().length()<6) {
					pCodeLabel.setText("INVALID");
					pCodeLabel.setForeground(Color.red);
				}
			}
		});
		frame.getContentPane().add(textPinCode);
		textPinCode.setColumns(10);
		
		Register = new JButton("Register");
		Register.setBounds(383, 466, 104, 23);
		Register.setBackground(Color.CYAN);
		Register.setEnabled(true);
		Register.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				//getting the data from the sign up form
				String FirstName=(textFirstName.getText());
				String LastName=(textLastName.getText());
				String MiddleName=(textMiddleName.getText());
				String Email=(textUserName.getText());
				String ContactNumber=(textNumber.getText());
				String UserName=(textUserName.getText().trim());
				String Gender=(comboBoxGender.getSelectedItem().toString());
				String City=(textCity.getText());
				String PinCode=(textPinCode.getText());
				String State=(comboBoxState.getSelectedItem().toString());
				String Password=(passwordField.getText());
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "prakash");
					 if(FirstName.equals(null)||LastName.equals(null)||Email.equals(null)||ContactNumber.equals(null)||UserName.equals(null)||Password.equals(null))
	    				{
	                    	JOptionPane.showMessageDialog(null, "Please fill all the mandatory fields");
	                    	connection.close();
	    				}
					String queryDetails = "INSERT INTO details(FirstName,MiddleName,LastName,Gender,ContactNumber,Email) values"
							+ "('" + FirstName + "','" + MiddleName + "','"+ LastName  + "','" + Gender  +"','"+ ContactNumber +"','"+ Email  +"')";
                    Statement detailsTable = connection.createStatement();
                    String query1 = "INSERT INTO address(State,City,PinCode) values('"+ State +" ','" + City + "','"+ PinCode +"')";
                    Statement addressTable = connection.createStatement();
                    String query2 = "INSERT INTO authentication(UserName,Password) values('"+ UserName +" ','" + Password +"')";
                    Statement authenticationTable = connection.createStatement();
                    
                    int rowCount = detailsTable.executeUpdate(queryDetails);
                    addressTable.executeUpdate(query1);
                    authenticationTable.executeUpdate(query2);
				
                    if (rowCount == 0) {
                        JOptionPane.showMessageDialog(Register, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(Register,
                            "Welcome "+FirstName+",Your Profile created sucessfully:)");
                    }
                    connection.close();
					
				} catch (Exception exception) {
					 exception.printStackTrace();
				}
				
			}
		});
		Register.setForeground(Color.BLUE);
		frame.getContentPane().add(Register);
		
		txtUserRegistrationForm = new JTextField();
		txtUserRegistrationForm.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtUserRegistrationForm.setBounds(325, 11, 178, 20);
		txtUserRegistrationForm.setEditable(false);
		txtUserRegistrationForm.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserRegistrationForm.setForeground(new Color(0, 0, 255));
		txtUserRegistrationForm.setBackground(Color.CYAN);
		txtUserRegistrationForm.setText("Registration Form");
		frame.getContentPane().add(txtUserRegistrationForm);
		txtUserRegistrationForm.setColumns(10);
		
		
		JButton reset = new JButton("Reset");
		reset.setBounds(634, 466, 89, 23);
		reset.setEnabled(true);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFirstName.setText(null);
				textLastName.setText(null);
				textMiddleName.setText(null);
				textUserName.setText(null);
				textEmail.setText(null);
				textNumber.setText(null);
				textUserName.setText(null);
				textCity.setText(null);
				textPinCode.setText(null);
				passwordField.setText(null);
				passwordField_1.setText(null);
				comboBoxGender.setSelectedIndex(0);
				comboBoxState.setSelectedIndex(0);
			}
		});
		reset.setForeground(Color.BLUE);
		reset.setBackground(Color.CYAN);
		frame.getContentPane().add(reset);
		frame.getContentPane().setBackground(SystemColor.info);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Operations obj = new Operations();
                frame.setVisible(false);
				obj.setVisible(true);
				obj.dispose();
			}
		});
		back.setBackground(Color.CYAN);
		back.setForeground(Color.BLUE);
		back.setBounds(146, 466, 89, 23);
		frame.getContentPane().add(back);
		
		fNameLabel = new JLabel("");
		fNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		fNameLabel.setBounds(246, 80, 152, 14);
		frame.getContentPane().add(fNameLabel);
		
		lNameLabel = new JLabel("");
		lNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lNameLabel.setBounds(246, 138, 166, 14);
		frame.getContentPane().add(lNameLabel);
		
		uNameLabel = new JLabel("");
		uNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		uNameLabel.setBounds(246, 195, 178, 22);
		frame.getContentPane().add(uNameLabel);
		
		passwordLabel = new JLabel("");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		passwordLabel.setBounds(246, 275, 178, 14);
		frame.getContentPane().add(passwordLabel);
		
		cpasswordLabel = new JLabel("");
		cpasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		cpasswordLabel.setBounds(246, 347, 152, 14);
		frame.getContentPane().add(cpasswordLabel);
		
		emailLabel = new JLabel("");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		emailLabel.setBounds(670, 138, 137, 14);
		frame.getContentPane().add(emailLabel);
		
		cityLabel = new JLabel("");
		cityLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		cityLabel.setBounds(670, 195, 137, 14);
		frame.getContentPane().add(cityLabel);
		
		stateLabel = new JLabel("");
		stateLabel.setBounds(670, 275, 137, 14);
		frame.getContentPane().add(stateLabel);
		
		genderLabel = new JLabel("");
		genderLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		genderLabel.setBounds(246, 420, 137, 20);
		frame.getContentPane().add(genderLabel);
		
		mNameLabel = new JLabel("");
		mNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		mNameLabel.setBounds(669, 80, 152, 14);
		frame.getContentPane().add(mNameLabel);
		
		mNumberLabel = new JLabel("");
		mNumberLabel.setBounds(669, 415, 137, 14);
		frame.getContentPane().add(mNumberLabel);
		
		pCodeLabel = new JLabel("");
		pCodeLabel.setBounds(670, 347, 137, 14);
		frame.getContentPane().add(pCodeLabel);
		
		
		
		
		
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		textFirstName.setText(textFirstName.getText());
		textLastName.setText(textLastName.getText());
		textMiddleName.setText(textMiddleName.getText());
		textUserName.setText(textUserName.getText());
		textNumber.setText(textNumber.getText());
		textUserName.setText(textUserName.getText());
		textCity.setText(textCity.getText());
		textPinCode.setText(textPinCode.getText());
		passwordField.setText(passwordField.getText());
		passwordField_1.setText(passwordField_1.getText());
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		textFirstName.setText(textFirstName.getText());
		textLastName.setText(textLastName.getText());
		textMiddleName.setText(textMiddleName.getText());
		textUserName.setText(textUserName.getText());
		textNumber.setText(textNumber.getText());
		textUserName.setText(textUserName.getText());
		textCity.setText(textCity.getText());
		textPinCode.setText(textPinCode.getText());
		passwordField.setText(passwordField.getText());
		passwordField_1.setText(passwordField_1.getText());
	}
}
