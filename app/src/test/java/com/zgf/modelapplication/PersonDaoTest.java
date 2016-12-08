package com.zgf.modelapplication;

import com.zgf.modelapplication.mock.test.Person;
import com.zgf.modelapplication.mock.test.PersonDao;
import com.zgf.modelapplication.mock.test.PersonService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by zgf on 2016/12/8.
 *
 * 获得mock对象是实际测试的类的对象
 * 即所要测试的方法所在的类的对象
 */

public class PersonDaoTest {
    @Mock
    private PersonDao personDao;
    private PersonService personService;

    @Mock
    private List<Integer> list1;
    @Mock
    private List<Integer> list2;

    @Before
    public void setUp() throws Exception {
        // 实例化
        MockitoAnnotations.initMocks(this);
        personService = new PersonService(personDao);
    }

    @Test
    public void shouldUpdatePersonName() throws Exception {
        Person person = new Person(1, "xiaoming");
        when(personDao.fetchPerson(1)).thenReturn(person);
        boolean update = personService.update(1, "xiaowang");
        assertTrue(update);
        verify(personDao).fetchPerson(1);

        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
        verify(personDao).update(personCaptor.capture());
        Person value = personCaptor.getValue();
        assertEquals("xiaowang", value.getName());

        verifyNoMoreInteractions(personDao); // 允许你检查没有其他的方法被调用了
    }

    @Test
    @Ignore
    public void shouldNotUpdateIfPersonNotFound() throws Exception {
        when(personDao.fetchPerson(1)).thenReturn(null); // null什么也不做
        boolean update = personService.update(1, "xiaowang");
        assertTrue(update);
        verify(personDao).fetchPerson(1);
        verifyZeroInteractions(personDao);
        verifyNoMoreInteractions(personDao);
    }

    @Test
    public void find_redundant_interaction() {
        //List<Integer> list = Mockito.mock(List.class);
        list1.add(1);
        list1.add(2);
        verify(list1, Mockito.times(2)).add(Mockito.anyInt());
        verifyNoMoreInteractions(list1);

        //List<Integer> list2 = Mockito.mock(List.class);
        list2.add(1);
        list2.add(2);
        verify(list2, Mockito.times(2)).add(Mockito.anyInt());
        verify(list2, Mockito.never()).add(3);
        verifyNoMoreInteractions(list2);
    }
}
