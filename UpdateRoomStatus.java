import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateRoomStatus extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfavailability, tfcleaningStatus, tfdeposit, tfpending;
    JButton check, update, back;
    UpdateRoomStatus(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("UPDATE ROOM STATUS");
        text.setFont(new Font("Arial", Font.ITALIC+Font.BOLD, 25));
        text.setBounds(30, 20, 300, 30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 130, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 130, 150, 20);
        add(tfroom);

        JLabel lblavailability = new JLabel("Availability");
        lblavailability.setBounds(30, 180, 100, 20);
        add(lblavailability);

        tfavailability = new JTextField();
        tfavailability.setBounds(200, 180, 150, 20);
        add(tfavailability);

        JLabel lblcleaningStatus = new JLabel("Cleaning Status");
        lblcleaningStatus.setBounds(30, 230, 100, 20);
        add(lblcleaningStatus);

        tfcleaningStatus = new JTextField();
        tfcleaningStatus.setBounds(200, 230, 150, 20);
        add(tfcleaningStatus);

        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 300, 100, 30);
        check.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150, 300, 100, 30);
        update.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 300, 100, 30);
        back.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(300, 200, 980, 450);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+tfroom.getText()+"'");
                while(rs2.next()) {
                    tfavailability.setText(rs2.getString("availability"));
                    tfcleaningStatus.setText(rs2.getString("cleaning_status"));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        else if (ae.getSource() == update) {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String availability = tfavailability.getText();
            String cleaningStatus = tfcleaningStatus.getText();

            try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '"+availability+"', cleaning_status = '"+cleaningStatus+"' where room_number = '"+room+"'");

                JOptionPane.showMessageDialog(null, "Data Updated Successfully");

                setVisible(false);
                new Reception();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args){
        new UpdateRoomStatus();
    }
}
