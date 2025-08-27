
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.EmployeePage;
import qucoon.mod.SpringServerless.model.request.EmployeeFilterRequest;

import java.util.List;

@Repository
    public interface EmployeeRepository {


    // Additional query methods can be defined here.
    int create(Employee employee);
    void bulkCreate(List<Employee>  employee);
    int update(Employee  employee);
    int delete(int employeeId);
    EmployeePage findEmployee(EmployeeFilterRequest filter);
    boolean truncate();
    List<Employee> read();
    List<Employee> readByEmployeeContractEndDate(String employeeContractEndDate);
    List<Employee> readByEmployeeCreatedAt(String employeeCreatedAt);
    List<Employee> readByEmployeeDateOfBirth(String employeeDateOfBirth);
    List<Employee> readByEmployeeEmail(String employeeEmail);
    List<Employee> readByEmployeeEmploymentStatus(String employeeEmploymentStatus);
    List<Employee> readByEmployeeEmploymentType(String employeeEmploymentType);
    List<Employee> readByEmployeeFirstName(String employeeFirstName);
    List<Employee> readByEmployeeHireDate(String employeeHireDate);
    Employee readByEmployeeId(int employeeId);
    List<Employee> readByEmployeeJobId(int employeeJobId);
    List<Employee> readByEmployeeLastName(String employeeLastName);
    List<Employee> readByEmployeeMaritalStatus(String employeeMaritalStatus);
    List<Employee> readByEmployeeNationality(String employeeNationality);
    List<Employee> readByEmployeePhone(String employeePhone);
    List<Employee> readByEmployeePhotoUrl(String employeePhotoUrl);
    List<Employee> readByEmployeeStatus(String employeeStatus);
    List<Employee> readByEmployeeUpdatedAt(String employeeUpdatedAt);
}
