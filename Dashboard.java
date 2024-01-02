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
    	JButton btn1, btn2, btn3, btn4, btn5, btn6;
	ImageIcon backImg;
	ImageIcon imgBtn2, imgBtn1, imgBtn3, imgBtn4, imgBtn5, imgBtn6;
	Image backImg2;
	JLabel backLbl;
	
	Dashboard() {
        setLocation(180, 20);
        setSize(1100, 800);
        setTitle("Dashboard - Library");
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(255, 255, 255));
	
        Font fontHead = new Font("Monospaced", Font.BOLD, 40);
        JLabel header = new JLabel("<html><p style = 'border-bottom: 3px solid black;'> Dashboard </p></html>");
        header.setFont(fontHead);
        header.setBounds(425, 30, 220, 50);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(new Color(51, 51, 51));
        add(header);

        Font fontBtn = new Font("Monospaced", Font.BOLD, 20);

        imgBtn1 = new ImageIcon(ClassLoader.getSystemResource("images/bookStack.png"));
        Image imgBtn1Temp = imgBtn1.getImage().getScaledInstance(50, 45, Image.SCALE_REPLICATE);
        btn1 = new JButton(new ImageIcon(imgBtn1Temp) );
        btn1.setBounds(150, 140, 300, 90);
        btn1.setFont(fontBtn);
        btn1.setText("Books Available");
        btn1.setBackground(new Color(77, 77, 77));
        btn1.setForeground(new Color(255, 255, 255));
        btn1.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn1.setFocusPainted(false);
        btn1.addActionListener(this);

        imgBtn2 = new ImageIcon(ClassLoader.getSystemResource("images/staff.png"));
        Image imgBtn2Temp = imgBtn2.getImage().getScaledInstance(50, 50, Image.SCALE_REPLICATE);
        btn2 = new JButton(new ImageIcon(imgBtn2Temp));
        btn2.setBounds(625, 140, 300, 90);
        btn2.setFont(fontBtn);
        btn2.setText(" Staff Details");
        btn2.setBackground(new Color(77, 77, 77));
        btn2.setForeground(new Color(255, 255, 255));
        btn2.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn2.setFocusPainted(false);
        btn2.addActionListener(this);

        imgBtn3 = new ImageIcon(ClassLoader.getSystemResource("images/addBook.png"));
        Image imgBtn3Temp = imgBtn3.getImage().getScaledInstance(50, 45, Image.SCALE_REPLICATE);
        btn3 = new JButton(new ImageIcon(imgBtn3Temp));
        btn3.setBounds(150, 300, 300, 90);
        btn3.setFont(fontBtn);
        btn3.setText(" Add Books");
        btn3.setBackground(new Color(77, 77, 77));
        btn3.setForeground(new Color(255, 255, 255));
        btn3.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn3.setFocusPainted(false);
        btn3.addActionListener(this);

        imgBtn4 = new ImageIcon(ClassLoader.getSystemResource("images/addStaff.png"));
        Image imgBtn4Temp = imgBtn4.getImage().getScaledInstance(50, 50, Image.SCALE_REPLICATE);
        btn4 = new JButton(new ImageIcon(imgBtn4Temp));
        btn4.setBounds(625, 300, 300, 90);
        btn4.setFont(fontBtn);
        btn4.setText(" Add Staff");
        btn4.setBackground(new Color(77, 77, 77));
        btn4.setForeground(new Color(255, 255, 255));
        btn4.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn4.setFocusPainted(false);
        btn4.addActionListener(this);

        imgBtn5 = new ImageIcon(ClassLoader.getSystemResource("images/removeBook.png"));
        Image imgBtn5Temp = imgBtn5.getImage().getScaledInstance(50, 45, Image.SCALE_REPLICATE);
        btn5 = new JButton(new ImageIcon(imgBtn5Temp));
        btn5.setBounds(150, 460, 300, 90);
        btn5.setFont(fontBtn);
        btn5.setText(" Remove Books");
        btn5.setBackground(new Color(77, 77, 77));
        btn5.setForeground(new Color(255, 255, 255));
        btn5.setBorder(BorderFactory.createMatteBorder(2, 2, 4, 2, new Color(64, 64, 64)));
        btn5.setFocusPainted(false);
        btn5.addActionListener(this);

        imgBtn6 = new ImageIcon(ClassLoader.getSystemResource("images/siblings.png"));
        Image imgBtn6Temp = imgBtn6.getImage().getScaledInstance(50, 45, Image.SCALE_SMOOTH);
        btn6 = new JButton(new ImageIcon(imgBtn6Temp));
        btn6.setBounds(625, 460, 300, 90);
        btn6.setFont(fontBtn);
        btn6.setText(" About Us");
        btn6.setBackground(new Color(77, 77, 77));
        btn6.setForeground(new Color(255, 255, 255));
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

	backImg = new ImageIcon(ClassLoader.getSystemResource("images/first.png"));
        backImg2 = backImg.getImage().getScaledInstance(800, 190, Image.SCALE_SMOOTH);
        backLbl = new JLabel(new ImageIcon(backImg2));
	backLbl.setBounds(150, 570, 800, 200);
	add(backLbl);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D vLine = new Line2D.Float(545, 160, 545, 600);
        Line2D hLine1 = new Line2D.Float(140, 295, 940, 295);
        Line2D hLine2 = new Line2D.Float(140, 455, 940, 455);
        g2.draw(vLine);
        g2.draw(hLine1);
        g2.draw(hLine2);
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
            new About();
        }
    }
    public static void main(String[] args) {
	    new Splash();
    }
}