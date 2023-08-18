package gui;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import myConnection.SqlConnection;
import sendEmail.Email;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

public class SignUpEmailVerify extends JFrame {

	private JPanel contentPane;
	private JTextField EmailIdtxt;
	Statement myStmt;
	private JTextField OTPtxt;
	String oo;
	String em;
	final JButton SendOTP;

	public SignUpEmailVerify() {
	
			myStmt = SqlConnection.stmt;

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(23, 52, 91, 34);
		contentPane.add(lblNewLabel);
		
		EmailIdtxt = new JTextField();
		EmailIdtxt.setBounds(101, 63, 229, 19);
		contentPane.add(EmailIdtxt);
		EmailIdtxt.setColumns(10);
		
		
		
		SendOTP = new JButton("Send OTP");
		SendOTP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				em = (EmailIdtxt.getText()).toLowerCase();
				
				ResultSet myRs;
				if(!em.isEmpty())
				{
				
				try
				{
					
					if(em.contains("@") && em.contains("."))
					{
							myRs = myStmt.executeQuery("select * from PatientRegistration where EmailId = '"+em+"'");
							
							if(myRs.next())
							{
								JOptionPane.showMessageDialog(SendOTP, "Email Id Already Exist");
							}
							
							else
							{
								String numbers = "0123456789";
								  
						        Random rndm_method = new Random();
						  
						        char[] otp = new char[6];
						  
						        for (int i = 0; i < 6; i++)
						        {
						            otp[i] =numbers.charAt(rndm_method.nextInt(numbers.length()));
						        }
						        
						        oo = new String(otp);
						        String sub = "Verify Email";
						        String m = "HEALTH CARE Welcomes You,\n\nYour 6 digit OTP for login is: "+oo+".\n\n\nThanks,\nHEALTH CARE.";
						        
						        
						        Email.sendMail(sub,m,em);
						        JOptionPane.showMessageDialog(SendOTP, "OTP sent to Email");
							}
									
					}
					
					else
					{
						JOptionPane.showMessageDialog(SendOTP, "Enter Valid Email Id");
					}
					
				}
				
					
				
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				}
			
				else
				{

					if(em.isEmpty())
					{
						JOptionPane.showMessageDialog(SendOTP, "Fill Email Id");
					}
				}
			}
			
		});
		SendOTP.setBounds(225, 92, 105, 34);
		contentPane.add(SendOTP);
		
		JLabel lblNewLabel_1 = new JLabel("SIGNUP");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(164, 10, 84, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblOtp = new JLabel("OTP:");
		lblOtp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOtp.setBounds(23, 167, 91, 34);
		contentPane.add(lblOtp);
		
		OTPtxt = new JTextField();
		OTPtxt.setColumns(10);
		OTPtxt.setBounds(101, 178, 229, 19);
		contentPane.add(OTPtxt);
		
		final JButton Verify = new JButton("Verify");
		Verify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String ottp = OTPtxt.getText();
				

					if(ottp.equals(oo))
					{
						JOptionPane.showMessageDialog(Verify, "Verified");
						PatientSignUp f = new PatientSignUp(em);
						f.setVisible(true);
						setVisible(false);
				
					}
					
					else
					{
						JOptionPane.showMessageDialog(Verify, "Wrong OTP");
					}
				
			
			}
		});
		Verify.setBounds(225, 207, 105, 34);
		contentPane.add(Verify);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App p = new App();
				p.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
	}

}
