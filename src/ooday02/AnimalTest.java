package ooday02;

class AnimalTest {
    public static void main(String[] args) {
        Dog dog = new Dog("來福", 12, "黑");
        dog.eat();//重寫方法
        dog.drink();//超類方法
        dog.lookHome();//特有方法

        Chick chick = new Chick("嗶嗶", 1, "黃");
        chick.eat();//重寫方法
        chick.drink();//超類方法
        chick.layEgg();//特有方法

        Fish fish = new Fish("提莫", 30, "橘");
        fish.eat();//重寫方法
        fish.drink();//超類方法

        Animal[] animalList = new Animal[12];//(3,4,5)
        animalList[0] = new Dog("d1",1,"黑");
        animalList[1] = new Dog("d2",2,"白");
        animalList[2] = new Dog("d3",3,"花");
        animalList[3] = new Chick("c1",1,"紅");
        animalList[4] = new Chick("c2",2,"橙");
        animalList[5] = new Chick("c3",3,"黃");
        animalList[6] = new Chick("c4",4,"綠");
        animalList[7] = new Fish("f1",1,"藍");
        animalList[8] = new Fish("f2",2,"靛");
        animalList[9] = new Fish("f3",3,"紫");
        animalList[10] = new Fish("f4",4,"黑");
        animalList[11] = new Fish("f5",5,"白");
        for (int i = 0; i < animalList.length; i++) {
            animalList[i].eat();
            animalList[i].drink();
        }

    }
}
