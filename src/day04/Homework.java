package day04;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        //1.
        Scanner scanner = new Scanner(System.in);
        int command = 0;
        System.out.println("請選擇功能");
        command = scanner.nextInt();
        switch (command) {
            case 1:
                System.out.println("存款業務");
                break;
            case 2:
                System.out.println("提款業務");
                break;
            case 3:
                System.out.println("查詢餘額");
                break;
            case 4:
                System.out.println("退出卡片");
                break;
            default:
                System.out.println("輸入錯誤");
        }


        //2.
        //goal:用戶要猜的目標數(0~1000)
        int goal = (int) (Math.random() * 1000 + 1);
        System.out.println(goal);
        //user:玩家猜的數字

        System.out.println("請開始猜數字...");
        int user = scanner.nextInt();

        //提示系統(使用while)
        while (user != goal) {
            if (user > goal) {
                System.out.println("你猜得太大了，再猜吧!!");
            } else {
                System.out.println("你猜得太小了，再猜吧!!");
            }
            user = scanner.nextInt();
        }
        System.out.println("恭喜你猜對了!!遊戲結束!!");

        //3.
        System.out.println("請開始猜數字...");
        user = scanner.nextInt();
        do {
            if (user > goal) {
                System.out.println("你猜得太大了，再猜一次吧!!");
            } else if (user < goal) {
                System.out.println("你猜得太小了，再猜一次吧!!");
            } else {//如果第一次就猜中就會走此分支，否則不會顯示猜對的恭喜提示程序就結束了
                break;
            }
            user = scanner.nextInt();
        } while (user != goal);
        System.out.println("恭喜你猜對了!!遊戲結束!!");

        //4.
        //透過程序計算1+2+3+.......+98+99+100的計算結果
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("sum=" + sum);

        //輸出五次"行動是成功的階梯"
        for (int i = 0; i < 5; i++) {
            System.out.println("行動是成功的階梯");
        }
        System.out.println("程序繼續執行...");

        //輸出九九乘法表
        for (int m = 1; m <= 9; m++) {
            for (int n = 1; n <= 9; n += 1) {
                System.out.println(m + "x" + n + "=" + m * n);
            }
        }
        //9的乘法表(1~9版)
        for (int i = 1; i <= 9; i++) {
            System.out.println(9 + "x" + i + "=" + 9 * i);
        }
        //9的乘法表(1/3/5/7/9)
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(9 + "x" + i + "=" + 9 * i);
        }
        //9的乘法表(9~1版)
        for (int i = 9; i > 0; i--) {
            System.out.println(9 + "x" + i + "=" + 9 * i);
        }

    }
}
