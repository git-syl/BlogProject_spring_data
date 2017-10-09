package cn.syl.repository;

import cn.syl.domain.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCategoryRepository extends JpaRepository<BlogCategory,Long> {
}
