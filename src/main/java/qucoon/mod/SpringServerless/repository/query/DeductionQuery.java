
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   DeductionQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
DEDUCTION   SET   deductionStatus   =   'DELETED',   deductionUpdatedAt   =   GETDATE() 
WHERE   deductionId=:deductionId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
DEDUCTION
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
DEDUCTION   WHERE   deductionStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
DEDUCTION(

 deductionAmount,
 deductionSalaryId,
 deductionType,
deductionStatus,
deductionCreatedAt,
deductionUpdatedAt
)   VALUES   (

 :deductionAmount,
 :deductionSalaryId,
 :deductionType,
 COALESCE(:deductionStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
DEDUCTION   SET

 deductionAmount = :deductionAmount,
 deductionSalaryId = :deductionSalaryId,
 deductionType = :deductionType,
 deductionStatus=:userStatus,
 deductionUpdatedAt = GETDATE()
WHERE   deductionId=:deductionId
""";


public   static   final   String   READ_BY_DEDUCTION_DEDUCTIONAMOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEDUCTION   WHERE   deductionAmount=:deductionAmount   AND   deductionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEDUCTION_DEDUCTIONCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEDUCTION   WHERE   deductionCreatedAt=:deductionCreatedAt   AND   deductionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEDUCTION_DEDUCTIONID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEDUCTION   WHERE   deductionId=:deductionId   AND   deductionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEDUCTION_DEDUCTIONSALARYID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEDUCTION   WHERE   deductionSalaryId=:deductionSalaryId   AND   deductionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEDUCTION_DEDUCTIONSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEDUCTION   WHERE   deductionStatus=:deductionStatus   AND   deductionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEDUCTION_DEDUCTIONTYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEDUCTION   WHERE   deductionType=:deductionType   AND   deductionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_DEDUCTION_DEDUCTIONUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
DEDUCTION   WHERE   deductionUpdatedAt=:deductionUpdatedAt   AND   deductionStatus<>'DELETED'
""";



private   DeductionQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
