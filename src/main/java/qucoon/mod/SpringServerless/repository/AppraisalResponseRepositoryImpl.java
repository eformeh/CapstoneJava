
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
public class AppraisalResponseRepositoryImpl implements AppraisalResponseRepository {

    private final Environment environment;

    @Autowired
    public AppraisalResponseRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(AppraisalResponse  appraisalresponse) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int appraisalResponseId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), AppraisalResponseQuery.INSERT, true)
                .bind (appraisalresponse)
                .executeUpdate()
                .getKey(int.class);


        return appraisalResponseId;
    }

    @Override
    public void bulkCreate(List<AppraisalResponse> appraisalresponses) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,AppraisalResponseQuery.INSERT, false);
            for (AppraisalResponse appraisalresponse : appraisalresponses) {
                query.bind(appraisalresponse).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(AppraisalResponse appraisalresponse) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.UPDATE, true)
                .bind (appraisalresponse)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int appraisalResponseId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.DELETE, true)
                .addParameter("appraisalResponseId", appraisalResponseId)
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
                    .execute(AppraisalResponseQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<AppraisalResponse> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.READ, true)
                .executeAndFetch(AppraisalResponse.class);
    }
    @Override
    public List<AppraisalResponse> readByAppraisalResponseAppraisalId(int appraisalResponseAppraisalId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSEAPPRAISALID, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalResponseAppraisalId)
                .executeAndFetch(AppraisalResponse.class);
    }
    @Override
    public List<AppraisalResponse> readByAppraisalResponseCreatedAt(String appraisalResponseCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSECREATEDAT, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalResponseCreatedAt)
                .executeAndFetch(AppraisalResponse.class);
    }
    @Override
    public AppraisalResponse readByAppraisalResponseId(int appraisalResponseId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSEID, true)
                .addParameter("appraisalResponseId", appraisalResponseId)
                .executeAndFetch (AppraisalResponse.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<AppraisalResponse> readByAppraisalResponseQuestionId(int appraisalResponseQuestionId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSEQUESTIONID, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalResponseQuestionId)
                .executeAndFetch(AppraisalResponse.class);
    }
    @Override
    public List<AppraisalResponse> readByAppraisalResponseScore(Double appraisalResponseScore) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSESCORE, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalResponseScore)
                .executeAndFetch(AppraisalResponse.class);
    }
    @Override
    public List<AppraisalResponse> readByAppraisalResponseStatus(String appraisalResponseStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSESTATUS, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalResponseStatus)
                .executeAndFetch(AppraisalResponse.class);
    }
    @Override
    public List<AppraisalResponse> readByAppraisalResponseUpdatedAt(String appraisalResponseUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSEUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalResponseUpdatedAt)
                .executeAndFetch(AppraisalResponse.class);
    }
    @Override
    public List<AppraisalResponse> readByAppraisalResponseValue(String appraisalResponseValue) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalResponseQuery.READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSEVALUE, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalResponseValue)
                .executeAndFetch(AppraisalResponse.class);
    }

@Override
public AppraisalResponsePage findAppraisalResponse(AppraisalResponseFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(AppraisalResponseQuery.READ);

    // Dynamic filters

    if (filter.getAppraisalResponseAppraisalId() != null) {   baseSql.append(" AND appraisalResponseAppraisalId = :appraisalResponseAppraisalId"); }
    if (filter.getAppraisalResponseCreatedAt() != null) {   baseSql.append(" AND appraisalResponseCreatedAt = :appraisalResponseCreatedAt"); }
    if (filter.getAppraisalResponseId() != null) {   baseSql.append(" AND appraisalResponseId = :appraisalResponseId"); }
    if (filter.getAppraisalResponseQuestionId() != null) {   baseSql.append(" AND appraisalResponseQuestionId = :appraisalResponseQuestionId"); }
    if (filter.getAppraisalResponseScore() != null) {   baseSql.append(" AND appraisalResponseScore = :appraisalResponseScore"); }
    if (filter.getAppraisalResponseStatus() != null) {   baseSql.append(" AND appraisalResponseStatus = :appraisalResponseStatus"); }
    if (filter.getAppraisalResponseUpdatedAt() != null) {   baseSql.append(" AND appraisalResponseUpdatedAt = :appraisalResponseUpdatedAt"); }
    if (filter.getAppraisalResponseValue() != null) {   baseSql.append(" AND appraisalResponseValue = :appraisalResponseValue"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getAppraisalResponseAppraisalId() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseAppraisalId());
     if (filter.getAppraisalResponseCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseCreatedAt());
     if (filter.getAppraisalResponseId() != null) countQuery.addParameter("appraisalResponseId", filter.getAppraisalResponseId());
     if (filter.getAppraisalResponseQuestionId() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseQuestionId());
     if (filter.getAppraisalResponseScore() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseScore());
     if (filter.getAppraisalResponseStatus() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseStatus());
     if (filter.getAppraisalResponseUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseUpdatedAt());
     if (filter.getAppraisalResponseValue() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseValue());
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

    if (filter.getAppraisalResponseAppraisalId() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseAppraisalId());
    if (filter.getAppraisalResponseCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseCreatedAt());
    if (filter.getAppraisalResponseId() != null) pageQuery.addParameter("appraisalResponseId", filter.getAppraisalResponseId());
    if (filter.getAppraisalResponseQuestionId() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseQuestionId());
    if (filter.getAppraisalResponseScore() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseScore());
    if (filter.getAppraisalResponseStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseStatus());
    if (filter.getAppraisalResponseUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseUpdatedAt());
    if (filter.getAppraisalResponseValue() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalResponseValue());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<AppraisalResponse> data = pageQuery.executeAndFetch(AppraisalResponse.class);

     return new AppraisalResponsePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA"),"appraisalResponseId",System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
