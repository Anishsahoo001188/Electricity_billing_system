package electricity.billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeterInfo extends JFrame implements ActionListener {
    JLabel meterno,mnotext,heading,meternum,metertype,phasetype, billtype,info ,xx;
    Choice meternumch, metertypech,phasetypech,billtypech;
    JButton submit;
    String mno;
    MeterInfo(String mno){
        super("Meter Information");
        this.mno=mno;
        setSize(700,500);
        setLocation(400,200);

        //Desining the panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);


        // setting the heading
        heading = new JLabel("Meter Information");
        heading.setBounds(200,10,200,20);
        heading.setFont(new Font("tahoma",Font.BOLD,18));
        panel.add(heading);

        //meter number

        meterno= new JLabel("Meter Number");
        meterno.setBounds(50,80,100,20);
        panel.add(meterno);
        mnotext= new JLabel(mno);
        mnotext.setBounds(160,81,100,20);
        panel.add(mnotext);

        //meter location
        meternum=new JLabel("Meter Location :");
        meternum.setBounds(50,130,100,20);
        panel.add(meternum);
        meternumch= new Choice();
        meternumch.setBounds(160,131,150,20);
        meternumch.addItem("Outside");
        meternumch.addItem("Inside");
        panel.add(meternumch);

        //Meter type
        metertype=new JLabel("Meter Type :");
        metertype.setBounds(50,180,100,20);
        panel.add(metertype);
        metertypech= new Choice();
        metertypech.setBounds(160,181,150,20);
        metertypech.addItem("Electric Meter");
        metertypech.addItem("Smart Meter");
        metertypech.addItem("Solar Meter");
        panel.add(metertypech);

        //phase code
        phasetype=new JLabel("Phase Code :");
        phasetype.setBounds(50,230,100,20);
        panel.add(phasetype);
        phasetypech= new Choice();
        phasetypech.setBounds(160,231,150,20);
        phasetypech.addItem("011");
        phasetypech.addItem("022");
        phasetypech.addItem("033");
        phasetypech.addItem("044");
        phasetypech.addItem("055");
        phasetypech.addItem("066");
        phasetypech.addItem("077");
        phasetypech.addItem("088");
        phasetypech.addItem("099");
        panel.add(phasetypech);

        //bill type

        billtype=new JLabel("Bill Type :");
        billtype.setBounds(50,280,100,20);
        panel.add(billtype);
        billtypech= new Choice();
        billtypech.setBounds(160,281,150,20);
        billtypech.addItem("Normal");
        billtypech.addItem("Industrial");
        panel.add(billtypech);

        info=new JLabel("30 Days Billing Time...");
        info.setBounds(50,330,150,20);
        panel.add(info);

        xx=new JLabel("Note:-\nby default is calculated for 30 days only.");
        xx.setBounds(50,330,260,80);
        panel.add(xx);

        // submit button

        submit=new JButton("Submit");
        submit.setBounds(200,400,100,20);
        submit.setForeground(Color.white);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        panel.add(submit);

        setLayout(new BorderLayout());
        add(panel,"Center");


        ImageIcon ig= new ImageIcon(ClassLoader.getSystemResource("pictures/information.png"));
        Image i= ig.getImage().getScaledInstance(210,180,Image.SCALE_DEFAULT);
        ImageIcon ig2= new ImageIcon(i);
        JLabel ii= new JLabel(ig2);
        add(ii,"East");


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String meternumber=mnotext.getText();
            String meterlocation= meternumch.getSelectedItem();
            String metertype= metertypech.getSelectedItem();
            String phasecode= phasetypech.getSelectedItem();
            String billtype=billtypech.getSelectedItem();
            String days="30";
            String query_meterinfou="insert into meter values('"+meternumber+"','"+meterlocation+"','"+metertype+"','"+phasecode+"','"+billtype+"','"+days+"')";
            try{
                DataBase d= new DataBase();
                d.statement.executeUpdate(query_meterinfou);
                JOptionPane.showMessageDialog(null,"Meter information submitted successfully");
                setVisible(false);
            }
            catch (Exception E){
                E.printStackTrace();
            }

        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MeterInfo("");
    }
}
