package com.dao;

import com.entity.KechengziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KechengziyuanVO;
import com.entity.view.KechengziyuanView;


/**
 * 课程资源
 * 
 * @author 
 * @email 
 * @date 2025-03-29 21:36:16
 */
public interface KechengziyuanDao extends BaseMapper<KechengziyuanEntity> {
	
	List<KechengziyuanVO> selectListVO(@Param("ew") Wrapper<KechengziyuanEntity> wrapper);
	
	KechengziyuanVO selectVO(@Param("ew") Wrapper<KechengziyuanEntity> wrapper);
	
	List<KechengziyuanView> selectListView(@Param("ew") Wrapper<KechengziyuanEntity> wrapper);

	List<KechengziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<KechengziyuanEntity> wrapper);

	
	KechengziyuanView selectView(@Param("ew") Wrapper<KechengziyuanEntity> wrapper);
	

}
