package com.dao;

import com.entity.DiscussshipinziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshipinziyuanVO;
import com.entity.view.DiscussshipinziyuanView;


/**
 * 视频资源评论表
 * 
 * @author 
 * @email 
 * @date 2025-03-29 21:36:17
 */
public interface DiscussshipinziyuanDao extends BaseMapper<DiscussshipinziyuanEntity> {
	
	List<DiscussshipinziyuanVO> selectListVO(@Param("ew") Wrapper<DiscussshipinziyuanEntity> wrapper);
	
	DiscussshipinziyuanVO selectVO(@Param("ew") Wrapper<DiscussshipinziyuanEntity> wrapper);
	
	List<DiscussshipinziyuanView> selectListView(@Param("ew") Wrapper<DiscussshipinziyuanEntity> wrapper);

	List<DiscussshipinziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshipinziyuanEntity> wrapper);

	
	DiscussshipinziyuanView selectView(@Param("ew") Wrapper<DiscussshipinziyuanEntity> wrapper);
	

}
