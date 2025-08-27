package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class InventoryItemReadRequest {
@NotEmpty(message = "Inventoryitemavailablestock is required")
public int inventoryItemAvailableStock;
@NotEmpty(message = "Inventoryitemcategory is required")
public String inventoryItemCategory;
@NotEmpty(message = "Inventoryitemcreatedat is required")
public String inventoryItemCreatedAt;
@NotEmpty(message = "Inventoryitemcurrentstock is required")
public int inventoryItemCurrentStock;
@NotEmpty(message = "Inventoryitemdescription is required")
public String inventoryItemDescription;
@NotEmpty(message = "Inventoryitemid is required")
public int inventoryItemId;
@NotEmpty(message = "Inventoryitemminimumstocklevel is required")
public int inventoryItemMinimumStockLevel;
@NotEmpty(message = "Inventoryitemname is required")
public String inventoryItemName;
@NotEmpty(message = "Inventoryitemreservedstock is required")
public int inventoryItemReservedStock;
@NotEmpty(message = "Inventoryitemstatus is required")
public String inventoryItemStatus;
@NotEmpty(message = "Inventoryitemunitcost is required")
public Double inventoryItemUnitCost;
@NotEmpty(message = "Inventoryitemunitofmeasure is required")
public String inventoryItemUnitOfMeasure;
@NotEmpty(message = "Inventoryitemupdatedat is required")
public String inventoryItemUpdatedAt;
}
