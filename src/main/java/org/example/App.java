package org.example;

import com.opencsv.bean.CsvBindByPosition;
import ru.reportgen.report.CSVReport;
import ru.reportgen.report.Report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main( String[] args ) {

        AnyObject obj_1 = new AnyObject(1, "Obj_1");
        AnyObject obj_2 = new AnyObject(2, "Obj_2");

        List<AnyObject> objects = new ArrayList<>();
        objects.add(obj_1);
        objects.add(obj_2);

        Map<String, Object> settings = new HashMap<>();
        settings.put("separator", ';');
        settings.put("CSVResultPath", "D:/123.csv");

        Report csv = new CSVReport<>(objects, settings);
        csv.generate();
    }
}

class AnyObject {
    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private String name;

    public AnyObject(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
