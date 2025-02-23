package hh.sof03.bookstore.web;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categorylist")
    public String showCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist"; 
    }

    @GetMapping("/addcategory")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; 
    }

    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist"; 
    }
}
