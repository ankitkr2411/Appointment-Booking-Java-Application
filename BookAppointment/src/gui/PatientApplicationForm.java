package gui;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Color;
import myConnection.SqlConnection;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.SwingConstants;

public class PatientApplicationForm extends JFrame{
	

	private JPanel contentPane;
	private JTextField Firsttxt;
	private JTextField Middletxt;
	private JTextField Lasttxt;
	private JTextField Phonetxt;
	private JTextField Emailtxt;
	private JTextField Addtxt;
	private JTextField Citytxt;
	private JTextField Statetxt;
	private JTextField PinCodetxt;
	private JTextField Agetxt;
	private JTextField Emergencytxt;
	private JTextField Relationtxt;
	private JTextField RelAddtxt;
	private JTextField RelPhonetxt;
	private JTextField FormNametxt;
	private JTextField FormReltxt;
	Statement myStmt;
	private JTextField Dobtxt;
	private JTextField Sextxt;
	private JTextField Datetxt;


	public PatientApplicationForm(final String u)
	{
		
		
			myStmt = SqlConnection.stmt;
			

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 855);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel First = new JLabel("FIRST NAME :");
		First.setBounds(49, 213, 82, 13);
		contentPane.add(First);
		
		Firsttxt = new JTextField();
		Firsttxt.setBounds(48, 234, 195, 19);
		contentPane.add(Firsttxt);
		Firsttxt.setColumns(10);
		
		JLabel Middle = new JLabel("MIDDLE NAME :");
		Middle.setBounds(298, 213, 96, 13);
		contentPane.add(Middle);
		
		Middletxt = new JTextField();
		Middletxt.setColumns(10);
		Middletxt.setBounds(298, 234, 195, 19);
		contentPane.add(Middletxt);
		
		JLabel Last = new JLabel("LAST NAME :");
		Last.setBounds(550, 213, 82, 13);
		contentPane.add(Last);
		
		Lasttxt = new JTextField();
		Lasttxt.setColumns(10);
		Lasttxt.setBounds(550, 234, 195, 19);
		contentPane.add(Lasttxt);
		
		JLabel Phone = new JLabel("Phone Number :");
		Phone.setBounds(49, 273, 118, 13);
		contentPane.add(Phone);
		
		Phonetxt = new JTextField();
		Phonetxt.setColumns(10);
		Phonetxt.setBounds(149, 270, 195, 19);
		contentPane.add(Phonetxt);
		
			

		
		JLabel Email = new JLabel("Email Id :");
		Email.setBounds(389, 273, 118, 13);
		contentPane.add(Email);
		
		Emailtxt = new JTextField();
		Emailtxt.setColumns(10);
		Emailtxt.setBounds(449, 270, 195, 19);
		contentPane.add(Emailtxt);
		try
		{
			ResultSet rs = myStmt.executeQuery("select * from PatientRegistration where UserId = '"+u+"'");
			
			rs.next();

				Emailtxt.setText(rs.getString(2));
				Emailtxt.setEditable(false);
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();		
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(SystemColor.desktop));
		panel.setBounds(28, 194, 757, 116);
		contentPane.add(panel);
		
		JLabel Address = new JLabel("Address :");
		Address.setBounds(49, 331, 118, 13);
		contentPane.add(Address);
		
		Addtxt = new JTextField();
		Addtxt.setBounds(104, 328, 641, 19);
		contentPane.add(Addtxt);
		Addtxt.setColumns(10);
		
		JLabel City = new JLabel("City :");
		City.setBounds(49, 368, 118, 13);
		contentPane.add(City);
		
		Citytxt = new JTextField();
		Citytxt.setColumns(10);
		Citytxt.setBounds(81, 365, 131, 19);
		contentPane.add(Citytxt);
		
		JLabel State = new JLabel("State :");
		State.setBounds(249, 368, 118, 13);
		contentPane.add(State);
		
		Statetxt = new JTextField();
		Statetxt.setColumns(10);
		Statetxt.setBounds(289, 365, 131, 19);
		contentPane.add(Statetxt);
		
		JLabel PinCode = new JLabel("Pin Code :");
		PinCode.setBounds(463, 368, 118, 13);
		contentPane.add(PinCode);
		
		PinCodetxt = new JTextField();
		PinCodetxt.setColumns(10);
		PinCodetxt.setBounds(525, 365, 220, 19);
		contentPane.add(PinCodetxt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(SystemColor.desktop));
		panel_1.setBounds(28, 309, 757, 98);
		contentPane.add(panel_1);
		
