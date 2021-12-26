package com.kmsoft.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.repository.ProductUpdateHistoryRepository;
import com.kmsoft.service.ProductUpdateHistoryService;

@Service
public class ProductUpdateHistoryServiceImp implements ProductUpdateHistoryService {

	@Autowired
	ProductUpdateHistoryRepository puhRepo;
	
	@Override
	public ProductUpdateHistory createProductUpdateHistory(ProductUpdateHistory productupdtHst) {
		// TODO Auto-generated method stub
		return puhRepo.save(productupdtHst) ;
	}

	@Override
	public Page<List<ProductUpdateHistory>> findAllById(int id, Pageable paging) {
		// TODO Auto-generated method stub
		return puhRepo.findAllById(id, paging);
	}

	@Override
	public Page<List<ProductUpdateHistory>> findByUpdateDateContaining(String title, int id, Pageable paging) {
		// TODO Auto-generated method stub
		return puhRepo.findByUpdateDateContaining(title, id, paging);
	}

	@Override
	public int getSTockSold() {
		// TODO Auto-generated method stub
		return puhRepo.getSTockSold();
	}

}
