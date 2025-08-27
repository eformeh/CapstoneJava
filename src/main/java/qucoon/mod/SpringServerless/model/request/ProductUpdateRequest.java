package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductUpdateRequest {
public String productBarcode;
public String productCategory;
public String productCreatedAt;
public String productDescription;
public int productId;
public int productMinimumThreshold;
public String productName;
public Double productPrice;
public String productSKU;
public String productStatus;
public int productStockQuantity;
public String productUpdatedAt;
}
