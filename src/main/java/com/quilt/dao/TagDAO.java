package com.quilt.dao;

import com.quilt.entity.Tag;

import java.util.List;

public interface TagDAO {
    /**
     * 
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 
     */
    int insert(Tag record);

    /**
     * 
     */
    int insertSelective(Tag record);

    /**
     * 
     */
    Tag selectByPrimaryKey(Integer id);

    /**
     * 
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * 
     */
    int updateByPrimaryKey(Tag record);


    List<Tag> getAllTags();

    int getTagCount();


}