package dev.galiev.vkinternship.service;

import dev.galiev.vkinternship.dto.album.Album;
import dev.galiev.vkinternship.dto.album.Albums;

public interface AlbumsService {
    Albums getPosts();
    Album getPost(Integer id);
    Album create(Album album);
    Album delete(Album album);
    Album delete(Integer id);
    Album edit(Album post);
    Album edit(Integer id);
}
