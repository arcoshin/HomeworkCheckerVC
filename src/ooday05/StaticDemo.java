package ooday05;

/**
 * 靜態關鍵字演示類 : 靜態變量 靜態方法 靜態代碼塊
 */
public class StaticDemo {
    public static void main(String[] args) {
        /**
         * 一個類中的成員變量包含兩種: 實例變量 與 靜態變量(或稱類變量)
         * 實例變量屬於對象，只能通過對象訪問
         * 靜態變量屬於類本身，一般建議使用類名打點訪問
         *
         * 又靜態資源全類共享，
         * 因此本案例可發現靜態資源出現了累加現象(所有修改共用一份數據)
         */
        StaticVar o1 = new StaticVar();
        o1.show();

        StaticVar o2 = new StaticVar();
        o2.show();

        StaticVar o3 = new StaticVar();
        o3.show();


        /**
         * 靜態代碼塊於內存中，是在加載類時就執行一次
         * 因此會在構造器(方法)之前執行，而且只會執行一次
         */
        StaticBlock s1 = new StaticBlock();
        StaticBlock s2 = new StaticBlock();
        StaticBlock s3 = new StaticBlock();


    }
}

/**
 * 成員變量解釋類: 包含 實例變量 與 靜態變量
 */
class StaticVar {
    int a;//實例變量
    static int b;//靜態變量

    public StaticVar() {
        a++;
        b++;
    }

    void show() {
        System.out.println("a=" + a + ",b=" + b);
    }
}

/**
 * 靜態方法演示類
 */
class StaticMethod {
    int a; //實例變量，由對象訪問
    static int b;//靜態變量(類變量)，由類名訪問

    void show(){//有隱式this(系統默認提供，因為實例資源屬於對象，this即是指代調用的當前對象)
        System.out.println(this.a);//完整寫法
        System.out.println(StaticMethod.b);//完整寫法
    }

    static void test() {//無隱式this，因為靜態資源屬於類
        /**
         * 無隱式this代表沒有對象調用
         * 但實例變量只能通過實例對象調用
         * 所以此處代碼編譯錯誤
         */

//        System.out.println(a);//編譯錯誤，靜態方法中不可直接訪實例成員
        StaticMethod s = new StaticMethod();
        System.out.println(s.a);//生成實例就可以，但一般不這麼做

        System.out.println(b);//完整寫法，默認類名打點訪問
    }
}

/**
 * 靜態代碼塊
 */
class StaticBlock {
    static {//靜態代碼塊
        System.out.println("靜態代碼塊已被執行");
    }

    public StaticBlock() {
        System.out.println("構造方法已被執行");
    }
}


