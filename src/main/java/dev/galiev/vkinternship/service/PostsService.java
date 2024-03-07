package dev.galiev.vkinternship.service;

import dev.galiev.vkinternship.dto.post.Post;
import dev.galiev.vkinternship.dto.post.Posts;

public interface PostsService {
    Posts getPosts();
    Post getPost(Integer id);
    Post create(Post post);
    Post delete(Post post);
    Post delete(Integer id);
    Post edit(Post post);
    Post edit(Integer id);
}
