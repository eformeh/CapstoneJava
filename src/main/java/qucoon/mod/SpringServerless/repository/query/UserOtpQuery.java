
package   qucoon.mod.SpringServerless.repository.query;

import   qucoon.mod.SpringServerless.utility.constant.PrefixConstant;


public   class   UserOtpQuery   {


public   static   final   String   DELETE   =   """
Update """ + PrefixConstant.ENTITY + """
USER_OTP   SET   userotpStatus   =   'DELETED',   userotpUpdatedAt   =   GETDATE() 
WHERE   userOtpId=:userOtpId
""";


public   static   final   String   TRUNCATE   =   """
TRUNCATE   TABLE   """ + PrefixConstant.ENTITY + """
USER_OTP
""";


public   static   final   String   READ   =   """
SELECT   *   FROM      """ + PrefixConstant.ENTITY + """
USER_OTP   WHERE   userotpStatus<>'DELETED'
""";


public   static   final   String   INSERT   =   """
INSERT   INTO   """ + PrefixConstant.ENTITY + """
USER_OTP(

 userOtpOtp,
 userOtpUsername,
userOtpStatus,
userOtpCreatedAt,
userOtpUpdatedAt
)   VALUES   (

 :userOtpOtp,
 :userOtpUsername,
 COALESCE(:userOtpStatus,'ACTIVE'),
 GETDATE(),
 GETDATE()
)
""";


public   static   final   String   UPDATE   =   """
Update """ + PrefixConstant.ENTITY + """
USER_OTP   SET

 userOtpOtp = :userOtpOtp,
 userOtpUsername = :userOtpUsername,
 userOtpStatus=:userStatus,
 userOtpUpdatedAt = GETDATE()
WHERE   userOtpId=:userOtpId
""";


public   static   final   String   READ_BY_USER_OTP_USEROTPCREATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER_OTP   WHERE   userOtpCreatedAt=:userOtpCreatedAt   AND   userotpStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_OTP_USEROTPID  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER_OTP   WHERE   userOtpId=:userOtpId   AND   userotpStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_OTP_USEROTPOTP  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER_OTP   WHERE   userOtpOtp=:userOtpOtp   AND   userotpStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_OTP_USEROTPSTATUS  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER_OTP   WHERE   userOtpStatus=:userOtpStatus   AND   userotpStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_OTP_USEROTPUPDATEDAT  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER_OTP   WHERE   userOtpUpdatedAt=:userOtpUpdatedAt   AND   userotpStatus<>'DELETED'
""";

public   static   final   String   READ_BY_USER_OTP_USEROTPUSERNAME  =  """
SELECT   *   FROM   """ + PrefixConstant.ENTITY + """
USER_OTP   WHERE   userOtpUsername=:userOtpUsername   AND   userotpStatus<>'DELETED'
""";



private   UserOtpQuery()   {
//   Private   constructor   to   prevent   instantiation
}
}
