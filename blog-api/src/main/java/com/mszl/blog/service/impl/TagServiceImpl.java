package com.mszl.blog.service.impl;

import com.mszl.blog.dao.mapper.TagMapper;
import com.mszl.blog.dao.pojo.Tag;
import com.mszl.blog.service.TagService;
import com.mszl.blog.vo.Result;
import com.mszl.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    public  TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }

    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag:tagList){
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        //mybatisPlus无法进行多表查询
        List<Tag> tags = tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
//        return null;
    }

    @Override
    public Result hots(int limit) {
        /**
         * 1、标签所拥有的文章数量最多  最热标签
         * 2、查询 根据tag_id 分组 计数，从大到小排列 limit个
         */
        List<Long> tagIds = tagMapper.findHotsTagIds(limit);
        if (CollectionUtils.isEmpty(tagIds)){
            return Result.success(Collections.emptyList());
        }
        //需求的是 tagId 和 tagName  Tag对象
        //select * from tag where id in (1,2,3,...)
        List<Tag> tagList = tagMapper.findTagsByTagIds(tagIds);
        return Result.success(tagList);
    }
}
