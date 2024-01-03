import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Section extends JFrame /*implements ActionListener*/{
    JButton btn1, btn2;
    ImageIcon imgBtn2, imgBtn1;
    Section(){

        setTitle("Section - Library");
        setSize(1100, 750);
        setLocation(250, 30);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel heading=new JLabel("<html><p style = 'border-bottom: 3px solid rgb(244, 214, 51);'> Are you a Staff or a Student?</p></html>");
        heading.setBounds(550,200,500,90);
        heading.setForeground(new Color(244, 214, 51));
        heading.setFont(new Font("Monospaced",Font.BOLD,35));
        add(heading);
         
        imgBtn1 = new ImageIcon(ClassLoader.getSystemResource("images/staff.png"));
        Image imgBtn1Temp = imgBtn1.getImage().getScaledInstance(50, 45, Image.SCALE_REPLICATE);
        btn1 = new JButton(new ImageIcon(imgBtn1Temp) );
        btn1.setBounds(520, 380, 220, 75);
        btn1.setFont(new Font("Monospaced",Font.BOLD,24));
        btn1.setText("Staff");
        btn1.setBackground(new Color(244,214,51));
        btn1.setForeground(new Color(255, 255, 255));
        btn1.setFocusPainted(false);
       // btn1.addActionListener(this);

        imgBtn2 = new ImageIcon(ClassLoader.getSystemResource("images/addStaff.png"));
        Image imgBtn2Temp = imgBtn2.getImage().getScaledInstance(50, 50, Image.SCALE_REPLICATE);
        btn2 = new JButton(new ImageIcon(imgBtn2Temp));
        btn2.setBounds(780, 380, 220, 75);
        btn2.setFont(new Font("Monospaced",Font.BOLD,24));
        btn2.setText(" Student");
        btn2.setBackground(new Color(244,214,51));
        btn2.setForeground(new Color(255, 255, 255));
        btn2.setFocusPainted(false);
        //btn2.addActionListener(this);

        add(btn1);
        add(btn2);
        

       /*  JButton btn1=new JButton("Staff");
        btn1.setBounds(580,420,160,60);
        btn1.setBackground(new Color(244,214,51));
        btn1.setFont(new Font("Arial",Font.BOLD,24));
        btn1.setForeground(Color.WHITE);
        btn1.setFocusPainted(false);
        add(btn1);

        JButton btn2=new JButton("Student");
        btn2.setBounds(800,420,160,60);
        btn2.setBackground(new Color(244,214,51));
        btn2.setFont(new Font("Arial",Font.BOLD,24));
        btn2.setForeground(Color.WHITE);
        btn2.setFocusPainted(false);
        add(btn2);*/

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./images/Section.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH); // Adjusted scaling
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(0, 40, 500, 600);
        add(img);
        
    }

     /*  public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == btn1){
                setVisible(false);
                new StaffLogin();
            }
            else {
                setVisible(false);
                new Login();
            }
}*/
   
    public static void main(String args[]){
        new Section();
    }
}