
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
import qucoon.mod.SpringServerless.repository.page.AccountPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.AccountDto;


@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private  final Gson GSON;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(AccountCreateRequest request) {

        Account account = GSON.fromJson(GSON.toJson(request), Account.class);
        if (account.getAccountStatus() == null) {
            account.setAccountStatus("ACTIVE");
        }
        accountRepository.create(account);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<AccountCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Account[] accountArray = GSON.fromJson(json, Account[].class);
            List<Account> accounts = Arrays.asList(accountArray);
            accountRepository.bulkCreate(accounts);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(AccountUpdateRequest request) {
        Account account = accountRepository.readByAccountId(request.getAccountId());
        if (account == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        accountRepository.update(account);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int accountId) {
        int updateResponse = accountRepository.delete(accountId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public AccountReadListResponse read() {
        List<Account> accounts = accountRepository.read();
       if(accounts == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AccountReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), accounts);
    }
   public AccountReadPagedResponse search(AccountFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       AccountPage page = accountRepository.findAccount(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<AccountDto> dtos = page.getData().stream()
            .map(AccountDto::from)
            .collect(Collectors.toList());
    return new AccountReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public AccountReadListResponse readByAccountAccountName(String accountaccountname) {
        List<Account> accounts = accountRepository.readByAccountAccountName(accountaccountname);
        return new AccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounts);
    }
    public AccountReadListResponse readByAccountAccountTypeId(int accountaccounttypeid) {
        List<Account> accounts = accountRepository.readByAccountAccountTypeId(accountaccounttypeid);
        return new AccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounts);
    }
    public AccountReadListResponse readByAccountCreatedAt(String accountcreatedat) {
        List<Account> accounts = accountRepository.readByAccountCreatedAt(accountcreatedat);
        return new AccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounts);
    }
    public AccountReadListResponse readByAccountDescription(String accountdescription) {
        List<Account> accounts = accountRepository.readByAccountDescription(accountdescription);
        return new AccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounts);
    }
    public AccountReadSingleResponse readByAccountId(int accountid) {
        Account account = accountRepository.readByAccountId(accountid);
        if (account == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AccountReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                account);
    }
    public AccountReadListResponse readByAccountStatus(String accountstatus) {
        List<Account> accounts = accountRepository.readByAccountStatus(accountstatus);
        return new AccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounts);
    }
    public AccountReadListResponse readByAccountUpdatedAt(String accountupdatedat) {
        List<Account> accounts = accountRepository.readByAccountUpdatedAt(accountupdatedat);
        return new AccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        accounts);
    }
}
