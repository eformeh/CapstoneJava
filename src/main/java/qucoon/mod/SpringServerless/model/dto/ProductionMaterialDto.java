package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.ProductionMaterial;


@Data
public class ProductionMaterialDto  {

private String productionMaterialCreatedAt;
private Integer productionMaterialId;
private Integer productionMaterialInventoryItemId;
private Integer productionMaterialProductionRecordId;
private Integer productionMaterialQuantityConsumed;
private String productionMaterialStatus;
private String productionMaterialUpdatedAt;

public static ProductionMaterialDto from(ProductionMaterial p) {
    ProductionMaterialDto dto = new ProductionMaterialDto();

    dto.setProductionMaterialCreatedAt(p.getProductionMaterialCreatedAt());
    dto.setProductionMaterialId(p.getProductionMaterialId());
    dto.setProductionMaterialInventoryItemId(p.getProductionMaterialInventoryItemId());
    dto.setProductionMaterialProductionRecordId(p.getProductionMaterialProductionRecordId());
    dto.setProductionMaterialQuantityConsumed(p.getProductionMaterialQuantityConsumed());
    dto.setProductionMaterialStatus(p.getProductionMaterialStatus());
    dto.setProductionMaterialUpdatedAt(p.getProductionMaterialUpdatedAt());
    return dto;
   }
}
