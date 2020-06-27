package ru.netology.manager;

import net.sf.saxon.expr.Component;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class MovieManagerTest {
    @Mock
    MovieRepository repository;
    @InjectMocks
    MovieManager manager = new MovieManager(repository);


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

        MovieManager manager = new MovieManager(new MovieRepository());
        Movie[] returned = new Movie[] {first};
        doReturn(returned).when(repository).findAll();
        manager.add(first);
        Movie[] expected = new Movie[] {first};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldGetAll() {

        MovieManager manager = new MovieManager(new MovieRepository());
        Movie[] returned = new Movie[] {first};
        doReturn(returned).when(repository).findAll();
        manager.add(first);
        manager.getAll();
        Movie[] expected = new Movie[] {first};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test

    public void shouldGetLast() {

        MovieManager manager = new MovieManager(new MovieRepository());
        Movie[] returned = new Movie[] {first, second,third,fourth, fifth, sixth, seventh,eighth, ninth,tenth};
        doReturn(returned).when(repository).findAll();
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
        manager.getLast();

        Movie[] expected = new Movie[] {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }




}