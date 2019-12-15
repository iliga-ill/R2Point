import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class UserWindow extends JFrame {
    Convex sample;
    double Circle=100;
    int E=32;

    public UserWindow(){

    }

    public UserWindow(Convex convex,int i){
        if (i==0){
        this.setSize(1200,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.sample = convex;}
    }

    @Override
    public void paint(Graphics g){
        g.clearRect(0,0,2000,2000);
        g.translate(this.getWidth()/2,this.getHeight()/2);
        g.drawLine(-this.getWidth()/2,0,this.getWidth()/2,0);
        g.drawLine(0,getHeight()/2,0,-this.getHeight()/2);
        g.drawOval((int) (0-Circle/2),(int) (0-Circle/2),(int) Circle,(int) Circle);
        sample.draw(g);
    }
    
}
