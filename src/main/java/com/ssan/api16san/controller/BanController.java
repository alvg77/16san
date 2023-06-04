package com.ssan.api16san.controller;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.service.AuthService;
import com.ssan.api16san.service.BanService;
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

    @GetMapping(params = "boardName")
    public ResponseEntity<?> getAllBansByBoardName(@RequestParam String boardName) {
        return ResponseEntity.ok(banService.getAllBansFromBoard(boardName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(
                banService.getById(id)
        );
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BanResource banResource) {
        BanResource saved = banService.save(banResource, authService.getCurrentUser());
        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/bans/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody BanResource banResource, @PathVariable long id) {
        return ResponseEntity.ok(banService.update(banResource, authService.getCurrentUser(), id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        banService.delete(authService.getCurrentUser(), id);
        return ResponseEntity.noContent().build();
    }
}
