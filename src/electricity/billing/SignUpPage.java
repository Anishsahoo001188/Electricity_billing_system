package electricity.billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class SignUpPage extends JFrame implements ActionListener {
    JTextField employid,un ,nametf, passwordtf, metertf;
    Choice atf;
    JButton create ,back;


    SignUpPage(){
        super("signup");
        getContentPane().setBackground(Color.lightGray);




        JLabel at= new JLabel("Create Account");
        at.setBounds(1,0,100,20);
        add(at);

        //create account type
        JLabel accounttype= new JLabel("Create Account As :");
        accounttype.setBounds(30,50,120,20);
        add(accounttype);
        atf=new Choice();
        atf.add("Enter your choice");
        atf.add("Admin");
        atf.add("Customer");
        atf.setBounds(150,51,150,20);
        add(atf);


        //employer id
        JLabel empid= new JLabel("Employer ID :");
        empid.setBounds(30,90,100,20);

        add(empid);
        employid=new JTextField();
        employid.setBounds(150,91,150,20);
        empid.setVisible(true);
        employid.setVisible(true);
        add(employid);

        //METER NUMBER
        JLabel meterno=new JLabel("Meter No :");
        meterno.setBounds(30,90,100,20);
        add(meterno);
        meterno.setVisible(false);
        metertf=new JTextField();
        metertf.setBounds(150,91,150,20);
        add(metertf);
        metertf.setVisible(false);



        //username
        JLabel username= new JLabel("UserName :");
        username.setBounds(30,130,100,20);
        add(username);
        un=new JTextField();
        un.setBounds(150,131,150,20);
        add(un);


        //NAME
        JLabel name=new JLabel("Name :");
        name.setBounds(30,170,100,20);
        add(name);
        nametf=new JTextField("");
        nametf.setBounds(150,171,150,20);
        add(nametf);

        //focus listener for automaatically enter the name after meter num is entered.

        nametf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try{
                    DataBase d = new DataBase();
                    ResultSet result = d.statement.executeQuery("select * from signup where meter_no = '"+metertf.getText()+"' ");
                    if(result.next()){
                        nametf.setText(result.getString("name"));
                    }
                }
                catch(Exception f){
                    f.printStackTrace();
                }
            }
        });


        //PASSWORD

        JLabel pass=new JLabel("Password :");
        pass.setBounds(30,210,100,20);
        add(pass);
        passwordtf=new JTextField();
        passwordtf.setBounds(150,211,150,20);
        add(passwordtf);


        //CREATE BUTTON

        create=new JButton("Create");
        create.setBounds(75,270,80,20);
        create.setBackground(new Color(218, 176, 73));
        create.addActionListener(this);
        add(create);

        //BACK

        back=new JButton("Back");
        back.setBounds(200,270,80,20);
        back.setBackground(new Color(218, 176, 73));
        back.addActionListener(this);
        add(back);


        //IMAGE

        ImageIcon profile=new ImageIcon(ClassLoader.getSystemResource("pictures/boy.png"));
        Image ig1= profile.getImage().getScaledInstance(250,240,Image.SCALE_DEFAULT);
        ImageIcon profile2= new ImageIcon(ig1);
        JLabel i1= new JLabel(profile2);
        i1.setBounds(330,40,250,250);
        add(i1);

        //EVENT LISTENER FOR SETTING THE VISIBILITY OF THE EMPLOY AND METER NO
        atf.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user=atf.getSelectedItem();
                if(user.equals("Customer")){
                    meterno.setVisible(true);
                    nametf.setEditable(false);
                    metertf.setVisible(true);
                    empid.setVisible(false);
                    employid.setVisible(false);
                } else if (user.equals("Admin")) {
                    meterno.setVisible(false);
                    metertf.setVisible(false);
                    empid.setVisible(true);
                    employid.setVisible(true);
                }
            }
        });

        setLayout(null);
        setLocation(500,200);
        setSize(600,380);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create){
            String alog=atf.getSelectedItem();
            String uname=un.getText();
            String name=nametf.getText();
            String password= passwordtf.getText();
            String meter=metertf.getText();
            try{
                DataBase c= new DataBase();
                String query =null;
                if(alog.equals("Admin")) {
                    query = "insert into signup value ('"+meter+"','"+uname+"','"+name+"','"+ password+"','"+alog+"') ";
                }
                else{
                    query="update signup set username = '"+uname+"' , password = '"+password+"', usertype = '"+alog+"' where meter_no ='"+meter+"' ";
                }
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created");
                setVisible(false);
                new LoginPage();
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==back){
            setVisible(false);
            new LoginPage();
        }
    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
