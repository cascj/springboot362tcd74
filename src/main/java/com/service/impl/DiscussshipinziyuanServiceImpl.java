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


import com.dao.DiscussshipinziyuanDao;
import com.entity.DiscussshipinziyuanEntity;
import com.service.DiscussshipinziyuanService;
import com.entity.vo.DiscussshipinziyuanVO;
import com.entity.view.DiscussshipinziyuanView;

@Service("discussshipinziyuanService")
public class DiscussshipinziyuanServiceImpl extends ServiceImpl<DiscussshipinziyuanDao, DiscussshipinziyuanEntity> implements DiscussshipinziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshipinziyuanEntity> page = this.selectPage(
                new Query<DiscussshipinziyuanEntity>(params).getPage(),
                new EntityWrapper<DiscussshipinziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshipinziyuanEntity> wrapper) {
		  Page<DiscussshipinziyuanView> page =new Query<DiscussshipinziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussshipinziyuanVO> selectListVO(Wrapper<DiscussshipinziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshipinziyuanVO selectVO(Wrapper<DiscussshipinziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshipinziyuanView> selectListView(Wrapper<DiscussshipinziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshipinziyuanView selectView(Wrapper<DiscussshipinziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
