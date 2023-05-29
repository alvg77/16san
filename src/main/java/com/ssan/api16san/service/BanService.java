package com.ssan.api16san.service;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.entity.Ban;

public interface BanService {
    BanResource save(BanResource banResource);
}
