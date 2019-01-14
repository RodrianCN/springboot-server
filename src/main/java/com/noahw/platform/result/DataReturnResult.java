package com.noahw.platform.result;

import com.noahw.platform.base.BaseResult;

/**

* @Description:    统一返回数据Result

* @Author:         noahw

* @CreateDate:     2019-01-11 9:41

* @Version:        1.0

*/
public class DataReturnResult extends BaseResult {
    private Object data;

    public DataReturnResult(Object data){
        super();
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
