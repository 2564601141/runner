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


import com.dao.PaotuizheDao;
import com.entity.PaotuizheEntity;
import com.service.PaotuizheService;
import com.entity.vo.PaotuizheVO;
import com.entity.view.PaotuizheView;

@Service("paotuizheService")
public class PaotuizheServiceImpl extends ServiceImpl<PaotuizheDao, PaotuizheEntity> implements PaotuizheService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PaotuizheEntity> page = this.selectPage(
                new Query<PaotuizheEntity>(params).getPage(),
                new EntityWrapper<PaotuizheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PaotuizheEntity> wrapper) {
		  Page<PaotuizheView> page =new Query<PaotuizheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PaotuizheVO> selectListVO(Wrapper<PaotuizheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PaotuizheVO selectVO(Wrapper<PaotuizheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PaotuizheView> selectListView(Wrapper<PaotuizheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PaotuizheView selectView(Wrapper<PaotuizheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
