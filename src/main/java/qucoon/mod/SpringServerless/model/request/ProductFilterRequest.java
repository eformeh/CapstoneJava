package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductFilterRequest {

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
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
