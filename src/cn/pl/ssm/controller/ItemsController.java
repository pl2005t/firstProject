package cn.pl.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.regexp.internal.recompile;

import cn.pl.ssm.controller.validation.ValidGroup1;
import cn.pl.ssm.exception.CustomException;
import cn.pl.ssm.po.ItemsCustom;
import cn.pl.ssm.po.ItemsQueryVo;
import cn.pl.ssm.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController{

	@Autowired
	//@Resource
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception {
		System.out.println("id==========================================="+request.getParameter("id"));
		
		List<ItemsCustom> iList=itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("items",iList);
		/*modelAndView.setViewName("/WEB-INF/jsp/items/items.jsp");*/
		modelAndView.setViewName("items/items");
		return modelAndView;
	}
	
	@RequestMapping("/skip")
	public ModelAndView skip() throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject(null);
		modelAndView.setViewName("items/dragger");
		//modelAndView.setViewName("/WEB-INF/jsp/items/dragger.jsp");
		return modelAndView;
	}
	
	/*@RequestMapping(value="/editItems",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView editItems() throws Exception{
		ItemsCustom itemsCustom=itemsService.findItemsById(1);	
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("itemsCustom",itemsCustom);
		modelAndView.setViewName("items/editItems");
		return modelAndView;
	}*/
	
	@RequestMapping(value="/editItems",method= {RequestMethod.GET,RequestMethod.POST})
	public String editItems(Model model,@RequestParam(value="id") Integer items_id) throws Exception{
		ItemsCustom itemsCustom=itemsService.findItemsById(items_id);
	/*	if (itemsCustom==null) {
			throw new CustomException("修改商品信息不存在");
		}*/
		model.addAttribute("itemsCustom",itemsCustom);
		return "items/editItems";
	}
	
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception{
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		return itemsCustom;
	}
/*	@RequestMapping("/editItemsSubmit")
	public ModelAndView editItemsSubmit() throws Exception{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}*/
	
	//在需要校验的pojo前加@Validated，在之后加BindingResult用于接收校验出错的信息；当出现多个需要校验的pojo时，@Validated和BindingResult配对出现，并且顺序固定
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model,HttpServletRequest request,Integer id,@Validated(value= {ValidGroup1.class}) ItemsCustom itemsCustom,BindingResult bindingResult,MultipartFile items_pic) throws Exception{
		
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors=  bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors", allErrors);
			
			return "items/editItems";
		}
		String originalFilename = items_pic.getOriginalFilename();
		if (items_pic!=null&&originalFilename!=null&&originalFilename.length()>0) {
			String picPath="E:\\upload\\temp\\";
			
			String newFilename=UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile=new File(picPath+newFilename);
			items_pic.transferTo(newFile);
			itemsCustom.setPic(newFilename);
		}
		itemsService.updateItems(id, itemsCustom);
		//重定向
		//return "redirect:queryItems.action";
		//页面转发
		//return "forward:queryItems.action";
		//return "items/editItems";
		return "success";
	}
	
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id)throws Exception{
		//批量删除业务待完善
		return "success";
	}
	
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception {
		
		List<ItemsCustom> iList=itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("items",iList);
		/*modelAndView.setViewName("/WEB-INF/jsp/items/items.jsp");*/
		modelAndView.setViewName("items/editItemsQuery");
		return modelAndView;
	}
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception{	
		//批量修改业务待完善
		return "success";
	}
	
}
