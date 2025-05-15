package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChapterkechengziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChapterkechengziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChapterkechengziyuanView;


/**
 * 课程资源章节表
 *
 * @author 
 * @email 
 * @date 2025-03-29 21:36:17
 */
public interface ChapterkechengziyuanService extends IService<ChapterkechengziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChapterkechengziyuanVO> selectListVO(Wrapper<ChapterkechengziyuanEntity> wrapper);
   	
   	ChapterkechengziyuanVO selectVO(@Param("ew") Wrapper<ChapterkechengziyuanEntity> wrapper);
   	
   	List<ChapterkechengziyuanView> selectListView(Wrapper<ChapterkechengziyuanEntity> wrapper);
   	
   	ChapterkechengziyuanView selectView(@Param("ew") Wrapper<ChapterkechengziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChapterkechengziyuanEntity> wrapper);

   	

}

