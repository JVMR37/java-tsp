public class Cidade {
    public double x;
    public double y;

    public Cidade(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
