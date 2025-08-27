package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class ProductionRecordCreateRequest {
public String productionRecordBatchNumber;
@NotNull(message = "productionRecordCreatedByUserId is required")
public int productionRecordCreatedByUserId;
public String productionRecordDate;
@NotNull(message = "productionRecordFinishedGoodProductId is required")
public int productionRecordFinishedGoodProductId;
public String supplierPhoneNumber;
}
