package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusswenbenziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusswenbenziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusswenbenziyuanView;


/**
 * 文本资源评论表
 *
 * @author 
 * @email 
 * @date 2025-03-29 21:36:17
 */
public interface DiscusswenbenziyuanService extends IService<DiscusswenbenziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusswenbenziyuanVO> selectListVO(Wrapper<DiscusswenbenziyuanEntity> wrapper);
   	
   	DiscusswenbenziyuanVO selectVO(@Param("ew") Wrapper<DiscusswenbenziyuanEntity> wrapper);
   	
   	List<DiscusswenbenziyuanView> selectListView(Wrapper<DiscusswenbenziyuanEntity> wrapper);
   	
   	DiscusswenbenziyuanView selectView(@Param("ew") Wrapper<DiscusswenbenziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusswenbenziyuanEntity> wrapper);

   	

}

