package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class InventoryItemUpdateRequest {
public int inventoryItemAvailableStock;
public String inventoryItemCategory;
public String inventoryItemCreatedAt;
public int inventoryItemCurrentStock;
public String inventoryItemDescription;
public int inventoryItemId;
public int inventoryItemMinimumStockLevel;
public String inventoryItemName;
public int inventoryItemReservedStock;
public String inventoryItemStatus;
public Double inventoryItemUnitCost;
public String inventoryItemUnitOfMeasure;
public String inventoryItemUpdatedAt;
}
