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
@Table(name = "subs")
@NamedQueries({
    @NamedQuery(name = "Subs.findAll", query = "SELECT s FROM Subs s"),
    @NamedQuery(name = "Subs.findBySubsId", query = "SELECT s FROM Subs s WHERE s.subsId = :subsId"),
    @NamedQuery(name = "Subs.findBySubsName", query = "SELECT s FROM Subs s WHERE s.subsName = :subsName")})
public class Subs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "subs_id")
    private Integer subsId;
    @Size(max = 50)
    @Column(name = "subs_name")
    private String subsName;
    @ManyToMany(mappedBy = "subsSet")
    private Set<Movies> moviesSet;

    public Subs() {
    }

    public Subs(Integer subsId) {
        this.subsId = subsId;
    }

    public Integer getSubsId() {
        return subsId;
    }

    public void setSubsId(Integer subsId) {
        this.subsId = subsId;
    }

    public String getSubsName() {
        return subsName;
    }

    public void setSubsName(String subsName) {
        this.subsName = subsName;
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
        hash += (subsId != null ? subsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subs)) {
            return false;
        }
        Subs other = (Subs) object;
        if ((this.subsId == null && other.subsId != null) || (this.subsId != null && !this.subsId.equals(other.subsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.entities.Subs[ subsId=" + subsId + " ]";
    }
    
}
