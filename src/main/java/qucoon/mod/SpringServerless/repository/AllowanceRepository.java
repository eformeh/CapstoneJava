
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.AllowancePage;
import qucoon.mod.SpringServerless.model.request.AllowanceFilterRequest;

import java.util.List;

@Repository
    public interface AllowanceRepository {


    // Additional query methods can be defined here.
    int create(Allowance allowance);
    void bulkCreate(List<Allowance>  allowance);
    int update(Allowance  allowance);
    int delete(int allowanceId);
    AllowancePage findAllowance(AllowanceFilterRequest filter);
    boolean truncate();
    List<Allowance> read();
    List<Allowance> readByAllowanceAmount(Double allowanceAmount);
    List<Allowance> readByAllowanceCreatedAt(String allowanceCreatedAt);
    Allowance readByAllowanceId(int allowanceId);
    List<Allowance> readByAllowanceSalaryId(int allowanceSalaryId);
    List<Allowance> readByAllowanceStatus(String allowanceStatus);
    List<Allowance> readByAllowanceType(String allowanceType);
    List<Allowance> readByAllowanceUpdatedAt(String allowanceUpdatedAt);
}
