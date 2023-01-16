package com.ageit.gostyle.repository;

import com.ageit.gostyle.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromotionRepo extends JpaRepository<Promotion, Long> {
   Promotion findById(long id);


   // cherche toutes les promotions
    /*
    @Query("select prom from Promotion prom")
    List<Promotion> getAllPromotions();
    */

   // cherche toutes les promotions en cours
   @Query("select prom from Promotion prom where prom.dateDebut<= CURRENT_DATE and prom.dateFin>= CURRENT_DATE ")
   List<Promotion> getCurrentPromotions();

   // cherche toutes les promotions en cours pour un produit donné;
   @Query("select prom from Promotion prom where prom.produit.id = ?1 and prom.dateDebut<= CURRENT_DATE and prom.dateFin>= CURRENT_DATE " )
   List<Promotion> getCurrentPromotionsForProduit(long prodId);

   // cherche toutes les promotions en cours pour les produits de la même catégorie
   // @todo
   @Query("select prom from Promotion prom join Produit prod on prom.produit.id=prod.id where prod.categorieId = ?1 and prom.dateDebut<= CURRENT_DATE and prom.dateFin>= CURRENT_DATE " )
   List<Promotion> getCurrentPromotionsForProduitCategorie(long prodId);


   // cherche toutes les promotions en cours pour les produits d'une certaine catégorie
   @Query("select prom from Promotion prom join Produit prod on prom.produit.id=prod.id where prod.categorieId = ?1 and prom.dateDebut<= CURRENT_DATE and prom.dateFin>= CURRENT_DATE " )
   List<Promotion> getCurrentPromotionsForCategorie(long catId);

}
