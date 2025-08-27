
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   ExpenseItemQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   SET   expenseitemStatus   =   'DELETED',   expenseitemUpdatedAt   =   GETDATE() 
WHERE   expenseItemId=:expenseItemId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   WHERE   expenseitemStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM(

 expenseItemAmount,
 expenseItemCategory,
 expenseItemClaimId,
 expenseItemDescription,
 expenseItemReceiptUrl,
expenseItemStatus,
expenseItemCreatedAt,
expenseItemUpdatedAt
)   VALUES   (

 :expenseItemAmount,
 :expenseItemCategory,
 :expenseItemClaimId,
 :expenseItemDescription,
 :expenseItemReceiptUrl,
 COALESCE(:expenseItemStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   SET

 expenseItemAmount = :expenseItemAmount,
 expenseItemCategory = :expenseItemCategory,
 expenseItemClaimId = :expenseItemClaimId,
 expenseItemDescription = :expenseItemDescription,
 expenseItemReceiptUrl = :expenseItemReceiptUrl,
 expenseItemStatus=:userStatus,
 expenseItemUpdatedAt = GETDATE()
WHERE   expenseItemId=:expenseItemId
""";


public   static   final   String   READ_BY_EXPENSE_ITEM_EXPENSEITEMAMOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   WHERE   expenseItemAmount=:expenseItemAmount   AND   expenseitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_ITEM_EXPENSEITEMCATEGORY  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   WHERE   expenseItemCategory=:expenseItemCategory   AND   expenseitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_ITEM_EXPENSEITEMCLAIMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   WHERE   expenseItemClaimId=:expenseItemClaimId   AND   expenseitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_ITEM_EXPENSEITEMCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   WHERE   expenseItemCreatedAt=:expenseItemCreatedAt   AND   expenseitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_ITEM_EXPENSEITEMDESCRIPTION  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   WHERE   expenseItemDescription=:expenseItemDescription   AND   expenseitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_ITEM_EXPENSEITEMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   WHERE   expenseItemId=:expenseItemId   AND   expenseitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_ITEM_EXPENSEITEMRECEIPTURL  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   WHERE   expenseItemReceiptUrl=:expenseItemReceiptUrl   AND   expenseitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_ITEM_EXPENSEITEMSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   WHERE   expenseItemStatus=:expenseItemStatus   AND   expenseitemStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_ITEM_EXPENSEITEMUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_ITEM   WHERE   expenseItemUpdatedAt=:expenseItemUpdatedAt   AND   expenseitemStatus<>'DELETED'
""";



private   ExpenseItemQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
