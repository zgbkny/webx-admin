package com.alibaba.webx.adminx.dal.dao.mongo;

import com.alibaba.webx.adminx.dal.dao.BlogDao;
import com.alibaba.webx.adminx.dal.dataobject.Blog;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;

/**
 * Created by wei on 2016/5/24.
 */
public class MongoBlogDao implements BlogDao {

    public static MongoDatabase getMongoDb() {
        MongoDatabase mongoDatabase = null;
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "192.168.80.128" , 27017 );

            // 连接到数据库
            mongoDatabase = mongoClient.getDatabase("adminx");

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return mongoDatabase;
    }

    public List<String> getBlogsByKey(String key) {
        List<String> list = new ArrayList<String>();
        MongoDatabase mongoDatabase = getMongoDb();
        MongoCollection<Document> collection = mongoDatabase.getCollection("blog");
        System.out.println("集合 选择成功" + collection);

        //检索所有文档
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while(mongoCursor.hasNext()) {
            list.add(String.valueOf(mongoCursor.next()));
        }
        return list;
    }
}
