package string;

/**
 * StringBuilder類 : 適合頻繁編輯的String工具，改善頻繁增刪對象的過程
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        //StringBuilder創建方式
        StringBuilder b1 = new StringBuilder();//目前為空字符串
        StringBuilder b2 = new StringBuilder("abc");//b2為"abc"字符串

        //String 與 StringBuilder 互轉
        String str1 = "abc";
        StringBuilder b3 = new StringBuilder(str1);//b3為"abc"字符串
        String str2 = b3.toString();//StringBuilder轉換為String的方法
        System.out.println(str2);

        String str = "好好學習Java";
        //String -> StringBuilder : 利於頻繁修改
        StringBuilder builder = new StringBuilder(str);

        /**
         * 優點 : builder為可變字符串，故不用重新賦值回builder
         */

        /**
         * append()追加內容，從末尾開始
         */
        builder.append("，為了找份好工作!");
        System.out.println(builder);//好好學習Java，為了找份好工作!
        //                            0.00.0.00000.01.11.1.11.1 下
        //                            0.12.3.45678.90.12.3.45.6 標

        /**
         * replace(int start,int end,String str)替換指定位置的內容
         */
        builder.replace(9, 16, "就是為了改變世界");//下標一樣含頭不含尾(實際取代9~15)
        System.out.println(builder);//好好學習Java，就是為了改變世界!
        //                            0.00.0.00000.01.11.1.11.11 下
        //                            0.12.3.45678.90.12.3.45.67 標

        /**
         * delete(int start,int end)刪除指定位置的內容
         */
        builder.delete(0,8);//下標一樣含頭不含尾(實際刪除0~7)
        System.out.println(builder);//，就是為了改變世界!
        //                            0.0 0.00.00.00.0 下
        //                            0.1 2.34.56.78.9 標

        /**
         * insert(int start,String str)從指定位置插入內容
         */
        builder.insert(0,"活著");
        System.out.println(builder);//活著，就是為了改變世界

    }
}
