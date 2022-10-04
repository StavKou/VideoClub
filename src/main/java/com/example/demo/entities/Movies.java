/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author karat
 */
@Entity
@Table(name = "movies")
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"),
    @NamedQuery(name = "Movies.findByMovieId", query = "SELECT m FROM Movies m WHERE m.movieId = :movieId"),
    @NamedQuery(name = "Movies.findByMovieTitle", query = "SELECT m FROM Movies m WHERE m.movieTitle = :movieTitle"),
    @NamedQuery(name = "Movies.findByMoviePlot", query = "SELECT m FROM Movies m WHERE m.moviePlot = :moviePlot"),
    @NamedQuery(name = "Movies.findByMovieProduction", query = "SELECT m FROM Movies m WHERE m.movieProduction = :movieProduction"),
    @NamedQuery(name = "Movies.findByMoviePrice", query = "SELECT m FROM Movies m WHERE m.moviePrice = :moviePrice"),
    @NamedQuery(name = "Movies.findByMovieYear", query = "SELECT m FROM Movies m WHERE m.movieYear = :movieYear"),
    @NamedQuery(name = "Movies.findByMovieDirector", query = "SELECT m FROM Movies m WHERE m.movieDirector = :movieDirector"),
    @NamedQuery(name = "Movies.findByMovieRating", query = "SELECT m FROM Movies m WHERE m.movieRating = :movieRating"),
    @NamedQuery(name = "Movies.findByMovieQuantity", query = "SELECT m FROM Movies m WHERE m.movieQuantity = :movieQuantity"),
    @NamedQuery(name = "Movies.findByMovieAdded", query = "SELECT m FROM Movies m WHERE m.movieAdded = :movieAdded")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movie_id")
    private Integer movieId;
    @Size(max = 50)
    @Column(name = "movie_Title")
    private String movieTitle;
    @Size(max = 300)
    @Column(name = "movie_Plot")
    private String moviePlot;
    @Size(max = 50)
    @Column(name = "movie_Production")
    private String movieProduction;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "movie_Price")
    private BigDecimal moviePrice;
    @Column(name = "movie_Year")
    private Integer movieYear;
    @Size(max = 50)
    @Column(name = "movie_Director")
    private String movieDirector;
    @Column(name = "movie_Rating")
    private BigDecimal movieRating;
    @Column(name = "movie_Quantity")
    private Integer movieQuantity;
    @Column(name = "movie_added")
    @Temporal(TemporalType.DATE)
    private Date movieAdded;
    @JoinTable(name = "movieswithorders", joinColumns = {
        @JoinColumn(name = "FK_movies_orders", referencedColumnName = "movie_id")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_orders_movies", referencedColumnName = "order_id")})
    @ManyToMany
    private Set<Orders> ordersSet;
    @ManyToMany(mappedBy = "moviesSet")
    private Set<Category> categorySet;
    @ManyToMany(mappedBy = "moviesSet")
    private Set<Dubs> dubsSet;
    @JoinTable(name = "movies_subs", joinColumns = {
        @JoinColumn(name = "FK_movies_subs", referencedColumnName = "movie_id")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_subs_movies", referencedColumnName = "subs_id")})
    @ManyToMany
    private Set<Subs> subsSet;
    @ManyToMany(mappedBy = "moviesSet")
    private Set<Actors> actorsSet;

    public Movies() {
    }

    public Movies(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMoviePlot() {
        return moviePlot;
    }

    public void setMoviePlot(String moviePlot) {
        this.moviePlot = moviePlot;
    }

    public String getMovieProduction() {
        return movieProduction;
    }

    public void setMovieProduction(String movieProduction) {
        this.movieProduction = movieProduction;
    }

    public BigDecimal getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(BigDecimal moviePrice) {
        this.moviePrice = moviePrice;
    }

    public Integer getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(Integer movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public BigDecimal getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(BigDecimal movieRating) {
        this.movieRating = movieRating;
    }

    public Integer getMovieQuantity() {
        return movieQuantity;
    }

    public void setMovieQuantity(Integer movieQuantity) {
        this.movieQuantity = movieQuantity;
    }

    public Date getMovieAdded() {
        return movieAdded;
    }

    public void setMovieAdded(Date movieAdded) {
        this.movieAdded = movieAdded;
    }

    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    public Set<Dubs> getDubsSet() {
        return dubsSet;
    }

    public void setDubsSet(Set<Dubs> dubsSet) {
        this.dubsSet = dubsSet;
    }

    public Set<Subs> getSubsSet() {
        return subsSet;
    }

    public void setSubsSet(Set<Subs> subsSet) {
        this.subsSet = subsSet;
    }

    public Set<Actors> getActorsSet() {
        return actorsSet;
    }

    public void setActorsSet(Set<Actors> actorsSet) {
        this.actorsSet = actorsSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieId != null ? movieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.movieId == null && other.movieId != null) || (this.movieId != null && !this.movieId.equals(other.movieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.Movies[ movieId=" + movieId + " ]";
    }
    
}
