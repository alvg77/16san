package com.ssan.api16san.controller;

import com.ssan.api16san.controller.resources.DiscussionThreadRequest;
import com.ssan.api16san.controller.resources.DiscussionThreadResponse;
import com.ssan.api16san.service.AuthService;
import com.ssan.api16san.service.DiscussionThreadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/api/v1/threads")
@RequiredArgsConstructor
public class DiscussionThreadController {
    private final DiscussionThreadService threadService;
    private final AuthService authService;
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam("board_id") long id) {
        return ResponseEntity.ok(threadService.getAllThreadsByBoardId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(threadService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DiscussionThreadRequest threadRequest) {
        DiscussionThreadResponse saved = threadService.save(threadRequest, authService.getCurrentUser());
        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/threads/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @Valid @RequestBody DiscussionThreadRequest threadRequest
    ) {
        return ResponseEntity.ok(threadService.update(threadRequest, authService.getCurrentUser(), id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        threadService.delete(authService.getCurrentUser(), id);
        return ResponseEntity.noContent().build();
    }
}
