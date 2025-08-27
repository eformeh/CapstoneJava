
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   AppraisalResponseQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   SET   appraisalresponseStatus   =   'DELETED',   appraisalresponseUpdatedAt   =   GETDATE() 
WHERE   appraisalResponseId=:appraisalResponseId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   WHERE   appraisalresponseStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE(

 appraisalResponseAppraisalId,
 appraisalResponseQuestionId,
 appraisalResponseScore,
 appraisalResponseValue,
appraisalResponseStatus,
appraisalResponseCreatedAt,
appraisalResponseUpdatedAt
)   VALUES   (

 :appraisalResponseAppraisalId,
 :appraisalResponseQuestionId,
 :appraisalResponseScore,
 :appraisalResponseValue,
 COALESCE(:appraisalResponseStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   SET

 appraisalResponseAppraisalId = :appraisalResponseAppraisalId,
 appraisalResponseQuestionId = :appraisalResponseQuestionId,
 appraisalResponseScore = :appraisalResponseScore,
 appraisalResponseValue = :appraisalResponseValue,
 appraisalResponseStatus=:userStatus,
 appraisalResponseUpdatedAt = GETDATE()
WHERE   appraisalResponseId=:appraisalResponseId
""";


public   static   final   String   READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSEAPPRAISALID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   WHERE   appraisalResponseAppraisalId=:appraisalResponseAppraisalId   AND   appraisalresponseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSECREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   WHERE   appraisalResponseCreatedAt=:appraisalResponseCreatedAt   AND   appraisalresponseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSEID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   WHERE   appraisalResponseId=:appraisalResponseId   AND   appraisalresponseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSEQUESTIONID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   WHERE   appraisalResponseQuestionId=:appraisalResponseQuestionId   AND   appraisalresponseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSESCORE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   WHERE   appraisalResponseScore=:appraisalResponseScore   AND   appraisalresponseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSESTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   WHERE   appraisalResponseStatus=:appraisalResponseStatus   AND   appraisalresponseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSEUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   WHERE   appraisalResponseUpdatedAt=:appraisalResponseUpdatedAt   AND   appraisalresponseStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_RESPONSE_APPRAISALRESPONSEVALUE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_RESPONSE   WHERE   appraisalResponseValue=:appraisalResponseValue   AND   appraisalresponseStatus<>'DELETED'
""";



private   AppraisalResponseQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
