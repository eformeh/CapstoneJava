
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
public class AppraisalRepositoryImpl implements AppraisalRepository {

    private final Environment environment;

    @Autowired
    public AppraisalRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Appraisal  appraisal) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int appraisalId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), AppraisalQuery.INSERT, true)
                .bind (appraisal)
                .executeUpdate()
                .getKey(int.class);


        return appraisalId;
    }

    @Override
    public void bulkCreate(List<Appraisal> appraisals) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,AppraisalQuery.INSERT, false);
            for (Appraisal appraisal : appraisals) {
                query.bind(appraisal).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Appraisal appraisal) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.UPDATE, true)
                .bind (appraisal)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int appraisalId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.DELETE, true)
                .addParameter("appraisalId", appraisalId)
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
                    .execute(AppraisalQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Appraisal> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ, true)
                .executeAndFetch(Appraisal.class);
    }
    @Override
    public List<Appraisal> readByAppraisalCreatedAt(String appraisalCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ_BY_APPRAISAL_APPRAISALCREATEDAT, true)
                .addParameter("appraisalCreatedAt", appraisalCreatedAt)
                .executeAndFetch(Appraisal.class);
    }
    @Override
    public List<Appraisal> readByAppraisalDate(String appraisalDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ_BY_APPRAISAL_APPRAISALDATE, true)
                .addParameter("appraisalDate", appraisalDate)
                .executeAndFetch(Appraisal.class);
    }
    @Override
    public List<Appraisal> readByAppraisalEmployeeIdRoleId(int appraisalEmployeeIdRoleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ_BY_APPRAISAL_APPRAISALEMPLOYEEIDROLEID, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalEmployeeIdRoleId)
                .executeAndFetch(Appraisal.class);
    }
    @Override
    public List<Appraisal> readByAppraisalFormId(int appraisalFormId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ_BY_APPRAISAL_APPRAISALFORMID, true)
                .addParameter("appraisalFormId", appraisalFormId)
                .executeAndFetch(Appraisal.class);
    }
    @Override
    public List<Appraisal> readByAppraisalGeneralFeedback(String appraisalGeneralFeedback) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ_BY_APPRAISAL_APPRAISALGENERALFEEDBACK, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalGeneralFeedback)
                .executeAndFetch(Appraisal.class);
    }
    @Override
    public Appraisal readByAppraisalId(int appraisalId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ_BY_APPRAISAL_APPRAISALID, true)
                .addParameter("appraisalId", appraisalId)
                .executeAndFetch (Appraisal.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Appraisal> readByAppraisalOverallScore(Double appraisalOverallScore) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ_BY_APPRAISAL_APPRAISALOVERALLSCORE, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalOverallScore)
                .executeAndFetch(Appraisal.class);
    }
    @Override
    public List<Appraisal> readByAppraisalReviewerId(int appraisalReviewerId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ_BY_APPRAISAL_APPRAISALREVIEWERID, true)
                .addParameter("appraisalReviewerId", appraisalReviewerId)
                .executeAndFetch(Appraisal.class);
    }
    @Override
    public List<Appraisal> readByAppraisalStatus(String appraisalStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ_BY_APPRAISAL_APPRAISALSTATUS, true)
                .addParameter("appraisalStatus", appraisalStatus)
                .executeAndFetch(Appraisal.class);
    }
    @Override
    public List<Appraisal> readByAppraisalUpdatedAt(String appraisalUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuery.READ_BY_APPRAISAL_APPRAISALUPDATEDAT, true)
                .addParameter("appraisalUpdatedAt", appraisalUpdatedAt)
                .executeAndFetch(Appraisal.class);
    }

