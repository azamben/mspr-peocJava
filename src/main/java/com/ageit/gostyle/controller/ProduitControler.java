package com.ageit.gostyle.controller;

import com.ageit.gostyle.model.Produit;
import com.ageit.gostyle.repository.ProduitRepo;

import org.springframework.web.bind.annotation.*;


import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProduitControler {
    private ProduitRepo produitRepository ;

    public ProduitControler(ProduitRepo produitRepository) {
        this.produitRepository = produitRepository;
    }
    // READ: LISTES DES PRODUITS

    @GetMapping("/produits")
    public Iterable <Produit> getAllProducts (){
    return produitRepository.findAll();    }
    // READ: UN PRODUITS

    @GetMapping("/produits/{id}")
    public Optional<Produit> getProductByid(@PathVariable(value = "id") Long id ){
        return produitRepository.findById(id); }
    // 2- METHODE EXECEPTION
    /*
    @GetMapping("/produits/{id}")
    public Produit getProduit(@PathVariable(value = "id") Long id) {
        return findProduitById(id);
    }
    */

    // READ: LISTES DES PRODUITS SUGGESTION

    @GetMapping("/produits/suggestion")
    public Iterable<Produit> getProduitWithCurrentPromotions() {

        return produitRepository.getProduitWithCurrentPromotions();
    }

    // READ: LISTES DES PRODUITS SUGGESTION AVEC CATID
    @GetMapping("/produits/suggestion/{catId}")
    public Iterable<Produit> getProduitWithCurrentPromotionsFromCat(@PathVariable(value = "catId") Long catId) {

        return produitRepository.getProduitWithCurrentPromotionsFromCat(catId);
    }


    // methode avec exception
    /*
    private Produit findProduitById(Long id) {

        Optional<Produit> res  =  produitRepository.findById(id);
        if (res.isPresent()){
            LogMessage("Produit "+id+" trouvé");
            return res.get();
        }else{
            LogMessage("Produit "+id+" non trouvé");
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Livre '%s' non trouvé", id)
            );

        }
    }
*/


    private void LogMessage(String message) {
        System.err.printf("Message=%s, Class=%s\n", message, this.getClass().getCanonicalName());
    }
}
