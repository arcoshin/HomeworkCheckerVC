package string;

/**
 * indexOf(String str,int n):檢索在所給字符串對象中，下標為n開始，str第一次出現的位置(n默認為0，可省略不寫為重載方法)
 * lastIndexOf(String str)  :檢索在所給字符串對象中，str最後一次出現的位置(有同上的重載方法，幾乎不使用)
 */
public class IndexOfAndLastIndexOf {
    public static void main(String[] args) {
        //            0000000000111111 下
        //            0123456789012345 標
        String str = "thinking in java";

        int index = str.indexOf("in");//檢索in在str中第一次出現的位置
        System.out.println(index);//2

        index =  str.indexOf("in", 3);//檢索從下標為3開始，in在str中第一次出現的位置
        System.out.println(index);//5

        index = str.indexOf("abc");//若字符串不存在，則返回-1
        System.out.println(index);//-1

        index = str.lastIndexOf("in");//檢索in在str中最後一次出現的位置
        System.out.println(index);//9
    }
}
