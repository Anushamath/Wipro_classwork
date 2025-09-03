package wipro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Logintest {
	
	static Login login;

    @BeforeAll
    public static void setup() {
        System.out.println("Starting Login Tests...");
        login = new Login(); // Create the object before all tests
    }

    @AfterAll
    public static void teardown() {
        System.out.println("All tests completed.");
    }

    @Test
    public void testValidLogin() {
        assertTrue(login.validateLogin("admin", "1234"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(login.validateLogin("user", "1234"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(login.validateLogin("admin", "wrong"));
    }

    @Test
    public void testEmptyCredentials() {
        assertFalse(login.validateLogin("", ""));
    }

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
