package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WenbenziyuanDao;
import com.entity.WenbenziyuanEntity;
import com.service.WenbenziyuanService;
import com.entity.vo.WenbenziyuanVO;
import com.entity.view.WenbenziyuanView;

@Service("wenbenziyuanService")
public class WenbenziyuanServiceImpl extends ServiceImpl<WenbenziyuanDao, WenbenziyuanEntity> implements WenbenziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenbenziyuanEntity> page = this.selectPage(
                new Query<WenbenziyuanEntity>(params).getPage(),
                new EntityWrapper<WenbenziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenbenziyuanEntity> wrapper) {
		  Page<WenbenziyuanView> page =new Query<WenbenziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WenbenziyuanVO> selectListVO(Wrapper<WenbenziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WenbenziyuanVO selectVO(Wrapper<WenbenziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WenbenziyuanView> selectListView(Wrapper<WenbenziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenbenziyuanView selectView(Wrapper<WenbenziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
