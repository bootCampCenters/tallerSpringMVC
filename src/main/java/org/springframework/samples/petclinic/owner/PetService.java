package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
	@Autowired
	private PetRepository petRepository;
	
	public void save(Pet pet) {
		this.petRepository.save(pet);
	}	
	public Pet findById(Integer id) {
		return this.petRepository.findById(id);
	}
	public List<PetType> findPetTypes() {
		return this.findPetTypes();
	}
}
