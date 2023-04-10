package stringRegex;

/**
 * String replaceAll(String regex,String s)
 * 將當前字符串中符合正則表達式regex的部分替換為字符串s並返回
 *
 * 注意 :
 * replaceAll(String regex,String s)支持正則表達式
 * 但是replace(String old,String new)不支持正則表達式
 */
public class ReplaceAllDemo {
    public static void main(String[] args) {
        String line = "TMD,你這個SB,簡直SJB";
//        String lineRegex = "[A-Z]+";
        String lineRegex = "(TMD|SB|SJB)";

        /**
         * 將符合正則表達式條件的字符串替換為XXX
         */
        String newLine = line.replaceAll(lineRegex, "XXX");

        /**
         * 常用於禁言或兒童觀賞保護系統
         */
        System.out.println(newLine);

        /**
         * 利用取代切除資源
         * String replace(String target,String replacement)
         * 將所給字符串中的所有符合字符串"target"的位置替換為字符串"replacement"並返回
         */
        String message = "abc123def123ghi123";
        String result = message.replace("123", "");//替換成空形同切除
        System.out.println(result);

        /**
         * replace(String old,String new)不支持正則表達式，但格式正確所以不會報錯
         */
        lineRegex = "(1|2|3)";
        result = message.replace(lineRegex,"");
        System.out.println(result);//無效


    }
}
