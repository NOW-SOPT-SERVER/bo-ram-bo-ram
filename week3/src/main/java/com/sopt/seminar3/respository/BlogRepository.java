package com.sopt.seminar3.respository;

import com.sopt.seminar3.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}