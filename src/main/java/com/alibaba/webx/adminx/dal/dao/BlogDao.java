package com.alibaba.webx.adminx.dal.dao;

import com.alibaba.webx.adminx.dal.dataobject.Blog;

import java.util.List;

/**
 * Created by wei on 2016/5/24.
 */
public interface BlogDao {
    List<String> getBlogsByKey(String key);
}
