package class_files;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame implements ActionListener{
    Dashboard() {
         setLocation(100, 50);
         setSize(780, 600);
        setTitle("Dashboard - Library");
         setLayout(null);
         setResizable(false);
         getContentPane().setBackground(new Color(0, 0, 0, 225));

        Font fontHead = new Font("Arial", Font.BOLD, 35);
        JLabel header = new JLabel("<html><p style='border-bottom: 3px solid rgb(255,255,179);'> Dashboard </p></html>");
        header.setFont(fontHead);
        header.setBounds(280, 30, 200, 50);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(new Color(255,255,179));
         add(header);

        Font fontBtn = new Font("Arial", Font.BOLD, 18);

        ImageIcon imgBtn1 = new ImageIcon(ClassLoader.getSystemResource("images/bookStack.png"));
        Image imgBtn1Temp = imgBtn1.getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT);
        JButton btn1 = new JButton(new ImageIcon(imgBtn1Temp) );
        btn1.setBounds(90, 120, 250, 90);
        btn1.setFont(fontBtn);
        btn1.setText("Books Available");
        btn1.setBackground(new Color(26, 26, 26));
        btn1.setForeground(new Color(255, 255, 179));
        btn1.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn1.setFocusPainted(false);
        btn1.addActionListener(this);

        ImageIcon imgBtn2 = new ImageIcon(ClassLoader.getSystemResource("images/staff.png"));
        Image imgBtn2Temp = imgBtn2.getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT);
        JButton btn2 = new JButton(new ImageIcon(imgBtn2Temp));
        btn2.setBounds(415, 120, 250, 90);
        btn2.setFont(fontBtn);
        btn2.setText("Staff Details");
        btn2.setBackground(new Color(26, 26, 26));
        btn2.setForeground(new Color(255, 255, 179));
        btn2.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn2.setFocusPainted(false);
        btn2.addActionListener(this);

        ImageIcon imgBtn3 = new ImageIcon(ClassLoader.getSystemResource("images/addBook.png"));
        Image imgBtn3Temp = imgBtn3.getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT);
        JButton btn3 = new JButton(new ImageIcon(imgBtn3Temp));
        btn3.setBounds(90, 260, 250, 90);
        btn3.setFont(fontBtn);
        btn3.setText(" Add Books");
        btn3.setBackground(new Color(26, 26, 26));
        btn3.setForeground(new Color(255, 255, 179));
        btn3.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn3.setFocusPainted(false);
        btn3.addActionListener(this);

        ImageIcon imgBtn4 = new ImageIcon(ClassLoader.getSystemResource("images/addStaff.png"));
        Image imgBtn4Temp = imgBtn4.getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT);
        JButton btn4 = new JButton(new ImageIcon(imgBtn4Temp));
        btn4.setBounds(415, 260, 250, 90);
        btn4.setFont(fontBtn);
        btn4.setText(" Add Staff");
        btn4.setBackground(new Color(26, 26, 26));
        btn4.setForeground(new Color(255, 255, 179));
        btn4.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn4.setFocusPainted(false);
        btn4.addActionListener(this);

        ImageIcon imgBtn5 = new ImageIcon(ClassLoader.getSystemResource("images/removeBook.png"));
        Image imgBtn5Temp = imgBtn5.getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT);
        JButton btn5 = new JButton(new ImageIcon(imgBtn5Temp));
        btn5.setBounds(90, 400, 250, 90);
        btn5.setFont(fontBtn);
        btn5.setText("Remove Books");
        btn5.setBackground(new Color(26, 26, 26));
        btn5.setForeground(new Color(255, 255, 179));
        btn5.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn5.setFocusPainted(false);
        btn5.addActionListener(this);

        ImageIcon imgBtn6 = new ImageIcon(ClassLoader.getSystemResource("images/removeStaff.png"));
        Image imgBtn6Temp = imgBtn6.getImage().getScaledInstance(50, 60, Image.SCALE_DEFAULT);
        JButton btn6 = new JButton(new ImageIcon(imgBtn6Temp));
        btn6.setBounds(415, 400, 250, 90);
        btn6.setFont(fontBtn);
        btn6.setText("Remove Staff");
        btn6.setBackground(new Color(26, 26, 26));
        btn6.setForeground(new Color(255, 255, 179));
        btn6.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn6.setFocusPainted(false);
        btn6.addActionListener(this);

        // adding buttons to the frame
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btn1){
            setVisible(false);
            new ViewBooks();
        }
        else if(ae.getSource() == btn2){
            setVisible(false);
            new StaffDetails();
        }
        else if(ae.getSource() == btn3){
            setVisible(false);
            new AddBook();
        }
        else if(ae.getSource() == btn4){
            setVisible(false);
            new AddStaff();
        }
        else if(ae.getSource() == btn5){
            setVisible(false);
            new RemoveBook();
        }
        else{
            setVisible(false);

            // new RemoveStaff();
        }
    }
    public static void main(String[] args) {
        new Dashboard();
    }
}