import net.proteanit.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    Choice car, gender;
    JCheckBox available;
    Pickup(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("PICKUP SERVICE");
        text.setFont(new Font("Arial", Font.ITALIC+Font.BOLD, 20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblcar = new JLabel("Car");
        lblcar.setFont(new Font("Arial", Font.ITALIC+Font.BOLD, 14));
        lblcar.setBounds(50,100,100,20);
        add(lblcar);

        car = new Choice();
        car.setBounds(150,100,200,25);
        add(car);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()) {
                car.add(rs.getString("car_model"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        JLabel l1 = new JLabel("Name");
        l1.setBounds(50,160,100,20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(200,160,100,20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(340,160,100,20);
        add(l3);

        JLabel l4 = new JLabel("Car company");
        l4.setBounds(460,160,100,20);
        add(l4);

        JLabel l5 = new JLabel("Car model");
        l5.setBounds(600,160,100,20);
        add(l5);

        JLabel l6 = new JLabel("Driver availability");
        l6.setBounds(730,160,100,20);
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(900,160,100,20);
        add(l7);

        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(600, 500, 120, 30);
        submit.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        submit.addActionListener(this);
        add(submit);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200, 500, 120, 30);
        back.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        setBounds(300,200,1000, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            try{
                String query = "select * from driver where car_model = '"+car.getSelectedItem()+"'";

                Conn conn = new Conn();
                ResultSet rs;
                rs = conn.s.executeQuery(query);

                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }

    }

    public static void main(String[] args){
        new Pickup();
    }
}
