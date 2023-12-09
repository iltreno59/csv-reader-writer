package main;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class CSVServiceImpl implements CSVService{
    @Override
    public String[] importFile(String filename) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(filename));
        String[] data = new String[10000];
        int i = 0;
        String line = csvReader.readLine();
        while (line != null) {
            data[i++] = Arrays.toString(line.split(","));
            line = csvReader.readLine();
        }
        csvReader.close();
        return data;
    }

    @Override
    public void exportFile(List<Division> divisionList) throws IOException {
        String fileName = "Service_database_" + LocalDate.now() + ".csv";
        File database = new File(fileName);
        database.createNewFile();

        FileWriter csvWriter = new FileWriter(fileName);

        csvWriter.append("ФИО");
        csvWriter.append(", ");
        csvWriter.append("Должность");
        csvWriter.append(", ");
        csvWriter.append("Зарплата");
        csvWriter.append(", ");
        csvWriter.append("Отдел");
        csvWriter.append("\n");

        List<List<Employer>> data = new ArrayList<>();
        for(Division division: divisionList){
            data.add((division.getEmployerList()));
        }

        for (List<Employer> employerList : data) {
            for(Employer employer: employerList){
                csvWriter.append(employer.getName());
                csvWriter.append(", ");
                csvWriter.append(employer.getPosition().toString());
                csvWriter.append(", ");
                csvWriter.append(Integer.toString(employer.getSalary()*employer.getPosition().getMultiplier()));
                csvWriter.append(", ");
                csvWriter.append(employer.getDivision().getName());
                csvWriter.append("\n");
            }

        }

        csvWriter.flush();
        csvWriter.close();
    }
}
