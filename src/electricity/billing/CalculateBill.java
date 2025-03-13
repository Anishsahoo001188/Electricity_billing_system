package electricity.billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class CalculateBill extends JFrame implements ActionListener {
    JLabel meterno ,nametext, addresstext;
    JTextField unittext;
    Choice meternocho, monthcho;
    JButton submit, cancel;

    CalculateBill(){
        super("CalculateBill");
        setSize(650,450);
        setLocation(400,200);
        //panel

        JPanel panel= new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(214,195,247));
        add(panel);

        //heading
        JLabel heading= new JLabel("Calculate Bill");
        heading.setBounds(70,10,300,20);
        heading.setFont(new Font("tahoma",Font.BOLD,18));
        panel.add(heading);


        //meterNumber

        meterno= new JLabel("Meter Number :");
        meterno.setBounds(50,80,100,20);
        panel.add(meterno);
        meternocho= new Choice();
        meternocho.setBounds(160,81,150,20);
        try{
            DataBase d= new DataBase();
            ResultSet result=  d.statement.executeQuery("select * from new_customer1");
            while(result.next()){
                meternocho.add(result.getString("meterno"));
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        panel.add(meternocho);

        //name

        JLabel name= new JLabel("Name :");
        name.setBounds(50,130,100,20);
        panel.add(name);

        nametext=new JLabel();
        nametext.setBounds(160,131,150,20);
        nametext.setFont(new Font("tahoma",Font.BOLD,18));
        panel.add(nametext);

        //address
        JLabel address =new JLabel("Address :");
        address.setBounds(50,180,100,20);
        panel.add(address);
        addresstext=new JLabel();
        addresstext.setBounds(160,181,150,20);
        addresstext.setFont(new Font("tahoma",Font.BOLD,18));
        panel.add(addresstext);
        meternocho.addItemListener(new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent e) {
               try{
                   DataBase d= new DataBase();
                   ResultSet result= d.statement.executeQuery("select * from new_customer1 where meterno = '"+meternocho.getSelectedItem()+"'");
                   while(result.next()){
                       nametext.setText(result.getString("name"));
                       addresstext.setText(result.getString("address"));
                   }
               }
               catch(Exception p){
                   p.printStackTrace();
               }
           }
        });
        JLabel unitconsumed = new JLabel("Unit Consumed :");
        unitconsumed.setBounds(50,230,100,20);
        panel.add(unitconsumed);

        unittext= new JTextField();
        unittext.setBounds(160,231,150,20);
        panel.add(unittext);

        //month

        JLabel month= new JLabel("Month :");
        month.setBounds(50,280,100,20);
        panel.add(month);
        monthcho=new Choice();
        monthcho.addItem("January");
        monthcho.addItem("Feburary");
        monthcho.addItem("March");
        monthcho.addItem("April");
        monthcho.addItem("May");
        monthcho.addItem("June");
        monthcho.addItem("July");
        monthcho.addItem("August");
        monthcho.addItem("September");
        monthcho.addItem("October");
        monthcho.addItem("November");
        monthcho.addItem("December");
        monthcho.setBounds(160,281,150,20);
        panel.add(monthcho);


        //submit button

        submit= new JButton("Submit");
        submit.setBounds(100,330,80,20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        panel.add(submit);

        //cancel

        cancel= new JButton("Cancel");
        cancel.setBounds(190,330,80,20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon ig= new ImageIcon(ClassLoader.getSystemResource("pictures/budget.png"));
        Image scale= ig.getImage().getScaledInstance(230 ,200,Image.SCALE_DEFAULT);
        ImageIcon  ig2= new ImageIcon(scale);
        JLabel j= new JLabel(ig2);
        add(j,"West");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit) {
            String Meterno =meternocho.getSelectedItem();
            String unit= unittext.getText();
            String monthss= monthcho.getSelectedItem();
            int total_bill=0;
            int units= Integer.parseInt(unit);
            String query_tax="select * from tax";


            try{
                DataBase d= new DataBase();
                ResultSet result= d.statement.executeQuery(query_tax);
                while(result.next()){
                    total_bill+=units*Integer.parseInt(result.getString("cost_per_unit"));
                    total_bill+=Integer.parseInt(result.getString("meter_rent"));
                    total_bill+=Integer.parseInt(result.getString("service_charge"));
                    total_bill+=Integer.parseInt(result.getString("service_tax"));
                    total_bill+=Integer.parseInt(result.getString("swachh_bharat"));
                    total_bill+=Integer.parseInt(result.getString("fixed_tax"));

                }

            }
            catch (Exception p){
                p.printStackTrace();
            }
            String query_bill="insert into bill values('"+Meterno+"','"+monthss+"','"+unit+"','"+total_bill+"','not paid')";
            try{
                DataBase d= new DataBase();
                d.statement.executeUpdate(query_bill);
                JOptionPane.showMessageDialog(null,"Customer bill updated successfully");
                setVisible(false);
            }
            catch(Exception i){
                i.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CalculateBill();
    }
}
