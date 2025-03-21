import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.Operations.Checker;

public class TestAddress {
    
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
        int result = Checker.verifyAddress("Rocio jurado 27 4");  // Dirección sin calle/avenida
        assertEquals(-1, result, "La dirección debería ser inválida.");
    }
    
    @Test
    void badAddress2() {
        int result = Checker.verifyAddress("");  // Dirección vacía
        assertEquals(-1, result, "La dirección debería ser inválida.");
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
        int result = Checker.verifyAddress("Rocio jurado 27 4");  // Dirección sin calle/avenida
        assertEquals(-1, result, "La dirección debería ser inválida.");
    }
    
    @Test
    void invalidAddress2() {
        int result = Checker.verifyAddress("Calle 1");  // Falta número
        assertEquals(-1, result, "La dirección debería ser inválida.");
    }
    
    @Test
    void invalidAddress3() {
        int result = Checker.verifyAddress("Avenida, 10");  // Falta nombre de la calle
        assertEquals(-1, result, "La dirección debería ser inválida.");
    }
    
    @Test
    void invalidAddress4() {
        int result = Checker.verifyAddress("Calle Gran Vía 125A");  // Falta la coma
        assertEquals(-1, result, "La dirección debería ser inválida.");
    }
    
    @Test
    void invalidAddress5() {
        int result = Checker.verifyAddress("12345, 67");  // No tiene tipo de vía
        assertEquals(-1, result, "La dirección debería ser inválida.");
    }
    


    /*    ZipCode   */

    @Test
void testVerifyZipCode_WhenValidCode_ShouldReturn0() {
    assertEquals(0, Checker.verifyZipCode("28080"));
    assertEquals(0, Checker.verifyZipCode("01001"));
    assertEquals(0, Checker.verifyZipCode("52006"));
}

@Test
void testVerifyZipCode_WhenInvalidProvince_ShouldReturnMinus1() {
    assertEquals(-1, Checker.verifyZipCode("00000")); // provincia 00 no existe
    assertEquals(-1, Checker.verifyZipCode("99000")); // provincia fuera de rango
}

@Test
void testVerifyZipCode_WhenWrongFormat_ShouldReturnMinus1() {
    assertEquals(-1, Checker.verifyZipCode("28A80")); // contiene letra
    assertEquals(-1, Checker.verifyZipCode("1234"));  // menos de 5 cifras
    assertEquals(-1, Checker.verifyZipCode("123456")); // más de 5 cifras
}

@Test
void testVerifyCity_WhenCityIsValid_ShouldReturnZero() {
    assertEquals(0, Checker.verifyCity("Madrid")); // Ciudad válida
}

@Test
void testVerifyCity_WhenCityHasSpecialCharacters_ShouldReturnZero() {
    assertEquals(0, Checker.verifyCity("New York")); // Ciudad válida con espacio
}


@Test
void testVerifyCity_WhenCityIsEmpty_ShouldReturnNegativeTwo() {
    assertEquals(-1, Checker.verifyCity("")); // Cadena vacía
}

@Test
void testVerifyCity_WhenCityContainsNumber_ShouldReturnNegativeTwo() {
    assertEquals(-2, Checker.verifyCity("Madrid123")); // Ciudad con números
}

@Test
void testVerifyCity_WhenCityIsNull_ShouldReturnNegativeTwo() {
    assertEquals(-1, Checker.verifyCity(null)); // Ciudad nula
}

@Test
void testVerifyCity_WhenCityHasMultipleSpaces_ShouldReturnZero() {
    assertEquals(0, Checker.verifyCity("San Francisco")); // Ciudad válida con espacio
}


/*   verifyState */


@Test
void testVerifyState_WhenStateIsNull_ShouldReturnNegativeOne() {
    assertEquals(-1, Checker.verifyState(null)); // Estado nulo
}

@Test
void testVerifyState_WhenStateIsEmpty_ShouldReturnNegativeOne() {
    assertEquals(-1, Checker.verifyState("")); // Estado vacío
}

@Test
void testVerifyState_WhenStateHasSpaces_ShouldReturnNegativeOne() {
    assertEquals(-1, Checker.verifyState("   ")); // Estado con solo espacios
}

@Test
void testVerifyState_WhenStateIsValid_ShouldReturnZero() {
    assertEquals(0, Checker.verifyState("California")); // Estado válido
}

@Test
void testVerifyState_WhenStateHasSpecialCharacters_ShouldReturnNegativeTwo() {
    assertEquals(0, Checker.verifyState("New-York")); // Estado con guión, no válido según la regex
}

@Test
void testVerifyState_WhenStateHasNumbers_ShouldReturnNegativeTwo() {
    assertEquals(-2, Checker.verifyState("Texas1")); // Estado con número, no válido según la regex
}


@Test
void validCountry_SpanishUpperCase() {
    int result = Checker.verifyCountry("España");  
    assertEquals(0, result, "El país debería ser válido.");
}

@Test
void validCountry_SpanishLowerCase() {
    int result = Checker.verifyCountry("españa");  
    assertEquals(0, result, "El país debería ser válido.");
}

@Test
void invalidCountry_EmptyString() {
    int result = Checker.verifyCountry("");  
    assertEquals(-1, result, "El país debería ser inválido.");
}

@Test
void invalidCountry_Null() {
    int result = Checker.verifyCountry(null);  
    assertEquals(-1, result, "El país debería ser inválido.");
}

@Test
void invalidCountry_AnotherCountry() {
    int result = Checker.verifyCountry("Francia");  
    assertEquals(-2, result, "El país debería ser inválido.");
}

@Test
void invalidCountry_CountryWithSpaces() {
    int result = Checker.verifyCountry("España ");  
    assertEquals(-2, result, "El país debería ser inválido debido a los espacios.");
}




}

