
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
public class LeaveTypeRepositoryImpl implements LeaveTypeRepository {

    private final Environment environment;

    @Autowired
    public LeaveTypeRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(LeaveType  leavetype) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int leaveTypeId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), LeaveTypeQuery.INSERT, true)
                .bind (leavetype)
                .executeUpdate()
                .getKey(int.class);


        return leaveTypeId;
    }

    @Override
    public void bulkCreate(List<LeaveType> leavetypes) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,LeaveTypeQuery.INSERT, false);
            for (LeaveType leavetype : leavetypes) {
                query.bind(leavetype).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(LeaveType leavetype) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.UPDATE, true)
                .bind (leavetype)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int leaveTypeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.DELETE, true)
                .addParameter("leaveTypeId", leaveTypeId)
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
                    .execute(LeaveTypeQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<LeaveType> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.READ, true)
                .executeAndFetch(LeaveType.class);
    }
    @Override
    public List<LeaveType> readByLeaveTypeAccrualRatePerMonth(Double leaveTypeAccrualRatePerMonth) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.READ_BY_LEAVE_TYPE_LEAVETYPEACCRUALRATEPERMONTH, true)
                .addParameter(System.getenv("API_KEY_LEAVETYP"), leaveTypeAccrualRatePerMonth)
                .executeAndFetch(LeaveType.class);
    }
    @Override
    public List<LeaveType> readByLeaveTypeCreatedAt(String leaveTypeCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.READ_BY_LEAVE_TYPE_LEAVETYPECREATEDAT, true)
                .addParameter("leaveTypeCreatedAt", leaveTypeCreatedAt)
                .executeAndFetch(LeaveType.class);
    }
    @Override
    public List<LeaveType> readByLeaveTypeDescription(String leaveTypeDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.READ_BY_LEAVE_TYPE_LEAVETYPEDESCRIPTION, true)
                .addParameter(System.getenv("API_KEY_LEAVETYP"), leaveTypeDescription)
                .executeAndFetch(LeaveType.class);
    }
    @Override
    public LeaveType readByLeaveTypeId(int leaveTypeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.READ_BY_LEAVE_TYPE_LEAVETYPEID, true)
                .addParameter("leaveTypeId", leaveTypeId)
                .executeAndFetch (LeaveType.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<LeaveType> readByLeaveTypeName(String leaveTypeName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.READ_BY_LEAVE_TYPE_LEAVETYPENAME, true)
                .addParameter("leaveTypeName", leaveTypeName)
                .executeAndFetch(LeaveType.class);
    }
    @Override
    public List<LeaveType> readByLeaveTypeResetPolicy(String leaveTypeResetPolicy) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.READ_BY_LEAVE_TYPE_LEAVETYPERESETPOLICY, true)
                .addParameter(System.getenv("API_KEY_LEAVETYP"), leaveTypeResetPolicy)
                .executeAndFetch(LeaveType.class);
    }
    @Override
    public List<LeaveType> readByLeaveTypeStatus(String leaveTypeStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.READ_BY_LEAVE_TYPE_LEAVETYPESTATUS, true)
                .addParameter("leaveTypeStatus", leaveTypeStatus)
                .executeAndFetch(LeaveType.class);
    }
    @Override
    public List<LeaveType> readByLeaveTypeUpdatedAt(String leaveTypeUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),LeaveTypeQuery.READ_BY_LEAVE_TYPE_LEAVETYPEUPDATEDAT, true)
                .addParameter("leaveTypeUpdatedAt", leaveTypeUpdatedAt)
                .executeAndFetch(LeaveType.class);
    }

