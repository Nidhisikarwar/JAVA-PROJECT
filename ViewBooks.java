package class_files;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import net.proteanit.sql.DbUtils;

public class ViewBooks extends JFrame implements ActionListener{
	JTable table;
	Choice chooseBook;
	JButton search, back;
	JLabel titleLbl, searchLbl, footimg;
        ImageIcon imgFoot;
        Image imgfootTemp;
	
	ViewBooks(){
	getContentPane().setBackground(new Color(239, 250, 252));
	setLayout(null);
	setSize(1200, 800);
	setTitle("Available Books");
	setLocation(160, 20);
	setVisible(true);
	setResizable(false);
	
	titleLbl = new JLabel("Books Placed in Bookshelves");
	titleLbl.setBounds(360, 10, 500, 70);
	titleLbl.setFont(new Font("Monospaced", Font.BOLD, 30));
	add(titleLbl);
	
	searchLbl = new JLabel("Search by Book name : ");
	searchLbl.setBounds(70, 100, 200, 30);
	searchLbl.setFont(new Font("Arial", Font.PLAIN, 18));
	add(searchLbl);
	
	chooseBook = new Choice();
        chooseBook.setBackground(getContentPane().getBackground());
        chooseBook.requestFocus();
        chooseBook.setBounds(280, 100, 220, 30);
	chooseBook.setFont(new Font("Arial", Font.PLAIN, 18));
	add(chooseBook);
	
	Font font = new Font("Arial", Font.PLAIN, 16);
	
	search = new JButton("Search");
	search.setBounds(70, 150, 100, 30);
	search.setFont(font);
	search.setBackground(new Color(77, 77, 77));
	search.setForeground(Color.WHITE);
	search.addActionListener(this);
	search.setFocusPainted(false);
	add(search);
	
	back = new JButton("Back");
	back.setBounds(400, 150, 100, 30);
	back.setFont(font);
	back.setBackground(new Color(77, 77, 77));
	back.setForeground(Color.WHITE);
	back.addActionListener(this);
	back.setFocusPainted(false);
	add(back);
	
	try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("select * from bookDetails");
		while(rs.next()){
			chooseBook.add(rs.getString("bookName"));
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
       
        imgFoot = new ImageIcon(ClassLoader.getSystemResource("images/viewbookFoot.png"));
        imgfootTemp = imgFoot.getImage().getScaledInstance(1000, 120, Image.SCALE_SMOOTH);
        footimg = new JLabel(new ImageIcon(imgfootTemp));
	footimg.setBounds(100, 645, 1000, 120);
	add(footimg); 
        
	JScrollPane jsp = new JScrollPane(table);
	jsp.setBounds(20, 220, 1150, 250);
        
	table.setBackground(getContentPane().getBackground());
        table.getTableHeader().setBackground(getContentPane().getBackground());
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.getTableHeader().setPreferredSize(new Dimension(jsp.getWidth(), 30));
	table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setFillsViewportHeight(true);
        table.setRowHeight(25);
        table.setGridColor(new Color(133, 201, 214));
        table.setEnabled(false);
        jsp.setBorder(BorderFactory.createEmptyBorder());
        add(jsp);

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