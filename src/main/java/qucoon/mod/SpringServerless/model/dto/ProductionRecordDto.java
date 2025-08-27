package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.ProductionRecord;


@Data
public class ProductionRecordDto  {

private String productionRecordBatchNumber;
private String productionRecordCreatedAt;
private Integer productionRecordCreatedByUserId;
private String productionRecordDate;
private Integer productionRecordFinishedGoodProductId;
private Integer productionRecordId;
private String productionRecordStatus;
private String productionRecordUpdatedAt;
private String supplierPhoneNumber;

public static ProductionRecordDto from(ProductionRecord p) {
    ProductionRecordDto dto = new ProductionRecordDto();

    dto.setProductionRecordBatchNumber(p.getProductionRecordBatchNumber());
    dto.setProductionRecordCreatedAt(p.getProductionRecordCreatedAt());
    dto.setProductionRecordCreatedByUserId(p.getProductionRecordCreatedByUserId());
    dto.setProductionRecordDate(p.getProductionRecordDate());
    dto.setProductionRecordFinishedGoodProductId(p.getProductionRecordFinishedGoodProductId());
    dto.setProductionRecordId(p.getProductionRecordId());
    dto.setProductionRecordStatus(p.getProductionRecordStatus());
    dto.setProductionRecordUpdatedAt(p.getProductionRecordUpdatedAt());
    dto.setSupplierPhoneNumber(p.getSupplierPhoneNumber());
    return dto;
   }
}
