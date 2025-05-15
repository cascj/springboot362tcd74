package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshipinziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshipinziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshipinziyuanView;


/**
 * 视频资源评论表
 *
 * @author 
 * @email 
 * @date 2025-03-29 21:36:17
 */
public interface DiscussshipinziyuanService extends IService<DiscussshipinziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshipinziyuanVO> selectListVO(Wrapper<DiscussshipinziyuanEntity> wrapper);
   	
   	DiscussshipinziyuanVO selectVO(@Param("ew") Wrapper<DiscussshipinziyuanEntity> wrapper);
   	
   	List<DiscussshipinziyuanView> selectListView(Wrapper<DiscussshipinziyuanEntity> wrapper);
   	
   	DiscussshipinziyuanView selectView(@Param("ew") Wrapper<DiscussshipinziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshipinziyuanEntity> wrapper);

   	

}

