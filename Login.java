package class_files;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField tfusername,tfpassword;
    JCheckBox cbnew;
    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel Heading=new JLabel("Login Page");
        Heading.setBounds(160,80,200,80);
        Heading.setFont(new Font("Arial",Font.BOLD,34));
        add(Heading);

        Font lblFont = new Font("Arial",Font.BOLD,20);
        Font tfFont = new Font("Arial",Font.PLAIN,18);
        
        JLabel lblusername=new JLabel("Username:");
        lblusername.setBounds(80,180,150,50);
        lblusername.setFont(lblFont);
        add(lblusername);

        tfusername =new JTextField();
        tfusername.setBounds(200,190,150,30);
        tfusername.setFont(tfFont);
        add(tfusername);

        JLabel lblpassword=new JLabel("Password:");
        lblpassword.setBounds(80,240,150,50);
        lblpassword.setFont(lblFont);
        add(lblpassword);

        tfpassword =new JPasswordField();
        tfpassword .setBounds(200,250,150,30);
        tfpassword.setFont(tfFont);
        ((JPasswordField) tfpassword).setEchoChar('*');
        add(tfpassword);

        cbnew=new JCheckBox("Show Password");
        cbnew.addActionListener(this); 
        cbnew.setBounds(80,305,125,35);
	cbnew.setFont(new Font("Arial",Font.BOLD,13));
	cbnew.setBackground(Color.WHITE);
	cbnew.setSelected(false);
	add(cbnew);

        
    
        JButton jblogin=new JButton("LOGIN");
        jblogin.setBounds(175,380,150,40);
        jblogin.setBackground(Color.BLACK);
        jblogin.setForeground(Color.WHITE);
        jblogin.setFont(new Font("Arial",Font.BOLD,18));
        jblogin.setFocusPainted(false);
        jblogin.addActionListener(this);
        add(jblogin);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./images/login.png"));
        Image i2 = i1.getImage().getScaledInstance(500,450, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(350,0,700,600);
        add(img); 

        setSize(1050,600);
        setLocation(300,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
}
    
   public void actionPerformed(ActionEvent ae){
        try{
            String username=tfusername.getText();
            String password=tfpassword.getText();
            Conn c=new Conn();
            String query ="select * from login where username = '"+ username+"' and binary password = '"+ password+"' ";
            ResultSet rs= c.s.executeQuery(query);
	    if(ae.getSource() == cbnew){
		if(cbnew.isSelected()){
                    ((JPasswordField) tfpassword).setEchoChar((char)0);
		}
		else{
                    ((JPasswordField) tfpassword).setEchoChar('*');
		}
	    }
	    else{
		if(rs.next()){
			setVisible(false);
			new Dashboard();
		}
		else{
			JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                }
	    }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
   
    public static void main(String args[]){
        new Login();
    }
}