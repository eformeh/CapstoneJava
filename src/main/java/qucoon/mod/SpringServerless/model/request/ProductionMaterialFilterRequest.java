package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductionMaterialFilterRequest {

private String productionMaterialCreatedAt;
private Integer productionMaterialId;
private Integer productionMaterialInventoryItemId;
private Integer productionMaterialProductionRecordId;
private Integer productionMaterialQuantityConsumed;
private String productionMaterialStatus;
private String productionMaterialUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
