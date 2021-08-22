package com.kmsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmsoft.model.Brand;
import com.kmsoft.model.Manufacturer;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
