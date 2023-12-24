package class_files;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class AddBook extends JFrame/* implements ActionListener*/{
    Random id=new Random();
    int number=id.nextInt(999999);

    JTextField tfname,tfauthor,tfpage,tfpublisher,tfprice,tfedition; 
    JButton add,back;

    AddBook(){
        getContentPane().setBackground(Color.WHITE);//background is white
        setLayout(null);

        JLabel heading=new JLabel("Add Book ");
        heading.setBounds(340,35,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,28));
        heading.setBackground(Color.WHITE);
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel labelname=new JLabel("Name of the book:");
        labelname.setBounds(50,140,170,50);
        labelname.setFont(new Font("serif",Font.PLAIN,18));
        add(labelname);

        tfname=new JTextField();
        tfname.setBounds(230,150,180,30);
        add(tfname);

        JLabel labelauthor=new JLabel("Author name:");
        labelauthor.setBounds(50,190,170,50);
        labelauthor.setFont(new Font("serif",Font.PLAIN,18));
        add(labelauthor);

        tfauthor=new JTextField();
        tfauthor.setBounds(230,200,180,30);
        add(tfauthor);

        JLabel labelpage=new JLabel("No. of pages:");
        labelpage.setBounds(50,240,170,60);
        labelpage.setFont(new Font("serif",Font.PLAIN,18));
        add(labelpage);

        tfpage =new JTextField();
        tfpage.setBounds(230,250,180,30);
        add(tfpage);

        JLabel labelpublisher=new JLabel("Publisher name:");
        labelpublisher.setBounds(50,290,170,60);
        labelpublisher.setFont(new Font("serif",Font.PLAIN,18));
        add(labelpublisher);

        tfpublisher=new JTextField();
        tfpublisher.setBounds(230,300,180,30);
        add(tfpublisher);

        JLabel labelprice=new JLabel("Price:");
        labelprice.setBounds(50,340,170,60);
        labelprice.setFont(new Font("serif",Font.PLAIN,18));
        add(labelprice);

        tfprice=new JTextField();
        tfprice.setBounds(230,350,180,30);
        add(tfprice);

        JLabel labeledition=new JLabel("Edition:");
        labeledition.setBounds(50,390,170,50);
        labeledition.setFont(new Font("serif",Font.PLAIN,18));
        add(labeledition);

        tfedition=new JTextField();
        tfedition.setBounds(230,400,180,30);
        add(tfedition); 

        JLabel labelbookid=new JLabel("Book Id:");
        labelbookid.setBounds(50,440,170,50);
        labelbookid.setFont(new Font("serif",Font.PLAIN,18));
        add(labelbookid);

        JLabel labelid=new JLabel(""+ number);
        labelid.setBounds(230,440,170,50);
        labelid.setFont(new Font("serif",Font.PLAIN,18));
        add(labelid);
         
        add=new JButton("Add Book Details");
        add.setBounds(200,520,170,50);
        add.setFont(new Font("serif",Font.PLAIN,16));
      //  add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        

        back=new JButton("Back");
        back.setBounds(420,520,170,50);
        back.setFont(new Font("serif",Font.PLAIN,16));
       // back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);


        setSize(800,650);
        setLocation(300,50);
        setVisible(true);
        add(back);
        
    }

   /*  public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String name=tfname.getText();
            String author=tfauthor.getText();     
            String npages=tfpage.getText();  
            String publishername=tfpublisher.getText(); 
            String price=tfprice.getText();  
            String edition=tfedition.getText();   

            try{
                Conn conn=new Conn();
                String query= "insert into book details('"+name+"','"+author+"','"+npages+"','"+publishername+"','"+price+"','"+edition+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Book Details Added Successfully");
                setVisible(false);
                new Dashboard();
            }
            catch(Exception e){
            e.printStackTrace();
            }
        }
            else{

         setVisible(false);
        
    }
}
/* */
    public static void main(String args[]){
        new AddBook();
    }
}
  