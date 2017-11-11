import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import emerald.AForm;
import emerald.Login;
import emerald.PForm;
import emerald.RForm;
import emerald.RSearch;
import emerald.PSearch;

@SuppressWarnings("serial")
public class HomeScreen extends JFrame implements ActionListener
{
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btnExit;
	

	public HomeScreen() {
		super();
		
		setLayout(null);
		
		JPanel pan1 = new JPanel();
		pan1.setBackground(new Color(255, 255, 255));
		pan1.setBounds(0, 0, 1100, 600);
		add(pan1);
		pan1.setLayout(null);
		
		btn1 = new JButton("Add Profile");
		btn1.addActionListener(this);
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setBackground(new Color(0, 51, 102));
		btn1.setBorder(null);
		btn1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		btn1.setBounds(100, 120, 220, 100);
		pan1.add(btn1);
		
		btn2 = new JButton("Search Profile");
		btn2.setForeground(new Color(255, 255, 255));
		btn2.addActionListener(this);
		btn2.setBackground(new Color(0, 51, 102));
		btn2.setBorder(null);
		btn2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		btn2.setBounds(100, 310, 220, 100);
		pan1.add(btn2);
		
		btn3 = new JButton("Make Payment");
		btn3.addActionListener(this);
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setBackground(new Color(0, 51, 102));
		btn3.setBorder(null);
		btn3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		btn3.setBounds(420, 120, 220, 100);
		pan1.add(btn3);
		
		btn4 = new JButton("Search Payment");
		btn4.addActionListener(this);
		btn4.setForeground(new Color(255, 255, 255));
		btn4.setBackground(new Color(0, 51, 102));
		btn4.setBorder(null);
		btn4.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		btn4.setBounds(420, 310, 220, 100);
		pan1.add(btn4);
		
		btn5 = new JButton("Administrator");
		btn5.addActionListener(this);
		btn5.setForeground(new Color(255, 255, 255));
		btn5.setBackground(new Color(0, 51, 102));
		btn5.setBorder(null);
		btn5.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		btn5.setBounds(740, 120, 220, 100);
		pan1.add(btn5);
		
		btn6 = new JButton("Contact Me");
		btn6.addActionListener(this);
		btn6.setForeground(new Color(255, 255, 255));
		btn6.setBackground(new Color(0, 51, 102));
		btn6.setBorder(null);
		btn6.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		btn6.setBounds(740, 310, 220, 100);
		pan1.add(btn6);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		btnExit.setBorder(null);
		btnExit.setBackground(new Color(153, 0, 51));
		btnExit.setBounds(440, 505, 180, 70);
		pan1.add(btnExit);
		
		JPanel pan2 = new JPanel();
		pan2.setForeground(new Color(255, 255, 255));
		pan2.setBackground(new Color(0, 51, 102));
		pan2.setBounds(1100, 0, 100, 675);
		add(pan2);
		pan2.setLayout(null);
		
		JLabel lblH = new JLabel("H");
		lblH.setForeground(new Color(255, 255, 255));
		lblH.setBounds(0, 150, 100, 80);
		pan2.add(lblH);
		lblH.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 90));
		lblH.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblO = new JLabel("O");
		lblO.setForeground(new Color(255, 255, 255));
		lblO.setHorizontalAlignment(SwingConstants.CENTER);
		lblO.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 90));
		lblO.setBounds(0, 240, 100, 80);
		pan2.add(lblO);
		
		JLabel lblM = new JLabel("M");
		lblM.setForeground(new Color(255, 255, 255));
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 90));
		lblM.setBounds(0, 330, 100, 80);
		pan2.add(lblM);
		
		JLabel lblE = new JLabel("E");
		lblE.setForeground(new Color(255, 255, 255));
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 90));
		lblE.setBounds(0, 420, 100, 80);
		pan2.add(lblE);
		
		JPanel pan3 = new JPanel();
		pan3.setBounds(0, 600, 1100, 75);
		add(pan3);
		pan3.setLayout(null);
		
		JLabel lbl1 = new JLabel("Developed by");
		lbl1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lbl1.setBounds(30, 13, 123, 30);
		pan3.add(lbl1);
		
		JLabel lbl2 = new JLabel("Bhushan A Deshmukh");
		lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lbl2.setBounds(153, 22, 300, 40);
		pan3.add(lbl2);
		
		setUndecorated(true);
		setSize(1200,675);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton btn=(JButton)e.getSource();
		if(btn==btn1)
		{
			@SuppressWarnings("unused")
			RForm obj1=new RForm(this,true);
		}
		if(btn==btn2)
		{
			@SuppressWarnings("unused")
			RSearch obj2=new RSearch(this,true);
		}
		if(btn==btn3)
		{
			@SuppressWarnings("unused")
			PForm obj3=new PForm(this,true);
		}
		if(btn==btn4)
		{
			@SuppressWarnings("unused")
			PSearch obj4=new PSearch(this,true);
		}
		if(btn==btn5)
		{
			@SuppressWarnings("unused")
			AForm obj5=new AForm(this, true);
		}
		if(btn==btn6)
		{
			
		}
		if(btn==btnExit)
		{
			System.exit(0);
		}
	}
	public static void main(String []args)
	{
		/*
		java.sql.Date dt1,dt2;
		try
		{
			FileInputStream fis=new FileInputStream("Assets\\gem.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			dt2=(java.sql.Date)ois.readObject();
			ois.close();
			fis.close();
			dt1=new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			
			System.out.println(""+dt1+"   "+dt2);
			SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
			File f=new File("Assets/error.bat");
			
			if(f.exists()==false)
		       {
				
		    	   System.exit(0);
		       }
			
			if(dt1.after(dt2)==true)	
			{
				System.out.println("System Expired");
				try	
				{
				//	Desktop.getDesktop().open(f);
				}
			       catch(Exception e){e.printStackTrace();}
			
			}
		}
		catch(Exception e1){e1.printStackTrace();}	
		System.out.println("Hello");
		*/
		HomeScreen obj=new HomeScreen();
		@SuppressWarnings("unused")
		Login object=new Login(obj,true);
	}
}
