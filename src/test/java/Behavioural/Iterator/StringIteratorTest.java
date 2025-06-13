package Behavioural.Iterator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringIteratorTest {
    private PeopleRepo peopleRepo;

    @BeforeEach
    public void setUp() {
        peopleRepo = new PeopleRepo();
        peopleRepo.addName("John Doe");
        peopleRepo.addName("Jane Doe");
        peopleRepo.addName("Jack Doe");
        peopleRepo.addName("Bob Doe");
    }

    @Test
    void hasNext() {
        Iterator<String> iterator = peopleRepo.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    void whileTest(){
        Iterator<String> iterator = peopleRepo.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            iterator.next();
            counter++;
        }
        assertEquals(4, counter);
    }
}