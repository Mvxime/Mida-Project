package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GardienRepository;
import com.example.demo.dao.MaterielRepository;
import com.example.demo.dao.SalleRepository;
import com.example.demo.models.Gardien;
import com.example.demo.models.Materiel;
import com.example.demo.models.Salle;

@RestController
public class ExtraServices {
	
	@Autowired
	private MaterielRepository mr;
	@Autowired 
	private SalleRepository sr;
	@Autowired
	private GardienRepository gr;

	@PostMapping("/mts/{mid}/{sid}")
	public Materiel ajoutSalle(@PathVariable long mid,@PathVariable long sid) {
		Salle c = sr.findById(sid).get();
		Materiel e = mr.findById(mid).get();
		e.setMsalle(c);
		return mr.save(e);
	}
	
	@PostMapping("/gts/{gid}/{sid}")
	public Gardien ajoutSa(@PathVariable long gid,@PathVariable long sid) {
		Salle c = sr.findById(sid).get();
		Gardien e = gr.findById(gid).get();
		e.setSalle(c);
		return gr.save(e);
	}
	
	
	
}
