package electricity.billing;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class PayBill extends JFrame implements ActionListener {
    String meterno;
    Choice monthcho;
    JButton pay,back;
    PayBill(String meterno){
        super("Pay Bill");
        getContentPane().setBackground(new Color(218, 176, 73));

        this.meterno=meterno;
        setBounds(300,150,900,600);
        setLayout(null);
        setVisible(true);

        //Headding

        JLabel paybill = new JLabel("Pay Bill");
        paybill.setFont(new Font("Tahoma",Font.BOLD,20));
        paybill.setBounds(120,5,400,30);
        add(paybill);

        //meter number

        JLabel meter= new JLabel("Meter No :");
        meter.setBounds(35,80,200,20);
        add(meter);

        JLabel metertf= new JLabel("");
        metertf.setBounds(300,80,200,20);
        add(metertf);

        //name
        JLabel name= new JLabel("Name :");
        name.setBounds(35,140,200,20);
        add(name);

        JLabel nametf= new JLabel("");
        nametf.setBounds(300,140,200,20);
        add(nametf);

        //Month

        JLabel month= new JLabel("Month :");
        month.setBounds(35,200,200,20);
        add(month);

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
        monthcho.setBounds(300,200,200,20);
        add(monthcho);

        //unit

        JLabel unit= new JLabel("Unit Consumed :");
        unit.setBounds(35,260,200,20);
        add(unit);

        JLabel unittf= new JLabel("");
        unittf.setBounds(300,260,200,20);
        add(unittf);

        //calculate total bill

        JLabel totalbill= new JLabel("Total Bill :");
        totalbill.setBounds(35,320,200,20);
        add(totalbill);

        JLabel totalbilltf= new JLabel("");
        totalbilltf.setBounds(300,320,200,20);
        add(totalbill);

        //bill status

        JLabel status = new JLabel("Status :");
        status.setBounds(35,380,200,20);
        add(status);

        JLabel statustf= new JLabel("");
        statustf.setForeground(Color.red);
        statustf.setBounds(300,380,200,20);
        add(status);

        try{
           DataBase d = new DataBase();
           ResultSet result= d.statement.executeQuery("select * from new_customer1 where meterno = '"+meterno+"'");
           while(result.next()){
               metertf.setText(result.getString("meterno"));
               nametf.setText(result.getString("name"));

           }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        monthcho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    DataBase b= new DataBase();
                    ResultSet result= b.statement.executeQuery("select * from bill where meter_number = '"+meterno+"'");

                    while(result.next()){
                        unittf.setText(result.getString("unit"));
                        totalbilltf.setText(result.getString("total_bill"));
                        statustf.setText(result.getString("status"));

                    }
                }
                catch(Exception p){
                    p.printStackTrace();
                }

            }
        });

        //pay button

        pay= new JButton("Pay");
        pay.setBounds(70,440,80,20);
        pay.setForeground(Color.white);
        pay.addActionListener(this);
        pay.setBackground(Color.BLACK);

        add(pay);

        back= new JButton("Back");
        back.setBounds(170,440,80,20);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);

        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pay){
            try{
                DataBase d= new DataBase();
                d.statement.executeUpdate("update bill status = 'Paid' where meter_number = '"+meterno+"' and month = '"+monthcho.getSelectedItem()+"' ");
            }
            catch(Exception f){
                f.printStackTrace();
            }
            setVisible(false);
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new PayBill("");
    }
}
