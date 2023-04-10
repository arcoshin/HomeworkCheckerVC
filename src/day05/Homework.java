package day05;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        /**====================
         * addition隨機加法運算器
         * ==================*/

//
//        //隨機數
//        int x, y;
//
//        //創建scanner對象及接收作答的變量
//        int user;//接收使用者作答
//        Scanner scanner = new Scanner(System.in);
//
//        int score = 0;//計分變量
//
//        for (int i = 0; i < 10; i++) {
//            //出題
//            x = new Random().nextInt(100);
//            y = new Random().nextInt(100);
//            System.out.println("第" + (i + 1) + "題" + x + "+" + y + "=?");
//
//            //答案
//            user = scanner.nextInt();//接收使用者的作答
//
//            //判題
//            if (user == x + y) {
//                System.out.println("答對了");
//                score += 10;
//            } else {
//                System.out.println("答錯了");
//            }
//        }//結束循環後統計分數
//        System.out.println("您的得分:" + score);

        /**====================
         * 九九乘法表
         * ==================*/

//        for (int i = 1; i <= 9; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(i + "x" + j + "=" + i * j + "\t");
//            }
//            System.out.println();//換行，排版用
//        }

        /**====================
         * 數組代碼練習
         * ==================*/

//        //聲明
//        int array[] = new int[10];
//
//        //初始化
//        for (int i = 0; i < array.length; i++) {
//            array[i] = new Random().nextInt(100);
//        }
//
//        //訪問
//        System.out.println("array[0] = " + array[0]);
//        System.out.println("array[1] = " + array[1]);
//        System.out.println("array[2] = " + array[2]);
//        System.out.println("array[3] = " + array[3]);
//        System.out.println("array[4] = " + array[4]);
//        System.out.println("array[5] = " + array[5]);
//        System.out.println("array[6] = " + array[6]);
//        System.out.println("array[7] = " + array[7]);
//        System.out.println("array[8] = " + array[8]);
//        System.out.println("array[9] = " + array[9]);
//
//        //遍歷
//        System.out.print("[");
//        for (int i = 0; i < array.length; i++) {
//            if (i == array.length - 1) {
//                System.out.print(array[i]);
//            } else {
//                System.out.print(array[i] + ",");
//            }
//        }
//        System.out.print("]");

        /**====================
         * MaxOfArray
         * ==================*/

//
//        //聲明
//        int arr[] = new int[10];
//
//        //初始化arr.fori
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new Random().nextInt(1000-101) + 101;//101-999
//        }
//
//        //求最大邏輯:令首位元素為參考數，遍歷元素與參考數比較，遇更大則重新賦值，遍歷完成則得最後值為所求
//        int max = arr[0];
//        for (int i = 0; i < arr.length; i++) {//arr.fori
//            if (max < arr[i]) {//若出現比參考數更大的數則走此分支
//                max = arr[i];//重新賦值
//            }
//        }
//        System.out.println("最大值為:" + max);
//        Arrays.sort(arr);//打樁語句
//        System.out.println("原數組:" + Arrays.toString(arr));//輸出檢查

        /**====================
         * 數組的升序
         * ==================*/
//
//        //聲明
//        int arr[] = new int[10];
//
//        //初始化arr.fori
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new Random().nextInt(200-101) + 101;//101-199
//        }
//
//        //調用Arrays.sort()排列(自然排列、升序)
//        Arrays.sort(arr);//僅排列無輸出功能
//        System.out.println(Arrays.toString(arr));//輸出檢查






    }
}
