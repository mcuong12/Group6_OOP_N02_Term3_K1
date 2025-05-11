import java.util.Random;

public class randNum {
    public static int randNum() {
        Random random = new Random();
        return random.nextInt(100); // Trả về số ngẫu nhiên từ 0-99
    }
}