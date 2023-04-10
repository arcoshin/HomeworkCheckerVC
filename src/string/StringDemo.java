package string;

/**
 * String字符串類型演示類
 */
public class StringDemo {
    final static String sss5 = "123";
    public static void main(String[] args) {
        /**
         * 若使用直接量、字面量聲明String對象時，系統會自動去常量池比對
         * 1).若無，則創建一個字符串對象，並於常量池中產生引用(常量池成可理解為地址列表)
         * 2).若有，則直引用至該對象不再生成新對象，實現資源複用
         *
         * String的賦值，本質上就是在堆中創建新對象重新引用
         * 而最後堆中未被引用的資源，將被JAVA自帶的GC清除(GC可理解為垃圾回收員)
         *
         * 備註:
         * 基本類型中的"=="，比較的是對象中所存的值(直接量)
         * 引用類型中的"=="，比較的是對象的內存地址
         */
        String s1 = "ABC";//堆中創建一個"ABC"字符串對象
        String s2 = "ABC";//常量池中有相當資源，直接引用至對中該對象
        String s3 = "ABC";//常量池中有相當資源，直接引用至對中該對象

        System.out.println(s1 == s2);//實現資源複用
        System.out.println(s1 == s3);//實現資源複用
        System.out.println(s2 == s3);//實現資源複用

        s1 = s1 + "!";
        System.out.println(s1 == s2); //false，s1已重新引用至堆中新創的對象("ABC!")

        /**======
         * 面試題
         =======*/
        /**
         * """在編譯期"""時，若發現是兩個字面量拼相連，會直接拼接好再傳入常量值中查詢
         * 只有"""字面量"""相連才會有此情形，"""變量不會"""
         * 此為系統規定，能真正有效節省資源
         */

        String sss1 = "123abc";
        /**
         * 直接量拼接String
         */
        String sss2 = "123" + "abc";
        System.out.println(sss1 == sss2);//true

        /**
         * 變量拼接String
         * 此時變量在編譯期不會實現預先拼接
         * sss4的地址為sss3+"abc"在堆中所生成的新對象地址
         * 所以sss1與sss4的地址必然不同
         */
        String sss3 = "123";
        String sss4 = sss3 + "abc";
        System.out.println(sss1 == sss4);//false


        /**
         * 常量拼接String
         * 常量可以理解為在編譯期就會直接替換為字面量、直接量
         * 因此傳入常量池的值依然是拼接後的值("123abc")
         * 故而可知實現複用，引用該對象地址
         */
//        final static String sss5 = "123";//已在類中聲明，此為提醒
        String sss6 = sss5 + "abc";
        System.out.println(sss1 == sss6);//true

        /**
         * 很常見的面試題:
         * String s = new String("hello");
         * 請問如上語句，總共創建了幾個對象?
         * 答 兩個
         */

        /**
         * 解析:
         * 此時堆中會產生:
         * 第一個對象為 "hello" 的字面量String對象......r1
         * 第二個對象為 "new String()" 對象............r2
         * 而 s 會引用至 r2(s存的是r2的地址)
         *
         * 補充:
         * 可以發現使用題目的方式聲明變量，new String的部分是灰色的---無意義代碼
         */

        String s = new String("hello");

       /**
         * 延伸:
         * 若此時再聲明String r3 = "hello";
         * 則根據傳入常量池的值，直接引用r1
         */
        String r3 = "hello";

        /**
         * 比較:
         * 1.)使用"==" : 比較基本類型變量的數值 或者 "引用類型的對象地址"
         * 1.)使用".equal" : "引用類型變量的內容"
         * 可發現即使字面量相同，但存的是不同地址，意即代表引用到不同的字符串對象
         */
        System.out.println(s == r3);//false，不同地址表示不同對象
        System.out.println(s.equals(r3));//true，兩個String對象中所儲存的內容相通(字面量相同)



    }

}
