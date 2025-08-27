
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.SalePage;
import qucoon.mod.SpringServerless.model.request.SaleFilterRequest;

import java.util.List;

@Repository
    public interface SaleRepository {


    // Additional query methods can be defined here.
    int create(Sale sale);
    void bulkCreate(List<Sale>  sale);
    int update(Sale  sale);
    int delete(int saleId);
    SalePage findSale(SaleFilterRequest filter);
    boolean truncate();
    List<Sale> read();
    List<Sale> readBySaleAmountPaid(Double saleAmountPaid);
    List<Sale> readBySaleCreatedAt(String saleCreatedAt);
    List<Sale> readBySaleCreditDue(String saleCreditDue);
    List<Sale> readBySaleCustomerId(int saleCustomerId);
    List<Sale> readBySaleDeliveryType(String saleDeliveryType);
    List<Sale> readBySaleEmployeeId(int saleEmployeeId);
    Sale readBySaleId(int saleId);
    List<Sale> readBySaleStatus(String saleStatus);
    List<Sale> readBySaleTotalAmount(Double saleTotalAmount);
    List<Sale> readBySaleType(String saleType);
    List<Sale> readBySaleUpdatedAt(String saleUpdatedAt);
}
