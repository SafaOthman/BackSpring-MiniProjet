package tn.essat.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.IGestionPfe;
import tn.essat.dao.IGestionTypePfe;
import tn.essat.model.Pfe;
import tn.essat.model.TypePfe;


@CrossOrigin("*")
@RestController
@RequestMapping(path="/rest")
public class AppRest {
	@Autowired
	IGestionPfe daop;
	@Autowired
	IGestionTypePfe daot;
	

	@GetMapping("/pfes")
	public List<Pfe> get1(){
		return daop.findAll();
	}
	
	@GetMapping("/listepfe/{id}")
	public List<Pfe> get2(@PathVariable("id") int id){
		return daop.getPfeByTypePfe(id);
	}
	
	@GetMapping("/listetype")
	public List<TypePfe> get3(){
		return daot.findAll();
	}
	
	@PostMapping("/addPFE")
	public void addM(@RequestBody Pfe p){
		daop.save(p);
	}
	@GetMapping("/recherche/{titre}")
	public List<Pfe> get4(@PathVariable("titre") String titre){
	return daop.getAllPfeByTitre(titre);
	}
	@DeleteMapping("/delete/{id}")
	public void get5(@PathVariable("id") int id){
		daop.deleteById(id);
	}
	@GetMapping("/count")
	public Integer meth6(){
		return daop.findAll().size();
		}
}
