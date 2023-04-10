package ooday03;

/**
 * 引用類型數組的演示
 */
public class RefArrayDemo {
    public static void main(String[] args) {
        //聲明Dog型數組dogs，包含三個元素，默認值為null
        Dog[] dogs = new Dog[3];
        dogs[0] = new Dog("小黑", 2, "黑");
        dogs[1] = new Dog("小白", 3, "白");
        dogs[2] = new Dog("小黃", 4, "黃");
        for (int i = 0; i < dogs.length; i++) {
            System.out.println("======以下調用" + dogs[i].name + "的屬性與行為======");
            /**
             * 調用每隻狗的屬性
             */
            System.out.println("有一隻" + dogs[i].color + "狗叫做" + dogs[i].name + "，今年" + dogs[i].age + "歲");
            System.out.println();
            /**
             * 調用每隻狗的行為
             */
            dogs[i].eat();//重寫超類方法
            dogs[i].drink();//複用超類方法
            dogs[i].swim();//重寫接口方法
            dogs[i].lookHome();//狗類特定方法
            System.out.println("=========================================================================");
        }

        //聲明Chick型數組chicks，包含三個元素，默認值為null
        Chick[] chicks = new Chick[3];
        chicks[0] = new Chick("小紅", 1, "紅");
        chicks[1] = new Chick("小黑", 1, "黑");
        chicks[2] = new Chick("小花", 1, "花");
        for (int i = 0; i < chicks.length; i++) {
            System.out.println("======以下調用" + chicks[i].name + "的屬性與行為======");
            /**
             * 調用每隻雞的屬性
             */
            System.out.println("有一隻" + chicks[i].color + "雞叫做" + chicks[i].name + "，今年" + chicks[i].age + "歲");
            System.out.println();
            /**
             * 調用每隻雞的行為
             */
            chicks[i].eat();//重寫超類方法
            chicks[i].drink();//複用超類方法
            chicks[i].layEgg();//雞類特定方法
            System.out.println("=========================================================================");
        }

        //聲明Fish型數組fish，包含三個元素，默認值為null
        Fish[] fish = new Fish[2];
        fish[0] = new Fish("小金", 2, "金");
        fish[1] = new Fish("小銀", 2, "銀");
        for (int i = 0; i < fish.length; i++) {
            System.out.println("======以下調用" + fish[i].name + "的屬性與行為======");
            /**
             * 調用每隻魚的屬性
             */
            System.out.println("有一隻" + fish[i].color + "魚叫做" + fish[i].name + "，今年" + fish[i].age + "歲");
            System.out.println();
            /**
             * 調用每隻魚的行為
             */
            fish[i].eat();//重寫超類方法
            fish[i].drink();//複用超類方法
            fish[i].swim();//重寫接口方法
            System.out.println("=========================================================================");
        }

    }
}
