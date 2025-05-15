package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BiaoqianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BiaoqianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BiaoqianView;


/**
 * 标签
 *
 * @author 
 * @email 
 * @date 2025-03-29 21:36:16
 */
public interface BiaoqianService extends IService<BiaoqianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BiaoqianVO> selectListVO(Wrapper<BiaoqianEntity> wrapper);
   	
   	BiaoqianVO selectVO(@Param("ew") Wrapper<BiaoqianEntity> wrapper);
   	
   	List<BiaoqianView> selectListView(Wrapper<BiaoqianEntity> wrapper);
   	
   	BiaoqianView selectView(@Param("ew") Wrapper<BiaoqianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BiaoqianEntity> wrapper);

   	

}

