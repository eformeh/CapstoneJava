
package   qucoon.mod.SpringServerless.service;


import qucoon.mod.SpringServerless.utility.exception.CustomExceptions;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;
import qucoon.mod.SpringServerless.model.entity.User;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.model.response.*;
import qucoon.mod.SpringServerless.utility.LocalDateTimeTypeAdapter;
import qucoon.mod.SpringServerless.repository.*;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.ProductionMaterialPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.ProductionMaterialDto;


@Service
public class ProductionMaterialService {

    private final ProductionMaterialRepository productionmaterialRepository;
    private  final Gson GSON;


    public ProductionMaterialService(ProductionMaterialRepository productionmaterialRepository) {
        this.productionmaterialRepository = productionmaterialRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(ProductionMaterialCreateRequest request) {

        ProductionMaterial productionmaterial = GSON.fromJson(GSON.toJson(request), ProductionMaterial.class);
        if (productionmaterial.getProductionMaterialStatus() == null) {
            productionmaterial.setProductionMaterialStatus("ACTIVE");
        }
        productionmaterialRepository.create(productionmaterial);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<ProductionMaterialCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            ProductionMaterial[] productionmaterialArray = GSON.fromJson(json, ProductionMaterial[].class);
            List<ProductionMaterial> productionmaterials = Arrays.asList(productionmaterialArray);
            productionmaterialRepository.bulkCreate(productionmaterials);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(ProductionMaterialUpdateRequest request) {
        ProductionMaterial productionmaterial = productionmaterialRepository.readByProductionMaterialId(request.getProductionMaterialId());
        if (productionmaterial == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        productionmaterialRepository.update(productionmaterial);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int productionMaterialId) {
        int updateResponse = productionmaterialRepository.delete(productionMaterialId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public ProductionMaterialReadListResponse read() {
        List<ProductionMaterial> productionmaterials = productionmaterialRepository.read();
       if(productionmaterials == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ProductionMaterialReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), productionmaterials);
    }
   public ProductionMaterialReadPagedResponse search(ProductionMaterialFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       ProductionMaterialPage page = productionmaterialRepository.findProductionMaterial(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<ProductionMaterialDto> dtos = page.getData().stream()
            .map(ProductionMaterialDto::from)
            .collect(Collectors.toList());
    return new ProductionMaterialReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public ProductionMaterialReadListResponse readByProductionMaterialCreatedAt(String productionmaterialcreatedat) {
        List<ProductionMaterial> productionmaterials = productionmaterialRepository.readByProductionMaterialCreatedAt(productionmaterialcreatedat);
        return new ProductionMaterialReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionmaterials);
    }
    public ProductionMaterialReadSingleResponse readByProductionMaterialId(int productionmaterialid) {
        ProductionMaterial productionmaterial = productionmaterialRepository.readByProductionMaterialId(productionmaterialid);
        if (productionmaterial == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ProductionMaterialReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                productionmaterial);
    }
    public ProductionMaterialReadListResponse readByProductionMaterialInventoryItemId(int productionmaterialinventoryitemid) {
        List<ProductionMaterial> productionmaterials = productionmaterialRepository.readByProductionMaterialInventoryItemId(productionmaterialinventoryitemid);
        return new ProductionMaterialReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionmaterials);
    }
    public ProductionMaterialReadListResponse readByProductionMaterialProductionRecordId(int productionmaterialproductionrecordid) {
        List<ProductionMaterial> productionmaterials = productionmaterialRepository.readByProductionMaterialProductionRecordId(productionmaterialproductionrecordid);
        return new ProductionMaterialReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionmaterials);
    }
    public ProductionMaterialReadListResponse readByProductionMaterialQuantityConsumed(int productionmaterialquantityconsumed) {
        List<ProductionMaterial> productionmaterials = productionmaterialRepository.readByProductionMaterialQuantityConsumed(productionmaterialquantityconsumed);
        return new ProductionMaterialReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionmaterials);
    }
    public ProductionMaterialReadListResponse readByProductionMaterialStatus(String productionmaterialstatus) {
        List<ProductionMaterial> productionmaterials = productionmaterialRepository.readByProductionMaterialStatus(productionmaterialstatus);
        return new ProductionMaterialReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionmaterials);
    }
    public ProductionMaterialReadListResponse readByProductionMaterialUpdatedAt(String productionmaterialupdatedat) {
        List<ProductionMaterial> productionmaterials = productionmaterialRepository.readByProductionMaterialUpdatedAt(productionmaterialupdatedat);
        return new ProductionMaterialReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionmaterials);
    }
}
