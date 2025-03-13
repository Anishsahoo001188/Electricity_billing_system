package electricity.billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewInformation extends JFrame implements ActionListener {
    String meter1;
    JButton cancel;
    ViewInformation(String meter1){
        super("view information");
        this.meter1=meter1;
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.WHITE);


        JLabel heading= new JLabel("View Information");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("seriff",Font.BOLD,20));
        add(heading);

        //Name

        JLabel name= new JLabel("Name :");
        name.setBounds(50,80,100,20);
        add(name);

        JLabel printname= new JLabel("");
        printname.setBounds(160,80,120,20);
        add(printname);

        //meterno

        JLabel meterno=new JLabel("MeterNo :");
        meterno.setBounds(50,130,100,20);
        add(meterno);

        JLabel meter= new JLabel("");
        meter.setBounds(160,130,100,20);
        add(meter);

        //address

        JLabel address=new JLabel("Address :");
        address.setBounds(50,180,100,20);
        add(address);

        JLabel addressname= new JLabel("");
        addressname.setBounds(160,180,250,20);
        add(addressname);

        //City

        JLabel city=new JLabel("City :");
        city.setBounds(50,230,100,20);
        add(city);

        JLabel cityname= new JLabel("");
        cityname.setBounds(160,230,120,20);
        add(cityname);

        //State

        JLabel state=new JLabel("State :");
        state.setBounds(500,80,100,20);
        add(state);

        JLabel statename= new JLabel("");
        statename.setBounds(610,80,50,20);
        add(statename);

        //Email

        JLabel email=new JLabel("Email :");
        email.setBounds(500,130,100,20);
        add(email);

        JLabel emailname= new JLabel("");
        emailname.setBounds(610,130,200,20);
        add(emailname);

        //Phone number

        JLabel phone=new JLabel("Phone :");
        phone.setBounds(500,180,100,20);
        add(phone);

        JLabel phonename= new JLabel("");
        phonename.setBounds(610,180,200,20);
        add(phonename);

        //getting update from the database

        try{
            DataBase d = new DataBase();
            ResultSet result= d.statement.executeQuery("select * from  new_customer1 where meterno = '"+meter1+"' ");
            if(result.next()){
                printname.setText(result.getString("name"));
                meter.setText(result.getString("meterno"));
                addressname.setText(result.getString("address"));
                cityname.setText(result.getString("city"));
                statename.setText(result.getString("state"));
                emailname.setText(result.getString("email"));
                phonename.setText(result.getString("phone"));
            }
        }
        catch(Exception e){

        }

        cancel= new JButton("Cancel");
        cancel.setBounds(200,280,80,20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("pictures/viewInfo.png"));
        Image ig2= image.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon ig= new ImageIcon(ig2);
        JLabel j= new JLabel(ig);
        j.setBounds(100,320,600,300);
        add(j);


        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
       new ViewInformation("");
    }
}
