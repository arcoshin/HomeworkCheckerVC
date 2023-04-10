package stringRegex;

import java.util.Arrays;
import java.util.Objects;

class Homework {
    public static void main(String[] args) {
        /**=======================
         * String_regex_matches()
         * =====================*/
        String email = "1ar2co3sh4in@gmail.com.tw";
        String mailRegex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-z]+)+";

        boolean matches = email.matches(mailRegex);

        if (matches) {
            System.out.println("信箱格式正確");
        } else {
            System.out.println("輸入格式錯誤");
        }

        /**==========================
         * String_regex_replaceAll()
         * ========================*/
        String line = "TMD,你這個SB,簡直SJB";
        String lineRegex = "(TMD|SB|SJB)";
        String newLine = line.replaceAll(lineRegex, "XXX");
        System.out.println(newLine);

        String message = "abc123def123ghi123";
        String result = message.replace("123", "");//替換成空形同切除
        System.out.println(result);

        lineRegex = "(1|2|3)";
        result = message.replace(lineRegex,"");
        System.out.println(result);//無效

        /**=====================
         * String_regex_split()
         * ===================*/
        String lines = "abc123def456ghi";
        String[] data = lines.split("[0-9]+");//按照數字拆分"abc","def","ghi"三等份
        System.out.println(Arrays.toString(data));//[abc, def, ghi]

        line = ".12.456.78.16541.....0..111.............";
        data = line.split("\\.");
        System.out.println(Arrays.toString(data));//[, 12, 456, 78, 16541, , , , , 0, , 111]
        System.out.println(data.length);//12


        /**====================
         * object
         * ==================*/
        //每個類最少都會有"本身"或者"Object"兩種類型的多態

        Aoo a1 = new Aoo();
        Object o1 = new Aoo();

        Boo b2 = new Boo();
        Object o2 = new Boo();
        Aoo a2 = new Boo();

        Coo c3 = new Coo();
        Object o3 = new Coo();
        Aoo a3 = new Coo();
        Boo b3 = new Coo();
        Loo l3 = new Coo();

        System.out.println(c3);//objcet.Coo@1b6d3586
        System.out.println(a3);//objcet.Coo@4554617c
        System.out.println(b3);//objcet.Coo@74a14482
        System.out.println(l3);//objcet.Coo@1540e19d
        System.out.println(o3);//objcet.Coo@677327b6

        String string = "Hello";
        System.out.println("string = " + string);//直接輸出
        StringBuilder builder = new StringBuilder(string);
        System.out.println("builder = " + builder);//直接輸出

        Point p1 = new Point();
        Point p2 = new Point();
        System.out.println("p1 == p2 ? " + (p1 == p2));//false
        System.out.println("p1.equals(p2) ? " + p1.equals(p2));//重寫後比較的是屬性值true

        String string1 = new String("123456789");
        String string2 = new String("123456789");
        System.out.println("string1 == string2 ? " + (string1 == string2));//false，已知兩者內存地址必不相同(new)
        System.out.println("string1.equals(string2) ? " + string1.equals(string2));//String類已經重寫equals()方法

        StringBuilder builder1 = new StringBuilder(string);
        StringBuilder builder2 = new StringBuilder(string);
        System.out.println("builder1 == builder2 ? " + (builder1 == builder2));//false，已知兩者內存地址必不相同(new)
        System.out.println("builder1.equals(builder2) ? " + builder1.equals(builder2));//StringBuilder類沒有重寫equals()方法



        /**====================
         * 包裝類
         * ==================*/
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(5);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        Integer i3 = Integer.valueOf(5);
        Integer i4 = Integer.valueOf(5);
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));

        Integer i5 = Integer.valueOf(128);
        Integer i6 = Integer.valueOf(128);
        System.out.println(i5 == i6);
        System.out.println(i5.equals(i6));

        int j1 = i1.intValue();
        int j2 = i2.intValue();
        int j3 = i3.intValue();
        int j4 = i4.intValue();
        int j5 = i5.intValue();
        int j6 = i6.intValue();


        int num = 10;

        //自動打包------>底層邏輯: Integer k = Integer.valueOf(num);
        Integer k = num;
        //自動拆包------>底層邏輯: int l = k.intValue();
        int l = k;

        System.out.println(k);
        System.out.println(l);

        //1.)包裝類內涵最大值最小值方法
        int intMax = Integer.MAX_VALUE;
        int intMin = Integer.MIN_VALUE;
        System.out.println("intRange = (" + intMax + "," + intMin);

        long longMax = Long.MAX_VALUE;
        long longMin = Long.MIN_VALUE;
        System.out.println("longRange = (" + longMax + "," + longMin);

        double doubleMax = Double.MAX_VALUE;
        double doubleMin = Double.MIN_VALUE;
        System.out.println("doubleRange = (" + doubleMax + "," + doubleMin);

        //2.)包裝類可以將字符串轉換為對應的基本類型------特別常用，需重點掌握
        String num1 = "39";
        int n1 = Integer.parseInt(num1);
        System.out.println(n1);

        String num2 = "3.1415926";
        double n2 = Double.parseDouble(num2);
        System.out.println(n2);

    }

    /**
     * 點類
     */
    private static class Point {
        private int x;
        private int y;

        public Point() {
        }

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
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }


    }


    /**
     * 萬類之祖 :　Object是所有類的頂級父類(直接或間接繼承)
     */
    private class ObjectDemo {

    }

    static class Aoo {

    }

    static class Boo extends Aoo {

    }

    static class Coo extends Boo implements Loo {

    }

    interface Loo {

    }

}
