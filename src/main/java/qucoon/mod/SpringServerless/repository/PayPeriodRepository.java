
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.PayPeriodPage;
import qucoon.mod.SpringServerless.model.request.PayPeriodFilterRequest;

import java.util.List;

@Repository
    public interface PayPeriodRepository {


    // Additional query methods can be defined here.
    int create(PayPeriod payperiod);
    void bulkCreate(List<PayPeriod>  payperiod);
    int update(PayPeriod  payperiod);
    int delete(int payPeriodId);
    PayPeriodPage findPayPeriod(PayPeriodFilterRequest filter);
    boolean truncate();
    List<PayPeriod> read();
    List<PayPeriod> readByPayPeriodCreatedAt(String payPeriodCreatedAt);
    List<PayPeriod> readByPayPeriodEndDate(String payPeriodEndDate);
    PayPeriod readByPayPeriodId(int payPeriodId);
    List<PayPeriod> readByPayPeriodName(String payPeriodName);
    List<PayPeriod> readByPayPeriodPeriodType(String payPeriodPeriodType);
    List<PayPeriod> readByPayPeriodStartDate(String payPeriodStartDate);
    List<PayPeriod> readByPayPeriodStatus(String payPeriodStatus);
    List<PayPeriod> readByPayPeriodUpdatedAt(String payPeriodUpdatedAt);
}
