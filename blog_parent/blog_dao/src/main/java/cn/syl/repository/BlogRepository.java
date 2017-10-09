package cn.syl.repository;

import cn.syl.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository  extends JpaRepository<Blog,Long> {
}
