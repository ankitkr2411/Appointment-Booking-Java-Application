package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import myConnection.SqlConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField passtxt;
	private JTextField repasstxt;
	Statement myStmt;
	private JButton btnNewButton;

	public ChangePassword(final String em) {
		

			myStmt = SqlConnection.stmt;
			

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pass = new JLabel("New Password: ");
		pass.setFont(new Font("Tahoma", Font.BOLD, 20));
		pass.setBounds(22, 73, 191, 27);
		contentPane.add(pass);
		
		passtxt = new JTextField();
		passtxt.setBounds(198, 81, 215, 19);
		contentPane.add(passtxt);
		passtxt.setColumns(10);
		
		JLabel repass = new JLabel("Re- Password: ");
		repass.setFont(new Font("Tahoma", Font.BOLD, 20));
		repass.setBounds(22, 137, 191, 27);
		contentPane.add(repass);
		
		repasstxt = new JTextField();
		repasstxt.setColumns(10);
		repasstxt.setBounds(198, 145, 215, 19);
		contentPane.add(repasstxt);
		
		final JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String tpass = passtxt.getText();
				String trepass = repasstxt.getText();
				
				int myRs;
				
				if(tpass.equals(trepass))
				{
					try {
						myRs = myStmt.executeUpdate("update PatientRegistration set Pass = '"+tpass+"' where EmailId = '"+em+"';");
						
						JOptionPane.showMessageDialog(submit, "Password Changed");
						App pp = new App();
						pp.setVisible(true);
						setVisible(false);
					}
					
					catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(submit, "Password doesn't matched");
				}
			}
		});
		submit.setBounds(312, 191, 101, 27);
		contentPane.add(submit);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgotPasswordVerify f = new ForgotPasswordVerify();
				f.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(10, 10, 66, 21);
		contentPane.add(btnNewButton);
	}

}
