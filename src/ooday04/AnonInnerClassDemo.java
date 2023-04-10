package ooday04;

/**
 * 匿名內部類的演示類 : 應用率高，要重點掌握!!!
 * 特別重點:
 *
 * 1.若想創建一派生類對象，且該對象只創建一次，則推薦使用，可以大幅簡化代碼
 *
 * 2.匿名內部類不可以修改外面局部變量的值
 *
 * 3.面試題 : 匿名內部類有獨立的class文件嗎? (字節碼文件)  答 : 有!!!所有內部類都有!
 * 在專案資料夾/out資料夾/當前文件所在包位置/可以發現 : 外部類名 + $ + 內部類名(此處匿名內部類則為1,2,3,4).class文件即是
 */
public class AnonInnerClassDemo {
    public static void main(String[] args) {
        /**
         * 匿名內部類時，系統自動完成了兩件事
         * 1)."創建了Aoo的派生類"，但是該類沒有名字!
         * 2).為該派稱類創造了一個對象，名為o1，並且"向上轉型為Aoo類型!"
         * 3).大括號中的內容為派生類的類體
         */
        Aoo o1 = new Aoo() {//匿名內部類
            /**
             * 既是派生類(子類)，則超類(父類)中的抽象方法必須重寫完整
             */
            @Override
            void show() {
                System.out.println("此處已成功執行抽象類Aoo的子類對象，o1的show()的方法...");
            }
        };

        /**
         * 匿名內部類時，系統自動完成了兩件事
         * 1)."創建了Aoo的派生類"，但是該類沒有名字!
         * 2).為該派生類創造了一個對象，名為o2，並且"向上造型為Aoo類型!"
         * 3).大括號中的內容為派生類的類體
         */
        Aoo o2 = new Aoo() {//匿名內部類
            /**
             * 既是派生類(子類)，則超類(父類)中的抽象方法必須重寫完整
             */
            @Override
            void show() {
                System.out.println("此處已成功執行抽象類Aoo的子類對象，o2的show()的方法...");
            }
        };

        /**
         * 可以生成非常多次的 new Aoo(){}
         * 但本質上是產生Aoo無數個新的派生類然後再創建該類對象
         * 因此o1,o2...等匿名內部類對象之間，其實並沒有關係!!!!!
         * 另外要特別注意 : 匿名內部類不可以修改外部成員變量的值!!!!!!
         */

        /**
         * 調用匿名內部類的資源，則直接使用該派生類的對象調用即可
         */
        o1.show();
        o2.show();

        /**
         * 接口的匿名內部類 :
         */
        Inter i1 = new Inter() {
            @Override
            public void test() {
                System.out.println("已成功調用i1重寫後的test方法");
            }
        };

        Inter i2 = new Inter() {
            @Override
            public void test() {
                System.out.println("已成功調用i2重寫後的test方法");
            }
        };


    }
}

/**
 * 抽象類範例
 */
abstract class Aoo {
    abstract void show();
}

/**
 * 接口範例
 */
interface Inter {
    void test();
}
