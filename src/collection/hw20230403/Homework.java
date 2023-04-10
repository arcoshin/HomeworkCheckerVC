package collection.hw20230403;

import java.util.*;

class Homework {
    public static void main(String[] args) {
        /**====================
         * Collection基本操作
         * ==================*/
        System.out.println("Collection基本操作");
        System.out.println();
        //add
        Collection c = new ArrayList();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("something");

        //size
        System.out.print("c.size() = ");
        System.out.println(c.size());

        //contains
        System.out.print("c.contains(\"two\") = ");
        System.out.println(c.contains("two"));

        //remove
        c.remove("something");
        System.out.println("after c.remove(\"something\"); c = " + c);

        //clear
        c.clear();
        System.out.println("after c.clear(); c = " + c);

        //isEmpty
        System.out.println("c is empty now ? " + c.isEmpty());


        /**====================
         * Collection集合間操作
         * ==================*/
        System.out.println();
        System.out.println("Collection集合間操作");
        System.out.println();
        Collection c1 = new ArrayList();
        c1.add("Integer");
        c1.add("Double");
        c1.add("Character");
        c1.add("String");
        System.out.println("c1:" + c1);

        Collection c2 = new ArrayList();
        c2.add("float");
        c2.add("long");
        c2.add("boolean");
        c2.add("String");
        System.out.println("c2:" + c2);

        //addAll
        c1.addAll(c2);
        System.out.println("after c1.addAll(c2); c = " + c1);
        System.out.println("after c1.addAll(c2); c = " + c2);

        //containsAll
        System.out.println("c1 contains all elements of c2 now ?" + c1.containsAll(c2));

        //removeAll
        c1.removeAll(c1);
        System.out.println("after c1.remove(c2); c1 = " + c1);
        System.out.println("after c1.remove(c2); c2 = " + c2);

        //retainAll
        c1.retainAll(c2);
        System.out.println("What is the element that be showed both of c1&c2 ?" + c1.retainAll(c2));
        System.out.println("after c1.retainAll(c2); c1 = " + c1);
        System.out.println("after c1.retainAll(c2); c2 = " + c2);

        /**====================
         * 迭代器遍歷集合
         * ==================*/
        Collection<Integer> randomIntegerCollection = new ArrayList();
        for (int i = 0; i < 10; i++) {
            int random = new Random().nextInt(100 - 1 + 1) + 1;
            randomIntegerCollection.add(random);
        }
        System.out.println("Collection:" + randomIntegerCollection);

        Iterator it = randomIntegerCollection.iterator();
        System.out.println("iterator遍歷開始========================================");
        while (it.hasNext()) {//當有下個元素時...問(只問不動)
            System.out.print(it.next() + " ");//指針一致下個元素並返回...取
            //it.remove();//刪...非必要
        }
        System.out.println();
        System.out.println("iterator遍歷完畢========================================");


        /**====================
         * 增強型for循環
         * //使用上題集合
         * ==================*/
        System.out.println("====================增強型for循環遍歷開始====================");
        for (Integer random : randomIntegerCollection) {//randomIntegerCollection.for
            System.out.print(random + " ");
        }
        System.out.println();
        System.out.println("====================增強型for循環遍歷完畢====================");


        /**====================
         * 泛型
         * ==================*/
        Collection<Integer> c3 = new ArrayList<>();
        c3.add(1);
//        c3.add("1");//編譯錯誤
        Iterator<Integer> iterator = c3.iterator();//c3.iterator.var可自動生成相應Iterator對象，省略強轉操作


        /**=========================
         * Collection ------> Array
         * =======================*/
        System.out.println(
                "Collection ------> Array"
        );
        Collection<Integer> c4 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            c4.add(i);
        }
        System.out.println("c4:" + c4);
        /**
         * if integers.length > c4.size,add default value from the final element.
         * if integers.length == c4.size,normal.
         * if integers.length < c4.size,(Auto)Set integer.length == c4.size.
         */
        Integer[] integers = c4.toArray(new Integer[c4.size()]);
        System.out.println("integers:" + Arrays.toString(integers));



        /**=========================
         * Array ------> List
         * =======================*/
        System.out.println(
                "Array ------> List"
        );
        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100 - 1 + 1) + 1;//1~100
        }
        System.out.println(Arrays.toString(array));

        List<Integer> list = Arrays.asList(array);
        System.out.println("list:" + list);

    }
}
