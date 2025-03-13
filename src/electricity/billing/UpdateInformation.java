package electricity.billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateInformation extends JFrame implements ActionListener {
    String meter;
    JLabel nametf,metertf;
    JTextField addresstf,citytf,statetf,emailtf,phonetf;
    JButton update,cancel;
    UpdateInformation(String meter){
        super("UpdateInformation");
        this.meter=meter;
        setLayout(null);
        setBounds(400,150,660,500);
        getContentPane().setBackground(new Color(98, 154, 221));


        JLabel heading= new JLabel("Update Information");
        heading.setBounds(100,10,400,40);
        heading.setFont(new Font("seriff",Font.BOLD,18));
        add(heading);

        JLabel name = new JLabel("Name :");
        name.setBounds(30,70,100,20);
        add(name);
        nametf=new JLabel("");
        nametf.setBounds(150,70,150,20);
        add(nametf);

        //metrno

        JLabel meterno = new JLabel("Meter no :");
        meterno.setBounds(30,120,100,20);
        add(meterno);
        metertf=new JLabel("");
        metertf.setBounds(150,120,150,20);
        add(metertf);

        //address

        JLabel address = new JLabel("Address :");
        address.setBounds(30,170,100,20);
        add(address);
        addresstf=new JTextField();
        addresstf.setBounds(150,170,150,20);
        add(addresstf);

        //city

        JLabel city = new JLabel("City :");
        city.setBounds(30,220,100,20);
        add(city);
        citytf=new JTextField();
        citytf.setBounds(150,220,150,20);
        add(citytf);

        //state
        JLabel state = new JLabel("State :");
        state.setBounds(30,270,100,20);
        add(state);
        statetf=new JTextField();
        statetf.setBounds(150,270,150,20);
        add(statetf);

        //email
        JLabel email = new JLabel("Email :");
        email.setBounds(30,320,100,20);
        add(email);
        emailtf=new JTextField();
        emailtf.setBounds(150,320,150,20);
        add(emailtf);

        //phone

        JLabel phone = new JLabel("Phone :");
        phone.setBounds(30,370,100,20);
        add(phone);
        phonetf=new JTextField();
        phonetf.setBounds(150,370,150,20);
        add(phonetf);

        try{
            DataBase d= new DataBase();
            ResultSet result= d.statement.executeQuery("select * from new_customer1 where meterno = '"+meter+"'");
            if (result.next()){
                nametf.setText(result.getString("name"));
                metertf.setText(result.getString("meterno"));
                addresstf.setText(result.getString("address"));
                citytf.setText(result.getString("city"));
                statetf.setText(result.getString("state"));
                emailtf.setText(result.getString("email"));
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }


        update=new JButton("Update");
        update.setForeground(Color.white);
        update.setBackground(Color.BLACK);
        update.setBounds(80,420,80,20);
        update.addActionListener(this);
        add(update);

        cancel=new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(180,420,80,20);
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);

        ImageIcon image= new ImageIcon(ClassLoader.getSystemResource("pictures/update.png"));
        Image ig1=image.getImage().getScaledInstance(410,470,Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(ig1);
        JLabel jl2=new JLabel(image2);
        jl2.setBounds(320,0,410,470);
        add(jl2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==update){
            String saddress= addresstf.getText();
            String sstate=statetf.getText();
            String scity=statetf.getText();
            String semail= emailtf.getText();
            String sphone= phonetf.getText();
            try{
                DataBase d= new DataBase();
                d.statement.executeUpdate("update new_customer1 set address = '"+saddress+"', city = '"+scity+"', state = '"+sstate+"', email = '"+semail+"', phoneno = '"+sphone+"'  ");
                JOptionPane.showMessageDialog(null,"Information Updated Successfully");
                setVisible(false);
            }
            catch(Exception p){
                p.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateInformation("");
    }
}
