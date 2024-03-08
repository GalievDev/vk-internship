package dev.galiev.vkinternship.service;

import dev.galiev.vkinternship.dto.album.Album;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlbumsService {
    ResponseEntity<List<Album>> getAlbums();
    ResponseEntity<Album> getAlbum(Integer id);
    ResponseEntity<Album> create(Album album);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<Album> edit(Integer id, Album album);
}
