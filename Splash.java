package class_files;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Splash extends JFrame{
    public static void main(String[] args){
        JFrame f = new JFrame("Library Management System");
        f.setSize(1200, 600);
        f.setLocation(100, 50);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./images/bookShelves.jpg"));
        Image img2 = img.getImage().getScaledInstance(1199, 599, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel imgLbl = new JLabel(new ImageIcon(img2));

        JLabel titl = new JLabel("Library Management System");
        Font font = new Font("Arial", Font.BOLD, 50);

        titl.setFont(font);
        titl.setLocation(250, 35);
        titl.setSize(700, 150);
        titl.setBackground(Color.WHITE);
        titl.setForeground(Color.YELLOW);
        Border borderCyan = BorderFactory.createLineBorder(new Color(255, 215, 0));
        titl.setBorder(borderCyan);

        f.add(titl);
        f.add(imgLbl);
        f.setVisible(true);
            try{
                Thread.sleep(5000);
                f.setVisible(false);
            }catch(InterruptedException e){}
    }
}