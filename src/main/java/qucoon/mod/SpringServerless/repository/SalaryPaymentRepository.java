
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.SalaryPaymentPage;
import qucoon.mod.SpringServerless.model.request.SalaryPaymentFilterRequest;

import java.util.List;

@Repository
    public interface SalaryPaymentRepository {


    // Additional query methods can be defined here.
    int create(SalaryPayment salarypayment);
    void bulkCreate(List<SalaryPayment>  salarypayment);
    int update(SalaryPayment  salarypayment);
    int delete(int salaryPaymentId);
    SalaryPaymentPage findSalaryPayment(SalaryPaymentFilterRequest filter);
    boolean truncate();
    List<SalaryPayment> read();
    List<SalaryPayment> readBySalaryPaymentAmount(Double salaryPaymentAmount);
    List<SalaryPayment> readBySalaryPaymentApprovedBy(int salaryPaymentApprovedBy);
    List<SalaryPayment> readBySalaryPaymentChannel(String salaryPaymentChannel);
    List<SalaryPayment> readBySalaryPaymentCreatedAt(String salaryPaymentCreatedAt);
    List<SalaryPayment> readBySalaryPaymentEmployeeAccountId(int salaryPaymentEmployeeAccountId);
    SalaryPayment readBySalaryPaymentId(int salaryPaymentId);
    List<SalaryPayment> readBySalaryPaymentSalaryId(int salaryPaymentSalaryId);
    List<SalaryPayment> readBySalaryPaymentStatus(String salaryPaymentStatus);
    List<SalaryPayment> readBySalaryPaymentTransactionId(int salaryPaymentTransactionId);
    List<SalaryPayment> readBySalaryPaymentUpdatedAt(String salaryPaymentUpdatedAt);
}
