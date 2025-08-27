
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.LeaveBalancePage;
import qucoon.mod.SpringServerless.model.request.LeaveBalanceFilterRequest;

import java.util.List;

@Repository
    public interface LeaveBalanceRepository {


    // Additional query methods can be defined here.
    int create(LeaveBalance leavebalance);
    void bulkCreate(List<LeaveBalance>  leavebalance);
    int update(LeaveBalance  leavebalance);
    int delete(int leaveBalanceId);
    LeaveBalancePage findLeaveBalance(LeaveBalanceFilterRequest filter);
    boolean truncate();
    List<LeaveBalance> read();
    List<LeaveBalance> readByLeaveBalanceCreatedAt(String leaveBalanceCreatedAt);
    List<LeaveBalance> readByLeaveBalanceEmployeeId(int leaveBalanceEmployeeId);
    LeaveBalance readByLeaveBalanceId(int leaveBalanceId);
    List<LeaveBalance> readByLeaveBalanceRemainingDays(int leaveBalanceRemainingDays);
    List<LeaveBalance> readByLeaveBalanceStatus(String leaveBalanceStatus);
    List<LeaveBalance> readByLeaveBalanceTotalDays(int leaveBalanceTotalDays);
    List<LeaveBalance> readByLeaveBalanceTypeId(int leaveBalanceTypeId);
    List<LeaveBalance> readByLeaveBalanceUpdatedAt(String leaveBalanceUpdatedAt);
    List<LeaveBalance> readByLeaveBalanceUsedDays(int leaveBalanceUsedDays);
}
