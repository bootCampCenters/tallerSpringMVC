package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	public List<Bill> getBillByVisitNotNull();
	public List<Bill> getBillByVisitNull();
}