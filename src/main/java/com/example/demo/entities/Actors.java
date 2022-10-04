/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author karat
 */
@Entity
@Table(name = "actors")
@NamedQueries({
    @NamedQuery(name = "Actors.findAll", query = "SELECT a FROM Actors a"),
    @NamedQuery(name = "Actors.findByActorsId", query = "SELECT a FROM Actors a WHERE a.actorsId = :actorsId"),
    @NamedQuery(name = "Actors.findByActorsName", query = "SELECT a FROM Actors a WHERE a.actorsName = :actorsName")})
public class Actors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "actors_id")
    private Integer actorsId;
    @Size(max = 50)
    @Column(name = "actors_name")
    private String actorsName;
    @JoinTable(name = "movies_actors", joinColumns = {
        @JoinColumn(name = "FK_actors_movies", referencedColumnName = "actors_id")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_movies_actors", referencedColumnName = "movie_id")})
    @ManyToMany
    private Set<Movies> moviesSet;

    public Actors() {
    }

    public Actors(Integer actorsId) {
        this.actorsId = actorsId;
    }

    public Integer getActorsId() {
        return actorsId;
    }

    public void setActorsId(Integer actorsId) {
        this.actorsId = actorsId;
    }

    public String getActorsName() {
        return actorsName;
    }

    public void setActorsName(String actorsName) {
        this.actorsName = actorsName;
    }

    public Set<Movies> getMoviesSet() {
        return moviesSet;
    }

    public void setMoviesSet(Set<Movies> moviesSet) {
        this.moviesSet = moviesSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actorsId != null ? actorsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actors)) {
            return false;
        }
        Actors other = (Actors) object;
        if ((this.actorsId == null && other.actorsId != null) || (this.actorsId != null && !this.actorsId.equals(other.actorsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.Actors[ actorsId=" + actorsId + " ]";
    }
    
}
