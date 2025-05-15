package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussshipinziyuanEntity;
import com.entity.view.DiscussshipinziyuanView;

import com.service.DiscussshipinziyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 视频资源评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-29 21:36:17
 */
@RestController
@RequestMapping("/discussshipinziyuan")
public class DiscussshipinziyuanController {
    @Autowired
    private DiscussshipinziyuanService discussshipinziyuanService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussshipinziyuanEntity discussshipinziyuan,
		HttpServletRequest request){
        EntityWrapper<DiscussshipinziyuanEntity> ew = new EntityWrapper<DiscussshipinziyuanEntity>();

		PageUtils page = discussshipinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshipinziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussshipinziyuanEntity discussshipinziyuan, 
		HttpServletRequest request){
        EntityWrapper<DiscussshipinziyuanEntity> ew = new EntityWrapper<DiscussshipinziyuanEntity>();

		PageUtils page = discussshipinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshipinziyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussshipinziyuanEntity discussshipinziyuan){
       	EntityWrapper<DiscussshipinziyuanEntity> ew = new EntityWrapper<DiscussshipinziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussshipinziyuan, "discussshipinziyuan")); 
        return R.ok().put("data", discussshipinziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussshipinziyuanEntity discussshipinziyuan){
        EntityWrapper< DiscussshipinziyuanEntity> ew = new EntityWrapper< DiscussshipinziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussshipinziyuan, "discussshipinziyuan")); 
		DiscussshipinziyuanView discussshipinziyuanView =  discussshipinziyuanService.selectView(ew);
		return R.ok("查询视频资源评论表成功").put("data", discussshipinziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussshipinziyuanEntity discussshipinziyuan = discussshipinziyuanService.selectById(id);
        return R.ok().put("data", discussshipinziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussshipinziyuanEntity discussshipinziyuan = discussshipinziyuanService.selectById(id);
        return R.ok().put("data", discussshipinziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussshipinziyuanEntity discussshipinziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussshipinziyuan);
        discussshipinziyuanService.insert(discussshipinziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussshipinziyuanEntity discussshipinziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussshipinziyuan);
        discussshipinziyuanService.insert(discussshipinziyuan);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussshipinziyuanEntity discussshipinziyuan = discussshipinziyuanService.selectOne(new EntityWrapper<DiscussshipinziyuanEntity>().eq("", username));
        return R.ok().put("data", discussshipinziyuan);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussshipinziyuanEntity discussshipinziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshipinziyuan);
        discussshipinziyuanService.updateById(discussshipinziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussshipinziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussshipinziyuanEntity discussshipinziyuan, HttpServletRequest request,String pre){
        EntityWrapper<DiscussshipinziyuanEntity> ew = new EntityWrapper<DiscussshipinziyuanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussshipinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshipinziyuan), params), params));
        return R.ok().put("data", page);
    }










}
