package com.mszl.bolg.dao.pojo;

public class Article {
    public static  final int Article_TOP = 1;
    public static final int Article_COMMON = 0;
    private Long id;
    private String title;
    private String summary;
    private int commentCounts;
    private int viewCounts;

    /*
    * 作者id
    * */
    private Long authorId;
}
