package Parser;

import Course.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParserTable {
//todo import lib for working with excel
    public void parseCourse(){
        throw new RuntimeException();
    }

    public void parseTheme(String[] themeNames, String[] taskNames, String[] taskValues){
        List<Theme> themes = new ArrayList<>();
        int themeStartIndex = 0;
        int themeEndIndex = 0;
        for (int i = 0; i < themeNames.length; i++){
            if (themeNames[i] != null){
                themeStartIndex = themeEndIndex;
                themeEndIndex = i;
                if (themeStartIndex > themeEndIndex){
                    Theme newTheme = new Theme(themeNames[themeStartIndex], Integer.parseInt(taskValues[themeStartIndex + 1]));
                    HashMap<String, Exercise> tasks = parseTask(
                            Arrays.copyOfRange(themeNames, themeStartIndex, themeEndIndex),
                            Arrays.copyOfRange(taskValues, themeStartIndex, themeEndIndex));
                    newTheme.setCollection(tasks);
                }
            }
        }
    }
    public static HashMap<String, Exercise> parseTask(String[] taskNames, String[] taskValues){
        HashMap<String,Exercise> tasks = new HashMap<String,Exercise>();
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
