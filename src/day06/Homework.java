package day06;


import java.util.Arrays;
import java.util.Random;

public class Homework {
    /**
     * Test
     */
    public static void test1() {
        System.out.println("test1 OK!");
    }
    public void test2() {
        System.out.println("test2 OK!");
    }

    public static void main(String[] args) {
        System.out.println("=================");
        System.out.println("1.MaxOfArray");
        System.out.println("=================");
        //產生一數組，隨機生成十個0~99之間的數字
        int[] Array = new int[10];
        for (int i = 0; i < Array.length; i++) {
            Array[i] = new Random().nextInt(100);
        }
        //求最大邏輯:假設首位元素為最大，並遍歷數組與其餘元素分別比較。若遇更大者，重新賦值給最大值對象
        int max = Array[0];//假設首位元素為最大
        for (int i = 1; i < Array.length; i++) {//不需跟自己比較，故起始下標為1
            if (max < Array[i]) {//若遇到更大的數則走此分支
                max = Array[i];//遇更大則重新賦值
            }
        }//循環結束後
        System.out.println("最大值 : " + max);//尋找紀錄中最大值
        Arrays.sort(Array);//自然排序以便後續驗算
        System.out.println("檢驗" + Arrays.toString(Array));

        System.out.println("=================");
        System.out.println("2.自定義方法調用區");
        System.out.println("=================");

        say();//調用
        say("XJX");//調用
        say("XJX",29);//調用

        double pi = getPi();//調用
        System.out.println("pi = " + pi);//輸出檢驗

        int plus = plus(43, 57);//調用
        System.out.println("plus = " + plus);//輸出檢驗

        int[] array = generateArray(17, 1000);//調用
        System.out.println("array: " + Arrays.toString(array));//輸出檢驗
    }
    /**===========================================================
     * 定義say()無參無返回值方法，調用測試
     * 定義say()有一個參無返回值方法，調用測試
     * 定義say()有兩個參無返回值的方法，調用測試
     * 定義getNum()無參有返回值方法，演示return的用法，調用測試
     * 定義plus()兩個參有返回值方法，調用測試
     * 定義generateArray()用於生成整型數組填充隨機數並返回數組，調用測試
     * ==========================================================*/
    /**
     * 定義say()無參無返回值方法，調用測試
     */
    private static void say() {
        System.out.println("Hi!");
    }

    /**
     * 定義say()有一個參無返回值方法，調用測試
     */
    private static void say(String name) {
        System.out.println("Hi! I'm " + name);
    }

    /**
     * 定義say()有兩個參無返回值的方法，調用測試
     */
    private static void say(String name, int age) {
        System.out.println("Hi! I'm " + name + ",I am " + age + " years old");
    }

    /**
     * 定義getNum()無參有返回值方法，演示return的用法，調用測試
     */
    private static double getPi() {
        return 3.14;
    }

    /**
     * 定義plus()兩個參有返回值方法，調用測試
     */
    private static int plus(int a, int b) {
        return a + b;
    }
    /**
     * 定義generateArray()用於生成整型數組填充隨機數並返回數組，調用測試
     */

    private static int[] generateArray(int length,int max) {
        int[] array = new int[length];//自定義長度
        for (int i = 0; i < array.length; i++) {//Array.fori
            array[i] = new Random().nextInt(max);//bound不含所寫
        }
        return array;//返回成品Array數組
    }

}
