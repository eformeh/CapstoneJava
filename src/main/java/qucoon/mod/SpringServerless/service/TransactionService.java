
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
import qucoon.mod.SpringServerless.repository.page.TransactionPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.TransactionDto;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private  final Gson GSON;


    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(TransactionCreateRequest request) {

        Transaction transaction = GSON.fromJson(GSON.toJson(request), Transaction.class);
        if (transaction.getTransactionStatus() == null) {
            transaction.setTransactionStatus("ACTIVE");
        }
        transactionRepository.create(transaction);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<TransactionCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Transaction[] transactionArray = GSON.fromJson(json, Transaction[].class);
            List<Transaction> transactions = Arrays.asList(transactionArray);
            transactionRepository.bulkCreate(transactions);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(TransactionUpdateRequest request) {
        Transaction transaction = transactionRepository.readByTransactionId(request.getTransactionId());
        if (transaction == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        transactionRepository.update(transaction);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int transactionId) {
        int updateResponse = transactionRepository.delete(transactionId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public TransactionReadListResponse read() {
        List<Transaction> transactions = transactionRepository.read();
       if(transactions == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new TransactionReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), transactions);
    }
   public TransactionReadPagedResponse search(TransactionFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       TransactionPage page = transactionRepository.findTransaction(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<TransactionDto> dtos = page.getData().stream()
            .map(TransactionDto::from)
            .collect(Collectors.toList());
    return new TransactionReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public TransactionReadListResponse readByTransactionAmount(Double transactionamount) {
        List<Transaction> transactions = transactionRepository.readByTransactionAmount(transactionamount);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
    public TransactionReadListResponse readByTransactionCreatedAt(String transactioncreatedat) {
        List<Transaction> transactions = transactionRepository.readByTransactionCreatedAt(transactioncreatedat);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
    public TransactionReadListResponse readByTransactionDescription(String transactiondescription) {
        List<Transaction> transactions = transactionRepository.readByTransactionDescription(transactiondescription);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
    public TransactionReadSingleResponse readByTransactionId(int transactionid) {
        Transaction transaction = transactionRepository.readByTransactionId(transactionid);
        if (transaction == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new TransactionReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                transaction);
    }
    public TransactionReadListResponse readByTransactionNarration(String transactionnarration) {
        List<Transaction> transactions = transactionRepository.readByTransactionNarration(transactionnarration);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
    public TransactionReadListResponse readByTransactionReferenceNumber(String transactionreferencenumber) {
        List<Transaction> transactions = transactionRepository.readByTransactionReferenceNumber(transactionreferencenumber);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
    public TransactionReadListResponse readByTransactionSourceModule(String transactionsourcemodule) {
        List<Transaction> transactions = transactionRepository.readByTransactionSourceModule(transactionsourcemodule);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
    public TransactionReadListResponse readByTransactionSourceReferenceId(int transactionsourcereferenceid) {
        List<Transaction> transactions = transactionRepository.readByTransactionSourceReferenceId(transactionsourcereferenceid);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
    public TransactionReadListResponse readByTransactionStatus(String transactionstatus) {
        List<Transaction> transactions = transactionRepository.readByTransactionStatus(transactionstatus);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
    public TransactionReadListResponse readByTransactionTransactionCategoryId(int transactiontransactioncategoryid) {
        List<Transaction> transactions = transactionRepository.readByTransactionTransactionCategoryId(transactiontransactioncategoryid);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
    public TransactionReadListResponse readByTransactionTransactionDate(String transactiontransactiondate) {
        List<Transaction> transactions = transactionRepository.readByTransactionTransactionDate(transactiontransactiondate);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
    public TransactionReadListResponse readByTransactionUpdatedAt(String transactionupdatedat) {
        List<Transaction> transactions = transactionRepository.readByTransactionUpdatedAt(transactionupdatedat);
        return new TransactionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        transactions);
    }
}
