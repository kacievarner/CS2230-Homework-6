package net.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedQuadTreeTest {

    //All tests done
    @Test
    public void addNWTest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("A");
        qt.addNW(r, "B");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.nw(qt.root()).getElement());

        qt.addNW(qt.nw(qt.root()), "C");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.nw(qt.root()).getElement());
        assertEquals("C", qt.nw(qt.nw(qt.root())).getElement());
    }

    @Test
    public void addNETest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("A");
        qt.addNE(r, "B");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.ne(qt.root()).getElement());

        qt.addNE(qt.ne(qt.root()), "C");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.ne(qt.root()).getElement());
        assertEquals("C", qt.ne(qt.ne(qt.root())).getElement());
    }

    @Test
    public void addSWTest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("A");
        qt.addSW(r, "B");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.sw(qt.root()).getElement());

        qt.addSW(qt.sw(qt.root()), "C");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.sw(qt.root()).getElement());
        assertEquals("C", qt.sw(qt.sw(qt.root())).getElement());
    }

    @Test
    public void addSETest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("A");
        qt.addSE(r, "B");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.se(qt.root()).getElement());

        qt.addSE(qt.se(qt.root()), "C");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.se(qt.root()).getElement());
        assertEquals("C", qt.se(qt.se(qt.root())).getElement());
    }

    @Test
    public void setTest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("0, 0");
        qt.set(r, "0,1");
        Position<String> x = qt.addNW(r, "-3, 4");
        qt.set(x, "3,4");
        assertEquals("0,1", qt.root().getElement());
        assertEquals("3,4", qt.nw(qt.root()).getElement());
    }

    @Test
    public void everythingTest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("0, 0");
        qt.addNW(r, "-3, 4");
        Position<String> a = qt.addNE(r, "3, 2");
        Position<String> b = qt.addNE(a, "10, 12");
        qt.addSW(b, "7, 7");
        qt.addSW(r, "-5, -6");
        qt.addSE(r, "6, -5");

        assertEquals("-3, 4", qt.nw(qt.root()).getElement());
        assertEquals("3, 2", qt.ne(qt.root()).getElement());
        Position<String> test1 = qt.ne(qt.root());
        assertEquals("-5, -6", qt.sw(qt.root()).getElement());
        assertEquals("6, -5", qt.se(qt.root()).getElement());
        assertEquals("10, 12", qt.ne(test1).getElement());
        Position<String> test2 = qt.ne(test1);
        assertEquals("7, 7", qt.sw(test2).getElement());
    }
}