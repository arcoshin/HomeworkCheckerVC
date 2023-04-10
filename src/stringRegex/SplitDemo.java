package stringRegex;

import java.util.Arrays;

/**
 * String[] split(String regex):
 * 將當前字符串依照滿足正則表達式的部分進行分割，並將分割的結果以"字符串數組"的形式返回
 */
public class SplitDemo {
    public static void main(String[] args) {
        String line = "abc123def456ghi";
        String[] data = line.split("[0-9]+");//按照數字拆分"abc","def","ghi"三等份
        System.out.println(Arrays.toString(data));//[abc, def, ghi]

        line = ".12.456.78.16541.....0..111.............";
        /**
         * 按照"."來拆分，所以使用"."，而正則表達式中"."有特殊意義，其表示任意字元，故須以"\."轉義
         * 又JAVA中"\"本身也有特殊意義，其表示轉義，故須以"\\."再次轉義
         *
         * 如字符串中，第一個元素即是可拆分對象，則返回數組之第一個元素為空白字符串
         * 如果字符串中，出現兩續兩個以上可拆分對象，則其中也會多拆出一個空字符
         */
        data = line.split("\\.");
        System.out.println(Arrays.toString(data));//[, 12, 456, 78, 16541, , , , , 0, , 111]
        System.out.println(data.length);//12
    }
}
