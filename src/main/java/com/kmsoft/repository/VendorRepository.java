package com.kmsoft.repository;

import com.kmsoft.model.Vendors;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendors, Integer>{
	public Vendors findByVendorMobile(String vendorMobile);
	
	Page<Vendors> findAll(Pageable pageable);

	@Query(value="SELECT * FROM vendors WHERE (vendor_name LIKE :title"+" OR vendor_mobile LIKE :title "
			 +" OR vendorgstin LIKE :title "
					 +" OR vendor_address LIKE :title) and isalivevendor=1 ",nativeQuery = true)
			 Page<Vendors> findByVendorNameContaining(String title,Pageable pageable);

	@Query(value="SELECT * FROM vendors WHERE (vendor_name LIKE :namelike"+" OR vendor_mobile LIKE :namelike "
			 +" OR vendorgstin LIKE :namelike ) and isalivevendor=1"
					 ,nativeQuery = true)
	public List<Vendors> getvendorsLike(String namelike);

	@Modifying
	@Transactional
	@Query(value = "update vendors set isalivevendor=0 where vendor_id=:id",nativeQuery = true)
	public void deleteVendorsById(int id);

}
