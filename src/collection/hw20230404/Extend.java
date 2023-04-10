package collection.hw20230404;

import java.util.*;

/**
 * 拓展作業類
 */
class Extend {
    public static void main(String[] args) {
        List<Point> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            int x = new Random().nextInt(9) + 1;//1~9
            int y = new Random().nextInt(9) + 1;//1~9
            list.add(new Point(x,y));
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getX() == o2.getX()) {
                    return o2.getY() - o1.getY();
                }
                return o2.getX() - o1.getX();
            }
        });
        System.out.println(list);



    }
    private static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

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
            return "(" + x + "," + y + ")";
        }
    }

}

