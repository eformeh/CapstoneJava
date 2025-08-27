
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   AllowanceQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
ALLOWANCE   SET   allowanceStatus   =   'DELETED',   allowanceUpdatedAt   =   GETDATE() 
WHERE   allowanceId=:allowanceId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
ALLOWANCE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
ALLOWANCE   WHERE   allowanceStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
ALLOWANCE(

 allowanceAmount,
 allowanceSalaryId,
 allowanceType,
allowanceStatus,
allowanceCreatedAt,
allowanceUpdatedAt
)   VALUES   (

 :allowanceAmount,
 :allowanceSalaryId,
 :allowanceType,
 COALESCE(:allowanceStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
ALLOWANCE   SET

 allowanceAmount = :allowanceAmount,
 allowanceSalaryId = :allowanceSalaryId,
 allowanceType = :allowanceType,
 allowanceStatus=:userStatus,
 allowanceUpdatedAt = GETDATE()
WHERE   allowanceId=:allowanceId
""";


public   static   final   String   READ_BY_ALLOWANCE_ALLOWANCEAMOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ALLOWANCE   WHERE   allowanceAmount=:allowanceAmount   AND   allowanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ALLOWANCE_ALLOWANCECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ALLOWANCE   WHERE   allowanceCreatedAt=:allowanceCreatedAt   AND   allowanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ALLOWANCE_ALLOWANCEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ALLOWANCE   WHERE   allowanceId=:allowanceId   AND   allowanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ALLOWANCE_ALLOWANCESALARYID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ALLOWANCE   WHERE   allowanceSalaryId=:allowanceSalaryId   AND   allowanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ALLOWANCE_ALLOWANCESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ALLOWANCE   WHERE   allowanceStatus=:allowanceStatus   AND   allowanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ALLOWANCE_ALLOWANCETYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ALLOWANCE   WHERE   allowanceType=:allowanceType   AND   allowanceStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ALLOWANCE_ALLOWANCEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ALLOWANCE   WHERE   allowanceUpdatedAt=:allowanceUpdatedAt   AND   allowanceStatus<>'DELETED'
""";



private   AllowanceQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
