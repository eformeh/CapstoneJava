
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
import qucoon.mod.SpringServerless.repository.page.EmployeePage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.EmployeeDto;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private  final Gson GSON;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(EmployeeCreateRequest request) {
        //Unique Attribute Check
        List<Employee> employee_1 = employeeRepository.readByEmployeeEmail(request.getEmployeeEmail());
        if (!employee_1.isEmpty()) {
            throw new CustomExceptions.DuplicateItemException("+Employee with EmployeeEmail: " + request.getEmployeeEmail() + " already exists");
        }

        //Unique Attribute Check
        List<Employee> employee_2 = employeeRepository.readByEmployeePhone(request.getEmployeePhone());
        if (!employee_2.isEmpty()) {
            throw new CustomExceptions.DuplicateItemException("+Employee with EmployeePhone: " + request.getEmployeePhone() + " already exists");
        }


        Employee employee = GSON.fromJson(GSON.toJson(request), Employee.class);
        if (employee.getEmployeeStatus() == null) {
            employee.setEmployeeStatus("ACTIVE");
        }
        employeeRepository.create(employee);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<EmployeeCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Employee[] employeeArray = GSON.fromJson(json, Employee[].class);
            List<Employee> employees = Arrays.asList(employeeArray);
            employeeRepository.bulkCreate(employees);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(EmployeeUpdateRequest request) {
        Employee employee = employeeRepository.readByEmployeeId(request.getEmployeeId());
        if (employee == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        employeeRepository.update(employee);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int employeeId) {
        int updateResponse = employeeRepository.delete(employeeId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public EmployeeReadListResponse read() {
        List<Employee> employees = employeeRepository.read();
       if(employees == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new EmployeeReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), employees);
    }
   public EmployeeReadPagedResponse search(EmployeeFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       EmployeePage page = employeeRepository.findEmployee(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<EmployeeDto> dtos = page.getData().stream()
            .map(EmployeeDto::from)
            .collect(Collectors.toList());
    return new EmployeeReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public EmployeeReadListResponse readByEmployeeContractEndDate(String employeecontractenddate) {
        List<Employee> employees = employeeRepository.readByEmployeeContractEndDate(employeecontractenddate);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadListResponse readByEmployeeCreatedAt(String employeecreatedat) {
        List<Employee> employees = employeeRepository.readByEmployeeCreatedAt(employeecreatedat);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadListResponse readByEmployeeDateOfBirth(String employeedateofbirth) {
        List<Employee> employees = employeeRepository.readByEmployeeDateOfBirth(employeedateofbirth);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadSingleResponse readByEmployeeEmail(String employeeemail) {
        List<Employee> employee = employeeRepository.readByEmployeeEmail(employeeemail);
        if (employee == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new EmployeeReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                employee.get(0));
    }
    public EmployeeReadListResponse readByEmployeeEmploymentStatus(String employeeemploymentstatus) {
        List<Employee> employees = employeeRepository.readByEmployeeEmploymentStatus(employeeemploymentstatus);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadListResponse readByEmployeeEmploymentType(String employeeemploymenttype) {
        List<Employee> employees = employeeRepository.readByEmployeeEmploymentType(employeeemploymenttype);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadListResponse readByEmployeeFirstName(String employeefirstname) {
        List<Employee> employees = employeeRepository.readByEmployeeFirstName(employeefirstname);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadListResponse readByEmployeeHireDate(String employeehiredate) {
        List<Employee> employees = employeeRepository.readByEmployeeHireDate(employeehiredate);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadSingleResponse readByEmployeeId(int employeeid) {
        Employee employee = employeeRepository.readByEmployeeId(employeeid);
        if (employee == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new EmployeeReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                employee);
    }
    public EmployeeReadListResponse readByEmployeeJobId(int employeejobid) {
        List<Employee> employees = employeeRepository.readByEmployeeJobId(employeejobid);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadListResponse readByEmployeeLastName(String employeelastname) {
        List<Employee> employees = employeeRepository.readByEmployeeLastName(employeelastname);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadListResponse readByEmployeeMaritalStatus(String employeemaritalstatus) {
        List<Employee> employees = employeeRepository.readByEmployeeMaritalStatus(employeemaritalstatus);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadListResponse readByEmployeeNationality(String employeenationality) {
        List<Employee> employees = employeeRepository.readByEmployeeNationality(employeenationality);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadSingleResponse readByEmployeePhone(String employeephone) {
        List<Employee> employee = employeeRepository.readByEmployeePhone(employeephone);
        if (employee == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new EmployeeReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                employee.get(0));
    }
    public EmployeeReadListResponse readByEmployeePhotoUrl(String employeephotourl) {
        List<Employee> employees = employeeRepository.readByEmployeePhotoUrl(employeephotourl);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadListResponse readByEmployeeStatus(String employeestatus) {
        List<Employee> employees = employeeRepository.readByEmployeeStatus(employeestatus);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
    public EmployeeReadListResponse readByEmployeeUpdatedAt(String employeeupdatedat) {
        List<Employee> employees = employeeRepository.readByEmployeeUpdatedAt(employeeupdatedat);
        return new EmployeeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employees);
    }
}
