package com.kmsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmsoft.model.Billproduct;

public interface BillRepository extends JpaRepository<Billproduct, Integer> {

}
