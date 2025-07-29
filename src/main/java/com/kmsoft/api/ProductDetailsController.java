package com.kmsoft.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmsoft.model.Product;
import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.model.ProductValidators;
import com.kmsoft.repository.ProductValidatorsRepository;
import com.kmsoft.service.ProductService;
import com.kmsoft.service.ProductUpdateHistoryService;
import com.kmsoft.service.PurchaseBillProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController

public class ProductDetailsController {

    @Autowired
    ProductService productservice;

    @Autowired
    ProductUpdateHistoryService productUpdateHistoryService;

    @Autowired
    PurchaseBillProductService purchaseBillProductService;

    @Autowired
    ProductValidatorsRepository pvRepo;

    //@CrossOrigin("*")
    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        return productservice.getAllProducts();
    }

    //@CrossOrigin("*")
    @GetMapping("/products/{id}")
    public Product getProductsById(@PathVariable Integer id) {
        return productservice.getoneById(id);
    }

    // save product
    //@CrossOrigin("*")
    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        if (product.getPrimaryUnit() == null) {
            product.setPrimaryUnit("qty");
        }
        if (product.getSecondaryUnit() == null) {
            String su = product.getPrimaryUnit();

            product.setSecondaryUnit(su);
        }
        if (product.getUnitConversion() == 0) {
            product.setUnitConversion(1);
        }

        product.setIsAliveProduct(1);
        return productservice.createProduct(product);

    }

    //@CrossOrigin("*")
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @Valid @RequestBody Product product) {
        return productservice.updateProduct(id, product);

    }

    //@CrossOrigin("*")
    @PutMapping("/deleteproducts")

    public void deleteProduct(@RequestParam int id) {
        productservice.deleteProduct(id);
    }

    //@CrossOrigin("*")
    @GetMapping("/productsLike/{productlike}")
    public List<Product> getproductlike(@PathVariable String productlike) {
        return productservice.getproductlike(productlike);
    }

    //@CrossOrigin("*")
    @GetMapping("/products/lowstock")
    public List<Product> getLowStock() {
        return productservice.getLowStock();
    }

    //@CrossOrigin("*")
    @GetMapping("/products/stockInHand")
    public int getStockInHand() {
        return productservice.getStockInHand();
    }

    //@CrossOrigin("*")
    @GetMapping("/products/totalProductCount")
    public int getTotalproductcount() {
        return productservice.getTotalproductcount();
    }

    //@CrossOrigin("*")
    @GetMapping("/prd")
    public Page<Product> getAllProducts(@RequestParam(required = false) String title,
                                        @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        List<Product> tutorials = new ArrayList<Product>();
        Pageable paging = PageRequest.of(page, size);
        Page<Product> pageTuts;

        if (title == null) {
            pageTuts = productservice.getAllproduct(paging);

        } else {
            pageTuts = productservice.findByProductNameContaining(title, paging);
        }
        return pageTuts;

    }

    //@CrossOrigin("*")
    @RequestMapping("/updatequantity/{id}")
    public void updateQuantity(@PathVariable int id, @RequestParam() String qty) {
        productservice.updateProductQuantity(id, qty, "purchase");
    }

    //@CrossOrigin("*")
    @GetMapping("/inventoryReports")
    public Page<List<Map<String, Object>>> getInventoryReport(

            @RequestParam(required = false) String title, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<List<Map<String, Object>>> data;

        Pageable paging = PageRequest.of(page, size);

        if (title == null) {

            data = productservice.getInventoryReport(paging);

        } else {

            data = productservice.getInventoryReportTitle(title, paging);

        }
        return data;

    }

    //@CrossOrigin("*")
    @PostMapping("/productValidators")
    public ProductValidators createProductValidators(@RequestBody ProductValidators pv) {
        return pvRepo.save(pv);
    }

    //@CrossOrigin("*")
    @GetMapping("/productValidators")
    public Optional<ProductValidators> getPv() {
        return pvRepo.findById(1);
    }

    //@CrossOrigin("*")
    @PatchMapping("/adjustbatch")
    @Transactional(rollbackOn = {Exception.class})
    public void adjustbatch(@RequestBody String adjustbatch) {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject jsonobj = new JSONObject(adjustbatch);

        ProductUpdateHistory productUpdateHistory = new ProductUpdateHistory();
        try {
            productUpdateHistory = objectMapper.readValue(jsonobj.get("updatehst").toString(), ProductUpdateHistory.class);
            productUpdateHistoryService.createProductUpdateHistory(productUpdateHistory);

            JSONObject o = (JSONObject) jsonobj.get("batchQty");
            int pbpid = o.getInt("pbpid");
            String qty = o.get("qty").toString();
            purchaseBillProductService.updatAvailableQty(pbpid, qty);

            JSONObject o1 = (JSONObject) jsonobj.get("batchRate");
            int pbpid1 = o1.getInt("id");
            String rate = o1.get("rate").toString();
            System.out.println(rate + " " + "rate");

            purchaseBillProductService.updatRate(pbpid1, rate);

            JSONObject pqu = (JSONObject) jsonobj.get("productQuantityUpdate");
            int productid = pqu.getInt("id");
            String productqty = pqu.get("quantity").toString();
            productservice.updateProductQuantityBatchAdjust(productid, productqty);

        } catch (JsonProcessingException | JSONException e) {

            e.printStackTrace();
        }

    }

    //@CrossOrigin("*")
    @GetMapping("/topmovingproducts")
    public List<Product> getTopMovingProducts() {
        return productservice.getTopMovingproducts();

    }

    //@CrossOrigin("*")
    @GetMapping("/test")
    public String getsample() {
        return "test executed";
    }

    @RequestMapping(value = "/uploadProduct", method = RequestMethod.POST)
    public ResponseEntity<String> uploadProduct(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("{\"message\": \"Please select a file to upload.\"}");
        }
        Optional<String> extension = Optional.ofNullable(file.getOriginalFilename()).filter(f -> f.contains("."))
                .map(m -> m.substring(m.lastIndexOf(".") + 1));
        if (!(extension.filter(f -> f.equals("xlsx") || f.equals("xls")).isPresent())) {
            ResponseEntity<String> notAnExcelFile = ResponseEntity.badRequest().body("{\"message\": \"Invalid file type. Only .xlsx and .xls are allowed.\"}");
            return notAnExcelFile;
        }
        try {
            InputStream workbookFile = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(workbookFile);
            productservice.uploadProductSheet(workbook);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return ResponseEntity.ok("sucessfull");
    }

}
