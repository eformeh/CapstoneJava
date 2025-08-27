
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   AccountTypeQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE   SET   accounttypeStatus   =   'DELETED',   accounttypeUpdatedAt   =   GETDATE() 
WHERE   accountTypeId=:accountTypeId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE   WHERE   accounttypeStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE(

 accountTypeAccountTypeName,
 accountTypeDescription,
 accountTypeNormalBalance,
accountTypeStatus,
accountTypeCreatedAt,
accountTypeUpdatedAt
)   VALUES   (

 :accountTypeAccountTypeName,
 :accountTypeDescription,
 :accountTypeNormalBalance,
 COALESCE(:accountTypeStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE   SET

 accountTypeAccountTypeName = :accountTypeAccountTypeName,
 accountTypeDescription = :accountTypeDescription,
 accountTypeNormalBalance = :accountTypeNormalBalance,
 accountTypeStatus=:userStatus,
 accountTypeUpdatedAt = GETDATE()
WHERE   accountTypeId=:accountTypeId
""";


public   static   final   String   READ_BY_ACCOUNT_TYPE_ACCOUNTTYPEACCOUNTTYPENAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE   WHERE   accountTypeAccountTypeName=:accountTypeAccountTypeName   AND   accounttypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_TYPE_ACCOUNTTYPECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE   WHERE   accountTypeCreatedAt=:accountTypeCreatedAt   AND   accounttypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_TYPE_ACCOUNTTYPEDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE   WHERE   accountTypeDescription=:accountTypeDescription   AND   accounttypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_TYPE_ACCOUNTTYPEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE   WHERE   accountTypeId=:accountTypeId   AND   accounttypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_TYPE_ACCOUNTTYPENORMALBALANCE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE   WHERE   accountTypeNormalBalance=:accountTypeNormalBalance   AND   accounttypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_TYPE_ACCOUNTTYPESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE   WHERE   accountTypeStatus=:accountTypeStatus   AND   accounttypeStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_TYPE_ACCOUNTTYPEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_TYPE   WHERE   accountTypeUpdatedAt=:accountTypeUpdatedAt   AND   accounttypeStatus<>'DELETED'
""";



private   AccountTypeQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
