
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   LeaveBalanceQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   SET   leavebalanceStatus   =   'DELETED',   leavebalanceUpdatedAt   =   GETDATE() 
WHERE   leaveBalanceId=:leaveBalanceId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   WHERE   leavebalanceStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE(

 leaveBalanceEmployeeId,
 leaveBalanceRemainingDays,
 leaveBalanceTotalDays,
 leaveBalanceTypeId,
 leaveBalanceUsedDays,
leaveBalanceStatus,
leaveBalanceCreatedAt,
leaveBalanceUpdatedAt
)   VALUES   (

 :leaveBalanceEmployeeId,
 :leaveBalanceRemainingDays,
 :leaveBalanceTotalDays,
 :leaveBalanceTypeId,
 :leaveBalanceUsedDays,
 COALESCE(:leaveBalanceStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   SET

 leaveBalanceEmployeeId = :leaveBalanceEmployeeId,
 leaveBalanceRemainingDays = :leaveBalanceRemainingDays,
 leaveBalanceTotalDays = :leaveBalanceTotalDays,
 leaveBalanceTypeId = :leaveBalanceTypeId,
 leaveBalanceUsedDays = :leaveBalanceUsedDays,
 leaveBalanceStatus=:userStatus,
 leaveBalanceUpdatedAt = GETDATE()
WHERE   leaveBalanceId=:leaveBalanceId
""";


public   static   final   String   READ_BY_LEAVE_BALANCE_LEAVEBALANCECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   WHERE   leaveBalanceCreatedAt=:leaveBalanceCreatedAt   AND   leavebalanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_BALANCE_LEAVEBALANCEEMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   WHERE   leaveBalanceEmployeeId=:leaveBalanceEmployeeId   AND   leavebalanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_BALANCE_LEAVEBALANCEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   WHERE   leaveBalanceId=:leaveBalanceId   AND   leavebalanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_BALANCE_LEAVEBALANCEREMAININGDAYS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   WHERE   leaveBalanceRemainingDays=:leaveBalanceRemainingDays   AND   leavebalanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_BALANCE_LEAVEBALANCESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   WHERE   leaveBalanceStatus=:leaveBalanceStatus   AND   leavebalanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_BALANCE_LEAVEBALANCETOTALDAYS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   WHERE   leaveBalanceTotalDays=:leaveBalanceTotalDays   AND   leavebalanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_BALANCE_LEAVEBALANCETYPEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   WHERE   leaveBalanceTypeId=:leaveBalanceTypeId   AND   leavebalanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_BALANCE_LEAVEBALANCEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   WHERE   leaveBalanceUpdatedAt=:leaveBalanceUpdatedAt   AND   leavebalanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_LEAVE_BALANCE_LEAVEBALANCEUSEDDAYS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
LEAVE_BALANCE   WHERE   leaveBalanceUsedDays=:leaveBalanceUsedDays   AND   leavebalanceStatus<>'DELETED'
""";



private   LeaveBalanceQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
