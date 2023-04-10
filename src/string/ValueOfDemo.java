package string;

/**
 * String String.valueOf()
 * 將所給變量轉變為字符串類型的方法
 */
public class ValueOfDemo {
    public static void main(String[] args) {
        /**
         * int轉String
         */
        System.out.println("int轉String=======================");
        int numInt = 123456789;
        System.out.println("numInt        = " + numInt);
        System.out.println("numInt + 1    = " + (numInt + 1));
        String numString = String.valueOf(numInt);
        System.out.println("numString + 1 = " + numString + 1 + "(拼接)");

        /**
         * double轉String
         */
        System.out.println("double轉String====================");
        double piDouble = 3.14;
        System.out.println("piDouble      = " + piDouble);
        System.out.println("piDouble + 1  = " + (piDouble + 1));
        String piString = String.valueOf(piDouble);
        System.out.println("piString + 1  = " + piString + 1 + "(拼接)");

        /**
         * String.valueOf()為將所給變量轉變為字符串類型的方法
         * 而String與任何變量加法時，結果都會變為String類型(字符串拼接)，但效率低
         */

    }
}
