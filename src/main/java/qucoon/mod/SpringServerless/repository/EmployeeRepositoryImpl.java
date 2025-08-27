
package   qucoon.mod.SpringServerless.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.repository.query.*;
import qucoon.mod.SpringServerless.utility.Environment;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.repository.page.*;
import qucoon.mod.SpringServerless.model.entity.Module;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import java.util.List;

import static qucoon.mod.SpringServerless.repository.query.QueryUtils.createQueryWithoutOnMappingFailure;


@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Environment environment;

    @Autowired
    public EmployeeRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Employee  employee) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int employeeId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), EmployeeQuery.INSERT, true)
                .bind (employee)
                .executeUpdate()
                .getKey(int.class);


        return employeeId;
    }

    @Override
    public void bulkCreate(List<Employee> employees) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,EmployeeQuery.INSERT, false);
            for (Employee employee : employees) {
                query.bind(employee).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Employee employee) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.UPDATE, true)
                .bind (employee)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int employeeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.DELETE, true)
                .addParameter("employeeId", employeeId)
                .executeUpdate()
                .getResult();
    }

    @Override
    public boolean truncate() {
        try {
            assert environment.getDatabaseUtil().getSql2oConnection() != null;
            return environment.getDatabaseUtil().getSql2oConnection()
                    .getJdbcConnection()
                    .createStatement()
                    .execute(EmployeeQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Employee> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ, true)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeContractEndDate(String employeeContractEndDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEECONTRACTENDDATE, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeContractEndDate)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeCreatedAt(String employeeCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEECREATEDAT, true)
                .addParameter("employeeCreatedAt", employeeCreatedAt)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeDateOfBirth(String employeeDateOfBirth) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEDATEOFBIRTH, true)
                .addParameter("employeeDateOfBirth", employeeDateOfBirth)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeEmail(String employeeEmail) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEEMAIL, true)
                .addParameter("employeeEmail", employeeEmail)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeEmploymentStatus(String employeeEmploymentStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEEMPLOYMENTSTATUS, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeEmploymentStatus)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeEmploymentType(String employeeEmploymentType) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEEMPLOYMENTTYPE, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeEmploymentType)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeFirstName(String employeeFirstName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEFIRSTNAME, true)
                .addParameter("employeeFirstName", employeeFirstName)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeHireDate(String employeeHireDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEHIREDATE, true)
                .addParameter("employeeHireDate", employeeHireDate)
                .executeAndFetch(Employee.class);
    }
    @Override
    public Employee readByEmployeeId(int employeeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEID, true)
                .addParameter("employeeId", employeeId)
                .executeAndFetch (Employee.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Employee> readByEmployeeJobId(int employeeJobId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEJOBID, true)
                .addParameter("employeeJobId", employeeJobId)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeLastName(String employeeLastName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEELASTNAME, true)
                .addParameter("employeeLastName", employeeLastName)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeMaritalStatus(String employeeMaritalStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEMARITALSTATUS, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeMaritalStatus)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeNationality(String employeeNationality) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEENATIONALITY, true)
                .addParameter("employeeNationality", employeeNationality)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeePhone(String employeePhone) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEPHONE, true)
                .addParameter("employeePhone", employeePhone)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeePhotoUrl(String employeePhotoUrl) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEPHOTOURL, true)
                .addParameter("employeePhotoUrl", employeePhotoUrl)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeStatus(String employeeStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEESTATUS, true)
                .addParameter("employeeStatus", employeeStatus)
                .executeAndFetch(Employee.class);
    }
    @Override
    public List<Employee> readByEmployeeUpdatedAt(String employeeUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeQuery.READ_BY_EMPLOYEE_EMPLOYEEUPDATEDAT, true)
                .addParameter("employeeUpdatedAt", employeeUpdatedAt)
                .executeAndFetch(Employee.class);
    }

