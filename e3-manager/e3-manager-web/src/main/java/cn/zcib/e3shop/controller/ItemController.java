package cn.zcib.e3shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zcib.e3shop.pojo.TbItem;
import cn.zcib.e3shop.service.ItemSrervice;

@Controller
public class ItemController {
	
	@Autowired
	private ItemSrervice itemSrervice;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemByID(@PathVariable Long itemId) {
		
		return itemSrervice.getItemById(itemId);
	}

}
