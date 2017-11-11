package emerald;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import onyx.Confirm;
import sapphire.DeleteDB;


@SuppressWarnings("serial")
public class AForm extends JDialog implements ActionListener,FocusListener {
	private JTextField tu,tp1,tp2, tp3;
	private JTextField tf1;
	private JTextField tf2;
	private JButton bhome,bReset,b1,b2,b3;
	private JLabel lcfee1, lcfee2,lerror1,lerror2;
	private JFrame parent;
	private DeleteDB del;
	FileInputStream fis;
	FileOutputStream fos;
	DataOutputStream dos;
	DataInputStream dis;
	private int math,sci;
	private String pass,user;

	public AForm(JFrame a,Boolean bm) {
		super(a,bm);
		del=new DeleteDB();
		parent=a;
		
		try
		{
			fis=new FileInputStream("Assets\\Chest.dat");
			dis=new DataInputStream(fis);
			math=dis.readInt();
			sci=dis.readInt();
			dis.close();
			fis.close();
			
			
		}
		catch(Exception e){}
		
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 550, 675);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblOldPassword = new JLabel("Current");
		lblOldPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOldPassword.setForeground(Color.BLACK);
		lblOldPassword.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblOldPassword.setBackground(Color.WHITE);
		lblOldPassword.setBounds(40, 160, 150, 45);
		panel.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New");
		lblNewPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewPassword.setForeground(Color.BLACK);
		lblNewPassword.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewPassword.setBackground(Color.WHITE);
		lblNewPassword.setBounds(40, 210, 150, 45);
		panel.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Retype New");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmPassword.setForeground(Color.BLACK);
		lblConfirmPassword.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblConfirmPassword.setBackground(Color.WHITE);
		lblConfirmPassword.setBounds(40, 260, 150, 45);
		panel.add(lblConfirmPassword);
		
		JLabel lbl2 = new JLabel("Change Password");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lbl2.setBounds(165, 50, 220, 50);
		panel.add(lbl2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(205, 155, 180, 5);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(205, 255, 180, 5);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(205, 305, 180, 5);
		panel.add(separator_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 51, 102));
		panel_2.setBounds(1100, 0, 100, 675);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblResetDatabase = new JLabel("Reset Database");
		lblResetDatabase.setHorizontalAlignment(SwingConstants.CENTER);
		lblResetDatabase.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblResetDatabase.setBounds(165, 420, 220, 50);
		panel.add(lblResetDatabase);
		
		JTextArea txtrResettingTheDatabase = new JTextArea();
		txtrResettingTheDatabase.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		txtrResettingTheDatabase.setText("Resetting the DataBase will result in clearing \r\nof all the Information stored till date.");
		txtrResettingTheDatabase.setBounds(75, 480, 400, 60);
		panel.add(txtrResettingTheDatabase);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(550, 0, 550, 675);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl1 = new JLabel("Change Fees - Maths");
		lbl1.setBounds(130, 50, 260, 50);
		panel_1.add(lbl1);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("Current");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(40, 110, 125, 45);
		panel_1.add(label_2);
		
		JLabel label_1 = new JLabel("New");
		label_1.setBounds(40, 160, 125, 45);
		panel_1.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_1.setBackground(Color.WHITE);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(180, 205, 100, 5);
		panel_1.add(separator_4);
		
		JLabel lblChangeFees = new JLabel("Change Fees - Science");
		lblChangeFees.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeFees.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblChangeFees.setBounds(130, 320, 260, 50);
		panel_1.add(lblChangeFees);
		
		JLabel label = new JLabel("Current");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label.setBackground(Color.WHITE);
		label.setBounds(40, 380, 125, 45);
		panel_1.add(label);
		
		JLabel label_3 = new JLabel("New");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(40, 430, 125, 45);
		panel_1.add(label_3);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(180, 475, 100, 5);
		panel_1.add(separator_3);
		
		JLabel lblNewUser = new JLabel("New Username");
		lblNewUser.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewUser.setForeground(Color.BLACK);
		lblNewUser.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewUser.setBackground(Color.WHITE);
		lblNewUser.setBounds(40, 110, 150, 45);
		panel.add(lblNewUser);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(205, 205, 180, 5);
		panel.add(separator_5);
		
		lerror1 = new JLabel("Passwords do not match");
		lerror1.setOpaque(true);
		lerror1.setHorizontalAlignment(SwingConstants.CENTER);
		lerror1.setForeground(new Color(153, 0, 51));
		lerror1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lerror1.setBorder(null);
		lerror1.setVisible(false);
		lerror1.setBackground(Color.WHITE);
		lerror1.setBounds(40, 335, 280, 30);
		panel.add(lerror1);
		
		lerror2 = new JLabel("Incorrect Current Password");
		lerror2.setOpaque(true);
		lerror2.setHorizontalAlignment(SwingConstants.CENTER);
		lerror2.setForeground(new Color(153, 0, 51));
		lerror2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lerror2.setBorder(null);
		lerror2.setBackground(Color.WHITE);
		lerror2.setBounds(40, 335, 280, 30);
		lerror2.setVisible(false);
		panel.add(lerror2);
		
		tu = new JTextField();
		tu.setForeground(Color.BLACK);
		tu.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tu.setBorder(null);
		tu.setBounds(205, 120, 180, 30);
		panel.add(tu);
		
		tp1 = new JPasswordField();
		tp1.setForeground(Color.BLACK);
		tp1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tp1.setBorder(null);
		tp1.setBackground(new Color(255, 255, 255));
		tp1.setBounds(205, 170, 180, 30);
		panel.add(tp1);
		
