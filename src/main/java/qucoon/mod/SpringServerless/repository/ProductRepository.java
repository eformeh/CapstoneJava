
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.ProductPage;
import qucoon.mod.SpringServerless.model.request.ProductFilterRequest;

import java.util.List;

@Repository
    public interface ProductRepository {


    // Additional query methods can be defined here.
    int create(Product product);
    void bulkCreate(List<Product>  product);
    int update(Product  product);
    int delete(int productId);
    ProductPage findProduct(ProductFilterRequest filter);
    boolean truncate();
    List<Product> read();
    List<Product> readByProductBarcode(String productBarcode);
    List<Product> readByProductCategory(String productCategory);
    List<Product> readByProductCreatedAt(String productCreatedAt);
    List<Product> readByProductDescription(String productDescription);
    Product readByProductId(int productId);
    List<Product> readByProductMinimumThreshold(int productMinimumThreshold);
    List<Product> readByProductName(String productName);
    List<Product> readByProductPrice(Double productPrice);
    List<Product> readByProductSKU(String productSKU);
    List<Product> readByProductStatus(String productStatus);
    List<Product> readByProductStockQuantity(int productStockQuantity);
    List<Product> readByProductUpdatedAt(String productUpdatedAt);
}
