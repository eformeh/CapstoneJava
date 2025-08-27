
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   AppraisalQuestionQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   SET   appraisalquestionStatus   =   'DELETED',   appraisalquestionUpdatedAt   =   GETDATE() 
WHERE   appraisalQuestionId=:appraisalQuestionId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   WHERE   appraisalquestionStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION(

 appraisalFormId,
 appraisalQuestionText,
 appraisalQuestionType,
 appraisalQuestionWeight,
appraisalQuestionStatus,
appraisalQuestionCreatedAt,
appraisalQuestionUpdatedAt
)   VALUES   (

 :appraisalFormId,
 :appraisalQuestionText,
 :appraisalQuestionType,
 :appraisalQuestionWeight,
 COALESCE(:appraisalQuestionStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   SET

 appraisalFormId = :appraisalFormId,
 appraisalQuestionText = :appraisalQuestionText,
 appraisalQuestionType = :appraisalQuestionType,
 appraisalQuestionWeight = :appraisalQuestionWeight,
 appraisalQuestionStatus=:userStatus,
 appraisalQuestionUpdatedAt = GETDATE()
WHERE   appraisalQuestionId=:appraisalQuestionId
""";


public   static   final   String   READ_BY_APPRAISAL_QUESTION_APPRAISALFORMID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   WHERE   appraisalFormId=:appraisalFormId   AND   appraisalquestionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   WHERE   appraisalQuestionCreatedAt=:appraisalQuestionCreatedAt   AND   appraisalquestionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   WHERE   appraisalQuestionId=:appraisalQuestionId   AND   appraisalquestionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   WHERE   appraisalQuestionStatus=:appraisalQuestionStatus   AND   appraisalquestionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONTEXT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   WHERE   appraisalQuestionText=:appraisalQuestionText   AND   appraisalquestionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONTYPE  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   WHERE   appraisalQuestionType=:appraisalQuestionType   AND   appraisalquestionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   WHERE   appraisalQuestionUpdatedAt=:appraisalQuestionUpdatedAt   AND   appraisalquestionStatus<>'DELETED'
""";

public   static   final   String   READ_BY_APPRAISAL_QUESTION_APPRAISALQUESTIONWEIGHT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
APPRAISAL_QUESTION   WHERE   appraisalQuestionWeight=:appraisalQuestionWeight   AND   appraisalquestionStatus<>'DELETED'
""";



private   AppraisalQuestionQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
