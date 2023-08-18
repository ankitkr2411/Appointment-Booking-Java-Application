package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import myConnection.SqlConnection;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Patient extends JFrame {

	private JPanel contentPane;
	Statement myStmt;

	public Patient(final String u) {


			myStmt = SqlConnection.stmt;

		
		setBounds(100, 100, 1004, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 278, 750);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton ScheduleAppointment = new JButton("Schedule Appointment");
		ScheduleAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				SelectDay day = new SelectDay(u);
				day.setVisible(true);
				setVisible(false);
				
			}
		});
		ScheduleAppointment.setBounds(54, 139, 162, 36);
		panel.add(ScheduleAppointment);
		
		JButton btnViewAppointments = new JButton("View Appointments");
		btnViewAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAppointment v = new ViewAppointment(u);
				v.setVisible(true);
				setVisible(false);
			}
		});
		btnViewAppointments.setBounds(54, 205, 162, 36);
		panel.add(btnViewAppointments);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				App p = new App();
				p.setVisible(true);
				setVisible(false);
			}
		});
		btnLogOut.setBounds(68, 634, 134, 36);
		panel.add(btnLogOut);
		
		JLabel lblNewLabel = new JLabel("PATIENT INFORMATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(509, 29, 320, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone:");
		lblNewLabel_1.setBounds(301, 155, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Id:");
		lblNewLabel_1_1.setBounds(301, 114, 76, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email Id:");
		lblNewLabel_1_2.setBounds(301, 190, 65, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setBounds(301, 224, 65, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("City:");
		lblNewLabel_2_1.setBounds(301, 254, 65, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("State:");
		lblNewLabel_2_1_1.setBounds(301, 287, 65, 13);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Pin Code:");
		lblNewLabel_2_1_1_1.setBounds(301, 320, 65, 13);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("DOB:");
		lblNewLabel_2_1_1_1_1.setBounds(301, 355, 65, 13);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Age:");
		lblNewLabel_2_1_1_1_1_1.setBounds(301, 389, 65, 13);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Sex:");
		lblNewLabel_2_1_1_1_1_1_1.setBounds(301, 422, 65, 13);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1 = new JLabel("Emergency Contact:");
		lblNewLabel_2_1_1_1_1_1_1_1.setBounds(301, 500, 149, 13);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1 = new JLabel("Relationship:");
		lblNewLabel_2_1_1_1_1_1_1_1_1.setBounds(301, 531, 149, 13);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_1 = new JLabel("Address:");
		lblNewLabel_2_1_1_1_1_1_1_1_1_1.setBounds(301, 564, 149, 13);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_2 = new JLabel("Phone:");
		lblNewLabel_2_1_1_1_1_1_1_1_1_2.setBounds(301, 598, 149, 13);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("First Name:");
		lblNewLabel_1_1_1.setBounds(429, 114, 76, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Middle Name:");
		lblNewLabel_1_1_2.setBounds(615, 114, 101, 13);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Last Name:");
		lblNewLabel_1_1_2_1.setBounds(817, 114, 76, 13);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		JLabel o1 = new JLabel("Phone:");
		o1.setBounds(328, 114, 101, 13);
		contentPane.add(o1);
		
		JLabel o6 = new JLabel("Phone:");
		o6.setBounds(376, 190, 153, 13);
		contentPane.add(o6);
		
		JLabel o7 = new JLabel("Phone:");
		o7.setBounds(376, 224, 371, 13);
		contentPane.add(o7);
		
		JLabel o8 = new JLabel("Phone:");
		o8.setBounds(376, 254, 100, 13);
		contentPane.add(o8);
		
		JLabel o9 = new JLabel("Phone:");
		o9.setBounds(376, 287, 100, 13);
		contentPane.add(o9);
		
		JLabel o10 = new JLabel("Phone:");
		o10.setBounds(376, 320, 100, 13);
		contentPane.add(o10);
		
		JLabel o11 = new JLabel("Phone:");
		o11.setBounds(376, 355, 100, 13);
		contentPane.add(o11);
		
		JLabel o12 = new JLabel("Phone:");
		o12.setBounds(376, 389, 100, 13);
		contentPane.add(o12);
		
		JLabel o13 = new JLabel("Phone:");
		o13.setBounds(376, 422, 100, 13);
		contentPane.add(o13);
		
		JLabel o14 = new JLabel("Phone:");
		o14.setBounds(429, 500, 176, 13);
		contentPane.add(o14);
		
		JLabel o15 = new JLabel("Phone:");
		o15.setBounds(429, 531, 100, 13);
		contentPane.add(o15);
		
		JLabel o16 = new JLabel("Phone:");
		o16.setBounds(429, 564, 100, 13);
		contentPane.add(o16);
		
		JLabel o17 = new JLabel("Phone:");
		o17.setBounds(429, 598, 100, 13);
		contentPane.add(o17);
		
		JLabel o2 = new JLabel("Phone:");
		o2.setBounds(505, 114, 100, 13);
		contentPane.add(o2);
		
		JLabel o3 = new JLabel("Phone:");
		o3.setBounds(707, 114, 100, 13);
		contentPane.add(o3);
		
		JLabel o4 = new JLabel("Phone:");
		o4.setBounds(890, 114, 100, 13);
		contentPane.add(o4);
		
		JLabel o5 = new JLabel("Phone:");
		o5.setBounds(376, 155, 100, 13);
		contentPane.add(o5);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_2_1 = new JLabel("Registration:");
		lblNewLabel_2_1_1_1_1_1_1_1_1_2_1.setBounds(301, 715, 149, 13);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1_1_1_2_1);
		
		JLabel o20 = new JLabel("Phone:");
		o20.setBounds(376, 715, 100, 13);
		contentPane.add(o20);
		
		try
		{
			ResultSet rs = myStmt.executeQuery("select * from PatientInformation where UserId = '"+u+"'");
			
			rs.next();
			
			String s;
			
			s=rs.getString(1);
			o1.setText(s);
			
			s=rs.getString(2);
			o2.setText(s);
			
			s=rs.getString(3);
			o3.setText(s);
			
			s=rs.getString(4);
			o4.setText(s);
			
			long s1=rs.getLong(5);
			s = Long.toString(s1);
			o5.setText(s);
			
			s=rs.getString(6);
			o6.setText(s);
			
			s=rs.getString(7);
			o7.setText(s);
			
			s=rs.getString(8);
			o8.setText(s);
			
			s=rs.getString(9);
			o9.setText(s);
			
			
			int s2 = rs.getInt(10);
			s=Integer.toString(s2);
			o10.setText(s);
			
			s=rs.getString(11);
			o11.setText(s);
			
			s2 = rs.getInt(12);
			s=Integer.toString(s2);
			o12.setText(s);
			
			s=rs.getString(13);
			o13.setText(s);
			
			s=rs.getString(14);
			o14.setText(s);
			
			s=rs.getString(15);
			o15.setText(s);
			
			s=rs.getString(16);
			o16.setText(s);
			
			s1 = rs.getLong(17);
			s=Long.toString(s1);
			o17.setText(s);
			
			s=rs.getString(20);
			o20.setText(s);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
