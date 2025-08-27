
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
public class OnboardingTaskRepositoryImpl implements OnboardingTaskRepository {

    private final Environment environment;

    @Autowired
    public OnboardingTaskRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(OnboardingTask  onboardingtask) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int onboardingTaskId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), OnboardingTaskQuery.INSERT, true)
                .bind (onboardingtask)
                .executeUpdate()
                .getKey(int.class);


        return onboardingTaskId;
    }

    @Override
    public void bulkCreate(List<OnboardingTask> onboardingtasks) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,OnboardingTaskQuery.INSERT, false);
            for (OnboardingTask onboardingtask : onboardingtasks) {
                query.bind(onboardingtask).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(OnboardingTask onboardingtask) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OnboardingTaskQuery.UPDATE, true)
                .bind (onboardingtask)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int onboardingTaskId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OnboardingTaskQuery.DELETE, true)
                .addParameter("onboardingTaskId", onboardingTaskId)
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
                    .execute(OnboardingTaskQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<OnboardingTask> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OnboardingTaskQuery.READ, true)
                .executeAndFetch(OnboardingTask.class);
    }
    @Override
    public List<OnboardingTask> readByOnboardingTaskCreatedAt(String onboardingTaskCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OnboardingTaskQuery.READ_BY_ONBOARDING_TASK_ONBOARDINGTASKCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_ONBOARDI"), onboardingTaskCreatedAt)
                .executeAndFetch(OnboardingTask.class);
    }
    @Override
    public List<OnboardingTask> readByOnboardingTaskCreatedBy(int onboardingTaskCreatedBy) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OnboardingTaskQuery.READ_BY_ONBOARDING_TASK_ONBOARDINGTASKCREATEDBY, true)
                .addParameter(System.getenv("API_KEY_ONBOARDI"), onboardingTaskCreatedBy)
                .executeAndFetch(OnboardingTask.class);
    }
    @Override
    public List<OnboardingTask> readByOnboardingTaskDescription(String onboardingTaskDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OnboardingTaskQuery.READ_BY_ONBOARDING_TASK_ONBOARDINGTASKDESCRIPTION, true)
                .addParameter(System.getenv("API_KEY_ONBOARDI"), onboardingTaskDescription)
                .executeAndFetch(OnboardingTask.class);
    }
    @Override
    public OnboardingTask readByOnboardingTaskId(int onboardingTaskId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OnboardingTaskQuery.READ_BY_ONBOARDING_TASK_ONBOARDINGTASKID, true)
                .addParameter("onboardingTaskId", onboardingTaskId)
                .executeAndFetch (OnboardingTask.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<OnboardingTask> readByOnboardingTaskStatus(String onboardingTaskStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OnboardingTaskQuery.READ_BY_ONBOARDING_TASK_ONBOARDINGTASKSTATUS, true)
                .addParameter(System.getenv("API_KEY_ONBOARDI"), onboardingTaskStatus)
                .executeAndFetch(OnboardingTask.class);
    }
    @Override
    public List<OnboardingTask> readByOnboardingTaskUpdatedAt(String onboardingTaskUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OnboardingTaskQuery.READ_BY_ONBOARDING_TASK_ONBOARDINGTASKUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_ONBOARDI"), onboardingTaskUpdatedAt)
                .executeAndFetch(OnboardingTask.class);
    }

@Override
public OnboardingTaskPage findOnboardingTask(OnboardingTaskFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(OnboardingTaskQuery.READ);

    // Dynamic filters

    if (filter.getOnboardingTaskCreatedAt() != null) {   baseSql.append(" AND onboardingTaskCreatedAt = :onboardingTaskCreatedAt"); }
    if (filter.getOnboardingTaskCreatedBy() != null) {   baseSql.append(" AND onboardingTaskCreatedBy = :onboardingTaskCreatedBy"); }
    if (filter.getOnboardingTaskDescription() != null) {   baseSql.append(" AND onboardingTaskDescription = :onboardingTaskDescription"); }
    if (filter.getOnboardingTaskId() != null) {   baseSql.append(" AND onboardingTaskId = :onboardingTaskId"); }
    if (filter.getOnboardingTaskStatus() != null) {   baseSql.append(" AND onboardingTaskStatus = :onboardingTaskStatus"); }
    if (filter.getOnboardingTaskUpdatedAt() != null) {   baseSql.append(" AND onboardingTaskUpdatedAt = :onboardingTaskUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getOnboardingTaskCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_ONBOARDI"), filter.getOnboardingTaskCreatedAt());
     if (filter.getOnboardingTaskCreatedBy() != null) countQuery.addParameter(System.getenv("API_KEY_ONBOARDI"), filter.getOnboardingTaskCreatedBy());
     if (filter.getOnboardingTaskDescription() != null) countQuery.addParameter(System.getenv("API_KEY_ONBOARDI"), filter.getOnboardingTaskDescription());
     if (filter.getOnboardingTaskId() != null) countQuery.addParameter("onboardingTaskId", filter.getOnboardingTaskId());
     if (filter.getOnboardingTaskStatus() != null) countQuery.addParameter(System.getenv("API_KEY_ONBOARDI"), filter.getOnboardingTaskStatus());
     if (filter.getOnboardingTaskUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_ONBOARDI"), filter.getOnboardingTaskUpdatedAt());
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

    if (filter.getOnboardingTaskCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_ONBOARDI"), filter.getOnboardingTaskCreatedAt());
    if (filter.getOnboardingTaskCreatedBy() != null) pageQuery.addParameter(System.getenv("API_KEY_ONBOARDI"), filter.getOnboardingTaskCreatedBy());
    if (filter.getOnboardingTaskDescription() != null) pageQuery.addParameter(System.getenv("API_KEY_ONBOARDI"), filter.getOnboardingTaskDescription());
    if (filter.getOnboardingTaskId() != null) pageQuery.addParameter("onboardingTaskId", filter.getOnboardingTaskId());
    if (filter.getOnboardingTaskStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_ONBOARDI"), filter.getOnboardingTaskStatus());
    if (filter.getOnboardingTaskUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_ONBOARDI"), filter.getOnboardingTaskUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<OnboardingTask> data = pageQuery.executeAndFetch(OnboardingTask.class);

     return new OnboardingTaskPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_ONBOARDI"),System.getenv("API_KEY_ONBOARDI"),System.getenv("API_KEY_ONBOARDI"),"onboardingTaskId",System.getenv("API_KEY_ONBOARDI"),System.getenv("API_KEY_ONBOARDI")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
