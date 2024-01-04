package class_files;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Section extends JFrame implements ActionListener{
    JButton btn1, btn2;
    ImageIcon imgBtn2, imgBtn1, i1;
    Image i2;
    JLabel img, heading;
    
    Section(){
        setTitle("Section - Library");
        setSize(925, 580);
        setLocation(250, 30);
        setResizable(false);
        getContentPane().setBackground(new Color(252,252,252));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         
        imgBtn1 = new ImageIcon(ClassLoader.getSystemResource("images/staffSec.png"));
        Image imgBtn1Temp = imgBtn1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        btn1 = new JButton(new ImageIcon(imgBtn1Temp) );
        btn1.setBounds(550, 100, 280, 100);
        btn1.setFont(new Font("Monospaced",Font.BOLD,30));
        btn1.setText(" Staff");
        btn1.setBackground(new Color(223, 138, 81));
        btn1.setForeground(new Color(77, 77, 77));
        btn1.setFocusPainted(false);
        btn1.setBorder(BorderFactory.createLineBorder(new Color(204, 104, 38), 3, true));
        btn1.addActionListener(this);

        imgBtn2 = new ImageIcon(ClassLoader.getSystemResource("images/reading.png"));
        Image imgBtn2Temp = imgBtn2.getImage().getScaledInstance(75, 80, Image.SCALE_SMOOTH);
        btn2 = new JButton(new ImageIcon(imgBtn2Temp));
        btn2.setBounds(550, 300, 280, 100);
        btn2.setFont(new Font("Monospaced",Font.BOLD,24));
        btn2.setText(" Student");
        btn2.setBackground(new Color(145, 186, 224));
        btn2.setForeground(new Color(77, 77, 77));
        btn2.setFocusPainted(false);
        btn2.setBorder(BorderFactory.createLineBorder(new Color(47, 131, 200), 3, true));
        btn2.addActionListener(this);

        add(btn1);
        add(btn2);

        i1 = new ImageIcon(ClassLoader.getSystemResource("images/shelf.jpg"));
        i2 = i1.getImage().getScaledInstance(450, 550, Image.SCALE_SMOOTH);
        img = new JLabel(new ImageIcon(i2));
        img.setBounds(0, 5, 450, 550);
        add(img);
     
        setLayout(null);
        setVisible(true);
    }

     public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == btn1){
                setVisible(false);
                new StaffLogin();
            }
            else {
                setVisible(false);
                new Login();
            }
        }
   
    public static void main(String args[]){
        new Section();
    }
}