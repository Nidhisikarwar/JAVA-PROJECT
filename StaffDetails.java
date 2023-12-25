package class_files;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import class_files.Conn;
import class_files.Dashboard;
import net.proteanit.sql.DbUtils;
public class StaffDetails extends JFrame implements ActionListener{
	JTable sTable;
	Choice choosEmp;
	JButton searchEmp, back;
	JLabel titleLabel, searchEmpLbl;

	StaffDetails(){
	getContentPane().setBackground(new Color(255, 255, 230));
	setLayout(null);
	setSize(1100, 650);
	setLocation(100, 100);
	setVisible(true);
	setResizable(false);

	titleLabel = new JLabel("Staff Details");
	titleLabel.setBounds(475, 20, 200, 70);
	titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	add(titleLabel);
	
	searchEmpLbl = new JLabel("Search by Employee name : ");
	searchEmpLbl.setBounds(70, 100, 200, 30);
	searchEmpLbl.setFont(new Font("Arial", Font.PLAIN, 18));
	add(searchEmpLbl);
	
	choosEmp = new Choice();
	choosEmp.setBounds(280, 100, 150, 30);
	choosEmp.setFont(new Font("Arial", Font.PLAIN, 18));
	add(choosEmp);
	Font font = new Font("Arial", Font.BOLD, 14);
	
	searchEmp = new JButton("Search");
	searchEmp.setBounds(100, 150, 100, 30);
	searchEmp.setFont(font);
	searchEmp.addActionListener(this);
	add(searchEmp);
	
	back = new JButton("Back");
	back.setBounds(400, 150, 100, 30);
	back.setFont(font);
	back.addActionListener(this);
	add(back);
	
	try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("select * from staffdetails");
		while(rs.next()){
			choosEmp.getString("memberName");
		}
	} catch(Exception e){
		e.printStackTrace();
	}
	
	sTable = new JTable();
	try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("select * from staffdetails");
		sTable.setModel(DbUtils.resultSetToTableModel(rs));
	}catch(Exception e){
		e.printStackTrace();
	}
	
	JScrollPane jsp = new JScrollPane(sTable);
	jsp.setBounds(0, 100,900,600);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == searchEmp){
			String query = "select * from staffdetails where memberName = '"+choosEmp.getSelectedItem()+"'";
			try{
				Conn c =new Conn();
				ResultSet rs = c.s.executeQuery(query);
				sTable.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else {
			setVisible(false);
			new Dashboard();
		}
	}
	
	public static void main(String[] args){
		new StaffDetails();
	}
}