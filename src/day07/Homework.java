package day07;


import java.util.*;

public class Homework {
    /**===========================================================
     *=======第二題方法區===========================================
     ===========================================================*/
    /**
     * 隨機生成一個數字的方法
     */
    private static char createRandomNum() {
        int index = new Random().nextInt(57 - 48 + 1) + 48;//48~57
        return (char) index;//'0'~'9'
    }

    /**
     * 隨機生成一個大寫英文字母的方法
     */
    private static char createUpperCase() {
        int index = new Random().nextInt(26) + 65;//65~90
        return (char) index;//'A'~'Z'
    }

    /**
     * 隨機生成一個小寫英文字母的方法
     */
    private static char createLowerCase() {
        int index = new Random().nextInt(26) + 97;//97~122
        return (char) index;//'a'~'z'
    }

    /**
     * 隨機生成一組N位驗證碼的方法
     */
    private static String createCode(int len) {
        String code = "";
        for (int i = 1; i <= len; i++) {//長度要多長就循環幾次
            int chance = new Random().nextInt(3 - 1 + 1) + 1;//1~3
            switch (chance) {//隨機選擇生成方法，拼接成驗證碼
                case 1:
                    char randomNum = createRandomNum();//隨機生成數字
                    code += randomNum;
                    break;
                case 2:
                    char upperCase = createUpperCase();//隨機生成大寫
                    code += upperCase;
                    break;
                case 3:
                    char lowerCase = createLowerCase();//隨機生成小寫
                    code += lowerCase;
                    break;
            }
        }
        return code;
    }

    /**
     * ===========================================================
     * =======第四題方法區==========================================
     * ===========================================================
     */
    private static double calAirplaneTicketPrice(double price, int month, int level) {
        //先驗證所輸入資訊是否正確
        if (price <= 0) {
            System.out.println("輸入票價錯誤");
            return -1;//有錯誤一律返回-1，並停止方法
        }
        if (month < 1 || month > 12) {
            System.out.println("輸入月份錯誤");
            return -1;//有錯誤一律返回-1，並停止方法
        }
        if (level < 1 || level > 3) {
            System.out.println("輸入艙等錯誤");
            return -1;//有錯誤一律返回-1，並停止方法
        }

        //系統執行至此代表輸入資訊正確，即開始分類計算
        double finalPrice = price;//接收票價準備後續計算

        switch (level) {
            case 1://頭等艙
                if (month >= 5 && month <= 10) {//旺季走此分支
                    finalPrice *= 0.9;
                } else {//非5~10月(淡季)則走此分支
                    finalPrice *= 0.7;
                }
                break;
            case 2://商務艙
                if (month >= 5 && month <= 10) {//旺季走此分支
                    finalPrice *= 0.85;
                } else {//非5~10月(淡季)則走此分支
                    finalPrice *= 0.65;
                }
                break;
            case 3://經濟艙
                if (month >= 5 && month <= 10) {//旺季走此分支
                    finalPrice *= 0.8;
                } else {//非5~10月(淡季)則走此分支
                    finalPrice *= 0.6;
                }
                break;
        }
        return finalPrice;
    }

