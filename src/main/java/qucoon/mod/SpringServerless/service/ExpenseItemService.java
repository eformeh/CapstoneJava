
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
import qucoon.mod.SpringServerless.repository.page.ExpenseItemPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.ExpenseItemDto;


@Service
public class ExpenseItemService {

    private final ExpenseItemRepository expenseitemRepository;
    private  final Gson GSON;


    public ExpenseItemService(ExpenseItemRepository expenseitemRepository) {
        this.expenseitemRepository = expenseitemRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(ExpenseItemCreateRequest request) {

        ExpenseItem expenseitem = GSON.fromJson(GSON.toJson(request), ExpenseItem.class);
        if (expenseitem.getExpenseItemStatus() == null) {
            expenseitem.setExpenseItemStatus("ACTIVE");
        }
        expenseitemRepository.create(expenseitem);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<ExpenseItemCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            ExpenseItem[] expenseitemArray = GSON.fromJson(json, ExpenseItem[].class);
            List<ExpenseItem> expenseitems = Arrays.asList(expenseitemArray);
            expenseitemRepository.bulkCreate(expenseitems);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(ExpenseItemUpdateRequest request) {
        ExpenseItem expenseitem = expenseitemRepository.readByExpenseItemId(request.getExpenseItemId());
        if (expenseitem == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        expenseitemRepository.update(expenseitem);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int expenseItemId) {
        int updateResponse = expenseitemRepository.delete(expenseItemId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public ExpenseItemReadListResponse read() {
        List<ExpenseItem> expenseitems = expenseitemRepository.read();
       if(expenseitems == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ExpenseItemReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), expenseitems);
    }
   public ExpenseItemReadPagedResponse search(ExpenseItemFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       ExpenseItemPage page = expenseitemRepository.findExpenseItem(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<ExpenseItemDto> dtos = page.getData().stream()
            .map(ExpenseItemDto::from)
            .collect(Collectors.toList());
    return new ExpenseItemReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public ExpenseItemReadListResponse readByExpenseItemAmount(Double expenseitemamount) {
        List<ExpenseItem> expenseitems = expenseitemRepository.readByExpenseItemAmount(expenseitemamount);
        return new ExpenseItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseitems);
    }
    public ExpenseItemReadListResponse readByExpenseItemCategory(String expenseitemcategory) {
        List<ExpenseItem> expenseitems = expenseitemRepository.readByExpenseItemCategory(expenseitemcategory);
        return new ExpenseItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseitems);
    }
    public ExpenseItemReadListResponse readByExpenseItemClaimId(int expenseitemclaimid) {
        List<ExpenseItem> expenseitems = expenseitemRepository.readByExpenseItemClaimId(expenseitemclaimid);
        return new ExpenseItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseitems);
    }
    public ExpenseItemReadListResponse readByExpenseItemCreatedAt(String expenseitemcreatedat) {
        List<ExpenseItem> expenseitems = expenseitemRepository.readByExpenseItemCreatedAt(expenseitemcreatedat);
        return new ExpenseItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseitems);
    }
    public ExpenseItemReadListResponse readByExpenseItemDescription(String expenseitemdescription) {
        List<ExpenseItem> expenseitems = expenseitemRepository.readByExpenseItemDescription(expenseitemdescription);
        return new ExpenseItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseitems);
    }
    public ExpenseItemReadSingleResponse readByExpenseItemId(int expenseitemid) {
        ExpenseItem expenseitem = expenseitemRepository.readByExpenseItemId(expenseitemid);
        if (expenseitem == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ExpenseItemReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                expenseitem);
    }
    public ExpenseItemReadListResponse readByExpenseItemReceiptUrl(String expenseitemreceipturl) {
        List<ExpenseItem> expenseitems = expenseitemRepository.readByExpenseItemReceiptUrl(expenseitemreceipturl);
        return new ExpenseItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseitems);
    }
    public ExpenseItemReadListResponse readByExpenseItemStatus(String expenseitemstatus) {
        List<ExpenseItem> expenseitems = expenseitemRepository.readByExpenseItemStatus(expenseitemstatus);
        return new ExpenseItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseitems);
    }
    public ExpenseItemReadListResponse readByExpenseItemUpdatedAt(String expenseitemupdatedat) {
        List<ExpenseItem> expenseitems = expenseitemRepository.readByExpenseItemUpdatedAt(expenseitemupdatedat);
        return new ExpenseItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        expenseitems);
    }
}
