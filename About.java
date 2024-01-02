package class_files;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.BorderFactory;

public class About extends JFrame implements ActionListener{
        JLabel heading;
        JButton back;
        
        About(){
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
                add(heading);

                
                Font font1 = new Font("Arial", Font.BOLD, 16);
                Font font2 = new Font("Arial", Font.PLAIN, 16);
                
                String str1 = "         At Virtual Library, we are passionate about fostering a love for literature and knowledge within our community. Our library is more than just a collection of books; it's a hub of learning, exploration, and connection.";
                String str2 = "       Our aim is to provide a welcoming and inclusive space where individuals of all ages can discover the joy of reading, expand their knowledge, and connect with each other. We strive to be a resource that empowers our community through access to a diverse range of materials. While rooted in tradition, we embrace technology to enhance the library experience, making information and resources more accessible.";
                String str3 = "Our team is committed to creating a positive and enriching environment for our patrons.";
                String str4 = "Bhushan Harode & Nidhi Sikarwar\nBachelor of Science (Computer Science, Electronics, Mathematics)\nSchool of Electronics\nDevi Ahilya Vishwavidyalaya, Indore";
                String str5 = "We love hearing from you! If you have any questions, suggestions, or just want to say hello, feel free to contact us or drop us a text.\nThank you for being a part of the Virtual Library community!";
                
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
                add(cont);

                JTextArea ta5 = new JTextArea(str5);
                ta5.setEditable(false);
                ta5.setLineWrap(true);
                ta5.setWrapStyleWord(true);
                ta5.setFont(font2);
                ta5.setBackground(new Color(getContentPane().getBackground().getRGB(), true));
                ta5.setForeground(new Color(getContentPane().getForeground().getRGB(), true));
                ta5.setBounds(20, 590, 950, 70);
                add(ta5);

                back = new JButton("Back");
        	back.setBounds(850, 660, 100, 30);
	        back.setFont(font1);
        	back.setBackground(new Color(77, 77, 77));
	        back.setForeground(Color.WHITE);
        	back.addActionListener(this);
	        back.setFocusPainted(false);
        	add(back);
        }

        public void actionPerformed(ActionEvent ae){
                if(ae.getSource() == back){
                        setVisible(false);
                        new Dashboard();
                }
        }
        
        public static void main(String[] args){
               new About();
        }
}