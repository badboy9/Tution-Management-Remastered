package emerald;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;
import javax.swing.table.*;

import onyx.Confirm;

import java.sql.*;

import topaz.Student;
import sapphire.DeleteDB;
import sapphire.ExtractDB;

@SuppressWarnings("serial")
public class RSearch extends JDialog implements FocusListener,ActionListener,ItemListener {
	private JTextField tsid,tfname;
	private Choice school;
	private CheckboxGroup cbg1,cgcs;
	private JButton bhome,bmod,bdel,bsearch,bprofile;
	private Checkbox cbsid,cbfname,cbclass,cbschool,cbfees;
	private int fschool,fcbg1,fstd,fdel,fview,fmod;
	private Student sobj;
	private Checkbox ccs[];
	private ExtractDB ext;
	private JLabel lerror,lsid2,lsid3;
	private JPanel panel_1;
	private JScrollPane span;
	private JTable tab;
	private JFrame parent;
	private DeleteDB del;
	
	public RSearch(JFrame a,Boolean bm) {
		
		super(a,bm);
		parent=a;
		
		del=new DeleteDB();
		ext=new ExtractDB();
		fschool=fcbg1=fstd=fdel=fview=fmod=0;
		sobj=new Student();
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 480, 675);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setBounds(65, 50, 350, 50);
		lblSearch.setOpaque(true);
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 22));
		lblSearch.setBackground(new Color(0, 51, 102));
		panel.add(lblSearch);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setForeground(Color.BLACK);
		lblStudentId.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblStudentId.setBackground(Color.WHITE);
		lblStudentId.setBounds(80, 170, 110, 45);
		panel.add(lblStudentId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblFirstName.setBackground(Color.WHITE);
		lblFirstName.setBounds(80, 230, 110, 45);
		panel.add(lblFirstName);
		
		JLabel lblSchool = new JLabel("Class");
		lblSchool.setForeground(Color.BLACK);
		lblSchool.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblSchool.setBackground(Color.WHITE);
		lblSchool.setBounds(80, 290, 110, 45);
		panel.add(lblSchool);
		
		JLabel lblSchool_1 = new JLabel("School");
		lblSchool_1.setForeground(Color.BLACK);
		lblSchool_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblSchool_1.setBackground(Color.WHITE);
		lblSchool_1.setBounds(80, 350, 110, 45);
		panel.add(lblSchool_1);
		
		JLabel lblu = new JLabel("Unpaid Fees");
		lblu.setForeground(Color.BLACK);
		lblu.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblu.setBackground(Color.WHITE);
		lblu.setBounds(80, 410, 120, 45);
		panel.add(lblu);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(480, 0, 620, 675);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 51, 102));
		panel_2.setBounds(1100, 0, 100, 675);
		add(panel_2);
		panel_2.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(195, 215, 100, 5);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(195, 275, 100, 5);
		panel.add(separator_1);
		
		lsid2 = new JLabel("Student ID: ");
		lsid2.setForeground(Color.BLACK);
		lsid2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lsid2.setBackground(Color.WHITE);
		lsid2.setBounds(70, 570, 110, 45);
		panel_1.add(lsid2);
		
		lsid3 = new JLabel("");
		lsid3.setForeground(Color.BLACK);
		lsid3.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		lsid3.setBackground(Color.WHITE);
		lsid3.setBounds(185, 570, 200, 45);
		panel_1.add(lsid3);
		
		lerror = new JLabel("Do Not leave the FIelds Empty");
		lerror.setOpaque(true);
		lerror.setHorizontalAlignment(SwingConstants.CENTER);
		lerror.setForeground(new Color(153, 0, 51));
		lerror.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lerror.setBorder(null);
		lerror.setBackground(Color.WHITE);
		lerror.setBounds(100, 550, 280, 30);
		lerror.setVisible(false);
		panel.add(lerror);
		
		tsid = new JTextField();
		tsid.addFocusListener(this);
		tsid.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tsid.setColumns(10);
		tsid.setBorder(null);
		tsid.setBounds(195, 180, 100, 30);
		panel.add(tsid);
		
		tfname = new JTextField();
		tfname.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tfname.setColumns(10);
		tfname.setBorder(null);
		tfname.setBounds(195, 240, 100, 30);
		panel.add(tfname);
		
		school = new Choice();
		school.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		school.addItemListener(this);
		school.add("Select school");
		school.add("1. Mount Carmel");
		school.add("2. Carmel Academy");
		school.add("3. Vidya Niketan");
		school.add("4. St. Michael School");
		school.add("Other");
		school.setBounds(195, 365, 250, 30);
		panel.add(school);
		
		cbg1=new CheckboxGroup();
		cbsid = new Checkbox("");
		cbsid.setCheckboxGroup(cbg1);
		cbsid.addItemListener(this);
		cbsid.setBackground(new Color(255, 255, 255));
		cbsid.setForeground(new Color(0, 0, 0));
		cbsid.setBounds(50, 180, 25, 25);
		panel.add(cbsid);
		
		ccs=new Checkbox[2];
		cgcs=new CheckboxGroup();
		ccs[0] = new Checkbox("IX");
		ccs[0].addItemListener(this);
		ccs[0].setCheckboxGroup(cgcs);
		ccs[0].setFont(new Font("Century Gothic", Font.PLAIN, 18));
		ccs[0].setBackground(Color.WHITE);
		ccs[0].setBounds(190, 290, 60, 45);
		panel.add(ccs[0]);
		ccs[1] = new Checkbox("X");
		ccs[1].addItemListener(this);
		ccs[1].setCheckboxGroup(cgcs);
		ccs[1].setFont(new Font("Century Gothic", Font.PLAIN, 18));
		ccs[1].setBackground(Color.WHITE);
		ccs[1].setBounds(260, 290, 60, 45);
		panel.add(ccs[1]);
		
		cbfname = new Checkbox("");
		cbfname.setCheckboxGroup(cbg1);
		cbfname.addItemListener(this);
		cbfname.setBackground(new Color(255, 255, 255));
		cbfname.setForeground(new Color(0, 0, 0));
		cbfname.setBounds(50, 240, 25, 25);
		panel.add(cbfname);
		
		cbclass = new Checkbox("");
		cbclass.setCheckboxGroup(cbg1);
		cbclass.addItemListener(this);
		cbclass.setBackground(new Color(255, 255, 255));
		cbclass.setForeground(new Color(0, 0, 0));
		cbclass.setBounds(50, 300, 25, 25);
		panel.add(cbclass);
		
		cbschool = new Checkbox("");
		cbschool.setCheckboxGroup(cbg1);
		cbschool.addItemListener(this);
		cbschool.setBackground(new Color(255, 255, 255));
		cbschool.setForeground(new Color(0, 0, 0));
		cbschool.setBounds(50, 360, 25, 25);
		panel.add(cbschool);
		
		cbfees = new Checkbox("");
		cbfees.setCheckboxGroup(cbg1);
		cbfees.addItemListener(this);
		cbfees.setBackground(new Color(255, 255, 255));
		cbfees.setForeground(new Color(0, 0, 0));
		cbfees.setBounds(50, 420, 25, 25);
		panel.add(cbfees);
		
		bsearch = new JButton("Search");
		bsearch.addActionListener(this);
		bsearch.setForeground(Color.WHITE);
		bsearch.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		bsearch.setBorder(null);
		bsearch.setBackground(new Color(0, 51, 102));
		bsearch.setBounds(170, 500, 140, 40);
		panel.add(bsearch);
		
		bprofile = new JButton("Profile");
		bprofile.addActionListener(this);
		bprofile.setForeground(Color.WHITE);
		bprofile.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		bprofile.setBorder(null);
		bprofile.setBackground(new Color(0, 51, 102));
		bprofile.setBounds(70, 500, 120, 40);
		panel_1.add(bprofile);
		
		bmod = new JButton("Modify");
		bmod.addActionListener(this);
		bmod.setForeground(Color.WHITE);
		bmod.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		bmod.setBorder(null);
		bmod.setBackground(new Color(0, 51, 102));
		bmod.setBounds(250, 500, 120, 40);
		panel_1.add(bmod);
		
		bdel = new JButton("Delete");
		bdel.addActionListener(this);
		bdel.setForeground(Color.WHITE);
		bdel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		bdel.setBorder(null);
		bdel.setBackground(new Color(153,0 , 51));
		bdel.setBounds(430, 500, 120, 40);
		panel_1.add(bdel);
		
		bhome = new JButton(new ImageIcon("Assets//Home.jpg"));
		bhome.setBorder(null);
		bhome.addActionListener(this);
		bhome.setBounds(5, 300, 90, 70);
		panel_2.add(bhome);
				
		tab=new JTable();
		tab.getTableHeader().setBackground(new Color(55,55,55));
		tab.getTableHeader().setForeground(Color.WHITE);
		tab.getTableHeader().setFont(new Font("Century Gothic", Font.PLAIN, 17));
		tab.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	        	fdel=fview=fmod=0;
	        	if(e.getClickCount()==2)
	        	{
	        		lsid3.setText("");
	        		JTable table = (JTable)e.getSource();
	        		int row = table.getSelectedRow();
	        		int col = table.getSelectedColumn();
	        		if(col==0)
	        			fview=1;
	        			fmod=1;
	        			fdel=1;
	  	       			lsid3.setText(""+tab.getModel().getValueAt(row, col));
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
	public void actionPerformed(ActionEvent e)
	{
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
			fdel=fview=fmod=0;
			lsid3.setText("");
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
			catch(Exception e1){}
			
		}
		if(btn==bdel)
		{
			if(fdel==1)
			{	
				lerror.setVisible(false);
				try{
					int id=Integer.parseInt(lsid3.getText());
					Confirm con=new Confirm(this,true);
					if(con.b==false)
						return;
					del.spDel(id);
					del.sDel(id);
					fdel=0;
				}
				catch(Exception e1){System.out.println("Error in Deleting::"+e1);return;}
			}
			else
			{
				lerror.setVisible(true);
			}
		}
		if(btn==bmod)
		{
			lerror.setVisible(false);
				try{
					int id=Integer.parseInt(lsid3.getText());

					@SuppressWarnings("unused")
					MForm mfo=new MForm(this,true,id);
					fview=0;
				}
				catch(Exception e1){System.out.println("Error in Modifying::"+e1);lerror.setVisible(true);return;}
		}
		if(btn==bprofile)
		{
				lerror.setVisible(false);
				try{
					int id=Integer.parseInt(lsid3.getText());

					@SuppressWarnings("unused")
					Profile pro=new Profile(this,true,id);
					fview=0;
				}
				catch(Exception e1){System.out.println("Error in Viewing::"+e1);lerror.setVisible(true);return;}
		}
	}
	public void itemStateChanged(ItemEvent e)
	{
		try
		{
			Checkbox cb=(Checkbox)e.getSource();
			CheckboxGroup cbg=cb.getCheckboxGroup();
			if(cbg==cbg1)
			{
				fcbg1=1;
			}
			else if(cb==ccs[0])										//1=IX
			{
				sobj.std=1;
				fstd=1;
			}
			else if(cb==ccs[1])										//2=X
			{
				sobj.std=2;
				fstd=1;
			}
		}
		catch(Exception e1){}
		try
		{
			Choice ch=(Choice)e.getSource();
			if(ch==school)
			{
				if(ch.getSelectedIndex()==0)
				{
					fschool=0;
					return;
				}
				fschool=1;
				sobj.school=ch.getSelectedIndex();
			}
		}
		catch(Exception e1){}
	}
	public void focusGained(FocusEvent e) {
	}
	public void focusLost(FocusEvent e)
	{
		try
		{
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
		}
		catch(Exception ee){}
	}
	
	public ResultSet search() throws Exception
	{
		ResultSet rs;
		Checkbox cbs=cbg1.getSelectedCheckbox();
		if(cbs==cbsid)
		{
			sobj.sid=Integer.parseInt(tsid.getText().trim());
			rs=ext.sidExtract(sobj);
		}
		else if(cbs==cbfname)
		{
			sobj.fname=tfname.getText().trim();
			rs=ext.fnmExtract(sobj);
		}
		else if(cbs==cbclass)
		{
			rs=ext.classExtract(sobj);
		}
		else if(cbs==cbschool)
		{
			rs=ext.schoolExtract(sobj);
		}
		else
		{
			rs=ext.ramountExtract(sobj);
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
		else if(cbs==cbfname&&tfname.getText().trim().isEmpty())
		{	
			flg=1;
		}
		else if(cbs==cbclass&&fstd==0)
		{
			flg=1;
		}
		else if(cbs==cbschool&&fschool==0)
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
	public void clear()
	{
		tfname.setText("");
		tsid.setText("");
		school.select(0);
	}
	public void fillLabel(ResultSet rs)
	{
		int i=2;	
		Object []header =new String[]{"SID","Name","Amount","Contact"};
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
		columnModel.getColumn(0).setPreferredWidth(60);
		columnModel.getColumn(1).setPreferredWidth(250);
		columnModel.getColumn(2).setPreferredWidth(90);
		columnModel.getColumn(3).setPreferredWidth(120);	
		
		tab.setRowHeight(30);
		tab.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		try
		{
			while(rs.next())
			{
				dtm.addRow(new Object[]{rs.getInt(1)," "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4),rs.getInt(13),rs.getString(6)});
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
}
