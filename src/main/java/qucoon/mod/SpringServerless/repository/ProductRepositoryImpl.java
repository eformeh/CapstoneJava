
package   qucoon.mod.SpringServerless.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.repository.query.*;
import qucoon.mod.SpringServerless.utility.Environment;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.repository.page.*;
import qucoon.mod.SpringServerless.model.entity.Module;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import java.util.List;

import static qucoon.mod.SpringServerless.repository.query.QueryUtils.createQueryWithoutOnMappingFailure;


@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Environment environment;

    @Autowired
    public ProductRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Product  product) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int productId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), ProductQuery.INSERT, true)
                .bind (product)
                .executeUpdate()
                .getKey(int.class);


        return productId;
    }

    @Override
    public void bulkCreate(List<Product> products) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,ProductQuery.INSERT, false);
            for (Product product : products) {
                query.bind(product).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Product product) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.UPDATE, true)
                .bind (product)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int productId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.DELETE, true)
                .addParameter("productId", productId)
                .executeUpdate()
                .getResult();
    }

    @Override
    public boolean truncate() {
        try {
            assert environment.getDatabaseUtil().getSql2oConnection() != null;
            return environment.getDatabaseUtil().getSql2oConnection()
                    .getJdbcConnection()
                    .createStatement()
                    .execute(ProductQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Product> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ, true)
                .executeAndFetch(Product.class);
    }
    @Override
    public List<Product> readByProductBarcode(String productBarcode) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTBARCODE, true)
                .addParameter("productBarcode", productBarcode)
                .executeAndFetch(Product.class);
    }
    @Override
    public List<Product> readByProductCategory(String productCategory) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTCATEGORY, true)
                .addParameter("productCategory", productCategory)
                .executeAndFetch(Product.class);
    }
    @Override
    public List<Product> readByProductCreatedAt(String productCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTCREATEDAT, true)
                .addParameter("productCreatedAt", productCreatedAt)
                .executeAndFetch(Product.class);
    }
    @Override
    public List<Product> readByProductDescription(String productDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTDESCRIPTION, true)
                .addParameter("productDescription", productDescription)
                .executeAndFetch(Product.class);
    }
    @Override
    public Product readByProductId(int productId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTID, true)
                .addParameter("productId", productId)
                .executeAndFetch (Product.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Product> readByProductMinimumThreshold(int productMinimumThreshold) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTMINIMUMTHRESHOLD, true)
                .addParameter(System.getenv("API_KEY_PRODUCTM"), productMinimumThreshold)
                .executeAndFetch(Product.class);
    }
    @Override
    public List<Product> readByProductName(String productName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTNAME, true)
                .addParameter("productName", productName)
                .executeAndFetch(Product.class);
    }
    @Override
    public List<Product> readByProductPrice(Double productPrice) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTPRICE, true)
                .addParameter("productPrice", productPrice)
                .executeAndFetch(Product.class);
    }
    @Override
    public List<Product> readByProductSKU(String productSKU) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTSKU, true)
                .addParameter("productSKU", productSKU)
                .executeAndFetch(Product.class);
    }
    @Override
    public List<Product> readByProductStatus(String productStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTSTATUS, true)
                .addParameter("productStatus", productStatus)
                .executeAndFetch(Product.class);
    }
    @Override
    public List<Product> readByProductStockQuantity(int productStockQuantity) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTSTOCKQUANTITY, true)
                .addParameter(System.getenv("API_KEY_PRODUCTS"), productStockQuantity)
                .executeAndFetch(Product.class);
    }
    @Override
    public List<Product> readByProductUpdatedAt(String productUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductQuery.READ_BY_PRODUCT_PRODUCTUPDATEDAT, true)
                .addParameter("productUpdatedAt", productUpdatedAt)
                .executeAndFetch(Product.class);
    }

