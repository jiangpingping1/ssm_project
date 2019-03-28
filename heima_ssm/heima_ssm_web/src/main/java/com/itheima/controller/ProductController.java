package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.resources.Messages_pt_BR;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll.do")
    @RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
    public ModelAndView findAll(@RequestParam(required = false) String str,@RequestParam(required = false,defaultValue = "1") int pageNum,@RequestParam(required = false,defaultValue = "5")int pageSize){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll(str,pageNum,pageSize);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("str",str);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
    @RequestMapping("/save.do")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }
    @RequestMapping("/delete.do")
    public String delete(HttpServletRequest request){
        String[] ids = request.getParameterValues("ids");
        productService.delete(ids);

        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
        modelAndView.addObject("product",product);
        modelAndView.setViewName("product-update");
        return modelAndView;
    }
    @RequestMapping("/update.do")
    public String update(Product product){
        System.out.println(product);
        productService.update(product);
        return "redirect:findAll.do";
    }

}
