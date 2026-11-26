package org.example.DAO;

import org.example.Model.Student;
import org.example.Service.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAOImpl implements StudentsDAO {

    public List<Student> getAllStudents() {
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

    public List<Student> getAllStudentsWithHighestScores(int score) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM studentscsv WHERE math_score >= ?";
        try (Connection conn = DataBaseManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, score);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    students.add(new Student(rs.getInt("id"), rs.getString("gender"), rs.getString("race_ethnicity"), rs.getString("parental_level_of_education"),
                            rs.getString("lunch"), rs.getString("test_preparation_course"), rs.getInt("math_score"), rs.getInt("reading_score"), rs.getInt("writing_score")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public List<Student> getAllOneGenderStudents(String genderType) {
        List<Student> students = new ArrayList<>();
        //String sql = "SELECT * FROM studentscsv where gender = ?";
        String sql = "SELECT * FROM studentscsv WHERE LOWER(TRIM(gender)) = LOWER(?)";
        try (Connection conn = DataBaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, genderType);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    students.add(new Student(rs.getInt("id"), rs.getString("gender"), rs.getString("race_ethnicity"), rs.getString("parental_level_of_education"),
                            rs.getString("lunch"), rs.getString("test_preparation_course"), rs.getInt("math_score"), rs.getInt("reading_score"), rs.getInt("writing_score")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
