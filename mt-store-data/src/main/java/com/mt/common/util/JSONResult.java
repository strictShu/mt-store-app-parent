package com.mt.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  成功:     code:200成功  msg: "..."  data:数据
 *  失败:     code:非200   msg: 描述信息  data:null
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JSONResult {

    // 响应业务状态
    private Integer code;

    // 响应消息提示
    private String msg;

    // 响应中的数据
    private Object data;



    public static JSONResult error(String msg) {
        return new JSONResult(400,msg, null);
    }


    public static JSONResult success() {
        return new JSONResult(200, "success", null);
    }

    public static JSONResult success(Object data) {
        return new JSONResult(200, "success", data);
    }


    public static JSONResult success(String msg, Object data) {
        return new JSONResult(200, msg, data);
    }
}


