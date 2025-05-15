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

import com.entity.KechengziyuanEntity;
import com.entity.view.KechengziyuanView;

import com.service.KechengziyuanService;
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
 * 课程资源
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-29 21:36:16
 */
@RestController
@RequestMapping("/kechengziyuan")
public class KechengziyuanController {
    @Autowired
    private KechengziyuanService kechengziyuanService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengziyuanEntity kechengziyuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			kechengziyuan.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KechengziyuanEntity> ew = new EntityWrapper<KechengziyuanEntity>();

		PageUtils page = kechengziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengziyuanEntity kechengziyuan, 
		HttpServletRequest request){
        EntityWrapper<KechengziyuanEntity> ew = new EntityWrapper<KechengziyuanEntity>();

		PageUtils page = kechengziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengziyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengziyuanEntity kechengziyuan){
       	EntityWrapper<KechengziyuanEntity> ew = new EntityWrapper<KechengziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengziyuan, "kechengziyuan")); 
        return R.ok().put("data", kechengziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengziyuanEntity kechengziyuan){
        EntityWrapper< KechengziyuanEntity> ew = new EntityWrapper< KechengziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengziyuan, "kechengziyuan")); 
		KechengziyuanView kechengziyuanView =  kechengziyuanService.selectView(ew);
		return R.ok("查询课程资源成功").put("data", kechengziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengziyuanEntity kechengziyuan = kechengziyuanService.selectById(id);
		kechengziyuan.setClicktime(new Date());
		kechengziyuanService.updateById(kechengziyuan);
        kechengziyuan = kechengziyuanService.selectView(new EntityWrapper<KechengziyuanEntity>().eq("id", id));
        return R.ok().put("data", kechengziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengziyuanEntity kechengziyuan = kechengziyuanService.selectById(id);
		kechengziyuan.setClicktime(new Date());
		kechengziyuanService.updateById(kechengziyuan);
        kechengziyuan = kechengziyuanService.selectView(new EntityWrapper<KechengziyuanEntity>().eq("id", id));
        return R.ok().put("data", kechengziyuan);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        KechengziyuanEntity kechengziyuan = kechengziyuanService.selectById(id);
        if(type.equals("1")) {
        	kechengziyuan.setThumbsupnum(kechengziyuan.getThumbsupnum()+1);
        } else {
        	kechengziyuan.setCrazilynum(kechengziyuan.getCrazilynum()+1);
        }
        kechengziyuanService.updateById(kechengziyuan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengziyuanEntity kechengziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kechengziyuan);
        kechengziyuanService.insert(kechengziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengziyuanEntity kechengziyuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kechengziyuan);
        kechengziyuanService.insert(kechengziyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengziyuanEntity kechengziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengziyuan);
        kechengziyuanService.updateById(kechengziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,KechengziyuanEntity kechengziyuan, HttpServletRequest request,String pre){
        EntityWrapper<KechengziyuanEntity> ew = new EntityWrapper<KechengziyuanEntity>();
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
		PageUtils page = kechengziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengziyuan), params), params));
        return R.ok().put("data", page);
    }


    @Autowired
    private XueshengService xueshengService;
    /**
     * 协同算法（按注册选型推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,KechengziyuanEntity kechengziyuan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "biaoqian";
        String tableName = request.getSession().getAttribute("tableName").toString();
        List<String> inteltypes = new ArrayList<String>();
        if(tableName.equals("xuesheng")) {
            XueshengEntity xuesheng = xueshengService.selectOne(new EntityWrapper<XueshengEntity>().eq("id", userId));
            inteltypes = Arrays.asList(xuesheng.getBiaoqian().split(","));
        }
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<KechengziyuanEntity> kechengziyuanList = new ArrayList<KechengziyuanEntity>();
        //去重
        if(inteltypes!=null && inteltypes.size()>0) {
            for(String s : inteltypes) {
                kechengziyuanList.addAll(kechengziyuanService.selectList(new EntityWrapper<KechengziyuanEntity>().eq(inteltypeColumn, s)));
            }
        }
        EntityWrapper<KechengziyuanEntity> ew = new EntityWrapper<KechengziyuanEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = kechengziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengziyuan), params), params));
        List<KechengziyuanEntity> pageList = (List<KechengziyuanEntity>)page.getList();
        if(kechengziyuanList.size()<limit) {
            int toAddNum = (limit-kechengziyuanList.size())<=pageList.size()?(limit-kechengziyuanList.size()):pageList.size();
            for(KechengziyuanEntity o1 : pageList) {
                boolean addFlag = true;
                for(KechengziyuanEntity o2 : kechengziyuanList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    kechengziyuanList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(kechengziyuanList.size()>limit) {
            kechengziyuanList = kechengziyuanList.subList(0, limit);
        }
        page.setList(kechengziyuanList);
        return R.ok().put("data", page);
    }








}
