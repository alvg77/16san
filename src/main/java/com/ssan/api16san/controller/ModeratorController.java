package com.ssan.api16san.controller;

import com.ssan.api16san.controller.resources.ModeratorResource;
import com.ssan.api16san.service.AuthService;
import com.ssan.api16san.service.ModeratorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/api/v1/moderators")
@RequiredArgsConstructor
public class ModeratorController {
    private final AuthService authService;
    private final ModeratorService moderatorService;

    @GetMapping(params = "boardId")
    public ResponseEntity<?> getAll(@RequestParam long boardId) {
        return ResponseEntity.ok(moderatorService.getAllModeratorsFromBoard(boardId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(moderatorService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ModeratorResource moderatorResource) {
        ModeratorResource saved = moderatorService.save(moderatorResource, authService.getCurrentUser());

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/moderators/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        moderatorService.delete(authService.getCurrentUser(), id);
        return ResponseEntity.noContent().build();
    }
}
