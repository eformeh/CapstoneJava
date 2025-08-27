package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductionRecordFilterRequest {

private String productionRecordBatchNumber;
private String productionRecordCreatedAt;
private Integer productionRecordCreatedByUserId;
private String productionRecordDate;
private Integer productionRecordFinishedGoodProductId;
private Integer productionRecordId;
private String productionRecordStatus;
private String productionRecordUpdatedAt;
private String supplierPhoneNumber;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
