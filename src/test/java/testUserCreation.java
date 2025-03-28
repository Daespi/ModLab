import com.example.Exceptions.BuildException;
import com.example.Models.User.Entity.User;

public class testUserCreation {
    public static void main(String[] args) {
        try {
            User ash = User.getInstance(
                "", "AshAyala", "Ash", "Grau Ayala", "Abcd1234?", 
                "ashgraunuriacefp@gmail.com", "648293958", "21-03-2025 16:12:00", false
            );

            System.out.println(ash.toString());

            int addressId = 1;
            String address = "Calle Valencia 20 1-1";
            String zipCode = "08014";
            String city = "Barcelona";
            String state = "Catalunya";
            String country = "España";
            int respuesta = ash.setShippingAddresses(addressId, address, zipCode, city, state, country);
            System.out.println("Shipping address set response: " + respuesta);

        } catch (BuildException ex) {
            System.out.println("Error creating user: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
