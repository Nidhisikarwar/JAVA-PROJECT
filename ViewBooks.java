package class_files;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

public class ViewBooks extends JFrame implements ActionListener{
	JTable table;
	Choice chooseBook;
	JButton search, back;
	JLabel titleLbl, searchLbl, footimg;
        ImageIcon imgFoot;
        Image imgfootTemp;
        TableColumnModel columnModel;
	
	ViewBooks(){
	getContentPane().setBackground(new Color(239, 250, 252));
	setLayout(null);
	setSize(1400, 800);
	setTitle("Available Books");
	setLocation(80, 20);
	setVisible(true);
	setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	titleLbl = new JLabel("Books Placed in Bookshelves");
	titleLbl.setBounds(450, 10, 500, 70);
	titleLbl.setFont(new Font("Monospaced", Font.BOLD, 30));
	add(titleLbl);

	searchLbl = new JLabel("Search by Book name : ");
	searchLbl.setBounds(70, 100, 200, 30);
	searchLbl.setFont(new Font("Arial", Font.PLAIN, 18));
	add(searchLbl);
	
	chooseBook = new Choice();
        chooseBook.setBackground(getContentPane().getBackground());
        chooseBook.requestFocus();
        chooseBook.setBounds(280, 100, 300, 30);
	chooseBook.setFont(new Font("Arial", Font.PLAIN, 17));
	add(chooseBook);
	
	Font font = new Font("Arial", Font.PLAIN, 16);
	
	search = new JButton("Search");
	search.setBounds(70, 150, 100, 30);
	search.setFont(font);
	search.setBackground(new Color(77, 77, 77));
	search.setForeground(Color.WHITE);
	search.addActionListener(this);
	search.setFocusPainted(false);
        search.setBorder(BorderFactory.createEmptyBorder());
	add(search);
	
	back = new JButton("Back");
	back.setBounds(400, 150, 100, 30);
	back.setFont(font);
	back.setBackground(new Color(77, 77, 77));
	back.setForeground(Color.WHITE);
	back.addActionListener(this);
	back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder());
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
        
	JScrollPane jsp = new JScrollPane(table);
	jsp.setBounds(20, 220, 1350, 400);
       
        columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(220);
        columnModel.getColumn(1).setPreferredWidth(140);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(130);
        columnModel.getColumn(4).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(70);
         
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

        imgFoot = new ImageIcon(ClassLoader.getSystemResource("images/viewbookFoot.png"));
        imgfootTemp = imgFoot.getImage().getScaledInstance(1000, 150, Image.SCALE_SMOOTH);
        footimg = new JLabel(new ImageIcon(imgfootTemp));
	footimg.setBounds(200, 620, 1000, 150);
	add(footimg); 
	}

	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == search){
			String query = "select * from bookDetails where bookName = '"+chooseBook.getSelectedItem()+"'";
			try{
				Conn c =new Conn();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
                                columnModel.getColumn(0).setPreferredWidth(220);
                                columnModel.getColumn(1).setPreferredWidth(140);
                                columnModel.getColumn(2).setPreferredWidth(40);
                                columnModel.getColumn(3).setPreferredWidth(130);
                                columnModel.getColumn(4).setPreferredWidth(60);
                                columnModel.getColumn(5).setPreferredWidth(100);
                                columnModel.getColumn(6).setPreferredWidth(70);
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