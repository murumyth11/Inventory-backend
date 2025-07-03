package com.kmsoft.repository;

import com.kmsoft.model.PurchaseBillProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PurchaseBillProductRepository extends JpaRepository<PurchaseBillProduct, Integer> {

	
	@Query(value = "select * from purchase_bill_product where purchasebill_fk=:id",nativeQuery = true)
	List<PurchaseBillProduct> findAllbyid(int id);

	
	@Query(value = "select * from purchase_bill_product where product_fk=:id order by pbp_id desc",nativeQuery = true)
	List<PurchaseBillProduct> getbatchcode(int id);

	
	@Modifying
    @Transactional 
	@Query(value = "update purchase_bill_product set availablequantity=availablequantity - :qty where pbp_id=:batch and product_fk=:id",nativeQuery = true)
	void updateBatchQuantity(int id,String qty,int batch);


	@Query(value = "select * from purchase_bill_product where product_fk=:id order by pbp_id desc",nativeQuery = true)
	Page<PurchaseBillProduct> findAllBatchById(int id, Pageable paging);


	@Query(value = "select * from purchase_bill_product where product_fk=:id and batch like :title order by pbp_id desc",nativeQuery = true)
	Page<PurchaseBillProduct> findByIdContaining(String title, int id, Pageable paging);

  @Query(value = "select * from purchase_bill_product where pbp_id=:id ",nativeQuery = true)
	PurchaseBillProduct getavailableqty(int id);


  @Query(value = "select ifnull(sum(p.availablequantity),0) as currentstockquantity,sum(p.availablequantity*p.costprice) as currentstockvalue from purchase_bill_product p join product pt on p.product_fk=pt.product_id cross join (select sum(amount) as amount from billproduct) b where pt.isaliveproduct=1",nativeQuery = true)
Map<String, Number> gettotalstockinfo();

  @Modifying
  @Transactional 
  @Query(value="update purchase_bill_product set availablequantity=availablequantity + :qty where pbp_id=:id",nativeQuery = true)
void updateAvailableqty(int id, String qty);


  @Modifying
  @Transactional 
	@Query(value = "update purchase_bill_product set rate=:rate where pbp_id=:pbpid1",nativeQuery = true)
	void updateRate(int pbpid1, String rate);


  @Query(value = "select concat(sum(pbp.availablequantity),' ',p.secondaryunit) as instock,p.product_name from purchase_bill_product pbp join product p on p.product_id=pbp.product_fk where pbp.warehouse_fk=:warehouseid and p.product_name like :title group by pbp.product_fk,pbp.warehouse_fk",countQuery = 
		  "select count(*) from (select p.product_name from purchase_bill_product pbp join product p on p.product_id=pbp.product_fk  group by pbp.product_fk,pbp.warehouse_fk) as cnt",nativeQuery = true)
Page<List<Map<String, Object>>> getWarehouseProducts(String title,Pageable paging,int warehouseid);
}
