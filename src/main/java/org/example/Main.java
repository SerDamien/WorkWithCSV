package org.example;

import org.example.DAO.CommandDataBase;
import org.example.Model.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        CommandDataBase commandDataBase = new CommandDataBase();

        List<Student> students = new ArrayList<>();

        commandDataBase.createTable();
        commandDataBase.sendToDBFromCSV();
        students = commandDataBase.checkImportFromCSV();
        for (Student student : students) {
            System.out.println(student.toString());
        }

        }
    }
