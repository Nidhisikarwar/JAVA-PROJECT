package class_files;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateStaff extends JFrame/* implements ActionListener*/{
    Random sid=new Random();
    int number=sid.nextInt(999999);

    JTextField tfsname,tffname,tfsalary,tfdob,tfaddress,tfemail,tfphone,tfeducation; 
    JButton add,back;
    String memberName;

    UpdateStaff(String memberName){
        this.memberName=memberName;
        getContentPane().setBackground(Color.WHITE);//background is white
        setLayout(null);
        setTitle("Update Staff details");

        JLabel heading=new JLabel("<html><p style='border-bottom: 3px solid rgb(BLACK);'> Update Staff Details </p></html>");
        heading.setBounds(230,37,500,50);
        heading.setFont(new Font("MONOSPACED",Font.BOLD,30));
        heading.setBackground(Color.WHITE);
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel labelsname=new JLabel("Name:");
        labelsname.setBounds(50,120,180,65);
        labelsname.setFont(new Font("Arial",Font.BOLD,18));
        add(labelsname);

        JLabel lblname=new JLabel();
        lblname.setBounds(200,140,180,30);
        add(lblname);

        JLabel labelfname=new JLabel("Fathers Name:");
        labelfname.setBounds(430,120,180,65);
        labelfname.setFont(new Font("Arial",Font.BOLD,18));
        add(labelfname);

        tffname=new JTextField();
        tffname.setBounds(600,140,180,30);
        add(tffname);

        JLabel labelsalary=new JLabel("Salary:");
        labelsalary.setBounds(430,170,170,65);
        labelsalary.setFont(new Font("Arial",Font.BOLD,18));
        add(labelsalary);

        JLabel lblsalary=new JLabel();
        lblsalary.setBounds(600,190,180,30);
        add(lblsalary);

        JLabel labeldob=new JLabel("Date of Birth:");
        labeldob.setBounds(50,170,170,65);
        labeldob.setFont(new Font("Arial",Font.BOLD,18));
        add(labeldob);

        /*JDateChooser dcdob=new JDateChooser();
        dcdob.setBounds(150,190,170,50);
        add(dcdob);*/

        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,190,180,30);
        add(lbldob);

        JLabel labeladdress=new JLabel("Address:");
        labeladdress.setBounds(50,220,170,65);
        labeladdress.setFont(new Font("Arial",Font.BOLD,18));
        add(labeladdress);

        tfaddress =new JTextField();
        tfaddress.setBounds(200,240,180,30);
        add(tfaddress);

        JLabel labelemail=new JLabel("Email Address:");
        labelemail.setBounds(430,270,170,65);
        labelemail.setFont(new Font("Arial",Font.BOLD,18));
        add(labelemail);

        tfemail=new JTextField();
        tfemail.setBounds(600,290,180,30);
        add(tfemail);

        JLabel labelphone=new JLabel("Phone number:");
        labelphone.setBounds(50,270,180,65);
        labelphone.setFont(new Font("Arial",Font.BOLD,18));
        add(labelphone);

        tfphone=new JTextField();
        tfphone.setBounds(200,290,180,30);
        add(tfphone);

        JLabel labeleducation=new JLabel("Highest education:");
        labeleducation.setBounds(430,220,170,65);
        labeleducation.setFont(new Font("Arial",Font.BOLD,18));
        add(labeleducation);

        /*tfeducation=new JTextField();
        tfeducation.setBounds(600,240,180,30);
        add(tfeducation); */

        //String courses[]={"BBA","BCA","BA","B.COM","BTech","MBA","BSC","MSC","MTech","Phd"};
        JTextField tfeducation=new JTextField();
        tfeducation.setBounds(600,240,180,30);
        tfeducation.setBackground(Color.WHITE);
        add(tfeducation);

        JLabel labelstaffid=new JLabel("Staff Id:");
        labelstaffid.setBounds(50,360,170,50);
        labelstaffid.setFont(new Font("Arial",Font.BOLD,20));
        add(labelstaffid);

        JLabel labelsid=new JLabel();
        labelsid.setBounds(200,360,170,50);
        labelsid.setFont(new Font("Arial",Font.BOLD,20));
        add(labelsid);

       /* try{
            Conn c=new Conn();
            String query= "select * from staffdetails where memberName= '"+memberName+"'";
            ResultSet rs=c.s.executeQuery(query);
                while(rs.next()) {
                    lblname.setText(rs.getString("memberName"));
                    tffname.setText(rs.getString("fatherName"));
                    lbldob.setText(rs.getString("dob"));
                    tfaddress.setText(rs.getString("address"));
                    tfsalary.setText(rs.getString("salary"));
                    tfphone.setText(rs.getString("phone"));
                    tfemail.setText(rs.getString("email"));
                    tfeducation.setText(rs.getString("education"));   
                    
                }
            }
        catch(Exception e){
            e.printStackTrace();
        }
         */
        add=new JButton("Update");
        add.setBounds(200,460,170,50);
        add.setFont(new Font("Arial",Font.PLAIN,18));
      //  add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add(add);
        

        back=new JButton("Back");
        back.setBounds(460,460,170,50);
        back.setFont(new Font("Arial",Font.PLAIN,18));
       // back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setFocusPainted(false);
        back.setForeground(Color.WHITE);


        setSize(860,650);
        setLocation(300,50);
        setVisible(true);
        setResizable(false);
        add(back);
        
    }

   
    public static void main(String args[]){
        new UpdateStaff("");
    }
}
  