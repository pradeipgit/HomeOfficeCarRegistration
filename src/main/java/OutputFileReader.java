import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OutputFileReader {

    public static List<CarDetails> readCars(String outputFilePath) throws IOException {
        List<CarDetails> outputCars = new ArrayList<>();

        Path fileName = Paths.get(outputFilePath);
        List<String> lines = Files.readAllLines(fileName);

        for(int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            CarDetails car = new CarDetails();
            car.registrationNumber = values[0];
            car.make = values[1];
            car.model = values[2];
            car.colour = values[3];
            car.year = values[4];
            outputCars.add(car);
        }
        return outputCars;
    }

    public static void writeCars(String filePath, List<CarDetails> cars) throws IOException {
        Path path = Paths.get(filePath);
        String header = "REGISTRATION,MAKE,MODEL,COLOR,YEAR";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        //bufferedWriter.write(header);
        //Files.write(path, cars);
    }
}
