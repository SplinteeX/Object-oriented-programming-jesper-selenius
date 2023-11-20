package DataStreamsAndExceptions;

import java.io.*;
import java.net.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            List<Double> januaryFirstTemperatures = new ArrayList<>();
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(";");
                if (values[0].startsWith("01.01.2023")) {
                    try {
                        double temperature = Double.parseDouble(values[1].replace(",", "."));
                        januaryFirstTemperatures.add(temperature);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping non-numeric value: " + values[1]);
                    }
                }
            }

            double sum = 0.0;
            for (Double temp : januaryFirstTemperatures) {
                sum += temp;
            }
            double averageTemperature = januaryFirstTemperatures.isEmpty() ? 0.0 : sum / januaryFirstTemperatures.size();

            System.out.println("Average temperature for January 1, 2023: " + averageTemperature);

            reader.close();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}