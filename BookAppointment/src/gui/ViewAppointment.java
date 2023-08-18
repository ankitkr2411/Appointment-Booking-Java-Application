package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import myConnection.SqlConnection;
import sendEmail.Email;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class ViewAppointment extends JFrame {

	private JPanel contentPane;
	Statement myStmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAppointment frame = new ViewAppointment("ankit");
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
	public ViewAppointment(final String user) {
		

			myStmt = SqlConnection.stmt;
			

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APPOINTMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(299, 36, 393, 41);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 106, 1038, 500);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 30));
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient p = new Patient(user);
				p.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 10, 68, 21);
		contentPane.add(btnNewButton_1);
		
		try {
			ResultSet rs = myStmt.executeQuery("select _date,_time,_dbtime,_status from AppointData where UserId = '"+user+"' order by _date desc");
			while(rs.next())
			{

					final String date = rs.getString(1);
					final String time = rs.getString(2);
					final String dbtime = rs.getString(3);
					String status = rs.getString(4);
					
					JPanel panel_1 = new JPanel();
					panel.add(panel_1);
					panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
					
					JLabel lblNewLabel_1 = new JLabel(date);
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					panel_1.add(lblNewLabel_1);
					
					JLabel lblNewLabel_1_1 = new JLabel(time);
					lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
					panel_1.add(lblNewLabel_1_1);
					
					JLabel lblNewLabel_2 = new JLabel(" ");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 7));
					panel_1.add(lblNewLabel_2);
					
					if(status.equals("Booked"))
					{
						JButton btnNewButton = new JButton("Cancel");
						panel_1.add(btnNewButton);
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Calendar cal = new GregorianCalendar();
								int month = cal.get(Calendar.MONTH);
								int year = cal.get(Calendar.YEAR);
								int dayint = cal.get(Calendar.DAY_OF_MONTH);
								String nowdate = dayint + " / " + (month + 1) + " / " + year;
								String day;
								if(date.equals(nowdate))
								{
									day = "Today";
								}
								else {
									day = "Tommorow";
								}
								
								try {
									myStmt.executeUpdate("update AppointTime set "+dbtime+" = null  where _day = '"+day+"'");
									myStmt.executeUpdate("update AppointData set _status = 'Cancelled'  where _date = '"+date+"' AND UserId = '"+user+"'");
									
									
									
									ResultSet rs = myStmt.executeQuery("select FirstName, EmailId from PatientInformation where UserId = '"+user+"'");
									rs.next();
									String sub = "Appointment Cancelled";
							        String body = "Dear "+rs.getString(1)+",\n\nYour Appointment Scheduled \non "+date+" at "+time+" is Cancelled.\n\n\nThanks,\nHEALTH CARE.";
							        String em = rs.getString(2);
							        
							        Email.sendMail(sub,body,em);
							        
							        JOptionPane.showMessageDialog(null, "Cancelled");
									ViewAppointment v = new ViewAppointment(user);
									v.setVisible(true);
									setVisible(false);
								}
								
								catch (SQLException e1) {
									e1.printStackTrace();
								}
								
								
							
							}
						});
					}
					else if(status.equals("Done"))
					{
						JLabel label = new JLabel("Checked");
						panel_1.add(label);
					}
					else {
						JLabel label = new JLabel("Cancelled");
						panel_1.add(label);
					}
						
					
					
					
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
