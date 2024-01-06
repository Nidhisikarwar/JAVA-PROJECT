package class_files;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField tfusername,tfpassword;
    JCheckBox cbshow;
    JButton sign, jblogin;
    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("<html><p style = 'border-bottom: 3px solid rgb(230, 183, 37);'> Login </p></html>");
        heading.setBounds(180,70,200,80);
        heading.setForeground(new Color(230, 183, 37));
        heading.setFont(new Font("Monospaced",Font.BOLD,35));
        add(heading);

        Font lblFont = new Font("Arial",Font.BOLD,20);
        Font tfFont = new Font("Arial",Font.PLAIN,18);
        
        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(80,180,150,50);
        lblusername.setFont(lblFont);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(200,190,200,30);
        tfusername.setFont(tfFont);
        tfusername.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        add(tfusername);

        JLabel lblpassword = new JLabel("Password :");
        lblpassword.setBounds(80,240,150,50);
        lblpassword.setFont(lblFont);
        add(lblpassword);

        tfpassword =new JPasswordField();
        tfpassword .setBounds(200,250,200,30);
        tfpassword.setFont(tfFont);
        tfpassword.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        ((JPasswordField) tfpassword).setEchoChar('*');
        add(tfpassword);

        cbshow=new JCheckBox("Show Password");
        cbshow.addActionListener(this); 
        cbshow.setBounds(80,305,125,35);
	cbshow.setFont(new Font("Arial",Font.BOLD,13));
        cbshow.setForeground(new Color(38, 50, 56));
	cbshow.setBackground(Color.WHITE);
	cbshow.setSelected(false);
	add(cbshow);

        sign = new JButton("New User");
        sign.setBounds(340,305,60,35);
        sign.setBackground(getContentPane().getBackground());
        sign.setForeground(new Color(38, 50, 56));
        sign.setFont(new Font("Arial",Font.BOLD,13));
        sign.setBorder(BorderFactory.createEmptyBorder());
        sign.setFocusPainted(false);
        sign.addActionListener(this);
        add(sign); 
    
        jblogin = new JButton("LOGIN");
        jblogin.setBounds(80,380,320,40);
        jblogin.setBackground(new Color(230, 183, 37));
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

        setTitle("Login - Library");
        setSize(1025,600);
        setLocation(150,50);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
}
    
   public void actionPerformed(ActionEvent ae){
           if(ae.getSource() == cbshow){
		if(cbshow.isSelected()){
                    ((JPasswordField) tfpassword).setEchoChar((char)0);
		}
		else{
                    ((JPasswordField) tfpassword).setEchoChar('*');
		}
	    }
           else if(ae.getSource() == jblogin){ 
                try{
                        String susername=tfusername.getText();
                        String spassword=tfpassword.getText();
                        Conn c = new Conn();
                        String query="select * from login where susername= '"+susername+"' and binary spassword= '"+spassword+"' ";
                        ResultSet rs= c.s.executeQuery(query);
                        if(rs.next()){
			        setVisible(false);
			        new StudentDashboard(susername);
		        }
		        else{
			        JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                        }
                } catch(Exception e){
                        e.printStackTrace();
                }
           }
           else{
                setVisible(false);
                new SignUp();
           }
    }
   
    public static void main(String args[]){
        new Login();
    }
}