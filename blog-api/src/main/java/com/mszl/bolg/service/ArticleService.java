package com.mszl.bolg.service;

import com.mszl.bolg.vo.Result;
import com.mszl.bolg.vo.params.PageParams;

public interface ArticleService {
    /**
     * 分页查询 文章列表
     * @param pageParams
     * @return
     */
    Result listArticle(PageParams pageParams);
}
