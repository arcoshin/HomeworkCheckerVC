package day00ForWeekendHomework.homework20230325;


import java.util.*;

public class Homework {
    public static void main(String[] args) {
        /**====================
         * 1.CommandBySwitch
         * ==================*/
//        System.out.println("請選擇付款方式: 1.現金 2.信用卡 3.ATM轉帳 4.掃碼繳費 5.電信帳單");
//        int type = new Scanner(System.in).nextInt();
//        switch (type) {
//            case 1:
//                System.out.println("您已選擇現金付款，煩請十鐘內至專用繳費機繳費");
//                break;
//            case 2:
//                System.out.println("您已選擇信用卡付款......");
//                break;
//            case 3:
//                System.out.println("您已選擇ATM轉帳付款......");
//                break;
//            case 4:
//                System.out.println("您已選擇掃碼繳費......");
//                break;
//            case 5:
//                System.out.println("您已選擇合併電信帳單繳費......");
//                break;
//            default:
//                throw new RuntimeException("輸入錯誤，請重新進入頁面");
//        }

        /**====================
         * 2.Guessing
         * ==================*/
//        System.out.println("來玩猜數字吧!!1~100請猜吧");
//        int goal = new Random().nextInt(100 - 1 + 1) + 1;//1~100
//        while (true) {
//            int user = new Scanner(System.in).nextInt();
//            if (user > goal) {
//                System.out.println("猜太大了!!");
//            } else if (user < goal) {
//                System.out.println("猜太小了!!");
//            } else {
//                System.out.println("恭喜猜中了!!");
//                return;
//            }
//        }

        /**====================
         * 3.求1~100數字和
         * ==================*/
//        int sum = 0;
//        for (int i = 0; i < 101; i++) {//101.fori
//            sum += i;
//        }
//        System.out.println("1~100數字和 = " + sum);

        /**====================
         * 4.Addition
         * ==================*/
//        System.out.println("隨機生成十題加法測驗，請作答，每題十分");
//        int score = 0;
//        for (int i = 0; i < 10; i++) {
//            int x = new Random().nextInt(100 - 1 + 1) + 1;//1~100
//            int y = new Random().nextInt(100 - 1 + 1) + 1;//1~100
//            System.out.println("(" + (x + y) + ")");
//            System.out.println(x + "+" + y + "=?");
//
//            int user = new Scanner(System.in).nextInt();
//            if (user == x + y) {
//                System.out.println("答對了!");
//                score += 10;
//            } else {
//                System.out.println("答錯了!");
//            }
//        }
//        System.out.println("測驗結束，您本次測驗得分為:" + score + "分");

        /**====================
         * 5.九九乘法表
         * ==================*/
//        for (int y = 1; y <= 9; y++) {
//            for (int x = 1; x <= y; x++) {
//                System.out.print(x + "x" + y + "=" + x * y + "\t");
//            }
//            System.out.println();
//        }
//
        /**====================
         * 6.MaxOfArray
         * ==================*/
//        int[] arr = new int[10];//隨機生成數值
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new Random().nextInt(100 - 1 + 1) + 1;//1~100隨機賦值
//        }
//        Arrays.sort(arr);//自然排列
//        int max = arr[arr.length - 1];//自然排列最末位為最大
//
//        //擴容
//        arr = Arrays.copyOf(arr, arr.length + 1);//擴容:數組最末位補一默認值
//        arr[arr.length - 1] = max;//將最大值賦值給最末元素
//        //輸出打印
//        System.out.println(Arrays.toString(arr));

        /**====================
         * 7.生成N位驗證碼
         * ==================*/
//
//        //嘗試本方法內直接處理問題
//        System.out.println("請輸入要隨機生成多少位數的驗證碼?(N=?)");
//        int length = new Scanner(System.in).nextInt();
//        String code = "";
//        int index;
//        for (int i = 0; i < length; i++) {//length.fori
//            int chance = new Random().nextInt(3 - 1 + 1) + 1;//1~3
//            switch (chance) {//走哪個分支全憑隨機
//                case 1://生成數字，拼接給驗證碼
//                    index = new Random().nextInt(57 - 48 + 1) + 48;//48~57
//                    code += (char)index;//0~9
//                    break;
//                case 2://生成大寫字母，拼接給驗證碼
//                    index = new Random().nextInt(90 - 65 + 1) + 65;//65~90
//                    code += (char)index;//A~Z
//                    break;
//                case 3://生成小寫字母，拼接給驗證碼
//                    index = new Random().nextInt(122 - 97 + 1) + 97;//97~122
//                    code += (char)index;//a~z
//                    break;
//            }
//        }//循環次數等於驗證碼長度
//        System.out.println(code);
        /**====================
         * 8.求2~100所有素數
         * ==================*/
//        Collection<Integer> c = new ArrayList();//容器
//        for (int num = 2; num <= 100; num++) {
//            boolean result = true;//假設所有數都是素數
//            for (int i = 2; i <= (num / 2); i++) {
//                if (num % i == 0) {//被整除則必非素數
//                    result = false;
//                    break;//後續也沒有繼續檢驗剩餘元素的必要了
//                }
//            }
//            if (result) {//通過遍歷仍保持true則必為素數
//                c.add(num);//存入容器
//            }
//        }//所有數都檢驗完時
//        System.out.println("2~100包含的素數有" + c + "，共有" + c.size() + "個");

        /**====================
         * 9.機票打折系統
         * ==================*/
//        System.out.println("請輸入原始票價");
//        double price = new Scanner(System.in).nextDouble();
//        if (price <= 0) {
//            System.out.println("票價輸入錯誤，請重新開始");
//            return;
//        }
//
//        System.out.println("請輸入出行月份");
//        int month = new Scanner(System.in).nextInt();
//        if (month < 1 || month > 12) {
//            System.out.println("月份輸入錯誤，請重新開始");
//            return;
//        }
//
//        System.out.println("請輸入座位艙等: 1.頭等艙 2.商務艙 3.經濟艙");
//        int level = new Scanner(System.in).nextInt();
//        if (level < 1 || level > 3) {
//            System.out.println("艙等輸入錯誤，請重新開始");
//            return;
//        }
//
//        /**
//         * 優惠判斷
//         */
//        switch (level) {
//            case 1://頭等艙
//                if (5 <= month && month <= 10) {//旺季
//                    price *= 0.9;
//                } else {//淡季
//                    price *= 0.7;
//                }
//                break;
//            case 2://商務艙
//                if (5 <= month && month <= 10) {//旺季
//                    price *= 0.85;
//                } else {//淡季
//                    price *= 0.65;
//                }
//                break;
//            case 3://經濟艙
//                if (5 <= month && month <= 10) {//旺季
//                    price *= 0.8;
//                } else {//淡季
//                    price *= 0.6;
//                }
//                break;
//        }
//
//        System.out.println("你的機票最優惠價格為" + price + "元");

        /**====================
         * 10.去極端求平均
         * ==================*/
//
//        /**
//         * 隨機生成數組(內含10個數據)
//         */
//        int[] score = new int[10];
//        for (int i = 0; i < score.length; i++) {
//            score[i] = new Random().nextInt(100 - 75 + 1) + 75;//75~100
//        }
//        System.out.println("源數組" + Arrays.toString(score));
//
//        /**
//         * 去極端
//         */
//        //find max & min
//        int max = score[0];
//        int min = score[0];
//        for (int i = 1; i < score.length; i++) {
//            if (max < score[i]) {//遇強改強
//                max = score[i];
//            }
//            if (min > score[i]) {//遇弱改弱
//                min = score[i];
//            }
//        }
//        System.out.println("(max,min) = (" + max + "," + min + ")");
//        for (int i = 0; i < score.length; i++) {
//            if (score[i] == max || score[i] == min) {
//                score[i] = score[score.length - 1];//使用最末元素取代遇刪除的值
//                score = Arrays.copyOf(score, score.length - 1);//縮容以刪除最末位元素
//            }
//        }
//        System.out.println("去除後:" + Arrays.toString(score));
//
//        /**
//         * 求元素總和及平均
//         */
//        System.out.println("去除後數組長度為 = " + score.length);
//        double sum = 0;//總和
//        for (int i = 0; i < score.length; i++) {
//            sum += score[i];
//        }
//        System.out.println("去除後數組元素和 = " + sum);
//
//        System.out.println("分數平均 = 分數總和 / 分數數量 = " + (sum / score.length) + "分");
    }

}
