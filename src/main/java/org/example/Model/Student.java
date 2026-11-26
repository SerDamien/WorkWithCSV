package org.example.Model;

public class Student {

    int id;
    String gender;
    String race_ethnicity;
    String parental_level_of_education;
    String lunch;
    String test_preparation_course;
    int math_score;
    int reading_score;
    int writing_score;

    public Student(String gender, String race_ethnicity, String parental_level_of_education, String lunch, String test_preparation_course, int math_score, int reading_score, int writing_score) {
        this.gender = gender;
        this.race_ethnicity = race_ethnicity;
        this.parental_level_of_education = parental_level_of_education;
        this.lunch = lunch;
        this.test_preparation_course = test_preparation_course;
        this.math_score = math_score;
        this.reading_score = reading_score;
        this.writing_score = writing_score;
    }

    public Student(int id, String gender, String race_ethnicity, String parental_level_of_education, String lunch, String test_preparation_course, int math_score, int reading_score, int writing_score) {
        this.id = id;
        this.gender = gender;
        this.race_ethnicity = race_ethnicity;
        this.parental_level_of_education = parental_level_of_education;
        this.lunch = lunch;
        this.test_preparation_course = test_preparation_course;
        this.math_score = math_score;
        this.reading_score = reading_score;
        this.writing_score = writing_score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", race_ethnicity='" + race_ethnicity + '\'' +
                ", parental_level_of_education='" + parental_level_of_education + '\'' +
                ", lunch='" + lunch + '\'' +
                ", test_preparation_course='" + test_preparation_course + '\'' +
                ", math_score=" + math_score +
                ", reading_score=" + reading_score +
                ", writing_score=" + writing_score +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace_ethnicity() {
        return race_ethnicity;
    }

    public void setRace_ethnicity(String race_ethnicity) {
        this.race_ethnicity = race_ethnicity;
    }

    public String getParental_level_of_education() {
        return parental_level_of_education;
    }

    public void setParental_level_of_education(String parental_level_of_education) {
        this.parental_level_of_education = parental_level_of_education;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getTest_preparation_course() {
        return test_preparation_course;
    }

    public void setTest_preparation_course(String test_preparation_course) {
        this.test_preparation_course = test_preparation_course;
    }

    public int getMath_score() {
        return math_score;
    }

    public void setMath_score(int math_score) {
        this.math_score = math_score;
    }

    public int getReading_score() {
        return reading_score;
    }

    public void setReading_score(int reading_score) {
        this.reading_score = reading_score;
    }

    public int getWriting_score() {
        return writing_score;
    }

    public void setWriting_score(int writing_score) {
        this.writing_score = writing_score;
    }
}
