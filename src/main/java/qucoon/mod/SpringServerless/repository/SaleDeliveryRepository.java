
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.SaleDeliveryPage;
import qucoon.mod.SpringServerless.model.request.SaleDeliveryFilterRequest;

import java.util.List;

@Repository
    public interface SaleDeliveryRepository {


    // Additional query methods can be defined here.
    int create(SaleDelivery saledelivery);
    void bulkCreate(List<SaleDelivery>  saledelivery);
    int update(SaleDelivery  saledelivery);
    int delete(int saleDeliveryId);
    SaleDeliveryPage findSaleDelivery(SaleDeliveryFilterRequest filter);
    boolean truncate();
    List<SaleDelivery> read();
    List<SaleDelivery> readBySaleDeliveryAddress(String saleDeliveryAddress);
    List<SaleDelivery> readBySaleDeliveryConfirmedAt(String saleDeliveryConfirmedAt);
    List<SaleDelivery> readBySaleDeliveryContactName(String saleDeliveryContactName);
    List<SaleDelivery> readBySaleDeliveryContactPhone(String saleDeliveryContactPhone);
    List<SaleDelivery> readBySaleDeliveryCreatedAt(String saleDeliveryCreatedAt);
    List<SaleDelivery> readBySaleDeliveryExpectedDeliveryDate(String saleDeliveryExpectedDeliveryDate);
    SaleDelivery readBySaleDeliveryId(int saleDeliveryId);
    List<SaleDelivery> readBySaleDeliveryNotes(String saleDeliveryNotes);
    List<SaleDelivery> readBySaleDeliveryProvider(String saleDeliveryProvider);
    List<SaleDelivery> readBySaleDeliverySaleId(int saleDeliverySaleId);
    List<SaleDelivery> readBySaleDeliveryStatus(String saleDeliveryStatus);
    List<SaleDelivery> readBySaleDeliveryTrackingNumber(String saleDeliveryTrackingNumber);
    List<SaleDelivery> readBySaleDeliveryUpdatedAt(String saleDeliveryUpdatedAt);
}
