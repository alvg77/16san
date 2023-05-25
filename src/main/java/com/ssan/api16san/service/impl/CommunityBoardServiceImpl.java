package com.ssan.api16san.service.impl;

import com.ssan.api16san.repository.CommunityBoardRepository;
import com.ssan.api16san.service.CommunityBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityBoardServiceImpl implements CommunityBoardService {
    private final CommunityBoardRepository communityBoardRepository;

}