@Override
public EmployeePage findEmployee(EmployeeFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(EmployeeQuery.READ);

    // Dynamic filters

    if (filter.getEmployeeContractEndDate() != null) {   baseSql.append(" AND employeeContractEndDate = :employeeContractEndDate"); }
    if (filter.getEmployeeCreatedAt() != null) {   baseSql.append(" AND employeeCreatedAt = :employeeCreatedAt"); }
    if (filter.getEmployeeDateOfBirth() != null) {   baseSql.append(" AND employeeDateOfBirth = :employeeDateOfBirth"); }
    if (filter.getEmployeeEmail() != null) {   baseSql.append(" AND employeeEmail = :employeeEmail"); }
    if (filter.getEmployeeEmploymentStatus() != null) {   baseSql.append(" AND employeeEmploymentStatus = :employeeEmploymentStatus"); }
    if (filter.getEmployeeEmploymentType() != null) {   baseSql.append(" AND employeeEmploymentType = :employeeEmploymentType"); }
    if (filter.getEmployeeFirstName() != null) {   baseSql.append(" AND employeeFirstName = :employeeFirstName"); }
    if (filter.getEmployeeHireDate() != null) {   baseSql.append(" AND employeeHireDate = :employeeHireDate"); }
    if (filter.getEmployeeId() != null) {   baseSql.append(" AND employeeId = :employeeId"); }
    if (filter.getEmployeeJobId() != null) {   baseSql.append(" AND employeeJobId = :employeeJobId"); }
    if (filter.getEmployeeLastName() != null) {   baseSql.append(" AND employeeLastName = :employeeLastName"); }
    if (filter.getEmployeeMaritalStatus() != null) {   baseSql.append(" AND employeeMaritalStatus = :employeeMaritalStatus"); }
    if (filter.getEmployeeNationality() != null) {   baseSql.append(" AND employeeNationality = :employeeNationality"); }
    if (filter.getEmployeePhone() != null) {   baseSql.append(" AND employeePhone = :employeePhone"); }
    if (filter.getEmployeePhotoUrl() != null) {   baseSql.append(" AND employeePhotoUrl = :employeePhotoUrl"); }
    if (filter.getEmployeeStatus() != null) {   baseSql.append(" AND employeeStatus = :employeeStatus"); }
    if (filter.getEmployeeUpdatedAt() != null) {   baseSql.append(" AND employeeUpdatedAt = :employeeUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getEmployeeContractEndDate() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeContractEndDate());
     if (filter.getEmployeeCreatedAt() != null) countQuery.addParameter("employeeCreatedAt", filter.getEmployeeCreatedAt());
     if (filter.getEmployeeDateOfBirth() != null) countQuery.addParameter("employeeDateOfBirth", filter.getEmployeeDateOfBirth());
     if (filter.getEmployeeEmail() != null) countQuery.addParameter("employeeEmail", filter.getEmployeeEmail());
     if (filter.getEmployeeEmploymentStatus() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeEmploymentStatus());
     if (filter.getEmployeeEmploymentType() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeEmploymentType());
     if (filter.getEmployeeFirstName() != null) countQuery.addParameter("employeeFirstName", filter.getEmployeeFirstName());
     if (filter.getEmployeeHireDate() != null) countQuery.addParameter("employeeHireDate", filter.getEmployeeHireDate());
     if (filter.getEmployeeId() != null) countQuery.addParameter("employeeId", filter.getEmployeeId());
     if (filter.getEmployeeJobId() != null) countQuery.addParameter("employeeJobId", filter.getEmployeeJobId());
     if (filter.getEmployeeLastName() != null) countQuery.addParameter("employeeLastName", filter.getEmployeeLastName());
     if (filter.getEmployeeMaritalStatus() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeMaritalStatus());
     if (filter.getEmployeeNationality() != null) countQuery.addParameter("employeeNationality", filter.getEmployeeNationality());
     if (filter.getEmployeePhone() != null) countQuery.addParameter("employeePhone", filter.getEmployeePhone());
     if (filter.getEmployeePhotoUrl() != null) countQuery.addParameter("employeePhotoUrl", filter.getEmployeePhotoUrl());
     if (filter.getEmployeeStatus() != null) countQuery.addParameter("employeeStatus", filter.getEmployeeStatus());
     if (filter.getEmployeeUpdatedAt() != null) countQuery.addParameter("employeeUpdatedAt", filter.getEmployeeUpdatedAt());
     if (filter.getSearch() != null) countQuery.addParameter("search", "%" + filter.getSearch() + "%");
     Long total = countQuery.executeScalar(Long.class);

   // MSSQL pagination requires ORDER BY for OFFSET/FETCH
    String validSortDir = filter.getSortDir().equalsIgnoreCase("ASC") ? "ASC" : "DESC";
    String orderBy = " ORDER BY " + sanitizeSortBy(filter.getSortBy()) + " " + validSortDir;
     // Append order and pagination
     StringBuilder pageSql_old = new StringBuilder(baseSql)
             .append(" ORDER BY ").append (filter.getSortBy())
             .append(" ").append (filter.getSortDir())
             .append("  OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY");
    // Build pagination SQL
    String pageSql = baseSql.toString() + orderBy +
" OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY";

     // Fetch page data
     var pageQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             pageSql.toString(),
             true);

    if (filter.getEmployeeContractEndDate() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeContractEndDate());
    if (filter.getEmployeeCreatedAt() != null) pageQuery.addParameter("employeeCreatedAt", filter.getEmployeeCreatedAt());
    if (filter.getEmployeeDateOfBirth() != null) pageQuery.addParameter("employeeDateOfBirth", filter.getEmployeeDateOfBirth());
    if (filter.getEmployeeEmail() != null) pageQuery.addParameter("employeeEmail", filter.getEmployeeEmail());
    if (filter.getEmployeeEmploymentStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeEmploymentStatus());
    if (filter.getEmployeeEmploymentType() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeEmploymentType());
    if (filter.getEmployeeFirstName() != null) pageQuery.addParameter("employeeFirstName", filter.getEmployeeFirstName());
    if (filter.getEmployeeHireDate() != null) pageQuery.addParameter("employeeHireDate", filter.getEmployeeHireDate());
    if (filter.getEmployeeId() != null) pageQuery.addParameter("employeeId", filter.getEmployeeId());
    if (filter.getEmployeeJobId() != null) pageQuery.addParameter("employeeJobId", filter.getEmployeeJobId());
    if (filter.getEmployeeLastName() != null) pageQuery.addParameter("employeeLastName", filter.getEmployeeLastName());
    if (filter.getEmployeeMaritalStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeMaritalStatus());
    if (filter.getEmployeeNationality() != null) pageQuery.addParameter("employeeNationality", filter.getEmployeeNationality());
    if (filter.getEmployeePhone() != null) pageQuery.addParameter("employeePhone", filter.getEmployeePhone());
    if (filter.getEmployeePhotoUrl() != null) pageQuery.addParameter("employeePhotoUrl", filter.getEmployeePhotoUrl());
    if (filter.getEmployeeStatus() != null) pageQuery.addParameter("employeeStatus", filter.getEmployeeStatus());
    if (filter.getEmployeeUpdatedAt() != null) pageQuery.addParameter("employeeUpdatedAt", filter.getEmployeeUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Employee> data = pageQuery.executeAndFetch(Employee.class);

     return new EmployeePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_EMPLOYEE"),"employeeCreatedAt","employeeDateOfBirth","employeeEmail",System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),"employeeFirstName","employeeHireDate","employeeId","employeeJobId","employeeLastName",System.getenv("API_KEY_EMPLOYEE"),"employeeNationality","employeePhone","employeePhotoUrl","employeeStatus","employeeUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
