
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   LeaveTypeQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   SET   leavetypeStatus   =   'DELETED',   leavetypeUpdatedAt   =   GETDATE() 
WHERE   leaveTypeId=:leaveTypeId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
LEAVE_TYPE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   WHERE   leavetypeStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
LEAVE_TYPE(

 leaveTypeAccrualRatePerMonth,
 leaveTypeDescription,
 leaveTypeName,
 leaveTypeResetPolicy,
leaveTypeStatus,
leaveTypeCreatedAt,
leaveTypeUpdatedAt
)   VALUES   (

 :leaveTypeAccrualRatePerMonth,
 :leaveTypeDescription,
 :leaveTypeName,
 :leaveTypeResetPolicy,
 COALESCE(:leaveTypeStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   SET

 leaveTypeAccrualRatePerMonth = :leaveTypeAccrualRatePerMonth,
 leaveTypeDescription = :leaveTypeDescription,
 leaveTypeName = :leaveTypeName,
 leaveTypeResetPolicy = :leaveTypeResetPolicy,
 leaveTypeStatus=:userStatus,
 leaveTypeUpdatedAt = GETDATE()
WHERE   leaveTypeId=:leaveTypeId
""";


public   static   final   String   READ_BY_LEAVE_TYPE_LEAVETYPEACCRUALRATEPERMONTH  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   WHERE   leaveTypeAccrualRatePerMonth=:leaveTypeAccrualRatePerMonth   AND   leavetypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_TYPE_LEAVETYPECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   WHERE   leaveTypeCreatedAt=:leaveTypeCreatedAt   AND   leavetypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_TYPE_LEAVETYPEDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   WHERE   leaveTypeDescription=:leaveTypeDescription   AND   leavetypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_TYPE_LEAVETYPEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   WHERE   leaveTypeId=:leaveTypeId   AND   leavetypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_TYPE_LEAVETYPENAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   WHERE   leaveTypeName=:leaveTypeName   AND   leavetypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_TYPE_LEAVETYPERESETPOLICY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   WHERE   leaveTypeResetPolicy=:leaveTypeResetPolicy   AND   leavetypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_TYPE_LEAVETYPESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   WHERE   leaveTypeStatus=:leaveTypeStatus   AND   leavetypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_TYPE_LEAVETYPEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_TYPE   WHERE   leaveTypeUpdatedAt=:leaveTypeUpdatedAt   AND   leavetypeStatus<>'DELETED'
""";



private   LeaveTypeQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
