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

import net.proteanit.sql.DbUtils;

public class ViewBooks extends JFrame implements ActionListener{
	JTable table;
	Choice chooseBook;
	JButton search, back, update;
	JLabel titleLbl, searchLbl;
	ViewBooks(){
	getContentPane().setBackground(new Color(255, 255, 230));
	setLayout(null);
	setSize(1100, 650);
	setLocation(100, 100);
	setVisible(true);
	setResizable(false);
	titleLbl = new JLabel("Available Books");
	titleLbl.setBounds(475, 20, 200, 70);
	titleLbl.setFont(new Font("Arial", Font.BOLD, 24));
	add(titleLbl);
	
	searchLbl = new JLabel("Search by Book name : ");
	searchLbl.setBounds(70, 100, 200, 30);
	searchLbl.setFont(new Font("Arial", Font.PLAIN, 18));
	add(searchLbl);
	
	chooseBook = new Choice();
	chooseBook.setBounds(280, 100, 150, 30);
	chooseBook.setFont(new Font("Arial", Font.PLAIN, 18));
	add(chooseBook);
	Font font = new Font("Arial", Font.BOLD, 14);
	
	search = new JButton("Search");
	search.setBounds(100, 150, 100, 30);
	search.setFont(font);
	search.addActionListener(this);
	add(search);
	
	back = new JButton("Back");
	back.setBounds(400, 150, 100, 30);
	back.setFont(font);
	back.addActionListener(this);
	add(back);
	
	try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("select * from bookDetails");
		while(rs.next()){
			chooseBook.getString("bookName");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	table = new JTable();
	try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("select * from bookDetails");
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}catch(Exception e){
		e.printStackTrace();
	}
	
	JScrollPane jsp = new JScrollPane(table);
	jsp.setBounds(0, 100,900,600);
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == search){
			String query = "select * from bookDetails where bookName = '"+chooseBook.getSelectedItem()+"'";
			try{
				Conn c =new Conn();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
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
		new ViewBooks();
	}
}