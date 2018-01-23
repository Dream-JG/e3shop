package cn.zcib.e3shop.service;

import cn.zcib.e3shop.common.pojo.EasyUIDataGridResult;
import cn.zcib.e3shop.pojo.TbItem;

public interface ItemService {
	 
	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page,int rows);

}
