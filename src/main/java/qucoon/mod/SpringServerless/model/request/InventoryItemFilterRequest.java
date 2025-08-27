package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class InventoryItemFilterRequest {

private Integer inventoryItemAvailableStock;
private String inventoryItemCategory;
private String inventoryItemCreatedAt;
private Integer inventoryItemCurrentStock;
private String inventoryItemDescription;
private Integer inventoryItemId;
private Integer inventoryItemMinimumStockLevel;
private String inventoryItemName;
private Integer inventoryItemReservedStock;
private String inventoryItemStatus;
private Double inventoryItemUnitCost;
private String inventoryItemUnitOfMeasure;
private String inventoryItemUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
