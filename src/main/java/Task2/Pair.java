package Task2;

public class Pair {

    Double first;
    Double second;


    public Pair(Double first, Double second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public Double getFirst() {
        return first;
    }

    public Double getSecond() {
        return second;
    }
}