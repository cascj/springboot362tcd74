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


import com.dao.ChapterkechengziyuanDao;
import com.entity.ChapterkechengziyuanEntity;
import com.service.ChapterkechengziyuanService;
import com.entity.vo.ChapterkechengziyuanVO;
import com.entity.view.ChapterkechengziyuanView;

@Service("chapterkechengziyuanService")
public class ChapterkechengziyuanServiceImpl extends ServiceImpl<ChapterkechengziyuanDao, ChapterkechengziyuanEntity> implements ChapterkechengziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChapterkechengziyuanEntity> page = this.selectPage(
                new Query<ChapterkechengziyuanEntity>(params).getPage(),
                new EntityWrapper<ChapterkechengziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChapterkechengziyuanEntity> wrapper) {
		  Page<ChapterkechengziyuanView> page =new Query<ChapterkechengziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChapterkechengziyuanVO> selectListVO(Wrapper<ChapterkechengziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChapterkechengziyuanVO selectVO(Wrapper<ChapterkechengziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChapterkechengziyuanView> selectListView(Wrapper<ChapterkechengziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChapterkechengziyuanView selectView(Wrapper<ChapterkechengziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
