package com.jmp.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmp.dscommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
