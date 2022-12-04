package Repos;

import com.example.javaproject.Student;
import com.example.javaproject.StudentRepository;

import java.sql.*;

public class DbManager {
    public DbManager(StudentRepository repository){
        this.repository = repository;
    }
    private StudentRepository repository;
    static final String DB_URL = "jdbc:postgresql://192.168.1.2:3306/postgres";
    static final String USER = "postgres";
    static final String PASS = "mysecretpassword";

    public static void main(String[] args) {
        try {
        }
        catch (Exception e)
        {}
    }

    public void foo(){
        repository.save(new Student());
    }

    public static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path");
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("unreacheble database");
        }
        return dbConnection;
    }

//    public static void createDbScoreTable(Course course) throws SQLException {
//        Connection dbConnection = null;
//        Statement statement = null;
//
//        String createTableSQL =
//                String.format("CREATE TABLE %s(", course.getTitle())
//                + "\"Фамилия Имя\" VARCHAR(50) NOT NULL, "
//                + "Группа VARCHAR(50),";
//
////        var createThemesTables = new ArrayList<>();
////        for (var theme:course.getThemes().values()){
////            if (Objects.equals(theme.getTitle(), "") || theme.getTasks().values().size() == 0)
////                continue;
////            String createThemeTable = String.format("CREATE TABLE \"%s\"(", theme.getTitle());
////            for (var task:theme.getTasks().values()){
////
////                createThemeTable = createThemeTable
////                        + String.format("\"%s\" INT,", task.getTitle());
////            }
////            createThemeTable = createThemeTable.substring(0, createThemeTable.length() - 1) +
////            ")";
////            createThemesTables.add(createThemeTable);
//        }
////                createTableSQL = createTableSQL.replaceAll(":", "_");
////                createTableSQL = createTableSQL.replaceAll(" ", "_");
////        createTableSQL = createTableSQL.substring(0, createTableSQL.length() - 1) +
////                    ")";
//
//        try {
//            dbConnection = getDBConnection();
//
//            for (var sql:createThemesTables){
//                statement = dbConnection.createStatement();
//                statement.execute((String) sql);
//            }
//
//            // выполнить SQL запрос
//            System.out.println("Table \"dbuser\" is created!");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//            if (dbConnection != null) {
//                dbConnection.close();
//            }
//        }
//    }

}
