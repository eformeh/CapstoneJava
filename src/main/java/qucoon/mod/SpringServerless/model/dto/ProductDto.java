package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Product;


@Data
public class ProductDto  {

private String productBarcode;
private String productCategory;
private String productCreatedAt;
private String productDescription;
private Integer productId;
private Integer productMinimumThreshold;
private String productName;
private Double productPrice;
private String productSKU;
private String productStatus;
private Integer productStockQuantity;
private String productUpdatedAt;

public static ProductDto from(Product p) {
    ProductDto dto = new ProductDto();

    dto.setProductBarcode(p.getProductBarcode());
    dto.setProductCategory(p.getProductCategory());
    dto.setProductCreatedAt(p.getProductCreatedAt());
    dto.setProductDescription(p.getProductDescription());
    dto.setProductId(p.getProductId());
    dto.setProductMinimumThreshold(p.getProductMinimumThreshold());
    dto.setProductName(p.getProductName());
    dto.setProductPrice(p.getProductPrice());
    dto.setProductSKU(p.getProductSKU());
    dto.setProductStatus(p.getProductStatus());
    dto.setProductStockQuantity(p.getProductStockQuantity());
    dto.setProductUpdatedAt(p.getProductUpdatedAt());
    return dto;
   }
}
