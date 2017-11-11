package emerald;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import com.toedter.calendar.JDateChooser;

import topaz.payment;
import sapphire.ExtractDB;
import sapphire.InsertDB;
import sapphire.UpdateDB;

@SuppressWarnings("serial")
public class PForm extends JDialog implements ActionListener, FocusListener{
	private JTextField tsid;
	private JTextField tamt;
	private JButton bhome,bpay;
	private JLabel lpid,lerror,tname;
	private JDateChooser dateChooser;
	private int id1,id2;
	private payment pobj;
	private InsertDB ins;
	private ExtractDB ext;
	private UpdateDB updt;
	private JFrame parent;
	
	public PForm(JFrame a,Boolean bm) 
	{
		super(a,bm);
		parent=a;
		try
		{
			FileInputStream fis=new FileInputStream("Assets\\Index.dat");
			DataInputStream dis=new DataInputStream(fis);
			id1=dis.readInt();
			id2=dis.readInt();
			dis.close();
			fis.close();	
		}
		catch(Exception e){}
		pobj=new payment();
		ins=new InsertDB();
		ext=new ExtractDB();
		updt=new UpdateDB();
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 660, 500);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.BLACK);
		lblDate.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblDate.setBackground(Color.WHITE);
		lblDate.setBounds(60, 350, 115, 45);
		panel.add(lblDate);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setForeground(Color.BLACK);
		lblAmount.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblAmount.setBackground(Color.WHITE);
		lblAmount.setBounds(60, 290, 115, 45);
		panel.add(lblAmount);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(60, 230, 115, 45);
		panel.add(lblName);
		
		JLabel label_3 = new JLabel("Student ID");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 20));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(60, 170, 115, 45);
		panel.add(label_3);
		
		JLabel lblPaymentId = new JLabel("Payment ID");
		lblPaymentId.setForeground(Color.BLACK);
		lblPaymentId.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPaymentId.setBackground(Color.WHITE);
		lblPaymentId.setBounds(60, 110, 115, 45);
		panel.add(lblPaymentId);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 102));
		panel_1.setBounds(660, 0, 100, 500);
		add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(185, 215, 80, 5);
		panel.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(185, 336, 100, 5);
		panel.add(separator_2);
		
		JLabel lblPayment = new JLabel("PAYMENT");
		lblPayment.setOpaque(true);
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setForeground(Color.WHITE);
		lblPayment.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 22));
		lblPayment.setBackground(new Color(0, 51, 102));
		lblPayment.setBounds(50, 41, 500, 50);
		panel.add(lblPayment);
		
		lerror= new JLabel("Do Not leave the FIelds Empty");
		lerror.setOpaque(true);
		lerror.setHorizontalAlignment(SwingConstants.CENTER);
		lerror.setForeground(new Color(153, 0, 51));
		lerror.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lerror.setBorder(null);
		lerror.setBackground(Color.WHITE);
		lerror.setBounds(190, 450, 280, 30);
		lerror.setVisible(false);
		panel.add(lerror);
		
		tsid = new JTextField();
		tsid.addFocusListener(this);
		tsid.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tsid.setBorder(null);
		tsid.setBounds(185, 180, 80, 30);
		panel.add(tsid);
		tsid.setColumns(10);
		
		tname = new JLabel();
		tname.setOpaque(true);
		tname.setHorizontalAlignment(SwingConstants.LEFT);
		tname.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tname.setBorder(null);
		tname.setBackground(Color.WHITE);
		tname.setBounds(185, 240, 250, 30);
		panel.add(tname);
		
		tamt = new JTextField();
		tamt.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tamt.addFocusListener(this);
		tamt.setBorder(null);
		tamt.setColumns(10);
		tamt.setBounds(185, 300, 100, 30);
		panel.add(tamt);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(185, 360, 130, 30);
		dateChooser.setDate(new java.util.Date());
		panel.add(dateChooser);
		
		lpid = new JLabel(""+id2);
		lpid.setOpaque(true);
		lpid.setHorizontalAlignment(SwingConstants.LEFT);
		lpid.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lpid.setBorder(null);
		lpid.setBackground(Color.WHITE);
		lpid.setBounds(185, 120, 80, 30);
		panel.add(lpid);
		
		bpay = new JButton("Pay");
		bpay.addActionListener(this);
		bpay.setForeground(Color.WHITE);
		bpay.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		bpay.setBorder(null);
		bpay.setBackground(new Color(0, 51, 102));
		bpay.setBounds(260, 405, 140, 40);
		panel.add(bpay);
		
		bhome = new JButton(new ImageIcon("Assets//Home.jpg"));
		bhome.addActionListener(this);
		bhome.setBorder(null);
		bhome.setBounds(5, 215, 90, 70);
		panel_1.add(bhome);

		setUndecorated(true);
		setSize(760,500);
		parent.setVisible(false);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton btn=(JButton)e.getSource();
		if(btn==bhome)
		{
			try{
				ins.cClose();
				updt.cClose();
				ext.cClose();
			}
			catch(Exception e1){}
			parent.setVisible(true);
			dispose();
		}
		if(btn==bpay)
		{
			if(isEmpty()==true)
			{
				lerror.setVisible(true);
				return;
			}
			lerror.setVisible(false);
			if(add2Object()==true)
			{
				if(pay(pobj)==false)
					return;
				try{ins.pAdd(pobj);}
				catch(Exception e1)
				{JOptionPane.showMessageDialog(null,""+e1,"Error in Insertion",JOptionPane.ERROR_MESSAGE);return;}
				
				id2=id2+1;
				try
				{
					FileOutputStream fos=new FileOutputStream("Assets\\Index.dat");
					DataOutputStream dos=new DataOutputStream(fos);
					
					dos.writeInt(id1);
					dos.writeInt(id2);
					fos.close();
					dos.close();
				}
				catch(Exception e1){}
				clear();
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
			if(tb==tsid)
			{
				int id=0;
				String nm="Wrong ID";
				try{
					id=Integer.parseInt(tsid.getText());
				}
				catch(Exception e1)
				{
					tsid.setText("");
					tsid.requestFocus();
					return;
				}
				try{
					
					nm=ext.nmExtract(id);
					
				}
				catch(Exception e1){}
				tname.setText(nm);
				
			}
			if(tb==tamt)
			{
				try{
					Long.parseLong(tamt.getText());
				}
				catch(Exception e1)
				{
					tamt.setText("");
					tamt.requestFocus();
					return;
				}
			}
		}
		catch(Exception ee){}
	}
	
	public Boolean isEmpty()
	{
		int flg=0;
		if(tsid.getText().trim().isEmpty())
		{
			flg=1;
		}
		else if(tamt.getText().trim().isEmpty())
		{
			flg=1;
		}
		else if(dateChooser.getDate()==null)
		{
			flg=1;
		}
		else if(lpid.getText().trim().isEmpty())
		{
			flg=1;
		}
		else if(tname.getText().trim().equals("Wrong ID"))
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
			pobj.pid=Integer.parseInt(lpid.getText().trim());
			pobj.sid=Integer.parseInt(tsid.getText());
			pobj.dop=new java.sql.Date(dateChooser.getDate().getTime());
			pobj.pamount=Integer.parseInt(tamt.getText().trim());
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public void clear()
	{
		tamt.setText("");
		tsid.setText("");
		lpid.setText(""+id2);
		tname.setText("");
		dateChooser.setDate(new java.util.Date());
	}
	public Boolean pay(payment pobj)
	{	
		try{
			int amt=ext.amtExtract(pobj.sid);
			amt=amt-pobj.pamount;
			updt.pay(pobj,amt);
		}
		catch(Exception e){JOptionPane.showMessageDialog(null,""+e,"Error in Insertion",JOptionPane.ERROR_MESSAGE);return false;}
		return true;
	}
}
