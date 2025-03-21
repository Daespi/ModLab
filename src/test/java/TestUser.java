import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.Exceptions.BuildException;
import com.example.Models.User.User;

public class TestUser {
    private User ash;
    
        @BeforeAll
        void createUser (){
            try{
                this.ash = User.getInstance("", "AshAyala", "Ash", "Grau Ayala", "Abcd1234?", 
            "ashgraunuriacefp@gmail.com", "648293958", "21/03/2025 16:12:00", false);
        } catch (BuildException ex){
            ex.getMessage();
        }
    }

    @Test
    void testNullId (){
        int result = ash.setUserId(null);
        assertEquals(0, result);
    }

    @Test
    void testBlankId (){
        int result = ash.setUserId("");
        assertEquals(0, result);
    }

    @Test
    void testSomethingId (){
        int result = ash.setUserId("adaasasa");
        assertEquals(-21, result);
    }

    @Test
    void testUsernameValid (){
        int result = ash.setUsername("AshGrau");
        assertEquals(0, result);
    }

    @Test
    void testUsernameTooShort(){
        int result = ash.setUsername("A");
        assertEquals(-2, result);
    }

    @Test
    void testUsernameTooLong(){
        int result = ash.setUsername("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        assertEquals(-10, result);
    }

    @Test
    void testUsernameNull(){
        int result = ash.setUsername(null);
        assertEquals(-1, result);
    }

    @Test
    void testUsernameBlank(){
        int result = ash.setUsername("          ");
        assertEquals(-1, result);
    }

    @Test
    void testFirstNameGood (){
        int result = ash.setFirstName("David");
        assertEquals(0, result);
    }
}




