package com.mszl.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mszl.blog.dao.mapper.ArticleMapper;
import com.mszl.blog.dao.pojo.Article;
import com.mszl.blog.service.ArticleService;
import com.mszl.blog.service.SysUserService;
import com.mszl.blog.service.TagService;
import com.mszl.blog.vo.ArticleVo;
import com.mszl.blog.vo.Result;
import com.mszl.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public Result listArticle(PageParams pageParams) {
        /**
         * 1、分页查询article数据库表
         */
        Page<Article> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //是否置顶排序
        // order by create_date desc 时间排序
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);

        Page<Article> articlePage = articleMapper.selectPage(page,queryWrapper);
        List<Article> records = articlePage.getRecords();
        //能直接返回吗？很明显不能
        List<ArticleVo> articleVoList=  copyList(records,true,true);

        return Result.success(articleVoList);
    }

    private List<ArticleVo> copyList(List<Article> records,boolean isTag,boolean isAuthor){
        List<ArticleVo> articleVoList = new ArrayList<>();
        for(Article record:records){
            articleVoList.add(copy(record,isTag,isAuthor));
        }
        return articleVoList;
    }

    private ArticleVo copy(Article article,boolean isTag,boolean isAuthor){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article,articleVo);
        //时间格式不匹配，手动转
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        //并不是所有的接口 都需要标签、作者信息
        if(isTag){
            Long articleId = article.getId();
//            articleVo.setTags(tagService.findTagsByArticleId(articleId));
            articleVo.setTags(tagService.findTagsByArticleId(articleId));
        }
        if(isAuthor){
            Long authorID = article.getAuthorId();
            articleVo.setAuthor(sysUserService.findUserById(authorID).getNickname());
        }
        return articleVo;
    }
}
