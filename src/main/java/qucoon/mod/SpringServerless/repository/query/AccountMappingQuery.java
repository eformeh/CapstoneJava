
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   AccountMappingQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   SET   accountmappingStatus   =   'DELETED',   accountmappingUpdatedAt   =   GETDATE() 
WHERE   accountMappingId=:accountMappingId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   WHERE   accountmappingStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING(

 accountMappingCrAccountId,
 accountMappingDescription,
 accountMappingDrAccountId,
 accountMappingTransactionCategoryId,
accountMappingStatus,
accountMappingCreatedAt,
accountMappingUpdatedAt
)   VALUES   (

 :accountMappingCrAccountId,
 :accountMappingDescription,
 :accountMappingDrAccountId,
 :accountMappingTransactionCategoryId,
 COALESCE(:accountMappingStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   SET

 accountMappingCrAccountId = :accountMappingCrAccountId,
 accountMappingDescription = :accountMappingDescription,
 accountMappingDrAccountId = :accountMappingDrAccountId,
 accountMappingTransactionCategoryId = :accountMappingTransactionCategoryId,
 accountMappingStatus=:userStatus,
 accountMappingUpdatedAt = GETDATE()
WHERE   accountMappingId=:accountMappingId
""";


public   static   final   String   READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGCRACCOUNTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   WHERE   accountMappingCrAccountId=:accountMappingCrAccountId   AND   accountmappingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   WHERE   accountMappingCreatedAt=:accountMappingCreatedAt   AND   accountmappingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   WHERE   accountMappingDescription=:accountMappingDescription   AND   accountmappingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGDRACCOUNTID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   WHERE   accountMappingDrAccountId=:accountMappingDrAccountId   AND   accountmappingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   WHERE   accountMappingId=:accountMappingId   AND   accountmappingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   WHERE   accountMappingStatus=:accountMappingStatus   AND   accountmappingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGTRANSACTIONCATEGORYID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   WHERE   accountMappingTransactionCategoryId=:accountMappingTransactionCategoryId   AND   accountmappingStatus<>'DELETED'
""";

public   static   final   String   READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
ACCOUNT_MAPPING   WHERE   accountMappingUpdatedAt=:accountMappingUpdatedAt   AND   accountmappingStatus<>'DELETED'
""";



private   AccountMappingQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
