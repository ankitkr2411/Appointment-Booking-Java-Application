package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import myConnection.SqlConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SelectDay extends JFrame {

	private JPanel contentPane;
	Statement myStmt;

	public SelectDay(final String u) {

			myStmt = SqlConnection.stmt;
			
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Day");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(116, 10, 155, 33);
		contentPane.add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose Day", "Today", "Tommorow"}));
		comboBox.setBounds(129, 66, 142, 21);
		contentPane.add(comboBox);
		
		final JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean booked = false;
				String s=(String) comboBox.getSelectedItem();
				if(s.equals("Choose Day"))
				{
					JOptionPane.showMessageDialog(btnNewButton, "Choose Day");		
				}
				else {

						try {
							ResultSet rs = myStmt.executeQuery("select * from AppointTime where _day = '"+s+"'");
							rs.next();
							for(int i =2;i<=19;i++)
							{
								if(rs.getString(i)!=null)
								{
									if(rs.getString(i).equals(u))
									{
										JOptionPane.showMessageDialog(btnNewButton, "You have Booked a Appointment "+s);
										booked = true;
										break;
									}
									
								}
							}
							
						}
						catch(Exception ex)
						{
							ex.printStackTrace();									
						}
						
						if(!booked)
						{
							SelectTime time = new SelectTime(s,u);
							time.setVisible(true);
							setVisible(false);
						}
			}
			}
		});
		
		
		btnNewButton.setBounds(154, 131, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient p = new Patient(u);
				p.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 10, 53, 21);
		contentPane.add(btnNewButton_1);
	}
}
