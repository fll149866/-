package com.nysb.demo01.controller;

import cn.hutool.core.util.StrUtil;
import com.nysb.demo01.entity.User;
import com.nysb.demo01.entity.request.LoginRequest;
import com.nysb.demo01.service.UserService;
import com.nysb.demo01.utils.JsonData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String,String> userInfo){
        int rows = userService.save(userInfo);

        return rows==1 ? JsonData.buildSuccess(userInfo):JsonData.buildError("创建失败");
    }

    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){
        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(),loginRequest.getPwd());

        return StrUtil.isEmpty(token)? JsonData.buildError("用户名或密码出错"):JsonData.buildSuccess(token);
    }

    @GetMapping("find_by_token")
    public JsonData findById(HttpServletRequest request){
        String userId = (String)request.getAttribute("user_id");
        System.out.println(userId);
        if(userId == null){
            return JsonData.buildError("查询失败");
        }

        User user = userService.findByUserId(userId);
        return JsonData.buildSuccess(user);

    }
}
