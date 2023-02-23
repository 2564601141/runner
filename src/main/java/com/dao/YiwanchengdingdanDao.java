package com.dao;

import com.entity.YiwanchengdingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YiwanchengdingdanVO;
import com.entity.view.YiwanchengdingdanView;


/**
 * 已完成订单
 * 
 * @author 
 * @email 
 * @date 2021-03-30 19:28:31
 */
public interface YiwanchengdingdanDao extends BaseMapper<YiwanchengdingdanEntity> {
	
	List<YiwanchengdingdanVO> selectListVO(@Param("ew") Wrapper<YiwanchengdingdanEntity> wrapper);
	
	YiwanchengdingdanVO selectVO(@Param("ew") Wrapper<YiwanchengdingdanEntity> wrapper);
	
	List<YiwanchengdingdanView> selectListView(@Param("ew") Wrapper<YiwanchengdingdanEntity> wrapper);

	List<YiwanchengdingdanView> selectListView(Pagination page,@Param("ew") Wrapper<YiwanchengdingdanEntity> wrapper);
	
	YiwanchengdingdanView selectView(@Param("ew") Wrapper<YiwanchengdingdanEntity> wrapper);
	
}
