package com.ssan.api16san.service.impl;

import com.ssan.api16san.repository.ModeratorRepository;
import com.ssan.api16san.service.ModeratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModeratorServiceImpl implements ModeratorService {
    private final ModeratorRepository moderatorRepository;

}
