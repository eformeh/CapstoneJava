package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class InventoryItemCreateRequest {
@NotNull(message = "inventoryItemAvailableStock is required")
public int inventoryItemAvailableStock;
public String inventoryItemCategory;
@NotNull(message = "inventoryItemCurrentStock is required")
public int inventoryItemCurrentStock;
public String inventoryItemDescription;
@NotNull(message = "inventoryItemMinimumStockLevel is required")
public int inventoryItemMinimumStockLevel;
public String inventoryItemName;
@NotNull(message = "inventoryItemReservedStock is required")
public int inventoryItemReservedStock;
public Double inventoryItemUnitCost;
public String inventoryItemUnitOfMeasure;
}
