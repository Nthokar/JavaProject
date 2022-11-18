import Course.Task;
import Parser.ParserTable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ParserTable.getRow("data/basicprogramming_2.csv");

        Path path = Path.of("data/basicprogramming_2.tsv");
//        List<String[]> data = Files.readAllLines(path, StandardCharsets.UTF_8).stream().map(ParserTable::getArrayFromRow).toList();
        List<String[]> data = Files.readAllLines(path, StandardCharsets.UTF_8).stream().map(list-> list.split("\t", -1)).toList();

        var course = ParserTable.parseCourse("data/basicprogramming_2.csv", data.get(0), data.get(1), data.get(2));
        var scores = ParserTable.parseStudents(data);
        var themes = course.getThemes();

        try {
            DbManager.createDbScoreTable(course);
        }
        catch (Exception e){
            System.out.println("something wrong");
        }
    }
}