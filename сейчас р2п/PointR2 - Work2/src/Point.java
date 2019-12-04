import java.awt.*;

public class Point implements Figure {
    private R2Point p;
    public Point(R2Point p) {
        this.p = p;
        ConvexTest.window.repaint();
    }
    public double perimeter() {
        return 0.0;
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point q) {
        if (!R2Point.equal(p,q)) return new Segment(p, q);
        else return this;
    }
    public void draw(Graphics g){
        g.fillOval((int) p.x-5/2,(int) -p.y-5/2,5,5);
    }
    public void GetTr() {
        System.out.println("Круг не попал в оболочку.");
    }
}
