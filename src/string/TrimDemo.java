package string;

/**
 * String Trim()
 * 消除字符串頭尾空白字符的方法:包含兩邊的 空白符、迴車符、換行符
 *
 * 再次體會String對象為不變對象
 * 因此任何對於字符串的修改，本質上都是創建一個新的字符串對象重新引用
 */
public class TrimDemo {
    public static void main(String[] args) {
        /**
         * 消除字符串頭尾空白字符
         */
        String tom = "                  Tom    ";
        String s1 = tom.trim();//接收修改後的新字符串對象
        System.out.println(s1);//Tom

        /**
         * 消除字符串頭尾空白字符 : 包含空白符、迴車符、換行符
         */
        String jerry = "" +
                "" +
                "" +
                "" +
                "Jerry" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "";
        System.out.println(jerry.trim());//Jerry

        /**
         * 消除字符串頭尾空白字符 : 包含空白符、迴車符、換行符
         * 但不會相除非空白字符之間的元素
         */
        String something = "   . Something ,     ";
        System.out.println(something.trim());//. Something ,
    }
}
