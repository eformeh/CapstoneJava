package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductionRecordUpdateRequest {
public String productionRecordBatchNumber;
public String productionRecordCreatedAt;
public int productionRecordCreatedByUserId;
public String productionRecordDate;
public int productionRecordFinishedGoodProductId;
public int productionRecordId;
public String productionRecordStatus;
public String productionRecordUpdatedAt;
public String supplierPhoneNumber;
}
