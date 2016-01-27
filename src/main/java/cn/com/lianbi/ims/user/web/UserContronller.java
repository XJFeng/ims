package cn.com.lianbi.ims.user.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lianbi.framework.dao.Hello;
import cn.com.lianbi.ims.service.CommonService;
import cn.com.lianbi.ims.user.entity.User;

/**
 * @since 2016年1月15日 上午10:44:08
 * @author xjh
 */
@Controller
@RequestMapping("/user")
public class UserContronller {
	
	private static final Logger logger = LogManager.getLogger(UserContronller.class);
	
	@Autowired
	private CommonService service;
	
	@Resource(name="helloProxy")
	private Hello hello;

	@RequestMapping(value="/{userId}.json", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable String userId){
		logger.debug(this);
		logger.debug("userId is {}",userId);
		hello.say();
		List<Map> list = service.findListBySql("select * from area", null, null);
		logger.debug(list);
		return new User();
	}
	
	@RequestMapping(value="/{userId}", method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getUserTextDesc(@PathVariable String userId){
		logger.debug("userId is {}",userId);
		return new User().toString();
	}
	
}
