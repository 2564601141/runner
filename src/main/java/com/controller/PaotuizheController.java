package com.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.PaotuizheEntity;
import com.entity.view.PaotuizheView;

import com.service.PaotuizheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 跑腿者
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-30 19:28:31
 */
@RestController
@RequestMapping("/paotuizhe")
public class PaotuizheController {
    @Autowired
    private PaotuizheService paotuizheService;
    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 小程序端登录验证接口
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		PaotuizheEntity user = paotuizheService.selectOne(new EntityWrapper<PaotuizheEntity>().eq("gonghao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(user.getId(), username,"paotuizhe",  "跑腿者" );
		return R.ok().put("token", token);
	}
	
	/**
     * 小程序端注册接口
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody PaotuizheEntity paotuizhe){
    	//ValidatorUtils.validateEntity(paotuizhe);
    	PaotuizheEntity user = paotuizheService.selectOne(new EntityWrapper<PaotuizheEntity>().eq("gonghao", paotuizhe.getGonghao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		paotuizhe.setId(uId);
        paotuizheService.insert(paotuizhe);
        return R.ok();
    }
	
	/**
	 * 小程序端退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        PaotuizheEntity user = paotuizheService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 小程序端密码重置接口
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	PaotuizheEntity user = paotuizheService.selectOne(new EntityWrapper<PaotuizheEntity>().eq("gonghao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
    	user.setMima("123456");
        paotuizheService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PaotuizheEntity paotuizhe, 
		HttpServletRequest request){

        EntityWrapper<PaotuizheEntity> ew = new EntityWrapper<PaotuizheEntity>();
		PageUtils page = paotuizheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paotuizhe), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PaotuizheEntity paotuizhe, HttpServletRequest request){
        EntityWrapper<PaotuizheEntity> ew = new EntityWrapper<PaotuizheEntity>();
		PageUtils page = paotuizheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paotuizhe), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PaotuizheEntity paotuizhe){
       	EntityWrapper<PaotuizheEntity> ew = new EntityWrapper<PaotuizheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( paotuizhe, "paotuizhe")); 
        return R.ok().put("data", paotuizheService.selectListView(ew));
    }

	 /**
     * 后台管理端查询所有接口
     */
    @RequestMapping("/query")
    public R query(PaotuizheEntity paotuizhe){
        EntityWrapper< PaotuizheEntity> ew = new EntityWrapper< PaotuizheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( paotuizhe, "paotuizhe")); 
		PaotuizheView paotuizheView =  paotuizheService.selectView(ew);
		return R.ok("查询跑腿者成功").put("data", paotuizheView);
    }
	
    /**
     * 后台管理端跑腿者详情接口
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PaotuizheEntity paotuizhe = paotuizheService.selectById(id);
        return R.ok().put("data", paotuizhe);
    }

    /**
     * 小程序端跑腿者详情接口
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PaotuizheEntity paotuizhe = paotuizheService.selectById(id);
        return R.ok().put("data", paotuizhe);
    }

    /**
     * 后台管理端保存接口
     */
    @RequestMapping("/save")
    public R save(@RequestBody PaotuizheEntity paotuizhe, HttpServletRequest request){
    	paotuizhe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(paotuizhe);
    	PaotuizheEntity user = paotuizheService.selectOne(new EntityWrapper<PaotuizheEntity>().eq("gonghao", paotuizhe.getGonghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		paotuizhe.setId(new Date().getTime());
        paotuizheService.insert(paotuizhe);
        return R.ok();
    }
    
    /**
     * 小程序端保存接口
     */
    @RequestMapping("/add")
    public R add(@RequestBody PaotuizheEntity paotuizhe, HttpServletRequest request){
    	paotuizhe.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(paotuizhe);
    	PaotuizheEntity user = paotuizheService.selectOne(new EntityWrapper<PaotuizheEntity>().eq("gonghao", paotuizhe.getGonghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		paotuizhe.setId(new Date().getTime());
        paotuizheService.insert(paotuizhe);
        return R.ok();
    }

    /**
     * 修改接口
     */
    @RequestMapping("/update")
    public R update(@RequestBody PaotuizheEntity paotuizhe, HttpServletRequest request){
        //ValidatorUtils.validateEntity(paotuizhe);
        paotuizheService.updateById(paotuizhe);//全部更新
        return R.ok();
    }
    

    /**
     * 删除接口
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        paotuizheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<PaotuizheEntity> wrapper = new EntityWrapper<PaotuizheEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = paotuizheService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
