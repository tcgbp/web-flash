package cn.enilu.flash.service.training;


import cn.enilu.flash.bean.entity.training.ClassGrade;
import cn.enilu.flash.dao.training.ClassGradeRepository;

import cn.enilu.flash.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassGradeService extends BaseService<ClassGrade,Long,ClassGradeRepository>  {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ClassGradeRepository classGradeRepository;

}

