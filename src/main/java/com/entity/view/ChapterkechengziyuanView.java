package com.entity.view;

import com.entity.ChapterkechengziyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 课程资源章节表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-29 21:36:17
 */
@TableName("chapterkechengziyuan")
public class ChapterkechengziyuanView  extends ChapterkechengziyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChapterkechengziyuanView(){
	}
 
 	public ChapterkechengziyuanView(ChapterkechengziyuanEntity chapterkechengziyuanEntity){
 	try {
			BeanUtils.copyProperties(this, chapterkechengziyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
