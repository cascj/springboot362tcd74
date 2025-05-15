package com.dao;

import com.entity.WenbenziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WenbenziyuanVO;
import com.entity.view.WenbenziyuanView;


/**
 * 文本资源
 * 
 * @author 
 * @email 
 * @date 2025-03-29 21:36:16
 */
public interface WenbenziyuanDao extends BaseMapper<WenbenziyuanEntity> {
	
	List<WenbenziyuanVO> selectListVO(@Param("ew") Wrapper<WenbenziyuanEntity> wrapper);
	
	WenbenziyuanVO selectVO(@Param("ew") Wrapper<WenbenziyuanEntity> wrapper);
	
	List<WenbenziyuanView> selectListView(@Param("ew") Wrapper<WenbenziyuanEntity> wrapper);

	List<WenbenziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<WenbenziyuanEntity> wrapper);

	
	WenbenziyuanView selectView(@Param("ew") Wrapper<WenbenziyuanEntity> wrapper);
	

}
