package com.ssan.api16san.controller;

import com.ssan.api16san.controller.resources.UpvoteResource;
import com.ssan.api16san.service.AuthService;
import com.ssan.api16san.service.UpvoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/upvotes")
@RequiredArgsConstructor
public class UpvoteController {
    private final UpvoteService upvoteService;
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UpvoteResource upvoteResource) {
        upvoteService.save(upvoteResource, authService.getCurrentUser());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(params = "postId")
    public ResponseEntity<?> create(long postId) {
        upvoteService.delete(postId, authService.getCurrentUser());
        return ResponseEntity.noContent().build();
    }
}
