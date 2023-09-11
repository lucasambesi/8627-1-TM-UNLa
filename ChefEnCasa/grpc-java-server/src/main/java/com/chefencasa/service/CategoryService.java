package com.chefencasa.service;

import com.chefencasa.Model.Category;
import com.chefencasa.Model.Recipe;
import com.chefencasa.Repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    private static CategoryService service;

    CategoryRepository categoryRepository = CategoryRepository.getInstance();

    public static CategoryService getInstance() {
        if(service == null) {
            service = new CategoryService();
        }
        return service;
    }

    public Category addCategory(grpc.Category.CategoryDTO categoryDTO) throws Exception {
        Category toPersist = mapToEntity(categoryDTO);
        Category persisted = categoryRepository.createCategory(toPersist);
        return persisted;
    }

    public Category getById (int idCategory) throws Exception{
        return categoryRepository.getById(idCategory);
    }

    public List<Category> getAll() throws Exception{
        return categoryRepository.getAll();
    }

    private Category mapToEntity (grpc.Category.CategoryDTO dto) throws Exception{
        Category u = new Category();
        u.setIdCategory(dto.getIdCategory());
        u.setName(dto.getName());

        return u;
    }
}
