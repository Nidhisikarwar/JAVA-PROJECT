package class_files;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
//import com.toedter.calender.JDateChooser;

public class AddStaff extends JFrame/* implements ActionListener*/{
    Random sid=new Random();
    int number=sid.nextInt(999999);

    JTextField tfsname,tffname,tfsalary,tfdob,tfaddress,tfemail,tfphone,tfeducation; 
    JButton add,back;

    AddStaff(){
        getContentPane().setBackground(Color.WHITE);//background is white
        setLayout(null);

        JLabel heading=new JLabel("<html><p style='border-bottom: 3px solid rgb(BLACK);'> New Staff Member </p></html>");
        heading.setBounds(280,37,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,30));
        heading.setBackground(Color.WHITE);
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel labelsname=new JLabel("Name:");
        labelsname.setBounds(50,120,180,65);
        labelsname.setFont(new Font("serif",Font.BOLD,18));
        add(labelsname);

        tfsname=new JTextField();
        tfsname.setBounds(190,140,180,30);
        add(tfsname);


        JLabel labelfname=new JLabel("Fathers Name:");
        labelfname.setBounds(430,120,180,65);
        labelfname.setFont(new Font("serif",Font.BOLD,18));
        add(labelfname);

        tffname=new JTextField();
        tffname.setBounds(590,140,180,30);
        add(tffname);

        JLabel labelsalary=new JLabel("Salary:");
        labelsalary.setBounds(430,170,170,65);
        labelsalary.setFont(new Font("serif",Font.BOLD,18));
        add(labelsalary);

        tfsalary=new JTextField();
        tfsalary.setBounds(590,190,180,30);
        add(tfsalary);

        JLabel labeldob=new JLabel("Date of Birth:");
        labeldob.setBounds(50,170,170,65);
        labeldob.setFont(new Font("serif",Font.BOLD,18));
        add(labeldob);

        /*JDateChooser dcdob=new JDateChooser();
        dcdob.setBounds(150,190,170,50);
        add(dcdob);*/

        tfdob=new JTextField();
        tfdob.setBounds(190,190,180,30);
        add(tfdob);

        JLabel labeladdress=new JLabel("Address:");
        labeladdress.setBounds(50,220,170,65);
        labeladdress.setFont(new Font("serif",Font.BOLD,18));
        add(labeladdress);

        tfaddress =new JTextField();
        tfaddress.setBounds(190,240,180,30);
        add(tfaddress);

        JLabel labelemail=new JLabel("Email Address:");
        labelemail.setBounds(430,270,170,65);
        labelemail.setFont(new Font("serif",Font.BOLD,18));
        add(labelemail);

        tfemail=new JTextField();
        tfemail.setBounds(590,290,180,30);
        add(tfemail);

        JLabel labelphone=new JLabel("Phone number:");
        labelphone.setBounds(50,270,180,65);
        labelphone.setFont(new Font("serif",Font.BOLD,18));
        add(labelphone);

        tfphone=new JTextField();
        tfphone.setBounds(190,290,180,30);
        add(tfphone);

        JLabel labeleducation=new JLabel("Highest education:");
        labeleducation.setBounds(430,220,170,65);
        labeleducation.setFont(new Font("serif",Font.BOLD,18));
        add(labeleducation);

        /*tfeducation=new JTextField();
        tfeducation.setBounds(600,240,180,30);
        add(tfeducation); */

        String courses[]={"BBA","BCA","BA","B.COM","BTech","MBA","BSC","MSC","MTech","Phd"};
        JComboBox cbeducation=new JComboBox(courses);
        cbeducation.setBounds(590,240,180,30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);

        JLabel labelstaffid=new JLabel("Staff Id:");
        labelstaffid.setBounds(50,360,170,50);
        labelstaffid.setFont(new Font("serif",Font.BOLD,20));
        add(labelstaffid);

        JLabel labelsid=new JLabel(""+ number);
        labelsid.setBounds(200,360,170,50);
        labelsid.setFont(new Font("serif",Font.BOLD,20));
        add(labelsid);
         
        add=new JButton("Add Staff Details");
        add.setBounds(200,460,170,50);
        add.setFont(new Font("serif",Font.PLAIN,18));
      //  add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add(add);
        

        back=new JButton("Back");
        back.setBounds(460,460,170,50);
        back.setFont(new Font("serif",Font.PLAIN,18));
       // back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setFocusPainted(false);
        back.setForeground(Color.WHITE);


        setSize(1150,650);
        setLocation(300,50);
        setVisible(true);
        setResizable(false);
        add(back);
        
    }

   /*  public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String name=tfname.getText();
            String author=tfauthor.getText();     
            String npages=tfpage.getText();  
            String publishername=tfpublisher.getText(); 
            String price=tfprice.getText();  
            String edition=tfedition.getText();   

            try{
                Conn conn=new Conn();
                String query= "insert into book details('"+name+"','"+author+"','"+npages+"','"+publishername+"','"+price+"','"+edition+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Book Details Added Successfully");
                setVisible(false);
                new Dashboard();
            }
            catch(Exception e){
            e.printStackTrace();
            }
        }
            else{

         setVisible(false);
        
    }
}
/* */
    public static void main(String args[]){
        new AddStaff();
    }
}
  