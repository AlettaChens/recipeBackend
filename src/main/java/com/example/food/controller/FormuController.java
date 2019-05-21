package com.example.food.controller;


import com.example.food.entity.Formu;
import com.example.food.entity.Image;
import com.example.food.entity.Talk;
import com.example.food.service.FormuService;
import com.example.food.service.ImageService;
import com.example.food.service.StarService;
import com.example.food.utils.FileUploadUtils;
import com.example.food.utils.ResultMap;
import com.example.food.utils.UUIDutils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("formu")
@Api(value = "论坛接口", description = "论坛接口")
public class FormuController {

    @Resource
    private FormuService formuService;

    @Resource
    private ImageService imageService;

    @Resource
    private StarService starService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "论坛言论发布接口", notes = "论坛言论发布接口")
    public ResultMap publish(String content, String userName, String userAvatar, HttpServletRequest request) throws Exception {
        List<MultipartFile> pictures = ((MultipartHttpServletRequest) request).getFiles("file");
        long forumId = UUIDutils.getLongUUID();
        if (formuService.publish(forumId, content, userName, userAvatar) == 1) {
            for (int i = 0; i < pictures.size(); i++) {
                long imageID = UUIDutils.getLongUUID();
                imageService.publish(imageID, forumId, FileUploadUtils.upLoadPicture(pictures.get(i), "file/sharePicture", request));
            }
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "searchAll", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有论坛条目", notes = "获取所有论坛条目")
    public ResultMap searchAll(long userId) {
        List<Talk> talkList = new ArrayList<>();
        List<Formu> formuList = formuService.searchAll();
        if (formuList != null) {
            for (Formu formu : formuList) {
                if (starService.search(formu.getId(), userId) != null) {
                    formu.setIsCheck(1);
                }
                List<Image> images = imageService.searchAll(formu.getId());
                talkList.add(new Talk(formu, images));
            }
            return ResultMap.ok(talkList);
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "更新点赞数量", notes = "更新点赞数量")
    @RequestMapping(value = "updateStar", method = RequestMethod.POST)
    public ResultMap updateStar(long forumId, long userId, String updateType) {
        int star;
        int currentStar = formuService.getStarById(forumId);
        if (updateType.equals("增加")) {
            star = currentStar + 1;
            starService.publish(forumId, userId);
        } else {
            star = currentStar - 1;
            starService.delete(forumId, userId);
        }
        if (formuService.updateStar(star, forumId) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }
}
