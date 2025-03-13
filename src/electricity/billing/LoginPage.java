package electricity.billing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {
    JTextField passwordtf,usertf;

    Choice logginch;

    JButton loginButton, signupButton, cancelButton;


    LoginPage(){
        // for setting the title
        super("Login");
        //for background colour
        getContentPane().setBackground(Color.GRAY);


        // for writing the text fields jlabel is used.
        JLabel username= new JLabel("Username :");
        // for setting its position in the frame set bounds function is used.
        username.setBounds(300,60,100,20);
        //for adding
        add(username);
        // username textfield
        usertf= new JTextField();
        usertf.setBounds(400,61,150,20);
        add(usertf);



        // for password
        JLabel password= new JLabel("Password :");
        password.setBounds(300,100,100,20);
        add(password);
        //password textfields
        passwordtf= new JTextField();
        passwordtf.setBounds(400,101,150,20);
        add(passwordtf);




        //for login
        JLabel loggin=new JLabel("Loggin in as :");
        loggin.setBounds(300,140,100,20);
        add(loggin);
        // dropdown for loggin
        logginch=new Choice();
        //for dropdown fields
        logginch.add("Admin");
        logginch.add("Customer");
        logginch.setBounds(400,141,150,20);
        add(logginch);


        //login button
        loginButton=new JButton("Login");
        loginButton.setBounds(341,181,70,20);
        //for performing actions with the buttons
        loginButton.addActionListener(this);
        add(loginButton);


        //cancel button
        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(444,181,90,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        //signup button
        signupButton=new JButton("Signup");
        signupButton.setBounds(385,221,90,20);

        signupButton.addActionListener(this);
        add(signupButton);


        // profile picture

        ImageIcon profile=new ImageIcon(ClassLoader.getSystemResource("pictures/profile.png"));
        Image scale= profile.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon profile1=new ImageIcon(scale);
        JLabel p1=  new JLabel(profile1);
        p1.setBounds(4,4,250,250);
        add(p1);



        // every frame has a default border layout setting it to null disables default layout
        setLayout(null);
        setLocation(400,200);
        setSize(640,300);
        setVisible(true);
    }

// this functiion will catch the object thowrn by button
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton){
            String uname=usertf.getText();
            String passwo= passwordtf.getText();
            String nm= logginch.getSelectedItem();

            try{
                DataBase c= new DataBase();
                String query= "select * from signup where username = '"+uname+"' and password = '"+passwo+"' and usertype = '"+nm+"' ";
                ResultSet s=c.statement.executeQuery(query);

                if(s.next()){
                    String meter= s.getString("meter_no");
                    setVisible(false);
                    new Main_Screen(nm,meter);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                }
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==cancelButton){
            setVisible(false);

        }
        else if(e.getSource()==signupButton){
            setVisible(false);
            new SignUpPage();
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
