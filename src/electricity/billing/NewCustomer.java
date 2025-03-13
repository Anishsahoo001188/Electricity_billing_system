package electricity.billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener {
    JLabel name, heading,meterno,address, city, state, email, phone,meternotf;
    JTextField nametf ,  addresstf,citytf, statetf, emailtf, phonetf;
    JButton next,cancel;
    NewCustomer(){
        super("New customer");
        setSize(700,550);
        setLocation(400,200);
        JPanel panel=  new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        //Heaading

        heading= new JLabel("New Customer");
        heading.setBounds(200,10,200,20);
        heading.setFont(new Font("tahoma",Font.BOLD,18));
        panel.add(heading);

        //Name

        name= new JLabel("Name :");
        name.setBounds(50,80,100,20);
        panel.add(name);
        nametf=new JTextField();
        nametf.setBounds(140,81,150,20);
        panel.add(nametf);

        //METER no

        meterno= new JLabel("Meter No :");
        meterno.setBounds(50,130,100,20);
        panel.add(meterno);
        meternotf=new JLabel("");
        meternotf.setBounds(140,131,150,20);
        panel.add(meternotf);
        Random ran= new Random();
        long num= ran.nextLong() % 1000000;
        meternotf.setText(""+Math.abs(num));

        //address
        address= new JLabel("Address :");
        address.setBounds(50,180,100,20);
        panel.add(address);
        addresstf=new JTextField();
        addresstf.setBounds(140,181,150,20);
        panel.add(addresstf);

        //city

        city= new JLabel("City :");
        city.setBounds(50,230,100,20);
        panel.add(city);
        citytf=new JTextField();
        citytf.setBounds(140,231,150,20);
        panel.add(citytf);

        //State
        state= new JLabel("State :");
        state.setBounds(50,280,100,20);
        panel.add(state);
        statetf=new JTextField();
        statetf.setBounds(140,281,150,20);
        panel.add(statetf);

        //email

        email= new JLabel("Email :");
        email.setBounds(50,330,100,20);
        panel.add(email);
        emailtf=new JTextField();
        emailtf.setBounds(140,331,150,20);
        panel.add(emailtf);

        //phone no
        phone= new JLabel("Phone :");
        phone.setBounds(50,380,100,20);
        panel.add(phone);
        phonetf=new JTextField();
        phonetf.setBounds(140,381,150,20);
        panel.add(phonetf);

        //next button
         next=new JButton("Next");
         next.setBounds(80,430,80,20);
         next.setBackground(Color.BLACK);
         next.setForeground(Color.white);
         next.addActionListener(this);
         panel.add(next);

         //cancel

        cancel=new JButton("Cancel");
        cancel.setBounds(190,430,80,20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon ig= new ImageIcon(ClassLoader.getSystemResource("pictures/boy.png"));
        Image scale= ig.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon  ig2= new ImageIcon(scale);
        JLabel j= new JLabel(ig2);
        add(j,"West");


        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            String name= nametf.getText();
            String  meterno= meternotf.getText();
            String address= addresstf.getText();
            String city= citytf.getText();
            String state= statetf.getText();
            String email= emailtf.getText();
            String phone= phonetf.getText();
            String query_customer="insert into new_customer1 values('"+name+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"','"+meterno+"')";
            String query_signup="insert into signup values('"+meterno+"','','"+name+"','','')";
            try{
                DataBase c= new DataBase();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);
            }
            catch(Exception E){
                E.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"customer details added successfully");
            setVisible(false);
            new MeterInfo(meterno);

        }
         else{
             setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
