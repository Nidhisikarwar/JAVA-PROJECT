package class_files;

//import class_files.Conn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveBook extends JFrame implements ActionListener{
        Choice cbookname;
        JButton delete,back;
        JLabel lbledition, lblbookid, lblauthor, lblpublisher, lblpages, lblprice;

    RemoveBook(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        
        JLabel labelheading=new JLabel("Remove Book");
        labelheading.setBounds(280,30,240,40);
        labelheading.setForeground(Color.BLACK);
        labelheading.setFont(new Font("MONOSPACED",Font.BOLD,30));
        add(labelheading);
        
        
        JLabel labelbookname=new JLabel("Search by Book Name:");
        labelbookname.setBounds(50,95,200,30);
        labelbookname.setForeground(Color.BLACK);
        labelbookname.setFont(new Font("Arial",Font.PLAIN,18));
        add(labelbookname);

        cbookname=new Choice();
        cbookname.setBounds(260,100,140,30); 
        cbookname.setFont(new Font("Arial",Font.PLAIN,16));
        add(cbookname);  
        
        try{
                        Conn c=new Conn();
                        String query ="select * from bookdetails where bookName = '"+cbookname.getSelectedItem()+"'"; 
                        ResultSet rs= c.s.executeQuery(query);
                        while(rs.next()){
                        cbookname.add(rs.getString("bookName"));
                        }
                } catch(Exception e) {
                        e.printStackTrace();

                }
        
        Font fontl = new Font("Arial",Font.PLAIN,17);
        
        JLabel labeldetails=new JLabel("Your Book details are:");
        labeldetails.setBounds(50,140,250,30);
        labeldetails.setForeground(Color.BLACK);
        labeldetails.setFont(new Font("Arial",Font.PLAIN,18));
        add(labeldetails);

        JLabel labelbookid=new JLabel("Book Id");
        labelbookid.setBounds(50,190,140,30);
        labelbookid.setForeground(Color.BLACK);
        labelbookid.setFont(fontl);
        add(labelbookid);

        lblbookid=new JLabel();
        lblbookid.setBounds(200,200,140,30);
        add(lblbookid);

        JLabel labelauthor=new JLabel("Author Name");
        labelauthor.setBounds(50,230,140,30);
        labelauthor.setForeground(Color.BLACK);
        labelauthor.setFont(fontl);
        add(labelauthor);

        lblauthor=new JLabel();
        lblauthor.setBounds(200,240,140,30);
        add(lblauthor);
        
        JLabel labelpublisher=new JLabel("Publisher Name");
        labelpublisher.setBounds(50,270,140,30);
        labelpublisher.setForeground(Color.BLACK);
        labelpublisher.setFont(fontl);
        add(labelpublisher);

        lblpublisher=new JLabel();
        lblpublisher.setBounds(200,280,140,30);
        add(lblpublisher);
        
        JLabel labelpages=new JLabel("Number of pages");
        labelpages.setBounds(50,310,140,30);
        labelpages.setForeground(Color.BLACK);
        labelpages.setFont(fontl);
        add(labelpages);

        lblpages=new JLabel();
        lblbookid.setBounds(200,320,140,30);
        add(lblpages);
        
        JLabel labelprice=new JLabel("Price");
        labelprice.setBounds(50,350,140,30);
        labelprice.setForeground(Color.BLACK);
        labelprice.setFont(fontl);
        add(labelprice);

        lblprice=new JLabel();
        lblprice.setBounds(200,360,140,30);
        add(lblprice);
        
        JLabel labeledition=new JLabel("Edition");
        labeledition.setBounds(50,390,150,30);
        labeledition.setForeground(Color.BLACK);
        labeledition.setFont(fontl);
        add(labeledition);

        lbledition=new JLabel();
        lbledition.setBounds(200,400,150,30);
        add(lbledition);

       
            
        cbookname.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                 try{
                        Conn c=new Conn();
                        String query ="select * from bookdetails where bookName = '"+cbookname.getSelectedItem()+"'"; 
                        ResultSet rs= c.s.executeQuery(query);
                        while(rs.next()){
                        lblbookid.setText(rs.getString("bookId"));
                        lblauthor.setText(rs.getString("authName"));
                        lblpublisher.setText(rs.getString("publisher"));
                        }
                } catch(Exception e) {
                        e.printStackTrace();
                }
            }});
        
        
        delete=new JButton("Delete");
        delete.setBounds(50,450,130,30);
        delete.setFont(new Font("Arial",Font.PLAIN,16));
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFocusPainted(false);
        delete.addActionListener(this);
        add(delete);

        back= new JButton("Back");
        back.setBounds(230,450,130,30);
        back.setFont(new Font("Arial",Font.PLAIN,16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.addActionListener(this);
        add(back);
            
        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/book.png"));
        Image i2 = i1.getImage().getScaledInstance(300,140, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(310,8,400,200);
        add(img);*/

        setSize(1000,650);
        setLocation(300,150);
        setVisible(true);
    }

   public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==delete){
        try{
            Conn c=new Conn();
            String query="delete from bookDetails where bookName='"+cbookname.getSelectedItem()+"'";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Book Details Removed Successfully");
            setVisible(false);
            }
        catch(Exception e){
              e.printStackTrace();
            }
           }
            else {
                    setVisible(false);
                    new Dashboard();
                } 
              }
            
    public static void main(String args[]){
        new RemoveBook();
    }
}
