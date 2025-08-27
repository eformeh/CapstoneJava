
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.LeaveRequestPage;
import qucoon.mod.SpringServerless.model.request.LeaveRequestFilterRequest;

import java.util.List;

@Repository
    public interface LeaveRequestRepository {


    // Additional query methods can be defined here.
    int create(LeaveRequest leaverequest);
    void bulkCreate(List<LeaveRequest>  leaverequest);
    int update(LeaveRequest  leaverequest);
    int delete(int leaveRequestId);
    LeaveRequestPage findLeaveRequest(LeaveRequestFilterRequest filter);
    boolean truncate();
    List<LeaveRequest> read();
    List<LeaveRequest> readByLeaveRequestCreatedAt(String leaveRequestCreatedAt);
    List<LeaveRequest> readByLeaveRequestDecisionDate(String leaveRequestDecisionDate);
    List<LeaveRequest> readByLeaveRequestEmployeeId(int leaveRequestEmployeeId);
    List<LeaveRequest> readByLeaveRequestEndDate(String leaveRequestEndDate);
    LeaveRequest readByLeaveRequestId(int leaveRequestId);
    List<LeaveRequest> readByLeaveRequestReason(String leaveRequestReason);
    List<LeaveRequest> readByLeaveRequestReviewerId(int leaveRequestReviewerId);
    List<LeaveRequest> readByLeaveRequestStartDate(String leaveRequestStartDate);
    List<LeaveRequest> readByLeaveRequestStatus(String leaveRequestStatus);
    List<LeaveRequest> readByLeaveRequestSubmittedAt(String leaveRequestSubmittedAt);
    List<LeaveRequest> readByLeaveRequestTypeId(int leaveRequestTypeId);
    List<LeaveRequest> readByLeaveRequestUpdatedAt(String leaveRequestUpdatedAt);
}
