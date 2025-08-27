
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
public class SaleDeliveryRepositoryImpl implements SaleDeliveryRepository {

    private final Environment environment;

    @Autowired
    public SaleDeliveryRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(SaleDelivery  saledelivery) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int saleDeliveryId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), SaleDeliveryQuery.INSERT, true)
                .bind (saledelivery)
                .executeUpdate()
                .getKey(int.class);


        return saleDeliveryId;
    }

    @Override
    public void bulkCreate(List<SaleDelivery> saledeliverys) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,SaleDeliveryQuery.INSERT, false);
            for (SaleDelivery saledelivery : saledeliverys) {
                query.bind(saledelivery).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(SaleDelivery saledelivery) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.UPDATE, true)
                .bind (saledelivery)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int saleDeliveryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.DELETE, true)
                .addParameter("saleDeliveryId", saleDeliveryId)
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
                    .execute(SaleDeliveryQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SaleDelivery> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ, true)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryAddress(String saleDeliveryAddress) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYADDRESS, true)
                .addParameter("saleDeliveryAddress", saleDeliveryAddress)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryConfirmedAt(String saleDeliveryConfirmedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYCONFIRMEDAT, true)
                .addParameter(System.getenv("API_KEY_SALEDELI"), saleDeliveryConfirmedAt)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryContactName(String saleDeliveryContactName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYCONTACTNAME, true)
                .addParameter(System.getenv("API_KEY_SALEDELI"), saleDeliveryContactName)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryContactPhone(String saleDeliveryContactPhone) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYCONTACTPHONE, true)
                .addParameter(System.getenv("API_KEY_SALEDELI"), saleDeliveryContactPhone)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryCreatedAt(String saleDeliveryCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_SALEDELI"), saleDeliveryCreatedAt)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryExpectedDeliveryDate(String saleDeliveryExpectedDeliveryDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYEXPECTEDDELIVERYDATE, true)
                .addParameter(System.getenv("API_KEY_SALEDELI"), saleDeliveryExpectedDeliveryDate)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public SaleDelivery readBySaleDeliveryId(int saleDeliveryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYID, true)
                .addParameter("saleDeliveryId", saleDeliveryId)
                .executeAndFetch (SaleDelivery.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryNotes(String saleDeliveryNotes) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYNOTES, true)
                .addParameter("saleDeliveryNotes", saleDeliveryNotes)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryProvider(String saleDeliveryProvider) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYPROVIDER, true)
                .addParameter(System.getenv("API_KEY_SALEDELI"), saleDeliveryProvider)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliverySaleId(int saleDeliverySaleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYSALEID, true)
                .addParameter("saleDeliverySaleId", saleDeliverySaleId)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryStatus(String saleDeliveryStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYSTATUS, true)
                .addParameter("saleDeliveryStatus", saleDeliveryStatus)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryTrackingNumber(String saleDeliveryTrackingNumber) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYTRACKINGNUMBER, true)
                .addParameter(System.getenv("API_KEY_SALEDELI"), saleDeliveryTrackingNumber)
                .executeAndFetch(SaleDelivery.class);
    }
    @Override
    public List<SaleDelivery> readBySaleDeliveryUpdatedAt(String saleDeliveryUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleDeliveryQuery.READ_BY_SALE_DELIVERY_SALEDELIVERYUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_SALEDELI"), saleDeliveryUpdatedAt)
                .executeAndFetch(SaleDelivery.class);
    }

