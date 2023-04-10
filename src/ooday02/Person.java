package ooday02;

class Person {
    /**
     * 共有屬性
     */
    String name;
    int age;
    String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * 共有方法
     */
    void eat() {
        System.out.println(name + "正在吃飯...");
    }

    void sleep() {
        System.out.println(name + "正在睡覺...");
    }

    void sayHi() {
        System.out.println("大家好，我叫" + name + "，今年" + age + "歲，來自" + address);
    }

}
class Student extends Person {
    String className;
    String stuId;
    //    String name;//與超類中的成員變量同名了!!

    /**
     * 構造器可以直接賦值給從父類繼承來的成員變量
     */
    public Student(String name, int age, String address, String className, String stuId) {
        super(name, age, address);
        this.className = className;
        this.stuId = stuId;
    }

    //        super.age = age;//指父類中成員變量
    //        this.age = age;//指當前類的成員變量。而子類可以訪問父類成員變量，故能使用this，意義等同super
    //
    //        super.address = address;//指父類中成員變量
    //        this.address = //指當前類的成員變量。而子類可以訪問父類成員變量，故能使用this，意義等同super

    /**
     * 特殊情況:但幾乎不會發生，因為同名變量可以透過定義不同變量名稱來化解，也更實用
     * <p>
     * 相同作用域的同名變量時，不可省略關鍵字(難以分辨)
     * 重名變量同作用域而省略關鍵字時，Java默認"就近原則"，以最近的那個變量為準
     * 關鍵字super:調用父類資源
     * 關鍵字this:調用當前對象類資源
     */
    //        name = name;//java關於同名變量的作用域為就近原則，故此處name皆為局部變量，故本行代碼無意義
    //        this.name = name;//指當前類的成員變量；子類可訪問父類成員變量，但因有同名變量，故此時super意義上不等同於this
    //        super.name = name;//直指父類中的成員變量


    void study() {
        System.out.println(name + "同學正在用功念書......");
    }

    @Override
    void sayHi() {
        super.sayHi();
        System.out.println("目前就讀的是" + className + "班，學號為" + stuId + "，很高興認識大家");
    }
}

class Teacher extends Person {
    double salary;

    public Teacher(String name, int age, String address, double salary) {
        super(name, age, address);
        this.salary = salary;
    }

    void teach() {
        System.out.println(name + "老師正在教學......");
    }

    @Override
    void sayHi() {
        super.sayHi();
        System.out.println("目前是名老師，月薪約" + salary + "元");
    }
}

class Doctor extends Person{
    String level;

    Doctor(String name,int age,String address,String level){
        super(name, age, address);
        this.level = level;
    }

    void cut() {
        System.out.println(name + "醫師正在進行手術.....");
    }
}
