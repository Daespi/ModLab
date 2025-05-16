

// import com.example.Exceptions.BuildException;
// import com.example.Models.User.ShippingAddress;
// import com.example.Models.User.User;

// public class TestUserCreation {
//     public static void main(String[] args) {
//         try {
//             User ash = User.getInstance(
//                  "Ash", "Ash", "Grau Ayala", "Abcd134?", 
//                 "ashgraunuriacefp@gmail.com", "648293958", "21-03-2025 16:12:00", false
//             );

// public class testUserCreation {
//     public static void main(String[] args) {
//         try {
//             User ash = User.getInstance(
//                  "Ash", "Ash", "Grau Ayala", "Abcd134?", 
//                 "ashgraunuriacefp@gmail.com", "648293958", false
//             );

//             System.out.println(ash.toString());

//             String address = "Ronda de Valencia 15";
//             String zipCode = "08014";
//             String city = "Barcelona";
//             String state = "Catalunya";
//             String country = "España";
//             ArrayList<ShippingAddress> AddressList = new ArrayList<>();
//             String respuesta = ash.setShippingAddresses(address, zipCode, city, state, country);
//             AddressList.addAll(ash.getShippingAddresses());
//             System.out.println("Shipping address set response: " + respuesta);
//             System.out.println("Direcciones de envío: " + ash.getShippingAddresses());

//             System.out.println(ash.toString());

//         } catch (BuildException ex) {
//             System.out.println( ex.getMessage());


//         }

//         try {

//         User alex = User.getInstance("Galsaan", "Alex", "Salas Galán", "!Alumnes2024", 
//         "alexsalas.nuria@gmail.com", "606665432", true);

//         System.out.println(alex.toString());

//     }
//     catch (BuildException ex) {
//         System.out.println( ex.getMessage());
//     }
//     }
// }