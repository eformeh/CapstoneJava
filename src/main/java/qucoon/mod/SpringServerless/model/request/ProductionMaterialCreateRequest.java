package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class ProductionMaterialCreateRequest {
@NotNull(message = "productionMaterialInventoryItemId is required")
public int productionMaterialInventoryItemId;
@NotNull(message = "productionMaterialProductionRecordId is required")
public int productionMaterialProductionRecordId;
@NotNull(message = "productionMaterialQuantityConsumed is required")
public int productionMaterialQuantityConsumed;
}
