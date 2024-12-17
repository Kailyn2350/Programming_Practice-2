import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class J9_1 {
    public static void main(String[] args) {
        // 誕生日の設定 (LocalDateを使用)
        LocalDate birthDate = LocalDate.of(2001, 2, 3); // 2月3日
        
        // 現在の日付
        LocalDate currentDate = LocalDate.now();
        
        // 日数の経過を計算
        long elapsedDays = ChronoUnit.DAYS.between(birthDate, currentDate);
        
        // 結果を出力
        System.out.println("誕生日: " + birthDate);
        System.out.println("現在日時: " + currentDate);
        System.out.println("誕生日からの経過日数: " + elapsedDays + "日");
    }
}
