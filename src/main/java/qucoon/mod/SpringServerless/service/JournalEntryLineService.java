
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
import qucoon.mod.SpringServerless.repository.page.JournalEntryLinePage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.JournalEntryLineDto;


@Service
public class JournalEntryLineService {

    private final JournalEntryLineRepository journalentrylineRepository;
    private  final Gson GSON;


    public JournalEntryLineService(JournalEntryLineRepository journalentrylineRepository) {
        this.journalentrylineRepository = journalentrylineRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(JournalEntryLineCreateRequest request) {

        JournalEntryLine journalentryline = GSON.fromJson(GSON.toJson(request), JournalEntryLine.class);
        if (journalentryline.getJournalEntryLineStatus() == null) {
            journalentryline.setJournalEntryLineStatus("ACTIVE");
        }
        journalentrylineRepository.create(journalentryline);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<JournalEntryLineCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            JournalEntryLine[] journalentrylineArray = GSON.fromJson(json, JournalEntryLine[].class);
            List<JournalEntryLine> journalentrylines = Arrays.asList(journalentrylineArray);
            journalentrylineRepository.bulkCreate(journalentrylines);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(JournalEntryLineUpdateRequest request) {
        JournalEntryLine journalentryline = journalentrylineRepository.readByJournalEntryLineId(request.getJournalEntryLineId());
        if (journalentryline == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        journalentrylineRepository.update(journalentryline);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int journalEntryLineId) {
        int updateResponse = journalentrylineRepository.delete(journalEntryLineId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public JournalEntryLineReadListResponse read() {
        List<JournalEntryLine> journalentrylines = journalentrylineRepository.read();
       if(journalentrylines == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new JournalEntryLineReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), journalentrylines);
    }
   public JournalEntryLineReadPagedResponse search(JournalEntryLineFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       JournalEntryLinePage page = journalentrylineRepository.findJournalEntryLine(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<JournalEntryLineDto> dtos = page.getData().stream()
            .map(JournalEntryLineDto::from)
            .collect(Collectors.toList());
    return new JournalEntryLineReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public JournalEntryLineReadListResponse readByJournalEntryLineAccountId(int journalentrylineaccountid) {
        List<JournalEntryLine> journalentrylines = journalentrylineRepository.readByJournalEntryLineAccountId(journalentrylineaccountid);
        return new JournalEntryLineReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        journalentrylines);
    }
    public JournalEntryLineReadListResponse readByJournalEntryLineAmount(Double journalentrylineamount) {
        List<JournalEntryLine> journalentrylines = journalentrylineRepository.readByJournalEntryLineAmount(journalentrylineamount);
        return new JournalEntryLineReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        journalentrylines);
    }
    public JournalEntryLineReadListResponse readByJournalEntryLineCreatedAt(String journalentrylinecreatedat) {
        List<JournalEntryLine> journalentrylines = journalentrylineRepository.readByJournalEntryLineCreatedAt(journalentrylinecreatedat);
        return new JournalEntryLineReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        journalentrylines);
    }
    public JournalEntryLineReadListResponse readByJournalEntryLineEntryType(String journalentrylineentrytype) {
        List<JournalEntryLine> journalentrylines = journalentrylineRepository.readByJournalEntryLineEntryType(journalentrylineentrytype);
        return new JournalEntryLineReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        journalentrylines);
    }
    public JournalEntryLineReadSingleResponse readByJournalEntryLineId(int journalentrylineid) {
        JournalEntryLine journalentryline = journalentrylineRepository.readByJournalEntryLineId(journalentrylineid);
        if (journalentryline == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new JournalEntryLineReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                journalentryline);
    }
    public JournalEntryLineReadListResponse readByJournalEntryLineStatus(String journalentrylinestatus) {
        List<JournalEntryLine> journalentrylines = journalentrylineRepository.readByJournalEntryLineStatus(journalentrylinestatus);
        return new JournalEntryLineReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        journalentrylines);
    }
    public JournalEntryLineReadListResponse readByJournalEntryLineTransactionId(int journalentrylinetransactionid) {
        List<JournalEntryLine> journalentrylines = journalentrylineRepository.readByJournalEntryLineTransactionId(journalentrylinetransactionid);
        return new JournalEntryLineReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        journalentrylines);
    }
    public JournalEntryLineReadListResponse readByJournalEntryLineUpdatedAt(String journalentrylineupdatedat) {
        List<JournalEntryLine> journalentrylines = journalentrylineRepository.readByJournalEntryLineUpdatedAt(journalentrylineupdatedat);
        return new JournalEntryLineReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        journalentrylines);
    }
}
