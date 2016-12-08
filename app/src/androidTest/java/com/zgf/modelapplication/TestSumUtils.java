package com.zgf.modelapplication;

import com.zgf.modelapplication.utils.SumUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by zgf on 2016/12/7.
 */

public class TestSumUtils {
    private SumUtils sumUtils;

    @Before
    public void setUp() {
        sumUtils = new SumUtils();
    }

    @Test
    public void tesSum() throws Exception {
        int sum = sumUtils.sum(1, 2);
        Assert.assertEquals(3, sum);
    }

    @Test
    @Ignore("not implemented yet")
    public void testMultiply() throws Exception {
        int mul = sumUtils.multiply(2, 3);
        Assert.assertEquals(6, mul);
    }
}
