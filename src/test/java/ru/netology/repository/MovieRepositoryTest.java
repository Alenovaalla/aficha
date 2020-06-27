package ru.netology.repository;

import net.sf.saxon.expr.Component;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private MovieRepository repository = new MovieRepository();

    @Test
    void shouldSave() {
        Movie first = new Movie(1, "A", "drama", "1");

        repository.save(first);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAll() {
        Movie first = new Movie(1, "A", "drama", "1");
        Movie second = new Movie(2, "B", "drama", "2");
        Movie third = new Movie(3, "C", "drama", "3");
        Movie fourth = new Movie(4, "D", "drama", "4");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.findAll();

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        Movie first = new Movie(1, "A", "drama", "1");
        Movie second = new Movie(2, "B", "drama", "2");

        repository.save(first);
        repository.save(second);
        repository.removeAll();

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        Movie first = new Movie(1, "A", "drama", "1");
        Movie second = new Movie(2, "B", "drama", "2");
        repository.save(first);
        repository.save(second);
        repository.removeById(1);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{second};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindById() {
        Movie first = new Movie(1, "A", "drama", "1");
        Movie second = new Movie(2, "B", "drama", "2");
        repository.save(first);
        repository.save(second);

        Movie actual = repository.findById(1);
        Movie expected = first;
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfNotExist() {
        Movie first = new Movie(1, "A", "drama", "1");
        Movie second = new Movie(2, "B", "drama", "2");
        repository.save(first);
        repository.save(second);

        Movie actual = repository.findById(4);
        Movie expected = null;
        assertEquals(expected, actual);
    }


}


