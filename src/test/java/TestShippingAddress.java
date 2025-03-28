import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.Exceptions.BuildException;
import com.example.Models.ShippingAddress.Entity.ShippingAddress;
import com.example.Models.User.Entity.User;
import com.example.Operations.Checker;

public class TestShippingAddress {
    
    @Test
    void correctAddress() {  // Método debe ser void
        int result = Checker.verifyAddress("Calle 1, 1");  
        
        assertEquals(0, result, "La dirección no pasó la validación correctamente.");
    }

    @Test
    void correctAddress2() {  // Método debe ser void
        int result = Checker.verifyAddress("Calle Rocas del Pollon, 1 4B");  
        
        assertEquals(0, result, "La dirección no pasó la validación correctamente.");
    }

    @Test
    void badAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Checker.verifyAddress("Rocio jurado 27 4");  
        });

        assertEquals("Dirección inválida", exception.getMessage());
    }

    @Test
    void badAddress2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Checker.verifyAddress("");  
        });

        assertEquals("Dirección inválida", exception.getMessage());
    }

    @Test
    void validAddress1() {
        int result = Checker.verifyAddress("Calle Mayor, 15");
        assertEquals(0, result, "La dirección debería ser válida.");
    }

    @Test
    void validAddress2() {
        int result = Checker.verifyAddress("Av. de la Constitución, 50B");
        assertEquals(0, result, "La dirección debería ser válida.");
    }

    @Test
    void validAddress3() {
        int result = Checker.verifyAddress("Plaza España, 3");
        assertEquals(0, result, "La dirección debería ser válida.");
    }

    @Test
    void validAddress4() {
        int result = Checker.verifyAddress("C/ Gran Vía, 125A");
        assertEquals(0, result, "La dirección debería ser válida.");
    }

    @Test
    void validAddress5() {
        int result = Checker.verifyAddress("Paseo del Prado, 8ºB");
        assertEquals(0, result, "La dirección debería ser válida.");
    }

    @Test
    void invalidAddress1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Checker.verifyAddress("Rocio jurado 27 4");  // Sin calle/avenida
        });
        assertEquals("Dirección inválida", exception.getMessage());
    }

    @Test
    void invalidAddress2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Checker.verifyAddress("Calle 1");  // Falta número
        });
        assertEquals("Dirección inválida", exception.getMessage());
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
            ShippingAddress alex = ShippingAddress.getInstance(0, null, null, null, null, null);
        } catch (BuildException ex){
            assertEquals("", ex.getMessage());
            
        }
        
    }
}

