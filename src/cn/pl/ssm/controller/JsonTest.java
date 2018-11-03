package cn.pl.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.pl.ssm.po.ItemsCustom;

@Controller
public class JsonTest {
	//@RequestBody���������Ʒ��Ϣjson��ת��ItemsCustom����
	//@ResponseBody��ItemsCustom����ת��json���
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) {
		return itemsCustom;
	}
	
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) {
		return itemsCustom;
	}
}
