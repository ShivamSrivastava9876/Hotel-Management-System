import net.proteanit.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    ManagerInfo(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(60,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(220,10,100,20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(380,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(540,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(680,10,100,20);
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(835,10,100,20);
        add(l6);

        JLabel l7 = new JLabel("Email Id");
        l7.setBounds(985,10,100,20);
        add(l7);

        JLabel l8 = new JLabel("Aadhaar");
        l8.setBounds(1130,10,100,20);
        add(l8);

        table = new JTable();
        table.setBounds(0,40,1250,400);
        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from employee where job = 'Manager'");
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
        new ManagerInfo();
    }
}
