import com.example.Exceptions.BuildException;
import com.example.Models.User.User;

public class TestUser {
    public static void main(String[] args) {
        try {

            User ash = User.getInstance("", "AshAyala", "Ash", "Grau Ayala", "abcA3164?", "ashgraunuriacefp@gmail.com",
                    "649918345", "19-03-2025 16:45:00", false);

            ash.toString();

        } catch (BuildException ex) {
            System.out.println("Error al crear un objeto User: " + ex.getMessage());
        }
    }
}
