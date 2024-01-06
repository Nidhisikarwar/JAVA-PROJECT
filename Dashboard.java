package class_files;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.geom.*;
import class_files.*;

public class Dashboard extends JFrame implements ActionListener{
    	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, logout;
	ImageIcon backImg;
	ImageIcon imgBtn2, imgBtn1, imgBtn3, imgBtn4, imgBtn5, imgBtn6, imgBtn7, imgBtn8, imgLog;
	Image backImg2;
	JLabel backLbl, user;

	Dashboard() {
        setLocation(180, 10);
        setSize(1250, 800);
        setTitle("Dashboard - Library");
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 255, 255));
	
        Font fontHead = new Font("Monospaced", Font.BOLD, 40);
        JLabel header = new JLabel("Dashboard");
        header.setFont(fontHead);
        header.setBounds(510, 30, 220, 50);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(new Color(51, 51, 51));
        add(header);

        Font fontBtn = new Font("Monospaced", Font.BOLD, 20);

        /*
        imgLog = new ImageIcon(ClassLoader.getSystemResource("images/viewinfo.png"));
        Image imgLogTemp = imgLog.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        user = new JLabel(new ImageIcon(imgLogTemp));
        user.setBounds(915, 20, 40, 40);
        user.setToolTipText("@" + username);
        add(user);
*/
                
        logout = new JButton();
        logout.setText("Logout");
        logout.setBounds(1130, 20, 100, 30);
        logout.setToolTipText("Log out of account");
        logout.setFocusPainted(false);
        logout.setFont(new Font("Monospaced", Font.BOLD, 16));
        logout.setBorder(BorderFactory.createLineBorder(new Color(77, 173, 254), 2, true));
        logout.setBackground(getContentPane().getBackground());
        logout.setForeground(new Color(26, 198, 181));
        logout.addActionListener(this);
                
        imgBtn1 = new ImageIcon(ClassLoader.getSystemResource("images/book.png"));
        Image imgBtn1Temp = imgBtn1.getImage().getScaledInstance(50, 45, Image.SCALE_REPLICATE);
        btn1 = new JButton(new ImageIcon(imgBtn1Temp) );
        btn1.setBounds(120, 140, 250, 90);
        btn1.setFont(fontBtn);
        btn1.setText(" View Books");
        btn1.setBackground(new Color(77, 77, 77));
        btn1.setForeground(new Color(255, 255, 255));
        btn1.setBorder(BorderFactory.createLineBorder(new Color(148, 27, 214), 4, true));
        btn1.setFocusPainted(false);
        btn1.addActionListener(this);

        imgBtn2 = new ImageIcon(ClassLoader.getSystemResource("images/staff.png"));
        Image imgBtn2Temp = imgBtn2.getImage().getScaledInstance(50, 50, Image.SCALE_REPLICATE);
        btn2 = new JButton(new ImageIcon(imgBtn2Temp));
        btn2.setBounds(490, 140, 250, 90);
        btn2.setFont(fontBtn);
        btn2.setText(" Staff Details");
        btn2.setBackground(new Color(77, 77, 77));
        btn2.setForeground(new Color(255, 255, 255));
        btn2.setBorder(BorderFactory.createLineBorder(new Color(174, 123, 96), 4, true));
        btn2.setFocusPainted(false);
        btn2.addActionListener(this);

        imgBtn3 = new ImageIcon(ClassLoader.getSystemResource("images/addBook.png"));
        Image imgBtn3Temp = imgBtn3.getImage().getScaledInstance(50, 45, Image.SCALE_REPLICATE);
        btn3 = new JButton(new ImageIcon(imgBtn3Temp));
        btn3.setBounds(860, 140, 250, 90);
        btn3.setFont(fontBtn);
        btn3.setText(" Add Book");
        btn3.setBackground(new Color(77, 77, 77));
        btn3.setForeground(new Color(255, 255, 255));
        btn3.setBorder(BorderFactory.createLineBorder(new Color(252, 190, 27), 3, true));
        btn3.setFocusPainted(false);
        btn3.addActionListener(this);

        imgBtn4 = new ImageIcon(ClassLoader.getSystemResource("images/addStaff.png"));
        Image imgBtn4Temp = imgBtn4.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        btn4 = new JButton(new ImageIcon(imgBtn4Temp));
        btn4.setBounds(120, 300, 250, 90);
        btn4.setFont(fontBtn);
        btn4.setText(" Add Staff");
        btn4.setBackground(new Color(77, 77, 77));
        btn4.setForeground(new Color(255, 255, 255));
        btn4.setBorder(BorderFactory.createLineBorder(new Color(24, 201,181), 4, true));
        btn4.setFocusPainted(false);
        btn4.addActionListener(this);

        imgBtn5 = new ImageIcon(ClassLoader.getSystemResource("images/removeBook.png"));
        Image imgBtn5Temp = imgBtn5.getImage().getScaledInstance(50, 45, Image.SCALE_SMOOTH);
        btn5 = new JButton(new ImageIcon(imgBtn5Temp));
        btn5.setBounds(300, 460, 250, 90);
        btn5.setFont(fontBtn);
        btn5.setText(" Remove Book");
        btn5.setBackground(new Color(77, 77, 77));
        btn5.setForeground(new Color(255, 255, 255));
        btn5.setBorder(BorderFactory.createLineBorder(new Color(38, 97, 168),4, true));
        btn5.setFocusPainted(false);
        btn5.addActionListener(this);

        imgBtn6 = new ImageIcon(ClassLoader.getSystemResource("images/siblings.png"));
        Image imgBtn6Temp = imgBtn6.getImage().getScaledInstance(50, 45, Image.SCALE_SMOOTH);
        btn6 = new JButton(new ImageIcon(imgBtn6Temp));
        btn6.setBounds(680, 460, 250, 90);
        btn6.setFont(fontBtn);
        btn6.setText(" About Us");
        btn6.setBackground(new Color(77, 77, 77));
        btn6.setForeground(new Color(255, 255, 255));
        btn6.setBorder(BorderFactory.createLineBorder(new Color(253, 66, 177), 4, true));
        btn6.setFocusPainted(false);
        btn6.addActionListener(this);

        imgBtn7 = new ImageIcon(ClassLoader.getSystemResource("images/user.png"));
        Image imgBtn7Temp = imgBtn7.getImage().getScaledInstance(50, 45, Image.SCALE_SMOOTH);
        btn7 = new JButton(new ImageIcon(imgBtn7Temp));
        btn7.setBounds(490, 300, 250, 90);
        btn7.setFont(fontBtn);
        btn7.setText(" User's Details");
        btn7.setBackground(new Color(77, 77, 77));
        btn7.setForeground(new Color(255, 255, 255));
        btn7.setBorder(BorderFactory.createLineBorder(new Color(255, 127, 80), 4, true));
        btn7.setFocusPainted(false);
        btn7.addActionListener(this);

        imgBtn8 = new ImageIcon(ClassLoader.getSystemResource("images/issuedBook.png"));
        Image imgBtn8Temp = imgBtn8.getImage().getScaledInstance(50, 45, Image.SCALE_SMOOTH);
        btn8 = new JButton(new ImageIcon(imgBtn8Temp));
        btn8.setBounds(860, 300, 250, 90);
        btn8.setFont(fontBtn);
        btn8.setText(" Issued Books");
        btn8.setBackground(new Color(77, 77, 77));
        btn8.setForeground(new Color(255, 255, 255));
        btn8.setBorder(BorderFactory.createLineBorder(new Color(179, 217, 255), 4, true));
        btn8.setFocusPainted(false);
        btn8.addActionListener(this);

        // adding buttons to the frame
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(logout);

	backImg = new ImageIcon(ClassLoader.getSystemResource("images/first.png"));
        backImg2 = backImg.getImage().getScaledInstance(800, 180, Image.SCALE_SMOOTH);
        backLbl = new JLabel(new ImageIcon(backImg2));
	backLbl.setBounds(210, 590, 800, 180);
	add(backLbl);
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D vLine1 = new Line2D.Float(440, 165, 440, 265);
        Line2D vLine2 = new Line2D.Float(810, 165, 810, 265);
        Line2D vLine3 = new Line2D.Float(440, 325, 440, 425);
        Line2D vLine4 = new Line2D.Float(810, 325, 810, 425);
        Line2D vLine5 = new Line2D.Float(625, 485, 625, 585);
        g2.setPaint(new Color(216, 200, 200));
        g2.draw(vLine1);
        g2.draw(vLine2);
        g2.draw(vLine3);
        g2.draw(vLine4);
        g2.draw(vLine5);
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
        else if(ae.getSource() == btn6){
            setVisible(false);
            new About();
        }
        else if(ae.getSource() == btn7){
            setVisible(false);
            new UserDetails();
        }
        else if(ae.getSource() == btn8){
            setVisible(false);
            new IssuedBooks();
        }
        else{
            setVisible(false);
            new Section();
        }
    }
    public static void main(String[] args) {
	    new Dashboard();
    }
}