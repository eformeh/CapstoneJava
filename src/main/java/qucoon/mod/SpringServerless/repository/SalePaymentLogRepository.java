
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.SalePaymentLogPage;
import qucoon.mod.SpringServerless.model.request.SalePaymentLogFilterRequest;

import java.util.List;

@Repository
    public interface SalePaymentLogRepository {


    // Additional query methods can be defined here.
    int create(SalePaymentLog salepaymentlog);
    void bulkCreate(List<SalePaymentLog>  salepaymentlog);
    int update(SalePaymentLog  salepaymentlog);
    int delete(int salePaymentLogid);
    SalePaymentLogPage findSalePaymentLog(SalePaymentLogFilterRequest filter);
    boolean truncate();
    List<SalePaymentLog> read();
    List<SalePaymentLog> readBySalePaymentLogAmount(Double salePaymentLogAmount);
    List<SalePaymentLog> readBySalePaymentLogCreatedAt(String salePaymentLogCreatedAt);
    List<SalePaymentLog> readBySalePaymentLogEmployeeid(int salePaymentLogEmployeeid);
    SalePaymentLog readBySalePaymentLogid(int salePaymentLogid);
    List<SalePaymentLog> readBySalePaymentLogMethod(String salePaymentLogMethod);
    List<SalePaymentLog> readBySalePaymentLogNotes(String salePaymentLogNotes);
    List<SalePaymentLog> readBySalePaymentLogSaleid(int salePaymentLogSaleid);
    List<SalePaymentLog> readBySalePaymentLogStatus(String salePaymentLogStatus);
    List<SalePaymentLog> readBySalePaymentUpdatedAt(String salePaymentUpdatedAt);
}
