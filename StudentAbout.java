package class_files;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class StudentAbout extends JFrame implements ActionListener {

        JLabel heading;
        JButton back;
        String username;

        StudentAbout(String username) {
                this.username = username;
                setTitle("About - Library");
                setSize(1000, 750);
                setLocation(250, 30);
                setResizable(false);
                setLayout(null);
                setVisible(true);
                getContentPane().setBackground(new Color(255, 230, 204));
                setDefaultCloseOperation(EXIT_ON_CLOSE);

                heading = new JLabel("About Us");
                heading.setBounds(420, 10, 180, 70);
                heading.setFont(new Font("Monospaced", Font.BOLD, 35));
                heading.setForeground(new Color(254, 115, 103));
                add(heading);

                Font font1 = new Font("Arial", Font.BOLD, 16);
                Font font2 = new Font("Arial", Font.PLAIN, 16);

                String str1 = "         At Virtual Library, we are passionate about fostering a love for literature and knowledge within our community. Our library is more than just a collection of books; it's a hub of learning, exploration, and connection.";
                String str2 = "       Our aim is to provide a welcoming and inclusive space where individuals of all ages can discover the joy of reading, expand their knowledge, and connect with each other. We strive to be a resource that empowers our community through access to a diverse range of materials. While rooted in tradition, we embrace technology to enhance the library experience, making information and resources more accessible.";
                String str3 = "Our team is committed to creating a positive and enriching environment for our patrons.";
                String str4 = "Bhushan Harode & Nidhi Sikarwar\nBachelor of Science (Computer Science, Electronics, Mathematics)\nSchool of Electronics\nDevi Ahilya Vishwavidyalaya, Indore";
                String str5 = "We love hearing from you! If you have any questions, suggestions, or just want to say hello, feel free to contact us or drop us a mail.\nThank you for being a part of the Virtual Library community!";
                String str6 = "Nidhisikarwar24@gmail.com,       github.com/Nidhisikarwar";
                String str7 = "Bhushanharode0246@gmail.com,        github.com/Bhushan0246";

                JTextArea ta = new JTextArea(str1);
                ta.setEditable(false);
                ta.setLineWrap(true);
                ta.setWrapStyleWord(true);
                ta.setFont(font2);
                ta.setBackground(new Color(getContentPane().getBackground().getRGB(), true));
                ta.setForeground(new Color(getContentPane().getForeground().getRGB(), true));
                ta.setBounds(20, 90, 950, 65);
                add(ta);

                JLabel moto = new JLabel("Our Mission : Inspiring Minds, Enriching Lives.");
                moto.setFont(font1);
                moto.setBounds(20, 160, 950, 40);
                moto.setForeground(new Color(254, 115, 103));
                add(moto);

                JTextArea ta2 = new JTextArea(str2);
                ta2.setEditable(false);
                ta2.setLineWrap(true);
                ta2.setWrapStyleWord(true);
                ta2.setFont(font2);
                ta2.setBackground(new Color(getContentPane().getBackground().getRGB(), true));
                ta2.setForeground(new Color(getContentPane().getForeground().getRGB(), true));
                ta2.setBounds(20, 210, 950, 120);
                add(ta2);

                JLabel team = new JLabel("Our Team :");
                team.setFont(font1);
                team.setBounds(20, 315, 950, 40);
                team.setForeground(new Color(254, 115, 103));
                add(team);

                JTextArea ta3 = new JTextArea(str3);
                ta3.setEditable(false);
                ta3.setLineWrap(true);
                ta3.setWrapStyleWord(true);
                ta3.setFont(font2);
                ta3.setBackground(new Color(getContentPane().getBackground().getRGB(), true));
                ta3.setForeground(new Color(getContentPane().getForeground().getRGB(), true));
                ta3.setBounds(20, 355, 950, 40);
                add(ta3);

                JLabel dev = new JLabel("Developers : ");
                dev.setBounds(20, 400, 950, 40);
                dev.setFont(font1);
                dev.setForeground(new Color(254, 115, 103));
                add(dev);

                JTextArea ta4 = new JTextArea(str4);
                ta4.setEditable(false);
                ta4.setLineWrap(true);
                ta4.setWrapStyleWord(true);
                ta4.setFont(font2);
                ta4.setBackground(new Color(getContentPane().getBackground().getRGB(), true));
                ta4.setForeground(new Color(getContentPane().getForeground().getRGB(), true));
                ta4.setBounds(20, 445, 950, 100);
                add(ta4);

                JLabel cont = new JLabel("Contact Us :");
                cont.setFont(font1);
                cont.setBounds(20, 550, 950, 30);
                cont.setForeground(new Color(254, 115, 103));
                add(cont);

                JTextArea ta5 = new JTextArea(str5);
                ta5.setEditable(false);
                ta5.setLineWrap(true);
                ta5.setWrapStyleWord(true);
                ta5.setFont(font2);
                ta5.setBackground(new Color(getContentPane().getBackground().getRGB(), true));
                ta5.setForeground(new Color(getContentPane().getForeground().getRGB(), true));
                ta5.setBounds(20, 590, 950, 45);
                add(ta5);

                JLabel id1 = new JLabel(str6);
                id1.setFont(font1);
                id1.setBounds(20, 640, 800, 20);
                id1.setForeground(new Color(254, 115, 103));
                add(id1);
                JLabel id2 = new JLabel(str7);
                id2.setFont(font1);
                id2.setBounds(20, 665, 800, 20);
                id2.setForeground(new Color(254, 115, 103));
                add(id2);

                back = new JButton("Back");
                back.setBounds(850, 660, 100, 30);
                back.setFont(font1);
                back.setBackground(new Color(77, 77, 77));
                back.setForeground(Color.WHITE);
                back.addActionListener(this);
                back.setFocusPainted(false);
                add(back);
        }

        public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(new Color(252, 137, 124));
                Line2D hLine = new Line2D.Float(55, 335, 925, 335);
                Line2D hLine1 = new Line2D.Float(55, 180, 925, 180);
                Line2D hLine2 = new Line2D.Float(55, 570, 925, 570);
                g2.draw(hLine);
                g2.draw(hLine1);
                g2.draw(hLine2);
        }

        public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == back) {
                        setVisible(false);
                        new StudentDashboard(username);
                }
        }

        public static void main(String[] args) {
                new StudentAbout("");
        }
}
