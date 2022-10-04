package com.example.demo.repositories;

import com.example.demo.entities.Movies;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movies, Integer>{
    
    @Query(value = "SELECT * FROM wannabe_videoclub.movies\n"
            + "join movies_category on FK_movies_category = movie_id\n"
            + "join category on FK_category_movies = idcategory\n"
            + "where idcategory= 1;", nativeQuery = true)
    public List<Movies> getAllComedyMovies();
    
    
    @Query(value = "SELECT * FROM wannabe_videoclub.movies\n"
            + "join movies_category on FK_movies_category = movie_id\n"
            + "join category on FK_category_movies = idcategory\n"
            + "where idcategory= 2;", nativeQuery = true)
    public List<Movies> getAllThrillerMovies();
    
    
    @Query(value = "SELECT * FROM wannabe_videoclub.movies\n"
            + "join movies_category on FK_movies_category = movie_id\n"
            + "join category on FK_category_movies = idcategory\n"
            + "where idcategory= 3;", nativeQuery = true)
    public List<Movies> getAllHorrorMovies();
    
    
    @Query(value = "SELECT * FROM wannabe_videoclub.movies\n"
            + "join movies_category on FK_movies_category = movie_id\n"
            + "join category on FK_category_movies = idcategory\n"
            + "where idcategory= 4;", nativeQuery = true)
    public List<Movies> getAllActionMovies();
    
    
    @Query(value = "SELECT * FROM wannabe_videoclub.movies\n"
            + "join movies_category on FK_movies_category = movie_id\n"
            + "join category on FK_category_movies = idcategory\n"
            + "where idcategory= 5;", nativeQuery = true)
    public List<Movies> getAllSportMovies();
    
    
    @Query(value = "SELECT * FROM wannabe_videoclub.movies\n"
            + "join movies_category on FK_movies_category = movie_id\n"
            + "join category on FK_category_movies = idcategory\n"
            + "where idcategory= 6;", nativeQuery = true)
    public List<Movies> getAllDramaMovies();
    
    
 @Query(value = "SELECT * FROM wannabe_videoclub.movies ORDER BY movie_added DESC limit 6;", nativeQuery = true)
        public List<Movies> getLastMovieAdded(); 
}

