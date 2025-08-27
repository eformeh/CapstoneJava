
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
public class AppraisalFormRepositoryImpl implements AppraisalFormRepository {

    private final Environment environment;

    @Autowired
    public AppraisalFormRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(AppraisalForm  appraisalform) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int appraisalFormId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), AppraisalFormQuery.INSERT, true)
                .bind (appraisalform)
                .executeUpdate()
                .getKey(int.class);


        return appraisalFormId;
    }

    @Override
    public void bulkCreate(List<AppraisalForm> appraisalforms) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,AppraisalFormQuery.INSERT, false);
            for (AppraisalForm appraisalform : appraisalforms) {
                query.bind(appraisalform).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(AppraisalForm appraisalform) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalFormQuery.UPDATE, true)
                .bind (appraisalform)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int appraisalFormId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalFormQuery.DELETE, true)
                .addParameter("appraisalFormId", appraisalFormId)
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
                    .execute(AppraisalFormQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<AppraisalForm> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalFormQuery.READ, true)
                .executeAndFetch(AppraisalForm.class);
    }
    @Override
    public List<AppraisalForm> readByAppraisalFormCreatedAt(String appraisalFormCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalFormQuery.READ_BY_APPRAISAL_FORM_APPRAISALFORMCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalFormCreatedAt)
                .executeAndFetch(AppraisalForm.class);
    }
    @Override
    public List<AppraisalForm> readByAppraisalFormCreatedBy(int appraisalFormCreatedBy) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalFormQuery.READ_BY_APPRAISAL_FORM_APPRAISALFORMCREATEDBY, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalFormCreatedBy)
                .executeAndFetch(AppraisalForm.class);
    }
    @Override
    public List<AppraisalForm> readByAppraisalFormDescription(String appraisalFormDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalFormQuery.READ_BY_APPRAISAL_FORM_APPRAISALFORMDESCRIPTION, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalFormDescription)
                .executeAndFetch(AppraisalForm.class);
    }
    @Override
    public AppraisalForm readByAppraisalFormId(int appraisalFormId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalFormQuery.READ_BY_APPRAISAL_FORM_APPRAISALFORMID, true)
                .addParameter("appraisalFormId", appraisalFormId)
                .executeAndFetch (AppraisalForm.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<AppraisalForm> readByAppraisalFormName(String appraisalFormName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalFormQuery.READ_BY_APPRAISAL_FORM_APPRAISALFORMNAME, true)
                .addParameter("appraisalFormName", appraisalFormName)
                .executeAndFetch(AppraisalForm.class);
    }
    @Override
    public List<AppraisalForm> readByAppraisalFormStatus(String appraisalFormStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalFormQuery.READ_BY_APPRAISAL_FORM_APPRAISALFORMSTATUS, true)
                .addParameter("appraisalFormStatus", appraisalFormStatus)
                .executeAndFetch(AppraisalForm.class);
    }
    @Override
    public List<AppraisalForm> readByAppraisalFormUpdatedAt(String appraisalFormUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalFormQuery.READ_BY_APPRAISAL_FORM_APPRAISALFORMUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalFormUpdatedAt)
                .executeAndFetch(AppraisalForm.class);
    }

@Override
public AppraisalFormPage findAppraisalForm(AppraisalFormFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(AppraisalFormQuery.READ);

    // Dynamic filters

    if (filter.getAppraisalFormCreatedAt() != null) {   baseSql.append(" AND appraisalFormCreatedAt = :appraisalFormCreatedAt"); }
    if (filter.getAppraisalFormCreatedBy() != null) {   baseSql.append(" AND appraisalFormCreatedBy = :appraisalFormCreatedBy"); }
    if (filter.getAppraisalFormDescription() != null) {   baseSql.append(" AND appraisalFormDescription = :appraisalFormDescription"); }
    if (filter.getAppraisalFormId() != null) {   baseSql.append(" AND appraisalFormId = :appraisalFormId"); }
    if (filter.getAppraisalFormName() != null) {   baseSql.append(" AND appraisalFormName = :appraisalFormName"); }
    if (filter.getAppraisalFormStatus() != null) {   baseSql.append(" AND appraisalFormStatus = :appraisalFormStatus"); }
    if (filter.getAppraisalFormUpdatedAt() != null) {   baseSql.append(" AND appraisalFormUpdatedAt = :appraisalFormUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getAppraisalFormCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalFormCreatedAt());
     if (filter.getAppraisalFormCreatedBy() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalFormCreatedBy());
     if (filter.getAppraisalFormDescription() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalFormDescription());
     if (filter.getAppraisalFormId() != null) countQuery.addParameter("appraisalFormId", filter.getAppraisalFormId());
     if (filter.getAppraisalFormName() != null) countQuery.addParameter("appraisalFormName", filter.getAppraisalFormName());
     if (filter.getAppraisalFormStatus() != null) countQuery.addParameter("appraisalFormStatus", filter.getAppraisalFormStatus());
     if (filter.getAppraisalFormUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalFormUpdatedAt());
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

    if (filter.getAppraisalFormCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalFormCreatedAt());
    if (filter.getAppraisalFormCreatedBy() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalFormCreatedBy());
    if (filter.getAppraisalFormDescription() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalFormDescription());
    if (filter.getAppraisalFormId() != null) pageQuery.addParameter("appraisalFormId", filter.getAppraisalFormId());
    if (filter.getAppraisalFormName() != null) pageQuery.addParameter("appraisalFormName", filter.getAppraisalFormName());
    if (filter.getAppraisalFormStatus() != null) pageQuery.addParameter("appraisalFormStatus", filter.getAppraisalFormStatus());
    if (filter.getAppraisalFormUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalFormUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<AppraisalForm> data = pageQuery.executeAndFetch(AppraisalForm.class);

     return new AppraisalFormPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA"),"appraisalFormId","appraisalFormName","appraisalFormStatus",System.getenv("API_KEY_APPRAISA")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