@Override
public LeaveTypePage findLeaveType(LeaveTypeFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(LeaveTypeQuery.READ);

    // Dynamic filters

    if (filter.getLeaveTypeAccrualRatePerMonth() != null) {   baseSql.append(" AND leaveTypeAccrualRatePerMonth = :leaveTypeAccrualRatePerMonth"); }
    if (filter.getLeaveTypeCreatedAt() != null) {   baseSql.append(" AND leaveTypeCreatedAt = :leaveTypeCreatedAt"); }
    if (filter.getLeaveTypeDescription() != null) {   baseSql.append(" AND leaveTypeDescription = :leaveTypeDescription"); }
    if (filter.getLeaveTypeId() != null) {   baseSql.append(" AND leaveTypeId = :leaveTypeId"); }
    if (filter.getLeaveTypeName() != null) {   baseSql.append(" AND leaveTypeName = :leaveTypeName"); }
    if (filter.getLeaveTypeResetPolicy() != null) {   baseSql.append(" AND leaveTypeResetPolicy = :leaveTypeResetPolicy"); }
    if (filter.getLeaveTypeStatus() != null) {   baseSql.append(" AND leaveTypeStatus = :leaveTypeStatus"); }
    if (filter.getLeaveTypeUpdatedAt() != null) {   baseSql.append(" AND leaveTypeUpdatedAt = :leaveTypeUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getLeaveTypeAccrualRatePerMonth() != null) countQuery.addParameter(System.getenv("API_KEY_LEAVETYP"), filter.getLeaveTypeAccrualRatePerMonth());
     if (filter.getLeaveTypeCreatedAt() != null) countQuery.addParameter("leaveTypeCreatedAt", filter.getLeaveTypeCreatedAt());
     if (filter.getLeaveTypeDescription() != null) countQuery.addParameter(System.getenv("API_KEY_LEAVETYP"), filter.getLeaveTypeDescription());
     if (filter.getLeaveTypeId() != null) countQuery.addParameter("leaveTypeId", filter.getLeaveTypeId());
     if (filter.getLeaveTypeName() != null) countQuery.addParameter("leaveTypeName", filter.getLeaveTypeName());
     if (filter.getLeaveTypeResetPolicy() != null) countQuery.addParameter(System.getenv("API_KEY_LEAVETYP"), filter.getLeaveTypeResetPolicy());
     if (filter.getLeaveTypeStatus() != null) countQuery.addParameter("leaveTypeStatus", filter.getLeaveTypeStatus());
     if (filter.getLeaveTypeUpdatedAt() != null) countQuery.addParameter("leaveTypeUpdatedAt", filter.getLeaveTypeUpdatedAt());
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

    if (filter.getLeaveTypeAccrualRatePerMonth() != null) pageQuery.addParameter(System.getenv("API_KEY_LEAVETYP"), filter.getLeaveTypeAccrualRatePerMonth());
    if (filter.getLeaveTypeCreatedAt() != null) pageQuery.addParameter("leaveTypeCreatedAt", filter.getLeaveTypeCreatedAt());
    if (filter.getLeaveTypeDescription() != null) pageQuery.addParameter(System.getenv("API_KEY_LEAVETYP"), filter.getLeaveTypeDescription());
    if (filter.getLeaveTypeId() != null) pageQuery.addParameter("leaveTypeId", filter.getLeaveTypeId());
    if (filter.getLeaveTypeName() != null) pageQuery.addParameter("leaveTypeName", filter.getLeaveTypeName());
    if (filter.getLeaveTypeResetPolicy() != null) pageQuery.addParameter(System.getenv("API_KEY_LEAVETYP"), filter.getLeaveTypeResetPolicy());
    if (filter.getLeaveTypeStatus() != null) pageQuery.addParameter("leaveTypeStatus", filter.getLeaveTypeStatus());
    if (filter.getLeaveTypeUpdatedAt() != null) pageQuery.addParameter("leaveTypeUpdatedAt", filter.getLeaveTypeUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<LeaveType> data = pageQuery.executeAndFetch(LeaveType.class);

     return new LeaveTypePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_LEAVETYP"),"leaveTypeCreatedAt",System.getenv("API_KEY_LEAVETYP"),"leaveTypeId","leaveTypeName",System.getenv("API_KEY_LEAVETYP"),"leaveTypeStatus","leaveTypeUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
