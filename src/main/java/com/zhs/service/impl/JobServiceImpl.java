//package com.zhs.service.impl;
//
//import com.zhs.entity.QuartzEntity;
//import com.zhs.mapper.QrtzJobDetailsMapper;
//import com.zhs.service.IJobService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @project: formwork
// * @author: zhs
// * @date: 2020/3/16 10:24
// * @package: com.zhs.service.impl
// * @description:
// */
//
//@Service("jobService")
//public class JobServiceImpl  implements IJobService {
//
//
//    @Autowired
//    private QrtzJobDetailsMapper qrtzJobDetailsMapper;
//
//
//    @Override
//    public List<QuartzEntity> listQuartzEntity() {
//
//        return qrtzJobDetailsMapper.listQuartzEntity();
//    }
//
//    @Override
//    public Long listQuartzEntityOne() {
//
//        return qrtzJobDetailsMapper.listQuartzEntityCount();
//    }
//}
