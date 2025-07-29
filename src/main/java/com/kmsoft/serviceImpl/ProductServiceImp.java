package com.kmsoft.serviceImpl;

import com.kmsoft.model.Product;
import com.kmsoft.repository.ProductRepository;
import com.kmsoft.repository.PurchaseBillProductRepository;
import com.kmsoft.service.ProductService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImp implements ProductService {

	private static final Map<String,String> expectedHeader =new HashMap<>();
	static {
		expectedHeader.put("productName","productName");
		expectedHeader.put("productQuantity","productQuantity");
		expectedHeader.put("isAliveProduct","isAliveProduct");
	}

    @Autowired
    ProductRepository productRepo;
    @Autowired
    PurchaseBillProductRepository pbpRepo;

    @Override
    public List<Product> getAllProducts() {

        return productRepo.findAll();
    }

    public Product createProduct(Product product) {

        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product product) {
        Product prod = productRepo.findById(id);
        prod.setProductId(product.getProductId());
        prod.setProductKey(product.getProductKey());
        prod.setProductName(product.getProductName());
        prod.setProductQuantity(product.getProductQuantity() + prod.getProductQuantity());
        prod.setBrand(product.getBrand());
        prod.setManufacturer(product.getManufacturer());
        prod.setCostPrice(product.getCostPrice());
        prod.setSellingPrice(product.getSellingPrice());
        prod.setDimension(product.getDimension());
        prod.setManufacturePartNumber(product.getManufacturePartNumber());
        prod.setProductgroup(product.getProductgroup());
        prod.setUnitConversion(product.getUnitConversion());
        prod.setPrimaryUnit(product.getPrimaryUnit());
        prod.setSecondaryUnit(product.getSecondaryUnit());
        prod.setUniversalProductCode(product.getUniversalProductCode());
        prod.setWeight(product.getWeight());
        prod.setBatch(product.getBatch());

        return productRepo.saveAndFlush(prod);
    }

    @Override
    public void deleteProduct(int id) {

        productRepo.deleteProductsById(id);
    }

    @Override
    public Product getoneById(int id) {
        // TODO Auto-generated method stub
        return productRepo.findById(id);
    }

    @Override
    public List<Product> getproductlike(String productlike) {
        // TODO Auto-generated method stub
        String sproductlike = "%" + productlike;
        return productRepo.getProductLike(sproductlike);
    }

    @Override
    public List<Product> getLowStock() {
        // TODO Auto-generated method stub
        return productRepo.getLowStock();
    }

    @Override
    public int getStockInHand() {
        // TODO Auto-generated method stub
        return productRepo.getStockinHand();
    }

    @Override
    public int getTotalproductcount() {
        // TODO Auto-generated method stub
        return productRepo.getTotalproduct();
    }

    @Override
    public Page<Product> findByProductNameContaining(String title, Pageable paging) {
        // TODO Auto-generated method stub
        String stitle = "%" + title + "%";
        return productRepo.findByProductNameContaining(stitle, paging);
    }

    @Override
    public Page<List<Map<String, Object>>> getInventoryReport(Pageable paging) {
        // TODO Auto-generated method stub
        return productRepo.getInventoryReport(paging);
    }

    @Override
    public Page<List<Map<String, Object>>> getInventoryReportTitle(String title, Pageable paging) {
        // TODO Auto-generated method stub
        String stitle = "%" + title + "%";
        return productRepo.getInventoryReportTitle(stitle, paging);
    }

    @Override
    public Page<Product> getAllproduct(Pageable paging) {
        // TODO Auto-generated method stub
        return productRepo.findAll(paging);
    }

    @Override
    public void updateProductQuantity(int id, String qty, String updatefrom) {

        productRepo.updateProductQuantityLess(id, qty, updatefrom);

    }

    @Override
    public void updatebatchQuantity(int id, String qty, int batch) {
        // TODO Auto-generated method stub
        pbpRepo.updateBatchQuantity(id, qty, batch);

    }

    @Override
    public void updateProductQuantityBatchAdjust(int id, String qty) {
        // TODO Auto-generated method stub

        productRepo.updateProductQuantityMore(id, qty);

    }

    @Override
    public List<Product> getTopMovingproducts() {
        // TODO Auto-generated method stub
        return productRepo.getTopMovingproducts();
    }

    public void uploadProductSheet(Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
       List<Product> productsToSave = new ArrayList<>();
		Row headerRow = iterator.next();
		Map<String, Integer> columnNameToIndexMap = readHeaderAndMapColumns(headerRow);
        while (iterator.hasNext()) {

			Row currentRow =iterator.next();
			Product product = new Product();
			try{
				product.setProductName(getCellValueOrNull(currentRow,columnNameToIndexMap,"productName"));
				product.setIsAliveProduct(parseInteger(getCellValueOrNull(currentRow,columnNameToIndexMap,"isAliveProduct")));
				product.setProductQuantity(parseInteger(getCellValueOrNull(currentRow,columnNameToIndexMap,"productQuantity")));

				productsToSave.add(product);

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			productRepo.saveAll(productsToSave);


                    }


    }
   Map<String, Integer> readHeaderAndMapColumns(Row headerRow){
		Map<String, Integer> columnMap = new HashMap<>();
		for(Cell cell :headerRow){
			String headerName = cell.getStringCellValue();
			if(expectedHeader.containsKey(headerName)){
				columnMap.put(headerName,cell.getColumnIndex());
			}
		}
		return columnMap;
}

	private String getCellValueOrNull(Row row, Map<String, Integer> columnMap, String headerName) {
		Integer colIndex = columnMap.get(headerName);
		if (colIndex == null) {
			// Header not found in the Excel file, return null
			return null;
		}
		Cell cell = row.getCell(colIndex);
		return cell.getStringCellValue();
	}
	private Integer parseInteger(String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		try {
			// Handle cases where numeric value might be read as "123.0" from Excel
			return new BigDecimal(value.trim()).intValueExact();
		} catch (ArithmeticException | NumberFormatException e) {
			throw new IllegalArgumentException("Invalid number format for integer: '" + value + "'", e);
		}
	}
}

