package ku.cs.models;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    UserList userList;

    @BeforeEach
    void init(){
        userList = new UserList();
    }

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        userList.addUser("user01", "normalUserpassword@");
        userList.addUser("user02", "ijijij0009");
        userList.addUser("superuser", "admin");
        // TODO: find one of them
        User user = userList.findUserByUsername("user02");
        // TODO: assert that UserList found User
         String expected = "user02";
         String actual = user.getUsername();
         assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        userList.addUser("user01", "normalUserpassword@");
        userList.addUser("user02", "ijijij0009");
        userList.addUser("superuser", "admin");
        // TODO: change password of one user
        boolean changed = userList.changePassword("superuser", "admin", "moreSecurePass0@_");
        // TODO: assert that user can change password
        assertTrue(changed);
        User user = userList.findUserByUsername("superuser");
        boolean actual = user.validatePassword("moreSecurePass0@_");
        assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        userList.addUser("user01", "normalUserpassword@");
        userList.addUser("user02", "ijijij0009");
        userList.addUser("superuser", "admin");
        // TODO: call login() with correct username and password
        User currentUser = userList.login("superuser", "admin");
        // TODO: assert that User object is found
        String username = currentUser.getUsername();
        assertEquals("superuser", username);
        BCrypt.Result check = BCrypt.verifyer().verify("admin".toCharArray(), currentUser.getPassword());
        assertTrue(check.verified);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        userList.addUser("user01", "normalUserpassword@");
        userList.addUser("user02", "ijijij0009");
        userList.addUser("superuser", "admin");
        // TODO: call login() with incorrect username or incorrect password
        User currentUser = userList.login("user01", "admin");
        // TODO: assert that the method return null
         assertNull(currentUser);
    }

}