@Override
public AppraisalPage findAppraisal(AppraisalFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(AppraisalQuery.READ);

    // Dynamic filters

    if (filter.getAppraisalCreatedAt() != null) {   baseSql.append(" AND appraisalCreatedAt = :appraisalCreatedAt"); }
    if (filter.getAppraisalDate() != null) {   baseSql.append(" AND appraisalDate = :appraisalDate"); }
    if (filter.getAppraisalEmployeeIdRoleId() != null) {   baseSql.append(" AND appraisalEmployeeIdRoleId = :appraisalEmployeeIdRoleId"); }
    if (filter.getAppraisalFormId() != null) {   baseSql.append(" AND appraisalFormId = :appraisalFormId"); }
    if (filter.getAppraisalGeneralFeedback() != null) {   baseSql.append(" AND appraisalGeneralFeedback = :appraisalGeneralFeedback"); }
    if (filter.getAppraisalId() != null) {   baseSql.append(" AND appraisalId = :appraisalId"); }
    if (filter.getAppraisalOverallScore() != null) {   baseSql.append(" AND appraisalOverallScore = :appraisalOverallScore"); }
    if (filter.getAppraisalReviewerId() != null) {   baseSql.append(" AND appraisalReviewerId = :appraisalReviewerId"); }
    if (filter.getAppraisalStatus() != null) {   baseSql.append(" AND appraisalStatus = :appraisalStatus"); }
    if (filter.getAppraisalUpdatedAt() != null) {   baseSql.append(" AND appraisalUpdatedAt = :appraisalUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getAppraisalCreatedAt() != null) countQuery.addParameter("appraisalCreatedAt", filter.getAppraisalCreatedAt());
     if (filter.getAppraisalDate() != null) countQuery.addParameter("appraisalDate", filter.getAppraisalDate());
     if (filter.getAppraisalEmployeeIdRoleId() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalEmployeeIdRoleId());
     if (filter.getAppraisalFormId() != null) countQuery.addParameter("appraisalFormId", filter.getAppraisalFormId());
     if (filter.getAppraisalGeneralFeedback() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalGeneralFeedback());
     if (filter.getAppraisalId() != null) countQuery.addParameter("appraisalId", filter.getAppraisalId());
     if (filter.getAppraisalOverallScore() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalOverallScore());
     if (filter.getAppraisalReviewerId() != null) countQuery.addParameter("appraisalReviewerId", filter.getAppraisalReviewerId());
     if (filter.getAppraisalStatus() != null) countQuery.addParameter("appraisalStatus", filter.getAppraisalStatus());
     if (filter.getAppraisalUpdatedAt() != null) countQuery.addParameter("appraisalUpdatedAt", filter.getAppraisalUpdatedAt());
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

    if (filter.getAppraisalCreatedAt() != null) pageQuery.addParameter("appraisalCreatedAt", filter.getAppraisalCreatedAt());
    if (filter.getAppraisalDate() != null) pageQuery.addParameter("appraisalDate", filter.getAppraisalDate());
    if (filter.getAppraisalEmployeeIdRoleId() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalEmployeeIdRoleId());
    if (filter.getAppraisalFormId() != null) pageQuery.addParameter("appraisalFormId", filter.getAppraisalFormId());
    if (filter.getAppraisalGeneralFeedback() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalGeneralFeedback());
    if (filter.getAppraisalId() != null) pageQuery.addParameter("appraisalId", filter.getAppraisalId());
    if (filter.getAppraisalOverallScore() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalOverallScore());
    if (filter.getAppraisalReviewerId() != null) pageQuery.addParameter("appraisalReviewerId", filter.getAppraisalReviewerId());
    if (filter.getAppraisalStatus() != null) pageQuery.addParameter("appraisalStatus", filter.getAppraisalStatus());
    if (filter.getAppraisalUpdatedAt() != null) pageQuery.addParameter("appraisalUpdatedAt", filter.getAppraisalUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Appraisal> data = pageQuery.executeAndFetch(Appraisal.class);

     return new AppraisalPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "appraisalCreatedAt","appraisalDate",System.getenv("API_KEY_APPRAISA"),"appraisalFormId",System.getenv("API_KEY_APPRAISA"),"appraisalId",System.getenv("API_KEY_APPRAISA"),"appraisalReviewerId","appraisalStatus","appraisalUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
