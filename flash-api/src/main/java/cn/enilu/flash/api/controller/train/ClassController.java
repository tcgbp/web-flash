package cn.enilu.flash.api.controller.train;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.entity.train.Class;
import cn.enilu.flash.service.train.ClassService;

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
@RequestMapping("/class")
public class ClassController extends BaseController {
	private  Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ClassService classService;

	@GetMapping(value = "/list")
	@RequiresPermissions(value = "class")
	public Ret list(@RequestParam(required = false) Long id) {
		Page<Class> page = new PageFactory<Class>().defaultPage();
		page.addFilter("id",id);
		page = classService.queryPage(page);
		return Rets.success(page);
	}
	@PostMapping
	@BussinessLog(value = "新增班级", key = "name")
	@RequiresPermissions(value = "classAdd")
	public Ret add(@ModelAttribute Class cls){
		classService.insert(cls);
		return Rets.success();
	}
	@PutMapping
	@BussinessLog(value = "更新班级", key = "name")
	@RequiresPermissions(value = "classUpdate")
	public Ret update(@ModelAttribute Class cls){
		classService.update(cls);
		return Rets.success();
	}
	@DeleteMapping
	@BussinessLog(value = "删除班级", key = "id")
	@RequiresPermissions(value = "classDelete")
	public Ret remove(Long id){
		if (id == null) {
			throw new ApplicationException(BizExceptionEnum.REQUEST_NULL);
		}
		classService.delete(id);
		return Rets.success();
	}
}
