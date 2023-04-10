package ooday02;

class PersonTest {
    public static void main(String[] args) {
        Student zs = new Student("張三", 25, "台北", "jsd2203", "001");
        //共有行為
        zs.eat();
        zs.sleep();
        zs.sayHi();
        //特定行為
        zs.study();

        Teacher ls = new Teacher("李四", 45, "台南", 120000);
        //共有行為
        ls.eat();
        ls.sleep();
        ls.sayHi();
        //特定行為
        ls.teach();

        Doctor ww = new Doctor("王五", 55, "台中", "急診");
        //共有行為
        ww.eat();
        ww.sleep();
        ww.sayHi();
        //特定行為
        ww.cut();
    }
}
