import Course.Student;
import Parser.ParserTable;
import Repos.DbManager;
import com.vk.api.sdk.objects.users.responses.SearchResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("src/data/basicprogramming_2.tsv");
//        List<String[]> data = Files.readAllLines(path, StandardCharsets.UTF_8).stream().map(ParserTable::getArrayFromRow).toList();
        List<String[]> data = Files.readAllLines(path, StandardCharsets.UTF_8).stream().map(list-> list.split("\t", -1)).toList();

        var course = ParserTable.parseCourse("data/basicprogramming_2.csv", data.get(0), data.get(1), data.get(2));
        var scores = ParserTable.parseStudents(data);
        var themes = course.getThemes();
        ArrayList<Student> students = new ArrayList<Student>();

        VkManager vkManager = null;
        try{
            vkManager = new VkManager("RU", "Екатеринбург", "УРФУ");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        if (vkManager == null)
            throw new RuntimeException();

//        for (Course.StudentScore score : scores) {
//            var student = new Student();
//            student.scores.add(score);
//            student.setName(score.studentName);
//            SearchResponse userInfo;
//            try{
//                userInfo = vkManager.SearchUser(student.getName());
//                student = vkManager.parseVkUserToStudent(student, userInfo.getItems().get(0));
//            }
//            catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//            students.add(student);
//        }
    }
}