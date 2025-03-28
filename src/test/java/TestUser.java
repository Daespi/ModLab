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
        int result = ash.setFirstName("Espinosa");
        assertEquals(0, result);
    }

    @Test
    void tryClient(){
        try{
            User David = User.getInstance(
                "", "SSSSSSSS", "Ash", "G", "Abcd1234?", 
                "ashgraunuriacefp@gmail.com", "648293958", "21-03-2025 16:12:00", false
            );
        } catch (BuildException ex){
            assertEquals("", ex.getMessage());
            
        }
        
    }

    
}




