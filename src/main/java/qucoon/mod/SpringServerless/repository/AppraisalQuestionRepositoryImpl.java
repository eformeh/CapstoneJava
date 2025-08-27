
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
public class AppraisalQuestionRepositoryImpl implements AppraisalQuestionRepository {

    private final Environment environment;

    @Autowired
    public AppraisalQuestionRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(AppraisalQuestion  appraisalquestion) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int appraisalQuestionId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), AppraisalQuestionQuery.INSERT, true)
                .bind (appraisalquestion)
                .executeUpdate()
                .getKey(int.class);


        return appraisalQuestionId;
    }

    @Override
    public void bulkCreate(List<AppraisalQuestion> appraisalquestions) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,AppraisalQuestionQuery.INSERT, false);
            for (AppraisalQuestion appraisalquestion : appraisalquestions) {
                query.bind(appraisalquestion).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(AppraisalQuestion appraisalquestion) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.UPDATE, true)
                .bind (appraisalquestion)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int appraisalQuestionId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.DELETE, true)
                .addParameter("appraisalQuestionId", appraisalQuestionId)
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
                    .execute(AppraisalQuestionQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<AppraisalQuestion> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.READ, true)
                .executeAndFetch(AppraisalQuestion.class);
    }
    @Override
    public List<AppraisalQuestion> readByAppraisalFormId(int appraisalFormId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.READ_BY_APPRAISAL_QUESTION_APPRAISALFORMID, true)
                .addParameter("appraisalFormId", appraisalFormId)
                .executeAndFetch(AppraisalQuestion.class);
    }
    @Override
    public List<AppraisalQuestion> readByAppraisalQuestionCreatedAt(String appraisalQuestionCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalQuestionCreatedAt)
                .executeAndFetch(AppraisalQuestion.class);
    }
    @Override
    public AppraisalQuestion readByAppraisalQuestionId(int appraisalQuestionId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONID, true)
                .addParameter("appraisalQuestionId", appraisalQuestionId)
                .executeAndFetch (AppraisalQuestion.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<AppraisalQuestion> readByAppraisalQuestionStatus(String appraisalQuestionStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONSTATUS, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalQuestionStatus)
                .executeAndFetch(AppraisalQuestion.class);
    }
    @Override
    public List<AppraisalQuestion> readByAppraisalQuestionText(String appraisalQuestionText) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONTEXT, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalQuestionText)
                .executeAndFetch(AppraisalQuestion.class);
    }
    @Override
    public List<AppraisalQuestion> readByAppraisalQuestionType(String appraisalQuestionType) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONTYPE, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalQuestionType)
                .executeAndFetch(AppraisalQuestion.class);
    }
    @Override
    public List<AppraisalQuestion> readByAppraisalQuestionUpdatedAt(String appraisalQuestionUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalQuestionUpdatedAt)
                .executeAndFetch(AppraisalQuestion.class);
    }
    @Override
    public List<AppraisalQuestion> readByAppraisalQuestionWeight(Double appraisalQuestionWeight) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AppraisalQuestionQuery.READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONWEIGHT, true)
                .addParameter(System.getenv("API_KEY_APPRAISA"), appraisalQuestionWeight)
                .executeAndFetch(AppraisalQuestion.class);
    }

@Override
public AppraisalQuestionPage findAppraisalQuestion(AppraisalQuestionFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(AppraisalQuestionQuery.READ);

    // Dynamic filters

    if (filter.getAppraisalFormId() != null) {   baseSql.append(" AND appraisalFormId = :appraisalFormId"); }
    if (filter.getAppraisalQuestionCreatedAt() != null) {   baseSql.append(" AND appraisalQuestionCreatedAt = :appraisalQuestionCreatedAt"); }
    if (filter.getAppraisalQuestionId() != null) {   baseSql.append(" AND appraisalQuestionId = :appraisalQuestionId"); }
    if (filter.getAppraisalQuestionStatus() != null) {   baseSql.append(" AND appraisalQuestionStatus = :appraisalQuestionStatus"); }
    if (filter.getAppraisalQuestionText() != null) {   baseSql.append(" AND appraisalQuestionText = :appraisalQuestionText"); }
    if (filter.getAppraisalQuestionType() != null) {   baseSql.append(" AND appraisalQuestionType = :appraisalQuestionType"); }
    if (filter.getAppraisalQuestionUpdatedAt() != null) {   baseSql.append(" AND appraisalQuestionUpdatedAt = :appraisalQuestionUpdatedAt"); }
    if (filter.getAppraisalQuestionWeight() != null) {   baseSql.append(" AND appraisalQuestionWeight = :appraisalQuestionWeight"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getAppraisalFormId() != null) countQuery.addParameter("appraisalFormId", filter.getAppraisalFormId());
     if (filter.getAppraisalQuestionCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionCreatedAt());
     if (filter.getAppraisalQuestionId() != null) countQuery.addParameter("appraisalQuestionId", filter.getAppraisalQuestionId());
     if (filter.getAppraisalQuestionStatus() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionStatus());
     if (filter.getAppraisalQuestionText() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionText());
     if (filter.getAppraisalQuestionType() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionType());
     if (filter.getAppraisalQuestionUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionUpdatedAt());
     if (filter.getAppraisalQuestionWeight() != null) countQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionWeight());
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

    if (filter.getAppraisalFormId() != null) pageQuery.addParameter("appraisalFormId", filter.getAppraisalFormId());
    if (filter.getAppraisalQuestionCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionCreatedAt());
    if (filter.getAppraisalQuestionId() != null) pageQuery.addParameter("appraisalQuestionId", filter.getAppraisalQuestionId());
    if (filter.getAppraisalQuestionStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionStatus());
    if (filter.getAppraisalQuestionText() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionText());
    if (filter.getAppraisalQuestionType() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionType());
    if (filter.getAppraisalQuestionUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionUpdatedAt());
    if (filter.getAppraisalQuestionWeight() != null) pageQuery.addParameter(System.getenv("API_KEY_APPRAISA"), filter.getAppraisalQuestionWeight());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<AppraisalQuestion> data = pageQuery.executeAndFetch(AppraisalQuestion.class);

     return new AppraisalQuestionPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "appraisalFormId",System.getenv("API_KEY_APPRAISA"),"appraisalQuestionId",System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA"),System.getenv("API_KEY_APPRAISA")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
