package emerald;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import sapphire.ExtractDB;
import topaz.Student;



@SuppressWarnings("serial")
public class Profile extends JDialog implements ActionListener{

	private Student sobj;
	private JDialog parent;
	private HashMap<Integer,String> hscl;
	private HashMap<Integer,String> hsub;
	private ExtractDB ext;
	private JButton bback;
	
	public Profile(JDialog a,Boolean bm,int sid) {
		
		super(a,bm);
		
		parent=a;
		hscl=new HashMap<Integer,String>();
		hscl.put(1,"Mount Carmel");
				hscl.put(2,"Carmel Academy");
				hscl.put(3,"Vidya Niketan");
				hscl.put(4,"St Michael School");
				hscl.put(5,"Other");

		hsub=new HashMap<Integer,String>();
		hsub.put(1,"Maths");
		hsub.put(3,"Science");
		hsub.put(4,"Maths - Science");
		
		ext=new ExtractDB();
		parent=a;
		sobj=new Student();
		sobj.sid=sid;
		setLayout(null);
		try{
			ResultSet rs=ext.sidExtract(sobj);
			rs.next();
			sobj.sid=rs.getInt(1);
			sobj.fname=rs.getString(2);
			sobj.pname=rs.getString(3);
			sobj.lname=rs.getString(4);
			sobj.address=rs.getString(5);
			sobj.contact=rs.getString(6);
			sobj.gender=rs.getInt(7);
			sobj.school=rs.getInt(8);
			sobj.std=rs.getInt(9);
			sobj.subject=rs.getInt(10);
			sobj.doa=rs.getDate(11);
			sobj.months=rs.getInt(12);
			sobj.ramount=rs.getInt(13);
		}
		catch(Exception e){}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1100, 675);
		add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("Contact No.");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setOpaque(true);
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		label_1.setBackground(new Color(0, 51, 102));
		label_1.setBounds(200, 230, 120, 45);
		panel.add(label_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setOpaque(true);
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblName.setBackground(new Color(0, 51, 102));
		lblName.setBounds(200, 170, 120, 45);
		panel.add(lblName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setOpaque(true);
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblGender.setBackground(new Color(0, 51, 102));
		lblGender.setBounds(200, 290, 120, 45);
		panel.add(lblGender);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setOpaque(true);
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAddress.setBackground(new Color(0, 51, 102));
		lblAddress.setBounds(200, 530, 120, 120);
		panel.add(lblAddress);
		
		JLabel tnm = new JLabel(""+sobj.fname+" "+sobj.pname+" "+sobj.lname);
		tnm.setHorizontalAlignment(SwingConstants.LEFT);
		tnm.setFont(new Font("Century Gothic", Font.BOLD, 18));
		tnm.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 51, 102)));
		tnm.setOpaque(true);
		tnm.setBackground(new Color(255, 255, 255));
		tnm.setBounds(340, 170, 300, 45);
		panel.add(tnm);
		
		JLabel tcon = new JLabel(""+sobj.contact);
		tcon.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tcon.setHorizontalAlignment(SwingConstants.LEFT);
		tcon.setOpaque(true);
		tcon.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 51, 102)));
		tcon.setBackground(Color.WHITE);
		tcon.setBounds(340, 230, 150, 45);
		panel.add(tcon);
		
		
		JLabel tgen = new JLabel(""+(sobj.gender==1?"Male":"Female"));
		tgen.setHorizontalAlignment(SwingConstants.LEFT);
		tgen.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tgen.setOpaque(true);
		tgen.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 51, 102)));
		tgen.setBackground(Color.WHITE);
		tgen.setBounds(340, 290, 80, 45);
		panel.add(tgen);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setOpaque(true);
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setForeground(Color.WHITE);
		lblStudentId.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblStudentId.setBackground(new Color(0, 51, 102));
		lblStudentId.setBounds(200, 110, 120, 45);
		panel.add(lblStudentId);
		
		JLabel tsid = new JLabel(""+sobj.sid);
		tsid.setOpaque(true);
		tsid.setHorizontalAlignment(SwingConstants.LEFT);
		tsid.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tsid.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 51, 102)));
		tsid.setBackground(Color.WHITE);
		tsid.setBounds(340, 110, 80, 45);
		panel.add(tsid);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 51, 102)));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(320, 530, 20, 120);
		panel.add(lblNewLabel_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setOpaque(true);
		label_4.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 51, 102)));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(320, 290, 20, 45);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setOpaque(true);
		label_5.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 51, 102)));
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(320, 230, 20, 45);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setOpaque(true);
		label_6.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 51, 102)));
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(320, 170, 20, 45);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setOpaque(true);
		label_7.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 51, 102)));
		label_7.setBackground(Color.WHITE);
		label_7.setBounds(320, 110, 20, 45);
		panel.add(label_7);
		
		JLabel lblStd = new JLabel("Subjects");
		lblStd.setBounds(440, 410, 120, 45);
		panel.add(lblStd);
		lblStd.setOpaque(true);
		lblStd.setHorizontalAlignment(SwingConstants.CENTER);
		lblStd.setForeground(Color.WHITE);
		lblStd.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblStd.setBackground(new Color(0, 51, 102));
		
		JLabel tsub = new JLabel(""+hsub.get(sobj.subject));
		tsub.setBounds(580, 410, 160, 45);
		panel.add(tsub);
		tsub.setOpaque(true);
		tsub.setHorizontalAlignment(SwingConstants.LEFT);
		tsub.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tsub.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 51, 102)));
		tsub.setBackground(Color.WHITE);
		
		JLabel lblDate = new JLabel("date");
		lblDate.setOpaque(true);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblDate.setBackground(new Color(0, 51, 102));
		lblDate.setBounds(440, 110, 120, 45);
		panel.add(lblDate);
		
		JLabel lblSchool = new JLabel("School");
		lblSchool.setBounds(200, 350, 120, 45);
		panel.add(lblSchool);
		lblSchool.setOpaque(true);
		lblSchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchool.setForeground(Color.WHITE);
		lblSchool.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblSchool.setBackground(new Color(0, 51, 102));
		
		JLabel tschool = new JLabel(""+hscl.get(sobj.school));
		tschool.setBounds(340, 350, 250, 45);
		panel.add(tschool);
		tschool.setOpaque(true);
		tschool.setHorizontalAlignment(SwingConstants.LEFT);
		tschool.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tschool.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 51, 102)));
		tschool.setBackground(Color.WHITE);
		
		JLabel lblSubject = new JLabel("Class");
		lblSubject.setBounds(200, 410, 120, 45);
		panel.add(lblSubject);
		lblSubject.setOpaque(true);
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setForeground(Color.WHITE);
		lblSubject.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblSubject.setBackground(new Color(0, 51, 102));
		
		JLabel tstd = new JLabel(""+(sobj.std==1?"IX":"X"));
		tstd.setBounds(340, 410, 87, 45);
		panel.add(tstd);
		tstd.setOpaque(true);
		tstd.setHorizontalAlignment(SwingConstants.LEFT);
		tstd.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tstd.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 51, 102)));
		tstd.setBackground(Color.WHITE);
		
		JLabel label_11 = new JLabel("");
		label_11.setOpaque(true);
		label_11.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 51, 102)));
		label_11.setBackground(Color.WHITE);
		label_11.setBounds(320, 350, 20, 45);
		panel.add(label_11);
		
		JLabel tdt = new JLabel(""+sobj.doa);
		tdt.setOpaque(true);
		tdt.setHorizontalAlignment(SwingConstants.LEFT);
		tdt.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tdt.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 51, 102)));
		tdt.setBackground(Color.WHITE);
		tdt.setBounds(580, 110, 120, 45);
		panel.add(tdt);
		
		JLabel label_13 = new JLabel("");
		label_13.setOpaque(true);
		label_13.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 51, 102)));
		label_13.setBackground(Color.WHITE);
		label_13.setBounds(560, 410, 20, 45);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setOpaque(true);
		label_14.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 51, 102)));
		label_14.setBackground(Color.WHITE);
		label_14.setBounds(320, 410, 20, 45);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setOpaque(true);
		label_15.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 51, 102)));
		label_15.setBackground(Color.WHITE);
		label_15.setBounds(560, 110, 20, 45);
		panel.add(label_15);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(192, 192, 192));
		lblNewLabel_2.setBounds(840, 50, 150, 180);
		panel.add(lblNewLabel_2);
		
		JLabel lblProfile = new JLabel("PROFILE");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setOpaque(true);
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 22));
		lblProfile.setBackground(new Color(0, 51, 102));
		lblProfile.setBounds(200, 25, 540, 50);
		panel.add(lblProfile);
		
		JTextArea taddr = new JTextArea(""+sobj.address);
		taddr.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		taddr.setEditable(false);
		taddr.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 51, 102)));
		taddr.setBounds(340, 530, 250, 120);
		panel.add(taddr);
		
		bback = new JButton("Back");
		bback.addActionListener(this);
		bback.setForeground(Color.WHITE);
		bback.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		bback.setBorder(null);
		bback.setBackground(new Color(0, 51, 102));
		bback.setBounds(840, 600, 140, 50);
		panel.add(bback);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setOpaque(true);
		lblFees.setHorizontalAlignment(SwingConstants.CENTER);
		lblFees.setForeground(Color.WHITE);
		lblFees.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblFees.setBackground(new Color(0, 51, 102));
		lblFees.setBounds(200, 470, 120, 45);
		panel.add(lblFees);
		
		JLabel tfee = new JLabel(""+sobj.ramount);
		tfee.setOpaque(true);
		tfee.setHorizontalAlignment(SwingConstants.LEFT);
		tfee.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tfee.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 51, 102)));
		tfee.setBackground(Color.WHITE);
		tfee.setBounds(340, 470, 87, 45);
		panel.add(tfee);
		
		JLabel label_9 = new JLabel("");
		label_9.setOpaque(true);
		label_9.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 51, 102)));
		label_9.setBackground(Color.WHITE);
		label_9.setBounds(320, 470, 20, 45);
		panel.add(label_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(1100, 0, 100, 675);
		add(panel_1);
		panel_1.setLayout(null);
		
		setUndecorated(true);
		parent.setVisible(false);
		setSize(1200,675);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
		ext.cClose();
		}
		catch(Exception e1){ }
		dispose();
		parent.setVisible(true);
	}
}
