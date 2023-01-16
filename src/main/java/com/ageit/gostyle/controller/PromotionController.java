package com.ageit.gostyle.controller;

import com.ageit.gostyle.model.Produit;
import com.ageit.gostyle.model.Promotion;

import com.ageit.gostyle.repository.PromotionRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PromotionController {
    private PromotionRepo promotionRepository;

    public PromotionController(PromotionRepo promotionRepository) {
        this.promotionRepository = promotionRepository;
    }
    // READ: LISTES DES PROMOTIONS

    @GetMapping("/promotions")
    public Iterable <Promotion> getAllPromotions (){
        return promotionRepository.findAll();    }

    // READ: LISTES DES  TOUTES PROMOTIONS EN COURS
    @GetMapping("/promotions/current")
    public Iterable <Promotion> getAllPromotionsCurrent (){
        return promotionRepository.getCurrentPromotions();    }


    // READ: LISTES DES PROMOTIONS EN COURS POUR UN PRODUITS de la même catégorie
    @GetMapping("/promotions/{prodId}")
    public Iterable<Promotion> getPromotionsCurrentForAllProducts(@PathVariable long prodId ){
        return promotionRepository.getCurrentPromotionsForProduit(prodId); }

    // READ: LISTES DES   PROMOTIONS EN COURS POUR UNE CATEGORIE ID
    @GetMapping("/promotions/categorie/{catId}")
    public Iterable<Promotion> getCurrentPromotionsForCategorie(@PathVariable long catId) {
        return promotionRepository.getCurrentPromotionsForCategorie(catId);
    }

    // READ: LISTES DES   PROMOTIONS POUR UNE CATEGORIE  PRODUIT
    @GetMapping("/promotions/produit/{prodId}/categorie")
    public Iterable<Promotion> getCurrentPromotionsForProduitCategorie(@PathVariable long prodId) {
        try{
            Produit p = promotionRepository.findById(prodId).getProduit();
            // System.out.println("LISTE des promotions pour le produit "+prodId);
            // List<Promotion> promosForProduit = repoPromos.getCurrentPromotionsForProduit(prodId);

            System.out.println("LISTE des promotions pour la catégorie  "+p.getCategorieId());
            List<Promotion> promosForCategorie = promotionRepository.getCurrentPromotionsForCategorie(p.getCategorieId());

            return promosForCategorie;
            /*
            promosForProduit.addAll(promosForCategorie) ;
            return promosForProduit;
            */

        }
        catch (Exception ex){
            throw ex;
        }
    }

    // READ: LISTES DE TOUTES   PROMOTIONS POUR UN PRODUIT
    @GetMapping(value="/promotions/all/{prodId}")
    public Iterable<Promotion> buyerLandingReport(@PathVariable long prodId) {
        try{

            List<Promotion> list1 = promotionRepository.getCurrentPromotionsForProduit(prodId);
            List<Promotion> list2 = promotionRepository.getCurrentPromotions();

            list1.addAll(list2) ;
            return list1;

        }
        catch (Exception ex){
            throw ex;
        }
    }
}

