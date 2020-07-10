import java.util.Objects;

public class CarDetails {
    String registrationNumber;
    String make;
    String model;
    String colour;
    String year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDetails that = (CarDetails) o;
        return Objects.equals(registrationNumber, that.registrationNumber) &&
                Objects.equals(make, that.make) &&
                Objects.equals(model, that.model) &&
                Objects.equals(colour, that.colour) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber, make, model, colour, year);
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
