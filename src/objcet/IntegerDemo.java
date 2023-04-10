package objcet;

/**
 * Integer(int的包裝類) 適用所有包裝類
 */
class IntegerDemo {
    public static void main(String[] args) {
        /**
         * 基本類型 ---打包--> 包裝類型 : 包裝類名.valueOf
         */
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(5);
        System.out.println(i1 == i2);//必定false
        System.out.println(i1.equals(i2));//true，包裝類已重寫equals()方法

        /**
         * valueOf會複用一個字節(-128~127)範圍之內的數據，所以一般建議使用valueOf聲明包裝類
         */
        Integer i3 = Integer.valueOf(5);
        Integer i4 = Integer.valueOf(5);
        System.out.println(i3 == i4);//true，實現複用
        System.out.println(i3.equals(i4));//true，包裝類已重寫equals()方法

        Integer i5 = Integer.valueOf(128);
        Integer i6 = Integer.valueOf(128);
        System.out.println(i5 == i6);//false，超出valueOf可複用範圍，故無法實現複用
        System.out.println(i5.equals(i6));//true，包裝類已重寫equals()方法

        /**
         * 包裝類型 ---拆包--> 基本類型 : 包裝類對象.基本類型+value
         */
        int j1 = i1.intValue();
        int j2 = i2.intValue();
        int j3 = i3.intValue();
        int j4 = i4.intValue();
        int j5 = i5.intValue();
        int j6 = i6.intValue();

        /**
         * Java支援自動拆裝箱 : 使用上更直觀
         */
        int num = 10;

        //自動打包------>底層邏輯: Integer k = Integer.valueOf(num);
        Integer k = num;

        //自動拆包------>底層邏輯: int l = k.intValue();
        int l = k;

        System.out.println(k);
        System.out.println(l);

        /**
         * 包類類的常用操作演示
         */

        //1.)包裝類內涵最大值最小值方法
        int intMax = Integer.MAX_VALUE;
        int intMin = Integer.MIN_VALUE;
        System.out.println("intRange = (" + intMax + "," + intMin);

        long longMax = Long.MAX_VALUE;
        long longMin = Long.MIN_VALUE;
        System.out.println("longRange = (" + longMax + "," + longMin);

        double doubleMax = Double.MAX_VALUE;
        double doubleMin = Double.MIN_VALUE;
        System.out.println("doubleRange = (" + doubleMax + "," + doubleMin);

        //2.)包裝類可以將字符串轉換為對應的基本類型------特別常用，需重點掌握
        String num1 = "39";
        int n1 = Integer.parseInt(num1);//String ------> int(不同於valueOf: Object ------> 包裝類型)
        System.out.println(n1);

        String num2 = "3.1415926";
        double n2 = Double.parseDouble(num2);//String ------> double(不同於valueOf: Object ------> 包裝類型)
        System.out.println(n2);


    }
}
