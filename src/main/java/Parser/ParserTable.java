package Parser;

import Course.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParserTable {
    //todo import lib for working with excel
    public static List<StudentScore> parseStudents(List<String[]> data){
        List<StudentScore> studentScores = new ArrayList<>();
        var themeNames = data.get(0);
        var taskNames = data.get(1);
        for (int i = 3; i < data.size(); i++){
            var score = data.get(i);
            var studentScore = new StudentScore(parseCourse("basicprogramming_2",themeNames, taskNames, score));
            studentScore.studentName = data.get(i)[0];
            studentScore.studentGroup = data.get(i)[1];
            studentScores.add(studentScore);
        }
        return studentScores;
    }

        public static StudentScore parseStudent(String[] themeNames, String[] taskNames, String[] scores){
        return new StudentScore(parseCourse("basicprogramming_2",themeNames, taskNames, scores));
    }
    public static Course parseCourse(String filepath, String[] themeNames, String[] taskNames, String[] maxValue){
        Course course = new Course(filepath
                .replaceAll("[^/]+/", "")
                .replaceAll("\\..*", ""));

        course.setThemes(parseThemes(themeNames, taskNames, maxValue));
        return course;
    }

    public static HashMap<String, Theme> parseThemes(String[] themeNames, String[] taskNames, String[] taskValues){
        HashMap<String, Theme> themes = new HashMap<>();
        int themeStartIndex = 0;
        for (int i = 0; i < themeNames.length; i++){
            if (!Objects.equals(themeNames[i], "")){
                if (i != 0){
                    if (themeStartIndex < i){
                        Theme newTheme = new Theme(themeNames[themeStartIndex]);
                        HashMap<String, Task> tasks = parseTask(
                                Arrays.copyOfRange(taskNames, themeStartIndex, i),
                                Arrays.copyOfRange(taskValues, themeStartIndex, i));
                        newTheme.setThemes(tasks);
                        newTheme.pullUp();
                        themes.put(newTheme.getTitle(), newTheme);
                    }
                    themeStartIndex = i;
                }
            }
        }
        return themes;
    }

    public static HashMap<String, Task> parseTask(String[] taskNames, String[] taskValues){
        HashMap<String,Task> tasks = new HashMap<>();
        for (int i = 0; i < taskValues.length; i++){
            try{
                int taskValue = Integer.parseInt(taskValues[i]);
                tasks.put(taskNames[i] ,new Task(taskNames[i], taskValue));
            } catch (Exception e){
                //throw new RuntimeException();
            }
        }
        return tasks;
    }


    public static String[] getArrayFromRow(String rowString){
        List<String> rowList = new ArrayList<>();
        String[] row = rowString.split(",");
        int countEmpty = 0;
        for (int i = 0; i < row.length; i++){
            if (row[i] == null){
                continue;
            }
            if (row[i].contains("\"")){
                int countSymbol = 0;
                for (int j = 0; j < row[i].length();j++){
                    if (row[i].charAt(j) == '\"')
                        countSymbol++;
                }
                if (countSymbol % 2 != 0){
                    int j = 0;
                    while (i+j++ < row.length && !row[i+j].contains("\"")){
                        row[i] = row[i] + "," +row[i+j];
                        row[i+j] = null;
                        countEmpty++;
                    }
                    row[i] = row[i] + "," +row[i+j];
                    rowList.add(row[i]);
                    row[i+j] = null;
                    countEmpty++;
                }
            }
            else{
                rowList.add(row[i]);
            }
        }
        return rowList.toArray(new String[0]);
    }
    public static String getRow(String filePath){
        try {
            var stream = getInputStream(filePath);
            Scanner sc = new Scanner(stream);
            String rows = sc.nextLine();
            return rows;
        } catch (IOException e){
            throw new RuntimeException("Error happens during reading file!", e);
        }
    }
    public static String getRow(String filePath, Integer count){
        try {
            var stream = getInputStream(filePath);
            Scanner sc = new Scanner(stream);
            for (int i = 0; i < count - 1; i++)
                sc.nextLine();
            return sc.nextLine();
        } catch (IOException e){
            throw new RuntimeException("Error happens during reading file!", e);
        }
    }
    private static InputStream getInputStream(String fileName) throws IOException{
        return Files.newInputStream(Paths.get(fileName));
    }
}
