package class_files;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Dashboard {
    Dashboard() {
        JFrame frameObj = new JFrame("Dashboard - Library");
        frameObj.setLocation(100, 50);
        frameObj.setSize(780, 600);
        frameObj.setLayout(null);
        frameObj.setResizable(false);
        frameObj.getContentPane().setBackground(new Color(0, 0, 0, 225));

        Font fontHead = new Font("Arial", Font.BOLD, 35);
        JLabel header = new JLabel("<html><p style='border-bottom: 3px solid rgb(255,255,179);'> Dashboard </p></html>");
        header.setFont(fontHead);
        header.setBounds(280, 30, 200, 50);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(new Color(255,255,179));
        frameObj.add(header);

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

        // adding buttons to the frame
        frameObj.add(btn1);
        frameObj.add(btn2);
        frameObj.add(btn3);
        frameObj.add(btn4);
        frameObj.add(btn5);
        frameObj.add(btn6);

        frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameObj.setVisible(true);
    }
    public static void main(String[] args) {
        new Dashboard();
    }
}