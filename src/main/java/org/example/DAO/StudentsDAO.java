package org.example.DAO;

import org.example.Model.Student;

import java.util.List;

public interface StudentsDAO {
    public List<Student> getAllStudentsWithHighestScores(int score);
    public List<Student> getAllStudents();
    public List<Student> getAllOneGenderStudents(String gender);

}
