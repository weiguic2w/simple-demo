package com.wcw.example.model.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChuangWeiwei;
 * @create 2023.01.16  10:33;
 */
@Data
public class AuthParamDto {
    private String username;
    private String password;
    private String number;//手机号
    private String checkCode;//验证码
    private String checkCodeKey;//验证码key
    private String authType; // 认证的类型   password:用户名密码模式类型    sms:短信模式类型
    private Map<String, Object> payload = new HashMap<>();//附加数据，作为扩展，不同认证类型可拥有不同的附加数据。如认证类型为短信时包含smsKey : sms:3d21042d054548b08477142bbca95cfa; 所有情况下都包含clientId

}
