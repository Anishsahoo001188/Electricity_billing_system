package electricity.billing;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class BillDetails extends JFrame {
    String meterno;
    BillDetails(String meterno){
        super("Bill Details");
        this.meterno=meterno;
        setBounds(400,150,700,650);
        setLayout(null);
        getContentPane().setBackground(Color.orange);

        //getting the table
        JTable table = new JTable();
         try{
            DataBase d = new DataBase();
             ResultSet result= d.statement.executeQuery("select * from bill where meter_number ='"+meterno+"'");
             table.setModel(DbUtils.resultSetToTableModel(result));
         }
         catch(Exception e){
             e.printStackTrace();
         }

        JScrollPane sp= new JScrollPane(table);
         sp.setBounds(0,0,700,650);
         add(sp);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BillDetails("");
    }
}
