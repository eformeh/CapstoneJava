
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.ProductionMaterialPage;
import qucoon.mod.SpringServerless.model.request.ProductionMaterialFilterRequest;

import java.util.List;

@Repository
    public interface ProductionMaterialRepository {


    // Additional query methods can be defined here.
    int create(ProductionMaterial productionmaterial);
    void bulkCreate(List<ProductionMaterial>  productionmaterial);
    int update(ProductionMaterial  productionmaterial);
    int delete(int productionMaterialId);
    ProductionMaterialPage findProductionMaterial(ProductionMaterialFilterRequest filter);
    boolean truncate();
    List<ProductionMaterial> read();
    List<ProductionMaterial> readByProductionMaterialCreatedAt(String productionMaterialCreatedAt);
    ProductionMaterial readByProductionMaterialId(int productionMaterialId);
    List<ProductionMaterial> readByProductionMaterialInventoryItemId(int productionMaterialInventoryItemId);
    List<ProductionMaterial> readByProductionMaterialProductionRecordId(int productionMaterialProductionRecordId);
    List<ProductionMaterial> readByProductionMaterialQuantityConsumed(int productionMaterialQuantityConsumed);
    List<ProductionMaterial> readByProductionMaterialStatus(String productionMaterialStatus);
    List<ProductionMaterial> readByProductionMaterialUpdatedAt(String productionMaterialUpdatedAt);
}
