import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.Exceptions.BuildException;
import com.example.Models.ShippingAddress.Entity.ShippingAddress;
import com.example.Operations.Checker;

public class TestShippingAddress {
    
    @Test
    void invalidAddress1() {
        int result = Checker.verifyAddress("Gran Vía, 10"); // Falta el tipo de vía
        assertEquals(-16, result);
    }
    
    @Test
    void invalidAddress2() {
        int result = Checker.verifyAddress("Calle Mayor 10"); // Falta la coma antes del número
        assertEquals(0, result);
    }
    
    @Test
    void invalidAddressWithSpecialChar(){
        int result = Checker.verifyAddress("Calle 1 @ ");
        assertEquals(-16, result);
    }
    @Test
    void invalidAddressWithSpecialCharAndNegative(){
        int result = Checker.verifyAddress("Calle 1 @ -2");
        assertEquals(-16, result);
    }

    @Test
    void correctAddressWithNegative(){
        int result = Checker.verifyAddress("Calle -2");
        assertEquals(0, result);
    }

    @Test
    void correctAddressWithLong(){
        int result = Checker.verifyAddress("Calle Del Españolisimo Español de España grande de Imperio Español ESPAÑOL");
        assertEquals(0, result);
    }

    @Test
    void invalidAddress3() {
        int result = Checker.verifyAddress("Calle 123, 10"); // Nombre de calle no válido
        assertEquals(0, result);
    }
    
    @Test
    void invalidAddress4() {
        int result = Checker.verifyAddress("Avenida,, 45B"); // Coma doble sin nombre de calle
        assertEquals(-16, result);
    }
    
    @Test
    void invalidAddress5() {
        int result = Checker.verifyAddress("Paseo"); // Falta número y detalles
        assertEquals(-16, result);
    }
    
    @Test
    void invalidAddress6() {
        int result = Checker.verifyAddress("Calle/ Serrano, 7"); // Barra incorrecta en el tipo de vía
        assertEquals(-16, result);
    }
    
    @Test
    void invalidAddress7() {
        int result = Checker.verifyAddress("123 Calle Mayor, 10"); // Número antes del tipo de vía
        assertEquals(-16, result);
    }
    
    @Test
    void validAddress1() {
        int result = Checker.verifyAddress("Calle Gran Vía, 25"); // Dirección válida
        assertEquals(0, result);
    }
    
    @Test
    void validAddress2() {
        int result = Checker.verifyAddress("Av. de la Constitución, 5B"); // Dirección válida
        assertEquals(0, result);
    }
    
    @Test
    void validAddress3() {
        int result = Checker.verifyAddress("Paseo del Prado, 3"); // Dirección válida
        assertEquals(0, result);
    }
    
    @Test
    void validAddress4() {
        int result = Checker.verifyAddress("C/ Serrano, 7"); // Dirección válida
        assertEquals(0, result);
    }
    
    @Test
    void validAddress5() {
        int result = Checker.verifyAddress("Plaza Mayor, 5"); // Dirección válida
        assertEquals(0, result);
    }
    
    @Test
    void validAddress6() {
        int result = Checker.verifyAddress("Camino Real, 15C"); // Dirección válida
        assertEquals(0, result);
    }
    
    @Test
    void validAddress7() {
        int result = Checker.verifyAddress("Carretera de Burgos, 22"); // Dirección válida
        assertEquals(0, result);
    }
    
    



    @Test
    void tryAddress(){
        try{
            ShippingAddress alex = ShippingAddress.getInstance(null, null, null, null, null);
        } catch (BuildException ex){
            assertEquals("La dirección no es correcta porque no puede dejarse en blanco.El código postal no es correcto porque no puede dejarse en blanco.La ciudad no es correcta porque no puede dejarse en blanco.La comunidad autónoma no es correcta porque no puede dejarse en blanco.La comunidad autónoma no es correcta porque no puede dejarse en blanco.", ex.getMessage());
            
        }
        
    }

}

