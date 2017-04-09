package ru.bvd.aquameter;

import org.junit.Test;

import java.util.Random;

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
        Aquarium aquarium = new Aquarium("4 3 2 1 0 1 2 3 4");
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
    @Test
    public void testMain13 () {
        Aquarium aquarium = new Aquarium("3 1 1 2 1 4");
        assertEquals(7, aquarium.calcVolume());

    }
    @Test
    public void testMain14 () {
        Aquarium aquarium = new Aquarium("3 1 0 3 1 4 1 2");
        assertEquals(3, aquarium.calcVolume());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testMain15 () {
        Aquarium aquarium = new Aquarium("3 -1 0 3 1 4 1 2");
        assertEquals(3, aquarium.calcVolume());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testMain16 () {
        Aquarium aquarium = new Aquarium("3 1.8 0 3 1 4 1 2");
        assertEquals(3, aquarium.calcVolume());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testMain17 () {
        Aquarium aquarium = new Aquarium("3 1,8 0 3 1 4 1 2");
        assertEquals(3, aquarium.calcVolume());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testMain18 () {
        Aquarium aquarium = new Aquarium("3 70000 0 3 1 4 1 2");
        assertEquals(3, aquarium.calcVolume());

    }
    @Test
    public void testMain19 () {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<65535; i++) {
            sb.append( String.valueOf( r.nextInt(65535) ) ).append(" ");
        }
        sb.setLength( sb.length()-1 );

        Aquarium aquarium = new Aquarium(sb.toString());
        boolean flag = false;
        if (aquarium.calcVolume()>0) {
            flag = true;
        }

        assertEquals(true, flag);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testMain20 () {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<70000; i++) {
            sb.append( String.valueOf( r.nextInt(65535) ) ).append(" ");
        }
        sb.setLength( sb.length()-1 );

        Aquarium aquarium = new Aquarium(sb.toString());
    }


    public static void main(String[] args) {
        AquariumTest at = new AquariumTest();
        at.testMain18();
    }

}
