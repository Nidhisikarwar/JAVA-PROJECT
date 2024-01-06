package class_files;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
public class IssuedBooks extends JFrame implements ActionListener{
	JTable iTable;
	Choice chooseBook;
	JButton search, back;
	JLabel titleLbl, searchLbl, footimg;
        ImageIcon imgFoot;
        Image imgfootTemp;
        TableColumnModel columnModel;
	
	IssuedBooks(){
	getContentPane().setBackground(new Color(255, 250, 250));
	setLayout(null);
	setSize(1400, 800);
	setTitle("Available Books");
	setLocation(80, 20);
	setVisible(true);
	setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	titleLbl = new JLabel("Issued Books Details");
	titleLbl.setBounds(480, 10, 500, 70);
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
        search.setBorder(BorderFactory.createLineBorder(new Color(77,77,77),2, true));
	search.setBackground(getContentPane().getBackground());
	search.setForeground(new Color(77,77,77));
	search.addActionListener(this);
	search.setFocusPainted(false);
	add(search);
	
	back = new JButton("Back");
	back.setBounds(400, 150, 100, 30);
	back.setFont(font);
        back.setBorder(BorderFactory.createLineBorder(new Color(77,77,77), 2, true));
	back.setBackground(getContentPane().getBackground());
	back.setForeground(new Color(77,77,77));
	back.addActionListener(this);
	back.setFocusPainted(false);
	add(back);
	
	try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("select * from issuedbooks");
		while(rs.next()){
			chooseBook.add(rs.getString("bookName"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	iTable = new JTable();
	try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("select * from issuedbooks");
		iTable.setModel(DbUtils.resultSetToTableModel(rs));
	}catch(Exception e){
		e.printStackTrace();
	}
        
	JScrollPane jsp = new JScrollPane(iTable);
	jsp.setBounds(20, 250, 1350, 350);
       
        columnModel = iTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(120);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(60);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(60);
         
	iTable.setBackground(getContentPane().getBackground());
        iTable.getTableHeader().setBackground(getContentPane().getBackground());
        iTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        iTable.getTableHeader().setPreferredSize(new Dimension(jsp.getWidth(), 30));
	iTable.setFont(new Font("Arial", Font.PLAIN, 16));
        iTable.setFillsViewportHeight(true);
        iTable.setRowHeight(25);
        iTable.setGridColor(new Color(77,77,77));
        iTable.setEnabled(false);
        
        jsp.setBorder(BorderFactory.createEmptyBorder());
        add(jsp);

        imgFoot = new ImageIcon(ClassLoader.getSystemResource("images/issueFoot.png"));
        imgfootTemp = imgFoot.getImage().getScaledInstance(800, 150, Image.SCALE_SMOOTH);
        footimg = new JLabel(new ImageIcon(imgfootTemp));
	footimg.setBounds(290, 640, 800, 150);
	add(footimg); 
	}
 
        public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == search){
			String query2 = "select * from issuedbooks where bookName = '"+chooseBook.getSelectedItem()+"' ";
			try{
				Conn c =new Conn();
				ResultSet rs = c.s.executeQuery(query2);
				iTable.setModel(DbUtils.resultSetToTableModel(rs));
                                columnModel.getColumn(0).setPreferredWidth(40);
                                columnModel.getColumn(1).setPreferredWidth(200);
                                columnModel.getColumn(2).setPreferredWidth(120);
                                columnModel.getColumn(3).setPreferredWidth(100);
                                columnModel.getColumn(4).setPreferredWidth(50);
                                columnModel.getColumn(5).setPreferredWidth(60);
                                columnModel.getColumn(6).setPreferredWidth(100);
                                columnModel.getColumn(7).setPreferredWidth(60);
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
                new IssuedBooks();
        }
}