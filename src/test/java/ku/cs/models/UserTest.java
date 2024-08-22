package ku.cs.models;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }

    @DisplayName("Password must be changeable")
    @Test
    void testSetPassword(){
        User user = new User("user01", "123");
        user.setPassword("1234");
        BCrypt.Result check = BCrypt.verifyer().verify("1234".toCharArray(), user.getPassword());
        assertTrue(check.verified);
        user.setPassword("a&28*az_223llsc");
        check = BCrypt.verifyer().verify("a&28*az_223llsc".toCharArray(), user.getPassword());
        assertTrue(check.verified);
    }

    @DisplayName("Check Username")
    @Test
    void testIsUsername(){
        User user = new User("student5905", "superSecurePas$word");
        boolean check = user.isUsername("student5905");
        assertTrue(check);
    }

    @DisplayName("Check Username - should not equal")
    @Test
    void testIsUsernameNotEqual(){
        User user = new User("student5905", "superSecurePas$word");
        boolean check = user.isUsername("TA135");
        assertFalse(check);
    }
}