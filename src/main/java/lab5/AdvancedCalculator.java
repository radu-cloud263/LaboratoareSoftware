package lab5;

public class AdvancedCalculator extends IntCalculator{
    public AdvancedCalculator(int state) {
        super(state);
    }

    @Override
    public AdvancedCalculator add(int x) {
        super.add(x);
        return this;
    }

    @Override
    public AdvancedCalculator substract(int x) {
        super.substract(x);
        return this;
    }

    @Override
    public AdvancedCalculator multiply(int x) {
        super.multiply(x);
        return this;
    }

    public AdvancedCalculator divide(int x) {
        state/= x;
        return this;
    }

    public AdvancedCalculator putere(int x) {
        state = (int)Math.pow(state, x);
        return this;
    }

    public AdvancedCalculator radical(int x) {
        state = (int)Math.pow(state, 1.0/x);
        return this;
    }
}
