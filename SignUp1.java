package class_files;

import java.awt.*;
import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
public class SignUp1 extends JFrame implements ActionListener{
    //Random sid=new Random();SignUp1.java
    //int number=sid.nextInt(999999);

    JTextField tfstuname,tflname,tfemail,tfphone,tfdob; 
    JButton add,back;
    JPasswordField tfpassword,tfcpassword;
    JCheckBox cbnew;
    SignUp1(){
        getContentPane().setBackground(Color.WHITE);//background is white
        setLayout(null);

        JLabel heading=new JLabel("Sign up ");
        heading.setBounds(630,37,500,40);
        heading.setFont(new Font("Monospaced",Font.BOLD,30));
        heading.setBackground(Color.WHITE);
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel labelsname=new JLabel("First Name:");
        labelsname.setBounds(530,100,180,30);
        labelsname.setFont(new Font("Arial",Font.PLAIN,14));
        add(labelsname);
        
        tfstuname=new JTextField();
        tfstuname.setBounds(670,105,180,30);
        tfstuname.setFont(new Font("Arial",Font.PLAIN,14));
        add(tfstuname);
        
        JLabel labellname=new JLabel("Last Name:");
        labellname.setBounds(530,150,180,30);
        labellname.setFont(new Font("Arial",Font.PLAIN,14));
        add(labellname);

        tflname=new JTextField();
        tflname.setBounds(670,155,180,30);
        tflname.setFont(new Font("Arial",Font.PLAIN,14));
        add(tflname);
        
        JLabel labelphone=new JLabel("Phone number:");
        labelphone.setBounds(530,200,180,30);
        labelphone.setFont(new Font("Arial",Font.PLAIN,14));
        add(labelphone);

        tfphone=new JTextField();
        tfphone.setBounds(670,205,180,30);
        tfphone.setFont(new Font("Arial",Font.PLAIN,14));
        add(tfphone);
       
        JLabel labelemail=new JLabel("Email Address:");
        labelemail.setBounds(530,250,180,30);
        labelemail.setFont(new Font("Arial",Font.PLAIN,14));
        add(labelemail);

        tfemail=new JTextField();
        tfemail.setBounds(670,255,180,30);
        tfemail.setFont(new Font("Arial",Font.PLAIN,14));
        add(tfemail);

        JLabel labelpassword=new JLabel("Enter Password:");
        labelpassword.setBounds(530,300,180,30);
        labelpassword.setFont(new Font("Arial",Font.PLAIN,14));
        add(labelpassword);

        tfpassword =new JPasswordField();
        tfpassword .setBounds(670,305,180,30);
        tfpassword.setFont(new Font("Arial",Font.BOLD,14));
        ((JPasswordField) tfpassword).setEchoChar('*');
        add(tfpassword);

        JLabel labelcpassword=new JLabel("Confirm Password:");
        labelcpassword.setBounds(530,350,180,30);
        labelcpassword.setFont(new Font("Arial",Font.PLAIN,14));
        add(labelcpassword);

        tfcpassword =new JPasswordField();
        tfcpassword .setBounds(670,355,180,30);
        tfcpassword.setFont(new Font("Arial",Font.BOLD,14));
        ((JPasswordField) tfcpassword).setEchoChar('*');
        add(tfcpassword);

        cbnew=new JCheckBox("Show Password");
        //cbnew.addActionListener(this); 
        cbnew.setBounds(670,390,125,35);
	    cbnew.setFont(new Font("Arial",Font.BOLD,13));
	    cbnew.setBackground(Color.WHITE);
	    cbnew.setSelected(false);
	    add(cbnew);
        
      /*  JLabel labeldob=new JLabel("Dob:");
        labeldob.setBounds(530,350,170,30);
        labeldob.setFont(new Font("Arial",Font.PLAIN,14));
        add(labeldob);

        tfdob=new JTextField();
        tfdob.setBounds(670,355,180,30);
        tfdob.setFont(new Font("Arial",Font.PLAIN,14));
        add(tfdob);
        
        JDateChooser dcdob=new JDateChooser();
        dcdob.setBounds(670,355,170,50);
        dcdob.setForeground(new Color(105,105,105));
        add(dcdob);
*/

      
         
        add=new JButton("Create Account");
        add.setBounds(500,460,170,30);
        add.setFont(new Font("Arial",Font.PLAIN,18));
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add(add);
        

        back=new JButton("Back");
        back.setBounds(750,460,150,30);
        back.setFont(new Font("Arial",Font.PLAIN,18));
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setFocusPainted(false);
        back.setForeground(Color.WHITE);


        setSize(1050,600);
        setLocation(300,50);
        setVisible(true);
        setResizable(false);
        add(back);
        
        
    }
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cbnew){
            if(cbnew.isSelected()){
                        ((JPasswordField) tfpassword).setEchoChar((char)0);
            }
            else{
                        ((JPasswordField) tfpassword).setEchoChar('*');
            }
}
        else if{
        
        if (ae.getSource() == add){
     
        if(!(new String(tfpassword.getPassword()).equals(new String(tfcpassword.getPassword())))){
             JOptionPane.showMessageDialog(null, "Your password doesn't Match");
        }
    else{
            JOptionPane.showMessageDialog(null, "Your password Match");}}
         /*   String studentFirstName = tfstuname.getText();
            String lastName = tflname.getText();
            String studentPhone= tfphone.getText();
            String studentPassword= new String(tfpassword.getPassword());
            String studentEmail = tfemail.getText();
           // String studentDob=((JTextField) dateChooser.getDateEditor().getUIComponent()).getText();
            
            if(studentFirstName.length() != 0  && studentPhone.length() != 0 && studentEmail.length() != 0 ){
                    try{
                        Conn conn = new Conn();
                        
                        String query = "insert into studentdetails values('"+studentFirstName+"','"+lastName+"','"+studentPhone+"','"+studentEmail+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Your Student Account is created");
                        setVisible(false);
                        new Login();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
            }
            else{
                    JOptionPane.showMessageDialog(null, "All Details Field are Mandatory");
            }
        }}*/
        else{
        setVisible(false);
        //new Login();
    }}
        else{
            setVisible(false);
        }
        
    public static void main(String args[]){
        new SignUp1();
    }
}
  


