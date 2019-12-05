package nghia.phone.controller;


import nghia.phone.model.Category;
import nghia.phone.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;



    @GetMapping("/list-category")
    public ModelAndView showListCategory(){
        Iterable<Category> category = categoryService.findAll();
        ModelAndView modelAndView=new ModelAndView("category/list");
        modelAndView.addObject("categories", category);
        return modelAndView;
    }

    @GetMapping("/create-category")
    public ModelAndView showEditForm(){
        ModelAndView modelAndView=new ModelAndView("category/create");
        modelAndView.addObject("categories",new Category());
        return modelAndView;
    }

    @PostMapping("/save-category")
    public ModelAndView saveCategory(Category category){
        categoryService.save(category);
        ModelAndView modelAndView=new ModelAndView("redirect:/list-category");
        modelAndView.addObject("categories",new Category());
        modelAndView.addObject("success","Added category successfully");
        return modelAndView;

    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        Category category=categoryService.findById(id);
        ModelAndView modelAndView=new ModelAndView("category/edit");
        modelAndView.addObject("categories",category);
        return modelAndView;
    }

    @PostMapping("/update-category")
    public ModelAndView updateCategory(@ModelAttribute Category category){
        categoryService.save(category);
        ModelAndView modelAndView=new ModelAndView("redirect:/list-category");
        modelAndView.addObject("categories", category);
        modelAndView.addObject("success","updated category successfully");
        return modelAndView;
    }
}
