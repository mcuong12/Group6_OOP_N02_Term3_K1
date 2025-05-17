public class CastingTest {
    public static void testDouble() {
        int a = 10;
        double b = a;
        System.out.println("Ép int sang double: " + b);
    }

    public static void testCasting() {
        double a = 9.5;
        int b = (int) a;
        System.out.println("Ép double sang int: " + b);
    }
}