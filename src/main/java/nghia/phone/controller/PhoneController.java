package nghia.phone.controller;


import nghia.phone.model.Category;
import nghia.phone.model.Phone;
import nghia.phone.service.ICategoryService;
import nghia.phone.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.SortedMap;

@Controller
public class PhoneController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPhoneService phoneService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/list-phone")
    public ModelAndView showList(@RequestParam("search")Optional<String> search,
                                 @PageableDefault(size = 8,direction = Sort.Direction.ASC)Pageable pageable){
        Page<Phone> phones;
        if (search.isPresent()) {

        phones=phoneService.findAllByPhoneName(search.get(),pageable);

        }else {

            phones=phoneService.findAll(pageable);
        }

        ModelAndView modelAndView=new ModelAndView("phone/list");
        modelAndView.addObject("phones",phones);
        return modelAndView;
        }

        @GetMapping("/create-phone")
        public ModelAndView showCreatePhone(){
        ModelAndView modelAndView=new ModelAndView("phone/create");
        modelAndView.addObject("phones", new Phone());
        return modelAndView;
        }

        @PostMapping("/save-phone")
        public ModelAndView saveMaterial(@ModelAttribute("phone") Phone phone){
        phoneService.save(phone);
        ModelAndView modelAndView=new ModelAndView("redirect:/list-phone");
        modelAndView.addObject("phones",new Phone());
        modelAndView.addObject("success","Added category successfully");
        return modelAndView;
        }

        @GetMapping("/edit-phone/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        Phone phone=phoneService.findById(id);
        ModelAndView modelAndView=new ModelAndView("phone/edit");
        modelAndView.addObject("phones",phone);
        return modelAndView;
        }

        @PostMapping("/update-phone")
    public ModelAndView updatePhone(@ModelAttribute Phone phone){
        phoneService.save(phone);
        ModelAndView modelAndView =new ModelAndView("redirect:/list-phone");
        modelAndView.addObject("phones",phone);
        modelAndView.addObject("message","updated Successfully");
        return modelAndView;
        }

}
