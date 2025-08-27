package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.InventoryItem;


@Data
public class InventoryItemDto  {

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

public static InventoryItemDto from(InventoryItem p) {
    InventoryItemDto dto = new InventoryItemDto();

    dto.setInventoryItemAvailableStock(p.getInventoryItemAvailableStock());
    dto.setInventoryItemCategory(p.getInventoryItemCategory());
    dto.setInventoryItemCreatedAt(p.getInventoryItemCreatedAt());
    dto.setInventoryItemCurrentStock(p.getInventoryItemCurrentStock());
    dto.setInventoryItemDescription(p.getInventoryItemDescription());
    dto.setInventoryItemId(p.getInventoryItemId());
    dto.setInventoryItemMinimumStockLevel(p.getInventoryItemMinimumStockLevel());
    dto.setInventoryItemName(p.getInventoryItemName());
    dto.setInventoryItemReservedStock(p.getInventoryItemReservedStock());
    dto.setInventoryItemStatus(p.getInventoryItemStatus());
    dto.setInventoryItemUnitCost(p.getInventoryItemUnitCost());
    dto.setInventoryItemUnitOfMeasure(p.getInventoryItemUnitOfMeasure());
    dto.setInventoryItemUpdatedAt(p.getInventoryItemUpdatedAt());
    return dto;
   }
}
