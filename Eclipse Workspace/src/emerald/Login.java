package emerald;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class Login extends JDialog implements ActionListener
{
	private JPanel panel_1;
	private JTextField textField,passwordField;
	private JButton btnX,btnContinue;
	private JFrame parent;
	private JLabel lblerror;
	public Login(JFrame a,Boolean bm) 
	{
		super(a,bm);
		parent=a;
		setLayout(null);
		Border myborder = BorderFactory.createMatteBorder(0, 1, 0, 0, Color.black);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 675);
		add(panel);
		panel.setLayout(null);
		
			ImageIcon ico=new ImageIcon("Assets\\Login2.jpg");
			JLabel lblimg = new JLabel(ico);
			lblimg.setOpaque(true);
			lblimg.setBounds(0, 0, 600, 675);
			panel.add(lblimg);
			ico.getImage();
			
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(36,47,65));
		panel_1.setBounds(600, 0, 600, 675);
		panel_1.setBorder(myborder);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Century Gothic", Font.PLAIN, 32));
		lblLogin.setBounds(175, 119, 200, 50);
		panel_1.add(lblLogin);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setForeground(new Color(220, 220, 220));
		lblUsername.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(75, 225, 120, 50);
		panel_1.add(lblUsername);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(75, 305, 300, 2);
		panel_1.add(separator);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(220, 220, 220));
		lblPassword.setBackground(new Color(220, 220, 220));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPassword.setBounds(75, 305, 120, 50);
		panel_1.add(lblPassword);
		
		lblerror = new JLabel("Invalid User Details");
		lblerror.setHorizontalAlignment(SwingConstants.CENTER);
		lblerror.setForeground(new Color(220, 220, 220));
		lblerror.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblerror.setBackground(new Color(220, 220, 220));
		lblerror.setBounds(175, 528, 200, 50);
		lblerror.setVisible(false);
		panel_1.add(lblerror);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(75, 385, 300, 2);
		panel_1.add(separator_1);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(36,47,65));
		textField.setBounds(75, 270, 300, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(36,47,65));
		passwordField.setBounds(75, 350, 300, 30);
		panel_1.add(passwordField);
		
		btnContinue = new JButton("Continue");
		btnContinue.setForeground(Color.WHITE);
		btnContinue.setFont(new Font("Century Gothic", Font.PLAIN, 18));;
		btnContinue.setBounds(200, 467, 150, 50);	
		btnContinue.setBackground(new Color(97,212,195));
		btnContinue.addActionListener(this);
		panel_1.add(btnContinue);
		
		btnX = new JButton("X");
		btnX.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		btnX.setForeground(Color.WHITE);
		btnX.setBackground(new Color(97,212,195));
		btnX.setHorizontalAlignment(SwingConstants.CENTER);
		btnX.setBounds(555, 0, 45, 30);
		btnX.addActionListener(this);
		btnX.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e)
			{
				btnX.setBackground(new Color(153, 0, 51));
			}
			public void mouseExited(MouseEvent e)
			{
				btnX.setBackground(new Color(97,212,195));
			}
		});
		panel_1.add(btnX);

		setUndecorated(true);
		setSize(1200,675);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton btn=(JButton)e.getSource();
		if(btn==btnX)
		{
			System.exit(0);
		}
		if(btn==btnContinue)
		{
			if(validitate()==true)
			{	
				lblerror.setVisible(false);
				parent.setVisible(true);
				dispose();
			}
			else
			{
				lblerror.setVisible(true);
				clear();
			}
		}
	}
	
	public Boolean validitate()
	{
		Boolean b=false;
		try
		{
			FileInputStream fis=new FileInputStream("Assets\\pass.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			String user=(String)ois.readObject();
			String pass=(String)ois.readObject();
			
			if(passwordField.getText().equals(pass)&&textField.getText().equals(user))
				b=true;
			
			fis.close();
			ois.close();
		}
		catch(Exception e){}
		return b;
	}
	
	public void clear()
	{
		textField.setText("");
		passwordField.setText("");
	}

}
