package com.dao;

import com.entity.DiscusswenbenziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusswenbenziyuanVO;
import com.entity.view.DiscusswenbenziyuanView;


/**
 * 文本资源评论表
 * 
 * @author 
 * @email 
 * @date 2025-03-29 21:36:17
 */
public interface DiscusswenbenziyuanDao extends BaseMapper<DiscusswenbenziyuanEntity> {
	
	List<DiscusswenbenziyuanVO> selectListVO(@Param("ew") Wrapper<DiscusswenbenziyuanEntity> wrapper);
	
	DiscusswenbenziyuanVO selectVO(@Param("ew") Wrapper<DiscusswenbenziyuanEntity> wrapper);
	
	List<DiscusswenbenziyuanView> selectListView(@Param("ew") Wrapper<DiscusswenbenziyuanEntity> wrapper);

	List<DiscusswenbenziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusswenbenziyuanEntity> wrapper);

	
	DiscusswenbenziyuanView selectView(@Param("ew") Wrapper<DiscusswenbenziyuanEntity> wrapper);
	

}
