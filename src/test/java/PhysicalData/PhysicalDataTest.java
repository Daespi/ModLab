package PhysicalData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;

import com.example.Exceptions.BuildException;
import com.example.Models.PhysicalData.Entity.PhysicalData;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PhysicalDataTest {
    private PhysicalData phy;


    @BeforeAll
    void createPhysical(){
        try{
            this.phy = PhysicalData.getInstance(1.0, 0.8, 1.00, 23.50, true);
            System.out.println(phy.toString());
        } catch (BuildException ex){
            ex.getMessage();
        }
    }

        @Test
        void testSetHighCorrect() {
            int result = phy.setHigh(2.0);
            assertEquals(0, result);
        }
    
        @Test
        void testSetHighZero() {
            int result = phy.setHigh(0.0);
            assertEquals(-3, result);
        }
    
        @Test
        void testSetHighNegative() {
            int result = phy.setHigh(-1.0);
            assertEquals(-4, result);
        }
    
        @Test
        void testSetHighTooHigh() {
            int result = phy.setHigh(40.0);
            assertEquals(-5, result);
        }
    
        @Test
        void testSetWidthCorrect() {
            int result = phy.setWidth(1.0);
            assertEquals(0, result);
        }
    
        @Test
        void testSetWidthTooWide() {
            int result = phy.setWidth(2.00);
            assertEquals(-5, result);
        }
    
        @Test
        void testSetLengthCorrect() {
            int result = phy.setLength(1.0);
            assertEquals(0, result);
        }
    
        @Test
        void testSetWeightCorrect() {
            int result = phy.setWeight(25.0);
            assertEquals(0, result);
        }

}
