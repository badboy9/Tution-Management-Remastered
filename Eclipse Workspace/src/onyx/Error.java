package onyx;
import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings("serial")
public class Error extends JDialog implements ActionListener
{
	private JFrame parent;
	public Error(JFrame a,Boolean bm,int code) {
		super(a,bm);
		parent=a;
		setLayout(null);
		String s=errorDescription(code);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 350, 196);
		add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("Continue");
		button.addActionListener(this);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		button.setBorder(null);
		button.setBackground(new Color(0, 51, 102));
		button.setBounds(125, 120, 100, 40);
		panel.add(button);
		
		JLabel lbl2 = new JLabel(""+s);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lbl2.setBounds(0, 65, 350, 30);
		panel.add(lbl2);
		
		JLabel lbl1 = new JLabel("Error Code: "+code);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lbl1.setBounds(100, 30, 150, 30);
		panel.add(lbl1);
		
		setUndecorated(true);
		setSize(350,196);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		parent.setVisible(true);
		dispose();
	}
	
	private String errorDescription(int code)
	{
		String s="";
		try{
			FileInputStream fis=new FileInputStream("Assets\\errorList.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			@SuppressWarnings({ "rawtypes", "unchecked" })
			Hashtable<Integer,String> hs=(Hashtable)ois.readObject();
			s=hs.get(code);
			
			fis.close();
			ois.close();
		}
		catch(Exception e){}
			return s;
	}
	
	public static void main(String args[])
	{
		@SuppressWarnings("unused")
		Error obj=new Error(null,true,4);	
	}
}
