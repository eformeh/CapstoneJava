
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
public class EmployeeOnboardingRepositoryImpl implements EmployeeOnboardingRepository {

    private final Environment environment;

    @Autowired
    public EmployeeOnboardingRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(EmployeeOnboarding  employeeonboarding) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int employeeOnboardingId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), EmployeeOnboardingQuery.INSERT, true)
                .bind (employeeonboarding)
                .executeUpdate()
                .getKey(int.class);


        return employeeOnboardingId;
    }

    @Override
    public void bulkCreate(List<EmployeeOnboarding> employeeonboardings) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,EmployeeOnboardingQuery.INSERT, false);
            for (EmployeeOnboarding employeeonboarding : employeeonboardings) {
                query.bind(employeeonboarding).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(EmployeeOnboarding employeeonboarding) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.UPDATE, true)
                .bind (employeeonboarding)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int employeeOnboardingId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.DELETE, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingId)
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
                    .execute(EmployeeOnboardingQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<EmployeeOnboarding> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ, true)
                .executeAndFetch(EmployeeOnboarding.class);
    }
    @Override
    public List<EmployeeOnboarding> readByEmployeeOnboardingAssignedBy(int employeeOnboardingAssignedBy) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGASSIGNEDBY, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingAssignedBy)
                .executeAndFetch(EmployeeOnboarding.class);
    }
    @Override
    public List<EmployeeOnboarding> readByEmployeeOnboardingAttachmentUrl(String employeeOnboardingAttachmentUrl) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGATTACHMENTURL, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingAttachmentUrl)
                .executeAndFetch(EmployeeOnboarding.class);
    }
    @Override
    public List<EmployeeOnboarding> readByEmployeeOnboardingCompletedDate(String employeeOnboardingCompletedDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGCOMPLETEDDATE, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingCompletedDate)
                .executeAndFetch(EmployeeOnboarding.class);
    }
    @Override
    public List<EmployeeOnboarding> readByEmployeeOnboardingCreatedAt(String employeeOnboardingCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingCreatedAt)
                .executeAndFetch(EmployeeOnboarding.class);
    }
    @Override
    public List<EmployeeOnboarding> readByEmployeeOnboardingDueDate(String employeeOnboardingDueDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGDUEDATE, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingDueDate)
                .executeAndFetch(EmployeeOnboarding.class);
    }
    @Override
    public List<EmployeeOnboarding> readByEmployeeOnboardingEmployeeId(int employeeOnboardingEmployeeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGEMPLOYEEID, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingEmployeeId)
                .executeAndFetch(EmployeeOnboarding.class);
    }
    @Override
    public EmployeeOnboarding readByEmployeeOnboardingId(int employeeOnboardingId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGID, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingId)
                .executeAndFetch (EmployeeOnboarding.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<EmployeeOnboarding> readByEmployeeOnboardingNotes(String employeeOnboardingNotes) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGNOTES, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingNotes)
                .executeAndFetch(EmployeeOnboarding.class);
    }
    @Override
    public List<EmployeeOnboarding> readByEmployeeOnboardingStatus(String employeeOnboardingStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGSTATUS, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingStatus)
                .executeAndFetch(EmployeeOnboarding.class);
    }
    @Override
    public List<EmployeeOnboarding> readByEmployeeOnboardingTaskId(int employeeOnboardingTaskId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGTASKID, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingTaskId)
                .executeAndFetch(EmployeeOnboarding.class);
    }
    @Override
    public List<EmployeeOnboarding> readByEmployeeOnboardingUpdatedAt(String employeeOnboardingUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeOnboardingQuery.READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeOnboardingUpdatedAt)
                .executeAndFetch(EmployeeOnboarding.class);
    }

@Override
public EmployeeOnboardingPage findEmployeeOnboarding(EmployeeOnboardingFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(EmployeeOnboardingQuery.READ);

    // Dynamic filters

    if (filter.getEmployeeOnboardingAssignedBy() != null) {   baseSql.append(" AND employeeOnboardingAssignedBy = :employeeOnboardingAssignedBy"); }
    if (filter.getEmployeeOnboardingAttachmentUrl() != null) {   baseSql.append(" AND employeeOnboardingAttachmentUrl = :employeeOnboardingAttachmentUrl"); }
    if (filter.getEmployeeOnboardingCompletedDate() != null) {   baseSql.append(" AND employeeOnboardingCompletedDate = :employeeOnboardingCompletedDate"); }
    if (filter.getEmployeeOnboardingCreatedAt() != null) {   baseSql.append(" AND employeeOnboardingCreatedAt = :employeeOnboardingCreatedAt"); }
    if (filter.getEmployeeOnboardingDueDate() != null) {   baseSql.append(" AND employeeOnboardingDueDate = :employeeOnboardingDueDate"); }
    if (filter.getEmployeeOnboardingEmployeeId() != null) {   baseSql.append(" AND employeeOnboardingEmployeeId = :employeeOnboardingEmployeeId"); }
    if (filter.getEmployeeOnboardingId() != null) {   baseSql.append(" AND employeeOnboardingId = :employeeOnboardingId"); }
    if (filter.getEmployeeOnboardingNotes() != null) {   baseSql.append(" AND employeeOnboardingNotes = :employeeOnboardingNotes"); }
    if (filter.getEmployeeOnboardingStatus() != null) {   baseSql.append(" AND employeeOnboardingStatus = :employeeOnboardingStatus"); }
    if (filter.getEmployeeOnboardingTaskId() != null) {   baseSql.append(" AND employeeOnboardingTaskId = :employeeOnboardingTaskId"); }
    if (filter.getEmployeeOnboardingUpdatedAt() != null) {   baseSql.append(" AND employeeOnboardingUpdatedAt = :employeeOnboardingUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getEmployeeOnboardingAssignedBy() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingAssignedBy());
     if (filter.getEmployeeOnboardingAttachmentUrl() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingAttachmentUrl());
     if (filter.getEmployeeOnboardingCompletedDate() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingCompletedDate());
     if (filter.getEmployeeOnboardingCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingCreatedAt());
     if (filter.getEmployeeOnboardingDueDate() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingDueDate());
     if (filter.getEmployeeOnboardingEmployeeId() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingEmployeeId());
     if (filter.getEmployeeOnboardingId() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingId());
     if (filter.getEmployeeOnboardingNotes() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingNotes());
     if (filter.getEmployeeOnboardingStatus() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingStatus());
     if (filter.getEmployeeOnboardingTaskId() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingTaskId());
     if (filter.getEmployeeOnboardingUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingUpdatedAt());
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

    if (filter.getEmployeeOnboardingAssignedBy() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingAssignedBy());
    if (filter.getEmployeeOnboardingAttachmentUrl() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingAttachmentUrl());
    if (filter.getEmployeeOnboardingCompletedDate() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingCompletedDate());
    if (filter.getEmployeeOnboardingCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingCreatedAt());
    if (filter.getEmployeeOnboardingDueDate() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingDueDate());
    if (filter.getEmployeeOnboardingEmployeeId() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingEmployeeId());
    if (filter.getEmployeeOnboardingId() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingId());
    if (filter.getEmployeeOnboardingNotes() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingNotes());
    if (filter.getEmployeeOnboardingStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingStatus());
    if (filter.getEmployeeOnboardingTaskId() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingTaskId());
    if (filter.getEmployeeOnboardingUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeOnboardingUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<EmployeeOnboarding> data = pageQuery.executeAndFetch(EmployeeOnboarding.class);

     return new EmployeeOnboardingPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
