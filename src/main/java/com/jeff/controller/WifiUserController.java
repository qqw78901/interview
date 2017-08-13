package com.jeff.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeff.common.BaseInfo;
import com.jeff.po.WifiUser;
import com.jeff.service.WifiUserService;
import com.jeff.util.ResultMap;

@Controller
@RequestMapping("wifiuser")
public class WifiUserController {

	@Autowired
	public WifiUserService wifiUserService;
	
	@RequestMapping("login")
	@ResponseBody
	public ResultMap login(HttpServletRequest request,WifiUser wifiUser) {
		ResultMap rs = new ResultMap();
		try {
			WifiUser loginVo = wifiUserService.login(wifiUser);
			if(loginVo!=null) {
				String userMac = loginVo.getMac();
				if(userMac==null||userMac.equals("")) {
					//初次登录的用户绑定一个mac
					loginVo.setMac(wifiUser.getMac());
					wifiUserService.update(loginVo);
				}else if(!userMac.equals(wifiUser.getMac())) {
//					登录的mac限制
					return rs.fail().info("mac认证失败 请联系老师处理");
				}
				BaseInfo.SetUserName(request, loginVo.getloginName());
				BaseInfo.SetName(request, loginVo.getName());
				BaseInfo.SetUserGrade(request, loginVo.getType());
				BaseInfo.SetMac(request, loginVo.getMac());
				rs.success().info("登录成功").data(loginVo);
			}else {
				rs.fail().info("账号或密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rs.fail().info("登录失败");
		}
		return rs;
		
	}

/*	@RequestMapping("addinfo")
	@ResponseBody
	public String addinfo(HttpServletRequest request,Info info) {
		String rString="";
		try {
			infoService.update(info);
		    String jsonpCallback = request.getParameter("callback");//客户端请求参数  
		    rString=  jsonpCallback+"('success')";
		} catch (Exception e) {
			e.printStackTrace();
			rString= "";
		}
		return rString;
*/

	
/*	@RequestMapping(value="getinfo", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getInfo(HttpServletRequest request,Info info,HttpServletResponse response) {
		String rm="";
		try {
		
			response.setContentType("text/plain; charset=utf-8");
			Info i = infoService.getById(info.getId());
			String functionName = request.getParameter("callback");
			rm ="var JSONresult ={";
			System.out.println(i.getCla());
			rm+="cla:'"+i.getCla()+"',";
			rm+="name:'"+i.getName()+"',";
			rm+="psw:'"+i.getPsw()+"',";
			rm+="school:'"+i.getSchool()+"',";
			rm+="id:'"+i.getId()+"'";
			rm +="};"+functionName+"(JSONresult);";
		} catch (Exception e) {
			e.printStackTrace();
			rm="failed";
		}
		return rm;
	}*/

	

}
