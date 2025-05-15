package com.dao;

import com.entity.ShipinziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShipinziyuanVO;
import com.entity.view.ShipinziyuanView;


/**
 * 视频资源
 * 
 * @author 
 * @email 
 * @date 2025-03-29 21:36:16
 */
public interface ShipinziyuanDao extends BaseMapper<ShipinziyuanEntity> {
	
	List<ShipinziyuanVO> selectListVO(@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);
	
	ShipinziyuanVO selectVO(@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);
	
	List<ShipinziyuanView> selectListView(@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);

	List<ShipinziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);

	
	ShipinziyuanView selectView(@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);
	

}
