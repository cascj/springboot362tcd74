package com.dao;

import com.entity.ChapterkechengziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChapterkechengziyuanVO;
import com.entity.view.ChapterkechengziyuanView;


/**
 * 课程资源章节表
 * 
 * @author 
 * @email 
 * @date 2025-03-29 21:36:17
 */
public interface ChapterkechengziyuanDao extends BaseMapper<ChapterkechengziyuanEntity> {
	
	List<ChapterkechengziyuanVO> selectListVO(@Param("ew") Wrapper<ChapterkechengziyuanEntity> wrapper);
	
	ChapterkechengziyuanVO selectVO(@Param("ew") Wrapper<ChapterkechengziyuanEntity> wrapper);
	
	List<ChapterkechengziyuanView> selectListView(@Param("ew") Wrapper<ChapterkechengziyuanEntity> wrapper);

	List<ChapterkechengziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ChapterkechengziyuanEntity> wrapper);

	
	ChapterkechengziyuanView selectView(@Param("ew") Wrapper<ChapterkechengziyuanEntity> wrapper);
	

}
