package string;

/**
 * String toUpperCase() : 將字符串中的字母全部改為大寫
 * String toLowerCase() : 將字符串中的字母全部改為小寫
 */
public class ToUpperAndLowerCase {
    public static void main(String[] args) {
        String text = "I am practicing JAVA";

        /**
         * 全大寫 : ToUpperCase
         */
        String upper = text.toUpperCase();
        System.out.println(upper);//I AM PRACTICING JAVA

        /**
         * 全小寫 : ToLowerCase
         */
        String lower = text.toLowerCase();
        System.out.println(lower);//i am practicing java
    }
}
