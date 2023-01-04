package practice;

import org.junit.jupiter.api.*;



public class Practice8 {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Это метод @BeforeAll");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("Это метод @AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Это метод beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Это метод afterEach");
    }

    @Test
    void firstTest() {
        System.out.println("Это тест 1");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("Это тест 2");
        Assertions.assertTrue(3 > 2);
    }

}
