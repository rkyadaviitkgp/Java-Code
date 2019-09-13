/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajeshkumar.yadav
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "/Users/rajeshkumar.yadav/Product Modal.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            FileWriter csvWriter = new FileWriter("/Users/rajeshkumar.yadav/new.csv");
            csvWriter.append("contract_count");
            csvWriter.append(",");
            csvWriter.append("service_contract_count");
            csvWriter.append(",");
            csvWriter.append("lease_instance_count");
            csvWriter.append(",");
            csvWriter.append("contract_account_empty");
            csvWriter.append(",");
            csvWriter.append("servoice_contract_account_empty");
            csvWriter.append(",");
            csvWriter.append("contract_asset_M2M_count");
            csvWriter.append(",");
            csvWriter.append("contract_asset_M2M_Totalcount");
            csvWriter.append("\n");

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                if (country[0].length() >= 10) {
                    country[0] = country[0].substring(12);
                }
                if (country.length < 6) {
                    continue;
                }
                
                country[6] = country[6].replace("\"", "");

                List<List<String>> rows = Arrays.asList(
                        Arrays.asList(country[0], country[1], country[2], country[3], country[4], country[5], country[6]));

                for (List<String> rowData : rows) {
                    csvWriter.append(String.join(",", rowData));
                    csvWriter.append("\n");
                }

                //System.out.println("contract_count = " + country[0] + "  service_contract_count = " + country[1] + " lease_instance_count = " + country[2] + "  contract_account_empty  = " + country[3] + "  servoice_contract_account_empty  = " + country[4] + "  contract_asset_M2M_count  = " + country[5] + "  contract_asset_M2M_Totalcount  = " + country[6]);

            }
            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
