import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JButton add, cancel;
    JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    JComboBox gendercombo, availablecombo;

    AddDriver() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD DRIVER");
        heading.setFont(new Font("Tahoma", Font.BOLD+Font.ITALIC, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblname.setBounds(60, 70, 200, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);

        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblage.setBounds(60, 110, 120, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblgender.setBounds(60, 150, 120, 30);
        add(lblgender);

        String[] genderOptions = {"Male", "Female", "Other"};
        gendercombo = new JComboBox(genderOptions);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        gendercombo.setFont(new Font("Tahoma", Font.ITALIC, 14));
        add(gendercombo);

        JLabel lblcarc = new JLabel("Car Company");
        lblcarc.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblcarc.setBounds(60, 190, 120, 30);
        add(lblcarc);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);

        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblmodel.setBounds(60, 230, 120, 30);
        add(lblmodel);

        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblavailable.setBounds(60, 270, 120, 30);
        add(lblavailable);

        String[] availableOptions = {"Available", "Busy"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setFont(new Font("Tahoma", Font.ITALIC, 14));
        add(availablecombo);

        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lbllocation.setBounds(60, 310, 120, 30);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);

        add = new JButton("ADD DRIVER");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 370, 130, 30);
        add.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        add.addActionListener(this);
        add(add);

        cancel = new JButton("CANCEL");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 370, 130, 30);
        cancel.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 333, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(300,200,980,470);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String carmodel = tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();

            try{
                Conn conn = new Conn();
                String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+carmodel+"', '"+available+"', '"+location+"')";

                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "New driver added successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}

