package web.model;


public class Car {
    int series;
    String mark;
    String model;

    public Car(int series, String mark, String model) {
        this.series = series;
        this.mark = mark;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "series=" + series +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
