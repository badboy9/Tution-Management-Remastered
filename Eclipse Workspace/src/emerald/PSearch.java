package emerald;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.event.*;
import java.sql.*;

import sapphire.DeleteDB;
import sapphire.ExtractDB;
import sapphire.UpdateDB;
import topaz.payment;
import onyx.Confirm;

@SuppressWarnings("serial")
public class PSearch extends JDialog implements ActionListener,ItemListener,FocusListener{
	private JTextField tpid,tsid;
	private JLabel lerror,lpid2,lpid3;
	private Checkbox cbsid,cbpid;
	private CheckboxGroup cbg1;
	private JButton bdel,bsearch,bhome;
	private int fcbg1,fdel;
	private JPanel panel_1;
	private ExtractDB ext;
	private payment pobj;
	private JScrollPane span;
	private JTable tab;
	private JFrame parent;
	private DeleteDB del;
	private UpdateDB updt;
	
	public PSearch(JFrame a,Boolean bm) {
		super(a,bm);
		
		
		fcbg1=fdel=0;
		parent=a;
		updt=new UpdateDB();
		pobj=new payment();
		del=new DeleteDB();
		ext=new ExtractDB();
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 480, 675);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("SEARCH");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 22));
		label.setBackground(new Color(0, 51, 102));
		label.setBounds(65, 50, 350, 50);
		panel.add(label);
		
		JLabel lblPaymentId = new JLabel("Payment ID");
		lblPaymentId.setForeground(Color.BLACK);
		lblPaymentId.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPaymentId.setBackground(Color.WHITE);
		lblPaymentId.setBounds(80, 170, 120, 45);
		panel.add(lblPaymentId);
		
		JLabel label_2 = new JLabel("Student ID");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(80, 230, 120, 45);
		panel.add(label_2);
				
		JSeparator separator = new JSeparator();
		separator.setBounds(206, 201, 100, 5);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(206, 275, 100, 5);
		panel.add(separator_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(205, 214, 100, 5);
		panel.add(separator_3);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(480, 0, 620, 675);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 51, 102));
		panel_2.setBounds(1100, 0, 100, 675);
		add(panel_2);
		panel_2.setLayout(null);
		
		lpid2 = new JLabel("Payment ID");
		lpid2.setForeground(Color.BLACK);
		lpid2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lpid2.setBackground(Color.WHITE);
		lpid2.setBounds(70, 560, 120, 45);
		panel_1.add(lpid2);
		
		lpid3 = new JLabel("");
		lpid3.setBounds(190, 560, 100, 45);
		panel_1.add(lpid3);
		lpid3.setForeground(Color.BLACK);
		lpid3.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		lpid3.setBackground(Color.WHITE);
		
		lerror = new JLabel("Do Not leave the FIelds Empty");
		lerror.setHorizontalAlignment(SwingConstants.CENTER);
		lerror.setBounds(100, 490, 280, 30);
		lerror.setVisible(false);
		lerror.setForeground(new Color(153, 51, 51));
		lerror.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lerror.setBackground(Color.WHITE);
		panel.add(lerror);
		tpid = new JTextField();
		tpid.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tpid.addFocusListener(this);
		tpid.setColumns(10);
		tpid.setBorder(null);
		tpid.setBounds(205, 180, 100, 30);
		panel.add(tpid);
		
		tsid = new JTextField();
		tsid.addFocusListener(this);
		tsid.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tsid.setColumns(10);
		tsid.setBorder(null);
		tsid.setBounds(205, 240, 100, 30);
		panel.add(tsid);
		
		cbg1=new CheckboxGroup();
		cbpid = new Checkbox("");
		cbpid.setCheckboxGroup(cbg1);
		cbpid.addItemListener(this);
		cbpid.setBackground(new Color(255, 255, 255));
		cbpid.setBounds(50, 180, 25, 25);
		panel.add(cbpid);
		
		cbsid = new Checkbox("");
		cbsid.setCheckboxGroup(cbg1);
		cbsid.addItemListener(this);
		cbsid.setBackground(new Color(255, 255, 255));
		cbsid.setBounds(50, 240, 25, 25);
		panel.add(cbsid);
		
		bdel = new JButton("Delete");
		bdel.addActionListener(this);
		bdel.setForeground(Color.WHITE);
		bdel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		bdel.setBorder(null);
		bdel.setBackground(new Color(153,0 , 51));
		bdel.setBounds(250, 500, 120, 40);
		panel_1.add(bdel);
		
		bhome = new JButton(new ImageIcon("Assets\\Home.jpg"));
		bhome.addActionListener(this);
		bhome.setBounds(5, 300, 90, 70);
		panel_2.add(bhome);
		
		bsearch = new JButton("Search");
		bsearch.addActionListener(this);
		bsearch.setForeground(Color.WHITE);
		bsearch.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		bsearch.setBorder(null);
		bsearch.setBackground(new Color(0, 51, 102));
		bsearch.setBounds(170, 440, 140, 40);
		panel.add(bsearch);
		
		
		
		tab=new JTable();
		tab.getTableHeader().setBackground(new Color(55,55,55));
		tab.getTableHeader().setForeground(Color.WHITE);
		tab.getTableHeader().setFont(new Font("Century Gothic", Font.PLAIN, 17));
		tab.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	        	fdel=0;
	        	if(e.getClickCount()==2)
	        	{
	        		lpid3.setText("");
	        		JTable table = (JTable)e.getSource();
	        		int row = table.getSelectedRow();
	        		int col = table.getSelectedColumn();
	        		if(col==0)
	  	       			fdel=1;
	        			lpid3.setText(""+tab.getModel().getValueAt(row, col));
	        		}
	        	}
	    });
		span=new JScrollPane(tab);
		span.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        span.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		span.setBounds(50, 60, 550, 400);
		panel_1.add(span);
		
		
		
		
		
		
		setUndecorated(true);
		parent.setVisible(false);
		setSize(1200,675);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		
			JTextField tb=(JTextField)e.getSource();
			if(tb==tsid)
			{	
				try{
					Long.parseLong(tsid.getText());
				}
				catch(Exception e1)
				{
					tsid.setText("");
				}
			}
			else if(tb==tpid)
			{	
				try{
					Long.parseLong(tpid.getText());
				}
				catch(Exception e1)
				{
					tpid.setText("");
				}
			}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Checkbox cb=(Checkbox)e.getSource();
		CheckboxGroup cbg=cb.getCheckboxGroup();
		if(cbg==cbg1)
		{
			fcbg1=1;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn=(JButton)e.getSource();
		if(btn==bhome)
		{
			try{
				del.cClose();
				ext.cClose();
			}
			catch(Exception e1){}
			parent.setVisible(true);
			dispose();
		}
		if(btn==bsearch)
		{
			fdel=0;
			lpid3.setText("");
			if(isEmpty()==true)
			{
				lerror.setVisible(true);
				return;
			}
			lerror.setVisible(false);
			try
			{
				ResultSet rs=search();
				fillLabel(rs);
			}
			catch(Exception e1){System.out.println("Wrong:: "+e1);}
			
		}
		if(btn==bdel)
		{
			if(fdel==1)
			{	
				lerror.setVisible(false);
				try{
					int id=Integer.parseInt(lpid3.getText());
					Confirm con=new Confirm(this,true);
					if(con.b==false)
						return;
					ext.objExtract(pobj,id);
					if(UnPay(pobj)==false)
						return;
					del.pDel(id);
					fdel=0;
				}
				catch(Exception e1){System.out.println("Error in Deleting::"+e1);return;}
			}
			else
				lerror.setVisible(true);
		}
	}
	
	public ResultSet search() throws Exception
	{
		ResultSet rs;
		Checkbox cbs=cbg1.getSelectedCheckbox();
		if(cbs==cbsid)
		{
			pobj.sid=Integer.parseInt(tsid.getText().trim());
			rs=ext.sidExtract(pobj);
		}
		else
		{
			pobj.pid=Integer.parseInt(tpid.getText().trim());
			rs=ext.pidExtract(pobj);
		}
		
		return rs;
	}
	public Boolean isEmpty()
	{
		int flg=0;
		Checkbox cbs=cbg1.getSelectedCheckbox();
		if(cbs==cbsid&&tsid.getText().trim().isEmpty())
		{
			flg=1;
		}
		else if(cbs==cbpid&&tpid.getText().trim().isEmpty())
		{	
			flg=1;
		}
		else if(fcbg1==0)																//none of the Checkbox selected
		{
			flg=1;
		}
		if(flg==1)
			return true;
		return false;
	}
	public void fillLabel(ResultSet rs)
	{
		int i=2;	
		Object []header =new String[]{"PID","SID","Name","Amount","Date"};
	
		DefaultTableModel dtm = new DefaultTableModel(header,0) 
		{
			@Override
				public boolean isCellEditable(int row, int column) {
			//all cells false
				return false;
			}
		};
		tab.setModel(dtm);
		TableColumnModel columnModel = tab.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(50);
		columnModel.getColumn(2).setPreferredWidth(200);	
		columnModel.getColumn(3).setPreferredWidth(100);	
		columnModel.getColumn(4).setPreferredWidth(100);		
		
		tab.setRowHeight(30);
		tab.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		try
		{
			while(rs.next())
			{
				dtm.addRow(new Object[]{rs.getInt(1),rs.getInt(2),rs.getString(3)+" "+rs.getString(4),rs.getInt(5),rs.getString(6)});
				i++;
			}
		}
		catch(Exception e){System.out.println("Wrong");}

		//Code TO Colour Alternate Rows As Gray

		tab.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
			{
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				c.setBackground(row % 2 == 1 ? new Color(0, 51, 102) : Color.WHITE);
				c.setForeground(row % 2 == 1 ? Color.WHITE : Color.BLACK);
				return this;
			}
		});

		tab.setPreferredScrollableViewportSize(new Dimension(520,(i*tab.getRowHeight())));
        tab.setFillsViewportHeight(true);
		panel_1.validate();
	}
	public void clear()
	{
		tpid.setText("");
		tsid.setText("");
	}

	public Boolean UnPay(payment pobj)
	{	
		try{
			int amt=ext.amtExtract(pobj.sid);
			amt=amt+pobj.pamount;
			updt.pay(pobj,amt);
		}
		catch(Exception e){JOptionPane.showMessageDialog(null,""+e,"Error in Insertion",JOptionPane.ERROR_MESSAGE);return false;}
		return true;
	}

	public static void main(String []args)
	{
		@SuppressWarnings("unused")
		PSearch obj=new PSearch(null,true);
	}
}
