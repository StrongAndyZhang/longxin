package org.longxin.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.longxin.domains.Product;
import org.longxin.service.FeatureService;
import org.longxin.service.ProductService;
import org.longxin.web.controller.bean.ProductSearchBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product") 
public class ProductController {

	@Autowired
	ProductService productService;
	
	FeatureService featureService;
	
	@RequestMapping(method = RequestMethod.GET)  
    public String getAllProducts(Model model) {  
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
        return "redirect:/product/list";  
    }
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchProduct(Model model)
	{
		model.addAttribute("productSearchBean", new ProductSearchBean());
		model.addAttribute("products", productService.getAllProducts());
		return "/product/listproducts";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String doSearchProduct(Model model, ProductSearchBean searchForm)
	{
		model.addAttribute("productSearchBean", searchForm);
		System.out.println(searchForm.getKeyword());
		if (StringUtils.isEmpty(searchForm.getKeyword()))
		{
			model.addAttribute("products", productService.getAllProducts());
		} else
		{
			model.addAttribute("products", productService.getProjectByID(Integer.valueOf(searchForm.getKeyword())));
		}
		return "/product/listproducts";
	}
	
    /**
     * responsible for the product/add GET request.
     */ 
    @RequestMapping(value="/add", method=RequestMethod.GET) 
    public String addProduct(Model model){ 
        model.addAttribute(new Product()); 
        return "/product/addproduct"; 
    } 
    
    /**
     * Reponsbile for the product/add POST request.
     */
    @RequestMapping(value="/add", method=RequestMethod.POST) 
	public String addProduct(Product product) {
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
    		    .getAuthentication()
    		    .getPrincipal();
    	productService.saveProduct(product);
		return "redirect:/product/list";
	}

    @RequestMapping("/list") 
    public String list(Model model){ 
        model.addAttribute("product", productService.getAllProducts()); 
        return "/product/listproducts"; 
    } 
      
    @RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
	public String editProduct(@PathVariable int productId, Model model)
	{
		Product product = productService.getProjectByID(productId);
		model.addAttribute("product", product);
		//model.addAttribute("feature", featureService);
		return "/product/editproduct";
	}
	
	@RequestMapping(value = "/edit/{productId}", method = RequestMethod.POST)
	public String editUsers(Model model, Product product)
	{
		//productService.editProduct(product);
		//model.addAttribute("userSearchBean", new UserSearchBean());
		//model.addAttribute(new Users());
		return "redirect:/user/search";
	}
	
	@RequestMapping(value = "/delete/{productId}", method = RequestMethod.POST)
	public void deleteUsers(@PathVariable int productId,Model model)
	{
		productService.deleteProduct(productId);
	}
  

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}  
}
