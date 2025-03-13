package electricity.billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Screen extends JFrame implements ActionListener {
    String account_type;
    String metertype;
    Main_Screen(String account_type,String metertype){
       super("Main Page");
       this.account_type=account_type;
       this.metertype=metertype;
       ImageIcon ig= new ImageIcon(ClassLoader.getSystemResource("pictures/WhatsApp Image 2025-03-09 at 17.55.55_5b55bdfc.jpg"));
       Image ig1= ig.getImage().getScaledInstance(1532,830,Image.SCALE_DEFAULT);
       ImageIcon ig2= new ImageIcon(ig1);
       JLabel jg= new JLabel(ig2);
       add(jg);


       //MENU BAR

        JMenuBar menubar= new JMenuBar();
        setJMenuBar(menubar);


        //-----------------------------------------------------------------------------------------------

        JMenu menu= new JMenu("Menu");
        menu.setFont(new Font("serif",Font.BOLD,20));

        //MENU ITEMS
        JMenuItem newcustomer= new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN,15));
        newcustomer.addActionListener(this);
        //icon
        ImageIcon customerig= new ImageIcon(ClassLoader.getSystemResource("pictures/newcustomer.png"));
        Image customers= customerig.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(customers));
        menu.add(newcustomer);

        //CUSTOMER DETAILS
        JMenuItem customerdetails= new JMenuItem("Customer details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,15));
        customerdetails.addActionListener(this);
        ImageIcon detailsig= new ImageIcon(ClassLoader.getSystemResource("pictures/customerDetails.png"));
        Image customericon= detailsig.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(customericon));
        menu.add(customerdetails);

        //DEPOSIT DETAILS
        JMenuItem detailsdeposit = new JMenuItem("Deposit Details");
        detailsdeposit.setFont(new Font("monospaced",Font.PLAIN,15));
        detailsdeposit.addActionListener(this);
        ImageIcon detailsicon= new ImageIcon(ClassLoader.getSystemResource("pictures/depositdetails.png"));
        Image detailsdepoicon= detailsicon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        detailsdeposit.setIcon(new ImageIcon(detailsdepoicon));
        menu.add(detailsdeposit);

        //CALCULATE BILL
         JMenuItem calculatebill= new JMenuItem("Calculate Bill");
         calculatebill.setFont(new Font("monospaced",Font.PLAIN,15));
         calculatebill.addActionListener(this);
         ImageIcon calculateicon = new ImageIcon(ClassLoader.getSystemResource("pictures/calculatorbills.png"));
         Image calculatesc= calculateicon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
         calculatebill.setIcon(new ImageIcon(calculatesc));
         menu.add(calculatebill);

         //---------------------------------------------------------------------------------------

         // INFORMATION MENU
        JMenu information= new JMenu("Information");
        information.setFont(new Font("serif",Font.BOLD,20));

        //UPDATE INFO
        JMenuItem updateinfo= new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospaced",Font.PLAIN,15));
        updateinfo.addActionListener(this);
        ImageIcon updateinfoicon= new ImageIcon(ClassLoader.getSystemResource("pictures/refresh.png"));
        Image updateinfoscale= updateinfoicon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(updateinfoscale));
        information.add(updateinfo);

        //VIEW INFORMATION
        JMenuItem viewinfo= new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,15));
        viewinfo.addActionListener(this);
        ImageIcon viewinfoicon= new ImageIcon(ClassLoader.getSystemResource("pictures/information.png"));
        Image viewinfoscale= viewinfoicon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewinfo.setIcon(new ImageIcon(viewinfoscale));
        information.add(viewinfo);

        //----------------------------------------------------------------------------------------------------

        //USER MENU
        JMenu user= new JMenu("User");
        user.setFont(new Font("serif",Font.BOLD,20));


        //PAY BILL

        JMenuItem paybill= new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,15));
        paybill.addActionListener(this);
        ImageIcon paybillicon= new ImageIcon(ClassLoader.getSystemResource("pictures/bill.png"));
        Image paybills=paybillicon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybills));
        user.add(paybill);


        //BILL DETAILS
        JMenuItem billdetails= new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,15));
        billdetails.addActionListener(this);
        ImageIcon billdetailsicon= new ImageIcon(ClassLoader.getSystemResource("pictures/detail.png"));
        Image billdetailss=billdetailsicon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailss));
        user.add(billdetails);

        //---------------------------------------------------------------------------------------------------------

        //BILL SECTION

        JMenu bill= new JMenu("Bill");
        bill.setFont(new Font("serif",Font.BOLD,20));

        //GENERATE BILL

        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced",Font.PLAIN,15));
        generatebill.addActionListener(this);
        ImageIcon generatebillicon= new ImageIcon(ClassLoader.getSystemResource("pictures/detail.png"));
        Image generatescale=generatebillicon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(generatescale));
        bill.add(generatebill);

        //---------------------------------------------------------------------------------------------------------

        //UTILITY SECTION

        JMenu utility= new JMenu("Utility");
        utility.setFont(new Font("serif",Font.BOLD,20));


        //GENERATE BILL

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,15));
        notepad.addActionListener(this);
        ImageIcon notepadicon= new ImageIcon(ClassLoader.getSystemResource("pictures/notepad.png"));
        Image notepadscale=notepadicon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadscale));
        utility.add(notepad);

        //CALCULATOR

        JMenuItem calculator= new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,15));
        calculator.addActionListener(this);
        ImageIcon calculatoricon = new ImageIcon(ClassLoader.getSystemResource("pictures/calculator.png"));
        Image calculatorscale= calculatoricon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorscale));
        utility.add(calculator);

        //-----------------------------------------------------------------------------------------------------------

        //EXIT SECTION

        JMenu exit= new JMenu("Exit");
        exit.setFont(new Font("serif",Font.BOLD,20));

        //EXIT

        JMenuItem exitt = new JMenuItem("Exit");
        exitt.setFont(new Font("monospaced",Font.PLAIN,15));
        exitt.addActionListener(this);
        ImageIcon exiticon= new ImageIcon(ClassLoader.getSystemResource("pictures/exit.png"));
        Image exitscale=exiticon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        exitt.setIcon(new ImageIcon(exitscale));
        exit.add(exitt);


       if(account_type.equals("Customer")){
        menubar.add(utility);
        menubar.add(user);
        menubar.add(information);
       }
       else{
        menubar.add(menu);
       }

        menubar.add(utility);
        menubar.add(exit);

        //----------------------------------------------------------------------------------------------------------

        //for full  screen length
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new FlowLayout());
        setVisible(true);
    }

 @Override
 public void actionPerformed(ActionEvent e) {
   try{
    String message=e.getActionCommand();
    if(message.equals("New Customer")){
     new NewCustomer();
    }
    else if (message.equals("Customer details")) {
     new CustomerDetails();
    }
    else if (message.equals("Deposit Details")) {
      new DepositDetails();
    }
    else if (message.equals("Calculate Bill")) {
     new CalculateBill();
    }
    else if(message.equals("View Information")){
     new ViewInformation(metertype);
    }
    else if(message.equals("Update Information")){
     new UpdateInformation(metertype);
    }
    else if(message.equals("Exit")){
     setVisible(false);
    }
    else if(message.equals("Bill Details")){
     new BillDetails(metertype);
    }
    else if(message.equals("Calculator")){
     try{
      Runtime.getRuntime().exec("calc.exe");
     }
     catch(Exception t){
      t.printStackTrace();
     }
    }
    else if (message.equals("Notepad")) {
     try {
      Runtime.getRuntime().exec("notepad.exe");
     }
     catch (Exception t){
      t.printStackTrace();
     }
    }

    else if(message.equals("Pay Bill")){
     new PayBill(metertype);

    }

   }



   catch(Exception f){
    f.printStackTrace();

   }
 }



 public static void main(String [] args){
        new Main_Screen("","");
    }
}
