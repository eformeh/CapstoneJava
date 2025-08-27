
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
import qucoon.mod.SpringServerless.repository.page.DepartmentPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.DepartmentDto;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private  final Gson GSON;


    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(DepartmentCreateRequest request) {

        Department department = GSON.fromJson(GSON.toJson(request), Department.class);
        if (department.getDepartmentStatus() == null) {
            department.setDepartmentStatus("ACTIVE");
        }
        departmentRepository.create(department);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<DepartmentCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Department[] departmentArray = GSON.fromJson(json, Department[].class);
            List<Department> departments = Arrays.asList(departmentArray);
            departmentRepository.bulkCreate(departments);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(DepartmentUpdateRequest request) {
        Department department = departmentRepository.readByDepartmentId(request.getDepartmentId());
        if (department == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        departmentRepository.update(department);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int departmentId) {
        int updateResponse = departmentRepository.delete(departmentId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public DepartmentReadListResponse read() {
        List<Department> departments = departmentRepository.read();
       if(departments == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new DepartmentReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), departments);
    }
   public DepartmentReadPagedResponse search(DepartmentFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       DepartmentPage page = departmentRepository.findDepartment(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<DepartmentDto> dtos = page.getData().stream()
            .map(DepartmentDto::from)
            .collect(Collectors.toList());
    return new DepartmentReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public DepartmentReadListResponse readByDepartmentCreatedAt(String departmentcreatedat) {
        List<Department> departments = departmentRepository.readByDepartmentCreatedAt(departmentcreatedat);
        return new DepartmentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        departments);
    }
    public DepartmentReadListResponse readByDepartmentDescription(String departmentdescription) {
        List<Department> departments = departmentRepository.readByDepartmentDescription(departmentdescription);
        return new DepartmentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        departments);
    }
    public DepartmentReadSingleResponse readByDepartmentId(int departmentid) {
        Department department = departmentRepository.readByDepartmentId(departmentid);
        if (department == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new DepartmentReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                department);
    }
    public DepartmentReadListResponse readByDepartmentName(String departmentname) {
        List<Department> departments = departmentRepository.readByDepartmentName(departmentname);
        return new DepartmentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        departments);
    }
    public DepartmentReadListResponse readByDepartmentStatus(String departmentstatus) {
        List<Department> departments = departmentRepository.readByDepartmentStatus(departmentstatus);
        return new DepartmentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        departments);
    }
    public DepartmentReadListResponse readByDepartmentUpdatedAt(String departmentupdatedat) {
        List<Department> departments = departmentRepository.readByDepartmentUpdatedAt(departmentupdatedat);
        return new DepartmentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        departments);
    }
}
