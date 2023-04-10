package string;

/**
 * Boolean startsWith(String s) : 判斷當前字符串是否以給定字符串s為開頭
 * Boolean   endsWith(String s) : 判斷當前字符串是否以給定字符串s為結尾
 */
public class StartsWithAndEndsWith {
    public static void main(String[] args) {
        String str = "thinking in java";

        /**
         * startsWith(String s) : 判斷當前字符串是否以給定字符串s為開頭
         */
        Boolean r1 = str.startsWith("think");//判斷str是否以think開頭
        System.out.println(r1);//true

        /**
         * endsWith(String s) : 判斷當前字符串是否以給定字符串s為結尾
         */
        Boolean r2 = str.endsWith(".png");//判斷str是否以.png結尾
        System.out.println(r2);//false

    }
}
