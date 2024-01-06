package class_files;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class SignUp extends JFrame implements ActionListener{
    JTextField tfstuname,tflname,tfemail,tfphone,tfusername; 
    JButton sign,back;
    JPasswordField tfpassword,tfcpassword;
    JCheckBox cbnew;
    JLabel heading;
    SignUp(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./images/signup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,575, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(0,4,490,560);
        add(img);
        
        heading = new JLabel("<html><p style = 'border-bottom: 8px solid rgb(237, 165, 31);'>Sign up</p></html>");
        heading.setBounds(650,25,500,40);
        heading.setFont(new Font("Monospaced",Font.BOLD,32));
        heading.setForeground(new Color(237, 165, 31));
        add(heading);
        
        JLabel labelsname=new JLabel("First Name :");
        labelsname.setBounds(500,110,180,30);
        labelsname.setFont(new Font("Arial",Font.BOLD,16));
        labelsname.setForeground(new Color(141, 35,109));
        add(labelsname);
        
        tfstuname=new JTextField();
        tfstuname.setBounds(670,110,225,30);
        tfstuname.setFont(new Font("Arial",Font.PLAIN,15));
        tfstuname.setBorder(BorderFactory.createLineBorder(new Color(141, 35, 109), 2, true));
        add(tfstuname);
        
        JLabel labellname=new JLabel("Last Name :");
        labellname.setBounds(500,155,180,30);
        labellname.setFont(new Font("Arial",Font.BOLD,16));
        labellname.setForeground(new Color(141, 35,109));
        add(labellname);

        tflname=new JTextField();
        tflname.setBounds(670,155,225,30);
        tflname.setFont(new Font("Arial",Font.PLAIN,15));
        tflname.setBorder(BorderFactory.createLineBorder(new Color(141, 35, 109), 2, true));
        add(tflname);
        
        JLabel labelphone=new JLabel("Phone number :");
        labelphone.setBounds(500,205,180,30);
        labelphone.setFont(new Font("Arial",Font.BOLD,16));
        labelphone.setForeground(new Color(141, 35,109));
        add(labelphone);

        tfphone=new JTextField();
        tfphone.setBounds(670,205,225,30);
        tfphone.setFont(new Font("Arial",Font.PLAIN,15));
        tfphone.setBorder(BorderFactory.createLineBorder(new Color(141, 35, 109), 2, true));
        add(tfphone);
       
        JLabel labelemail=new JLabel("Email Address :");
        labelemail.setBounds(500,255,180,30);
        labelemail.setFont(new Font("Arial",Font.BOLD,16));
        labelemail.setForeground(new Color(141, 35,109));
        add(labelemail);

        tfemail=new JTextField();
        tfemail.setBounds(670,255,225,30);
        tfemail.setFont(new Font("Arial",Font.PLAIN,15));
        tfemail.setBorder(BorderFactory.createLineBorder(new Color(141, 35, 109), 2, true));
        add(tfemail);
        
        JLabel labelusername = new JLabel("Username :");
        labelusername.setBounds(500,306,180,30);
        labelusername.setFont(new Font("Arial",Font.BOLD,16));
        labelusername.setForeground(new Color(141, 35,109));
        add(labelusername);

        tfusername = new JTextField();
        tfusername.setBounds(670, 305, 225, 30);
        tfusername.setFont(new Font("Arial", Font.PLAIN, 15));
        tfusername.setBorder(BorderFactory.createLineBorder(new Color(141, 35, 109), 2, true));
        add(tfusername);

        JLabel labelpassword=new JLabel("Enter Password :");
        labelpassword.setBounds(500,356,180,30);
        labelpassword.setFont(new Font("Arial",Font.BOLD,16));
        labelpassword.setForeground(new Color(141, 35,109));
        add(labelpassword);

        tfpassword =new JPasswordField();
        tfpassword .setBounds(670,355,225,30);
        tfpassword.setFont(new Font("Arial",Font.PLAIN,15));
        ((JPasswordField) tfpassword).setEchoChar('*');
        tfpassword.setBorder(BorderFactory.createLineBorder(new Color(141, 35, 109), 2, true));
        add(tfpassword);

        JLabel labelcpassword=new JLabel("Re-enter Password :");
        labelcpassword.setBounds(500,406,180,30);
        labelcpassword.setFont(new Font("Arial",Font.BOLD,16));
        labelcpassword.setForeground(new Color(141, 35,109));
        add(labelcpassword);

        tfcpassword =new JPasswordField();
        tfcpassword .setBounds(670,405,225,30);
        tfcpassword.setFont(new Font("Arial",Font.PLAIN,15));
        ((JPasswordField) tfcpassword).setEchoChar('*');
        tfcpassword.setBorder(BorderFactory.createLineBorder(new Color(141, 35, 109), 2, true));
        add(tfcpassword);

        cbnew=new JCheckBox("Show Password");
        cbnew.addActionListener(this); 
        cbnew.setBounds(775,450,125,35);
	cbnew.setFont(new Font("Arial",Font.BOLD,13));
	cbnew.setBackground(Color.WHITE);
        cbnew.setForeground(new Color(141, 35,109));
	cbnew.setSelected(false);
	add(cbnew);

        sign = new JButton(" Sign up");
        sign.setBounds(500,520,180,30);
        sign.setFont(new Font("Arial",Font.BOLD,18));
        sign.addActionListener(this);
        sign.setBackground(new Color(237, 165, 31));
        sign.setForeground(Color.WHITE);
        sign.setFocusPainted(false);
        add(sign);
        
        back = new JButton("Login");
        back.setBounds(720,520,180,30);
        back.setFont(new Font("Arial",Font.BOLD,18));
        back.addActionListener(this);
        back.setBackground(new Color(237, 165, 31));
        back.setFocusPainted(false);
        back.setForeground(Color.WHITE);
        add(back);

        setTitle("Sign Up - Library");
        setSize(1050,650);
        setLocation(150,50);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cbnew){
            if(cbnew.isSelected()){
                        ((JPasswordField) tfpassword).setEchoChar((char)0);
                        ((JPasswordField) tfcpassword).setEchoChar((char)0);
            }
            else{
                        ((JPasswordField) tfpassword).setEchoChar('*');
                        ((JPasswordField) tfcpassword).setEchoChar('*');
            }
        }
        else if(ae.getSource() == sign){
                String firstName = tfstuname.getText();
                String lastName = tflname.getText();
                String sphone= tfphone.getText();
                String password= new String(tfpassword.getPassword());
                String semail = tfemail.getText();
                String username = tfusername.getText();
                String none = "- -";
                // String studentDob=((JTextField) dateChooser.getDateEditor().getUIComponent()).getText();

                if(firstName.length() < 3 || lastName.length() < 3){
                        JOptionPane.showMessageDialog(null, "Name should be minimum 3 characters long");}
                else if(sphone.length() != 10){
                        JOptionPane.showMessageDialog(null, "Phone number should be of 10 digits.");}
                else if(!(semail.contains("@") && semail.contains("mail.com"))){
                        JOptionPane.showMessageDialog(null, "Enter a valid email address.");}
                else if(username.length() < 6){
                        JOptionPane.showMessageDialog(null, "Username should be atleast 6 characters long.");}
                else if(password.length() < 8){
                        JOptionPane.showMessageDialog(null, "Password length should be minimum 8 characters.");}
                else if(!(new String(tfpassword.getPassword()).equals(new String(tfcpassword.getPassword())))){
                        JOptionPane.showMessageDialog(null, "Your password doesn't Match");}
                else{
                        try{
                                        Conn c = new Conn();
                                        String query = "insert into studentdetails values('"+firstName+"', '"+lastName+"', '"+sphone+"' , '"+semail+"' , '"+username+"', '"+none+"', '"+none+"', '"+none+"', '"+none+"', '"+none+"', '"+none+"')";
                                        String query2 = "insert into login values('"+username+"' ,'"+password+"')";
                                        c.s.executeUpdate(query);
                                        c.s.executeUpdate(query2);
                                        JOptionPane.showMessageDialog(null, "Your Student Account is created");
                                        setVisible(false);
                                        new Login();
                                } catch(Exception e){
                                        e.printStackTrace();
                                }
                }
        }
        else{
            setVisible(false);
            new Login();
        }
    }   
    public static void main(String args[]){
        new SignUp();
    }
}
 