package cat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.DAO.IProduitRepository;
import cat.entities.Produit;

@RestController
public class CatalogueController {

	@Autowired
	private IProduitRepository produitRepository;
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	
	@RequestMapping("/save")
	public Produit SaveProduit(Produit p){
		produitRepository.save(p);
		return p;
	}
	
	@RequestMapping("/all")
	public List<Produit> getProduits(){
		return produitRepository.findAll();
	}
	
	@RequestMapping("/produits")
	public Page<Produit> getProduitsParpage(int page){
		return produitRepository.findAll(new PageRequest(page, 5));
	}
	
	@RequestMapping("/produitsParMC")
	public Page<Produit> getProduitsParpage(String mc,int page){
		return produitRepository.produitParMC("%"+mc+"%", new PageRequest(page,5));
	}
	
	@RequestMapping("/get")
	public Produit getProduits(Long ref){
		return produitRepository.findOne(ref);
	}
	
	@RequestMapping("/delete")
	public boolean deleteProduit(Long ref){
		produitRepository.delete(ref);
		return true;
	}
	@RequestMapping("/update")
	public Produit updateProduit(Produit p){
	 produitRepository.saveAndFlush(p);
	return p;	
	}
	
}
