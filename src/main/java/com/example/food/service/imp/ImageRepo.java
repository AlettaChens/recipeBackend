package com.example.food.service.imp;



import com.example.food.entity.Image;
import com.example.food.mapper.ImageMapper;
import com.example.food.service.ImageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ImageRepo implements ImageService {

    @Resource
    private ImageMapper imageMapper;

    @Override
    public int publish(long id,long forumId, String pictureURL) {
        return imageMapper.publish(id,forumId,pictureURL);
    }

    @Override
    public List<Image> searchAll(long forumId) {
        return imageMapper.searchAll(forumId);
    }
}
