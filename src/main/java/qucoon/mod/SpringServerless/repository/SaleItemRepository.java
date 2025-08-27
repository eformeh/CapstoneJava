
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.SaleItemPage;
import qucoon.mod.SpringServerless.model.request.SaleItemFilterRequest;

import java.util.List;

@Repository
    public interface SaleItemRepository {


    // Additional query methods can be defined here.
    int create(SaleItem saleitem);
    void bulkCreate(List<SaleItem>  saleitem);
    int update(SaleItem  saleitem);
    int delete(int saleItemId);
    SaleItemPage findSaleItem(SaleItemFilterRequest filter);
    boolean truncate();
    List<SaleItem> read();
    List<SaleItem> readBySaleItemCreatedAt(String saleItemCreatedAt);
    SaleItem readBySaleItemId(int saleItemId);
    List<SaleItem> readBySaleItemProductId(int saleItemProductId);
    List<SaleItem> readBySaleItemQuantity(int saleItemQuantity);
    List<SaleItem> readBySaleItemSaleId(int saleItemSaleId);
    List<SaleItem> readBySaleItemStatus(String saleItemStatus);
    List<SaleItem> readBySaleItemTotal(Double saleItemTotal);
    List<SaleItem> readBySaleItemUnitPrice(Double saleItemUnitPrice);
    List<SaleItem> readBySaleItemUpdatedAt(String saleItemUpdatedAt);
}
