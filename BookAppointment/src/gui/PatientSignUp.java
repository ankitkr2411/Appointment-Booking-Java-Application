package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import myConnection.SqlConnection;
import sendEmail.Email;

import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class PatientSignUp extends JFrame {

	private JPanel contentPane;
	private JLabel UserId;
	private JTextField UserIdtxt;
	private JLabel Pass;
	private JPasswordField Passtxt;
	private JLabel lblNewLabel_2;
	static PatientSignUp frame;
	Statement myStmt;
	private JLabel repass;
	private JPasswordField repasstxt;

	
	public PatientSignUp(final String em) {
	
			myStmt = SqlConnection.stmt;

		
		setBounds(100, 100, 639, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Already Registered?");
		lblNewLabel_1.setBounds(193, 463, 124, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				App pa = new App();
				pa.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(313, 465, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JPanel signuppanel = new JPanel();
		signuppanel.setBackground(Color.WHITE);
		signuppanel.setBorder(new LineBorder(SystemColor.desktop));
		signuppanel.setBounds(14, 110, 573, 278);
		contentPane.add(signuppanel);
		signuppanel.setLayout(null);
		
		UserId = new JLabel("User Id     : ");
		UserId.setBounds(28, 30, 130, 43);
		signuppanel.add(UserId);
		UserId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		UserIdtxt = new JTextField();
		UserIdtxt.setBounds(232, 44, 289, 25);
		signuppanel.add(UserIdtxt);
		UserIdtxt.setForeground(Color.BLACK);
		UserIdtxt.setColumns(10);
		UserIdtxt.setBackground(Color.WHITE);
		
		Pass = new JLabel("Password  : ");
		Pass.setBounds(28, 83, 130, 43);
		signuppanel.add(Pass);
		Pass.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		Passtxt = new JPasswordField();
		Passtxt.setBounds(232, 97, 289, 25);
		signuppanel.add(Passtxt);
		
		final JButton SignUp = new JButton("Sign Up");
		SignUp.setBounds(391, 190, 130, 43);
		signuppanel.add(SignUp);
		SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String u = UserIdtxt.getText();
				
				String pass = String.valueOf(Passtxt.getPassword());
				
				String rpass = String.valueOf(repasstxt.getPassword());
				ResultSet myRs;
				
				if(!u.isEmpty() && !pass.isEmpty())
				{
					
					if(pass.equals(rpass))
					{
					
						try
						{
					
							myRs = myStmt.executeQuery("select * from PatientRegistration where UserId = '"+u+"'");
							
							if(myRs.next())
							{
								JOptionPane.showMessageDialog(SignUp, "User Id Already Exist");
							}
											
					
					
						
							else
						{
							myStmt.executeUpdate("insert into PatientRegistration(UserId,EmailId,Pass) values ('"+u+"','"+em+"','"+pass+"')");
							String sub = "Registration Successfull";
					        String m = "HEALTH CARE Welcomes You,\n\nYour userId is: "+u+"\nPlease Keep it with yourself only.\n\n\nThanks,\nHEALTH CARE.";
					        
					        
					        Email.sendMail(sub,m,em);

							JOptionPane.showMessageDialog(SignUp, "Registered Succesfully go to Login Page");
							App p = new App();
							p.setVisible(true);
							setVisible(false);
						}
					
				}
					
				
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				}
					
					else
					{
						JOptionPane.showMessageDialog(SignUp, "Both Password doesn't matched");
					}
				}
				
				else
				{
					if(u.isEmpty())
					{
						JOptionPane.showMessageDialog(SignUp, "Fill User Id");
					}
					
					
					if(pass.isEmpty())
					{
						JOptionPane.showMessageDialog(SignUp, "Fill Password");
					}
				}
			}
				
			
		});
		SignUp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		repass = new JLabel("Re-Password  : ");
		repass.setFont(new Font("Tahoma", Font.PLAIN, 23));
		repass.setBounds(28, 141, 194, 43);
		signuppanel.add(repass);
		
		repasstxt = new JPasswordField();
		repasstxt.setBounds(232, 155, 289, 25);
		signuppanel.add(repasstxt);
		
		lblNewLabel_2 = new JLabel("Patient Registartion");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(215, 21, 266, 31);
		contentPane.add(lblNewLabel_2);
	}
}
