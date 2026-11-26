package org.example.DAO;

import org.example.Model.Student;
import org.example.Service.DataBaseManager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommandDataBase {

    public static final String path = "StudentsPerformance.csv";

    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS studentscsv (id INT AUTO_INCREMENT PRIMARY KEY, gender VARCHAR(10) NOT NULL, race_ethnicity VARCHAR(50), parental_level_of_education VARCHAR(500), " +
                "lunch VARCHAR(50), test_preparation_course VARCHAR(50), math_score int, reading_score int, writing_score int)";
        try (Connection conn = DataBaseManager.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public void sendToDBFromCSV() throws SQLException {
        String importSql = "INSERT into studentscsv(gender, race_ethnicity, parental_level_of_education, lunch, test_preparation_course, math_score, reading_score, writing_score) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))){
            String line;
            br.readLine();
            try (Connection conn = DataBaseManager.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(importSql);){
                while((line = br.readLine()) != null){
                    String[] lineArr = line.split(",");
                    stmt.setString(1, lineArr[0]);
                    stmt.setString(2, lineArr[1]);
                    stmt.setString(3, lineArr[2]);
                    stmt.setString(4, lineArr[3]);
                    stmt.setString(5, lineArr[4]);
                    stmt.setInt(6, Integer.parseInt(lineArr[5].replace("\"", "")));
                    stmt.setInt(7, Integer.parseInt(lineArr[6].replace("\"", "")));
                    stmt.setInt(8, Integer.parseInt(lineArr[7].replace("\"", "")));
                    stmt.executeUpdate();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> checkImportFromCSV(){
        List<Student> student = new ArrayList<>();
        String sql = "SELECT * FROM studentscsv";
        try (Connection conn = DataBaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                student.add(new Student(rs.getInt("id"), rs.getString("gender"), rs.getString("race_ethnicity"), rs.getString("parental_level_of_education"),
                        rs.getString("lunch"), rs.getString("test_preparation_course"), rs.getInt("math_score"), rs.getInt("reading_score"), rs.getInt("writing_score")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }
}
