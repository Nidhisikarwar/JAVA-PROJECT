package class_files;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame{
        ImageIcon imgR1, imgR2, imgR3, imgR4, underlineTemp;
        Image img1, img2, img3, img4, underline;
        JLabel row1, row2, row3, row4, underlineLbl;
        JLabel titl1, titl2, titl3;
        
	Splash(){
        setSize(1200, 800);
        setLocation(100, 20);
	setTitle("Library Management System");
        getContentPane().setBackground(new Color(239, 250, 252));

        imgR1 = new ImageIcon(ClassLoader.getSystemResource("images/row.jpg"));
        img1 = imgR1.getImage().getScaledInstance(350, 180, Image.SCALE_SMOOTH);
        row1 = new JLabel(new ImageIcon(img1));
	row1.setBounds(50, 20, 0, 180);
	add(row1);
        
        imgR2 = new ImageIcon(ClassLoader.getSystemResource("images/row2.jpg"));
        img2 = imgR2.getImage().getScaledInstance(350, 180, Image.SCALE_SMOOTH);
        row2 = new JLabel(new ImageIcon(img2));
	row2.setBounds(50, 210, 0, 180);
	add(row2);

        imgR3 = new ImageIcon(ClassLoader.getSystemResource("images/row3.jpg"));
        img3 = imgR3.getImage().getScaledInstance(350, 180, Image.SCALE_SMOOTH);
        row3 = new JLabel(new ImageIcon(img3));
	row3.setBounds(50,410 , 0, 180);
	add(row3);
        
        imgR4 = new ImageIcon(ClassLoader.getSystemResource("images/row4.jpg"));
        img4 = imgR4.getImage().getScaledInstance(350, 180, Image.SCALE_SMOOTH);
        row4 = new JLabel(new ImageIcon(img4));
	row4.setBounds(50, 600, 0, 180);
	add(row4);
        
        Font font = new Font("Monospaced", Font.BOLD, 80);
        
        titl1 = new JLabel("Welcome");
        titl1.setForeground(new Color(238, 135, 32));
        titl1.setFont(font);
        titl1.setBounds(620, 110, 400, 150);
        titl1.setVisible(false);
        add(titl1);
        titl2 = new JLabel("To  Virtual");
        titl2.setForeground(new Color(238, 135, 32));
        titl2.setFont(font);
        titl2.setBounds(540, 250, 550, 150);
        titl2.setVisible(false);
        add(titl2);
        titl3 = new JLabel("Library");
        titl3.setForeground(new Color(183, 31, 54));
        titl3.setFont(new Font("Monospaced", Font.BOLD, 110));
        titl3.setBounds(560, 390, 550, 150);
        titl3.setVisible(false);
        add(titl3);

        underlineTemp = new ImageIcon(ClassLoader.getSystemResource("images/underline.png"));
        underline = underlineTemp.getImage().getScaledInstance(580, 180, Image.SCALE_SMOOTH);
        underlineLbl = new JLabel(new ImageIcon(underline));
	add(underlineLbl);
        
        JLabel temp = new JLabel();
        add(temp);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
            try{
                for(int i=1; i<=35; i++){
                        Thread.sleep(55);
	                row1.setBounds(50, 20, i*10, 180);
	                row2.setBounds(50, 210, i*10, 180);
	                row3.setBounds(50, 410, i*10, 180);
	                row4.setBounds(50, 600, i*10, 180);
                }
                titl1.setVisible(true);
                Thread.sleep(200);
                titl2.setVisible(true);
                Thread.sleep(300);
                titl3.setVisible(true);
	        underlineLbl.setBounds(530, 390, 580, 180);
                
                Thread.sleep(2500);
                setVisible(false);
                new Section();
            }catch(InterruptedException e){
		    e.printStackTrace();
	    }
	} 
	public static void main(String[] args){
	    new Splash();
	}
}