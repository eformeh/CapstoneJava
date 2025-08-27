
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
public class JobRepositoryImpl implements JobRepository {

    private final Environment environment;

    @Autowired
    public JobRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Job  job) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int jobId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), JobQuery.INSERT, true)
                .bind (job)
                .executeUpdate()
                .getKey(int.class);


        return jobId;
    }

    @Override
    public void bulkCreate(List<Job> jobs) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,JobQuery.INSERT, false);
            for (Job job : jobs) {
                query.bind(job).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Job job) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),JobQuery.UPDATE, true)
                .bind (job)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int jobId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),JobQuery.DELETE, true)
                .addParameter("jobId", jobId)
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
                    .execute(JobQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Job> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),JobQuery.READ, true)
                .executeAndFetch(Job.class);
    }
    @Override
    public List<Job> readByJobCreatedAt(String jobCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),JobQuery.READ_BY_JOB_JOBCREATEDAT, true)
                .addParameter("jobCreatedAt", jobCreatedAt)
                .executeAndFetch(Job.class);
    }
    @Override
    public List<Job> readByJobDepartmentId(int jobDepartmentId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),JobQuery.READ_BY_JOB_JOBDEPARTMENTID, true)
                .addParameter("jobDepartmentId", jobDepartmentId)
                .executeAndFetch(Job.class);
    }
    @Override
    public Job readByJobId(int jobId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),JobQuery.READ_BY_JOB_JOBID, true)
                .addParameter("jobId", jobId)
                .executeAndFetch (Job.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Job> readByJobRoleId(int jobRoleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),JobQuery.READ_BY_JOB_JOBROLEID, true)
                .addParameter("jobRoleId", jobRoleId)
                .executeAndFetch(Job.class);
    }
    @Override
    public List<Job> readByJobStatus(String jobStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),JobQuery.READ_BY_JOB_JOBSTATUS, true)
                .addParameter("jobStatus", jobStatus)
                .executeAndFetch(Job.class);
    }
    @Override
    public List<Job> readByJobUpdatedAt(String jobUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),JobQuery.READ_BY_JOB_JOBUPDATEDAT, true)
                .addParameter("jobUpdatedAt", jobUpdatedAt)
                .executeAndFetch(Job.class);
    }

@Override
public JobPage findJob(JobFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(JobQuery.READ);

    // Dynamic filters

    if (filter.getJobCreatedAt() != null) {   baseSql.append(" AND jobCreatedAt = :jobCreatedAt"); }
    if (filter.getJobDepartmentId() != null) {   baseSql.append(" AND jobDepartmentId = :jobDepartmentId"); }
    if (filter.getJobId() != null) {   baseSql.append(" AND jobId = :jobId"); }
    if (filter.getJobRoleId() != null) {   baseSql.append(" AND jobRoleId = :jobRoleId"); }
    if (filter.getJobStatus() != null) {   baseSql.append(" AND jobStatus = :jobStatus"); }
    if (filter.getJobUpdatedAt() != null) {   baseSql.append(" AND jobUpdatedAt = :jobUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getJobCreatedAt() != null) countQuery.addParameter("jobCreatedAt", filter.getJobCreatedAt());
     if (filter.getJobDepartmentId() != null) countQuery.addParameter("jobDepartmentId", filter.getJobDepartmentId());
     if (filter.getJobId() != null) countQuery.addParameter("jobId", filter.getJobId());
     if (filter.getJobRoleId() != null) countQuery.addParameter("jobRoleId", filter.getJobRoleId());
     if (filter.getJobStatus() != null) countQuery.addParameter("jobStatus", filter.getJobStatus());
     if (filter.getJobUpdatedAt() != null) countQuery.addParameter("jobUpdatedAt", filter.getJobUpdatedAt());
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

    if (filter.getJobCreatedAt() != null) pageQuery.addParameter("jobCreatedAt", filter.getJobCreatedAt());
    if (filter.getJobDepartmentId() != null) pageQuery.addParameter("jobDepartmentId", filter.getJobDepartmentId());
    if (filter.getJobId() != null) pageQuery.addParameter("jobId", filter.getJobId());
    if (filter.getJobRoleId() != null) pageQuery.addParameter("jobRoleId", filter.getJobRoleId());
    if (filter.getJobStatus() != null) pageQuery.addParameter("jobStatus", filter.getJobStatus());
    if (filter.getJobUpdatedAt() != null) pageQuery.addParameter("jobUpdatedAt", filter.getJobUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Job> data = pageQuery.executeAndFetch(Job.class);

     return new JobPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "jobCreatedAt","jobDepartmentId","jobId","jobRoleId","jobStatus","jobUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
