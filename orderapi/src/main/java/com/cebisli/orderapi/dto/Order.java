package com.cebisli.orderapi.dto;

import java.io.Serializable;

public class Order implements Serializable{
    private Product product;
    public Order( Product p,int piece){
        this.product=p;
        this.piece=piece;

    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    private int piece;  
    public int getPiece() {
        return piece;
    }
    public void setPiece(int piece) {
        this.piece = piece;
    }
}
