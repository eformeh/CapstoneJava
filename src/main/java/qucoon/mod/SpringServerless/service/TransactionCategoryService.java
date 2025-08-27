
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
import qucoon.mod.SpringServerless.repository.page.TransactionCategoryPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.TransactionCategoryDto;


@Service
public class TransactionCategoryService {

    private final TransactionCategoryRepository transactioncategoryRepository;
    private  final Gson GSON;


    public TransactionCategoryService(TransactionCategoryRepository transactioncategoryRepository) {
        this.transactioncategoryRepository = transactioncategoryRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(TransactionCategoryCreateRequest request) {

        TransactionCategory transactioncategory = GSON.fromJson(GSON.toJson(request), TransactionCategory.class);
        if (transactioncategory.getTransactionCategoryStatus() == null) {
            transactioncategory.setTransactionCategoryStatus("ACTIVE");
        }
        transactioncategoryRepository.create(transactioncategory);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<TransactionCategoryCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            TransactionCategory[] transactioncategoryArray = GSON.fromJson(json, TransactionCategory[].class);
            List<TransactionCategory> transactioncategorys = Arrays.asList(transactioncategoryArray);
            transactioncategoryRepository.bulkCreate(transactioncategorys);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(TransactionCategoryUpdateRequest request) {
        TransactionCategory transactioncategory = transactioncategoryRepository.readByTransactionCategoryId(request.getTransactionCategoryId());
        if (transactioncategory == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        transactioncategoryRepository.update(transactioncategory);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int transactionCategoryId) {
        int updateResponse = transactioncategoryRepository.delete(transactionCategoryId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public TransactionCategoryReadListResponse read() {
        List<TransactionCategory> transactioncategorys = transactioncategoryRepository.read();
       if(transactioncategorys == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new TransactionCategoryReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), transactioncategorys);
    }
   public TransactionCategoryReadPagedResponse search(TransactionCategoryFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       TransactionCategoryPage page = transactioncategoryRepository.findTransactionCategory(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<TransactionCategoryDto> dtos = page.getData().stream()
            .map(TransactionCategoryDto::from)
            .collect(Collectors.toList());
    return new TransactionCategoryReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public TransactionCategoryReadListResponse readByTransactionCategoryCreatedAt(String transactioncategorycreatedat) {
        List<TransactionCategory> transactioncategorys = transactioncategoryRepository.readByTransactionCategoryCreatedAt(transactioncategorycreatedat);
        return new TransactionCategoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactioncategorys);
    }
    public TransactionCategoryReadListResponse readByTransactionCategoryDescription(String transactioncategorydescription) {
        List<TransactionCategory> transactioncategorys = transactioncategoryRepository.readByTransactionCategoryDescription(transactioncategorydescription);
        return new TransactionCategoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactioncategorys);
    }
    public TransactionCategoryReadSingleResponse readByTransactionCategoryId(int transactioncategoryid) {
        TransactionCategory transactioncategory = transactioncategoryRepository.readByTransactionCategoryId(transactioncategoryid);
        if (transactioncategory == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new TransactionCategoryReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                transactioncategory);
    }
    public TransactionCategoryReadListResponse readByTransactionCategoryName(String transactioncategoryname) {
        List<TransactionCategory> transactioncategorys = transactioncategoryRepository.readByTransactionCategoryName(transactioncategoryname);
        return new TransactionCategoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactioncategorys);
    }
    public TransactionCategoryReadListResponse readByTransactionCategoryStatus(String transactioncategorystatus) {
        List<TransactionCategory> transactioncategorys = transactioncategoryRepository.readByTransactionCategoryStatus(transactioncategorystatus);
        return new TransactionCategoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactioncategorys);
    }
    public TransactionCategoryReadListResponse readByTransactionCategoryTransactionNature(String transactioncategorytransactionnature) {
        List<TransactionCategory> transactioncategorys = transactioncategoryRepository.readByTransactionCategoryTransactionNature(transactioncategorytransactionnature);
        return new TransactionCategoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactioncategorys);
    }
    public TransactionCategoryReadListResponse readByTransactionCategoryUpdatedAt(String transactioncategoryupdatedat) {
        List<TransactionCategory> transactioncategorys = transactioncategoryRepository.readByTransactionCategoryUpdatedAt(transactioncategoryupdatedat);
        return new TransactionCategoryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactioncategorys);
    }
}
