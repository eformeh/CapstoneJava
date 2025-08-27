
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   PayPeriodQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
PAY_PERIOD   SET   payperiodStatus   =   'DELETED',   payperiodUpdatedAt   =   GETDATE() 
WHERE   payPeriodId=:payPeriodId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
PAY_PERIOD
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
PAY_PERIOD   WHERE   payperiodStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
PAY_PERIOD(

 payPeriodEndDate,
 payPeriodName,
 payPeriodPeriodType,
 payPeriodStartDate,
payPeriodStatus,
payPeriodCreatedAt,
payPeriodUpdatedAt
)   VALUES   (

 :payPeriodEndDate,
 :payPeriodName,
 :payPeriodPeriodType,
 :payPeriodStartDate,
 COALESCE(:payPeriodStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
PAY_PERIOD   SET

 payPeriodEndDate = :payPeriodEndDate,
 payPeriodName = :payPeriodName,
 payPeriodPeriodType = :payPeriodPeriodType,
 payPeriodStartDate = :payPeriodStartDate,
 payPeriodStatus=:userStatus,
 payPeriodUpdatedAt = GETDATE()
WHERE   payPeriodId=:payPeriodId
""";


public   static   final   String   READ_BY_PAY_PERIOD_PAYPERIODCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PAY_PERIOD   WHERE   payPeriodCreatedAt=:payPeriodCreatedAt   AND   payperiodStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PAY_PERIOD_PAYPERIODENDDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PAY_PERIOD   WHERE   payPeriodEndDate=:payPeriodEndDate   AND   payperiodStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PAY_PERIOD_PAYPERIODID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PAY_PERIOD   WHERE   payPeriodId=:payPeriodId   AND   payperiodStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PAY_PERIOD_PAYPERIODNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PAY_PERIOD   WHERE   payPeriodName=:payPeriodName   AND   payperiodStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PAY_PERIOD_PAYPERIODPERIODTYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PAY_PERIOD   WHERE   payPeriodPeriodType=:payPeriodPeriodType   AND   payperiodStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PAY_PERIOD_PAYPERIODSTARTDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PAY_PERIOD   WHERE   payPeriodStartDate=:payPeriodStartDate   AND   payperiodStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PAY_PERIOD_PAYPERIODSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PAY_PERIOD   WHERE   payPeriodStatus=:payPeriodStatus   AND   payperiodStatus<>'DELETED'
""";

public   static   final   String   READ_BY_PAY_PERIOD_PAYPERIODUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
PAY_PERIOD   WHERE   payPeriodUpdatedAt=:payPeriodUpdatedAt   AND   payperiodStatus<>'DELETED'
""";



private   PayPeriodQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
