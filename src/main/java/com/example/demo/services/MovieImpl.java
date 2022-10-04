package com.example.demo.services;

import com.example.demo.entities.Movies;
import com.example.demo.repositories.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieImpl implements Imovie {

    @Autowired
    MovieRepository mr;

    @Override
    public void insertMovie(Movies m) {

        mr.save(m);
    }

    @Override
    public List<Movies> allMovies() {

        return mr.findAll();
    }

    @Override
    public Movies GetById(Integer id) {

        return mr.findById(id).get();
    }

    @Override
    public void deleteMovie(Movies movie) {

        mr.delete(movie);
    }

    @Override
    public void updateMovie(Movies movie) {
        mr.save(movie);

    }

    @Override
    public List<Movies> getMovieListByCategoryId() {

        System.out.println(mr.getAllComedyMovies());

        return mr.getAllComedyMovies();
    }
    
    
    @Override
    public List<Movies> getMovieListByCategoryId1() {

        System.out.println(mr.getAllThrillerMovies());

        return mr.getAllThrillerMovies();
    }
    
    
    @Override
    public List<Movies> getMovieListByCategoryId2() {

        System.out.println(mr.getAllHorrorMovies());

        return mr.getAllHorrorMovies();
    }
    
    
    @Override
    public List<Movies> getMovieListByCategoryId3() {

        System.out.println(mr.getAllActionMovies());

        return mr.getAllActionMovies();
    }
    
    
    @Override
    public List<Movies> getMovieListByCategoryId4() {

        System.out.println(mr.getAllSportMovies());

        return mr.getAllSportMovies();
    }
    
    
    @Override
    public List<Movies> getMovieListByCategoryId5() {

        System.out.println(mr.getAllDramaMovies());

        return mr.getAllDramaMovies();
    }

    @Override
    public List<Movies> lastmoviesadded() {
        
       return mr.getLastMovieAdded();
    }
    

}
