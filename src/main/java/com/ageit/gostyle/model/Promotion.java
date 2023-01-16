package com.ageit.gostyle.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity

public class Promotion {
    @Id
    private long id;
    // private long produitId;
    private java.sql.Date dateDebut;
    private java.sql.Date dateFin;
    private String reduction;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore //java.lang.IllegalStateException: Cannot call sendError() after the response has been committed
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;


    public Promotion() {
    }

    public Promotion(long id, Date dateDebut, Date dateFin, String reduction, Produit produit) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.reduction = reduction;
        this.produit = produit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getReduction() {
        return reduction;
    }

    public void setReduction(String reduction) {
        this.reduction = reduction;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
