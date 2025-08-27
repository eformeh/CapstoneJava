
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
import qucoon.mod.SpringServerless.repository.page.ProductionRecordPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.ProductionRecordDto;


@Service
public class ProductionRecordService {

    private final ProductionRecordRepository productionrecordRepository;
    private  final Gson GSON;


    public ProductionRecordService(ProductionRecordRepository productionrecordRepository) {
        this.productionrecordRepository = productionrecordRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(ProductionRecordCreateRequest request) {

        ProductionRecord productionrecord = GSON.fromJson(GSON.toJson(request), ProductionRecord.class);
        if (productionrecord.getProductionRecordStatus() == null) {
            productionrecord.setProductionRecordStatus("ACTIVE");
        }
        productionrecordRepository.create(productionrecord);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<ProductionRecordCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            ProductionRecord[] productionrecordArray = GSON.fromJson(json, ProductionRecord[].class);
            List<ProductionRecord> productionrecords = Arrays.asList(productionrecordArray);
            productionrecordRepository.bulkCreate(productionrecords);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(ProductionRecordUpdateRequest request) {
        ProductionRecord productionrecord = productionrecordRepository.readByProductionRecordId(request.getProductionRecordId());
        if (productionrecord == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        productionrecordRepository.update(productionrecord);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int productionRecordId) {
        int updateResponse = productionrecordRepository.delete(productionRecordId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public ProductionRecordReadListResponse read() {
        List<ProductionRecord> productionrecords = productionrecordRepository.read();
       if(productionrecords == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ProductionRecordReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), productionrecords);
    }
   public ProductionRecordReadPagedResponse search(ProductionRecordFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       ProductionRecordPage page = productionrecordRepository.findProductionRecord(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<ProductionRecordDto> dtos = page.getData().stream()
            .map(ProductionRecordDto::from)
            .collect(Collectors.toList());
    return new ProductionRecordReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public ProductionRecordReadListResponse readByProductionRecordBatchNumber(String productionrecordbatchnumber) {
        List<ProductionRecord> productionrecords = productionrecordRepository.readByProductionRecordBatchNumber(productionrecordbatchnumber);
        return new ProductionRecordReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionrecords);
    }
    public ProductionRecordReadListResponse readByProductionRecordCreatedAt(String productionrecordcreatedat) {
        List<ProductionRecord> productionrecords = productionrecordRepository.readByProductionRecordCreatedAt(productionrecordcreatedat);
        return new ProductionRecordReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionrecords);
    }
    public ProductionRecordReadListResponse readByProductionRecordCreatedByUserId(int productionrecordcreatedbyuserid) {
        List<ProductionRecord> productionrecords = productionrecordRepository.readByProductionRecordCreatedByUserId(productionrecordcreatedbyuserid);
        return new ProductionRecordReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionrecords);
    }
    public ProductionRecordReadListResponse readByProductionRecordDate(String productionrecorddate) {
        List<ProductionRecord> productionrecords = productionrecordRepository.readByProductionRecordDate(productionrecorddate);
        return new ProductionRecordReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionrecords);
    }
    public ProductionRecordReadListResponse readByProductionRecordFinishedGoodProductId(int productionrecordfinishedgoodproductid) {
        List<ProductionRecord> productionrecords = productionrecordRepository.readByProductionRecordFinishedGoodProductId(productionrecordfinishedgoodproductid);
        return new ProductionRecordReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionrecords);
    }
    public ProductionRecordReadSingleResponse readByProductionRecordId(int productionrecordid) {
        ProductionRecord productionrecord = productionrecordRepository.readByProductionRecordId(productionrecordid);
        if (productionrecord == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ProductionRecordReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                productionrecord);
    }
    public ProductionRecordReadListResponse readByProductionRecordStatus(String productionrecordstatus) {
        List<ProductionRecord> productionrecords = productionrecordRepository.readByProductionRecordStatus(productionrecordstatus);
        return new ProductionRecordReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionrecords);
    }
    public ProductionRecordReadListResponse readByProductionRecordUpdatedAt(String productionrecordupdatedat) {
        List<ProductionRecord> productionrecords = productionrecordRepository.readByProductionRecordUpdatedAt(productionrecordupdatedat);
        return new ProductionRecordReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionrecords);
    }
    public ProductionRecordReadListResponse readBySupplierPhoneNumber(String supplierphonenumber) {
        List<ProductionRecord> productionrecords = productionrecordRepository.readBySupplierPhoneNumber(supplierphonenumber);
        return new ProductionRecordReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        productionrecords);
    }
}
