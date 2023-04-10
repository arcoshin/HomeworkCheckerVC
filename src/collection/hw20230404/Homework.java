package collection.hw20230404;


import java.util.*;

class Homework {
    public static void main(String[] args) {
        /**====================
         * List基本練習
         * ==================*/
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("list:" + list);

        /**
         * get&set
         */
        list.set(1, "XXX");
        System.out.println("list[1] = " + list.get(1));

        /**
         * remove
         */
        list.remove(1);
        System.out.println("after remove(1) list:" + list);

        /**
         * add
         */
        list.add(1, 1);
        System.out.println("after add(1) list:" + list);


        /**====================
         * List獲取子集
         * ==================*/
        List sub = list.subList(3, 7 + 1);//獲取下標3~7的元素
        System.out.println("sublist:" + sub);//[3,4,5,6,7]

        /**
         * 修改子集就是修改原集
         * 解決辦法: 1.new 2.addAll
         */
        //問題
        System.out.println("展示源集與子集連動問題");
        sub.set(0, "11");
        System.out.println("源集" + sub);//[11,4,5,6,7]
        System.out.println("子集" + list);//[0,1,2,11,4,5,6,7,8,9]

        System.out.println("聲明新集合並傳入原本的子集");
        //1).new
        List list1 = new ArrayList(sub);
        list1.set(0, "X");
        System.out.println("子集1:" + list1);//["X",4,5,6,7]
        System.out.println("源集:" + sub);//["X",4,5,6,7]

        System.out.println("聲明新集合後使用addAll將子集傳入");
        //2).addAll
        List list2 = new ArrayList();
        list2.addAll(sub);
        list2.set(1, 999);
        System.out.println("子集2:" + list2);//[999,4,5,6,7]
        System.out.println("源集:" + sub);//[999,4,5,6,7]

        /**====================
         * Collection自定義排序
         * ==================*/
        //Integer
        List<Integer> list3 = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list3.add(100-i);
        }
        Collections.sort(list3);
        System.out.println("list3：" + list3);

        //String
        List<String> list4 = new ArrayList<>();
        list4.add("one");
        list4.add("two");
        list4.add("three");
        list4.add("four");
        list4.add("five");
        list4.add("six");
        Collections.sort(list4);
        System.out.println("list4:" + list4);

        //簡易聲明一Point集合
        List<Point> list5 = new ArrayList();
        for (int i = 0; i < 10; i++) {
            int x = new Random().nextInt(99) + 1;//1~99
            int y = new Random().nextInt(99) + 1;//1~99
            list5.add(new Point(x, y));
        }
        Collections.sort(list5, ((o1, o2) -> o2.getX() - o1.getX()));
        System.out.println("list5:" + list5);

        list5.sort(((o1, o2) -> o1.getX() - o2.getX()));
        System.out.println("list5:" + list5);


        /**====================
         * Set去重
         * ==================*/
        List list6 = new ArrayList();
        list6.add("one");
        list6.add("two");
        list6.add("three");
        list6.add("four");
        list6.add("five");
        list6.add("one");
        System.out.println("list6:" + list6);

        /**
         * 使用addAll或者直接生成新集合時傳入Set集合可以實現自動去重
         */
        Set set1 = new HashSet(list4);
        System.out.println("set1:" + set1);

        Set set2 = new HashSet();
        set2.addAll(list4);
        System.out.println("set2:" + set2);



    }
    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
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

