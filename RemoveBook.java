package class_files;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveBook extends JFrame implements ActionListener {

        Choice cbookname;
        JButton delete, back;
        JLabel lbledition, lblbookid, lblauthor, lblpublisher, lblpages, lblprice, img;
        ImageIcon i1;
        Image i2;

        RemoveBook() {
                getContentPane().setBackground(new Color(196, 227, 237));
                setLayout(null);
                setResizable(false);
                setTitle("Remove Book - Library");

                JLabel labelheading = new JLabel("<html><p style = 'border-bottom: 5px solid rgb(6,129,164);'>Remove Book</p></html>");
                labelheading.setBounds(190, 30, 290, 40);
                labelheading.setForeground(new Color(6, 129, 164));
                labelheading.setFont(new Font("MONOSPACED", Font.BOLD, 30));
                add(labelheading);

                i1 = new ImageIcon(ClassLoader.getSystemResource("images/removebook.jpg"));
                i2 = i1.getImage().getScaledInstance(425, 650, Image.SCALE_SMOOTH);
                img = new JLabel(new ImageIcon(i2));
                img.setBounds(600, 0, 400, 650);
                add(img);

                JLabel labelbookname = new JLabel("Search by Book Name:");
                labelbookname.setBounds(50, 110, 200, 30);
                labelbookname.setForeground(Color.BLACK);
                labelbookname.setFont(new Font("Arial", Font.BOLD, 18));
                add(labelbookname);

                cbookname = new Choice();
                cbookname.setBackground(getContentPane().getBackground());
                cbookname.setBounds(260, 110, 300, 30);
                cbookname.requestFocus();
                cbookname.setFont(new Font("Arial", Font.PLAIN, 17));
                add(cbookname);

                Font fontl = new Font("Arial", Font.BOLD, 18);
                Font fontt = new Font("Arial", Font.PLAIN, 18);

                JLabel labeldetails = new JLabel("Your Book details are:");
                labeldetails.setBounds(50, 150, 250, 30);
                labeldetails.setForeground(Color.BLACK);
                labeldetails.setFont(new Font("Arial", Font.PLAIN, 18));
                add(labeldetails);

                JLabel labelbookid = new JLabel("Book Id :");
                labelbookid.setBounds(50, 215, 140, 30);
                labelbookid.setForeground(Color.BLACK);
                labelbookid.setFont(fontl);
                add(labelbookid);

                lblbookid = new JLabel();
                lblbookid.setBounds(240, 215, 200, 30);
                lblbookid.setFont(fontt);
                add(lblbookid);

                JLabel labelauthor = new JLabel("Author Name :");
                labelauthor.setBounds(50, 260, 140, 30);
                labelauthor.setForeground(Color.BLACK);
                labelauthor.setFont(fontl);
                add(labelauthor);

                lblauthor = new JLabel();
                lblauthor.setBounds(240, 260, 250, 30);
                lblauthor.setFont(fontt);
                add(lblauthor);

                JLabel labelpublisher = new JLabel("Publisher Name :");
                labelpublisher.setBounds(50, 305, 165, 30);
                labelpublisher.setForeground(Color.BLACK);
                labelpublisher.setFont(fontl);
                add(labelpublisher);

                lblpublisher = new JLabel();
                lblpublisher.setBounds(240, 305, 250, 30);
                lblpublisher.setFont(fontt);
                add(lblpublisher);

                JLabel labeledition = new JLabel("Edition :");
                labeledition.setBounds(50, 350, 150, 30);
                labeledition.setForeground(Color.BLACK);
                labeledition.setFont(fontl);
                add(labeledition);

                lbledition = new JLabel();
                lbledition.setBounds(240, 350, 250, 30);
                lbledition.setFont(fontt);
                add(lbledition);

                try {
                        Conn c = new Conn();
                        String query = "select * from bookdetails";
                        ResultSet rs = c.s.executeQuery(query);
                        while (rs.next()) {
                                cbookname.add(rs.getString("bookName"));
                        }
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
                try {
                        Conn c = new Conn();
                        String query = "select * from bookdetails where bookName = '" + cbookname.getSelectedItem() + "'";
                        ResultSet rs = c.s.executeQuery(query);
                        while (rs.next()) {
                                lblbookid.setText(rs.getString("bookId"));
                                lblauthor.setText(rs.getString("authName"));
                                lblpublisher.setText(rs.getString("publisher"));
                                lbledition.setText(rs.getString("edition"));
                        }
                } catch (Exception ep) {
                        ep.printStackTrace();
                }

                cbookname.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent ie) {
                                try {
                                        Conn c = new Conn();
                                        String query = "select * from bookdetails where bookName = '" + cbookname.getSelectedItem() + "'";
                                        ResultSet rs = c.s.executeQuery(query);
                                        while (rs.next()) {
                                                lblbookid.setText(rs.getString("bookId"));
                                                lblauthor.setText(rs.getString("authName"));
                                                lblpublisher.setText(rs.getString("publisher"));
                                                lbledition.setText(rs.getString("edition"));
                                        }
                                } catch (Exception ep) {
                                        ep.printStackTrace();
                                }
                        }
                });

                delete = new JButton("Delete");
                delete.setBounds(50, 470, 130, 30);
                delete.setFont(new Font("Arial", Font.BOLD, 18));
                delete.setBackground(new Color(6, 129, 164));
                delete.setForeground(Color.WHITE);
                delete.setFocusPainted(false);
                delete.addActionListener(this);
                add(delete);

                back = new JButton("Back");
                back.setBounds(270, 470, 130, 30);
                back.setFont(new Font("Arial", Font.BOLD, 18));
                back.setBackground(new Color(6, 129, 164));
                back.setForeground(Color.WHITE);
                back.setFocusPainted(false);
                back.addActionListener(this);
                add(back);

                setSize(1000, 650);
                setLocation(300, 100);
                setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == delete) {
                        try {
                                Conn c = new Conn();
                                String query = "delete from bookDetails where bookName='" + cbookname.getSelectedItem() + "'";
                                c.s.executeUpdate(query);
                                JOptionPane.showMessageDialog(null, "Book Details Removed Successfully");
                                setVisible(false);
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                        setVisible(false);
                        new ViewBooks();
                } else {
                        setVisible(false);
                        new Dashboard();
                }
        }

        public static void main(String args[]) {
                new RemoveBook();
        }
}
