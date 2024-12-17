class J7_4 {
    public static void main(String[] args) {
        try {
            if (args.length == 0) { // 引数がないか確認
                throw new ArrayIndexOutOfBoundsException("引数がありません"); // 引数がない場合例外発生
            }

            Class<?> cls = Class.forName(args[0]); // 引数の値をクラスの名前で見なしてClassを返す。
            
            int count = 0;
            while ((cls = cls.getSuperclass()) != null) {
                count++; // スーパークラスが存在するたびに1増加
            }
            System.out.println("スーパークラスの数: " + count); // スーパークラスの個数を出力
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            System.out.println("引数がありません");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.out.println("クラスが見つかりません");
        }
    }
}
