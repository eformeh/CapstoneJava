package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class ProductCreateRequest {
public String productBarcode;
public String productCategory;
public String productDescription;
@NotNull(message = "productMinimumThreshold is required")
public int productMinimumThreshold;
public String productName;
public Double productPrice;
public String productSKU;
@NotNull(message = "productStockQuantity is required")
public int productStockQuantity;
}
