package class_files;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveBook extends JFrame implements ActionListener{

    Choice cbookname;
    JButton delete,back;


    RemoveBook(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);

        JLabel labelbookname=new JLabel("Book Name");
        labelbookname.setBounds(50,50,100,30);
        labelbookname.setForeground(Color.BLACK);
        add(labelbookname);

        cbookname=new Choice();
        cbookname.setBounds(200,50,100,30); 
        add(cbookname);  

        JLabel labelbookid=new JLabel("Book Id");
        labelbookid.setBounds(50,50,100,30);
        labelbookid.setForeground(Color.BLACK);
        add(labelbookid);

        JLabel lblbookid=new JLabel();
        lblbookid.setBounds(50,100,100,30);
        add(lblbookid);

        JLabel labelauthor=new JLabel("Author Name");
        labelbookid.setBounds(50,50,100,30);
        labelbookid.setForeground(Color.BLACK);
        add(labelbookid);

        JLabel lblauthor=new JLabel();
        lblauthor.setBounds(50,100,100,30);
        add(lblauthor);
        
        JLabel labelpublisher=new JLabel("Publisher Name");
        labelpublisher.setBounds(50,50,100,30);
        labelpublisher.setForeground(Color.BLACK);
        add(labelpublisher);

        JLabel lblpublisher=new JLabel();
        lblpublisher.setBounds(50,100,100,30);
        add(lblpublisher);
        

           /* cbookname.addItemListener(new ItemListener() {
                public void itemStateChanged(itemEvent ie) {
            try{
            Conn c=new Conn();
            String query ="select * from bookdetails where bookName = '"+cbookname.getSelectedItem()+"'"; 
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                 //cbookname.add(rs.getString("bookName"));

                lblbookid.setText(rs.getString("bookId"));
                lblauthor.setText(rs.getString("authName"));
                lblpublisher.setText(rs.getString("publisher"));
               }
            }
            catch(Exception e) {
            e.printStackTrace();
            }
            }
            });
*/
            delete=new JButton("Delete");
            delete.setBounds(220,300,100,30);
            delete.setBackground(Color.BLACK);
            delete.setForeground(Color.WHITE);
            delete.addActionListener(this);
            add(delete);

            back= new JButton("Back");
            back.setBounds(220,300,100,30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
            add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./images/book.png"));
        Image i2 = i1.getImage().getScaledInstance(200,240, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(310,8,700,600);
        add(img);

        setSize(1000,800);
        setLocation(300,150);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String args[]){
        new RemoveBook();
    }
}
