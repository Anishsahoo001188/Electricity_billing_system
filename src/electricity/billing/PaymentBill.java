package electricity.billing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentBill extends JFrame implements ActionListener {
    JButton button;
    String meter;
    PaymentBill(String meter){
        super("Payment Bill");
        this.meter=meter;
        JEditorPane j= new JEditorPane();
        j.setEditable(false);

        try{
            j.setPage("https://paytm.com/");
            j.setBounds(400,150,800,600);
        }
        catch (Exception e){
            e.printStackTrace();
            j.setContentType("text/html");
            j.setText("<html> Error! Error! Error! Error! Error! Error! </html>");

        }
        JScrollPane sp= new JScrollPane(j);
        add(sp);
        button=new JButton();
        button.setBounds(640,20,80,30);
        button.addActionListener(this);
        j.add(button);


        setBounds(400,150,800,600);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new PayBill(meter);

    }

    public static void main(String[] args) {
        new PaymentBill("");
    }
}
