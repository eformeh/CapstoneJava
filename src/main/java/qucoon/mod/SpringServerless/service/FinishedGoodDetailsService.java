
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
import qucoon.mod.SpringServerless.repository.page.FinishedGoodDetailsPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.FinishedGoodDetailsDto;


@Service
public class FinishedGoodDetailsService {

    private final FinishedGoodDetailsRepository finishedgooddetailsRepository;
    private  final Gson GSON;


    public FinishedGoodDetailsService(FinishedGoodDetailsRepository finishedgooddetailsRepository) {
        this.finishedgooddetailsRepository = finishedgooddetailsRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(FinishedGoodDetailsCreateRequest request) {

        FinishedGoodDetails finishedgooddetails = GSON.fromJson(GSON.toJson(request), FinishedGoodDetails.class);
        if (finishedgooddetails.getFinishedGoodDetailsStatus() == null) {
            finishedgooddetails.setFinishedGoodDetailsStatus("ACTIVE");
        }
        finishedgooddetailsRepository.create(finishedgooddetails);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<FinishedGoodDetailsCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            FinishedGoodDetails[] finishedgooddetailsArray = GSON.fromJson(json, FinishedGoodDetails[].class);
            List<FinishedGoodDetails> finishedgooddetailss = Arrays.asList(finishedgooddetailsArray);
            finishedgooddetailsRepository.bulkCreate(finishedgooddetailss);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(FinishedGoodDetailsUpdateRequest request) {
        FinishedGoodDetails finishedgooddetails = finishedgooddetailsRepository.readByFinishedGoodDetailsId(request.getFinishedGoodDetailsId());
        if (finishedgooddetails == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        finishedgooddetailsRepository.update(finishedgooddetails);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int finishedGoodDetailsId) {
        int updateResponse = finishedgooddetailsRepository.delete(finishedGoodDetailsId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public FinishedGoodDetailsReadListResponse read() {
        List<FinishedGoodDetails> finishedgooddetailss = finishedgooddetailsRepository.read();
       if(finishedgooddetailss == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new FinishedGoodDetailsReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), finishedgooddetailss);
    }
   public FinishedGoodDetailsReadPagedResponse search(FinishedGoodDetailsFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       FinishedGoodDetailsPage page = finishedgooddetailsRepository.findFinishedGoodDetails(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<FinishedGoodDetailsDto> dtos = page.getData().stream()
            .map(FinishedGoodDetailsDto::from)
            .collect(Collectors.toList());
    return new FinishedGoodDetailsReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public FinishedGoodDetailsReadListResponse readByFinishedGoodDetailsCreatedAt(String finishedgooddetailscreatedat) {
        List<FinishedGoodDetails> finishedgooddetailss = finishedgooddetailsRepository.readByFinishedGoodDetailsCreatedAt(finishedgooddetailscreatedat);
        return new FinishedGoodDetailsReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        finishedgooddetailss);
    }
    public FinishedGoodDetailsReadListResponse readByFinishedGoodDetailsExpiryDate(String finishedgooddetailsexpirydate) {
        List<FinishedGoodDetails> finishedgooddetailss = finishedgooddetailsRepository.readByFinishedGoodDetailsExpiryDate(finishedgooddetailsexpirydate);
        return new FinishedGoodDetailsReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        finishedgooddetailss);
    }
    public FinishedGoodDetailsReadSingleResponse readByFinishedGoodDetailsId(int finishedgooddetailsid) {
        FinishedGoodDetails finishedgooddetails = finishedgooddetailsRepository.readByFinishedGoodDetailsId(finishedgooddetailsid);
        if (finishedgooddetails == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new FinishedGoodDetailsReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                finishedgooddetails);
    }
    public FinishedGoodDetailsReadListResponse readByFinishedGoodDetailsInventoryItemId(int finishedgooddetailsinventoryitemid) {
        List<FinishedGoodDetails> finishedgooddetailss = finishedgooddetailsRepository.readByFinishedGoodDetailsInventoryItemId(finishedgooddetailsinventoryitemid);
        return new FinishedGoodDetailsReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        finishedgooddetailss);
    }
    public FinishedGoodDetailsReadListResponse readByFinishedGoodDetailsManufacturingDate(String finishedgooddetailsmanufacturingdate) {
        List<FinishedGoodDetails> finishedgooddetailss = finishedgooddetailsRepository.readByFinishedGoodDetailsManufacturingDate(finishedgooddetailsmanufacturingdate);
        return new FinishedGoodDetailsReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        finishedgooddetailss);
    }
    public FinishedGoodDetailsReadListResponse readByFinishedGoodDetailsProductId(int finishedgooddetailsproductid) {
        List<FinishedGoodDetails> finishedgooddetailss = finishedgooddetailsRepository.readByFinishedGoodDetailsProductId(finishedgooddetailsproductid);
        return new FinishedGoodDetailsReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        finishedgooddetailss);
    }
    public FinishedGoodDetailsReadListResponse readByFinishedGoodDetailsStatus(String finishedgooddetailsstatus) {
        List<FinishedGoodDetails> finishedgooddetailss = finishedgooddetailsRepository.readByFinishedGoodDetailsStatus(finishedgooddetailsstatus);
        return new FinishedGoodDetailsReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        finishedgooddetailss);
    }
    public FinishedGoodDetailsReadListResponse readByFinishedGoodDetailsUpdatedAt(String finishedgooddetailsupdatedat) {
        List<FinishedGoodDetails> finishedgooddetailss = finishedgooddetailsRepository.readByFinishedGoodDetailsUpdatedAt(finishedgooddetailsupdatedat);
        return new FinishedGoodDetailsReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        finishedgooddetailss);
    }
}
