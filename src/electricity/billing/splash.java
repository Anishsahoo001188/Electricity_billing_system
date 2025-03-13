package electricity.billing;

import javax.swing.*;
import java.awt.*;

public class splash  extends JFrame {
    splash(){
        //adding image to the frame
        ImageIcon ig=new ImageIcon(ClassLoader.getSystemResource("pictures/Splash.jpg"));
        // scaling a image
        Image image1= ig.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon ig2= new ImageIcon(image1);
        JLabel il= new JLabel(ig2);
        add(il);

        //setting size, frame visibility, frame locations
        setSize(600,400);
        setVisible(true);
        setLocation(500,200);

        try{
            Thread.sleep(3000);
            setVisible(false);
            new LoginPage();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new splash();
    }
}
