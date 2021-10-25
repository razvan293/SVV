package lab1;

public class SumCalculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public String sum(String a, String b) throws NullPointerException {
        if (a == null || b == null)
            throw new NullPointerException();
        return a + b;
    }
}
