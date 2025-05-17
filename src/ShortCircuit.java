public class ShortCircuit {
    public static void test() {
        int x = 10;
        if (x > 5 || x / 0 == 1) {
            System.out.println("Short-circuit OR hoạt động");
        }
    }
}