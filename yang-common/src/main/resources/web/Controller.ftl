package ${conf.basePackage}.${table.lowerCamelName}.controller;

import ${conf.basePackage}.base.controller.BaseController;
import ${conf.basePackage}.base.dto.ResponseDto;
import ${conf.basePackage}.${table.lowerCamelName}.dto.${table.className}DTO;
import ${conf.basePackage}.${table.lowerCamelName}.service.I${table.className}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${table.comment} Controller
 * @author ${conf.author}
 * @version ${conf.version}
 * @since ${conf.createDate}
 */
@Slf4j
@Controller
@RequestMapping("/${table.lowerCamelName}")
public class ${table.className}Controller extends BaseController<I${table.className}Service, ${table.className}DTO> {

	@RequestMapping(value = "list", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseDto list(${table.className}DTO ${table.lowerCamelName}DTO) {
		return super.query(${table.lowerCamelName}DTO);
	}

	@RequestMapping(value = "list", headers = {"version=1.1.0"}, method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseDto list1_1_0(${table.className}DTO ${table.lowerCamelName}DTO) {
		return super.query(${table.lowerCamelName}DTO);
	}

	@RequestMapping(value = "list", headers = {"version=1.2.0", "platform=APP"}, method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseDto list1_2_0(${table.className}DTO ${table.lowerCamelName}DTO) {
		return super.query(${table.lowerCamelName}DTO);
	}

	@RequestMapping(value = "queryByPage", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseDto queryByPage(${table.className}DTO ${table.lowerCamelName}DTO,Integer pageNo,Integer pageSize) {
		return super.queryByPage(${table.lowerCamelName}DTO, pageSize, pageNo);
	}

	@RequestMapping(value = "add", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseDto add(${table.className}DTO ${table.lowerCamelName}DTO) {
		return super.save(${table.lowerCamelName}DTO);
	}

	@RequestMapping(value = "show", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseDto show(Integer id) {
		return super.detail(id);
	}

	@RequestMapping(value = "modify", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseDto modify(${table.className}DTO ${table.lowerCamelName}) {
		return super.update(${table.lowerCamelName});
	}

	@RequestMapping(value = "remove", method = {RequestMethod.POST})
	@ResponseBody
	public ResponseDto remove(Integer id) {
		return super.delete(id);
	}
}
