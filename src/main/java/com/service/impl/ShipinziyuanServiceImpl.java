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


import com.dao.ShipinziyuanDao;
import com.entity.ShipinziyuanEntity;
import com.service.ShipinziyuanService;
import com.entity.vo.ShipinziyuanVO;
import com.entity.view.ShipinziyuanView;

@Service("shipinziyuanService")
public class ShipinziyuanServiceImpl extends ServiceImpl<ShipinziyuanDao, ShipinziyuanEntity> implements ShipinziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShipinziyuanEntity> page = this.selectPage(
                new Query<ShipinziyuanEntity>(params).getPage(),
                new EntityWrapper<ShipinziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShipinziyuanEntity> wrapper) {
		  Page<ShipinziyuanView> page =new Query<ShipinziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShipinziyuanVO> selectListVO(Wrapper<ShipinziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShipinziyuanVO selectVO(Wrapper<ShipinziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShipinziyuanView> selectListView(Wrapper<ShipinziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShipinziyuanView selectView(Wrapper<ShipinziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
