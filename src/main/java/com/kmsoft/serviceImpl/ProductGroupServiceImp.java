package com.kmsoft.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmsoft.model.ProductGroup;
import com.kmsoft.repository.ProductGroupRepository;
import com.kmsoft.service.ProductGroupService;
import com.kmsoft.service.ProductService;

@Service
public class ProductGroupServiceImp implements ProductGroupService {

	@Autowired
	ProductGroupRepository pgRepo;
	
	@Override
	public List<ProductGroup> getAllProductGroup() {
		// TODO Auto-generated method stub
		return pgRepo.findAllgroup() ;
	}

	@Override
	public ProductGroup createpg(ProductGroup productgroup) {
		// TODO Auto-generated method stub
		return pgRepo.save(productgroup);
	}

	@Override
	public ProductGroup updatepg(ProductGroup productgroup) {
		// TODO Auto-generated method stub
		return pgRepo.saveAndFlush(productgroup);
	}

	@Override
	public void deleteProductgroup(int id) {
		pgRepo.deletegroupbyId(id);
		
	}

}
