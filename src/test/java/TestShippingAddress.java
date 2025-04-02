import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.Exceptions.BuildException;
import com.example.Models.ShippingAddress.Entity.ShippingAddress;
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
        assertEquals(-16, result);
    }

    @Test
    void invalidAddress3() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Checker.verifyAddress("Avenida, 10");  // Falta nombre de la calle
        });
        assertEquals("Dirección inválida", exception.getMessage());
    }

    @Test
    void invalidAddress4() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Checker.verifyAddress("Calle Gran Vía 125A");  // Falta la coma
        });
        assertEquals("Dirección inválida", exception.getMessage());
    }

    @Test
    void invalidAddress5() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Checker.verifyAddress("12345, 67");  // No tiene tipo de vía
        });
        assertEquals("Dirección inválida", exception.getMessage());
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

