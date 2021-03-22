package com.zoomla.poc.respositories;

import com.zoomla.poc.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
