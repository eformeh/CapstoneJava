
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
import qucoon.mod.SpringServerless.repository.page.LedgerPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.LedgerDto;


@Service
public class LedgerService {

    private final LedgerRepository ledgerRepository;
    private  final Gson GSON;


    public LedgerService(LedgerRepository ledgerRepository) {
        this.ledgerRepository = ledgerRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(LedgerCreateRequest request) {

        Ledger ledger = GSON.fromJson(GSON.toJson(request), Ledger.class);
        if (ledger.getLedgerStatus() == null) {
            ledger.setLedgerStatus("ACTIVE");
        }
        ledgerRepository.create(ledger);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<LedgerCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Ledger[] ledgerArray = GSON.fromJson(json, Ledger[].class);
            List<Ledger> ledgers = Arrays.asList(ledgerArray);
            ledgerRepository.bulkCreate(ledgers);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(LedgerUpdateRequest request) {
        Ledger ledger = ledgerRepository.readByLedgerId(request.getLedgerId());
        if (ledger == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        ledgerRepository.update(ledger);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int ledgerId) {
        int updateResponse = ledgerRepository.delete(ledgerId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public LedgerReadListResponse read() {
        List<Ledger> ledgers = ledgerRepository.read();
       if(ledgers == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LedgerReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), ledgers);
    }
   public LedgerReadPagedResponse search(LedgerFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       LedgerPage page = ledgerRepository.findLedger(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<LedgerDto> dtos = page.getData().stream()
            .map(LedgerDto::from)
            .collect(Collectors.toList());
    return new LedgerReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public LedgerReadListResponse readByLedgerAccountId(int ledgeraccountid) {
        List<Ledger> ledgers = ledgerRepository.readByLedgerAccountId(ledgeraccountid);
        return new LedgerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        ledgers);
    }
    public LedgerReadListResponse readByLedgerBalanceAfter(Double ledgerbalanceafter) {
        List<Ledger> ledgers = ledgerRepository.readByLedgerBalanceAfter(ledgerbalanceafter);
        return new LedgerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        ledgers);
    }
    public LedgerReadListResponse readByLedgerCreatedAt(String ledgercreatedat) {
        List<Ledger> ledgers = ledgerRepository.readByLedgerCreatedAt(ledgercreatedat);
        return new LedgerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        ledgers);
    }
    public LedgerReadListResponse readByLedgerCredit(Double ledgercredit) {
        List<Ledger> ledgers = ledgerRepository.readByLedgerCredit(ledgercredit);
        return new LedgerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        ledgers);
    }
    public LedgerReadListResponse readByLedgerDebit(Double ledgerdebit) {
        List<Ledger> ledgers = ledgerRepository.readByLedgerDebit(ledgerdebit);
        return new LedgerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        ledgers);
    }
    public LedgerReadSingleResponse readByLedgerId(int ledgerid) {
        Ledger ledger = ledgerRepository.readByLedgerId(ledgerid);
        if (ledger == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LedgerReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                ledger);
    }
    public LedgerReadListResponse readByLedgerjournalEntryLineAccountId(int ledgerjournalentrylineaccountid) {
        List<Ledger> ledgers = ledgerRepository.readByLedgerjournalEntryLineAccountId(ledgerjournalentrylineaccountid);
        return new LedgerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        ledgers);
    }
    public LedgerReadListResponse readByLedgerStatus(String ledgerstatus) {
        List<Ledger> ledgers = ledgerRepository.readByLedgerStatus(ledgerstatus);
        return new LedgerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        ledgers);
    }
    public LedgerReadListResponse readByLedgerUpdatedAt(String ledgerupdatedat) {
        List<Ledger> ledgers = ledgerRepository.readByLedgerUpdatedAt(ledgerupdatedat);
        return new LedgerReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        ledgers);
    }
}
