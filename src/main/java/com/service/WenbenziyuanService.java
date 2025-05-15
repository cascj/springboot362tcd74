package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenbenziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WenbenziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WenbenziyuanView;


/**
 * 文本资源
 *
 * @author 
 * @email 
 * @date 2025-03-29 21:36:16
 */
public interface WenbenziyuanService extends IService<WenbenziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenbenziyuanVO> selectListVO(Wrapper<WenbenziyuanEntity> wrapper);
   	
   	WenbenziyuanVO selectVO(@Param("ew") Wrapper<WenbenziyuanEntity> wrapper);
   	
   	List<WenbenziyuanView> selectListView(Wrapper<WenbenziyuanEntity> wrapper);
   	
   	WenbenziyuanView selectView(@Param("ew") Wrapper<WenbenziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenbenziyuanEntity> wrapper);

   	

}

