package com.ageit.gostyle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity

public class Produit {
    @Id
    private long id;
    private String nom;
    private long categorieId;
    private String image;
    private Float prix;
    @OneToMany(mappedBy = "produit")
    @JsonIgnore //java.lang.IllegalStateException: Cannot call sendError() after the response has been committed
    @Where(clause="date_debut<= CURRENT_DATE and date_fin>= CURRENT_DATE")
    private Set<Promotion> promotions;

    public Produit() {
    }

    public Produit(long id, String nom, long categorieId, String image, Float prix, Set<Promotion> promotions) {
        this.id = id;
        this.nom = nom;
        this.categorieId = categorieId;
        this.image = image;
        this.prix = prix;
        this.promotions = promotions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(long categorieId) {
        this.categorieId = categorieId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }
}
