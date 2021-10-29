import lab1.SumCalculator;
import org.junit.*;

import static org.junit.Assert.*;


public class SumCalculatorTest {
    static SumCalculator sumCalculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass");
        sumCalculator = new SumCalculator();
    }

    @Before
    public void before() {
        System.out.println("@Before");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass");
    }

    @After
    public void after() {
        System.out.println("@After");
    }

    @Test
    public void testInt() {
        System.out.println("Test Int");
        assertEquals(1, sumCalculator.sum(0, 1));
    }

    @Test
    public void testString() {
        System.out.println("Test String");
        assertEquals("TestSomething", sumCalculator.sum("Test", "Something"));
    }

    @Test(expected = NullPointerException.class)
    public void testStringNullPointer() {
        System.out.println("Test NullPointer");
        sumCalculator.sum(null, "test");
    }
}
