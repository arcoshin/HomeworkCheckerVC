package stringRegex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 拓展作業類
 */
class Extend {
    public static void main(String[] args) {
        String path = "http://localhost:8088/myweb/reg?name=zhangsan&pwd=123456&nick=san&age=16";
        //參數名:pwd   參數值:123456
        //參數名:nick  參數值:san
        //參數名:age   參數值:16

        /**
         * 拆出待處理字段(?後方的部分)
         */
        String[] split = path.split("[\\?]");
//        System.out.println(Arrays.toString(split));//打樁語句
        //[http://localhost:8088/myweb/reg, name=zhangsan&pwd=123456&nick=san&age=16]

        /**
         * 拆出鍵值對結構(以&隔開的每一組key=value的部分)
         */
        String[] manyEntries = split[1].split("[&]+");
//        System.out.println(Arrays.toString(manyEntries));//打樁語句
        //[name=zhangsan, pwd=123456, nick=san, age=16]

        /**
         * 聲明一個Map集合
         * 遍歷每組鍵值對，將每組鍵值對拆分後(依照等號的前與後)分別傳入Map的鍵與值
         */
        HashMap<String,String> map = new HashMap<>();
        for (int i = 0; i < manyEntries.length; i++) {
            String[] entry = manyEntries[i].split("[\\=]");
            map.put(entry[0], entry[1]);
        }

        /**
         * 遍歷這個鍵值對(確認數據)
         */
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        entrySet.forEach(
                System.out::println
        );
        System.out.println();

        /**
         * 依照所求格式輸出
         */
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println("參數名:" + entry.getKey() + ", 參數值:" + entry.getValue());
        }

    }
}
