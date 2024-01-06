package class_files;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.*;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class AddBook extends JFrame implements ActionListener{
    Random id=new Random();
    int number=id.nextInt(99999);
    JLabel labelid, img;
    JTextField tfname, tfauthor, tfpage, tfpublisher, tfprice, tfedition;
    JButton add,back;
    ImageIcon i1;
    Image i2;
    
    AddBook(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setResizable(false);
        setTitle("Add new Book - Library");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading=new JLabel("<html><p style = 'border-bottom: 3px solid rgb((60, 82, 144));'> Add New Book </p></html>");
        heading.setBounds(285,35,500,50);
        heading.setFont(new Font("Monospaced", Font.BOLD, 30));
        heading.setForeground(new Color(60, 82, 144));
        add(heading);

        i1 = new ImageIcon(ClassLoader.getSystemResource("images/addbookpage.gif"));
        i2 = i1.getImage().getScaledInstance(325,450, Image.SCALE_SMOOTH);
        img = new JLabel(new ImageIcon(i2));
        img.setBounds(450,40,325,450);
        add(img);

        Font font = new Font("Arial", Font.BOLD,18);
        Font tfFont = new Font("Arial" , Font.PLAIN, 16);

        JLabel labelname=new JLabel("Name of the book :");
        labelname.setBounds(50,140,170,50);
        labelname.setFont(font);
        labelname.setForeground(new Color(77, 77, 77));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(230,150,180,30);
        tfname.setFont(tfFont);
        tfname.setBorder(BorderFactory.createLineBorder(new Color(77, 77, 77), 2, true));
        add(tfname);

        JLabel labelauthor=new JLabel("Author name :");
        labelauthor.setBounds(50,190,170,50);
        labelauthor.setFont(font);
        labelauthor.setForeground(new Color(77, 77, 77));
        add(labelauthor);

        tfauthor=new JTextField();
        tfauthor.setBounds(230,204,180,30);
        tfauthor.setFont(tfFont);
        tfauthor.setBorder(BorderFactory.createLineBorder(new Color(77, 77, 77), 2, true));
        add(tfauthor);

        JLabel labelpage=new JLabel("No. of pages :");
        labelpage.setBounds(50,240,170,60);
        labelpage.setFont(font);
        labelpage.setForeground(new Color(77, 77, 77));
        add(labelpage);

        tfpage =new JTextField();
        tfpage.setBounds(230,255,180,30);
        tfpage.setFont(tfFont);
        tfpage.setBorder(BorderFactory.createLineBorder(new Color(77, 77, 77), 2, true));
        add(tfpage);

        JLabel labelpublisher=new JLabel("Publisher name :");
        labelpublisher.setBounds(50,290,170,60);
        labelpublisher.setFont(font);
        labelpublisher.setForeground(new Color(77, 77, 77));
        add(labelpublisher);

        tfpublisher=new JTextField();
        tfpublisher.setBounds(230,305,180,30);
        tfpublisher.setFont(tfFont);
        tfpublisher.setBorder(BorderFactory.createLineBorder(new Color(77, 77, 77), 2, true));
        add(tfpublisher);

        JLabel labelprice=new JLabel("Price :");
        labelprice.setBounds(50,340,170,60);
        labelprice.setFont(font);
        labelprice.setForeground(new Color(77, 77, 77));
        add(labelprice);

        tfprice=new JTextField();
        tfprice.setBounds(230,355,180,30);
        tfprice.setFont(tfFont);
        tfprice.setBorder(BorderFactory.createLineBorder(new Color(77, 77, 77), 2, true));
        add(tfprice);

        JLabel labeledition=new JLabel("Edition :");
        labeledition.setBounds(50,390,170,50);
        labeledition.setFont(font);
        labeledition.setForeground(new Color(77, 77, 77));
        add(labeledition);

        tfedition=new JTextField();
        tfedition.setBounds(230,403,180,30);
        tfedition.setBorder(BorderFactory.createLineBorder(new Color(77, 77, 77), 2, true));
        tfedition.setFont(tfFont);
        add(tfedition);

        JLabel labelbookid=new JLabel("Book Id :");
        labelbookid.setBounds(50,440,170,50);
        labelbookid.setFont(font);
        labelbookid.setForeground(new Color(77, 77, 77));
        add(labelbookid);

        labelid = new JLabel(""+ number);
        labelid.setBounds(230,444,170,50);
        labelid.setFont(font);
        labelid.setForeground(new Color(77, 77, 77));
        add(labelid);
        
        add=new JButton("Add Book Details");
        add.setBounds(200,520,170,50);
        add.setFont(new Font("Arial",Font.BOLD,16));
        add.addActionListener(this);
        add.setFocusPainted(false);
        add.setBackground(new Color(53, 72, 126));
        add.setForeground(Color.WHITE);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(420,520,170,50);
        back.setFont(new Font("Arial",Font.BOLD,16));
        back.addActionListener(this);
        back.setFocusPainted(false);
        back.setBackground(new Color(53, 72, 126));
        back.setForeground(Color.WHITE);

        setSize(800,700);
        setLocation(300,50);
        setVisible(true);
        add(back);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String bookName = tfname.getText();
            String authName = tfauthor.getText();
            String pages = tfpage.getText();
            String publisher = tfpublisher.getText();
            String price = tfprice.getText();
            String edition = tfedition.getText();
            String bookId = labelid.getText();
            // check for mandatory fields
                if(bookName.length() != 0 && authName.length() != 0 && pages.length() != 0 && publisher.length() != 0 && price.length() != 0 && edition.length() != 0){
                try{
                        Conn c = new Conn();
                        String query = "insert into bookdetails values('"+bookName+"','"+authName+"','"+pages+"','"+publisher+"','"+price+"','"+edition+"','"+bookId+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Book Details Added Successfully");
                        setVisible(false);
                        new ViewBooks();
                } catch(Exception e){
                        e.printStackTrace();
                }
                }
                else{
                        JOptionPane.showMessageDialog(null, "All Fields are Mandatory");
                }
        }
        // back button pressed
        else{
            setVisible(false);
            new Dashboard();
        }
    }
    public static void main(String args[]){
        new AddBook();
    }
}