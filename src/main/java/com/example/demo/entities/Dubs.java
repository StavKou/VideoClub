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
@Table(name = "dubs")
@NamedQueries({
    @NamedQuery(name = "Dubs.findAll", query = "SELECT d FROM Dubs d"),
    @NamedQuery(name = "Dubs.findByDubsId", query = "SELECT d FROM Dubs d WHERE d.dubsId = :dubsId"),
    @NamedQuery(name = "Dubs.findByDubsName", query = "SELECT d FROM Dubs d WHERE d.dubsName = :dubsName")})
public class Dubs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dubs_id")
    private Integer dubsId;
    @Size(max = 50)
    @Column(name = "dubs_name")
    private String dubsName;
    @JoinTable(name = "movies_dubs", joinColumns = {
        @JoinColumn(name = "FK_dubs_movies", referencedColumnName = "dubs_id")}, inverseJoinColumns = {
        @JoinColumn(name = "FK_movies_dubs", referencedColumnName = "movie_id")})
    @ManyToMany
    private Set<Movies> moviesSet;

    public Dubs() {
    }

    public Dubs(Integer dubsId) {
        this.dubsId = dubsId;
    }

    public Integer getDubsId() {
        return dubsId;
    }

    public void setDubsId(Integer dubsId) {
        this.dubsId = dubsId;
    }

    public String getDubsName() {
        return dubsName;
    }

    public void setDubsName(String dubsName) {
        this.dubsName = dubsName;
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
        hash += (dubsId != null ? dubsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dubs)) {
            return false;
        }
        Dubs other = (Dubs) object;
        if ((this.dubsId == null && other.dubsId != null) || (this.dubsId != null && !this.dubsId.equals(other.dubsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.Dubs[ dubsId=" + dubsId + " ]";
    }
    
}
