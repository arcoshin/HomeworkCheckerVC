package ooday05;

/**
 * 點類
 */
public class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class GetterSetterDemo {
    public static void main(String[] args) {
        Point p = new Point();
        /**
         * 相當於
         * p.x = 1;
         * p.y = 2;
         */
        p.setX(1);
        p.setY(2);

        /**
         * 相當於
         * int x = p.x
         * int y = p.y
         * System.out.println(x,y);
         */
        int x = p.getX();
        int y = p.getY();

        System.out.println(p);
    }
}

