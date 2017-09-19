package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
	@Autowired
	private BillService billService;

	@RequestMapping(value="/bills", method=RequestMethod.GET)
	public List<Bill> findAll() {
		return this.billService.findAll();
	}
	
	@RequestMapping(value="/bills/{idBill}", method=RequestMethod.GET)
	public Bill findById(@PathVariable("idBill") Integer id) {
		Bill b = this.billService.findById(id);
		return b;
	}
	
	@RequestMapping(value="/bills", method=RequestMethod.POST)
	public ResponseEntity<Bill> saveBill(@RequestBody Bill b) {
		if(b != null)
			if(b.getId() != null)
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
			else
				return ResponseEntity.status(HttpStatus.OK).body(this.billService.save(b));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	}

	@RequestMapping(value="/bills/{idBill}", method=RequestMethod.PUT) 
	public Bill updateBill(@PathVariable("idBill") Integer id, @RequestBody Bill b) {
		Bill fromDB = this.billService.findById(id);
		if(fromDB != null) {
			b.setId(fromDB.getId());
			return this.billService.save(b);
		}
		return null;			
	}
	
	@RequestMapping(value="/bills/{idBill}", method=RequestMethod.DELETE) 
	public ResponseEntity<Bill> deleteBill(@PathVariable("idBill") Integer id) {
		Bill fromDB = this.billService.findById(id);
		if(fromDB != null) {
			this.billService.deleteBill(fromDB);
			return ResponseEntity.status(HttpStatus.OK).body(fromDB);			
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
	}

	@RequestMapping(value="/bills", method=RequestMethod.DELETE) 
	public void deleteAllBills() {
		this.billService.deleteAll();			
	}


}