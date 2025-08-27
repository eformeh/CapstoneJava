package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SaleItemUpdateRequest {
public String saleItemCreatedAt;
public int saleItemId;
public int saleItemProductId;
public int saleItemQuantity;
public int saleItemSaleId;
public String saleItemStatus;
public Double saleItemTotal;
public Double saleItemUnitPrice;
public String saleItemUpdatedAt;
}
