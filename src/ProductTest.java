import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Product("P001", "Laptop", "High-performance laptop", 999.99);
    }

    @Test
    public void testGetName() {
        assertEquals("Laptop", product.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals("High-performance laptop", product.getDescription());
    }

    @Test
    public void testGetID() {
        assertEquals("P001", product.getID());
    }

    @Test
    public void testGetCost() {
        assertEquals(999.99, product.getCost(), 0.001);
    }

    @Test
    public void testToCSVDataRecord() {
        String expectedCSV = "P001,Laptop,High-performance laptop,999.99";
        assertEquals(expectedCSV, product.toCSVDataRecord());
    }
}
