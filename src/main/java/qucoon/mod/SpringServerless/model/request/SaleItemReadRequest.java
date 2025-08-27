package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SaleItemReadRequest {
@NotEmpty(message = "Saleitemcreatedat is required")
public String saleItemCreatedAt;
@NotEmpty(message = "Saleitemid is required")
public int saleItemId;
@NotEmpty(message = "Saleitemproductid is required")
public int saleItemProductId;
@NotEmpty(message = "Saleitemquantity is required")
public int saleItemQuantity;
@NotEmpty(message = "Saleitemsaleid is required")
public int saleItemSaleId;
@NotEmpty(message = "Saleitemstatus is required")
public String saleItemStatus;
@NotEmpty(message = "Saleitemtotal is required")
public Double saleItemTotal;
@NotEmpty(message = "Saleitemunitprice is required")
public Double saleItemUnitPrice;
@NotEmpty(message = "Saleitemupdatedat is required")
public String saleItemUpdatedAt;
}
