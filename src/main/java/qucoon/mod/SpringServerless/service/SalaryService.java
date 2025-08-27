
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
import qucoon.mod.SpringServerless.repository.page.SalaryPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.SalaryDto;


@Service
public class SalaryService {

    private final SalaryRepository salaryRepository;
    private  final Gson GSON;


    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(SalaryCreateRequest request) {

        Salary salary = GSON.fromJson(GSON.toJson(request), Salary.class);
        if (salary.getSalaryStatus() == null) {
            salary.setSalaryStatus("ACTIVE");
        }
        salaryRepository.create(salary);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<SalaryCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Salary[] salaryArray = GSON.fromJson(json, Salary[].class);
            List<Salary> salarys = Arrays.asList(salaryArray);
            salaryRepository.bulkCreate(salarys);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(SalaryUpdateRequest request) {
        Salary salary = salaryRepository.readBySalaryId(request.getSalaryId());
        if (salary == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        salaryRepository.update(salary);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int salaryId) {
        int updateResponse = salaryRepository.delete(salaryId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public SalaryReadListResponse read() {
        List<Salary> salarys = salaryRepository.read();
       if(salarys == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SalaryReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), salarys);
    }
   public SalaryReadPagedResponse search(SalaryFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       SalaryPage page = salaryRepository.findSalary(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<SalaryDto> dtos = page.getData().stream()
            .map(SalaryDto::from)
            .collect(Collectors.toList());
    return new SalaryReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public SalaryReadListResponse readBySalaryBasicAmount(Double salarybasicamount) {
        List<Salary> salarys = salaryRepository.readBySalaryBasicAmount(salarybasicamount);
        return new SalaryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarys);
    }
    public SalaryReadListResponse readBySalaryCreatedAt(String salarycreatedat) {
        List<Salary> salarys = salaryRepository.readBySalaryCreatedAt(salarycreatedat);
        return new SalaryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarys);
    }
    public SalaryReadListResponse readBySalaryEmployeeId(int salaryemployeeid) {
        List<Salary> salarys = salaryRepository.readBySalaryEmployeeId(salaryemployeeid);
        return new SalaryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarys);
    }
    public SalaryReadListResponse readBySalaryGrossPay(Double salarygrosspay) {
        List<Salary> salarys = salaryRepository.readBySalaryGrossPay(salarygrosspay);
        return new SalaryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarys);
    }
    public SalaryReadSingleResponse readBySalaryId(int salaryid) {
        Salary salary = salaryRepository.readBySalaryId(salaryid);
        if (salary == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SalaryReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                salary);
    }
    public SalaryReadListResponse readBySalaryNetPay(Double salarynetpay) {
        List<Salary> salarys = salaryRepository.readBySalaryNetPay(salarynetpay);
        return new SalaryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarys);
    }
    public SalaryReadListResponse readBySalaryPayPeriodId(int salarypayperiodid) {
        List<Salary> salarys = salaryRepository.readBySalaryPayPeriodId(salarypayperiodid);
        return new SalaryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarys);
    }
    public SalaryReadListResponse readBySalaryStatus(String salarystatus) {
        List<Salary> salarys = salaryRepository.readBySalaryStatus(salarystatus);
        return new SalaryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarys);
    }
    public SalaryReadListResponse readBySalaryUpdatedAt(String salaryupdatedat) {
        List<Salary> salarys = salaryRepository.readBySalaryUpdatedAt(salaryupdatedat);
        return new SalaryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarys);
    }
}
