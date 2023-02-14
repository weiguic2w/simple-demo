package com.wcw.example.service;

import com.wcw.example.model.dto.AuthParamDto;
import com.wcw.example.model.pojo.User;

/**
 * @author ChuangWeiwei;
 * @create 2023.02.14  10:41;
 */
public interface AuthService {
    User execute(AuthParamDto authParamDto);
}
