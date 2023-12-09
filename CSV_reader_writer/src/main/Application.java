package main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        Division division_1 = new Division("Отдел продаж", new HashMap<>(), null);
        Division division_2 = new Division("Креативный отдел", new HashMap<>(), null);
        Division division_3 = new Division("Деловой отдел", new HashMap<>(), null);

        Employer employer_1 = new Employer("Кашкин Евгений Владимирович", 100000, PositionType.MANAGER);
        Employer employer_2 = new Employer("Иванова Ирина Алексеевна", 125000, PositionType.HEAD);
        Employer employer_3 = new Employer("Ксенофонтов Николай Валерьевич", 75000, PositionType.WORKER);
        Employer employer_4 = new Employer("Филатов Вячеслав Валерьевич", 100000, PositionType.HEAD);
        Employer employer_5 = new Employer("Выборнов Александр Николаевич", 70000, PositionType.WORKER);
        Employer employer_6 = new Employer("Садыков Ильдар Венерович", 150000, PositionType.MANAGER);
        Employer employer_7 = new Employer("Падалец Александр Александрович", 50000, PositionType.SALER);
        Employer employer_8 = new Employer("Смирнов Михаил Вячеславович", 80000, PositionType.HEAD);
        Employer employer_9 = new Employer("Кухтина Яна Валерьевна", 50000, PositionType.WORKER);

        division_1.addEmployer(employer_1);
        division_1.addEmployer(employer_2);
        division_1.addEmployer(employer_3);

        division_2.addEmployer(employer_4);
        division_2.addEmployer(employer_5);
        division_2.addEmployer(employer_6);

        division_3.addEmployer(employer_7);
        division_3.addEmployer(employer_8);
        division_3.addEmployer(employer_9);

        List<Division> company = new ArrayList<>();
        company.add(division_1);
        company.add(division_2);
        company.add(division_3);

        CSVServiceImpl csvService = new CSVServiceImpl();
        csvService.exportFile(company);

        String[] employersList = csvService.importFile("Service_database_" + LocalDate.now() + ".csv");
        for(String employer: employersList){
            if (employer == null) break;
            System.out.println(employer);
        }

        System.out.println("\n" + "Информация об отделах:" + "\n");
        System.out.println(division_1);
        System.out.println(division_2);
        System.out.println(division_3);
    }
}