		tp2 = new JPasswordField();
		tp2.setForeground(Color.BLACK);
		tp2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tp2.setBorder(null);
		tp2.setBackground(new Color(255, 255, 255));
		tp2.setBounds(205, 220, 180, 30);
		panel.add(tp2);
		
		tp3 = new JPasswordField();
		tp3.setForeground(Color.BLACK);
		tp3.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tp3.setBorder(null);
		tp3.setBackground(new Color(255, 255, 255));
		tp3.setBounds(205, 270, 180, 30);
		panel.add(tp3);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		tf1.addFocusListener(this);
		tf1.setBounds(180, 170, 100, 30);
		panel_1.add(tf1);
		tf1.setBorder(null);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.addActionListener(this);
		tf2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		tf2.setColumns(10);
		tf2.setBorder(null);
		tf2.setBounds(180, 440, 100, 30);
		panel_1.add(tf2);
		
		lcfee2 = new JLabel(""+sci);
		lcfee2.setHorizontalAlignment(SwingConstants.LEFT);
		lcfee2.setForeground(Color.BLACK);
		lcfee2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lcfee2.setBackground(Color.WHITE);
		lcfee2.setBounds(180, 390, 125, 30);
		panel_1.add(lcfee2);
		
		lcfee1 = new JLabel(""+math);
		lcfee1.setHorizontalAlignment(SwingConstants.LEFT);
		lcfee1.setForeground(Color.BLACK);
		lcfee1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lcfee1.setBackground(Color.WHITE);
		lcfee1.setBounds(180, 120, 125, 30);
		panel_1.add(lcfee1);
		
		bReset = new JButton("Reset");
		bReset.addActionListener(this);
		bReset.setForeground(Color.WHITE);
		bReset.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		bReset.setBorder(null);
		bReset.setBackground(new Color(153, 51, 51));
		bReset.setBounds(194, 570, 120, 40);
		panel.add(bReset);
		
		b1 = new JButton("Change");
		b1.addActionListener(this);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		b1.setBorder(null);
		b1.setBackground(new Color(0, 51, 102));
		b1.setBounds(320, 330, 120, 40);
		panel.add(b1);
		
		b2 = new JButton("Change");
		b2.addActionListener(this);
		b2.setBounds(300, 230, 120, 40);
		panel_1.add(b2);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		b2.setBorder(null);
		b2.setBackground(new Color(0, 51, 102));
		
		b3 = new JButton("Change");
		b3.addActionListener(this);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		b3.setBorder(null);
		b3.setBackground(new Color(0, 51, 102));
		b3.setBounds(300, 500, 120, 40);
		panel_1.add(b3);
		
		bhome = new JButton(new ImageIcon("Assets\\Home.jpg"));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn=(JButton)e.getSource();
		lerror1.setVisible(false);
		lerror2.setVisible(false);
		if(btn==b1)
		{
			loadPassword();
			if(tp1.getText().equals(pass)==false)
			{
				lerror2.setVisible(true);
				tp1.setText("");
				return;
			}
			if(tp2.getText().equals(tp3.getText())==false)
			{
				
				lerror1.setVisible(true);
				tp2.setText("");
				tp3.setText("");
				return;
			}
			user=tu.getText();
			pass=tp2.getText();
			savePassword();
		}
		if(btn==b2)
		{
			if(tf1.getText().trim().isEmpty())
				return;
			try
			{
				math=Integer.parseInt(tf1.getText());
				fos=new FileOutputStream("Assets\\Chest.dat");
				dos=new DataOutputStream(fos);
				dos.writeInt(math);
				dos.writeInt(sci);
				
				dos.close();
				fos.close();			
			}
			catch(Exception e1){}
			lcfee1.setText(""+math);
			tf1.setText("");
		}
		if(btn==b3)
		{
			if(tf2.getText().trim().isEmpty())
				return;
			try
			{
				sci=Integer.parseInt(tf2.getText());
				fos=new FileOutputStream("Assets\\Chest.dat");
				dos=new DataOutputStream(fos);
				dos.writeInt(math);
				dos.writeInt(sci);
				
				dos.close();
				fos.close();
			}
			catch(Exception e1){}
			lcfee2.setText(""+sci);
			tf2.setText("");
		}
		if(btn==bReset)
		{
			Confirm con=new Confirm(this,true);
			if(con.b==false)
				return;
			try{
				del.allDel();
				fos=new FileOutputStream("Assets\\Index.dat");
				dos=new DataOutputStream(fos);
					
				dos.writeInt(101);
				dos.writeInt(101);
				fos.close();
				dos.close();
			}
			catch(Exception e1){e1.printStackTrace();}
		}
		if(btn==bhome)
		{
			
			try{
				del.cClose();
			}
			catch(Exception e1){}
			dispose();
			parent.setVisible(true);
		}
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		try
		{
			JTextField tb=(JTextField)e.getSource();
			if(tb==tf1)
			{
				try{
					Integer.parseInt(tf1.getText());
				}
				catch(Exception e1)
				{
					tf1.setText("");
					return;
				}
			}
			if(tb==tf2)
			{
				try{
					Long.parseLong(tf2.getText());
				}
				catch(Exception e1)
				{
					tf2.setText("");
					return;
				}
			}
		}
		catch(Exception e1){}
	}
	public void loadPassword()
	{
		try{
			fis=new FileInputStream("Assets\\pass.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			user=(String)ois.readObject();
			pass=(String)ois.readObject();
			
			fis.close();
			ois.close();
		}
		catch(Exception e){}
	}
	public void savePassword()
	{
		try{
			fos=new FileOutputStream("Assets\\pass.dat");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(user);
			oos.writeObject(pass);
			
			fos.close();
			oos.close();
		}
		catch(Exception e){}
	}
}
