
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   LeaveRequestQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   SET   leaverequestStatus   =   'DELETED',   leaverequestUpdatedAt   =   GETDATE() 
WHERE   leaveRequestId=:leaveRequestId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaverequestStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST(

 leaveRequestDecisionDate,
 leaveRequestEmployeeId,
 leaveRequestEndDate,
 leaveRequestReason,
 leaveRequestReviewerId,
 leaveRequestStartDate,
 leaveRequestSubmittedAt,
 leaveRequestTypeId,
leaveRequestStatus,
leaveRequestCreatedAt,
leaveRequestUpdatedAt
)   VALUES   (

 :leaveRequestDecisionDate,
 :leaveRequestEmployeeId,
 :leaveRequestEndDate,
 :leaveRequestReason,
 :leaveRequestReviewerId,
 :leaveRequestStartDate,
 :leaveRequestSubmittedAt,
 :leaveRequestTypeId,
 COALESCE(:leaveRequestStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   SET

 leaveRequestDecisionDate = :leaveRequestDecisionDate,
 leaveRequestEmployeeId = :leaveRequestEmployeeId,
 leaveRequestEndDate = :leaveRequestEndDate,
 leaveRequestReason = :leaveRequestReason,
 leaveRequestReviewerId = :leaveRequestReviewerId,
 leaveRequestStartDate = :leaveRequestStartDate,
 leaveRequestSubmittedAt = :leaveRequestSubmittedAt,
 leaveRequestTypeId = :leaveRequestTypeId,
 leaveRequestStatus=:userStatus,
 leaveRequestUpdatedAt = GETDATE()
WHERE   leaveRequestId=:leaveRequestId
""";


public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestCreatedAt=:leaveRequestCreatedAt   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTDECISIONDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestDecisionDate=:leaveRequestDecisionDate   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTEMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestEmployeeId=:leaveRequestEmployeeId   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTENDDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestEndDate=:leaveRequestEndDate   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestId=:leaveRequestId   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTREASON  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestReason=:leaveRequestReason   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTREVIEWERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestReviewerId=:leaveRequestReviewerId   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTSTARTDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestStartDate=:leaveRequestStartDate   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestStatus=:leaveRequestStatus   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTSUBMITTEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestSubmittedAt=:leaveRequestSubmittedAt   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTTYPEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestTypeId=:leaveRequestTypeId   AND   leaverequestStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_REQUEST_LEAVEREQUESTUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_REQUEST   WHERE   leaveRequestUpdatedAt=:leaveRequestUpdatedAt   AND   leaverequestStatus<>'DELETED'
""";



private   LeaveRequestQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
