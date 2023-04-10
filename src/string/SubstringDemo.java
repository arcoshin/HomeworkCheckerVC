package string;

/**
 * String substring(int begin,int end):擷取字符串中下標begin到end位置的元素，以字符串返回(含頭不含尾)
 * 如substring(3,8):表示擷取字符串中下標3~7的元素，並以一個新的字符串形式返回
 */
public class SubstringDemo {
    public static void main(String[] args) {
        //            0123456789 下標
        String str = "0123456789";

        //擷取34567
        int start = str.indexOf("3");//擷取下標含頭不含尾所以不用修正
        int end = str.lastIndexOf("7") + 1;//擷取下標含頭不含尾所以+1
        String sub = str.substring(start, end);//取下標3~7
        System.out.println(sub);//34567

        //擷取公司名(適用於雙後綴網址)
        str = "www.tedu.cn";
        start = str.indexOf(".") + 1;//從第一個"."之後開始，擷取下標含頭不含尾所以+1
        end = str.indexOf(".", start);//從第一個"."之後，開始找第一次出現的"."作為擷取的末尾元素，擷取下標含頭不含尾所以不用修正。
        System.out.println(str.substring(start, end));

    }
}