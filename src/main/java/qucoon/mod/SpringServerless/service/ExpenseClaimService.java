
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
import qucoon.mod.SpringServerless.repository.page.ExpenseClaimPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.ExpenseClaimDto;


@Service
public class ExpenseClaimService {

    private final ExpenseClaimRepository expenseclaimRepository;
    private  final Gson GSON;


    public ExpenseClaimService(ExpenseClaimRepository expenseclaimRepository) {
        this.expenseclaimRepository = expenseclaimRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(ExpenseClaimCreateRequest request) {

        ExpenseClaim expenseclaim = GSON.fromJson(GSON.toJson(request), ExpenseClaim.class);
        if (expenseclaim.getExpenseClaimStatus() == null) {
            expenseclaim.setExpenseClaimStatus("ACTIVE");
        }
        expenseclaimRepository.create(expenseclaim);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<ExpenseClaimCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            ExpenseClaim[] expenseclaimArray = GSON.fromJson(json, ExpenseClaim[].class);
            List<ExpenseClaim> expenseclaims = Arrays.asList(expenseclaimArray);
            expenseclaimRepository.bulkCreate(expenseclaims);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(ExpenseClaimUpdateRequest request) {
        ExpenseClaim expenseclaim = expenseclaimRepository.readByExpenseClaimId(request.getExpenseClaimId());
        if (expenseclaim == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        expenseclaimRepository.update(expenseclaim);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int expenseClaimId) {
        int updateResponse = expenseclaimRepository.delete(expenseClaimId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public ExpenseClaimReadListResponse read() {
        List<ExpenseClaim> expenseclaims = expenseclaimRepository.read();
       if(expenseclaims == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ExpenseClaimReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), expenseclaims);
    }
   public ExpenseClaimReadPagedResponse search(ExpenseClaimFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       ExpenseClaimPage page = expenseclaimRepository.findExpenseClaim(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<ExpenseClaimDto> dtos = page.getData().stream()
            .map(ExpenseClaimDto::from)
            .collect(Collectors.toList());
    return new ExpenseClaimReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public ExpenseClaimReadListResponse readByExpenseClaimCreatedAt(String expenseclaimcreatedat) {
        List<ExpenseClaim> expenseclaims = expenseclaimRepository.readByExpenseClaimCreatedAt(expenseclaimcreatedat);
        return new ExpenseClaimReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseclaims);
    }
    public ExpenseClaimReadListResponse readByExpenseClaimDecisionDate(String expenseclaimdecisiondate) {
        List<ExpenseClaim> expenseclaims = expenseclaimRepository.readByExpenseClaimDecisionDate(expenseclaimdecisiondate);
        return new ExpenseClaimReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseclaims);
    }
    public ExpenseClaimReadListResponse readByExpenseClaimEmployeeId(int expenseclaimemployeeid) {
        List<ExpenseClaim> expenseclaims = expenseclaimRepository.readByExpenseClaimEmployeeId(expenseclaimemployeeid);
        return new ExpenseClaimReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseclaims);
    }
    public ExpenseClaimReadSingleResponse readByExpenseClaimId(int expenseclaimid) {
        ExpenseClaim expenseclaim = expenseclaimRepository.readByExpenseClaimId(expenseclaimid);
        if (expenseclaim == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ExpenseClaimReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                expenseclaim);
    }
    public ExpenseClaimReadListResponse readByExpenseClaimReimbursementDate(String expenseclaimreimbursementdate) {
        List<ExpenseClaim> expenseclaims = expenseclaimRepository.readByExpenseClaimReimbursementDate(expenseclaimreimbursementdate);
        return new ExpenseClaimReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseclaims);
    }
    public ExpenseClaimReadListResponse readByExpenseClaimReviewerId(int expenseclaimreviewerid) {
        List<ExpenseClaim> expenseclaims = expenseclaimRepository.readByExpenseClaimReviewerId(expenseclaimreviewerid);
        return new ExpenseClaimReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseclaims);
    }
    public ExpenseClaimReadListResponse readByExpenseClaimStatus(String expenseclaimstatus) {
        List<ExpenseClaim> expenseclaims = expenseclaimRepository.readByExpenseClaimStatus(expenseclaimstatus);
        return new ExpenseClaimReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseclaims);
    }
    public ExpenseClaimReadListResponse readByExpenseClaimTotalAmount(Double expenseclaimtotalamount) {
        List<ExpenseClaim> expenseclaims = expenseclaimRepository.readByExpenseClaimTotalAmount(expenseclaimtotalamount);
        return new ExpenseClaimReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseclaims);
    }
    public ExpenseClaimReadListResponse readByExpenseClaimUpdatedAt(String expenseclaimupdatedat) {
        List<ExpenseClaim> expenseclaims = expenseclaimRepository.readByExpenseClaimUpdatedAt(expenseclaimupdatedat);
        return new ExpenseClaimReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseclaims);
    }
}
