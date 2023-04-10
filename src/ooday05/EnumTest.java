package ooday05;

import java.util.Arrays;

/**
 * 枚舉測試類
 */
public class EnumTest {
    public static void main(String[] args) {
        /**
         * 遍歷枚舉
         */
        Seasons[] seasons = Seasons.values();//Seasons.values():獲取所有枚舉對象並返回數組類型
        System.out.println(Arrays.toString(seasons));//遍歷數組

        /**
         * 枚舉的生成
         */
//        Seasons o = new Seasons();//編譯錯誤，枚舉構造器為私有的，無法像類一樣直接調用
        Seasons s = Seasons.WINTER;//獲取WINTER對象
        switch (s) {//switch天生識別枚舉，所以case不需要加類名打點調用(後期常常搭配使用)
            case SPRING:
                System.out.println("春天到了...");
                break;
            case SUMMER:
                System.out.println("夏天到了...");
                break;
            case AUTUMN:
                System.out.println("秋天到了...");
                break;
            case WINTER:
                System.out.println("冬天到了...");
                break;
        }


    }
}

/**
 * 枚舉類範例 : 季節枚舉
 */
enum Seasons {
    SPRING,SUMMER,AUTUMN,WINTER;//表示Seasons中固定的四個對象都是常量
}