package com.ssan.api16san.controller;

import com.ssan.api16san.controller.resources.BoardResource;
import com.ssan.api16san.service.AuthService;
import com.ssan.api16san.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final AuthService authService;
    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(boardService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(boardService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BoardResource boardResource) {
        BoardResource saved = boardService.save(boardResource, authService.getCurrentUser());

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/boards/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @RequestBody BoardResource boardResource
    ) {
        return ResponseEntity.ok(boardService.update(boardResource, authService.getCurrentUser(), id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        boardService.delete(authService.getCurrentUser(), id);
        return ResponseEntity.noContent().build();
    }
}
