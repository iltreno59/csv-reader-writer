package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Division {
    private String name;
    private Map<String, Employer> employers;
    private Employer headOfDivision;
    private List<Employer> employerList = new ArrayList<>();


    public Division(String name, Map<String, Employer> employers, Employer headOfDivision) {
        this.name = name;
        this.employers = employers;
        this.headOfDivision = headOfDivision;
        if (employers != null) {
            for (String key : employers.keySet()) {
                employerList.add(employers.get(key));
                if (employers.get(key).getPosition() == PositionType.HEAD) {
                    this.headOfDivision = employers.get(key);
                }
            }
        }
    }

    public void addEmployer(Employer employer){
        employers.putIfAbsent(employer.getName(), employer);
        employerList.add(employer);
        employer.setDivision(this);
        if (employer.getPosition() == PositionType.HEAD) this.headOfDivision = employer;
    }

    public List<Employer> getEmployerList(){
        return employerList;
    }

    @Override
    public String toString() {
        return this.getName() + ":"
                + "\n" + "Глава отдела: " + this.getHeadOfDivision().getName()
                + "\n" + "Зарплата главы отдела: " + this.getHeadOfDivision().getSalary() * this.getHeadOfDivision().getPosition().getMultiplier()
                + "\n" + "Кол-во сотрудников: " + employerList.size()
                + "\n" + "Средняя зарплата: " + this.getAverageSalary() + "\n";
    }

    private double getAverageSalary(){
        double sum  = 0;
        for(Employer employer: employerList){
            sum += employer.getSalary() * employer.getPosition().getMultiplier();
        }
        return sum / employerList.size();
    }
    public String getName() {
        return name;
    }

    public Employer getHeadOfDivision() {
        return headOfDivision;
    }
}
