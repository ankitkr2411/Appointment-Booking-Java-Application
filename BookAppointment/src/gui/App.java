package gui;

import myConnection.SqlConnection;
import java.awt.EventQueue;

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
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private JPanel contentPane;
	private JLabel UserId;
	private JTextField UserIdtxt;
	private JLabel Pass;
	private JPasswordField Passtxt;
	private JLabel lblNewLabel;
	static App frame;
	private Statement myStmt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new App();
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
	public App()
	{
		try
		{
			
			SqlConnection.createConnection();
			myStmt = SqlConnection.stmt;
			
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Server Not Responding");
			System.exit(0);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 595);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UserId = new JLabel("User Id     : ");
		UserId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		UserId.setBounds(44, 195, 130, 43);
		contentPane.add(UserId);
		
		UserIdtxt = new JTextField();
		UserIdtxt.setForeground(Color.BLACK);
		UserIdtxt.setColumns(10);
		UserIdtxt.setBackground(Color.WHITE);
		UserIdtxt.setBounds(184, 205, 289, 25);
		contentPane.add(UserIdtxt);
		
		Pass = new JLabel("Password  : ");
		Pass.setFont(new Font("Tahoma", Font.PLAIN, 23));
		Pass.setBounds(44, 271, 130, 43);
		contentPane.add(Pass);
		
		Passtxt = new JPasswordField();
		Passtxt.setBounds(184, 283, 289, 25);
		contentPane.add(Passtxt);
		
		final JButton Login = new JButton("Login");
		
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String u = UserIdtxt.getText();
				String pas = String.valueOf(Passtxt.getPassword());
				try
				{
					ResultSet rs = myStmt.executeQuery("select * from PatientRegistration where UserId = '"+u+"' and Pass = '"+pas+"'");
					
					if(rs.next())
					{
						String s = rs.getString(4);
						
						if(s.equals("unfilled"))
						{
							PatientApplicationForm f = new PatientApplicationForm(u);
							f.setVisible(true);
							setVisible(false);
						}
						
						else
						{
							Patient p = new Patient(u);
							p.setVisible(true);
							setVisible(false);
						}
					}
					
					else
					{
						JOptionPane.showMessageDialog(Login, "Invalid User Id or Password");
					}
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
			}
		});
		Login.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Login.setBounds(343, 357, 130, 43);
		contentPane.add(Login);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have Account?");
		lblNewLabel_1.setBounds(194, 467, 124, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SignUpEmailVerify r = new SignUpEmailVerify();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(205, 492, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(SystemColor.desktop));
		panel.setBounds(14, 175, 495, 242);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton FrPass = new JButton("Click Here");
		FrPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ForgotPasswordVerify pp = new ForgotPasswordVerify();
				pp.setVisible(true);
				setVisible(false);
			}
		});
		FrPass.setBounds(130, 215, 115, 21);
		panel.add(FrPass);
		
		JLabel lblNewLabel_2 = new JLabel("Forgot Password?");
		lblNewLabel_2.setBounds(10, 219, 110, 13);
		panel.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("Patient Login");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(185, 23, 179, 33);
		contentPane.add(lblNewLabel);
	}
}
