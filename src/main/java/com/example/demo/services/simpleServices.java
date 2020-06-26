package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GardienRepository;
import com.example.demo.dao.MaterielRepository;
import com.example.demo.dao.MunicipalRepository;
import com.example.demo.dao.SalleRepository;
import com.example.demo.models.Gardien;
import com.example.demo.models.Materiel;
import com.example.demo.models.Municipal;
import com.example.demo.models.Salle;

@RestController
public class simpleServices {
	
	@Autowired
	private MaterielRepository mr;

	/*****************************Materiel*****************************************/
	
	@PostMapping(value="/addM",consumes = {"application/json"})
	private String addMateriels(@RequestBody Materiel a) {
		mr.save(a);
		return "materiel added successfully.";
	}
	
	@GetMapping("/getM")
	private List<Materiel> getMateriels(){
		return mr.findAll();
	}
	
	@GetMapping("/getM/{id}")
	private Materiel getMateriel(@PathVariable long id) {
		return mr.findById(id).get();
	}
	
	@PutMapping("/updateM/{id}")
	private String updateMateriel(@PathVariable long id,@RequestBody Materiel p) {
		p.setId(id);
		mr.save(p);
		return "Materiel updated successfully.";
	}
	
	@DeleteMapping("/deleteM/{id}")
	private String deleteMateriel(@PathVariable long id) {
		mr.deleteById(id);
		return "Materiel "+ id +" deleted successfully.";
	}
	
/*****************************Salle*****************************************/
	
	@Autowired
	private SalleRepository sr;
	
	@PostMapping("/addS")
	private String addSalles(@RequestBody List<Salle> a) {
		sr.saveAll(a);
		return "Salles added successfully.";
	}
	
	@GetMapping("/getS")
	private List<Salle> getSalles(){
		return sr.findAll();
	}
	
	@GetMapping("/getS/{id}")
	private Salle getSalle(@PathVariable long id) {
		return sr.findById(id).get();
	}
	
	@PutMapping("/updateS/{id}")
	private String updateSalle(@PathVariable long id,@RequestBody Salle p) {
		p.setId(id);
		sr.save(p);
		return "Salle updated successfully.";
	}
	
	@DeleteMapping("/deleteS/{id}")
	private String deleteSalle(@PathVariable long id) {
		sr.deleteById(id);
		return "Salle "+ id +" deleted successfully.";
	}

	/*******************************************Gardien****************************************/
	
	@Autowired
	private GardienRepository gr;
	
	@PostMapping("/addG")
	private String addGarde(@RequestBody List<Gardien> a) {
		gr.saveAll(a);
		return "Gardiens added successfully.";
	}
	
	@GetMapping("/getG")
	private List<Gardien> getGardiens(){
		return gr.findAll();
	}
	
	@GetMapping("/getG/{id}")
	private Gardien getGarde(@PathVariable long id) {
		return gr.findById(id).get();
	}
	
	@PutMapping("/updateG/{id}")
	private String updateGarde(@PathVariable long id,@RequestBody Gardien p) {
		p.setId(id);
		gr.save(p);
		return "Gardien updated successfully.";
	}
	
	@DeleteMapping("/deleteG/{id}")
	private String deleteGarde(@PathVariable long id) {
		gr.deleteById(id);
		return "Gardien "+ id +" deleted successfully.";
	}
	
	/*************************************Municipal***********************************/
	
	@Autowired
	private MunicipalRepository mer;
	
	@PostMapping("/addMe")
	private String addMuni(@RequestBody List<Municipal> a) {
		mer.saveAll(a);
		return "Municipaux added successfully.";
	}
	
	@GetMapping("/getMe")
	private List<Municipal> getMuni(){
		return mer.findAll();
	}
	
	@GetMapping("/getMe/{id}")
	private Municipal getMuni(@PathVariable long id) {
		return mer.findById(id).get();
	}
	
	@PutMapping("/updateMe/{id}")
	private String updateMuni(@PathVariable long id,@RequestBody Municipal p) {
		p.setId(id);
		mer.save(p);
		return "Municipal updated successfully.";
	}
	
	@DeleteMapping("/deleteMe/{id}")
	private String deleteMuni(@PathVariable long id) {
		mer.deleteById(id);
		return "Municipal "+ id +" deleted successfully.";
	}


}
