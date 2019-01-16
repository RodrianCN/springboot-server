package com.noahw.platform.util;

import com.noahw.platform.base.BaseResult;
import com.noahw.platform.constants.CommonConstant;

/**

* @Description:    通用工具类

* @Author:         noahw

* @CreateDate:     2019-01-14 13:25

* @Version:        1.0

*/
public class CommonUtil {

    public static BaseResult initErrorResult(String desc){
        return new BaseResult(CommonConstant.INTERNAL_ERROR_RESP_CODE, desc);
    }

    public static void updateErrorResult(BaseResult result, String desc){
        result.setResultCode(CommonConstant.INTERNAL_ERROR_RESP_CODE);
        result.setDesc(desc);
    }
}
