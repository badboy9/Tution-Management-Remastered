package emerald;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.border.MatteBorder;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import sapphire.ExtractDB;
import sapphire.InsertDB;
import sapphire.UpdateDB;
import topaz.Student;

public class MForm extends JDialog implements ActionListener, FocusListener, ItemListener {
	private static final long serialVersionUID = 1L;
	private JTextField tfname;
	private JTextField tpname;
	private JTextField tlname;
	private JTextField tcontact;
	private JTextArea taddress;
	private Checkbox []ccs;
	private Checkbox []cgen;
	private CheckboxGroup cgcs,cggen;
	private Choice school;
	private JDateChooser dateChooser;
	private JButton bhome,bmod;
	private JDialog parent;
	private JLabel lerr,lsid;
	@SuppressWarnings("unused")
	private Student sobj;
	private int math,sci,id2;
	private ExtractDB ext;
	private UpdateDB updt;
	private HashMap<Integer,String> hsub;
	
	public MForm(JDialog a,Boolean bm, int sid)
	{
		super(a,bm);
		parent=a;
		hsub=new HashMap<Integer,String>();
		hsub.put(1,"Maths");
		hsub.put(3,"Science");
		hsub.put(4,"Maths - Science");
		sobj=new Student();
		updt=new UpdateDB();
		ext=new ExtractDB();
		sobj.sid=sid;
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
		
		
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 550, 675);
		add(panel);
		panel.setLayout(null);
		
		JLabel lbla = new JLabel("First");
		lbla.setHorizontalAlignment(SwingConstants.CENTER);
		lbla.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lbla.setBounds(155, 190, 120, 30);
		panel.add(lbla);
		
		JLabel lblb = new JLabel("Middle");
		lblb.setHorizontalAlignment(SwingConstants.CENTER);
		lblb.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblb.setBounds(278, 190, 120, 30);
		panel.add(lblb);
		
		JLabel lblc = new JLabel("Last");
		lblc.setHorizontalAlignment(SwingConstants.CENTER);
		lblc.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblc.setBounds(399, 190, 120, 30);
		panel.add(lblc);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(140, 255, 120, 10);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(270, 255, 120, 10);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBounds(400, 255, 120, 12);
		panel.add(separator_2);
		
