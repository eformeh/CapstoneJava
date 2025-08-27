
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
import qucoon.mod.SpringServerless.repository.page.AccountMappingPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.AccountMappingDto;


@Service
public class AccountMappingService {

    private final AccountMappingRepository accountmappingRepository;
    private  final Gson GSON;


    public AccountMappingService(AccountMappingRepository accountmappingRepository) {
        this.accountmappingRepository = accountmappingRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(AccountMappingCreateRequest request) {

        AccountMapping accountmapping = GSON.fromJson(GSON.toJson(request), AccountMapping.class);
        if (accountmapping.getAccountMappingStatus() == null) {
            accountmapping.setAccountMappingStatus("ACTIVE");
        }
        accountmappingRepository.create(accountmapping);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<AccountMappingCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            AccountMapping[] accountmappingArray = GSON.fromJson(json, AccountMapping[].class);
            List<AccountMapping> accountmappings = Arrays.asList(accountmappingArray);
            accountmappingRepository.bulkCreate(accountmappings);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(AccountMappingUpdateRequest request) {
        AccountMapping accountmapping = accountmappingRepository.readByAccountMappingId(request.getAccountMappingId());
        if (accountmapping == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        accountmappingRepository.update(accountmapping);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int accountMappingId) {
        int updateResponse = accountmappingRepository.delete(accountMappingId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public AccountMappingReadListResponse read() {
        List<AccountMapping> accountmappings = accountmappingRepository.read();
       if(accountmappings == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AccountMappingReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), accountmappings);
    }
   public AccountMappingReadPagedResponse search(AccountMappingFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       AccountMappingPage page = accountmappingRepository.findAccountMapping(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<AccountMappingDto> dtos = page.getData().stream()
            .map(AccountMappingDto::from)
            .collect(Collectors.toList());
    return new AccountMappingReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public AccountMappingReadListResponse readByAccountMappingCrAccountId(int accountmappingcraccountid) {
        List<AccountMapping> accountmappings = accountmappingRepository.readByAccountMappingCrAccountId(accountmappingcraccountid);
        return new AccountMappingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accountmappings);
    }
    public AccountMappingReadListResponse readByAccountMappingCreatedAt(String accountmappingcreatedat) {
        List<AccountMapping> accountmappings = accountmappingRepository.readByAccountMappingCreatedAt(accountmappingcreatedat);
        return new AccountMappingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accountmappings);
    }
    public AccountMappingReadListResponse readByAccountMappingDescription(String accountmappingdescription) {
        List<AccountMapping> accountmappings = accountmappingRepository.readByAccountMappingDescription(accountmappingdescription);
        return new AccountMappingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accountmappings);
    }
    public AccountMappingReadListResponse readByAccountMappingDrAccountId(int accountmappingdraccountid) {
        List<AccountMapping> accountmappings = accountmappingRepository.readByAccountMappingDrAccountId(accountmappingdraccountid);
        return new AccountMappingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accountmappings);
    }
    public AccountMappingReadSingleResponse readByAccountMappingId(int accountmappingid) {
        AccountMapping accountmapping = accountmappingRepository.readByAccountMappingId(accountmappingid);
        if (accountmapping == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AccountMappingReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                accountmapping);
    }
    public AccountMappingReadListResponse readByAccountMappingStatus(String accountmappingstatus) {
        List<AccountMapping> accountmappings = accountmappingRepository.readByAccountMappingStatus(accountmappingstatus);
        return new AccountMappingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accountmappings);
    }
    public AccountMappingReadListResponse readByAccountMappingTransactionCategoryId(int accountmappingtransactioncategoryid) {
        List<AccountMapping> accountmappings = accountmappingRepository.readByAccountMappingTransactionCategoryId(accountmappingtransactioncategoryid);
        return new AccountMappingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accountmappings);
    }
    public AccountMappingReadListResponse readByAccountMappingUpdatedAt(String accountmappingupdatedat) {
        List<AccountMapping> accountmappings = accountmappingRepository.readByAccountMappingUpdatedAt(accountmappingupdatedat);
        return new AccountMappingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accountmappings);
    }
}
