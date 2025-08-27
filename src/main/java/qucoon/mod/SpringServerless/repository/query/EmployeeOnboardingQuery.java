
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   EmployeeOnboardingQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   SET   employeeonboardingStatus   =   'DELETED',   employeeonboardingUpdatedAt   =   GETDATE() 
WHERE   employeeOnboardingId=:employeeOnboardingId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeonboardingStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING(

 employeeOnboardingAssignedBy,
 employeeOnboardingAttachmentUrl,
 employeeOnboardingCompletedDate,
 employeeOnboardingDueDate,
 employeeOnboardingEmployeeId,
 employeeOnboardingNotes,
 employeeOnboardingTaskId,
employeeOnboardingStatus,
employeeOnboardingCreatedAt,
employeeOnboardingUpdatedAt
)   VALUES   (

 :employeeOnboardingAssignedBy,
 :employeeOnboardingAttachmentUrl,
 :employeeOnboardingCompletedDate,
 :employeeOnboardingDueDate,
 :employeeOnboardingEmployeeId,
 :employeeOnboardingNotes,
 :employeeOnboardingTaskId,
 COALESCE(:employeeOnboardingStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   SET

 employeeOnboardingAssignedBy = :employeeOnboardingAssignedBy,
 employeeOnboardingAttachmentUrl = :employeeOnboardingAttachmentUrl,
 employeeOnboardingCompletedDate = :employeeOnboardingCompletedDate,
 employeeOnboardingDueDate = :employeeOnboardingDueDate,
 employeeOnboardingEmployeeId = :employeeOnboardingEmployeeId,
 employeeOnboardingNotes = :employeeOnboardingNotes,
 employeeOnboardingTaskId = :employeeOnboardingTaskId,
 employeeOnboardingStatus=:userStatus,
 employeeOnboardingUpdatedAt = GETDATE()
WHERE   employeeOnboardingId=:employeeOnboardingId
""";


public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGASSIGNEDBY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingAssignedBy=:employeeOnboardingAssignedBy   AND   employeeonboardingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGATTACHMENTURL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingAttachmentUrl=:employeeOnboardingAttachmentUrl   AND   employeeonboardingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGCOMPLETEDDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingCompletedDate=:employeeOnboardingCompletedDate   AND   employeeonboardingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingCreatedAt=:employeeOnboardingCreatedAt   AND   employeeonboardingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGDUEDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingDueDate=:employeeOnboardingDueDate   AND   employeeonboardingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGEMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingEmployeeId=:employeeOnboardingEmployeeId   AND   employeeonboardingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingId=:employeeOnboardingId   AND   employeeonboardingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGNOTES  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingNotes=:employeeOnboardingNotes   AND   employeeonboardingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingStatus=:employeeOnboardingStatus   AND   employeeonboardingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGTASKID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingTaskId=:employeeOnboardingTaskId   AND   employeeonboardingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EMPLOYEE_ONBOARDING_EMPLOYEEONBOARDINGUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EMPLOYEE_ONBOARDING   WHERE   employeeOnboardingUpdatedAt=:employeeOnboardingUpdatedAt   AND   employeeonboardingStatus<>'DELETED'
""";



private   EmployeeOnboardingQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
