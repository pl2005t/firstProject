package cn.pl.ssm.mapper;


import java.util.List;


import cn.pl.ssm.po.ItemsCustom;
import cn.pl.ssm.po.ItemsQueryVo;



public interface ItemsMapperCustom {
   public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}