package com.noahw.platform.util;

import com.alibaba.fastjson.JSON;

/**

* @Description:    Json工具包

* @Author:         noahw

* @CreateDate:     2019-01-11 9:47

* @Version:        1.0

*/
public class JsonUtil {
    public static String Object2JsonString(Object object){
        return JSON.toJSONString(object);
    }
}
