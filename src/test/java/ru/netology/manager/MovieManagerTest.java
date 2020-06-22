package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    Movie first = new Movie(1, "A", "drama", "1");
    Movie second = new Movie(2, "B", "drama", "2");
    Movie third = new Movie(3, "C", "drama", "3");
    Movie fourth = new Movie(4, "D", "drama", "4");
    Movie fifth = new Movie(5, "E", "drama", "5");
    Movie sixth = new Movie(6, "F", "drama", "6");
    Movie seventh = new Movie(7, "G", "drama", "7");
    Movie eighth = new Movie(8, "H", "drama", "8");
    Movie ninth = new Movie(9, "I", "drama", "9");
    Movie tenth = new Movie(10, "J", "drama", "10");
    Movie eleventh = new Movie(11, "K", "drama", "11");


    @Test
    public void shouldAdd() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLast() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLast5() {
        MovieManager manager = new MovieManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastIfItemsLengthLessAfishaLength() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);


        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastIfItemsLengthLessAfishaLength1() {
        MovieManager manager = new MovieManager();
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[0];

        assertArrayEquals(expected, actual);
    }


}