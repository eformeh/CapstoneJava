
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.LeaveTypePage;
import qucoon.mod.SpringServerless.model.request.LeaveTypeFilterRequest;

import java.util.List;

@Repository
    public interface LeaveTypeRepository {


    // Additional query methods can be defined here.
    int create(LeaveType leavetype);
    void bulkCreate(List<LeaveType>  leavetype);
    int update(LeaveType  leavetype);
    int delete(int leaveTypeId);
    LeaveTypePage findLeaveType(LeaveTypeFilterRequest filter);
    boolean truncate();
    List<LeaveType> read();
    List<LeaveType> readByLeaveTypeAccrualRatePerMonth(Double leaveTypeAccrualRatePerMonth);
    List<LeaveType> readByLeaveTypeCreatedAt(String leaveTypeCreatedAt);
    List<LeaveType> readByLeaveTypeDescription(String leaveTypeDescription);
    LeaveType readByLeaveTypeId(int leaveTypeId);
    List<LeaveType> readByLeaveTypeName(String leaveTypeName);
    List<LeaveType> readByLeaveTypeResetPolicy(String leaveTypeResetPolicy);
    List<LeaveType> readByLeaveTypeStatus(String leaveTypeStatus);
    List<LeaveType> readByLeaveTypeUpdatedAt(String leaveTypeUpdatedAt);
}
