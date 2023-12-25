package class_files;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
    JTextField tfsname, tffname, tfsalary, tfdob, tfaddress, tfemail, tfphone, tfeducation;
    JButton add, back;
    ImageIcon img;
    Image img2;
    JLabel imJLbl;

    AddStaff(){
        getContentPane().setBackground(Color.WHITE);//background is white
        setLayout(null);

        ImageIcon img  =  new ImageIcon(ClassLoader.getSystemResource("./images/addmember.png"));
        Image img2  =  img.getImage().getScaledInstance(300, 500, Image.SCALE_AREA_AVERAGING);
        JLabel imgLbl  =  new JLabel(new ImageIcon(img2));
        imgLbl.setBounds(850, 0, 250, 600);
        add(imgLbl);

        JLabel heading = new JLabel("<html><p style = 'border-bottom: 3px solid rgb(BLACK);'> New Staff Member </p></html>");
        heading.setBounds(280,37,500,50);
        heading.setFont(new Font("arial",Font.BOLD,30));
        heading.setBackground(Color.WHITE);
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel labelsname = new JLabel("Name:");
        labelsname.setBounds(50,120,180,65);
        labelsname.setFont(new Font("arial",Font.BOLD,18));
        add(labelsname);

        tfsname = new JTextField();
        tfsname.setBounds(190,140,180,30);
        add(tfsname);


        JLabel labelfname = new JLabel("Fathers Name:");
        labelfname.setBounds(430,120,180,65);
        labelfname.setFont(new Font("arial",Font.BOLD,18));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(620,140,180,30);
        add(tffname);

        JLabel labelsalary = new JLabel("Salary:");
        labelsalary.setBounds(430,170,170,65);
        labelsalary.setFont(new Font("arial",Font.BOLD,18));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(620,190,180,30);
        add(tfsalary);

        JLabel labeldob = new JLabel("Date of Birth:");
        labeldob.setBounds(50,170,170,65);
        labeldob.setFont(new Font("arial",Font.BOLD,18));
        add(labeldob);

        /*JDateChooser dcdob = new JDateChooser();
        dcdob.setBounds(150,190,170,50);
        add(dcdob);*/

        tfdob = new JTextField();
        tfdob.setBounds(190,190,180,30);
        add(tfdob);

        JLabel labeladdress = new JLabel("Address:");
        labeladdress.setBounds(50,220,170,65);
        labeladdress.setFont(new Font("arial",Font.BOLD,18));
        add(labeladdress);

        tfaddress  = new JTextField();
        tfaddress.setBounds(190,240,180,30);
        add(tfaddress);

        JLabel labelemail = new JLabel("Email Address:");
        labelemail.setBounds(430,270,170,65);
        labelemail.setFont(new Font("arial",Font.BOLD,18));
        add(labelemail);

        tfemail  =  new JTextField();
        tfemail.setBounds(620,290,180,30);
        add(tfemail);

        JLabel labelphone = new JLabel("Phone number:");
        labelphone.setBounds(50,270,180,65);
        labelphone.setFont(new Font("arial",Font.BOLD,18));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(190,290,180,30);
        add(tfphone);

        JLabel labeleducation = new JLabel("Highest education:");
        labeleducation.setBounds(430,220,170,65);
        labeleducation.setFont(new Font("arial",Font.BOLD,18));
        add(labeleducation);

        /*tfeducation = new JTextField();
        tfeducation.setBounds(600,240,180,30);
        add(tfeducation); */

        String[] courses = {"BBA","BCA","BA","B.COM","BTech","MBA","BSC","MSC","MTech","Phd"};
        JComboBox cbeducation = new JComboBox(courses);
        cbeducation.setBounds(620,240,180,30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);

        JLabel labelstaffid = new JLabel("Staff Id:");
        labelstaffid.setBounds(50,360,170,50);
        labelstaffid.setFont(new Font("arial",Font.BOLD,20));
        add(labelstaffid);

        JLabel labelsid  =  new JLabel(""+ number);
        labelsid.setBounds(200,360,170,50);
        labelsid.setFont(new Font("arial",Font.BOLD,20));
        add(labelsid);

        add = new JButton("Add Member");
        add.setBounds(200,460,170,50);
        add.setFont(new Font("arial",Font.PLAIN,18));
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add(add);
        

        back = new JButton("Back");
        back.setBounds(460,460,170,50);
        back.setFont(new Font("arial",Font.PLAIN,18));
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setFocusPainted(false);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(1150,600);
        setLocation(200,50);
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
            try{
                Conn conn = new Conn();
                String query = "insert into staffdetails('"+memberName+"','"+fatherName+"','"+dob+"','"+salary+"','"+address+"','"+education+"','"+phone+"','"+email+"','"+staffId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Book Details Added Successfully");
                setVisible(false);
                new StaffDetails();
            } catch(Exception e){
            e.printStackTrace();
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
  