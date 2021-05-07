package com.lsitc.sfc.dspsample.common.menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsitc.sfc.dspsample.common.menu.vo.MenuVO;

@RestController
@RequestMapping("/api")
public class MenuController {
	
	@PostMapping(value = "/menu")
	public Map<String, Object> menu() throws Exception {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MenuVO> menuList = new ArrayList();
		
		MenuVO menuVO = new MenuVO();
		
		menuVO.setMenuId("1");
		menuVO.setMenuName("Dashboard");
		menuVO.setUrl("/admin/overview");
		menuVO.setIcon("nc-chart-pie-35");
		menuVO.setComponent("src/pages/DashboardLayout.vue");
		menuVO.setRouterName("Overview");
		menuList.add(menuVO);
		
		menuVO = new MenuVO();
		menuVO.setMenuId("2");
		menuVO.setMenuName("User Profile");
		menuVO.setUrl("/admin/user");
		menuVO.setIcon("nc-circle-09");
		menuVO.setComponent("src/pages/UserProfile.vue");
		menuVO.setRouterName("User");
		menuList.add(menuVO);
		
		menuVO = new MenuVO();
		menuVO.setMenuId("3");
		menuVO.setMenuName("Table list");
		menuVO.setUrl("/admin/table-list");
		menuVO.setIcon("nc-notes");
		menuVO.setComponent("src/pages/TableList.vue");
		menuVO.setRouterName("Table List");
		menuList.add(menuVO);
		
		menuVO = new MenuVO();
		menuVO.setMenuId("4");
		menuVO.setMenuName("Typography");
		menuVO.setUrl("/admin/typography");
		menuVO.setIcon("nc-paper-2");
		menuVO.setComponent("src/pages/Typography.vue");
		menuVO.setRouterName("Typography");
		menuList.add(menuVO);
		
		menuVO = new MenuVO();
		menuVO.setMenuId("5");
		menuVO.setMenuName("Icons");
		menuVO.setUrl("/admin/icons");
		menuVO.setIcon("nc-atom");
		menuVO.setComponent("src/pages/Icons.vue");
		menuVO.setRouterName("Icons");
		menuList.add(menuVO);
		
		menuVO = new MenuVO();
		menuVO.setMenuId("6");
		menuVO.setMenuName("Maps");
		menuVO.setUrl("/admin/maps");
		menuVO.setIcon("nc-pin-3");
		menuVO.setComponent("src/pages/Maps.vue");
		menuVO.setRouterName("Maps");
		menuList.add(menuVO);
		
		menuVO = new MenuVO();
		menuVO.setMenuId("7");
		menuVO.setMenuName("Notifications");
		menuVO.setUrl("/admin/notifications");
		menuVO.setIcon("nc-bell-55");
		menuVO.setComponent("src/pages/Notifications.vue");
		menuVO.setRouterName("Notifications");
		menuList.add(menuVO);
		
		menuVO = new MenuVO();
		menuVO.setMenuId("8");
		menuVO.setMenuName("Message");
		menuVO.setUrl("/admin/message");
		menuVO.setIcon("nc-email-83");
		menuVO.setComponent("src/pages/Messate.vue");
		menuVO.setRouterName("Message");
		menuList.add(menuVO);
		
		map.put("menuList", menuList);
		
		return map;
		
	}

}
