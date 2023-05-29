package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.entity.Ban;

import java.util.List;

public interface BanService {
    BanResource save(BanResource banResource);
    List<BanResource> getAll();
    BanResource get(Long id);
    void delete(Long id);
}
