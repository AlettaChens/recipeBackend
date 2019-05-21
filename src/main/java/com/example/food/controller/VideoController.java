package com.example.food.controller;

import com.example.food.service.VideoService;
import com.example.food.utils.FileUploadUtils;
import com.example.food.utils.ResultMap;
import com.example.food.utils.UUIDutils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("video")
@Api(value = "视频教程接口", description = "视频教程接口")
public class VideoController {
    @Resource
    private VideoService videoService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "视频教程发布接口", notes = "视频教程发布接口")
    public ResultMap publish(String title, @Param(value = "file") MultipartFile file, HttpServletRequest request) throws IOException {
        long UUID= UUIDutils.getLongUUID();
        if (videoService.publish(UUID,title, FileUploadUtils.upLoadPicture(file,"upload/video",request)) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }


    @RequestMapping(value = "searchAll", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有视频教程", notes = "获取所有视频教程")
    public ResultMap searchAll(String active) {
        if (videoService.searchAll(active) != null) {
            return ResultMap.ok(videoService.searchAll(active));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "updateState", method = RequestMethod.POST)
    @ApiOperation(value = "更新视频状态", notes = "更新视频状态")
    public ResultMap updateState(String state, long id) {
        if (videoService.updateStatue(state, id) != 0) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }
}