@Override
public SaleDeliveryPage findSaleDelivery(SaleDeliveryFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(SaleDeliveryQuery.READ);

    // Dynamic filters

    if (filter.getSaleDeliveryAddress() != null) {   baseSql.append(" AND saleDeliveryAddress = :saleDeliveryAddress"); }
    if (filter.getSaleDeliveryConfirmedAt() != null) {   baseSql.append(" AND saleDeliveryConfirmedAt = :saleDeliveryConfirmedAt"); }
    if (filter.getSaleDeliveryContactName() != null) {   baseSql.append(" AND saleDeliveryContactName = :saleDeliveryContactName"); }
    if (filter.getSaleDeliveryContactPhone() != null) {   baseSql.append(" AND saleDeliveryContactPhone = :saleDeliveryContactPhone"); }
    if (filter.getSaleDeliveryCreatedAt() != null) {   baseSql.append(" AND saleDeliveryCreatedAt = :saleDeliveryCreatedAt"); }
    if (filter.getSaleDeliveryExpectedDeliveryDate() != null) {   baseSql.append(" AND saleDeliveryExpectedDeliveryDate = :saleDeliveryExpectedDeliveryDate"); }
    if (filter.getSaleDeliveryId() != null) {   baseSql.append(" AND saleDeliveryId = :saleDeliveryId"); }
    if (filter.getSaleDeliveryNotes() != null) {   baseSql.append(" AND saleDeliveryNotes = :saleDeliveryNotes"); }
    if (filter.getSaleDeliveryProvider() != null) {   baseSql.append(" AND saleDeliveryProvider = :saleDeliveryProvider"); }
    if (filter.getSaleDeliverySaleId() != null) {   baseSql.append(" AND saleDeliverySaleId = :saleDeliverySaleId"); }
    if (filter.getSaleDeliveryStatus() != null) {   baseSql.append(" AND saleDeliveryStatus = :saleDeliveryStatus"); }
    if (filter.getSaleDeliveryTrackingNumber() != null) {   baseSql.append(" AND saleDeliveryTrackingNumber = :saleDeliveryTrackingNumber"); }
    if (filter.getSaleDeliveryUpdatedAt() != null) {   baseSql.append(" AND saleDeliveryUpdatedAt = :saleDeliveryUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getSaleDeliveryAddress() != null) countQuery.addParameter("saleDeliveryAddress", filter.getSaleDeliveryAddress());
     if (filter.getSaleDeliveryConfirmedAt() != null) countQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryConfirmedAt());
     if (filter.getSaleDeliveryContactName() != null) countQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryContactName());
     if (filter.getSaleDeliveryContactPhone() != null) countQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryContactPhone());
     if (filter.getSaleDeliveryCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryCreatedAt());
     if (filter.getSaleDeliveryExpectedDeliveryDate() != null) countQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryExpectedDeliveryDate());
     if (filter.getSaleDeliveryId() != null) countQuery.addParameter("saleDeliveryId", filter.getSaleDeliveryId());
     if (filter.getSaleDeliveryNotes() != null) countQuery.addParameter("saleDeliveryNotes", filter.getSaleDeliveryNotes());
     if (filter.getSaleDeliveryProvider() != null) countQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryProvider());
     if (filter.getSaleDeliverySaleId() != null) countQuery.addParameter("saleDeliverySaleId", filter.getSaleDeliverySaleId());
     if (filter.getSaleDeliveryStatus() != null) countQuery.addParameter("saleDeliveryStatus", filter.getSaleDeliveryStatus());
     if (filter.getSaleDeliveryTrackingNumber() != null) countQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryTrackingNumber());
     if (filter.getSaleDeliveryUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryUpdatedAt());
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

    if (filter.getSaleDeliveryAddress() != null) pageQuery.addParameter("saleDeliveryAddress", filter.getSaleDeliveryAddress());
    if (filter.getSaleDeliveryConfirmedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryConfirmedAt());
    if (filter.getSaleDeliveryContactName() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryContactName());
    if (filter.getSaleDeliveryContactPhone() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryContactPhone());
    if (filter.getSaleDeliveryCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryCreatedAt());
    if (filter.getSaleDeliveryExpectedDeliveryDate() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryExpectedDeliveryDate());
    if (filter.getSaleDeliveryId() != null) pageQuery.addParameter("saleDeliveryId", filter.getSaleDeliveryId());
    if (filter.getSaleDeliveryNotes() != null) pageQuery.addParameter("saleDeliveryNotes", filter.getSaleDeliveryNotes());
    if (filter.getSaleDeliveryProvider() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryProvider());
    if (filter.getSaleDeliverySaleId() != null) pageQuery.addParameter("saleDeliverySaleId", filter.getSaleDeliverySaleId());
    if (filter.getSaleDeliveryStatus() != null) pageQuery.addParameter("saleDeliveryStatus", filter.getSaleDeliveryStatus());
    if (filter.getSaleDeliveryTrackingNumber() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryTrackingNumber());
    if (filter.getSaleDeliveryUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEDELI"), filter.getSaleDeliveryUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<SaleDelivery> data = pageQuery.executeAndFetch(SaleDelivery.class);

     return new SaleDeliveryPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "saleDeliveryAddress",System.getenv("API_KEY_SALEDELI"),System.getenv("API_KEY_SALEDELI"),System.getenv("API_KEY_SALEDELI"),System.getenv("API_KEY_SALEDELI"),System.getenv("API_KEY_SALEDELI"),"saleDeliveryId","saleDeliveryNotes",System.getenv("API_KEY_SALEDELI"),"saleDeliverySaleId","saleDeliveryStatus",System.getenv("API_KEY_SALEDELI"),System.getenv("API_KEY_SALEDELI")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
