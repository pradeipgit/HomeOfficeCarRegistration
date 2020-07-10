import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String inputPath = "./src/main/java/DataFiles/car_input.txt";
    public static String outputPath = "./src/main/java/DataFiles/car_output.txt";

    public static void main(String[] args) {

        List<String> registrations = null;
        try {
            registrations = InputFileReader.findCarRegNumbers(inputPath);

            CarTaxCheckPage carTaxCheckPage = new CarTaxCheckPage();
            List<CarDetails> matchedCars = new ArrayList<>();
            List<CarDetails> unmatchedCars = new ArrayList<>();
            List<String> notFoundCars = new ArrayList<>();
            List<CarDetails> outputCars = OutputFileReader.readCars(outputPath);

            for (String reg : registrations)
            {
                CarDetails carDetails = carTaxCheckPage.checkCarDetailsMatching(reg);
                if(outputCars.contains(carDetails)) {
                    matchedCars.add(carDetails);
                }
                else {
                    if(carDetails.registrationNumber.equals(""))
                        {
                            notFoundCars.add(reg);
                        }
                    else
                        {
                            unmatchedCars.add(carDetails);
                        }
                }
            }
            carTaxCheckPage.closeDriver();

            System.out.println("***** Cars that are matched ******");
            for(CarDetails car : matchedCars){
                System.out.println(car);
            }

            System.out.println();
            System.out.println("***** Cars that are unmatched in output file******");
            for(CarDetails car : unmatchedCars){
                System.out.println(car);
            }

            System.out.println();
            System.out.println("***** Cars that are not found in cartaxcheck ******");
            for(String car : notFoundCars){
                System.out.println(car);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
