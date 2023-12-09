package main;

import java.io.IOException;
import java.util.List;

public interface CSVService {
    public String[] importFile(String filename) throws IOException;
    public void exportFile(List<Division> divisionList) throws IOException;
}