		JLabel lbl3 = new JLabel("Contact No.");
		lbl3.setBackground(new Color(255, 255, 255));
		lbl3.setForeground(new Color(0, 0, 0));
		lbl3.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbl3.setBounds(60, 290, 125, 45);
		panel.add(lbl3);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 0, 0));
		separator_3.setBounds(190, 335, 185, 10);
		panel.add(separator_3);
		
		JLabel lbl1 = new JLabel("    I. PERSONAL DETAILS");
		lbl1.setOpaque(true);
		lbl1.setForeground(new Color(255, 255, 255));
		lbl1.setBackground(new Color(0, 51, 102));
		lbl1.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 22));
		lbl1.setBounds(50, 80, 460, 50);
		panel.add(lbl1);
		
		JLabel lname = new JLabel("Name");
		lname.setHorizontalAlignment(SwingConstants.CENTER);
		lname.setForeground(new Color(0, 0, 0));
		lname.setBorder(null);
		lname.setBackground(new Color(255, 255, 255));
		lname.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lname.setBounds(60, 210, 70, 45);
		panel.add(lname);
		
		JLabel lbl4 = new JLabel("Gender");
		lbl4.setForeground(new Color(0, 0, 0));
		lbl4.setBackground(new Color(255, 255, 255));
		lbl4.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbl4.setBounds(60, 370, 125, 45);
		panel.add(lbl4);
		
		JLabel lbl5 = new JLabel("Address");
		lbl5.setForeground(new Color(0, 0, 0));
		lbl5.setBackground(new Color(255, 255, 255));
		lbl5.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbl5.setBounds(60, 450, 125, 50);
		panel.add(lbl5);
		
		JLabel lbl0 = new JLabel("+91");
		lbl0.setOpaque(true);
		lbl0.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lbl0.setBounds(190, 300, 35, 30);
		panel.add(lbl0);
		
		JPanel pan = new JPanel();
		pan.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pan.setBackground(new Color(255, 255, 255));
		pan.setBounds(550, 0, 550, 675);
		add(pan);
		pan.setLayout(null);
		
		JLabel lbl6 = new JLabel("   II. ACADEMIC DETAILS");
		lbl6.setOpaque(true);
		lbl6.setForeground(Color.WHITE);
		lbl6.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 22));
		lbl6.setBackground(new Color(0, 51, 102));
		lbl6.setBounds(50, 80, 460, 50);
		pan.add(lbl6);
		
		JLabel lbl8 = new JLabel("Class");
		lbl8.setForeground(Color.BLACK);
		lbl8.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbl8.setBackground(Color.WHITE);
		lbl8.setBounds(60, 260, 110, 45);
		pan.add(lbl8);
		
		JLabel lbl9 = new JLabel("Subject");
		lbl9.setForeground(Color.BLACK);
		lbl9.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbl9.setBackground(Color.WHITE);
		lbl9.setBounds(60, 320, 110, 45);
		pan.add(lbl9);
		
		JLabel lbl10 = new JLabel("School");
		lbl10.setForeground(Color.BLACK);
		lbl10.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbl10.setBackground(Color.WHITE);
		lbl10.setBounds(60, 390, 110, 45);
		pan.add(lbl10);
		
		JLabel lbl11 = new JLabel("Date");
		lbl11.setForeground(Color.BLACK);
		lbl11.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbl11.setBackground(Color.WHITE);
		lbl11.setBounds(60, 460, 110, 45);
		pan.add(lbl11);
		
		JLabel lbl7 = new JLabel("Student ID");
		lbl7.setForeground(Color.BLACK);
		lbl7.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbl7.setBackground(Color.WHITE);
		lbl7.setBounds(60, 200, 110, 45);
		pan.add(lbl7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 51, 102));
		panel_2.setBounds(1100, 0, 100, 675);
		add(panel_2);
		panel_2.setLayout(null);
		
		lsid = new JLabel(""+sid);
		lsid.setOpaque(true);
		lsid.setHorizontalAlignment(SwingConstants.LEFT);
		lsid.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lsid.setBorder(null);
		lsid.setBackground(Color.WHITE);
		lsid.setBounds(182, 210, 80, 30);
		pan.add(lsid);
		
		lerr = new JLabel("Do Not leave the FIelds Empty");
		lerr.setForeground(new Color(153, 0, 51));
		lerr.setOpaque(true);
		lerr.setHorizontalAlignment(SwingConstants.CENTER);
		lerr.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lerr.setBorder(null);
		lerr.setBackground(Color.WHITE);
		lerr.setBounds(135, 610, 280, 30);
		lerr.setVisible(false);
		pan.add(lerr);
		
		tfname = new JTextField(""+sobj.fname);
		tfname.addFocusListener(this);
		tfname.setBorder(null);
		tfname.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tfname.setBounds(140, 220, 120, 30);
		panel.add(tfname);
		tfname.setColumns(10);
		
		tpname = new JTextField(""+sobj.pname);
		tpname.addFocusListener(this);
		tpname.setBorder(null);
		tpname.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tpname.setColumns(10);
		tpname.setBounds(270, 220, 120, 30);
		panel.add(tpname);
		
		tlname = new JTextField(""+sobj.lname);
		tlname.addFocusListener(this);
		tlname.setBorder(null);
		tlname.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tlname.setColumns(10);
		tlname.setBounds(400, 220, 120, 30);
		panel.add(tlname);
		
		tcontact = new JTextField(""+sobj.contact);
		tcontact.addFocusListener(this);
		tcontact.setBorder(null);
		tcontact.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tcontact.setBounds(225, 300, 150, 30);
		panel.add(tcontact);
		tcontact.setColumns(10);
		
		taddress = new JTextArea(""+sobj.address);
		taddress.setWrapStyleWord(true);
		taddress.setLineWrap(true);
		taddress.addFocusListener(this);
		taddress.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		taddress.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		taddress.setBounds(190, 450, 250, 120);
		panel.add(taddress);
		
		cgen=new Checkbox[2];
		cggen=new CheckboxGroup();
		cgen[0] = new Checkbox("Male");
		cgen[0].addItemListener(this);
		cgen[0].setCheckboxGroup(cggen);
		cgen[0].setFont(new Font("Century Gothic", Font.PLAIN, 18));
		cgen[0].setBackground(new Color(255, 255, 255));
		cgen[0].setBounds(210, 370, 113, 45);
		panel.add(cgen[0]);
		cgen[1] = new Checkbox("Female");
		cgen[1].addItemListener(this);
		cgen[1].setCheckboxGroup(cggen);
		cgen[1].setFont(new Font("Century Gothic", Font.PLAIN, 18));
		cgen[1].setBackground(new Color(255, 255, 255));
		cgen[1].setBounds(330, 370, 110, 45);
		panel.add(cgen[1]);
		cgen[sobj.gender-1].setState(true);
		
		ccs=new Checkbox[2];
		cgcs=new CheckboxGroup();
		ccs[0] = new Checkbox("IX");
		ccs[0].addItemListener(this);
		ccs[0].setCheckboxGroup(cgcs);
		ccs[0].setFont(new Font("Century Gothic", Font.PLAIN, 18));
		ccs[0].setBackground(Color.WHITE);
		ccs[0].setBounds(190, 260, 60, 45);
		pan.add(ccs[0]);
		ccs[1] = new Checkbox("X");
		ccs[1].addItemListener(this);
		ccs[1].setCheckboxGroup(cgcs);
		ccs[1].setFont(new Font("Century Gothic", Font.PLAIN, 18));
		ccs[1].setBackground(Color.WHITE);
		ccs[1].setBounds(260, 260, 60, 45);
		pan.add(ccs[1]);
		ccs[sobj.std-1].setState(true);
		
		
		JLabel tsub = new JLabel(""+hsub.get(sobj.subject));
		tsub.setBounds(190, 320, 110, 45);
		pan.add(tsub);
		tsub.setOpaque(true);
		tsub.setHorizontalAlignment(SwingConstants.LEFT);
		tsub.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tsub.setBorder(null);
		tsub.setBackground(Color.WHITE);
		
		school = new Choice();
		school.addItemListener(this);
		school.add("Select school");
		school.add("1. Mount Carmel");
		school.add("2. Carmel Academy");
		school.add("3. Vidya Niketan");
		school.add("4. St. Michael School");
		school.add("Other");
		school.setBounds(190, 395, 250, 30);
		pan.add(school);
		school.select(sobj.school);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(190, 465, 130, 30);
		pan.add(dateChooser);
		dateChooser.setDate(sobj.doa);
		
		bmod = new JButton("Modify Profile");
		bmod.addActionListener(this);
		bmod.setForeground(new Color(255, 255, 255));
		bmod.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		bmod.setBackground(new Color(0, 51, 102));
		bmod.setBorder(null);
		bmod.setBounds(210, 550, 140, 50);
		pan.add(bmod);
		
		bhome = new JButton(new ImageIcon("Assets//Home.jpg"));													//add image to home button
		bhome.addActionListener(this);
		bhome.setBorder(null);
		bhome.setBounds(5, 300, 90, 70);
		panel_2.add(bhome);

		setUndecorated(true);
		parent.setVisible(false);
		setSize(1200,675);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		try
		{
			Checkbox cb=(Checkbox)e.getSource();
			
				if(cb==ccs[0])										//1=IX
				{
					sobj.std=1;
				}
				else if(cb==ccs[1])									//2=X
				{
					sobj.std=2;
				}
				else if(cb==cgen[0])								//1==Male
				{
					sobj.gender=1;
				}
				else if(cb==cgen[1])								//2=Female
				{
					sobj.gender=2;
				}
		}
		catch(Exception e1){}
		
		try{
			Choice ch=(Choice)e.getSource();
			if(ch==school)
			{
				if(ch.getSelectedIndex()==0)
				{
					return;
				}
				sobj.school=ch.getSelectedIndex();
			}
		}
		catch(Exception e1){}
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton btn=(JButton)e.getSource();
		if(btn==bhome)
		{
			try{
				updt.cClose();
			}
			catch(Exception e1){}
			parent.setVisible(true);
			dispose();
		}
		if(btn==bmod)
		{
			if(isEmpty()==true)
			{	
				lerr.setVisible(true);
				return;
			}
			lerr.setVisible(false);
			if(add2Object()==true)
			{
				System.out.println(" "+sobj.address+" "+sobj.contact+" "+sobj.fname+" "+sobj.pname+" "+sobj.lname+" "+sobj.gender+" "+sobj.school+" "+sobj.std+" "+sobj.subject+" "+sobj.sid+" "+sobj.doa+" "+sobj.months+" "+sobj.ramount);
				try{updt.allUp(sobj);}
				catch(Exception e1)
				{JOptionPane.showMessageDialog(null,"Alert"+e1,"Error in Insertion",JOptionPane.ERROR_MESSAGE);return;}
				
				//dispose();
			}
		}
	}
	public void focusGained(FocusEvent e)
	{
		
	}
	public void focusLost(FocusEvent e)
	{
		try
		{
		JTextField tb=(JTextField)e.getSource();
		if(tb==tcontact)
		{
			
			try{
				Long.parseLong(tcontact.getText());
			}
			catch(Exception e1)
			{
				tcontact.setText("");
				tcontact.requestFocus();
			}
		}
		}
		catch(Exception ee){}
	}
	
	public Boolean isEmpty()
	{
		int flg=0;
		if(tfname.getText().trim().isEmpty())
		{
			flg=1;tfname.requestFocus();
		}
		else if(tpname.getText().trim().isEmpty())
		{
			flg=1;tpname.requestFocus();
		}
		else if(tlname.getText().trim().isEmpty())
		{
			flg=1;tlname.requestFocus();
		}
		else if(tcontact.getText().trim().isEmpty())
		{
			flg=1;tcontact.requestFocus();
		}
		else if(tcontact.getText().length()!=10)
		{
			System.out.println("hello");
			flg=1;tcontact.setText("");tcontact.requestFocus();
		}
		else if(taddress.getText().trim().isEmpty())
		{
			flg=1;taddress.requestFocus();
		}	
		else if(lsid.getText().trim().isEmpty())
		{
			flg=1;
		}
		else if(dateChooser.getDate()==null)
		{
			flg=1;
		}
		
		if(flg==1)
			return true;
		else
			return false;
	}
	
	public Boolean add2Object()
	{
		try
		{
			sobj.sid=Integer.parseInt(lsid.getText());
			sobj.fname=tfname.getText().trim();
			sobj.pname=tpname.getText().trim();
			sobj.lname=tlname.getText().trim();
			sobj.contact=tcontact.getText();
			sobj.address=taddress.getText().trim();
			sobj.doa=new java.sql.Date(dateChooser.getDate().getTime());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public static void main(String []args)
	{
		MForm obj=new MForm(null,true,101);
	}
}
