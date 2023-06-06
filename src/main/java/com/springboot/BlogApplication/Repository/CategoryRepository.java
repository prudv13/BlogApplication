package com.springboot.BlogApplication.Repository;

import com.springboot.BlogApplication.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
