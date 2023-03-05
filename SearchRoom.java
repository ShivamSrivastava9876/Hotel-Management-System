import net.proteanit.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back, submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("SEARCH FOR ROOM");
        text.setFont(new Font("Arial", Font.ITALIC+Font.BOLD, 20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setFont(new Font("Arial", Font.ITALIC+Font.BOLD, 14));
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        bedType = new JComboBox(new String[] {"Single bed", "Double bed"});
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("Only display available rooms");
        available.setFont(new Font("Arial", Font.ITALIC+Font.BOLD, 14));
        available.setBounds(650,100,240,25);
        available.setBackground(Color.WHITE);
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(480,160,100,20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);
        add(l5);

        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from room");
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
                String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";

                Conn conn = new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }
                else{
                    rs = conn.s.executeQuery(query1);
                }
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
        new SearchRoom();
    }
}
