package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductReadRequest {
@NotEmpty(message = "Productbarcode is required")
public String productBarcode;
@NotEmpty(message = "Productcategory is required")
public String productCategory;
@NotEmpty(message = "Productcreatedat is required")
public String productCreatedAt;
@NotEmpty(message = "Productdescription is required")
public String productDescription;
@NotEmpty(message = "Productid is required")
public int productId;
@NotEmpty(message = "Productminimumthreshold is required")
public int productMinimumThreshold;
@NotEmpty(message = "Productname is required")
public String productName;
@NotEmpty(message = "Productprice is required")
public Double productPrice;
@NotEmpty(message = "Productsku is required")
public String productSKU;
@NotEmpty(message = "Productstatus is required")
public String productStatus;
@NotEmpty(message = "Productstockquantity is required")
public int productStockQuantity;
@NotEmpty(message = "Productupdatedat is required")
public String productUpdatedAt;
}
