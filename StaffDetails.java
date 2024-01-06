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
import javax.swing.table.TableColumnModel;
import class_files.Conn;
import class_files.Dashboard;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import net.proteanit.sql.DbUtils;

public class StaffDetails extends JFrame implements ActionListener{
	JTable sTable;
	Choice choosEmp;
	JButton searchEmp, back, update;
	JLabel titleLabel, searchEmpLbl;
        TableColumnModel columnModel;

	StaffDetails(){
	getContentPane().setBackground(new Color(239, 250, 252));
	setLayout(null);
        setTitle("Staff Details");
	setSize(1400, 800);
	setLocation(80, 20);
	setVisible(true);
	setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

	titleLabel = new JLabel("Staff Details");
	titleLabel.setBounds(570, 10, 280, 70);
	titleLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
	add(titleLabel);
	
	searchEmpLbl = new JLabel("Search by Employee name : ");
	searchEmpLbl.setBounds(70, 100, 230, 30);
	searchEmpLbl.setFont(new Font("Arial", Font.PLAIN, 18));
	add(searchEmpLbl);
	
	choosEmp = new Choice();
        choosEmp.setBackground(getContentPane().getBackground());
        choosEmp.requestFocus();
	choosEmp.setBounds(320, 100, 200, 30);
	choosEmp.setFont(new Font("Arial", Font.PLAIN, 18));
	add(choosEmp);
	Font font = new Font("Arial", Font.BOLD, 14);
	
	searchEmp = new JButton("Search");
	searchEmp.setBounds(70, 150, 100, 30);
	searchEmp.setFont(font);
	searchEmp.setBackground(new Color(77, 77, 77));
	searchEmp.setForeground(Color.WHITE);
	searchEmp.addActionListener(this);
	searchEmp.setFocusPainted(false);
	searchEmp.setBorder(BorderFactory.createEmptyBorder());
        add(searchEmp);

        update = new JButton("Update");
	update.setBounds(250, 150, 100, 30);
	update.setFont(font);
	update.setBackground(new Color(77, 77, 77));
	update.setForeground(Color.WHITE);
	update.addActionListener(this);
	update.setFocusPainted(false);
	update.setBorder(BorderFactory.createEmptyBorder());
        add(update);
        
	back = new JButton("Back");
	back.setBounds(420, 150, 100, 30);
	back.setFont(font);
	back.setBackground(new Color(77, 77, 77));
	back.setForeground(Color.WHITE);
	back.addActionListener(this);
	back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder());
	add(back);
	
	try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("select * from staffdetails");
		while(rs.next()){
			choosEmp.add(rs.getString("memberName"));
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
	jsp.setBounds(20, 220, 1350, 350);
        
        columnModel = sTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(80);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(50);
        columnModel.getColumn(4).setPreferredWidth(120);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(6).setPreferredWidth(50);
        columnModel.getColumn(7).setPreferredWidth(220);
        columnModel.getColumn(8).setPreferredWidth(60);
	sTable.setBackground(getContentPane().getBackground());
        sTable.getTableHeader().setBackground(getContentPane().getBackground());
        sTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        sTable.getTableHeader().setPreferredSize(new Dimension(jsp.getWidth(), 30));
	sTable.setFont(new Font("Arial", Font.PLAIN, 16));
        sTable.setFillsViewportHeight(true);
        sTable.setRowHeight(25);
        sTable.setGridColor(new Color(133, 201, 214));
        sTable.setEnabled(false);
        
        jsp.setBorder(BorderFactory.createEmptyBorder());
	add(jsp);
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
                else if(ae.getSource() == update){
                        setVisible(false);
                        new UpdateStaff(choosEmp.getSelectedItem());
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