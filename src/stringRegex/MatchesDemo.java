package stringRegex;

/**
 * boolean Matches(String regex):
 * 驗證當前給定字符串是否符合正則表達式regex
 */
public class MatchesDemo {
    public static void main(String[] args) {
        /**
         * 信箱正則表達式:
         * [a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-z]+)+
         */

        String email = "1ar2co3sh4in@gmail.com.tw";
        /**
         * 注意
         * \.中的"\"是正則表達式中的轉義字符
         * \\.中的第一個"\"則是JAVA系統中的轉義字符
         */
        String mailRegex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-z]+)+";

        boolean matches = email.matches(mailRegex);

        if (matches) {
            System.out.println("信箱格式正確");
        } else {
            System.out.println("輸入格式錯誤");
        }

    }
}
