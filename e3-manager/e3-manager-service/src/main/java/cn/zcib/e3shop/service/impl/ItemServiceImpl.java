package cn.zcib.e3shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.zcib.e3shop.common.pojo.EasyUIDataGridResult;
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

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		// 设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(new PageInfo<>(list).getTotal());
		//取分页结果
		return result;
	}
	

}
