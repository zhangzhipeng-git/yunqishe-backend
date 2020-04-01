package com.zx.yunqishe.dao;

import com.zx.yunqishe.entity.TopicContent;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface TopicContentMapper extends Mapper<TopicContent> , UpdateThumbCommonMapper{
    /**
     * 查询话题内容列表
     * @param map
     * @return
     */
    List<TopicContent> selectTopicContentList(Map<String, Object> map);

    /**
     * 根据id批量更新话题内容
     * @param topicContents
     */
    void batchUpdateTopicContent(@Param(value = "contents") List<TopicContent> topicContents);

    /**
     * 获取论坛首部右侧tab中帖子列表
     * @param wt 0-非问题（论坛）1-问题（问云）
     * @param type 1-近期，2-热门，3-随机
     * @param tid - 所属话题id
     * @return
     */
    List<TopicContent> fSelectList(@Param("wt") Byte wt, @Param("type") Integer type, @Param("tid") Integer tid);

    /**
     * 前台根据帖子id查帖子详情
     * @param id
     * @return
     */
    TopicContent fSelectOne(@Param("id") Integer id, @Param("uid") Integer uid);

    /**
     * 回复内容+1
     * @param id
     */
    void updateCommentCountAddOneById(Integer id);

    /**
     * 取消或关注话题内容
     * @param oid
     * @param value
     */
    void updateConcernAddValueById(@Param("id") Integer oid, @Param("value") Integer value);

    /**
     * 更新浏览次数
     * @param id
     * @param i
     */
    void updateViewAddValueById(@Param("id") Integer id, @Param("value") int i);
}