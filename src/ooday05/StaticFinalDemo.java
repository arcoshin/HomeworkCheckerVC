package ooday05;

/**
 * 常量演示類
 */
class StaticFinalDemo {
    public static void main(String[] args) {
        System.out.println(Loo.PI);//常量具備static修飾，屬於靜態資源，也是透過類名調用
    }
}

//常量演示
class Loo {
    public final static double PI = 3.14159;//通常是公開的，標準的常量聲明
//    public final static double NUM;//編譯錯誤，常量必須在聲明時一併初始化，且後續即無法更改
}
