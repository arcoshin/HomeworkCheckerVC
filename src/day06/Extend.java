package day06;

import java.util.Arrays;
import java.util.Random;

public class Extend {
    /**
     * 數組產生器
     */
    private static int[] arrayCreator(int length, int max, int min) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(max - min + 1) + min;
        }
        return arr;
    }

    /**
     * 用於獲取數組的最大值並返回
     */
    private static int getMaxOfArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 用於輸出數組中每一個元素
     */
    private static void printArrayData(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }



    public static void main(String[] args) {
        //生成一測試用數組對象
        int[] arr = arrayCreator(15,99,0);

        //測試getMaxOfArray
        int maxOfArray = getMaxOfArray(arr);
        System.out.println("最大值: " + maxOfArray);

        //測試printArrayData
        printArrayData(arr);

        /**
         * 跨包調用test
         */
        Homework.test1();//OK，類/類中靜態方法直接調用
        Homework homework = new Homework();
        homework.test2();//OK，普通方法需生成實例對象，以對象來決定可以訪問哪些屬性與方法
    }
}
