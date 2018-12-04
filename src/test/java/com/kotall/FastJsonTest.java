package com.kotall;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class FastJsonTest {

    @Test
    public void testJson() {

        String str = "{\"brandId\":1,\"brief\":\"测试\",\"categoryId\":1,\"counterPrice\":9,\"detail\":\"111<p><img src=\\\\'https://kotallmall.oss-cn-hangzhou.aliyuncs.com/aliyun/20181130/98aeefdea5ea4b8db40387b1d9dd5fb8.jpg\\\\' style=\\\\'max-width:100%;\\\\'><br></p>\",\"gallery\":\"\",\"goodsSn\":\"1\",\"id\":1181003,\"isHot\":0,\"isNew\":0,\"isOnSale\":false,\"keywords\":\"测试\",\"name\":\"TEST\",\"picUrl\":\"\",\"retailPrice\":10,\"storeId\":1,\"unit\":\"件\"}";
        Object obj = JSONObject.parse(str);
    }
}
