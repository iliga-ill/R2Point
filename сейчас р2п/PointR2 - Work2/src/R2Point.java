import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class R2Point {
    protected double x, y;
    protected double x0=10,y0=0;

    public R2Point(double x, double y) {
        this.x = x; this.y = y;
    }

    static Scanner scan = new Scanner(System.in);

    public R2Point() throws Exception {
        System.out.print("x -> ");
        x = scan.nextDouble();
        System.out.print("y -> ");
        y = scan.nextDouble();
    }

    public static double dist(R2Point a, R2Point b) {return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));}//расстояние между двумя точками
    public static double area(R2Point a, R2Point b, R2Point c) {return 0.5*((a.x-c.x)*(b.y-c.y)-(a.y-c.y)*(b.x-c.x));}
    public static boolean equal(R2Point a, R2Point b) {return a.x==b.x && a.y==b.y;}
    public static boolean isTriangle(R2Point a, R2Point b, R2Point c) {
        return area(a, b, c) != 0.0;
    }
    public boolean inside(R2Point a, R2Point b) {
        return (a.x <= x && x <= b.x || a.x >= x && x >= b.x) &&
                (a.y <= y && y <= b.y || a.y >= y && y >= b.y);
    }
    public boolean light(R2Point a, R2Point b) { //a c
        double s = area(a, b, this);//a c b
        return s < 0.0 || ( s == 0.0 && ! inside(a, b));//a c
    }

    public boolean lightR(R2Point a, R2Point b) { //a c
        double s = areaR(a, b, this);//a c b
        return s < 0.0 || ( s == 0.0 && ! inside(a, b));//a c
    }
    public static double areaR(R2Point a, R2Point b, R2Point c) {return 0.5*((a.x-c.x0)*(b.y-c.y0)-(a.y-c.y0)*(b.x-c.x0));}
}
