package gui;

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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ForgotPasswordVerify extends JFrame {

	private JPanel contentPane;
	private JTextField emailtxt;
	private JTextField otptxt;
	Statement myStmt;
	String oo;
	String em;

	public ForgotPasswordVerify() {
		

			myStmt = SqlConnection.stmt;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Tahoma", Font.BOLD, 20));
		email.setBounds(29, 87, 96, 29);
		contentPane.add(email);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(118, 96, 261, 19);
		contentPane.add(emailtxt);
		emailtxt.setColumns(10);
		
		final JButton sendotp = new JButton("Send OTP");
		sendotp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				em = (emailtxt.getText()).toLowerCase();
				


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
								String numbers = "0123456789";
								  
						        Random rndm_method = new Random();
						  
						        char[] otp = new char[6];
						  
						        for (int i = 0; i < 6; i++)
						        {
						            otp[i] =numbers.charAt(rndm_method.nextInt(numbers.length()));
						        }
						        
						        oo = new String(otp);
						        String sub = "Change Password";
						        String body = "Dear "+myRs.getString(2).substring(0,myRs.getString(2).indexOf('@'))+",\n\nYour 6 digit OTP for HEALTH CARE password change is: "+oo+".\n\n\nThanks,\nHEALTH CARE.";
						        
						        
						        Email.sendMail(sub,body,em);
						        JOptionPane.showMessageDialog(sendotp, "OTP sent to mail");
							}
							
							else
							{
								JOptionPane.showMessageDialog(sendotp, "Email Id not Registered");
								
							}
									
					}
					
					else
					{
						JOptionPane.showMessageDialog(sendotp, "Enter Valid Email Id");
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
						JOptionPane.showMessageDialog(sendotp, "Fill Email Id");
					}
				}       
			}
		});
		sendotp.setBounds(276, 125, 103, 29);
		contentPane.add(sendotp);
		
		JLabel otp = new JLabel("OTP:");
		otp.setFont(new Font("Tahoma", Font.BOLD, 20));
		otp.setBounds(29, 189, 96, 29);
		contentPane.add(otp);
		
		otptxt = new JTextField();
		otptxt.setColumns(10);
		otptxt.setBounds(118, 198, 261, 19);
		contentPane.add(otptxt);
		
		final JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				String ottp = otptxt.getText();
				

				if(ottp.equals(oo))
				{
					ChangePassword f = new ChangePassword(em);
					f.setVisible(true);
					setVisible(false);
			
				}
				
				else
				{
					JOptionPane.showMessageDialog(btnVerify, "Wrong OTP");
				}
			}
		});
		btnVerify.setBounds(276, 227, 103, 29);
		contentPane.add(btnVerify);
		
		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(140, 20, 216, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Verify Email");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(183, 54, 126, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App p = new App();
				p.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 18, 79, 21);
		contentPane.add(btnNewButton);
	}
}
