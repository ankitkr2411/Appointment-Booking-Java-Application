package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import myConnection.SqlConnection;
import sendEmail.Email;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectTime extends JFrame {

	private JPanel contentPane;

	Statement myStmt;
	String tim;
	private String day;
	private String userId;

	
	public void book(String time)
	{
		String dbtime;
		
		if(time.equals("9:00-9:30"))
		{
			dbtime = "t_9_930";		
		}
		
		else if(time.equals("9:30-10:00"))
		{
			dbtime = "t_930_10";
		}
		else if(time.equals("10:00-10:30"))
		{
			dbtime = "t_10_1030";
		}
		
		else if(time.equals("10:30-11:00"))
		{
			dbtime = "t_1030_11";
		}
		
		else if(time.equals("11:00-11:30"))
		{
			dbtime = "t_11_1130";
		}
		
		else if(time.equals("11:30-12:00"))
		{
			dbtime = "t_1130_12";
		}
		
		else if(time.equals("12:00-12:30"))
		{
			dbtime = "t_12_1230";
		}
		
		else if(time.equals("12:30-13:00"))
		{
			dbtime = "t_1230_1";
		}
		
		else if(time.equals("14:00-14:30"))
		{
			dbtime = "t_2_230";
		}
		
		else if(time.equals("14:30-15:00"))
		{
			dbtime = "t_230_3";
		}
		
		else if(time.equals("15:00-15:30"))
		{
			dbtime = "t_3_330";
		}
		
		else if(time.equals("15:30-16:00"))
		{
			dbtime = "t_330_4";
		}
		
		else if(time.equals("16:00-16:30"))
		{
			dbtime = "t_4_430";
		}
		
		else if(time.equals("16:30-17:00"))
		{
			dbtime = "t_430_5";
		}
		
		else if(time.equals("17:00-17:30"))
		{
			dbtime = "t_5_530";
		}
		
		else if(time.equals("17:30-18:00"))
		{
			dbtime = "t_530_6";
		}
		
		else if(time.equals("18:00-18:30"))
		{
			dbtime = "t_6_630";
		}
		else {
			dbtime = "t_630_7";
		}
		
		
		try {
			myStmt.executeUpdate("update AppointTime set "+dbtime+" = '"+this.userId+"' where _day = '"+this.day+"';");
			Calendar cal = new GregorianCalendar();
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			String date;
			if(this.day.equals("Today"))
			{
				date = day + " / " + (month + 1) + " / " + year;
			}
			else {
				date = (day+1) + " / " + (month + 1) + " / " + year;
				
			}
			 
			
			myStmt.executeUpdate("insert into AppointData(UserId,_date,_time,_dbtime,_status) values ('"+this.userId+"','"+date+"','"+time+"','"+dbtime+"','Booked')");              
			ResultSet rs = myStmt.executeQuery("select FirstName, EmailId from PatientInformation where UserId = '"+this.userId+"'");
			rs.next();
			String sub = "Appointment Scheduled";
	        String body = "Dear "+rs.getString(1)+",\n\nYour Appointment is Scheduled \non "+date+" at "+time+".\n\n\nThanks,\nHEALTH CARE.";
	        String em = rs.getString(2);
	        Email.sendMail(sub,body,em);
	        
	        JOptionPane.showMessageDialog(null,"Booked");
			Patient p = new Patient(this.userId);
			p.setVisible(true);
			setVisible(false);
			
		} catch (SQLException e) {

			e.printStackTrace();
			return;
		}
		
		
	}
	
	
	
	public JPanel createPanel(final String time)
	{
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel(time);
		
		JLabel lblNewLabel_2 = new JLabel("    ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 5));
		
		
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book(time);
			}
		});
		panel.add(lblNewLabel_1);
		panel.add(lblNewLabel_2);
		panel.add(btnNewButton);
		
		return panel;
		
	}
	

	
	
	
	
	public SelectTime(String day, final String userId) {
		
		this.day = day;
		this.userId = userId;
		

			myStmt = SqlConnection.stmt;

			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Time");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(380, 22, 172, 47);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 102, 990, 491);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 30, 50));
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectDay s = new SelectDay(userId);
				s.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(21, 10, 66, 21);
		contentPane.add(btnNewButton_1);
			
		
		
		try {
			ResultSet rs = myStmt.executeQuery("select * from AppointTime where _day = '"+day+"'");		
			rs.next();
			int h = 9;
			int m = 0;
			
			for(int i=2;i<=19;i++)
			{
				if(i==10)
				{
					h=h+1;
					m=0;
				}
				
				
			 if(rs.getString(i) == null)
			 {
				 if(i%2==0)
					{
						tim = Integer.toString(h)+":"+Integer.toString(m)+"0"+"-"+Integer.toString(h)+":"+Integer.toString(m+30);
						m=m+30;
						
						JPanel innerpanel = createPanel(tim);
						panel.add(innerpanel);
					}
					
					else
					{
						tim = Integer.toString(h)+":"+Integer.toString(m)+"-"+Integer.toString(h+1)+":"+Integer.toString(m-30)+"0";
						h=h+1;
						m=m-30;
						
						JPanel innerpanel = createPanel(tim);
						panel.add(innerpanel);				
					}
				 
				
			 }
			 
			 else {
				 
				 if(i%2==0)
					{
						tim = Integer.toString(h)+":"+Integer.toString(m)+"0"+"-"+Integer.toString(h)+":"+Integer.toString(m+30);
						m=m+30;
						
						JPanel innerpanel = new JPanel();
						
						innerpanel.setLayout(new BoxLayout(innerpanel, BoxLayout.Y_AXIS));
						
						JLabel lblNewLabel_1 = new JLabel(tim);
						
						JLabel lblNewLabel_2 = new JLabel("    ");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 5));
						
						
						JLabel btnNewButton = new JLabel("Not Available");
						
						innerpanel.add(lblNewLabel_1);
						innerpanel.add(lblNewLabel_2);
						innerpanel.add(btnNewButton);
						panel.add(innerpanel);
					}
					
					else
					{
						tim = Integer.toString(h)+":"+Integer.toString(m)+"-"+Integer.toString(h+1)+":"+Integer.toString(m-30)+"0";
						h=h+1;
						m=m-30;
						
						JPanel innerpanel = new JPanel();
						
						innerpanel.setLayout(new BoxLayout(innerpanel, BoxLayout.Y_AXIS));
						
						JLabel lblNewLabel_1 = new JLabel(tim);
						
						JLabel lblNewLabel_2 = new JLabel("    ");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 5));
						
						
						JLabel btnNewButton = new JLabel("Not Available");
						
						innerpanel.add(lblNewLabel_1);
						innerpanel.add(lblNewLabel_2);
						innerpanel.add(btnNewButton);
						panel.add(innerpanel);				
					}
				 
			 }
				
				
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Server Not Responding");
			System.exit(0);
		}
		
		
		
		
		
		
	}
}
