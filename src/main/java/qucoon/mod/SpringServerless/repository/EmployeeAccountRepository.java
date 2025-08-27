
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.EmployeeAccountPage;
import qucoon.mod.SpringServerless.model.request.EmployeeAccountFilterRequest;

import java.util.List;

@Repository
    public interface EmployeeAccountRepository {


    // Additional query methods can be defined here.
    int create(EmployeeAccount employeeaccount);
    void bulkCreate(List<EmployeeAccount>  employeeaccount);
    int update(EmployeeAccount  employeeaccount);
    int delete(int employeeAccountId);
    EmployeeAccountPage findEmployeeAccount(EmployeeAccountFilterRequest filter);
    boolean truncate();
    List<EmployeeAccount> read();
    List<EmployeeAccount> readByEmployeeAccountBankName(String employeeAccountBankName);
    List<EmployeeAccount> readByEmployeeAccountCreatedAt(String employeeAccountCreatedAt);
    List<EmployeeAccount> readByEmployeeAccountEmployeeId(int employeeAccountEmployeeId);
    EmployeeAccount readByEmployeeAccountId(int employeeAccountId);
    List<EmployeeAccount> readByEmployeeAccountName(String employeeAccountName);
    List<EmployeeAccount> readByEmployeeAccountNumber(String employeeAccountNumber);
    List<EmployeeAccount> readByEmployeeAccountStatus(String employeeAccountStatus);
    List<EmployeeAccount> readByEmployeeAccountUpdatedAt(String employeeAccountUpdatedAt);
}
