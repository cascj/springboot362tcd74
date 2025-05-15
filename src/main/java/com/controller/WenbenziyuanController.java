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

import com.entity.WenbenziyuanEntity;
import com.entity.view.WenbenziyuanView;

import com.service.WenbenziyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.XueshengService;
import com.entity.XueshengEntity;

/**
 * 文本资源
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-29 21:36:16
 */
@RestController
@RequestMapping("/wenbenziyuan")
public class WenbenziyuanController {
    @Autowired
    private WenbenziyuanService wenbenziyuanService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WenbenziyuanEntity wenbenziyuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			wenbenziyuan.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WenbenziyuanEntity> ew = new EntityWrapper<WenbenziyuanEntity>();

		PageUtils page = wenbenziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenbenziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WenbenziyuanEntity wenbenziyuan, 
		HttpServletRequest request){
        EntityWrapper<WenbenziyuanEntity> ew = new EntityWrapper<WenbenziyuanEntity>();

		PageUtils page = wenbenziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenbenziyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WenbenziyuanEntity wenbenziyuan){
       	EntityWrapper<WenbenziyuanEntity> ew = new EntityWrapper<WenbenziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wenbenziyuan, "wenbenziyuan")); 
        return R.ok().put("data", wenbenziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WenbenziyuanEntity wenbenziyuan){
        EntityWrapper< WenbenziyuanEntity> ew = new EntityWrapper< WenbenziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wenbenziyuan, "wenbenziyuan")); 
		WenbenziyuanView wenbenziyuanView =  wenbenziyuanService.selectView(ew);
		return R.ok("查询文本资源成功").put("data", wenbenziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WenbenziyuanEntity wenbenziyuan = wenbenziyuanService.selectById(id);
		wenbenziyuan.setClicktime(new Date());
		wenbenziyuanService.updateById(wenbenziyuan);
        wenbenziyuan = wenbenziyuanService.selectView(new EntityWrapper<WenbenziyuanEntity>().eq("id", id));
        return R.ok().put("data", wenbenziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WenbenziyuanEntity wenbenziyuan = wenbenziyuanService.selectById(id);
		wenbenziyuan.setClicktime(new Date());
		wenbenziyuanService.updateById(wenbenziyuan);
        wenbenziyuan = wenbenziyuanService.selectView(new EntityWrapper<WenbenziyuanEntity>().eq("id", id));
        return R.ok().put("data", wenbenziyuan);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        WenbenziyuanEntity wenbenziyuan = wenbenziyuanService.selectById(id);
        if(type.equals("1")) {
        	wenbenziyuan.setThumbsupnum(wenbenziyuan.getThumbsupnum()+1);
        } else {
        	wenbenziyuan.setCrazilynum(wenbenziyuan.getCrazilynum()+1);
        }
        wenbenziyuanService.updateById(wenbenziyuan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WenbenziyuanEntity wenbenziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(wenbenziyuan);
        wenbenziyuanService.insert(wenbenziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WenbenziyuanEntity wenbenziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(wenbenziyuan);
        wenbenziyuanService.insert(wenbenziyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WenbenziyuanEntity wenbenziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenbenziyuan);
        wenbenziyuanService.updateById(wenbenziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wenbenziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,WenbenziyuanEntity wenbenziyuan, HttpServletRequest request,String pre){
        EntityWrapper<WenbenziyuanEntity> ew = new EntityWrapper<WenbenziyuanEntity>();
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
		PageUtils page = wenbenziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenbenziyuan), params), params));
        return R.ok().put("data", page);
    }


    @Autowired
    private XueshengService xueshengService;
    /**
     * 协同算法（按注册选型推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,WenbenziyuanEntity wenbenziyuan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "biaoqian";
        String tableName = request.getSession().getAttribute("tableName").toString();
        List<String> inteltypes = new ArrayList<String>();
        if(tableName.equals("xuesheng")) {
            XueshengEntity xuesheng = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("id", userId));
            inteltypes = Arrays.asList(xuesheng.getBiaoqian().split(","));
        }
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<WenbenziyuanEntity> wenbenziyuanList = new ArrayList<WenbenziyuanEntity>();
        //去重
        if(inteltypes!=null && inteltypes.size()>0) {
            for(String s : inteltypes) {
                wenbenziyuanList.addAll(wenbenziyuanService.selectList(new EntityWrapper<WenbenziyuanEntity>().eq(inteltypeColumn, s)));
            }
        }
        EntityWrapper<WenbenziyuanEntity> ew = new EntityWrapper<WenbenziyuanEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = wenbenziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenbenziyuan), params), params));
        List<WenbenziyuanEntity> pageList = (List<WenbenziyuanEntity>)page.getList();
        if(wenbenziyuanList.size()<limit) {
            int toAddNum = (limit-wenbenziyuanList.size())<=pageList.size()?(limit-wenbenziyuanList.size()):pageList.size();
            for(WenbenziyuanEntity o1 : pageList) {
                boolean addFlag = true;
                for(WenbenziyuanEntity o2 : wenbenziyuanList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    wenbenziyuanList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(wenbenziyuanList.size()>limit) {
            wenbenziyuanList = wenbenziyuanList.subList(0, limit);
        }
        page.setList(wenbenziyuanList);
        return R.ok().put("data", page);
    }








}
