
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
public class EmployeeDocumentRepositoryImpl implements EmployeeDocumentRepository {

    private final Environment environment;

    @Autowired
    public EmployeeDocumentRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(EmployeeDocument  employeedocument) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int employeeDocumentId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), EmployeeDocumentQuery.INSERT, true)
                .bind (employeedocument)
                .executeUpdate()
                .getKey(int.class);


        return employeeDocumentId;
    }

    @Override
    public void bulkCreate(List<EmployeeDocument> employeedocuments) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,EmployeeDocumentQuery.INSERT, false);
            for (EmployeeDocument employeedocument : employeedocuments) {
                query.bind(employeedocument).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(EmployeeDocument employeedocument) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.UPDATE, true)
                .bind (employeedocument)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int employeeDocumentId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.DELETE, true)
                .addParameter("employeeDocumentId", employeeDocumentId)
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
                    .execute(EmployeeDocumentQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<EmployeeDocument> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ, true)
                .executeAndFetch(EmployeeDocument.class);
    }
    @Override
    public List<EmployeeDocument> readByEmployeeDocumentAccessLevel(String employeeDocumentAccessLevel) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTACCESSLEVEL, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeDocumentAccessLevel)
                .executeAndFetch(EmployeeDocument.class);
    }
    @Override
    public List<EmployeeDocument> readByEmployeeDocumentCreatedAt(String employeeDocumentCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeDocumentCreatedAt)
                .executeAndFetch(EmployeeDocument.class);
    }
    @Override
    public List<EmployeeDocument> readByEmployeeDocumentEmployeeId(int employeeDocumentEmployeeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTEMPLOYEEID, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeDocumentEmployeeId)
                .executeAndFetch(EmployeeDocument.class);
    }
    @Override
    public List<EmployeeDocument> readByEmployeeDocumentExpiresAt(String employeeDocumentExpiresAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTEXPIRESAT, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeDocumentExpiresAt)
                .executeAndFetch(EmployeeDocument.class);
    }
    @Override
    public List<EmployeeDocument> readByEmployeeDocumentFileUrl(String employeeDocumentFileUrl) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTFILEURL, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeDocumentFileUrl)
                .executeAndFetch(EmployeeDocument.class);
    }
    @Override
    public EmployeeDocument readByEmployeeDocumentId(int employeeDocumentId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTID, true)
                .addParameter("employeeDocumentId", employeeDocumentId)
                .executeAndFetch (EmployeeDocument.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<EmployeeDocument> readByEmployeeDocumentStatus(String employeeDocumentStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTSTATUS, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeDocumentStatus)
                .executeAndFetch(EmployeeDocument.class);
    }
    @Override
    public List<EmployeeDocument> readByEmployeeDocumentType(String employeeDocumentType) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTTYPE, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeDocumentType)
                .executeAndFetch(EmployeeDocument.class);
    }
    @Override
    public List<EmployeeDocument> readByEmployeeDocumentUpdatedAt(String employeeDocumentUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeDocumentUpdatedAt)
                .executeAndFetch(EmployeeDocument.class);
    }
    @Override
    public List<EmployeeDocument> readByEmployeeDocumentUploadedBy(int employeeDocumentUploadedBy) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTUPLOADEDBY, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeDocumentUploadedBy)
                .executeAndFetch(EmployeeDocument.class);
    }
    @Override
    public List<EmployeeDocument> readByEmployeeDocumentVersion(String employeeDocumentVersion) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeDocumentQuery.READ_BY_EMPLOYEE_DOCUMENT_EMPLOYEEDOCUMENTVERSION, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeDocumentVersion)
                .executeAndFetch(EmployeeDocument.class);
    }

@Override
public EmployeeDocumentPage findEmployeeDocument(EmployeeDocumentFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(EmployeeDocumentQuery.READ);

    // Dynamic filters

    if (filter.getEmployeeDocumentAccessLevel() != null) {   baseSql.append(" AND employeeDocumentAccessLevel = :employeeDocumentAccessLevel"); }
    if (filter.getEmployeeDocumentCreatedAt() != null) {   baseSql.append(" AND employeeDocumentCreatedAt = :employeeDocumentCreatedAt"); }
    if (filter.getEmployeeDocumentEmployeeId() != null) {   baseSql.append(" AND employeeDocumentEmployeeId = :employeeDocumentEmployeeId"); }
    if (filter.getEmployeeDocumentExpiresAt() != null) {   baseSql.append(" AND employeeDocumentExpiresAt = :employeeDocumentExpiresAt"); }
    if (filter.getEmployeeDocumentFileUrl() != null) {   baseSql.append(" AND employeeDocumentFileUrl = :employeeDocumentFileUrl"); }
    if (filter.getEmployeeDocumentId() != null) {   baseSql.append(" AND employeeDocumentId = :employeeDocumentId"); }
    if (filter.getEmployeeDocumentStatus() != null) {   baseSql.append(" AND employeeDocumentStatus = :employeeDocumentStatus"); }
    if (filter.getEmployeeDocumentType() != null) {   baseSql.append(" AND employeeDocumentType = :employeeDocumentType"); }
    if (filter.getEmployeeDocumentUpdatedAt() != null) {   baseSql.append(" AND employeeDocumentUpdatedAt = :employeeDocumentUpdatedAt"); }
    if (filter.getEmployeeDocumentUploadedBy() != null) {   baseSql.append(" AND employeeDocumentUploadedBy = :employeeDocumentUploadedBy"); }
    if (filter.getEmployeeDocumentVersion() != null) {   baseSql.append(" AND employeeDocumentVersion = :employeeDocumentVersion"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getEmployeeDocumentAccessLevel() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentAccessLevel());
     if (filter.getEmployeeDocumentCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentCreatedAt());
     if (filter.getEmployeeDocumentEmployeeId() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentEmployeeId());
     if (filter.getEmployeeDocumentExpiresAt() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentExpiresAt());
     if (filter.getEmployeeDocumentFileUrl() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentFileUrl());
     if (filter.getEmployeeDocumentId() != null) countQuery.addParameter("employeeDocumentId", filter.getEmployeeDocumentId());
     if (filter.getEmployeeDocumentStatus() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentStatus());
     if (filter.getEmployeeDocumentType() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentType());
     if (filter.getEmployeeDocumentUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentUpdatedAt());
     if (filter.getEmployeeDocumentUploadedBy() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentUploadedBy());
     if (filter.getEmployeeDocumentVersion() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentVersion());
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

    if (filter.getEmployeeDocumentAccessLevel() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentAccessLevel());
    if (filter.getEmployeeDocumentCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentCreatedAt());
    if (filter.getEmployeeDocumentEmployeeId() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentEmployeeId());
    if (filter.getEmployeeDocumentExpiresAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentExpiresAt());
    if (filter.getEmployeeDocumentFileUrl() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentFileUrl());
    if (filter.getEmployeeDocumentId() != null) pageQuery.addParameter("employeeDocumentId", filter.getEmployeeDocumentId());
    if (filter.getEmployeeDocumentStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentStatus());
    if (filter.getEmployeeDocumentType() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentType());
    if (filter.getEmployeeDocumentUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentUpdatedAt());
    if (filter.getEmployeeDocumentUploadedBy() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentUploadedBy());
    if (filter.getEmployeeDocumentVersion() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeDocumentVersion());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<EmployeeDocument> data = pageQuery.executeAndFetch(EmployeeDocument.class);

     return new EmployeeDocumentPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),"employeeDocumentId",System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
