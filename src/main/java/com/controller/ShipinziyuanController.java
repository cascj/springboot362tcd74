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

import com.entity.ShipinziyuanEntity;
import com.entity.view.ShipinziyuanView;

import com.service.ShipinziyuanService;
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
 * 视频资源
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-29 21:36:16
 */
@RestController
@RequestMapping("/shipinziyuan")
public class ShipinziyuanController {
    @Autowired
    private ShipinziyuanService shipinziyuanService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShipinziyuanEntity shipinziyuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			shipinziyuan.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShipinziyuanEntity> ew = new EntityWrapper<ShipinziyuanEntity>();

		PageUtils page = shipinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShipinziyuanEntity shipinziyuan, 
		HttpServletRequest request){
        EntityWrapper<ShipinziyuanEntity> ew = new EntityWrapper<ShipinziyuanEntity>();

		PageUtils page = shipinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinziyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShipinziyuanEntity shipinziyuan){
       	EntityWrapper<ShipinziyuanEntity> ew = new EntityWrapper<ShipinziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shipinziyuan, "shipinziyuan")); 
        return R.ok().put("data", shipinziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShipinziyuanEntity shipinziyuan){
        EntityWrapper< ShipinziyuanEntity> ew = new EntityWrapper< ShipinziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shipinziyuan, "shipinziyuan")); 
		ShipinziyuanView shipinziyuanView =  shipinziyuanService.selectView(ew);
		return R.ok("查询视频资源成功").put("data", shipinziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShipinziyuanEntity shipinziyuan = shipinziyuanService.selectById(id);
		shipinziyuan.setClicktime(new Date());
		shipinziyuanService.updateById(shipinziyuan);
        shipinziyuan = shipinziyuanService.selectView(new EntityWrapper<ShipinziyuanEntity>().eq("id", id));
        return R.ok().put("data", shipinziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShipinziyuanEntity shipinziyuan = shipinziyuanService.selectById(id);
		shipinziyuan.setClicktime(new Date());
		shipinziyuanService.updateById(shipinziyuan);
        shipinziyuan = shipinziyuanService.selectView(new EntityWrapper<ShipinziyuanEntity>().eq("id", id));
        return R.ok().put("data", shipinziyuan);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ShipinziyuanEntity shipinziyuan = shipinziyuanService.selectById(id);
        if(type.equals("1")) {
        	shipinziyuan.setThumbsupnum(shipinziyuan.getThumbsupnum()+1);
        } else {
        	shipinziyuan.setCrazilynum(shipinziyuan.getCrazilynum()+1);
        }
        shipinziyuanService.updateById(shipinziyuan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShipinziyuanEntity shipinziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shipinziyuan);
        shipinziyuanService.insert(shipinziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShipinziyuanEntity shipinziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shipinziyuan);
        shipinziyuanService.insert(shipinziyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShipinziyuanEntity shipinziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipinziyuan);
        shipinziyuanService.updateById(shipinziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shipinziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShipinziyuanEntity shipinziyuan, HttpServletRequest request,String pre){
        EntityWrapper<ShipinziyuanEntity> ew = new EntityWrapper<ShipinziyuanEntity>();
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
		PageUtils page = shipinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinziyuan), params), params));
        return R.ok().put("data", page);
    }


    @Autowired
    private XueshengService xueshengService;
    /**
     * 协同算法（按注册选型推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ShipinziyuanEntity shipinziyuan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "biaoqian";
        String tableName = request.getSession().getAttribute("tableName").toString();
        List<String> inteltypes = new ArrayList<String>();
        if(tableName.equals("xuesheng")) {
            XueshengEntity xuesheng = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("id", userId));
            inteltypes = Arrays.asList(xuesheng.getBiaoqian().split(","));
        }
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ShipinziyuanEntity> shipinziyuanList = new ArrayList<ShipinziyuanEntity>();
        //去重
        if(inteltypes!=null && inteltypes.size()>0) {
            for(String s : inteltypes) {
                shipinziyuanList.addAll(shipinziyuanService.selectList(new EntityWrapper<ShipinziyuanEntity>().eq(inteltypeColumn, s)));
            }
        }
        EntityWrapper<ShipinziyuanEntity> ew = new EntityWrapper<ShipinziyuanEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = shipinziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinziyuan), params), params));
        List<ShipinziyuanEntity> pageList = (List<ShipinziyuanEntity>)page.getList();
        if(shipinziyuanList.size()<limit) {
            int toAddNum = (limit-shipinziyuanList.size())<=pageList.size()?(limit-shipinziyuanList.size()):pageList.size();
            for(ShipinziyuanEntity o1 : pageList) {
                boolean addFlag = true;
                for(ShipinziyuanEntity o2 : shipinziyuanList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    shipinziyuanList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(shipinziyuanList.size()>limit) {
            shipinziyuanList = shipinziyuanList.subList(0, limit);
        }
        page.setList(shipinziyuanList);
        return R.ok().put("data", page);
    }








}