@Override
public ProductPage findProduct(ProductFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(ProductQuery.READ);

    // Dynamic filters

    if (filter.getProductBarcode() != null) {   baseSql.append(" AND productBarcode = :productBarcode"); }
    if (filter.getProductCategory() != null) {   baseSql.append(" AND productCategory = :productCategory"); }
    if (filter.getProductCreatedAt() != null) {   baseSql.append(" AND productCreatedAt = :productCreatedAt"); }
    if (filter.getProductDescription() != null) {   baseSql.append(" AND productDescription = :productDescription"); }
    if (filter.getProductId() != null) {   baseSql.append(" AND productId = :productId"); }
    if (filter.getProductMinimumThreshold() != null) {   baseSql.append(" AND productMinimumThreshold = :productMinimumThreshold"); }
    if (filter.getProductName() != null) {   baseSql.append(" AND productName = :productName"); }
    if (filter.getProductPrice() != null) {   baseSql.append(" AND productPrice = :productPrice"); }
    if (filter.getProductSKU() != null) {   baseSql.append(" AND productSKU = :productSKU"); }
    if (filter.getProductStatus() != null) {   baseSql.append(" AND productStatus = :productStatus"); }
    if (filter.getProductStockQuantity() != null) {   baseSql.append(" AND productStockQuantity = :productStockQuantity"); }
    if (filter.getProductUpdatedAt() != null) {   baseSql.append(" AND productUpdatedAt = :productUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getProductBarcode() != null) countQuery.addParameter("productBarcode", filter.getProductBarcode());
     if (filter.getProductCategory() != null) countQuery.addParameter("productCategory", filter.getProductCategory());
     if (filter.getProductCreatedAt() != null) countQuery.addParameter("productCreatedAt", filter.getProductCreatedAt());
     if (filter.getProductDescription() != null) countQuery.addParameter("productDescription", filter.getProductDescription());
     if (filter.getProductId() != null) countQuery.addParameter("productId", filter.getProductId());
     if (filter.getProductMinimumThreshold() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTM"), filter.getProductMinimumThreshold());
     if (filter.getProductName() != null) countQuery.addParameter("productName", filter.getProductName());
     if (filter.getProductPrice() != null) countQuery.addParameter("productPrice", filter.getProductPrice());
     if (filter.getProductSKU() != null) countQuery.addParameter("productSKU", filter.getProductSKU());
     if (filter.getProductStatus() != null) countQuery.addParameter("productStatus", filter.getProductStatus());
     if (filter.getProductStockQuantity() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTS"), filter.getProductStockQuantity());
     if (filter.getProductUpdatedAt() != null) countQuery.addParameter("productUpdatedAt", filter.getProductUpdatedAt());
     if (filter.getSearch() != null) countQuery.addParameter("search", "%" + filter.getSearch() + "%");
     Long total = countQuery.executeScalar(Long.class);

   // MSSQL pagination requires ORDER BY for OFFSET/FETCH
    String validSortDir = filter.getSortDir().equalsIgnoreCase("ASC") ? "ASC" : "DESC";
    String orderBy = " ORDER BY " + sanitizeSortBy(filter.getSortBy()) + " " + validSortDir;
     // Append order and pagination
     StringBuilder pageSql_old = new StringBuilder(baseSql)
             .append(" ORDER BY ").append (filter.getSortBy())
             .append(" ").append (filter.getSortDir())
             .append("  OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY");
    // Build pagination SQL
    String pageSql = baseSql.toString() + orderBy +
" OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY";

     // Fetch page data
     var pageQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             pageSql.toString(),
             true);

    if (filter.getProductBarcode() != null) pageQuery.addParameter("productBarcode", filter.getProductBarcode());
    if (filter.getProductCategory() != null) pageQuery.addParameter("productCategory", filter.getProductCategory());
    if (filter.getProductCreatedAt() != null) pageQuery.addParameter("productCreatedAt", filter.getProductCreatedAt());
    if (filter.getProductDescription() != null) pageQuery.addParameter("productDescription", filter.getProductDescription());
    if (filter.getProductId() != null) pageQuery.addParameter("productId", filter.getProductId());
    if (filter.getProductMinimumThreshold() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTM"), filter.getProductMinimumThreshold());
    if (filter.getProductName() != null) pageQuery.addParameter("productName", filter.getProductName());
    if (filter.getProductPrice() != null) pageQuery.addParameter("productPrice", filter.getProductPrice());
    if (filter.getProductSKU() != null) pageQuery.addParameter("productSKU", filter.getProductSKU());
    if (filter.getProductStatus() != null) pageQuery.addParameter("productStatus", filter.getProductStatus());
    if (filter.getProductStockQuantity() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTS"), filter.getProductStockQuantity());
    if (filter.getProductUpdatedAt() != null) pageQuery.addParameter("productUpdatedAt", filter.getProductUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Product> data = pageQuery.executeAndFetch(Product.class);

     return new ProductPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "productBarcode","productCategory","productCreatedAt","productDescription","productId",System.getenv("API_KEY_PRODUCTM"),"productName","productPrice","productSKU","productStatus",System.getenv("API_KEY_PRODUCTS"),"productUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
