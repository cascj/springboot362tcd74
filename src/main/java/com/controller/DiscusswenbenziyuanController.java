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

import com.entity.DiscusswenbenziyuanEntity;
import com.entity.view.DiscusswenbenziyuanView;

import com.service.DiscusswenbenziyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 文本资源评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-29 21:36:17
 */
@RestController
@RequestMapping("/discusswenbenziyuan")
public class DiscusswenbenziyuanController {
    @Autowired
    private DiscusswenbenziyuanService discusswenbenziyuanService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusswenbenziyuanEntity discusswenbenziyuan,
		HttpServletRequest request){
        EntityWrapper<DiscusswenbenziyuanEntity> ew = new EntityWrapper<DiscusswenbenziyuanEntity>();

		PageUtils page = discusswenbenziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusswenbenziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusswenbenziyuanEntity discusswenbenziyuan, 
		HttpServletRequest request){
        EntityWrapper<DiscusswenbenziyuanEntity> ew = new EntityWrapper<DiscusswenbenziyuanEntity>();

		PageUtils page = discusswenbenziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusswenbenziyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusswenbenziyuanEntity discusswenbenziyuan){
       	EntityWrapper<DiscusswenbenziyuanEntity> ew = new EntityWrapper<DiscusswenbenziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusswenbenziyuan, "discusswenbenziyuan")); 
        return R.ok().put("data", discusswenbenziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusswenbenziyuanEntity discusswenbenziyuan){
        EntityWrapper< DiscusswenbenziyuanEntity> ew = new EntityWrapper< DiscusswenbenziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusswenbenziyuan, "discusswenbenziyuan")); 
		DiscusswenbenziyuanView discusswenbenziyuanView =  discusswenbenziyuanService.selectView(ew);
		return R.ok("查询文本资源评论表成功").put("data", discusswenbenziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusswenbenziyuanEntity discusswenbenziyuan = discusswenbenziyuanService.selectById(id);
        return R.ok().put("data", discusswenbenziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusswenbenziyuanEntity discusswenbenziyuan = discusswenbenziyuanService.selectById(id);
        return R.ok().put("data", discusswenbenziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusswenbenziyuanEntity discusswenbenziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusswenbenziyuan);
        discusswenbenziyuanService.insert(discusswenbenziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusswenbenziyuanEntity discusswenbenziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusswenbenziyuan);
        discusswenbenziyuanService.insert(discusswenbenziyuan);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscusswenbenziyuanEntity discusswenbenziyuan = discusswenbenziyuanService.selectOne(new EntityWrapper<DiscusswenbenziyuanEntity>().eq("", username));
        return R.ok().put("data", discusswenbenziyuan);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusswenbenziyuanEntity discusswenbenziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusswenbenziyuan);
        discusswenbenziyuanService.updateById(discusswenbenziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusswenbenziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusswenbenziyuanEntity discusswenbenziyuan, HttpServletRequest request,String pre){
        EntityWrapper<DiscusswenbenziyuanEntity> ew = new EntityWrapper<DiscusswenbenziyuanEntity>();
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
		PageUtils page = discusswenbenziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusswenbenziyuan), params), params));
        return R.ok().put("data", page);
    }










}
