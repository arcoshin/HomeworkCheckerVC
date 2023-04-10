package string;

/**
 * int length();
 * 獲取數組長度的方法
 */
public class LengthDemo {
    public static void main(String[] args) {
        String str = "JAVA !";
        int length = str.length();//獲取str數組的長度
        System.out.println(length);//6，空格也算
    }
}
