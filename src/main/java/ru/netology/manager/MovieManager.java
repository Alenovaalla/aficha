package ru.netology.manager;


import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;


public class MovieManager {

    private int afishaLength = 10;

    private MovieRepository repository;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }


    public Movie[] getAll() {
        Movie[] movie = repository.findAll();
        Movie[] result = new Movie[movie.length];
        for (int i = 0; i < result.length; i++) {
            int index = movie.length - i - 1;
            result[i] = movie[index];
        }
        return result;
    }

    public Movie[] getLast() {
        Movie[] movies = repository.findAll();
        int resultLength = movies.length;
        if (resultLength > afishaLength) resultLength = afishaLength;
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}











