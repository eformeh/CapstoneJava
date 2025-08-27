
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
import qucoon.mod.SpringServerless.repository.page.AccountTypePage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.AccountTypeDto;


@Service
public class AccountTypeService {

    private final AccountTypeRepository accounttypeRepository;
    private  final Gson GSON;


    public AccountTypeService(AccountTypeRepository accounttypeRepository) {
        this.accounttypeRepository = accounttypeRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(AccountTypeCreateRequest request) {

        AccountType accounttype = GSON.fromJson(GSON.toJson(request), AccountType.class);
        if (accounttype.getAccountTypeStatus() == null) {
            accounttype.setAccountTypeStatus("ACTIVE");
        }
        accounttypeRepository.create(accounttype);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<AccountTypeCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            AccountType[] accounttypeArray = GSON.fromJson(json, AccountType[].class);
            List<AccountType> accounttypes = Arrays.asList(accounttypeArray);
            accounttypeRepository.bulkCreate(accounttypes);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(AccountTypeUpdateRequest request) {
        AccountType accounttype = accounttypeRepository.readByAccountTypeId(request.getAccountTypeId());
        if (accounttype == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        accounttypeRepository.update(accounttype);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int accountTypeId) {
        int updateResponse = accounttypeRepository.delete(accountTypeId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public AccountTypeReadListResponse read() {
        List<AccountType> accounttypes = accounttypeRepository.read();
       if(accounttypes == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AccountTypeReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), accounttypes);
    }
   public AccountTypeReadPagedResponse search(AccountTypeFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       AccountTypePage page = accounttypeRepository.findAccountType(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<AccountTypeDto> dtos = page.getData().stream()
            .map(AccountTypeDto::from)
            .collect(Collectors.toList());
    return new AccountTypeReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public AccountTypeReadListResponse readByAccountTypeAccountTypeName(String accounttypeaccounttypename) {
        List<AccountType> accounttypes = accounttypeRepository.readByAccountTypeAccountTypeName(accounttypeaccounttypename);
        return new AccountTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounttypes);
    }
    public AccountTypeReadListResponse readByAccountTypeCreatedAt(String accounttypecreatedat) {
        List<AccountType> accounttypes = accounttypeRepository.readByAccountTypeCreatedAt(accounttypecreatedat);
        return new AccountTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounttypes);
    }
    public AccountTypeReadListResponse readByAccountTypeDescription(String accounttypedescription) {
        List<AccountType> accounttypes = accounttypeRepository.readByAccountTypeDescription(accounttypedescription);
        return new AccountTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounttypes);
    }
    public AccountTypeReadSingleResponse readByAccountTypeId(int accounttypeid) {
        AccountType accounttype = accounttypeRepository.readByAccountTypeId(accounttypeid);
        if (accounttype == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AccountTypeReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                accounttype);
    }
    public AccountTypeReadListResponse readByAccountTypeNormalBalance(String accounttypenormalbalance) {
        List<AccountType> accounttypes = accounttypeRepository.readByAccountTypeNormalBalance(accounttypenormalbalance);
        return new AccountTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounttypes);
    }
    public AccountTypeReadListResponse readByAccountTypeStatus(String accounttypestatus) {
        List<AccountType> accounttypes = accounttypeRepository.readByAccountTypeStatus(accounttypestatus);
        return new AccountTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounttypes);
    }
    public AccountTypeReadListResponse readByAccountTypeUpdatedAt(String accounttypeupdatedat) {
        List<AccountType> accounttypes = accounttypeRepository.readByAccountTypeUpdatedAt(accounttypeupdatedat);
        return new AccountTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounttypes);
    }
}
