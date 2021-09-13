package com.mszl.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszl.blog.dao.pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 根据本章Id查询标签列表
     * @param articleId
     * @return
     */
    List<Tag> findTagsByArticleId(Long articleId);

    /**
     * 查询最热的标签 前n条
     * @param limit
     * @return
     */
    List<Long> findHotsTagIds(int limit);

    List<Tag> findTagsByTagIds(List<Long> tagIds);
}
