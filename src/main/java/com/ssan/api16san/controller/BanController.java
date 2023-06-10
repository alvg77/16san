package com.ssan.api16san.controller;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.repository.BanRepository;
import com.ssan.api16san.repository.BoardRepository;
import com.ssan.api16san.service.AuthService;
import com.ssan.api16san.service.BanService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/api/v1/bans")
@RequiredArgsConstructor
public class BanController {
    private final AuthService authService;
    private final BanService banService;

    @GetMapping
    public ResponseEntity<?> getAllBansByBoardName(@RequestParam("boardId") long boardId) {
        return ResponseEntity.ok(banService.getAllBansFromBoard(boardId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(
                banService.getById(id)
        );
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody BanResource banResource) {
        BanResource saved = banService.save(banResource, authService.getCurrentUser());
        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/bans/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody BanResource banResource, @PathVariable long id) {
        return ResponseEntity.ok(banService.update(banResource, authService.getCurrentUser(), id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        banService.delete(authService.getCurrentUser(), id);
        return ResponseEntity.noContent().build();
    }
}
