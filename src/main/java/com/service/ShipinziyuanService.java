package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShipinziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShipinziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShipinziyuanView;


/**
 * 视频资源
 *
 * @author 
 * @email 
 * @date 2025-03-29 21:36:16
 */
public interface ShipinziyuanService extends IService<ShipinziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShipinziyuanVO> selectListVO(Wrapper<ShipinziyuanEntity> wrapper);
   	
   	ShipinziyuanVO selectVO(@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);
   	
   	List<ShipinziyuanView> selectListView(Wrapper<ShipinziyuanEntity> wrapper);
   	
   	ShipinziyuanView selectView(@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShipinziyuanEntity> wrapper);

   	

}