    /**
     * ===========================================================
     * =======第五題方法區==========================================
     * ===========================================================
     */
    /**
     * 自動生成數組的方法
     */
    private static int[] createDataByRandom() throws InterruptedException {
        System.out.println("正在自動生成數組......");
        Thread.sleep(1000);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(101 - 0 + 1);//0~100
        }
        System.out.println("已生成數組:" + Arrays.toString(arr));
        return arr;
    }

    /**
     * 手動生成數組的方法
     */
    private static int[] createDataByUser() throws InterruptedException {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("請輸入第" + (i + 1) + "個數據");
            arr[i] = new Scanner(System.in).nextInt();
        }
        System.out.println("正在展示您已輸入完成的自定義數組......");
        Thread.sleep(1000);
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /**
     * 去除指定數組中最大值與最小值的方法
     */
    private static int[] cutBiggestAndSmallestInArray(int[] array) {
        //使用Arrays.sort();方法自然排序(從小到大)
        Arrays.sort(array);

        //藉由縮容去除最末位元素(即去除最大值)
        array = Arrays.copyOf(array, array.length - 1);

        //去除最小值:將此時的最末位元素賦值取代首位元素(覆蓋最小值)，並再縮容去除最末位元素(去除最末值的重複)
        array[0] = array[array.length - 1];//最末位取代最首位(第二大取代最小)
        array = Arrays.copyOf(array,array.length - 1);//縮容完成去除最小值

        System.out.println("去除最大與最小值後的數組:" + Arrays.toString(array));
        return array;
    }
    /**
     * 求出指定數組所有元素總和的方法
     */
     private static int getArraySum(int[] arr) {
         int sum = 0;
         for (int arrIndex : arr) {
             sum += arrIndex;
         }
         return sum;
     }

    /**
     * 求出指定數組所有元素平均的方法
     */
    private static double getArrayAvg(int[] arr) {
        double sum = getArraySum(arr);//求出指定數組所有元素總和的方法
        int len = arr.length;//求出指定數組長度
        double avg = (sum/len);//平均 = 總和 / 數量
        return avg;
    }

    public static void main(String[] args) throws InterruptedException {
        /**========================
         * 1.猜數字，使用while(true)
         * ======================*/
//
//        int num = new Random().nextInt(1000 - 1) + 1;//生成謎底1~1000隨機數
//        System.out.println("(學術用輔助外掛已開啟------\"num\" = " + num + ")");
//        System.out.println("範圍1~1000，請猜吧!!");
//        while (true) {//條件永遠為true，持續循環
//            int user = new Scanner(System.in).nextInt();//接收玩家的答案
//
//            if (user > num) {//判題
//                System.out.println("你猜的太大了");
//            } else if (user < num) {
//                System.out.println("你猜的太小了");
//            } else {
//                System.out.println("恭喜你猜對了!!!");
//                return;
//            }
//        }
//
        /**====================
         * 2.生成N位數驗證碼
         * ==================*/
//
//        System.out.println("請輸入要生成幾位數的驗證碼...(N=?)");
//        int n = new Scanner(System.in).nextInt();//接受長度要求
//        System.out.println(createCode(n));//生成驗證碼並輸出
//
        /**====================
         * 3.找出2~100之間的素數
         * ==================*/
//
//        Collection<Integer> c = new ArrayList();//用來儲存素數的容器
//        for (int num = 2; num <= 100; num++) {//遍歷所給範圍2~100
//            boolean result = true;//假設皆為素數
//            for (int i = 2; i <= (num / 2); i++) {//遍歷2~0.5倍自身是否能被某個數整除
//                if (num % i == 0) {//如能被某數整除則必非素數
//                    result = false;
//                    break;//直接結束本次循環沒有繼續運算剩餘元素的必要
//                }
//            }//通過循環後
//            if (result) {//仍然為true時則為素數
//                c.add(num);//歸檔紀錄
//            }
//        }
//        System.out.println(c);//輸出容器內的紀錄
//        System.out.println("\"2~100\"之中有" + c.size() + "個素數");//統計結果
//
        /**====================
         * 4.飛機票價計算器
         * ==================*/
//
//        System.out.println("請輸入原始票價");
//        double price = new Scanner(System.in).nextDouble();
//        System.out.println("請輸入旅遊月份");
//        int month = new Scanner(System.in).nextInt();
//        System.out.println("請輸入班機艙等: 1.頭等艙 2.商務艙 3.經濟艙");
//        int level = new Scanner(System.in).nextInt();
//
//        //調用並輸出票價
//        System.out.println(calAirplaneTicketPrice(price, month, level));
        /**==============================
         * 5.去大去小平均法，假設10個分數數據
         * =============================*/
//
//        System.out.println("即將演示\"去大去小平均法\"，假設10個數據");
//        System.out.println("請選擇數據來源: 1.系統隨機生成(推薦) 2.手動輸入");
//        int type = new Scanner(System.in).nextInt();
//        switch (type) {
//            case 1:
//                int[] dataByRandom = createDataByRandom();//生成數組
//                int[] newDataByRandom = cutBiggestAndSmallestInArray(dataByRandom);//去大去小
//                int sumOfNewDataByRandom = getArraySum(newDataByRandom);//求數組總和
//                double avgOfNewDataByRandom = getArrayAvg(newDataByRandom);//求數組平均
//                System.out.println("去除最大與最小值後的數組總和為:" + sumOfNewDataByRandom);
//                System.out.println("去除最大與最小值後的數組平均為:" + avgOfNewDataByRandom);
//                break;
//            case 2:
//                int[] dataByUser = createDataByUser();//生成數組
//                int[] newDataByUser = cutBiggestAndSmallestInArray(dataByUser);//去大去小
//                int sumOfNewDataByUser = getArraySum(newDataByUser);//求數組總和
//                double avgOfNewDataByUser = getArrayAvg(newDataByUser);//求數組平均
//                System.out.println("去除最大與最小值後的數組總和為:" + sumOfNewDataByUser);
//                System.out.println("去除最大與最小值後的數組平均為:" + avgOfNewDataByUser);
//                break;
//            default:
//                System.out.println("輸入錯誤!正在結束程序...");
//                return;
//        }



    }

}
