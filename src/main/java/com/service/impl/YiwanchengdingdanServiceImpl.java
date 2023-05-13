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


import com.dao.YiwanchengdingdanDao;
import com.entity.YiwanchengdingdanEntity;
import com.service.YiwanchengdingdanService;
import com.entity.vo.YiwanchengdingdanVO;
import com.entity.view.YiwanchengdingdanView;

@Service("yiwanchengdingdanService")
public class YiwanchengdingdanServiceImpl extends ServiceImpl<YiwanchengdingdanDao, YiwanchengdingdanEntity> implements YiwanchengdingdanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiwanchengdingdanEntity> page = this.selectPage(
                new Query<YiwanchengdingdanEntity>(params).getPage(),
                new EntityWrapper<YiwanchengdingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiwanchengdingdanEntity> wrapper) {
		  Page<YiwanchengdingdanView> page =new Query<YiwanchengdingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YiwanchengdingdanVO> selectListVO(Wrapper<YiwanchengdingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YiwanchengdingdanVO selectVO(Wrapper<YiwanchengdingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YiwanchengdingdanView> selectListView(Wrapper<YiwanchengdingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiwanchengdingdanView selectView(Wrapper<YiwanchengdingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
