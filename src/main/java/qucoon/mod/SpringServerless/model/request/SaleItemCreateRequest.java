package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class SaleItemCreateRequest {
@NotNull(message = "saleItemProductId is required")
public int saleItemProductId;
@NotNull(message = "saleItemQuantity is required")
public int saleItemQuantity;
@NotNull(message = "saleItemSaleId is required")
public int saleItemSaleId;
public Double saleItemTotal;
public Double saleItemUnitPrice;
}
