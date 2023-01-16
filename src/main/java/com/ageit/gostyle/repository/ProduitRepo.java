package com.ageit.gostyle.repository;

import com.ageit.gostyle.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface ProduitRepo extends JpaRepository <Produit, Long> {
    Produit findById(long id);


    @Query("select DISTINCT prod from Produit prod join Promotion prom on prom.produit.id=prod.id  where prom.dateDebut<= CURRENT_DATE and prom.dateFin>= CURRENT_DATE order by prod.categorieId" )
    List<Produit> getProduitWithCurrentPromotions();

    @Query("select DISTINCT prod from Produit prod join Promotion prom on prom.produit.id=prod.id  where prod.categorieId=?1 and prom.dateDebut<= CURRENT_DATE and prom.dateFin>= CURRENT_DATE order by prod.categorieId" )
    Iterable<Produit> getProduitWithCurrentPromotionsFromCat(Long catId);



}
