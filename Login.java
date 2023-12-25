package class_files;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame /*implements ActionListener*/{
    JTextField tfusername,tfpassword;
    //JCheckBox cbnew;
    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel Heading=new JLabel("Login Page");
        Heading.setBounds(160,80,200,80);
        Heading.setFont(new Font("Arial",Font.BOLD,34));
        add(Heading);

        JLabel lblusername=new JLabel("Username:");
        lblusername.setBounds(80,180,150,50);
        lblusername.setFont(new Font("Arial",Font.BOLD,20));
        add(lblusername);

        JTextField tfusername =new JTextField();
        tfusername.setBounds(200,190,150,30);
        add(tfusername);

        JLabel lblpassword=new JLabel("Password:");
        lblpassword.setBounds(80,240,150,50);
        lblpassword.setFont(new Font("Arial",Font.BOLD,20));
        add(lblpassword);

        JPasswordField tfpassword =new JPasswordField();
        tfpassword .setBounds(200,250,150,30);
        add(tfpassword);

        /*JCheckBox cbnew=new JCheckBox("Show Password");
        cbnew.addActionListener(this); 
         cbnew.setBounds(200,280,150,30);*/
    
        JButton jblogin=new JButton("LOGIN");
        jblogin.setBounds(175,360,150,40);
        jblogin.setBackground(Color.BLACK);
        jblogin.setForeground(Color.WHITE);
        jblogin.setFont(new Font("Arial",Font.BOLD,18));
        jblogin.setFocusPainted(false);
        //jblogin.addActionListener(this);
        add(jblogin);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./images/login.png"));
        Image i2 = i1.getImage().getScaledInstance(500,450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(310,0,700,600);
        add(img); 

        setSize(1000,600);
        setLocation(380,180);
        setVisible(true);



    }
   /*public void actionPerformed(ActionEvent ae){
       // setVisible(false);
        //new Dashboard();
        try{
            String username=tfusername.getText();
            String password=tfpassword.getText();


            Conn c=new Conn();
            String query ="select * from login where username= '"+ username+"' and password ='"+ password+"'";

            ResultSet rs= c.s.executeQuery(query);
            if(rs.next()){
                  setVisible(false);
                  Dashboard();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                setVisible(false);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }*/
    /*public void actionPerformed(ActionEvent ae){
                if(cbnew.isSelected())
                {
                    ((JPasswordField) tfpassword).setEchoChar((char)0);
                }
                else{
                    ((JPasswordField) tfpassword).setEchoChar('*');
                }
       
    }*/
    public static void main(String args[]){
        new Login();
    }
}