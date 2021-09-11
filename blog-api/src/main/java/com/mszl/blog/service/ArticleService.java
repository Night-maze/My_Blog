package com.mszl.blog.service;

import com.mszl.blog.vo.Result;
import com.mszl.blog.vo.params.PageParams;

public interface ArticleService {
    /**
     * 分页查询 文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);
}
