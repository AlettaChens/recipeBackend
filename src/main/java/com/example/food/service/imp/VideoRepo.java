package com.example.food.service.imp;

import com.example.food.entity.Video;
import com.example.food.mapper.VideoMapper;
import com.example.food.service.VideoService;
import com.example.food.utils.DateUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class VideoRepo implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    @Override
    public int publish(long id, String title, String videoURL) {
        return videoMapper.publish(id, title, videoURL, DateUtils.getCurrentStringDate(), "待验证");
    }

    @Override
    public List<Video> searchAll(String active) {
        return videoMapper.searchAll(active);
    }


    @Override
    public int updateStatue(String statue, long id) {
        return videoMapper.updateStatue(statue, id);
    }
}
