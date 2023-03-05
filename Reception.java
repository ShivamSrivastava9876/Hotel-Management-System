import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    JButton logout, checkout, pickupService, newCustomer, rooms, department, allEmployee, managerInfo, customers, searchRoom, update, roomStatus;

    Reception(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        department.addActionListener(this);
        add(department);

        allEmployee = new JButton("Employees");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.WHITE);
        allEmployee.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customers");
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        customers.addActionListener(this);
        add(customers);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        checkout.addActionListener(this);
        add(checkout);

        update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        roomStatus.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickupService = new JButton("Pickup Service");
        pickupService.setBounds(10,390,200,30);
        pickupService.setBackground(Color.BLACK);
        pickupService.setForeground(Color.WHITE);
        pickupService.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        pickupService.addActionListener(this);
        add(pickupService);

        searchRoom = new JButton("Search Rooms");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Calibri", Font.ITALIC+Font.BOLD, 14));
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);

        setBounds(350,200,800,570);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == rooms) {
            setVisible(false);
            new Room();
        } else if (ae.getSource() == department) {
            setVisible(false);
            new Department();
        } else if (ae.getSource() == allEmployee) {
            setVisible(false);
            new Employees();
        } else if (ae.getSource() == managerInfo) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource() == customers) {
            setVisible(false);
            new Customer();
        } else if (ae.getSource() == searchRoom) {
            setVisible(false);
            new SearchRoom();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateCheck();
        } else if (ae.getSource() == roomStatus) {
            setVisible(false);
            new UpdateRoomStatus();
        } else if (ae.getSource() == pickupService) {
            setVisible(false);
            new Pickup();
        } else if (ae.getSource() == checkout) {
            setVisible(false);
            new checkout();
        } else if (ae.getSource() == logout) {
            setVisible(false);
        }
    }

    public static void main(String[] args){

        new Reception();
    }
}
