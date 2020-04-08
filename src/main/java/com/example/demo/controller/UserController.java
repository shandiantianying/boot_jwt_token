package com.example.demo.controller;


import cn.hutool.json.JSONObject;
import com.example.demo.config.JwtConfig;
import com.example.demo.entity.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("users")
public class UserController {
    @Resource
    private JwtConfig jwtConfig;

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUserInfo() {

        return "getUser: admin";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object getUserInfo(String username) {
        JSONObject json = new JSONObject();

        /** 验证userName，passWord和数据库中是否一致，如不一致，直接return ResultTool.errer(); 【这里省略该步骤】*/

        // 这里模拟通过用户名和密码，从数据库查询userId
        // 这里把userId转为String类型，实际开发中如果subject需要存userId，则可以JwtConfig的createToken方法的参数设置为Long类型
        String userId = 5 + "";
        String token = jwtConfig.createToken(userId);
        if (!StringUtils.isEmpty(token)) {
            json.put("token", token);
        }
//        return json;
        return ResultInfo.success(json, "访问成功!");
    }

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Object getUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        String usernameFromToken = jwtConfig.getUsernameFromToken(token);
        return ResultInfo.success(usernameFromToken, "访问成功!");
//        return usernameFromToken;
    }

    @RequestMapping("/refershToken")
    @ResponseBody
    public Object getrefershToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        String usernameFromToken = jwtConfig.getUsernameFromToken(token);
        if (StringUtils.isEmpty(token)) {
            return ResultInfo.error(null, "刷新token失败");
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("token", jwtConfig.createToken("userId"));
            return ResultInfo.success(map, "刷新token成功!");
        }
//        return usernameFromToken;
    }

}
