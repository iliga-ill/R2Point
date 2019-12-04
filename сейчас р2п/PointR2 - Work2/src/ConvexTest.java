import java.util.Scanner;

public class ConvexTest {
    static Scanner scan= new Scanner(System.in);
    static UserWindow window;

    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();
        window = new UserWindow(convex);
        while (true) {
            convex.add(new R2Point());
            System.out.println("S = " + convex.area() + " , P = " + convex.perimeter());
            convex.GetTrue();
            window.repaint();
        }
    }
}
