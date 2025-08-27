
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.ProductionRecordPage;
import qucoon.mod.SpringServerless.model.request.ProductionRecordFilterRequest;

import java.util.List;

@Repository
    public interface ProductionRecordRepository {


    // Additional query methods can be defined here.
    int create(ProductionRecord productionrecord);
    void bulkCreate(List<ProductionRecord>  productionrecord);
    int update(ProductionRecord  productionrecord);
    int delete(int productionRecordId);
    ProductionRecordPage findProductionRecord(ProductionRecordFilterRequest filter);
    boolean truncate();
    List<ProductionRecord> read();
    List<ProductionRecord> readByProductionRecordBatchNumber(String productionRecordBatchNumber);
    List<ProductionRecord> readByProductionRecordCreatedAt(String productionRecordCreatedAt);
    List<ProductionRecord> readByProductionRecordCreatedByUserId(int productionRecordCreatedByUserId);
    List<ProductionRecord> readByProductionRecordDate(String productionRecordDate);
    List<ProductionRecord> readByProductionRecordFinishedGoodProductId(int productionRecordFinishedGoodProductId);
    ProductionRecord readByProductionRecordId(int productionRecordId);
    List<ProductionRecord> readByProductionRecordStatus(String productionRecordStatus);
    List<ProductionRecord> readByProductionRecordUpdatedAt(String productionRecordUpdatedAt);
    List<ProductionRecord> readBySupplierPhoneNumber(String supplierPhoneNumber);
}
