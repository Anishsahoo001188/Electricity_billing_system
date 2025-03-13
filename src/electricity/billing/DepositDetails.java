package electricity.billing;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DepositDetails extends JFrame implements ActionListener {
    Choice searchmeterch,searchnamech;
    JTable table;
    JButton search, print, close;
    DepositDetails(){
        super("Customer Details");
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        setSize(650,500);
        setLocation(400,200);

        //SEARCH METER NUMBER  AND GET THE USER DETAILS

        JLabel searchmeter= new JLabel("Search by meter :");
        searchmeter.setBounds(20,20,100,20);
        add(searchmeter);
        searchmeterch= new Choice();
        searchmeterch.setBounds(130,20,150,20);
        add(searchmeterch);

        JLabel searchbyname = new JLabel("Search by name : ");
        searchbyname.setBounds(360,20,100,20);
        add(searchbyname);
        searchnamech= new Choice();
        searchnamech.setBounds(470,20,150,20);
        add(searchnamech);

        try{
            DataBase d = new DataBase();
            ResultSet result= d.statement.executeQuery("select * from bill");
            while(result.next()){
                searchmeterch.addItem(result.getString("meterno"));
                searchnamech.addItem(result.getString("name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //seaarch button

        search= new JButton("Search");
        search.setBounds(50,70,80,20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);

        //print button
        print= new JButton("Print");
        print.setBounds(160,70,80,20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.white);
        print.addActionListener(this);
        add(print);

        //close button
        close= new JButton("Close");
        close.setBounds(530,70,80,20);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.white);
        close.addActionListener(this);
        add(close);

        //TABLE FOR GETTING THE DATA
        table= new JTable();
        try{
            DataBase d= new DataBase();
            ResultSet result= d.statement.executeQuery("select * from new_customer1");
            table.setModel(DbUtils.resultSetToTableModel(result));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // SCROLLING A TABLE
        JScrollPane scroll= new JScrollPane(table);
        scroll.setBounds(0,100,650,500);
        scroll.setBackground(Color.WHITE);

        add(scroll);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String meter=searchmeterch.getSelectedItem();
            String name=searchnamech.getSelectedItem();
            try{
                DataBase d= new DataBase();
                ResultSet result= d.statement.executeQuery("select * from new_customer1 where meterno = '"+meter+"' and name = '"+name+"'");
                table.setModel(DbUtils.resultSetToTableModel(result));
            }
            catch(Exception f){
                f.printStackTrace();
            }
        }
        else if (e.getSource()==print){
            try{
                table.print();
            }
            catch(Exception o){
                o.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new DepositDetails();
    }
}
