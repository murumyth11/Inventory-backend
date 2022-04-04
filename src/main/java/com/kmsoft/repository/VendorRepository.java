package com.kmsoft.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.Product;
import com.kmsoft.model.Vendors;

@Repository
public interface VendorRepository extends JpaRepository<Vendors, Integer>{
	public Vendors findByVendorMobile(String vendorMobile);
	
	Page<Vendors> findAll(Pageable pageable);

	@Query(value="SELECT * FROM vendors WHERE vendor_name LIKE %:title%"+" OR vendor_mobile LIKE %:title% "
			 +" OR vendorgstin LIKE %:title% "
					 +" OR vendor_address LIKE %:title% ",nativeQuery = true)
			 Page<Vendors> findByVendorNameContaining(String title,Pageable pageable);

	@Query(value="SELECT * FROM vendors WHERE vendor_name LIKE %:namelike%"+" OR vendor_mobile LIKE %:namelike% "
			 +" OR vendorgstin LIKE %:namelike% "
					 ,nativeQuery = true)
	public List<Vendors> getvendorsLike(String namelike);

}
