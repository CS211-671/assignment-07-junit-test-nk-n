package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s1;

    @BeforeEach
    void init(){
        s1 = new Student("6610405905", "nk");
    }

    @DisplayName("Change Name")
    @Test
    void testChangeName(){
        s1.changeName("narakorn");
        assertEquals("narakorn", s1.getName());
        s1.changeName("nrkn");
        assertEquals("nrkn", s1.getName());
        s1.changeName("nk-n");
        assertEquals("nk-n", s1.getName());
        s1.changeName("");
        assertEquals("nk-n", s1.getName());
        s1.changeName("nk");
        assertEquals("nk", s1.getName());
    }

    @DisplayName("Adding Score")
    @Test
    void testAddScore(){
        s1.addScore(40);
        assertEquals(40,s1.getScore());
        s1.addScore(30);
        assertEquals(70,s1.getScore());
        s1.addScore(-10);
        assertEquals(70,s1.getScore());
    }

    @DisplayName("Grade")
    @Test
    void testCalculateGrade(){
        s1.addScore(10);
        assertEquals("F", s1.grade());
        s1.addScore(40);
        assertEquals("D", s1.grade());
        s1.addScore(9);
        assertEquals("D", s1.grade());
        s1.addScore(1);
        assertEquals("C", s1.grade());
        s1.addScore(9);
        assertEquals("C", s1.grade());
        s1.addScore(10);
        assertEquals("B", s1.grade());
        s1.addScore(10);
        assertEquals("A", s1.grade());
    }

    @DisplayName("Check ID")
    @Test
    void testIsId(){
        boolean check = s1.isId(s1.getId());
        assertTrue(check);
    }

    @DisplayName("Check ID - false case")
    @Test
    void testIsIdFalseCase(){
        boolean check = s1.isId("6610450101");
        assertFalse(check);
    }
}