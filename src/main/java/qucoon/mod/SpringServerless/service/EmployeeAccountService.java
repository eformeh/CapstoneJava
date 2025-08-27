
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
import qucoon.mod.SpringServerless.repository.page.EmployeeAccountPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.EmployeeAccountDto;


@Service
public class EmployeeAccountService {

    private final EmployeeAccountRepository employeeaccountRepository;
    private  final Gson GSON;


    public EmployeeAccountService(EmployeeAccountRepository employeeaccountRepository) {
        this.employeeaccountRepository = employeeaccountRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(EmployeeAccountCreateRequest request) {

        EmployeeAccount employeeaccount = GSON.fromJson(GSON.toJson(request), EmployeeAccount.class);
        if (employeeaccount.getEmployeeAccountStatus() == null) {
            employeeaccount.setEmployeeAccountStatus("ACTIVE");
        }
        employeeaccountRepository.create(employeeaccount);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<EmployeeAccountCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            EmployeeAccount[] employeeaccountArray = GSON.fromJson(json, EmployeeAccount[].class);
            List<EmployeeAccount> employeeaccounts = Arrays.asList(employeeaccountArray);
            employeeaccountRepository.bulkCreate(employeeaccounts);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(EmployeeAccountUpdateRequest request) {
        EmployeeAccount employeeaccount = employeeaccountRepository.readByEmployeeAccountId(request.getEmployeeAccountId());
        if (employeeaccount == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        employeeaccountRepository.update(employeeaccount);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int employeeAccountId) {
        int updateResponse = employeeaccountRepository.delete(employeeAccountId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public EmployeeAccountReadListResponse read() {
        List<EmployeeAccount> employeeaccounts = employeeaccountRepository.read();
       if(employeeaccounts == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new EmployeeAccountReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), employeeaccounts);
    }
   public EmployeeAccountReadPagedResponse search(EmployeeAccountFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       EmployeeAccountPage page = employeeaccountRepository.findEmployeeAccount(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<EmployeeAccountDto> dtos = page.getData().stream()
            .map(EmployeeAccountDto::from)
            .collect(Collectors.toList());
    return new EmployeeAccountReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public EmployeeAccountReadListResponse readByEmployeeAccountBankName(String employeeaccountbankname) {
        List<EmployeeAccount> employeeaccounts = employeeaccountRepository.readByEmployeeAccountBankName(employeeaccountbankname);
        return new EmployeeAccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeaccounts);
    }
    public EmployeeAccountReadListResponse readByEmployeeAccountCreatedAt(String employeeaccountcreatedat) {
        List<EmployeeAccount> employeeaccounts = employeeaccountRepository.readByEmployeeAccountCreatedAt(employeeaccountcreatedat);
        return new EmployeeAccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeaccounts);
    }
    public EmployeeAccountReadListResponse readByEmployeeAccountEmployeeId(int employeeaccountemployeeid) {
        List<EmployeeAccount> employeeaccounts = employeeaccountRepository.readByEmployeeAccountEmployeeId(employeeaccountemployeeid);
        return new EmployeeAccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeaccounts);
    }
    public EmployeeAccountReadSingleResponse readByEmployeeAccountId(int employeeaccountid) {
        EmployeeAccount employeeaccount = employeeaccountRepository.readByEmployeeAccountId(employeeaccountid);
        if (employeeaccount == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new EmployeeAccountReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                employeeaccount);
    }
    public EmployeeAccountReadListResponse readByEmployeeAccountName(String employeeaccountname) {
        List<EmployeeAccount> employeeaccounts = employeeaccountRepository.readByEmployeeAccountName(employeeaccountname);
        return new EmployeeAccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeaccounts);
    }
    public EmployeeAccountReadListResponse readByEmployeeAccountNumber(String employeeaccountnumber) {
        List<EmployeeAccount> employeeaccounts = employeeaccountRepository.readByEmployeeAccountNumber(employeeaccountnumber);
        return new EmployeeAccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeaccounts);
    }
    public EmployeeAccountReadListResponse readByEmployeeAccountStatus(String employeeaccountstatus) {
        List<EmployeeAccount> employeeaccounts = employeeaccountRepository.readByEmployeeAccountStatus(employeeaccountstatus);
        return new EmployeeAccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeaccounts);
    }
    public EmployeeAccountReadListResponse readByEmployeeAccountUpdatedAt(String employeeaccountupdatedat) {
        List<EmployeeAccount> employeeaccounts = employeeaccountRepository.readByEmployeeAccountUpdatedAt(employeeaccountupdatedat);
        return new EmployeeAccountReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeaccounts);
    }
}
