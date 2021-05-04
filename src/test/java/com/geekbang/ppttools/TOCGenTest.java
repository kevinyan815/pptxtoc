package com.geekbang.ppttools;

import org.junit.Assert;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class TOCGenTest {

    @org.junit.jupiter.api.Test
    void isThePPT() {
        boolean ret = TOCGen.isThePPT(new File("001.pptx"));
        Assert.assertTrue(ret);
    }

    @org.junit.jupiter.api.Test
    void isNotThePPT() {
        boolean ret = TOCGen.isThePPT(new File("notpowerpoint"));
        Assert.assertFalse(ret);
    }


}