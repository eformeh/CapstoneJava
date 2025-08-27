
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
import qucoon.mod.SpringServerless.repository.page.OvertimePage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.OvertimeDto;


@Service
public class OvertimeService {

    private final OvertimeRepository overtimeRepository;
    private  final Gson GSON;


    public OvertimeService(OvertimeRepository overtimeRepository) {
        this.overtimeRepository = overtimeRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(OvertimeCreateRequest request) {

        Overtime overtime = GSON.fromJson(GSON.toJson(request), Overtime.class);
        if (overtime.getOvertimeStatus() == null) {
            overtime.setOvertimeStatus("ACTIVE");
        }
        overtimeRepository.create(overtime);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<OvertimeCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Overtime[] overtimeArray = GSON.fromJson(json, Overtime[].class);
            List<Overtime> overtimes = Arrays.asList(overtimeArray);
            overtimeRepository.bulkCreate(overtimes);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(OvertimeUpdateRequest request) {
        Overtime overtime = overtimeRepository.readByOvertimeId(request.getOvertimeId());
        if (overtime == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        overtimeRepository.update(overtime);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int overtimeId) {
        int updateResponse = overtimeRepository.delete(overtimeId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public OvertimeReadListResponse read() {
        List<Overtime> overtimes = overtimeRepository.read();
       if(overtimes == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new OvertimeReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), overtimes);
    }
   public OvertimeReadPagedResponse search(OvertimeFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       OvertimePage page = overtimeRepository.findOvertime(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<OvertimeDto> dtos = page.getData().stream()
            .map(OvertimeDto::from)
            .collect(Collectors.toList());
    return new OvertimeReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public OvertimeReadListResponse readByOvertimeCreatedAt(String overtimecreatedat) {
        List<Overtime> overtimes = overtimeRepository.readByOvertimeCreatedAt(overtimecreatedat);
        return new OvertimeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        overtimes);
    }
    public OvertimeReadListResponse readByOvertimeDate(String overtimedate) {
        List<Overtime> overtimes = overtimeRepository.readByOvertimeDate(overtimedate);
        return new OvertimeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        overtimes);
    }
    public OvertimeReadListResponse readByOvertimeEmployeeId(int overtimeemployeeid) {
        List<Overtime> overtimes = overtimeRepository.readByOvertimeEmployeeId(overtimeemployeeid);
        return new OvertimeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        overtimes);
    }
    public OvertimeReadListResponse readByOvertimeHours(Double overtimehours) {
        List<Overtime> overtimes = overtimeRepository.readByOvertimeHours(overtimehours);
        return new OvertimeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        overtimes);
    }
    public OvertimeReadSingleResponse readByOvertimeId(int overtimeid) {
        Overtime overtime = overtimeRepository.readByOvertimeId(overtimeid);
        if (overtime == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new OvertimeReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                overtime);
    }
    public OvertimeReadListResponse readByOvertimeStatus(String overtimestatus) {
        List<Overtime> overtimes = overtimeRepository.readByOvertimeStatus(overtimestatus);
        return new OvertimeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        overtimes);
    }
    public OvertimeReadListResponse readByOvertimeUpdatedAt(String overtimeupdatedat) {
        List<Overtime> overtimes = overtimeRepository.readByOvertimeUpdatedAt(overtimeupdatedat);
        return new OvertimeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        overtimes);
    }
}
