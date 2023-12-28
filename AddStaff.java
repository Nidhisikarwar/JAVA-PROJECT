package class_files;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddStaff extends JFrame implements ActionListener{
    Random sid = new Random();
    int number = sid.nextInt(999999);

    JComboBox cbeducation;
    JLabel labelsid;
    JTextField tfsname, tffname, tfsalary, tfdob, tfaddress, tfemail, tfphone;
    JButton add, back;
    ImageIcon img;
    JLabel imgLbl;
    Image img2;

    AddStaff(){
        getContentPane().setBackground(Color.WHITE);
        setTitle("Add Staff");
        setLayout(null);

        img  =  new ImageIcon(ClassLoader.getSystemResource("./images/addmember.png"));
        img2  =  img.getImage().getScaledInstance(330, 650, Image.SCALE_SMOOTH);
        imgLbl  =  new JLabel(new ImageIcon(img2));
        imgLbl.setBounds(820, 0, 330, 630);
        add(imgLbl);

        JLabel heading = new JLabel("<html><p style = 'border-bottom: 3px solid rgb(BLACK);'> New Staff Member </p></html>");
        heading.setBounds(420,30,500,50);
        heading.setFont(new Font("Monospaced",Font.BOLD,33));
        heading.setBackground(Color.WHITE);
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel labelsname = new JLabel("Name:");
        labelsname.setBounds(50,120,180,65);
        labelsname.setFont(new Font("Arial",Font.BOLD,18));
        add(labelsname);

        tfsname = new JTextField();
        tfsname.setBounds(190,140,180,30);
        tfsname.setFont(new Font("Arial",Font.BOLD,16));
        add(tfsname);


        JLabel labelfname = new JLabel("Fathers Name:");
        labelfname.setBounds(430,120,180,65);
        labelfname.setFont(new Font("Arial",Font.BOLD,18));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(620,140,180,30);
        tffname.setFont(new Font("Arial",Font.BOLD,16));
        add(tffname);

        JLabel labelsalary = new JLabel("Salary:");
        labelsalary.setBounds(430,170,170,65);
        labelsalary.setFont(new Font("Arial",Font.BOLD,18));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(620,190,180,30);
        tfsalary.setFont(new Font("Arial",Font.BOLD,16));
        add(tfsalary);

        JLabel labeldob = new JLabel("Date of Birth:");
        labeldob.setBounds(50,170,170,65);
        labeldob.setFont(new Font("Arial",Font.BOLD,18));
        add(labeldob);

        /*JDateChooser dcdob = new JDateChooser();
        dcdob.setBounds(150,190,170,50);
        add(dcdob);*/

        tfdob = new JTextField();
        tfdob.setBounds(190,190,180,30);
        tfdob.setFont(new Font("Arial",Font.BOLD,16));
        add(tfdob);

        JLabel labeladdress = new JLabel("Address:");
        labeladdress.setBounds(50,220,170,65);
        labeladdress.setFont(new Font("Arial",Font.BOLD,18));
        add(labeladdress);

        tfaddress  = new JTextField();
        tfaddress.setBounds(190,240,180,30);
        tfaddress.setFont(new Font("Arial",Font.BOLD,16));
        add(tfaddress);

        JLabel labelemail = new JLabel("Email Address:");
        labelemail.setBounds(430,270,170,65);
        labelemail.setFont(new Font("Arial",Font.BOLD,18));
        add(labelemail);

        tfemail  =  new JTextField();
        tfemail.setBounds(620,290,180,30);
        tfemail.setFont(new Font("Arial",Font.BOLD,16));
        add(tfemail);

        JLabel labelphone = new JLabel("Phone number:");
        labelphone.setBounds(50,270,180,65);
        labelphone.setFont(new Font("Arial",Font.BOLD,18));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(190,290,180,30);
        tfphone.setFont(new Font("Arial",Font.BOLD,16));
        add(tfphone);

        JLabel labeleducation = new JLabel("Highest education:");
        labeleducation.setBounds(430,220,170,65);
        labeleducation.setFont(new Font("Arial",Font.BOLD,18));
        add(labeleducation);

        String[] courses = {"BBA","BCA","BA","B.COM","BTech","MBA","BSC","MSC","MTech","Phd"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(620,240,180,30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);

        JLabel labelstaffid = new JLabel("Staff Id:");
        labelstaffid.setBounds(50,360,170,50);
        labelstaffid.setFont(new Font("Arial",Font.BOLD,20));
        add(labelstaffid);

        labelsid  =  new JLabel(""+ number);
        labelsid.setBounds(200,360,170,50);
        labelsid.setFont(new Font("Arial",Font.BOLD,20));
        add(labelsid);

        add = new JButton("Add Member");
        add.setBounds(200,460,170,50);
        add.setFont(new Font("Arial",Font.PLAIN,18));
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add(add);
        

        back = new JButton("Back");
        back.setBounds(460,460,170,50);
        back.setFont(new Font("Arial",Font.PLAIN,18));
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setFocusPainted(false);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(1150,600);
        setLocation(200,80);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
	
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String memberName = tfsname.getText();
            String fatherName = tffname.getText();
            String dob = tfdob.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String education = (String)cbeducation.getSelectedItem();
            String phone  = tfphone.getText();
            String email  = tfemail.getText();
            String staffId = labelsid.getText();
            if(memberName.length() != 0 && fatherName.length() != 0 && dob.length() != 0 && salary.length() != 0 && address.length() != 0 && education.length() != 0 && phone.length() != 0 && email.length() != 0 && staffId.length() != 0){
                    try{
                        Conn conn = new Conn();
                        String query = "insert into staffdetails values('"+memberName+"','"+fatherName+"','"+dob+"','"+salary+"','"+address+"','"+education+"','"+phone+"','"+email+"','"+staffId+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "New Member Details Added Successfully");
                        setVisible(false);
                        new StaffDetails();
                    } catch(Exception e){
                        e.printStackTrace();
                    }
            }
            else{
                    JOptionPane.showMessageDialog(null, "All Details Field are Mandatory");
            }
        }
        else{
        setVisible(false);
        new Dashboard();
    }
}
    public static void main(String args[]){
        new AddStaff();
    }
}
  