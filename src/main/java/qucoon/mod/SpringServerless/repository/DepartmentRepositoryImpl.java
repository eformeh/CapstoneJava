
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
public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final Environment environment;

    @Autowired
    public DepartmentRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Department  department) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int departmentId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), DepartmentQuery.INSERT, true)
                .bind (department)
                .executeUpdate()
                .getKey(int.class);


        return departmentId;
    }

    @Override
    public void bulkCreate(List<Department> departments) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,DepartmentQuery.INSERT, false);
            for (Department department : departments) {
                query.bind(department).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Department department) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DepartmentQuery.UPDATE, true)
                .bind (department)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int departmentId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DepartmentQuery.DELETE, true)
                .addParameter("departmentId", departmentId)
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
                    .execute(DepartmentQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Department> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DepartmentQuery.READ, true)
                .executeAndFetch(Department.class);
    }
    @Override
    public List<Department> readByDepartmentCreatedAt(String departmentCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DepartmentQuery.READ_BY_DEPARTMENT_DEPARTMENTCREATEDAT, true)
                .addParameter("departmentCreatedAt", departmentCreatedAt)
                .executeAndFetch(Department.class);
    }
    @Override
    public List<Department> readByDepartmentDescription(String departmentDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DepartmentQuery.READ_BY_DEPARTMENT_DEPARTMENTDESCRIPTION, true)
                .addParameter(System.getenv("API_KEY_DEPARTME"), departmentDescription)
                .executeAndFetch(Department.class);
    }
    @Override
    public Department readByDepartmentId(int departmentId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DepartmentQuery.READ_BY_DEPARTMENT_DEPARTMENTID, true)
                .addParameter("departmentId", departmentId)
                .executeAndFetch (Department.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Department> readByDepartmentName(String departmentName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DepartmentQuery.READ_BY_DEPARTMENT_DEPARTMENTNAME, true)
                .addParameter("departmentName", departmentName)
                .executeAndFetch(Department.class);
    }
    @Override
    public List<Department> readByDepartmentStatus(String departmentStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DepartmentQuery.READ_BY_DEPARTMENT_DEPARTMENTSTATUS, true)
                .addParameter("departmentStatus", departmentStatus)
                .executeAndFetch(Department.class);
    }
    @Override
    public List<Department> readByDepartmentUpdatedAt(String departmentUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),DepartmentQuery.READ_BY_DEPARTMENT_DEPARTMENTUPDATEDAT, true)
                .addParameter("departmentUpdatedAt", departmentUpdatedAt)
                .executeAndFetch(Department.class);
    }

@Override
public DepartmentPage findDepartment(DepartmentFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(DepartmentQuery.READ);

    // Dynamic filters

    if (filter.getDepartmentCreatedAt() != null) {   baseSql.append(" AND departmentCreatedAt = :departmentCreatedAt"); }
    if (filter.getDepartmentDescription() != null) {   baseSql.append(" AND departmentDescription = :departmentDescription"); }
    if (filter.getDepartmentId() != null) {   baseSql.append(" AND departmentId = :departmentId"); }
    if (filter.getDepartmentName() != null) {   baseSql.append(" AND departmentName = :departmentName"); }
    if (filter.getDepartmentStatus() != null) {   baseSql.append(" AND departmentStatus = :departmentStatus"); }
    if (filter.getDepartmentUpdatedAt() != null) {   baseSql.append(" AND departmentUpdatedAt = :departmentUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getDepartmentCreatedAt() != null) countQuery.addParameter("departmentCreatedAt", filter.getDepartmentCreatedAt());
     if (filter.getDepartmentDescription() != null) countQuery.addParameter(System.getenv("API_KEY_DEPARTME"), filter.getDepartmentDescription());
     if (filter.getDepartmentId() != null) countQuery.addParameter("departmentId", filter.getDepartmentId());
     if (filter.getDepartmentName() != null) countQuery.addParameter("departmentName", filter.getDepartmentName());
     if (filter.getDepartmentStatus() != null) countQuery.addParameter("departmentStatus", filter.getDepartmentStatus());
     if (filter.getDepartmentUpdatedAt() != null) countQuery.addParameter("departmentUpdatedAt", filter.getDepartmentUpdatedAt());
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

    if (filter.getDepartmentCreatedAt() != null) pageQuery.addParameter("departmentCreatedAt", filter.getDepartmentCreatedAt());
    if (filter.getDepartmentDescription() != null) pageQuery.addParameter(System.getenv("API_KEY_DEPARTME"), filter.getDepartmentDescription());
    if (filter.getDepartmentId() != null) pageQuery.addParameter("departmentId", filter.getDepartmentId());
    if (filter.getDepartmentName() != null) pageQuery.addParameter("departmentName", filter.getDepartmentName());
    if (filter.getDepartmentStatus() != null) pageQuery.addParameter("departmentStatus", filter.getDepartmentStatus());
    if (filter.getDepartmentUpdatedAt() != null) pageQuery.addParameter("departmentUpdatedAt", filter.getDepartmentUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Department> data = pageQuery.executeAndFetch(Department.class);

     return new DepartmentPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "departmentCreatedAt",System.getenv("API_KEY_DEPARTME"),"departmentId","departmentName","departmentStatus","departmentUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
