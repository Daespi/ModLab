import com.example.Exceptions.BuildException;
import com.example.Models.User.User;

public class testUserCreation {
    public static void main(String[] args) {
        try{
            User ash = User.getInstance("", "AshAyala", "Ash", "Grau Ayala", "Abcd1234?", 
            "ashgraunuriacefp@gmail.com", "648293958", "21/03/2025 16:12:00", false);
        } catch (BuildException ex){
            ex.getMessage();
        }
    }
    
}
