package com.chefencasa.service;

import com.chefencasa.Model.Category;
import com.chefencasa.Repository.CategoryRepository;

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

    private Category mapToEntity (grpc.Category.CategoryDTO dto) throws Exception{
        Category u = new Category();
        u.setIdCategory(dto.getIdCategory());
        u.setName(dto.getName());

        return u;
    }
}
