/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

/**
 *
 * @author stkou
 */
public class Item {

    private Movies movie;
    private int quantity;

    public Item() {
    }

    public Item(Movies movie, int quantity) {
        this.movie = movie;
        this.quantity = quantity;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
