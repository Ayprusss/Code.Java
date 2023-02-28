public class ScopeTest {
    int x = 5;
    int y = 10;

    public static void main(String[], args) {
        ScopeTest s = new ScopeTest();
        s.x = 10;
        s.y = 29;
    }
}