package com.noahw.platform.util;

import com.noahw.platform.base.BaseResult;
import com.noahw.platform.constants.ResultConstant;

/**

* @Description:    通用工具类

* @Author:         noahw

* @CreateDate:     2019-01-14 13:25

* @Version:        1.0

*/
public class CommonUtil {

    public static BaseResult initErrorResult(String desc){
        return new BaseResult(ResultConstant.RESULTCODE_FAIL, desc);
    }

    public static BaseResult updateErrorResult(BaseResult result, String desc){
        result.setResultCode(ResultConstant.RESULTCODE_FAIL);
        result.setDesc(desc);

        return result;
    }
}
