package com.example.test_nc.Utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilsTest {

    private MyUtils myUtils;
    @BeforeEach
    void setUp() {
        myUtils = new MyUtils();
    }

    @Test
    void add() {
        assertEquals(5, myUtils.add(1, 4));
    }


    @Test
    void tinhTongSoChanVoi0() {
        assertEquals(0, myUtils.tinhTongSoChan(0));
    }

    @Test
    void tinhTongSoChanVoi1() {
        assertEquals(0, myUtils.tinhTongSoChan(1));
    }
    @Test
    void tinhTongSoChanVoi2() {
        assertEquals(2, myUtils.tinhTongSoChan(2));
    }
    @Test
    void tinhTongSoChanVoi10() {
        assertEquals(30, myUtils.tinhTongSoChan(10));
    }
    @Test
    void tinhTongSoChanVoi20() {
        assertEquals(110, myUtils.tinhTongSoChan(20));
    }
    @Test
    void tinhTongSoChanInvalid() {
        assertEquals(0, myUtils.tinhTongSoChan(-1));
    }


}