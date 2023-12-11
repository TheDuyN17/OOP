public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sortStrategy(int [] array) {
        strategy.sort(array);
    }
}