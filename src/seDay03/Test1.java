package seDay03;

import java.io.*;
import java.util.Random;

/**
 * 獲取users中所有人的數據
 */
class Test1 {
    public static void main(String[] args) {
        /**
         * 綁定、定位到目標目錄
         */
        String path = "src/seDay03/demo/users";
        File pathName = new File(path);

        /**
         * 獲取目標目錄中所有後綴為obj的檔案(過濾器:lambda->以.obj結尾的檔案名)
         */
        File[] lists = pathName.listFiles(f -> f.getName().endsWith(".obj"));
        /**
         * 利用遍歷+拼接定位每個列表中的檔案
         */
        for (File list : lists) {
            String fileName = path + "/" + list.getName();//遍歷拼接
            try (
                    /**
                     * 建立對象輸入流:
                     */
                    ObjectInputStream ois = new ObjectInputStream(
                            new FileInputStream(fileName)
                    )
            ) {

                /**
                 * 讀取目標目錄中所有的obj檔案
                 * 此時直接輸出o就會直接調用o.toString方法
                 * 而toString是由Object類中所定義所以每個對象都有
                 * 又toString為實例方法且已被重寫過，故可直接調用
                 *
                 * 一般返回object類型時需轉回原本類型方可調用其他類中定義的實例方法
                 * 使用instanceof可以比對兩個對象之間是否有關係(繼承關係、實現關係)
                 * 返回true時方可強轉，是一種確保手段
                 */
                Object o = ois.readObject();
//                if (o instanceof User) {
                    System.out.println(o);
//                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * User產生器(mains的static先移除，避免誤觸)
     */
    static class AutoAddUsers {
        /**
         * 生成位置
         */
        private static String path = "src/seDay03/demo/users";

        public
//        static
        void main(String[] args) {
            Run();
            createUser();
            return;
        }

        /**
         * 進度
         */
        private static void Run() {
            System.out.println("正在生成隨機100個User資料");
            for (int i = 0; i <= 100; i++) {
                System.err.println("........" + i + "%");
                if (i == 100) {
                    System.err.println("........FINISH!");

                }
            }

        }

        /**
         * 生成對象
         */
        private static void createUser() {
            /**
             * 隨機生成對象的參數
             */
            for (int i = 0; i < 100; i++) {
                int pwdIndexMax = 99;
                int pwdIndexMin = 10;
                String pwdFrag = "" + new Random().nextInt(pwdIndexMax - pwdIndexMin + 1) + pwdIndexMin;
                int ageIndexMax = 130;
                int ageIndexMin = 0;

                String userName = String.valueOf(i);
                String pwd = "AAA" + pwdFrag + "zzz";
                String nick = "user" + i;
                int age = new Random().nextInt(ageIndexMax - ageIndexMin + 1) + ageIndexMin;

                /**
                 * 創建隨機對象
                 */
                seDay03.User user = new seDay03.User(userName, pwd, nick, age);

                /**
                 * 拼接新的對象地址
                 */
                String userPath = path + "/" + user.getName() + ".obj";

                /**
                 * 架設流
                 */
                try (
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userPath));
                ) {
                    /**
                     * 寫出對象
                     */
                    oos.writeObject(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        }
    }
}

