package class_files;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

public class UserDetails extends JFrame implements ActionListener{
        JLabel heading, uLbl;
        ImageIcon uImg;
        Image uImg2;
        JTable uTable;
        JButton back, search;
        Choice chooseuser;
        TableColumnModel columnModel;
        UserDetails(){
                setTitle("User Details - Library");
                setLayout(null);
                setLocation(100, 50);
                setSize(1400, 750);
                setResizable(false);
                getContentPane().setBackground(new Color(255, 250, 250));
                setDefaultCloseOperation(EXIT_ON_CLOSE);

                heading = new JLabel("<html><p style = 'border-bottom: 3px solid rgb(77, 77, 77);'>User Details Table</p></html>");
                heading.setFont(new Font("Monospaced", Font.BOLD, 32));
                heading.setBounds(480, 20, 400, 50);
                heading.setForeground(new Color(77, 77, 77));
                add(heading);
                
                JLabel lbl = new JLabel("Search by user's first name :");
                lbl.setFont(new Font("Arial", Font.BOLD, 18));
                lbl.setBounds(50, 90, 280, 40);
                add(lbl);

                chooseuser = new Choice();
                chooseuser.setBackground(getContentPane().getBackground());
                chooseuser.requestFocus();
        	chooseuser.setBounds(330, 100, 200, 40);
	        chooseuser.setFont(new Font("Arial", Font.PLAIN, 17));
        	add(chooseuser);

                search = new JButton("Search");
                search.setBounds(50, 150,120, 30);
                search.setFocusPainted(false);
                search.setBackground(getContentPane().getBackground());
                search.setForeground(new Color(77, 77, 77));
                search.setBorder(BorderFactory.createLineBorder(new Color(77, 77, 77), 2, true));
                search.setFont(new Font("Arial", Font.BOLD, 18));
                search.addActionListener(this);
                add(search);

                back = new JButton("Back");
                back.setBounds(300, 150, 120, 30);
                back.setFocusPainted(false);
                back.setBackground(getContentPane().getBackground());
                back.setBorder(BorderFactory.createLineBorder(new Color(77, 77, 77), 2, true));
                back.setFont(new Font("Arial", Font.BOLD, 18));
                back.setForeground(new Color(77, 77, 77));
                back.addActionListener(this);
                add(back);

                uImg = new ImageIcon(ClassLoader.getSystemResource("images/user.png"));
                uImg2 = uImg.getImage().getScaledInstance(250, 180, Image.SCALE_SMOOTH);
                uLbl = new JLabel(new ImageIcon(uImg2));
	        uLbl.setBounds(1100, 5, 250, 180);
	        add(uLbl);
                
                try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("select * from studentdetails");
		while(rs.next()){
			chooseuser.add(rs.getString("firstname"));
		}
	        } catch(Exception e){
		e.printStackTrace();
	        }
	
	        uTable = new JTable();
	try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("select * from studentdetails");
		uTable.setModel(DbUtils.resultSetToTableModel(rs));
	}catch(Exception e){
		e.printStackTrace();
	}
        
	JScrollPane jsp = new JScrollPane(uTable);
	jsp.setBounds(5, 250, 1380, 450);
        
        columnModel = uTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(70);
        columnModel.getColumn(2).setPreferredWidth(70);
        columnModel.getColumn(3).setPreferredWidth(160);
        columnModel.getColumn(4).setPreferredWidth(65);
        columnModel.getColumn(5).setPreferredWidth(80);
        columnModel.getColumn(6).setPreferredWidth(70);
        columnModel.getColumn(7).setPreferredWidth(60);
        columnModel.getColumn(8).setPreferredWidth(70);
        columnModel.getColumn(9).setPreferredWidth(60);
        columnModel.getColumn(10).setPreferredWidth(80);

        uTable.setBackground(getContentPane().getBackground());
        uTable.getTableHeader().setBackground(getContentPane().getBackground());
        uTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 17));
        uTable.getTableHeader().setPreferredSize(new Dimension(jsp.getWidth(), 30));
	uTable.setFont(new Font("Arial", Font.PLAIN, 17));
        uTable.setFillsViewportHeight(true);
        uTable.setRowHeight(25);
        uTable.setGridColor(new Color(77, 77, 77));
        uTable.setEnabled(false);

        jsp.setBorder(BorderFactory.createEmptyBorder());
	add(jsp);
        setVisible(true); 
        }
        
        public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == search){
			String query = "select * from studentdetails where firstname = '"+chooseuser.getSelectedItem()+"'";
			try{
				Conn c =new Conn();
				ResultSet rs = c.s.executeQuery(query);
				uTable.setModel(DbUtils.resultSetToTableModel(rs));
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
                new UserDetails();
        }
}