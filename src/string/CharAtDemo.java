package string;

/**
 * char chatAt(int index)
 * 查詢在所給的字符串指定下標位置上的字符，並返回
 */
public class CharAtDemo {
    public static void main(String[] args) {
        //            0000000000111111 下
        //            0123456789012345 標
        String str = "thinking in java";
        /**
         * StringIndexOutOfBoundsException : 字符串下標越界異常
         */
        try {
            System.out.println(str.charAt(16));//StringIndexOutOfBoundsException: String index out of range: 16
        } catch (Exception e) {
        }
        /**
         * 輸出下標位置15的元素(字符)
         */
        char b = str.charAt(15);
        System.out.println(b);//a
    }
}
