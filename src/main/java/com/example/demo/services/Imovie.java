package com.example.demo.services;

import com.example.demo.entities.Movies;
import java.util.List;

public interface Imovie {

    public void insertMovie(Movies m);

    public List<Movies> allMovies();

    public Movies GetById(Integer id);

    public void updateMovie(Movies movie);

    public void deleteMovie(Movies movie);

    public List<Movies> getMovieListByCategoryId();

    public List<Movies> getMovieListByCategoryId1();

    public List<Movies> getMovieListByCategoryId2();

    public List<Movies> getMovieListByCategoryId3();

    public List<Movies> getMovieListByCategoryId4();

    public List<Movies> getMovieListByCategoryId5();
    
    public List<Movies> lastmoviesadded();

}
