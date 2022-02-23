package com.trachoma.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author trachoma
 * @create 2022-02-23 13:59
 */
@Slf4j
@DisplayName("junit5功能测试")
//@SpringBootTest
public class Junit5Test {

    @Test
    @DisplayName("前置条件")
    void testAssumptions() {
        Assumptions.assumeTrue(false, "结果不是true");
        log.info("123");
    }

    @Test
    @DisplayName("测试简单断言")
    void testSimpleAssertions() {
        int cal = cal(2, 3);
        assertEquals(5, cal, "业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1, obj2, "指向不同对象");
    }

    @Test
    @DisplayName("array assertion")
    void array() {
        assertArrayEquals(new int[]{2, 1}, new int[] {1, 2}, "数据内容不相等");
    }

    int cal(int i, int j) {
        return i + j;
    }

    @Test
    @DisplayName("assert all")
    public void all() {
        assertAll("Math",
                () -> assertEquals(3, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0), "数学运算居然正常");

    }

    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(5000));
    }

    @Test
    @DisplayName("fail")
    public void shouldFail() {
        fail("This should fail");
    }

    @Test
    @DisplayName("测试DisplayName注解")
    void testDisplayName() {
        log.info("1");
    }

    @Disabled
    @Test
    @DisplayName("测试方法2")
    void test2() {
        log.info("2");
    }

    @RepeatedTest(value = 5)
    @Test
    @DisplayName("测试方法3")
    void test3() {
        log.info("3");
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(1000);
    }

    @BeforeEach
    void testBeforeEach() {
        log.info("测试开始===========");
    }

    @AfterEach
    void testAfterEach() {
        log.info("测试结束===========");
    }

    @BeforeAll
    static void testBeforeAll() {
        log.info("所有测试开始===========");
    }

    @AfterAll
    static void testAfterAll () {
        log.info("所有测试开始===========");
    }

}
