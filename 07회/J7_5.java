class J7_5 {
    public static void main(String[] args) {
        try {
            if (args.length == 0) { // 引数がないか確認
                throw new ArrayIndexOutOfBoundsException("引数がありません"); // 引数がない場合例外発生
            }
            int count = countSuperClasses(args[0]); // スーパークラスの数
            System.out.println("スーパークラスの数: " + count);
        } catch (ArrayIndexOutOfBoundsException e) { // 引数がない場合
            System.out.println(e);
            System.out.println("引数がありません");
        } catch (ClassNotFoundException e) { // クラスの名前がない場合
            System.out.println(e);
            System.out.println("クラスが見つかりません");
        }
    }

    public static int countSuperClasses(String className) throws ClassNotFoundException {
        Class<?> cls = Class.forName(className); // 引数の値をクラスの名前で見なしてClassを返す。
        int count = 0;
        while ((cls = cls.getSuperclass()) != null) {
            count++;
        }
        return count;
    }
}
