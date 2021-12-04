import java.io.Serializable;

public class Rivers implements Serializable {
    String name;
    String region;
    int longitude;

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", longitude=" + longitude +
                '}';
    }
}