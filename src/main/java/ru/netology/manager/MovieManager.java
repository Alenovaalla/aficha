package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.Movie;


public class MovieManager {

  private int afishaLength = 10;

  private Movie[] items = new Movie[0];

  public MovieManager(int afishaLength) {
    this.afishaLength = afishaLength;
  }

  public MovieManager() {
  }

  public void add(Movie item) {
    int length = items.length + 1;
    Movie[] tmp = new Movie[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public Movie[] getAll() {
    Movie[] result = new Movie[items.length];
    for (int i = 0; i < result.length; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

  public Movie[] getLast() {

    if (items.length < afishaLength) {
      Movie[] result = new Movie[items.length];
      for (int i = 0; i < items.length; i++) {
        int index = items.length - i - 1;
        result[i] = items[index];
      }
      return result;
    }

    else {
      Movie[] result = new Movie[afishaLength];
      for (int i = 0; i < afishaLength; i++) {
        int index = items.length - i - 1;
        result[i] = items[index];
      }
      return result;
    }
  }
}








