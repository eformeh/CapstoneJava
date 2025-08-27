
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.DepartmentPage;
import qucoon.mod.SpringServerless.model.request.DepartmentFilterRequest;

import java.util.List;

@Repository
    public interface DepartmentRepository {


    // Additional query methods can be defined here.
    int create(Department department);
    void bulkCreate(List<Department>  department);
    int update(Department  department);
    int delete(int departmentId);
    DepartmentPage findDepartment(DepartmentFilterRequest filter);
    boolean truncate();
    List<Department> read();
    List<Department> readByDepartmentCreatedAt(String departmentCreatedAt);
    List<Department> readByDepartmentDescription(String departmentDescription);
    Department readByDepartmentId(int departmentId);
    List<Department> readByDepartmentName(String departmentName);
    List<Department> readByDepartmentStatus(String departmentStatus);
    List<Department> readByDepartmentUpdatedAt(String departmentUpdatedAt);
}
