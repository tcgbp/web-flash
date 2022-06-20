package cn.enilu.flash.api.controller.training;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.entity.training.ClassGrade;
import cn.enilu.flash.service.training.ClassGradeService;

import cn.enilu.flash.bean.core.BussinessLog;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.enumeration.BizExceptionEnum;
import cn.enilu.flash.bean.exception.ApplicationException;
import cn.enilu.flash.bean.vo.front.Ret;
import cn.enilu.flash.bean.vo.front.Rets;

import cn.enilu.flash.utils.factory.Page;


import org.apache.shiro.authz.annotation.RequiresPermissions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/classGrade")
public class ClassGradeController extends BaseController {
	private  Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ClassGradeService classGradeService;

	@GetMapping(value = "/list")
	@RequiresPermissions(value = "classGrade")
	public Ret list(@RequestParam(required = false) Long id) {
		Page<ClassGrade> page = new PageFactory<ClassGrade>().defaultPage();
		page.addFilter("id",id);
		page = classGradeService.queryPage(page);
		return Rets.success(page);
	}
	@PostMapping
	@BussinessLog(value = "新增班级", key = "name")
	@RequiresPermissions(value = "classGradeAdd")
	public Ret add(@ModelAttribute ClassGrade classGrade){
		classGradeService.insert(classGrade);
		return Rets.success();
	}
	@PutMapping
	@BussinessLog(value = "更新班级", key = "name")
	@RequiresPermissions(value = "classGradeUpdate")
	public Ret update(@ModelAttribute ClassGrade classGrade){
		classGradeService.update(classGrade);
		return Rets.success();
	}
	@DeleteMapping
	@BussinessLog(value = "删除班级", key = "id")
	@RequiresPermissions(value = "classGradeDelete")
	public Ret remove(Long id){
		if (id == null) {
			throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
		}
		classGradeService.delete(id);
		return Rets.success();
	}
}
