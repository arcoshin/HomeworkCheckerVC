package day05;

import java.util.Arrays;
import java.util.Random;

public class Extend {
    public static void main(String[] args) {
        //計算1-100偶數和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("1-100偶數和 = " + sum);

        //計算8!
        int ans = 1;
        for (int i = 1; i <= 8; i++) {
            ans *= i;
        }
        System.out.println("8! = " + ans);

        //輸出指定直角三角形(1,3,5,7,9,11個*)
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //聲明包含十個數之數組，範圍自訂，求最大與最小自動輸出
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);//1-99
        }
        Arrays.sort(arr);//升序
        System.out.println("範圍:" + Arrays.toString(arr));
        System.out.println("最大值 = " + arr[arr.length - 1]);
        System.out.println("最小值 = " + arr[0]);

    }
}
