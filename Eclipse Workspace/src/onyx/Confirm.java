package onyx;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Confirm extends JDialog implements ActionListener{

	private JButton btnBack,btnContinue;
	public Boolean b=false;
	
	public Confirm(JDialog a,Boolean bm) 
	{
		
		super(a,bm);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 350, 196);
		add(panel);
		panel.setLayout(null);
		
		btnContinue = new JButton("Continue");
		btnContinue.addActionListener(this);
		btnContinue.setForeground(Color.WHITE);
		btnContinue.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnContinue.setBorder(null);
		btnContinue.setBackground(new Color(0, 51, 102));
		btnContinue.setBounds(50, 120, 100, 40);
		panel.add(btnContinue);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(0, 51, 102));
		btnBack.setBounds(200, 120, 100, 40);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Are you sure you want to Continue ?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblNewLabel.setBounds(0, 55, 350, 30);
		panel.add(lblNewLabel);

		

		setUndecorated(true);
	//	parent.setVisible(false);
		setSize(350,196);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn=(JButton)e.getSource();
		if(btn==btnContinue)
		{
			b=true;
			dispose();
		}
		else if(btn==btnBack)
		{
			dispose();
		}
	}

}
