package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
	@Autowired
	private BillRepository billRepository;
	public List<Bill> findAll() {
		return this.billRepository.findAll();
	}	
	public Bill findById(Integer id) {
		return this.billRepository.findOne(id);
	}
	
	public Bill save(Bill b) {
		return billRepository.save(b);
	}
	
	public void deleteBill(Bill b) {
		this.billRepository.delete(b);;
	}

	public void deleteAll() {
		this.billRepository.deleteAll();
	}
}

