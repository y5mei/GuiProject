import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class readData {
    public static TimeSeries createTSData(String file) {
        TimeSeries s1 = new TimeSeries(file, Month.class);
        String filename = file;
        int month;
        int year;
        Double openPrice;
        String date;

        try {
            Scanner scan = new Scanner(new File(filename));
            //Excepate the header
            scan.nextLine();
            scan.nextLine();
            while (scan.hasNextLine()) {
                String[] sepstr = scan.nextLine().split(",");
                String[] datetime = sepstr[0].split("-");
                year = Integer.parseInt(datetime[0]);
                month = Integer.parseInt(datetime[1]);
                openPrice = Double.parseDouble(sepstr[1]);
                s1.addOrUpdate(new Month(month, year), openPrice);
                // Verify data is being collected
//                System.out.println(year + "///" + month + "///" + openPrice);

            }
            scan.close();


        } catch (IOException e) {
            System.out.println("the input got a error " + e);
        }
        return s1;

    }

    public static void main(String[] args) {
        createTSData("AMZN.csv");


    }
}
