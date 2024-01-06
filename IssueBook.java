package class_files;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class IssueBook extends JFrame implements ActionListener {

        Choice cbookid;
        JButton issue, back;
        JLabel lbledition, lblbookname, lblauthor, lblpublisher, lblpages, lblprice, img;
        ImageIcon i1;
        Image i2;
        String issuedBy;

        IssueBook(String username) {
                this.issuedBy = username;
                getContentPane().setBackground(new Color(0, 179, 179));
                setLayout(null);
                setResizable(false);
                setTitle("Issue Book - Library");

                JLabel labelheading = new JLabel("<html><p style = 'border-bottom: 5px solid rgb(255, 252, 252);'>Issue Book</p></html>");
                labelheading.setBounds(190, 30, 290, 40);
                labelheading.setForeground(new Color(255, 252, 252));
                labelheading.setFont(new Font("MONOSPACED", Font.BOLD, 30));
                add(labelheading);

                i1 = new ImageIcon(ClassLoader.getSystemResource("images/removebook.jpg"));
                i2 = i1.getImage().getScaledInstance(425, 650, Image.SCALE_SMOOTH);
                img = new JLabel(new ImageIcon(i2));
                img.setBounds(600, 0, 400, 650);
                add(img);

                JLabel labelbookname = new JLabel("Search by Book Id :");
                labelbookname.setBounds(50, 110, 200, 30);
                labelbookname.setForeground(new Color(230, 255, 255));
                labelbookname.setFont(new Font("Arial", Font.BOLD, 18));
                add(labelbookname);

                cbookid = new Choice();
                cbookid.setBackground(getContentPane().getBackground());
                cbookid.setForeground(new Color(230, 255, 255));
                cbookid.setBounds(260, 110, 300, 30);
                cbookid.requestFocus();
                cbookid.setFont(new Font("Arial", Font.PLAIN, 17));
                add(cbookid);

                Font fontl = new Font("Arial", Font.BOLD, 18);
                Font fontt = new Font("Arial", Font.PLAIN, 18);

                JLabel labeldetails = new JLabel("Your Book details are :");
                labeldetails.setBounds(50, 160, 250, 30);
                labeldetails.setForeground(new Color(230, 255, 255));
                labeldetails.setFont(new Font("Arial", Font.PLAIN, 18));
                add(labeldetails);

                JLabel labelbookid = new JLabel("Book Name :");
                labelbookid.setBounds(50, 215, 140, 30);
                labelbookid.setForeground(new Color(230, 255, 255));
                labelbookid.setFont(fontl);
                add(labelbookid);

                lblbookname = new JLabel();
                lblbookname.setBounds(240, 215, 300, 30);
                lblbookname.setForeground(new Color(230, 255, 255));
                lblbookname.setFont(fontt);
                add(lblbookname);

                JLabel labelauthor = new JLabel("Author Name :");
                labelauthor.setBounds(50, 260, 140, 30);
                labelauthor.setForeground(new Color(230, 255, 255));
                labelauthor.setFont(fontl);
                add(labelauthor);

                lblauthor = new JLabel();
                lblauthor.setBounds(240, 260, 250, 30);
                lblauthor.setForeground(new Color(230, 255, 255));
                lblauthor.setFont(fontt);
                add(lblauthor);

                JLabel labelpublisher = new JLabel("Publisher Name :");
                labelpublisher.setBounds(50, 305, 165, 30);
                labelpublisher.setForeground(new Color(230, 255, 255));
                labelpublisher.setFont(fontl);
                add(labelpublisher);

                lblpublisher = new JLabel();
                lblpublisher.setBounds(240, 305, 250, 30);
                lblpublisher.setForeground(new Color(230, 255, 255));
                lblpublisher.setFont(fontt);
                add(lblpublisher);

                JLabel labeledition = new JLabel("Edition :");
                labeledition.setBounds(50, 350, 150, 30);
                labeledition.setForeground(new Color(230, 255, 255));
                labeledition.setFont(fontl);
                add(labeledition);

                lbledition = new JLabel();
                lbledition.setBounds(240, 350, 250, 30);
                lbledition.setForeground(new Color(230, 255, 255));
                lbledition.setFont(fontt);
                add(lbledition);

                JLabel labelpages = new JLabel("Pages :");
                labelpages.setBounds(50, 395, 150, 30);
                labelpages.setForeground(new Color(230, 255, 255));
                labelpages.setFont(fontl);
                add(labelpages);

                lblpages = new JLabel();
                lblpages.setBounds(240, 395, 250, 30);
                lblpages.setForeground(new Color(230, 255, 255));
                lblpages.setFont(fontt);
                add(lblpages);

                JLabel labelprice = new JLabel("Price :");
                labelprice.setBounds(50, 440, 150, 30);
                labelprice.setForeground(new Color(230, 255, 255));
                labelprice.setFont(fontl);
                add(labelprice);

                lblprice = new JLabel();
                lblprice.setBounds(240, 440, 250, 30);
                lblprice.setForeground(new Color(230, 255, 255));
                lblprice.setFont(fontt);
                add(lblprice);
                
                try {
                        Conn c = new Conn();
                        String query = "select * from bookdetails";
                        ResultSet rs = c.s.executeQuery(query);
                        while (rs.next()) {
                                cbookid.add(rs.getString("bookId"));
                        }
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
                try {
                        Conn c = new Conn();
                        String query = "select * from bookdetails where bookId = '" + cbookid.getSelectedItem() + "'";
                        ResultSet rs = c.s.executeQuery(query);
                        while (rs.next()) {
                                lblbookname.setText(rs.getString("bookName"));
                                lblauthor.setText(rs.getString("authName"));
                                lblpublisher.setText(rs.getString("publisher"));
                                lbledition.setText(rs.getString("edition"));
                                lblpages.setText(rs.getString("pages"));
                                lblprice.setText(rs.getString("price"));
                        }
                } catch (Exception ep) {
                        ep.printStackTrace();
                }

                cbookid.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent ie) {
                                try {
                                        Conn c = new Conn();
                                        String query = "select * from bookdetails where bookId = '" + cbookid.getSelectedItem() + "'";
                                        ResultSet rs = c.s.executeQuery(query);
                                        while (rs.next()) {
                                                lblbookname.setText(rs.getString("bookName"));
                                                lblauthor.setText(rs.getString("authName"));
                                                lblpublisher.setText(rs.getString("publisher"));
                                                lbledition.setText(rs.getString("edition"));
                                                lblpages.setText(rs.getString("pages"));
                                                lblprice.setText(rs.getString("price"));
                                        }
                                } catch (Exception ep) {
                                        ep.printStackTrace();
                                }
                        }
                });

                issue = new JButton("Issue");
                issue.setBounds(50, 510, 140, 30);
                issue.setFont(new Font("Arial", Font.BOLD, 18));
                issue.setBackground(getContentPane().getBackground());
                issue.setBorder(BorderFactory.createLineBorder(new Color(255, 252, 252), 3, true));
                issue.setForeground(Color.WHITE);
                issue.setFocusPainted(false);
                issue.addActionListener(this);
                add(issue);

                back = new JButton("Back");
                back.setBounds(280, 510, 140, 30);
                back.setFont(new Font("Arial", Font.BOLD, 18));
                back.setBackground(getContentPane().getBackground());
                back.setBorder(BorderFactory.createLineBorder(new Color(255, 252, 252), 3, true));
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
                if (ae.getSource() == issue) {
                        try {
                                String bookName = lblbookname.getText();
                                String authName = lblauthor.getText();
                                String pages = lblpages.getText();
                                String publisher = lblpublisher.getText();
                                String price = lblprice.getText();
                                String edition = lbledition.getText();
                                String bookId = cbookid.getSelectedItem();

                                Conn c = new Conn();
                                String query2 = "insert into issuedbooks values('" + bookId + "','" + bookName + "','" + authName + "','" + pages + "','" + publisher + "','" + price + "','" + edition + "', '"+issuedBy+"')";
                                c.s.executeUpdate(query2);
                                String query = "delete from bookDetails where bookId = '" + cbookid.getSelectedItem() + "' ";
                                c.s.executeUpdate(query);
                                JOptionPane.showMessageDialog(null, "Book Issued Successfully");
                                setVisible(false);
                                new StudentDashboard(issuedBy);
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                } else {
                        setVisible(false);
                        new StudentDashboard(issuedBy);
                }
        }

        public static void main(String args[]) {
                new IssueBook("");
        }
}
