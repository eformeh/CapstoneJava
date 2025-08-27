package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductionMaterialReadRequest {
@NotEmpty(message = "Productionmaterialcreatedat is required")
public String productionMaterialCreatedAt;
@NotEmpty(message = "Productionmaterialid is required")
public int productionMaterialId;
@NotEmpty(message = "Productionmaterialinventoryitemid is required")
public int productionMaterialInventoryItemId;
@NotEmpty(message = "Productionmaterialproductionrecordid is required")
public int productionMaterialProductionRecordId;
@NotEmpty(message = "Productionmaterialquantityconsumed is required")
public int productionMaterialQuantityConsumed;
@NotEmpty(message = "Productionmaterialstatus is required")
public String productionMaterialStatus;
@NotEmpty(message = "Productionmaterialupdatedat is required")
public String productionMaterialUpdatedAt;
}
