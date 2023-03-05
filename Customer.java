import net.proteanit.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Customer extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Customer(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Document");
        l1.setBounds(60,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Document Number");
        l2.setBounds(180,10,120,20);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(365,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(520,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(680,10,100,20);
        add(l5);

        JLabel l6 = new JLabel("Room");
        l6.setBounds(835,10,100,20);
        add(l6);

        JLabel l7 = new JLabel("Check-In Time");
        l7.setBounds(975,10,100,20);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(1130,10,100,20);
        add(l8);

        table = new JTable();
        table.setBounds(0,40,1250,400);
        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(565, 500, 120, 30);
        back.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        setBounds(150,150,1250, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args){
        new Customer();
    }
}
