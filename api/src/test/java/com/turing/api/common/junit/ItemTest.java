package com.turing.api.common.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void print() {
        Item s = new Item();
        String s3 = s.print();
        System.out.println("-->"+s3);
        Assertions.assertEquals(s.print(),"Hello");
    }

    @Test
    void addTest() {
        Item s = new Item();

        assertEquals(s.addTest(3,2),6);
    }


}