package com.example.food.controller;


import com.example.food.service.UserService;
import com.example.food.utils.FileUploadUtils;
import com.example.food.utils.ResultMap;
import com.example.food.utils.UUIDutils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "user")
@Api(value = "用户接口", description = "用户接口")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultMap register(String nickname, String password, String userType) {
        if (userService.login(nickname, password, userType) == null) {
            long UUID = UUIDutils.getLongUUID();
            if (userService.register(UUID, nickname, password, userType) == 1) {
                return ResultMap.ok(null);
            }
        }
        return ResultMap.fail("注册失败或者用户已存在");
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultMap login(String nickname, String password, String userType) {
        if (userService.login(nickname, password, userType) != null) {
            return ResultMap.ok(userService.login(nickname, password, userType));
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "用户头像修改", notes = "用户头像修改")
    @RequestMapping(value = "avatar", method = RequestMethod.POST)
    public ResultMap uploadImg(@RequestParam("file") MultipartFile file, long userId,
                               HttpServletRequest request) throws Exception {
        String url = FileUploadUtils.upLoadPicture(file, "file/user", request);
        if (userService.updateURL(url, userId) == 1) {
            return ResultMap.ok(url);
        }
        return ResultMap.fail(null);
    }

}
