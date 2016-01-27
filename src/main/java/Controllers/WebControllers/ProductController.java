package Controllers.WebControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hoapham on 27/01/2016.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @RequestMapping(value = "/list")
    public ModelAndView listProduct(){
        ModelAndView listProductsView = new ModelAndView("products");
        return listProductsView;
    }
}
