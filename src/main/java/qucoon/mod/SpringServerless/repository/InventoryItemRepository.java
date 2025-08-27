
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.InventoryItemPage;
import qucoon.mod.SpringServerless.model.request.InventoryItemFilterRequest;

import java.util.List;

@Repository
    public interface InventoryItemRepository {


    // Additional query methods can be defined here.
    int create(InventoryItem inventoryitem);
    void bulkCreate(List<InventoryItem>  inventoryitem);
    int update(InventoryItem  inventoryitem);
    int delete(int inventoryItemId);
    InventoryItemPage findInventoryItem(InventoryItemFilterRequest filter);
    boolean truncate();
    List<InventoryItem> read();
    List<InventoryItem> readByInventoryItemAvailableStock(int inventoryItemAvailableStock);
    List<InventoryItem> readByInventoryItemCategory(String inventoryItemCategory);
    List<InventoryItem> readByInventoryItemCreatedAt(String inventoryItemCreatedAt);
    List<InventoryItem> readByInventoryItemCurrentStock(int inventoryItemCurrentStock);
    List<InventoryItem> readByInventoryItemDescription(String inventoryItemDescription);
    InventoryItem readByInventoryItemId(int inventoryItemId);
    List<InventoryItem> readByInventoryItemMinimumStockLevel(int inventoryItemMinimumStockLevel);
    List<InventoryItem> readByInventoryItemName(String inventoryItemName);
    List<InventoryItem> readByInventoryItemReservedStock(int inventoryItemReservedStock);
    List<InventoryItem> readByInventoryItemStatus(String inventoryItemStatus);
    List<InventoryItem> readByInventoryItemUnitCost(Double inventoryItemUnitCost);
    List<InventoryItem> readByInventoryItemUnitOfMeasure(String inventoryItemUnitOfMeasure);
    List<InventoryItem> readByInventoryItemUpdatedAt(String inventoryItemUpdatedAt);
}
