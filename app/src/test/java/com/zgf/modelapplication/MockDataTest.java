package com.zgf.modelapplication;

import com.zgf.modelapplication.utils.MockData;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by zgf on 2016/12/8.
 */

public class MockDataTest {
    private static MockData mockData;

    @BeforeClass
    public static void setUp() throws Exception {
        // 初始化
        mockData = mock(MockData.class);

        // 运行时给定参数
        when(mockData.isLogin()).thenReturn(true);
        when(mockData.getUserName()).thenReturn("dmbj");
    }

    @Test
    //@Ignore // 忽略
    public void test() throws Exception {
        // 对比返回值
        String userName = mockData.getUserName();
        assertEquals("dmbj", userName);

        boolean login = mockData.isLogin();
        assertEquals(true, login);

        mockData.setLogin(true);
        verify(mockData).setLogin(true);// 默认为1次
    }

    @Test
    @Ignore
    public void testLogin() throws Exception {
        // 检测方法被调用的次数
        mockData.setLogin(true);
        mockData.setLogin(true);
        verify(mockData, times(2)).setLogin(true);
    }

}
