package com.example.food.controller;


import com.example.food.service.HistoryService;
import com.example.food.utils.ResultMap;
import com.example.food.utils.UUIDutils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("history")
@Api(value = "历史接口", description = "历史接口")
public class HistoryController {

    @Resource
    private HistoryService historyService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "添加历史", notes = "添加历史")
    public ResultMap publish( long recipeId, long userId) {
        long UUID= UUIDutils.getLongUUID();
        if (historyService.publish(UUID,recipeId,userId) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }
}
