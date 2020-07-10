import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Path.*;

public class InputFileReader {

    public static List<String> findCarRegNumbers(String strPath) throws IOException {
        List<String> carRegNumbers = new ArrayList<String>();
        //Path fileName = Paths.get("./src/main/java/DataFiles/car_input.txt");
        Path fileName = Paths.get(strPath);

        List<String> lines = Files.readAllLines(fileName);

        for(String carInputText: lines) {
            Matcher m = Pattern.compile("[A-Za-z]{2}[ ]?[0-9]{2}[ ]?[a-zA-Z]{3}")
                    .matcher(carInputText);
            while (m.find()) {
                carRegNumbers.add(m.group());
            }
        }

        return carRegNumbers;
    }

}
