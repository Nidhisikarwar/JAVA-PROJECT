package class_files;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewInfo extends JFrame implements ActionListener {

        JTextField tfaddress, tfeducation, tfBookLanguage, tfTime, tfdob;
        JButton update, back, edit;
        JComboBox cbBookGenre;
        JLabel lblname, lbllname, lbluname, lblphone, lblemail, lbluser;
        String username;

        ViewInfo(String username) {
                this.username = username;
                getContentPane().setBackground(Color.WHITE);
                setLayout(null);
                setTitle("Student Information - Library");

                JLabel heading = new JLabel("<html><p style='border-bottom: 3px solid rgb(255, 77, 77);'> Student Profile </p></html>");
                heading.setBounds(650, 15, 500, 50);
                heading.setFont(new Font("MONOSPACED", Font.BOLD, 30));
                heading.setBackground(Color.WHITE);
                heading.setForeground(new Color(255, 77, 77));
                add(heading);

                Font font = new Font("Arial", Font.PLAIN, 18);

                JLabel heading1 = new JLabel("Personal Information");
                heading1.setBounds(450, 80, 500, 50);
                heading1.setFont(new Font("MONOSPACED", Font.BOLD, 24));
                heading1.setBackground(Color.WHITE);
                heading1.setForeground(Color.BLACK);
                add(heading1);

                JLabel labelname = new JLabel("First Name :");
                labelname.setBounds(450, 120, 120, 65);
                labelname.setFont(new Font("Arial", Font.BOLD, 18));
                add(labelname);

                lblname = new JLabel();
                lblname.setBounds(580, 120, 150, 65);
                lblname.setFont(font);
                add(lblname);

                JLabel labellname = new JLabel("Last Name :");
                labellname.setBounds(850, 120, 120, 65);
                labellname.setFont(new Font("Arial", Font.BOLD, 18));
                add(labellname);

                lbllname = new JLabel();
                lbllname.setBounds(1000, 120, 150, 65);
                lbllname.setFont(font);
                add(lbllname);

                /*JLabel labelUname = new JLabel("Username :");
                labelUname.setBounds(450, 160, 120, 65);
                labelUname.setFont(new Font("Arial", Font.BOLD, 18));
                add(labelUname);

                lbluname = new JLabel();
                lbluname.setBounds(570, 160, 150, 65);
                lbluname.setFont(font);
                add(lbluname);*/
                JLabel labeldob = new JLabel("Date of Birth :");
                labeldob.setBounds(450, 200, 140, 65);
                labeldob.setFont(new Font("Arial", Font.BOLD, 18));
                add(labeldob);

                tfdob = new JTextField();
                tfdob.setBounds(580, 215, 200, 30);
                tfdob.setBackground(Color.WHITE);
                tfdob.setFont(font);
                tfdob.setEditable(false);
                tfdob.setBorder(BorderFactory.createEmptyBorder());
                add(tfdob);

                JLabel labeladdress = new JLabel("Address :");
                labeladdress.setBounds(450, 160, 120, 65);
                labeladdress.setFont(new Font("Arial", Font.BOLD, 18));
                add(labeladdress);

                tfaddress = new JTextField();
                tfaddress.setBounds(580, 176, 350, 30);
                tfaddress.setBackground(Color.WHITE);
                tfaddress.setFont(font);
                tfaddress.setEditable(false);
                tfaddress.setBorder(BorderFactory.createEmptyBorder());
                add(tfaddress);

                JLabel labeleducation = new JLabel("Education :");
                labeleducation.setBounds(450, 245, 120, 65);
                labeleducation.setFont(new Font("Arial", Font.BOLD, 18));
                add(labeleducation);

                tfeducation = new JTextField();
                tfeducation.setBounds(580, 260, 200, 30);
                tfeducation.setBackground(Color.WHITE);
                tfeducation.setFont(font);
                tfeducation.setEditable(false);
                tfeducation.setBorder(BorderFactory.createEmptyBorder());
                add(tfeducation);

                JLabel heading2 = new JLabel("Contact Information");
                heading2.setBounds(450, 310, 500, 50);
                heading2.setFont(new Font("MONOSPACED", Font.BOLD, 24));
                heading2.setBackground(Color.WHITE);
                heading2.setForeground(Color.BLACK);
                add(heading2);

                JLabel labelemail = new JLabel("Email Address :");
                labelemail.setBounds(450, 365, 150, 30);
                labelemail.setFont(new Font("Arial", Font.BOLD, 18));
                add(labelemail);

                lblemail = new JLabel();
                lblemail.setBounds(610, 365, 350, 30);
                lblemail.setFont(font);
                add(lblemail);

                JLabel labelphone = new JLabel("Phone number :");
                labelphone.setBounds(450, 420, 150, 30);
                labelphone.setFont(new Font("Arial", Font.BOLD, 18));
                add(labelphone);

                lblphone = new JLabel();
                lblphone.setBounds(610, 420, 180, 30);
                lblphone.setFont(font);
                add(lblphone);

                JLabel heading3 = new JLabel("Intrests");
                heading3.setBounds(450, 470, 200, 50);
                heading3.setFont(new Font("MONOSPACED", Font.BOLD, 24));
                heading3.setBackground(Color.WHITE);
                heading3.setForeground(Color.BLACK);
                add(heading3);

                JLabel labelBookGenre = new JLabel("Book Genre :");
                labelBookGenre.setBounds(450, 530, 150, 30);
                labelBookGenre.setFont(new Font("Arial", Font.BOLD, 18));
                add(labelBookGenre);

                String genre[] = {" - - ", "Fiction", "Non-Fiction", "Literary", "Science", "Novel", "Thriller", "History", "Adventure", "Horror", "Biography"};
                cbBookGenre = new JComboBox(genre);
                cbBookGenre.setBounds(590, 530, 180, 30);
                cbBookGenre.setFont(new Font("Arial", Font.PLAIN, 18));
                cbBookGenre.setBackground(Color.WHITE);
                cbBookGenre.setSelectedIndex(0);
                add(cbBookGenre);

                JLabel labelTime = new JLabel("Reading Time :");
                labelTime.setBounds(450, 577, 180, 30);
                labelTime.setFont(new Font("Arial", Font.BOLD, 18));
                add(labelTime);

                tfTime = new JTextField();
                tfTime.setBounds(590, 577, 180, 30);
                tfTime.setBackground(Color.WHITE);
                tfTime.setFont(font);
                tfTime.setEditable(false);
                tfTime.setBorder(BorderFactory.createEmptyBorder());
                add(tfTime);

                JLabel labelBookLanguage = new JLabel("Language :");
                labelBookLanguage.setBounds(450, 620, 250, 30);
                labelBookLanguage.setFont(new Font("Arial", Font.BOLD, 18));
                add(labelBookLanguage);

                tfBookLanguage = new JTextField();
                tfBookLanguage.setBounds(590, 620, 180, 30);
                tfBookLanguage.setBackground(Color.WHITE);
                tfBookLanguage.setFont(font);
                tfBookLanguage.setEditable(false);
                tfBookLanguage.setBorder(BorderFactory.createEmptyBorder());
                add(tfBookLanguage);

                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./images/viewinfo.png"));
                Image i2 = i1.getImage().getScaledInstance(230, 230, Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel img = new JLabel(new ImageIcon(i2));
                img.setBounds(80, 40, 230, 230);
                add(img);

                lbluser = new JLabel("@" + username);//display username 
                lbluser.setBounds(90, 300, 210, 45);
                lbluser.setFont(new Font("MONOSPACED", Font.BOLD, 25));
                lbluser.setBackground(Color.WHITE);
                lbluser.setForeground(new Color(255, 77, 77));
                add(lbluser);

                update = new JButton("Update");
                update.setBounds(90, 440, 210, 45);
                update.setFont(new Font("MONOSPACED", Font.BOLD, 22));
                update.addActionListener(this);
                update.setBackground(new Color(255, 77, 77));
                update.setForeground(Color.WHITE);
                update.setFocusPainted(false);
                update.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0, true));
                update.setVisible(false);
                add(update);

                back = new JButton("Back");
                back.setBounds(950, 670, 170, 50);
                back.setFont(new Font("MONOSPACED", Font.BOLD, 22));
                back.addActionListener(this);
                back.setBackground(new Color(255, 77, 77));
                back.setFocusPainted(false);
                back.setForeground(Color.WHITE);
                back.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0, true));
                add(back);

                edit = new JButton("Edit Profile");
                edit.setBounds(90, 370, 210, 45);
                edit.setFont(new Font("MONOSPACED", Font.BOLD, 22));
                edit.addActionListener(this);
                edit.setBackground(new Color(255, 77, 77));
                edit.setForeground(Color.WHITE);
                edit.setFocusPainted(false);
                edit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0, true));
                add(edit);

                try {
                        Conn c = new Conn();
                        String query = "select * from studentdetails where username= '" + username + "'";
                        ResultSet rs = c.s.executeQuery(query);
                        while (rs.next()) {
                                lblname.setText(rs.getString("firstname"));
                                lbllname.setText(rs.getString("lastname"));
                                tfdob.setText(rs.getString("dob"));
                                tfaddress.setText(rs.getString("address"));
                                cbBookGenre.setSelectedItem(rs.getString("bookGenre"));
                                lblphone.setText(rs.getString("phone"));
                                lblemail.setText(rs.getString("email"));
                                tfeducation.setText(rs.getString("education"));
                                tfTime.setText(rs.getString("readingTime"));
                                tfBookLanguage.setText(rs.getString("languages"));
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }

                setSize(1200, 800);
                setLocation(100, 10);
                setVisible(true);
                setResizable(false);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == edit) {
                        tfaddress.setEditable(true);
                        tfeducation.setEditable(true);
                        tfdob.setEditable(true);
                        cbBookGenre.setEditable(true);
                        tfTime.setEditable(true);
                        tfBookLanguage.setEditable(true);
                        update.setVisible(true);
                        tfaddress.setBorder(BorderFactory.createEtchedBorder());
                        tfeducation.setBorder(BorderFactory.createEtchedBorder());
                        cbBookGenre.setBorder(BorderFactory.createEtchedBorder());
                        tfTime.setBorder(BorderFactory.createEtchedBorder());
                        tfBookLanguage.setBorder(BorderFactory.createEtchedBorder());
                        tfdob.setBorder(BorderFactory.createEtchedBorder());
                } else if (ae.getSource() == update) {
                        tfaddress.setEditable(false);
                        tfeducation.setEditable(false);
                        tfdob.setEditable(false);
                        cbBookGenre.setEditable(false);
                        tfTime.setEditable(false);
                        tfBookLanguage.setEditable(false);
                        update.setVisible(false);

                        String address = tfaddress.getText();
                        String education = tfeducation.getText();
                        String bookGenre = (String) cbBookGenre.getSelectedItem();
                        String readingTime = tfTime.getText();
                        String languages = tfBookLanguage.getText();
                        String dob = tfdob.getText();
                        
                        if(address.length() < 5){
                                JOptionPane.showMessageDialog(null, "Address length should be minimum 5 characters!", "Invalid Address", JOptionPane.ERROR_MESSAGE); 
                        }
                        else if (dob.length() == 0){
                               JOptionPane.showMessageDialog(null, "Please enter your Date of Birth.", "DOB", JOptionPane.ERROR_MESSAGE);  
                        }
                        else {
                                try {
                                        Conn conn = new Conn();
                                        String query = "update studentdetails set dob ='" + dob + "', address = '" + address + "' , education = '" + education + "' , bookGenre = '" + bookGenre + "'  , readingTime='" + readingTime + "', languages='" + languages + "' where username = '" +username +"' ";
                                        conn.s.executeUpdate(query);
                                        JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                                        setVisible(false);
                                        new ViewInfo(username);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                } else {
                        setVisible(false);
                        new StudentDashboard(username);
                }
        }

        public static void main(String args[]) {
                new ViewInfo("");
        }
}
