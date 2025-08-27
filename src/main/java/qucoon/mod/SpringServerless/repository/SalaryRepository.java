
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.SalaryPage;
import qucoon.mod.SpringServerless.model.request.SalaryFilterRequest;

import java.util.List;

@Repository
    public interface SalaryRepository {


    // Additional query methods can be defined here.
    int create(Salary salary);
    void bulkCreate(List<Salary>  salary);
    int update(Salary  salary);
    int delete(int salaryId);
    SalaryPage findSalary(SalaryFilterRequest filter);
    boolean truncate();
    List<Salary> read();
    List<Salary> readBySalaryBasicAmount(Double salaryBasicAmount);
    List<Salary> readBySalaryCreatedAt(String salaryCreatedAt);
    List<Salary> readBySalaryEmployeeId(int salaryEmployeeId);
    List<Salary> readBySalaryGrossPay(Double salaryGrossPay);
    Salary readBySalaryId(int salaryId);
    List<Salary> readBySalaryNetPay(Double salaryNetPay);
    List<Salary> readBySalaryPayPeriodId(int salaryPayPeriodId);
    List<Salary> readBySalaryStatus(String salaryStatus);
    List<Salary> readBySalaryUpdatedAt(String salaryUpdatedAt);
}
