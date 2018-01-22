package cn.zcib.e3shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zcib.e3shop.mapper.TbItemMapper;
import cn.zcib.e3shop.pojo.TbItem;
import cn.zcib.e3shop.pojo.TbItemExample;
import cn.zcib.e3shop.pojo.TbItemExample.Criteria;
import cn.zcib.e3shop.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		// TODO Auto-generated method stub
		//根据主键查询
		//TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list.size()>0)
			return list.get(0);
		return null;

	}
	

}
