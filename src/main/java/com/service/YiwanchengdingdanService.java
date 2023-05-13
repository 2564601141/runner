package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiwanchengdingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YiwanchengdingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YiwanchengdingdanView;


/**
 * 已完成订单
 *
 * @author 
 * @email 
 * @date 2021-03-30 19:28:31
 */
public interface YiwanchengdingdanService extends IService<YiwanchengdingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiwanchengdingdanVO> selectListVO(Wrapper<YiwanchengdingdanEntity> wrapper);
   	
   	YiwanchengdingdanVO selectVO(@Param("ew") Wrapper<YiwanchengdingdanEntity> wrapper);
   	
   	List<YiwanchengdingdanView> selectListView(Wrapper<YiwanchengdingdanEntity> wrapper);
   	
   	YiwanchengdingdanView selectView(@Param("ew") Wrapper<YiwanchengdingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiwanchengdingdanEntity> wrapper);
   	
}

