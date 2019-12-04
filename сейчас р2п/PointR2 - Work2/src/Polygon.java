import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Polygon extends Deq implements Figure {
    private double s, p;

    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Polygon(R2Point a, R2Point b, R2Point c) {
        pushFront(b);
        if (b.light(a, c)) {
            pushFront(a);
            pushBack(c);
        } else {
            pushFront(c);
            pushBack(a);
        }
        p = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
        }


    public double perimeter() {
        return p;
    }
    public double area() {
        return s;
    }

    public Figure add(R2Point t) {
        int i;
// Ищем освещенные ребра, просматривая их одно за другим.
        for (i=length(); i>0 && !t.light(back(),front()); i--)
            pushBack(popFront());



// УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
// либо освещенных ребер нет совсем.
        if (i>0) {
            R2Point x;
            grow(back(), front(), t);
// Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t );
            pushFront(x);
// Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);
// Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }

        for (i=0;i<4;i++){arrayR[i]=0;}
        for (int j=0;j<array.length;j++) {
        t.x0=-10;
        t.y0=0;
        if (!t.lightR(back(), front())) {arrayR[0]=arrayR[0]+1;}else{arrayR[0]=arrayR[0]-1000;}
        t.x0=0;
        t.y0=10;
        if (!t.lightR(back(), front())) {arrayR[1]=arrayR[1]+1;}else{arrayR[1]=arrayR[1]-1000;}
        t.x0=10;
        t.y0=0;
        if (!t.lightR(back(), front())) {arrayR[2]=arrayR[2]+1;}else{arrayR[2]=arrayR[2]-1000;}
        t.x0=0;
        t.y0=-10;
        if (!t.lightR(back(), front())) {arrayR[3]=arrayR[3]+1;}else{arrayR[3]=arrayR[3]-1000;}
        pushBack(popFront());
        }

        return this;
    }

    public void draw(Graphics g) {
        for (int i=0;i<array.length;i++) {
            g.fillOval((int)front().x-5/2,(int)-front().y-5/2,5,5);
            g.drawLine((int)front().x,(int)-front().y,(int) back().x,(int) -back().y);
            pushBack(popFront());
        }

    }

    public void GetTr() {
        if(GetT()){System.out.println("Круг попал в оболочку.");}
        else{System.out.println("Круг не попал в оболочку.");}
    }

}
