package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList studentList;
    @BeforeEach
    void init(){
        studentList = new StudentList();
    }

    @DisplayName("Should be able to add student")
    @Test
    void testAddStudentBySize(){
        studentList.addNewStudent("6610400001", "first");
        assertEquals(1, studentList.getStudents().size());
        studentList.addNewStudent("6610400002", "second");
        studentList.addNewStudent("6610400003", "third");
        assertEquals(3, studentList.getStudents().size());
        studentList.addNewStudent("6610400004", "fourth", 20);
        assertEquals(4, studentList.getStudents().size());
    }

    @DisplayName("Added Student should contain the same info as the parameter")
    @Test
    void testAddStudentByInfo(){
        studentList.addNewStudent("6610400001", "first");
        studentList.addNewStudent("6610400002", "second", 60);
        String s1Name = studentList.getStudents().get(0).getName();
        String s1Id = studentList.getStudents().get(0).getId();
        double s1Score = studentList.getStudents().get(0).getScore();
        assertEquals("first", s1Name);
        assertEquals("6610400001", s1Id);
        assertEquals(0, s1Score);
        String s2Name = studentList.getStudents().get(1).getName();
        String s2Id = studentList.getStudents().get(1).getId();
        double s2Score = studentList.getStudents().get(1).getScore();
        assertEquals("second", s2Name);
        assertEquals("6610400002", s2Id);
        assertEquals(60, s2Score);
    }

    @DisplayName("Should be able to find student by ID")
    @Test
    void testFindStudentById(){
        studentList.addNewStudent("6610400001", "first");
        studentList.addNewStudent("6610400002", "second", 60);
        studentList.addNewStudent("6610400003", "third", 20);
        Student foundStudent = studentList.findStudentById("6610400002");
        assertEquals("second", foundStudent.getName());
        assertEquals("6610400002", foundStudent.getId());
        assertEquals(60, foundStudent.getScore());

        foundStudent = studentList.findStudentById("6610400001");
        assertEquals("first", foundStudent.getName());
        assertEquals("6610400001", foundStudent.getId());
        assertEquals(0, foundStudent.getScore());
    }

    @DisplayName("Should be able to give score to specific student")
    @Test
    void tesGiveScoreToId(){
        studentList.addNewStudent("6610400001", "first");
        studentList.addNewStudent("6610400002", "second", 60);
        studentList.addNewStudent("6610400003", "third", 20);
        studentList.giveScoreToId("6610400001", 27);
        assertEquals(27, studentList.getStudents().get(0).getScore());
        studentList.giveScoreToId("6610400002", 19);
        assertEquals(79, studentList.getStudents().get(1).getScore());
        studentList.giveScoreToId("6610400003", 0);
        assertEquals(20, studentList.getStudents().get(2).getScore());
    }

    @DisplayName("Should be able to view grade of specific student")
    @Test
    void tesViewGradeOfId(){
        studentList.addNewStudent("6610400001", "first");
        studentList.addNewStudent("6610400002", "second", 60);
        studentList.addNewStudent("6610400003", "third", 73);
        studentList.addNewStudent("6610400004", "fourth", 79);
        assertEquals("F", studentList.getStudents().get(0).grade());
        assertEquals("C", studentList.getStudents().get(1).grade());
        assertEquals("B", studentList.getStudents().get(2).grade());
        assertEquals("B", studentList.getStudents().get(3).grade());
    }
}