
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   AccountQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
ACCOUNT   SET   accountStatus   =   'DELETED',   accountUpdatedAt   =   GETDATE() 
WHERE   accountId=:accountId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
ACCOUNT
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
ACCOUNT   WHERE   accountStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
ACCOUNT(

 accountAccountName,
 accountAccountTypeId,
 accountDescription,
accountStatus,
accountCreatedAt,
accountUpdatedAt
)   VALUES   (

 :accountAccountName,
 :accountAccountTypeId,
 :accountDescription,
 COALESCE(:accountStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
ACCOUNT   SET

 accountAccountName = :accountAccountName,
 accountAccountTypeId = :accountAccountTypeId,
 accountDescription = :accountDescription,
 accountStatus=:userStatus,
 accountUpdatedAt = GETDATE()
WHERE   accountId=:accountId
""";


public   static   final   String   READ_BY_ACCOUNT_ACCOUNTACCOUNTNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT   WHERE   accountAccountName=:accountAccountName   AND   accountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_ACCOUNTACCOUNTTYPEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT   WHERE   accountAccountTypeId=:accountAccountTypeId   AND   accountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_ACCOUNTCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT   WHERE   accountCreatedAt=:accountCreatedAt   AND   accountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_ACCOUNTDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT   WHERE   accountDescription=:accountDescription   AND   accountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_ACCOUNTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT   WHERE   accountId=:accountId   AND   accountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_ACCOUNTSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT   WHERE   accountStatus=:accountStatus   AND   accountStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_ACCOUNTUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT   WHERE   accountUpdatedAt=:accountUpdatedAt   AND   accountStatus<>'DELETED'
""";



private   AccountQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
