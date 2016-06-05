package com.alibaba.webx.adminx.dal.dao.mongo;

import com.alibaba.webx.adminx.dal.dao.BlogDao;
import com.alibaba.webx.adminx.dal.dataobject.Blog;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by wei on 2016/5/24.
 */
public class MongoBlogDao implements BlogDao {

    public static MongoDatabase getMongoDb() {
        MongoDatabase mongoDatabase = null;
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            mongoDatabase = mongoClient.getDatabase("adminx");
            MongoCollection<Document> collection = mongoDatabase.getCollection("blog");
            if (collection == null) {
                mongoDatabase.createCollection("blog");
                collection = mongoDatabase.getCollection("blog");
            }

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return mongoDatabase;
    }

    public List<Blog> getBlogsByKey(String key) {

        List<Blog> list = new ArrayList<Blog>();
        Blog blog = new Blog();
        blog.setName("this is the mongoblogdao test");
        return null;
    }
}