		JLabel Dob = new JLabel("DOB :");
		Dob.setBounds(49, 424, 118, 13);
		contentPane.add(Dob);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(Color.BLACK));
		panel_2.setBounds(28, 405, 757, 51);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		Dobtxt = new JTextField();
		Dobtxt.setColumns(10);
		Dobtxt.setBounds(61, 15, 131, 19);
		panel_2.add(Dobtxt);
		Dobtxt.setText("DD / MM / YYYY");
		
		
		Sextxt = new JTextField();
		Sextxt.setColumns(10);
		Sextxt.setBounds(584, 15, 131, 19);
		panel_2.add(Sextxt);
		
		Agetxt = new JTextField();
		Agetxt.setBounds(344, 15, 131, 19);
		panel_2.add(Agetxt);
		Agetxt.setColumns(10);
		
		JLabel Age = new JLabel("Age :");
		Age.setBounds(300, 18, 66, 13);
		panel_2.add(Age);
		
		JLabel Sex = new JLabel("Sex :");
		Sex.setBounds(546, 18, 66, 13);
		panel_2.add(Sex);
		
		JLabel EmergencyContact = new JLabel("Emergency Contact :");
		EmergencyContact.setBounds(49, 476, 118, 13);
		contentPane.add(EmergencyContact);
		
		Emergencytxt = new JTextField();
		Emergencytxt.setColumns(10);
		Emergencytxt.setBounds(175, 473, 141, 19);
		contentPane.add(Emergencytxt);
		
		JLabel RelationshipToPatient = new JLabel("Relationship to Patient :");
		RelationshipToPatient.setBounds(470, 476, 145, 13);
		contentPane.add(RelationshipToPatient);
		
		Relationtxt = new JTextField();
		Relationtxt.setColumns(10);
		Relationtxt.setBounds(614, 473, 131, 19);
		contentPane.add(Relationtxt);
		
		JLabel RelAdd = new JLabel("Address :");
		RelAdd.setBounds(49, 511, 118, 13);
		contentPane.add(RelAdd);
		
		RelAddtxt = new JTextField();
		RelAddtxt.setColumns(10);
		RelAddtxt.setBounds(104, 508, 316, 19);
		contentPane.add(RelAddtxt);
		
		JLabel RelPhone = new JLabel("Phone Number :");
		RelPhone.setBounds(449, 511, 118, 13);
		contentPane.add(RelPhone);
		
		RelPhonetxt = new JTextField();
		RelPhonetxt.setColumns(10);
		RelPhonetxt.setBounds(550, 508, 195, 19);
		contentPane.add(RelPhonetxt);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.BLACK));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(28, 350, 757, 89);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("RELEASE OF INFORMATION");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(28, 558, 215, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("I hereby give permission to the person(s) listed below to receive information about the care of the above named patient.");
		lblNewLabel_2.setBounds(28, 597, 717, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel FormName = new JLabel("Name(s) :");
		FormName.setBounds(28, 631, 118, 13);
		contentPane.add(FormName);
		
		FormNametxt = new JTextField();
		FormNametxt.setColumns(10);
		FormNametxt.setBounds(84, 628, 141, 19);
		contentPane.add(FormNametxt);
		
		JLabel FormRel = new JLabel("Relationship to Patient :");
		FormRel.setBounds(289, 631, 145, 13);
		contentPane.add(FormRel);
		
		FormReltxt = new JTextField();
		FormReltxt.setColumns(10);
		FormReltxt.setBounds(436, 628, 131, 19);
		contentPane.add(FormReltxt);
		
		JLabel lblPatientparentOrGuardian = new JLabel("Patient/Parent or Guardian Signature :");
		lblPatientparentOrGuardian.setBounds(28, 713, 232, 13);
		contentPane.add(lblPatientparentOrGuardian);
		
		JLabel Date = new JLabel("Date :");
		Date.setBounds(561, 713, 118, 13);
		contentPane.add(Date);
		
		
		JLabel lblNewLabel_3 = new JLabel("PATIENT INFORMATION :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(28, 155, 339, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("HEALTH CARE");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.BLUE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3_1.setBounds(299, 21, 220, 29);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNhBailey = new JLabel("NH 30, Bailey Rd, MLA Colony.");
		lblNhBailey.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNhBailey.setBounds(329, 50, 169, 13);
		contentPane.add(lblNhBailey);
		
		JLabel lblPatnaBihar = new JLabel("Raja Bazar, Indrapuri");
		lblPatnaBihar.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPatnaBihar.setBounds(349, 65, 118, 13);
		contentPane.add(lblPatnaBihar);
		
		final JLabel Idlb = new JLabel(u);
		Idlb.setFont(new Font("Tahoma", Font.BOLD, 15));
		Idlb.setBounds(687, 155, 89, 29);
		contentPane.add(Idlb);
		
		JLabel lblNhBailey_1 = new JLabel("Patna, Bihar 800014.");
		lblNhBailey_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNhBailey_1.setBounds(352, 81, 129, 13);
		contentPane.add(lblNhBailey_1);
		
		final JButton Submit = new JButton("Submit");
		
		
		Submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
						
				
				String first = Firsttxt.getText();
				String middle = Middletxt.getText();
				String last = Lasttxt.getText();
				long phone;
				long relphone;
				
				try {
					phone = Long.parseLong(Phonetxt.getText());
					relphone = Long.parseLong(RelPhonetxt.getText());	
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(Submit,"Enter Valid Phone Number");
					return;
				}
				
				if(Long.toString(phone).length()!=10 || Long.toString(relphone).length()!=10)
				{
					JOptionPane.showMessageDialog(Submit,"Enter Valid Phone Number");
					return;
					
				}
				
				String email = Emailtxt.getText();
				email = email.toLowerCase();
				String add = Addtxt.getText();
				String city = Citytxt.getText();
				String state = Statetxt.getText();
				long pincode;
				try {
					pincode = Long.parseLong(PinCodetxt.getText());
					if(PinCodetxt.getText().length()!=6)
					{
						JOptionPane.showMessageDialog(Submit,"Enter Valid PinCode");
						return;
						
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(Submit,"Enter Valid PinCode");
					return;
				}
				
				
				
				String dob = Dobtxt.getText();
				int age;
				try {
					age = Integer.parseInt(Agetxt.getText());
					
				}
				
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(Submit,"Enter Valid Age");
					return;
					
				}
				String sex = Sextxt.getText();
				String emergency = Emergencytxt.getText();
				String relation = Relationtxt.getText();
				String reladd = RelAddtxt.getText();
				
				String formname = FormNametxt.getText();
				String formrel = FormReltxt.getText();
				String date = Datetxt.getText();
				
				
				
				if(first.length()==0 ||last.length()==0 ||email.length()==0||add.length()==0
						||city.length()==0||state.length()==0||state.length()==0||dob.length()==0||age<1||sex.length()==0
						||relation.length()==0||reladd.length()==0||formname.length()==0||formrel.length()==0||date.length()==0)
				{
					JOptionPane.showMessageDialog(Submit,"Enter All details");
					return;
				}
					

				
				try
				{
					
					myStmt.executeUpdate("insert into PatientInformation(UserId,FirstName,MiddleName,LastName,PhoneNumber,"
							+"EmailId,Address,City,State,PinCode,DOB,Age,Sex,EmergencyContact,Relationship,"
							+"RelAdd,RelPhone,FormName,FormRel,Dat) values ('"+u+"','"+first+"','"+middle+"','"+last+"',"+phone+","
									+ "'"+email+"','"+add+"','"+city+"','"+state+"',"+pincode+",'"+dob+"',"+age+",'"+sex+"',"
											+ "'"+emergency+"','"+relation+"','"+reladd+"',"+relphone+",'"+formname+"',"
													+ "'"+formrel+"','"+date+"')");
					
					myStmt.executeUpdate("Update PatientRegistration set Stat = 'filled' where UserId = '"+u+"'");
					
					JOptionPane.showMessageDialog(Submit,"Data Filled Successfully");
					
					Patient p = new Patient(u);
					p.setVisible(true);
					setVisible(false);
					
					
					
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		Submit.setBounds(329, 744, 118, 36);
		contentPane.add(Submit);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(28, 455, 757, 92);
		contentPane.add(panel_4);
		
		JLabel PatientId = new JLabel("PATIENT Id :");
		PatientId.setFont(new Font("Tahoma", Font.BOLD, 18));
		PatientId.setBounds(561, 155, 131, 29);
		contentPane.add(PatientId);
		
		
		Datetxt = new JTextField();
		Datetxt.setColumns(10);
		Datetxt.setBounds(614, 710, 131, 19);
		contentPane.add(Datetxt);
		Calendar cal = new GregorianCalendar();
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		Datetxt.setText(day + " / " + (month + 1) + " / " + year);
		Datetxt.setEditable(false);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App p = new App();
				p.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 21, 69, 21);
		contentPane.add(btnNewButton);
	}
}
