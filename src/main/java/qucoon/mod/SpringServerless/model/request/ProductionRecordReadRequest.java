package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductionRecordReadRequest {
@NotEmpty(message = "Productionrecordbatchnumber is required")
public String productionRecordBatchNumber;
@NotEmpty(message = "Productionrecordcreatedat is required")
public String productionRecordCreatedAt;
@NotEmpty(message = "Productionrecordcreatedbyuserid is required")
public int productionRecordCreatedByUserId;
@NotEmpty(message = "Productionrecorddate is required")
public String productionRecordDate;
@NotEmpty(message = "Productionrecordfinishedgoodproductid is required")
public int productionRecordFinishedGoodProductId;
@NotEmpty(message = "Productionrecordid is required")
public int productionRecordId;
@NotEmpty(message = "Productionrecordstatus is required")
public String productionRecordStatus;
@NotEmpty(message = "Productionrecordupdatedat is required")
public String productionRecordUpdatedAt;
@NotEmpty(message = "Supplierphonenumber is required")
public String supplierPhoneNumber;
}
