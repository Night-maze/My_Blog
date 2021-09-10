package com.mszl.bolg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszl.bolg.dao.mapper.ArticleMapper;
import com.mszl.bolg.dao.pojo.Article;
import com.mszl.bolg.service.ArticleService;
import com.mszl.bolg.vo.Result;
import com.mszl.bolg.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Result listArticle(PageParams pageParams) {
        /**
         * 1、分页查询article数据库表
         */
        Page<Article> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //是否置顶排序
        queryWrapper.orderByDesc(Article::getWeight);
        //order by create_date desc 时间排序
        queryWrapper.orderByDesc(Article::getCreateDate);

        articleMapper.selectPage(page,queryWrapper);
        return null;
    }
}
