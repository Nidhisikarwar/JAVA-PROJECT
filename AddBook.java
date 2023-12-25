package class_files;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class AddBook extends JFrame implements ActionListener{
    Random id=new Random();
    int number=id.nextInt(99999999);
    JLabel labelid;
    JTextField tfname, tfauthor, tfpage, tfpublisher, tfprice, tfedition;
    JButton add,back;

    AddBook(){
        getContentPane().setBackground(Color.WHITE);//background is white
        setLayout(null);
        setResizable(false);

        JLabel heading=new JLabel("<html><p style='border-bottom: 3px solid rgb(0, 0, 0);'> Add New Book </p></html>");
        heading.setBounds(280,35,500,50);
        heading.setFont(new Font("Arial", Font.BOLD, 35));
        heading.setBackground(Color.WHITE);
        heading.setForeground(Color.BLACK);
        add(heading);


        Font font = new Font("Arial", Font.BOLD,18);

        JLabel labelname=new JLabel("Name of the book:");
        labelname.setBounds(50,140,170,50);
        labelname.setFont(font);
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(230,150,180,30);
        add(tfname);

        JLabel labelauthor=new JLabel("Author name:");
        labelauthor.setBounds(50,190,170,50);
        labelauthor.setFont(font);
        add(labelauthor);

        tfauthor=new JTextField();
        tfauthor.setBounds(230,200,180,30);
        add(tfauthor);

        JLabel labelpage=new JLabel("No. of pages:");
        labelpage.setBounds(50,240,170,60);
        labelpage.setFont(font);
        add(labelpage);

        tfpage =new JTextField();
        tfpage.setBounds(230,250,180,30);
        add(tfpage);

        JLabel labelpublisher=new JLabel("Publisher name:");
        labelpublisher.setBounds(50,290,170,60);
        labelpublisher.setFont(font);
        add(labelpublisher);

        tfpublisher=new JTextField();
        tfpublisher.setBounds(230,300,180,30);
        add(tfpublisher);

        JLabel labelprice=new JLabel("Price:");
        labelprice.setBounds(50,340,170,60);
        labelprice.setFont(font);
        add(labelprice);

        tfprice=new JTextField();
        tfprice.setBounds(230,350,180,30);
        add(tfprice);

        JLabel labeledition=new JLabel("Edition:");
        labeledition.setBounds(50,390,170,50);
        labeledition.setFont(font);
        add(labeledition);

        tfedition=new JTextField();
        tfedition.setBounds(230,400,180,30);
        add(tfedition);

        JLabel labelbookid=new JLabel("Book Id:");
        labelbookid.setBounds(50,440,170,50);
        labelbookid.setFont(font);
        add(labelbookid);

        labelid = new JLabel(""+ number);
        labelid.setBounds(230,440,170,50);
        labelid.setFont(font);
        add(labelid);
        
        add=new JButton("Add Book Details");
        add.setBounds(200,520,170,50);
        add.setFont(new Font("serif",Font.PLAIN,16));
        add.addActionListener(this);
        add.setFocusPainted(false);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(420,520,170,50);
        back.setFont(new Font("serif",Font.PLAIN,16));
        back.addActionListener(this);
        add.setFocusPainted(false);
        back.setBackground(Color.BLACK);
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

            try{
                Conn c=new Conn();
                String query= "insert into bookdetails('"+bookName+"','"+authName+"','"+pages+"','"+publisher+"','"+price+"','"+edition+"','"+bookId+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Book Details Added Successfully");
                setVisible(false);
                new Dashboard();
            } catch(Exception e){
            e.printStackTrace();
            }
        }

        else{
            setVisible(false);
            new Dashboard();
        }
    }
    public static void main(String args[]){
        new AddBook();
    }
}