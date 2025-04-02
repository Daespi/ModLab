import com.example.Exceptions.BuildException;
import com.example.Models.User.Entity.User;

public class testUserCreation {
    public static void main(String[] args) {
       /* try {
            User ash = User.getInstance(
                 "Ash", "Ash", "Grau Ayala", "Abcd134?", 
                "ashgraunuriacefp@gmail.com", "648293958", "21-03-2025 16:12:00", false
            );

            System.out.println(ash.toString());

            String address = "Ronda de Valencia 15";
            String zipCode = "08014";
            String city = "Barcelona";
            String state = "Catalunya";
            String country = "España";
            ArrayList<ShippingAddress> AddressList = new ArrayList<>();
            String respuesta = ash.setShippingAddresses(address, zipCode, city, state, country);
            AddressList.addAll(ash.getShippingAddresses());
            System.out.println("Shipping address set response: " + respuesta);
            System.out.println("Direcciones de envío: " + ash.getShippingAddresses());

            System.out.println(ash.toString());

        } catch (BuildException ex) {
            System.out.println( ex.getMessage());
        }*/

        try {


            System.out.println("\n\n*****   A P P L I C A T I O N    S T A R T E D   *****\n\n");

        User Pau = com.example.Models.User.Entity.User.getInstance("Galssaan-dasc", "Alex-dasc", "SalasGalán", "@Alumnes2024", 
        "alexsalas.nuria@gmail.com", "606665432", "2022-04-25 16:12:53", true);

        System.out.println(Pau.toString());


        System.out.println("\n\n\n*****   - - - - - - - - - - - - - - - - - - - - - - - - - -   *****\n\n");


        User Alex = com.example.Models.User.Entity.User.getInstance("Alquimista-curioso33", "Alex-dasc", "SalasGalán", "@Alumnes2024", 
        "alexsalas.nuria@gmail.com", "906654323", "2022-04-25 16:12:53", true);

        System.out.println(Alex.toString());


        System.out.println("\n\n\n*****   A P P L I C A T I O N    E N D E D   *****\n\n\n");
    }
    catch (BuildException ex) {
        System.out.println( ex.getMessage());
    }
    }
}