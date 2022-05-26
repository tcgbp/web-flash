package cn.enilu.flash.service.train;


import cn.enilu.flash.bean.entity.train.Class;
import cn.enilu.flash.dao.train.ClassRepository;

import cn.enilu.flash.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService extends BaseService<Class,Long,ClassRepository>  {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ClassRepository classRepository;

}

