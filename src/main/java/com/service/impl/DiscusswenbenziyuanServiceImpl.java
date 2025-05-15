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


import com.dao.DiscusswenbenziyuanDao;
import com.entity.DiscusswenbenziyuanEntity;
import com.service.DiscusswenbenziyuanService;
import com.entity.vo.DiscusswenbenziyuanVO;
import com.entity.view.DiscusswenbenziyuanView;

@Service("discusswenbenziyuanService")
public class DiscusswenbenziyuanServiceImpl extends ServiceImpl<DiscusswenbenziyuanDao, DiscusswenbenziyuanEntity> implements DiscusswenbenziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusswenbenziyuanEntity> page = this.selectPage(
                new Query<DiscusswenbenziyuanEntity>(params).getPage(),
                new EntityWrapper<DiscusswenbenziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusswenbenziyuanEntity> wrapper) {
		  Page<DiscusswenbenziyuanView> page =new Query<DiscusswenbenziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusswenbenziyuanVO> selectListVO(Wrapper<DiscusswenbenziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusswenbenziyuanVO selectVO(Wrapper<DiscusswenbenziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusswenbenziyuanView> selectListView(Wrapper<DiscusswenbenziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusswenbenziyuanView selectView(Wrapper<DiscusswenbenziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
