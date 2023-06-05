package com.ssan.api16san.controller;

import com.ssan.api16san.controller.resources.PostResource;
import com.ssan.api16san.service.AuthService;
import com.ssan.api16san.service.PostService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final AuthService authService;
    private final PostService postService;

    @GetMapping
    public ResponseEntity<?> getAllPostsFromThread(@RequestParam("thread_id") long id) {
        return ResponseEntity.ok(postService.getAllPostsFromThread(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostResource postResource) {
        PostResource saved = postService.save(postResource, authService.getCurrentUser());
        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/posts/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody PostResource postResource, @PathVariable long id) {
        return ResponseEntity.ok(postService.update(postResource, authService.getCurrentUser(), id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        postService.delete(authService.getCurrentUser(), id);
        return ResponseEntity.noContent().build();
    }

}
