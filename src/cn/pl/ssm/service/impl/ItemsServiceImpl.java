package cn.pl.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pl.ssm.exception.CustomException;
import cn.pl.ssm.mapper.ItemsMapper;
import cn.pl.ssm.mapper.ItemsMapperCustom;
import cn.pl.ssm.po.Items;
import cn.pl.ssm.po.ItemsCustom;
import cn.pl.ssm.po.ItemsQueryVo;
import cn.pl.ssm.service.ItemsService;


//@Service("itemsServiceImpl")
public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		Items items=itemsMapper.selectByPrimaryKey(id);
		if (items==null) {
			throw new CustomException("修改商品信息不存在");
		}
		ItemsCustom itemsCustom=null;
		if (items!=null) {	
			itemsCustom=new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}
		return itemsCustom;
	}
	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		itemsCustom.setId(id);
		//更新所有数据。包括大文本类型
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
}
