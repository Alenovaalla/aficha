package ru.netology.repository;

import ru.netology.domain.Movie;


public class MovieRepository {

    private Movie[] movies = new Movie[0];

    public void save(Movie item) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public void removeAll() {
        movies = new Movie[0];
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : movies) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        movies = tmp;
    }

    public Movie findById(int id) {
        for (Movie item : movies) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;

    }
}



