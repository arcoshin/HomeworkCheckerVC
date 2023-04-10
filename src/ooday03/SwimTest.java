package ooday03;

/**
 * 游泳接口的測試類
 */
class SwimTest {
    public static void main(String[] args) {
        Dog dog = new Dog("小黑",2, "黑");
        dog.eat();     //Dog類中重寫(原始為超類Animal中的抽象方法)
        dog.drink();   //複用超類Animal中的方法
        dog.swim();    //Dog類中重寫(原始為接口Swim中的抽象方法)
        dog.lookHome();//Dog類中特有的方法

        Chick chick = new Chick("小白",1, "白");
        chick.eat();   //Chick類中重寫(原始為超類Animal中的抽象方法)
        chick.drink(); //複用超類Animal中的方法
        chick.layEgg();//Chick類中特有的方法

        Fish fish = new Fish("小金",1, "金");
        fish.eat();    //Fish類中重寫(原始為超類Animal中的抽象方法)
        fish.drink();  //複用超類Animal中的方法
        fish.swim();   //Fish類中重寫(原始為接口Swim中的抽象方法)

    }
}
