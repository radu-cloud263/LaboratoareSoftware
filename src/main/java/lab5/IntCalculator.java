package lab5;

public class IntCalculator {
    int state;

    public int result() {
        return state;
    }

    public void clear() {
        state = 0;
    }

    public IntCalculator add(int x) {
        state += x;
        return this;
    }

    public IntCalculator substract(int x) {
        state -= x;
        return this;
    }

    public IntCalculator multiply(int x) {
        state *= x;
        return this;
    }

    public IntCalculator(int state)
    {
        this.state = state;
    }


}
