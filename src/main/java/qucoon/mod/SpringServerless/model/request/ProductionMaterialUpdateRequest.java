package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductionMaterialUpdateRequest {
public String productionMaterialCreatedAt;
public int productionMaterialId;
public int productionMaterialInventoryItemId;
public int productionMaterialProductionRecordId;
public int productionMaterialQuantityConsumed;
public String productionMaterialStatus;
public String productionMaterialUpdatedAt;
}
