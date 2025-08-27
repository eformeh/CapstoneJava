
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   ExpenseClaimQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   SET   expenseclaimStatus   =   'DELETED',   expenseclaimUpdatedAt   =   GETDATE() 
WHERE   expenseClaimId=:expenseClaimId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   WHERE   expenseclaimStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM(

 expenseClaimDecisionDate,
 expenseClaimEmployeeId,
 expenseClaimReimbursementDate,
 expenseClaimReviewerId,
 expenseClaimTotalAmount,
expenseClaimStatus,
expenseClaimCreatedAt,
expenseClaimUpdatedAt
)   VALUES   (

 :expenseClaimDecisionDate,
 :expenseClaimEmployeeId,
 :expenseClaimReimbursementDate,
 :expenseClaimReviewerId,
 :expenseClaimTotalAmount,
 COALESCE(:expenseClaimStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   SET

 expenseClaimDecisionDate = :expenseClaimDecisionDate,
 expenseClaimEmployeeId = :expenseClaimEmployeeId,
 expenseClaimReimbursementDate = :expenseClaimReimbursementDate,
 expenseClaimReviewerId = :expenseClaimReviewerId,
 expenseClaimTotalAmount = :expenseClaimTotalAmount,
 expenseClaimStatus=:userStatus,
 expenseClaimUpdatedAt = GETDATE()
WHERE   expenseClaimId=:expenseClaimId
""";


public   static   final   String   READ_BY_EXPENSE_CLAIM_EXPENSECLAIMCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   WHERE   expenseClaimCreatedAt=:expenseClaimCreatedAt   AND   expenseclaimStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_CLAIM_EXPENSECLAIMDECISIONDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   WHERE   expenseClaimDecisionDate=:expenseClaimDecisionDate   AND   expenseclaimStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_CLAIM_EXPENSECLAIMEMPLOYEEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   WHERE   expenseClaimEmployeeId=:expenseClaimEmployeeId   AND   expenseclaimStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_CLAIM_EXPENSECLAIMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   WHERE   expenseClaimId=:expenseClaimId   AND   expenseclaimStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_CLAIM_EXPENSECLAIMREIMBURSEMENTDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   WHERE   expenseClaimReimbursementDate=:expenseClaimReimbursementDate   AND   expenseclaimStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_CLAIM_EXPENSECLAIMREVIEWERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   WHERE   expenseClaimReviewerId=:expenseClaimReviewerId   AND   expenseclaimStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_CLAIM_EXPENSECLAIMSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   WHERE   expenseClaimStatus=:expenseClaimStatus   AND   expenseclaimStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_CLAIM_EXPENSECLAIMTOTALAMOUNT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   WHERE   expenseClaimTotalAmount=:expenseClaimTotalAmount   AND   expenseclaimStatus<>'DELETED'
""";

public   static   final   String   READ_BY_EXPENSE_CLAIM_EXPENSECLAIMUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
EXPENSE_CLAIM   WHERE   expenseClaimUpdatedAt=:expenseClaimUpdatedAt   AND   expenseclaimStatus<>'DELETED'
""";



private   ExpenseClaimQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
