import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.example.Exceptions.BuildException;
import com.example.Models.User.Entity.User;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) 
public class TestUser {
    private User ash;
    
    @BeforeAll
    void createUser (){
        try{
            this.ash = User.getInstance( "AshAyala", "Ash", "Grau Ayala", "Abcd1234?", 
            "ashgraunuriacefp@gmail.com", "648293958", "21-03-2025 16:12:00", false);
        } catch (BuildException ex){
            ex.getMessage();
        }
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

    @Test
    void testFirstNameNull (){
        int result = ash.setFirstName(null);
        assertEquals(-1, result);
    }

    @Test
    void testFirstNameBlank (){
        int result = ash.setFirstName("     ");
        assertEquals(-1, result);
    }

    @Test
    void testFirstNameShort(){
        int result = ash.setFirstName("Da");
        assertEquals(-2, result);
    }

    @Test
    void testFirstNameLong(){
        int result = ash.setFirstName("Daaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        assertEquals(-10, result);
    }

    @Test
    void testLastNameGood(){
        int result = ash.setLastName("Grau Ayala");
        assertEquals(0, result);
    }

    @Test
    void testLastNameShort(){
        int result = ash.setLastName("A");
        assertEquals(-2, result);
    }

    @Test
    void testLastNameLong(){
        int result = ash.setLastName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        assertEquals(-10, result);
    }

    @Test
    void testLastNameBlank(){
        int result = ash.setLastName("     ");
        assertEquals(-1, result);
    }

    @Test
    void testLastNameNull(){
        int result = ash.setLastName(null);
        assertEquals(-1, result);
    }

    @Test
    void testPasswordGood(){
        int result = ash.setPasswordHash("Abcd1234?");
        assertEquals(0, result);
    }

    @Test
    void testPasswordNull(){
        int result = ash.setPasswordHash(null);
        assertEquals(-1, result);
    }


    @Test
    void testPasswordBlank(){
        int result = ash.setPasswordHash("     ");
        assertEquals(-1, result);
    }

    @Test
    void tryClient(){
        try{
            User David = User.getInstance(
                "AshGrau", "Ash", "Grau Ayala", "Abcd1234?", 
                "ashgraunuriacefp@gmail.com", "648293958", "21-03-2025 16:12:00", false
            );
        } catch (BuildException ex){
            assertEquals("", ex.getMessage());
            
        }
        
    }

}

