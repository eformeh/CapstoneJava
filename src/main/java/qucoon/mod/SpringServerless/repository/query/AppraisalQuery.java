
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   AppraisalQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
APPRAISAL   SET   appraisalStatus   =   'DELETED',   appraisalUpdatedAt   =   GETDATE() 
WHERE   appraisalId=:appraisalId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
APPRAISAL
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
APPRAISAL(

 appraisalDate,
 appraisalEmployeeIdRoleId,
 appraisalFormId,
 appraisalGeneralFeedback,
 appraisalOverallScore,
 appraisalReviewerId,
appraisalStatus,
appraisalCreatedAt,
appraisalUpdatedAt
)   VALUES   (

 :appraisalDate,
 :appraisalEmployeeIdRoleId,
 :appraisalFormId,
 :appraisalGeneralFeedback,
 :appraisalOverallScore,
 :appraisalReviewerId,
 COALESCE(:appraisalStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
APPRAISAL   SET

 appraisalDate = :appraisalDate,
 appraisalEmployeeIdRoleId = :appraisalEmployeeIdRoleId,
 appraisalFormId = :appraisalFormId,
 appraisalGeneralFeedback = :appraisalGeneralFeedback,
 appraisalOverallScore = :appraisalOverallScore,
 appraisalReviewerId = :appraisalReviewerId,
 appraisalStatus=:userStatus,
 appraisalUpdatedAt = GETDATE()
WHERE   appraisalId=:appraisalId
""";


public   static   final   String   READ_BY_APPRAISAL_APPRAISALCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalCreatedAt=:appraisalCreatedAt   AND   appraisalStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_APPRAISALDATE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalDate=:appraisalDate   AND   appraisalStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_APPRAISALEMPLOYEEIDROLEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalEmployeeIdRoleId=:appraisalEmployeeIdRoleId   AND   appraisalStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_APPRAISALFORMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalFormId=:appraisalFormId   AND   appraisalStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_APPRAISALGENERALFEEDBACK  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalGeneralFeedback=:appraisalGeneralFeedback   AND   appraisalStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_APPRAISALID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalId=:appraisalId   AND   appraisalStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_APPRAISALOVERALLSCORE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalOverallScore=:appraisalOverallScore   AND   appraisalStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_APPRAISALREVIEWERID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalReviewerId=:appraisalReviewerId   AND   appraisalStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_APPRAISALSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalStatus=:appraisalStatus   AND   appraisalStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_APPRAISALUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL   WHERE   appraisalUpdatedAt=:appraisalUpdatedAt   AND   appraisalStatus<>'DELETED'
""";



private   AppraisalQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
