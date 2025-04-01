import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.Exceptions.BuildException;
import com.example.Models.User.ShippingAddress;
import com.example.Models.User.User;
import com.example.Operations.Checker;

public class TestShippingAddress {
    
    @Test
    void correctAddress() { 
        int result = Checker.verifyAddress("Calle 1, 1");  
        
        assertEquals(0, result, "La dirección no pasó la validación correctamente.");
    }

    @Test
    void correctAddress2() { 
        int result = Checker.verifyAddress("Calle Rocas del Pollon, 1 4B");  
        
        assertEquals(0, result, "La dirección no pasó la validación correctamente.");
    }

    @Test
    void badAddress() {
        int result = Checker.verifyAddress("Rocio jurado 27 4");  
        assertEquals(-16, result);
    }

    @Test
    void badAddress2() {
        int result = Checker.verifyAddress("");  
        assertEquals(-1, result);
    }

    @Test
    void invalidAddress1() {
        int result = Checker.verifyAddress("Rocio jurado 27 4");  // Sin calle/avenida
        assertEquals(-16, result);
    }

    @Test
    void invalidAddress2() {
        int result = Checker.verifyAddress("Calle 1");  // Falta número
        assertEquals(0, result);
    }

    

    @Test
    void tryAddress(){
        try{
            ShippingAddress alex = ShippingAddress.getInstance(null, null, null, null, null);
        } catch (BuildException ex){
            assertEquals("", ex.getMessage());
            
        }
        
    }
}