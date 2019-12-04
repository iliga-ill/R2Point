import java.awt.*;

public class Segment implements Figure {
    private R2Point p, q;
    public Segment(R2Point p, R2Point q) {
        this.p = p; this.q = q;
        ConvexTest.window.repaint();
    }
    public double perimeter() {
        return 2.0 * R2Point.dist(p, q);
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point r) {
        if (R2Point.isTriangle(p, q, r))
            return new Polygon(p, q, r);
        if (q.inside(p, r)) q = r;
        if (p.inside(r, q)) p = r;
            return this;
    }

    public void draw(Graphics g){
       // g.clearRect(0,0,2000,2000);
        g.fillOval((int) p.x-5/2, (int) -p.y-5/2,5,5);
        g.fillOval((int) q.x-5/2,(int) -q.y-5/2,5,5);
        g.drawLine((int) p.x, (int) -p.y, (int) q.x, (int) -q.y);
    }
    public void GetTr() {
        System.out.println("Круг не попал в оболочку.");
    }
}
