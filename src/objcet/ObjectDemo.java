package objcet;

/**
 * 萬類之祖 :　Object是所有類的頂級父類(直接或間接繼承)
 * 或者說------萬類皆對象(為了多態)
 * <p>
 * ===>Object類中定義的方法可以在任何類中使用<===但是，基本類型不是類!!
 */
class ObjectDemo {
    public static void main(String[] args) {
        /**
         * 每個類最少都會有"本身"或者"Object"兩種類型的多態
         */
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

        /**
         *
         * Object.toString()
         *
         * 當我們輸出引用變量時，JAVA會默認調用Object.toString()方法
         * 而該方法會返回對象的"HashCode"值(可以簡單理解為內存地址)
         * 但這個值對我們開發軟件而言，其實並沒有太多意義
         * 我們真正想輸出的是該變量的屬性值
         * 因此我們常常需要重寫toString()來返回具體的屬性值
         */
        System.out.println(c3);//objcet.Coo@1b6d3586
        System.out.println(a3);//objcet.Coo@4554617c
        System.out.println(b3);//objcet.Coo@74a14482
        System.out.println(l3);//objcet.Coo@1540e19d
        System.out.println(o3);//objcet.Coo@677327b6

        /**
         * String類 & StringBuilder類，其實本身已經重寫過toString()方法
         */
        String string = "Hello";
        System.out.println("string = " + string);//直接輸出
        StringBuilder builder = new StringBuilder(string);
        System.out.println("builder = " + builder);//直接輸出

        /**
         *
         * Object.equals()
         *
         * 當我們調用Object.equals()方法時，內部還是在比較地址(內部使用的還是"==")，並沒有參考意義
         * 因此若想比較對象的屬性值，我們認為Object.equals()並不能滿足需求
         * 因此常常也會重寫equals()方法來比較屬性值
         */
        Point p1 = new Point();
        Point p2 = new Point();
        System.out.println("p1 == p2 ? " + (p1 == p2));//false
        System.out.println("p1.equals(p2) ? " + p1.equals(p2));//重寫後比較的是屬性值true

        /**
         * String類其實本身已經重寫過equals()方法
         * 但StringBuilder類沒有!
         */
        String string1 = new String("123456789");
        String string2 = new String("123456789");
        System.out.println("string1 == string2 ? " + (string1 == string2));//false，已知兩者內存地址必不相同(new)
        System.out.println("string1.equals(string2) ? " + string1.equals(string2));//String類已經重寫equals()方法

        StringBuilder builder1 = new StringBuilder(string);
        StringBuilder builder2 = new StringBuilder(string);
        System.out.println("builder1 == builder2 ? " + (builder1 == builder2));//false，已知兩者內存地址必不相同(new)
        System.out.println("builder1.equals(builder2) ? " + builder1.equals(builder2));//StringBuilder類沒有重寫equals()方法



    }

}

class Aoo {

}

class Boo extends Aoo {

}

class Coo extends Boo implements Loo {

}

interface Loo {

}