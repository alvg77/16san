package com.ssan.api16san.service.impl;

import com.ssan.api16san.repository.BanRepository;
import com.ssan.api16san.service.BanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BanServiceImpl implements BanService {
    private final BanRepository banRepository;

}
