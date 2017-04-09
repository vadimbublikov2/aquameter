package ru.bvd.aquameter;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AquariumTest {

    @Test
    public void testMain1 () {
        Aquarium aquarium = new Aquarium("4 2 1 2 1 5");
        assertEquals(10, aquarium.calcVolume());

    }
    @Test
    public void testMain2 () {
        Aquarium aquarium = new Aquarium("4 3 2 4 1 2");
        assertEquals(4, aquarium.calcVolume());

    }
    @Test
    public void testMain3 () {
        Aquarium aquarium = new Aquarium("4 3 2 1 0 1 2 3 4 ");
        assertEquals(0, aquarium.calcVolume());

    }
    @Test
    public void testMain4 () {
        Aquarium aquarium = new Aquarium("1 2 3 4 3 2 1 2 3 4 3 2 1");
        assertEquals(9, aquarium.calcVolume());

    }
    @Test
    public void testMain5 () {
        Aquarium aquarium = new Aquarium("1 1 1 2 4 1");
        assertEquals(0, aquarium.calcVolume());

    }
    @Test
    public void testMain6 () {
        Aquarium aquarium = new Aquarium("5 6 6 3 2 4 4 3 3 3 7 6 6 5 5 4 5 4 3");
        assertEquals(21, aquarium.calcVolume());

    }
    @Test
    public void testMain7 () {
        Aquarium aquarium = new Aquarium("3");
        assertEquals(0, aquarium.calcVolume());

    }
    @Test
    public void testMain8 () {
        Aquarium aquarium = new Aquarium("3 3 3 3");
        assertEquals(0, aquarium.calcVolume());

    }
    @Test
    public void testMain9 () {
        Aquarium aquarium = new Aquarium("1 1 1 1");
        assertEquals(0, aquarium.calcVolume());

    }
    @Test
    public void testMain10 () {
        Aquarium aquarium = new Aquarium("4 1 1 1 1 4");
        assertEquals(12, aquarium.calcVolume());

    }
    @Test
    public void testMain11 () {
        Aquarium aquarium = new Aquarium("4 1 1 0 1 1 4");
        assertEquals(0, aquarium.calcVolume());

    }
    @Test
    public void testMain12 () {
        Aquarium aquarium = new Aquarium("1 2 3 4 5 5 5 3 4 4 4 1 1 6 6 6 5 4 3 4 3 2 1");
        assertEquals(14, aquarium.calcVolume());

    }
}
