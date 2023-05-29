package com.ssan.api16san.service.impl;

import com.ssan.api16san.controller.resources.BanResource;
import com.ssan.api16san.entity.Ban;
import static com.ssan.api16san.mapper.BanMapper.MAPPER;
import com.ssan.api16san.repository.BanRepository;
import com.ssan.api16san.service.BanService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BanServiceImpl implements BanService {
    private final BanRepository banRepository;

    @Override
    public BanResource save(BanResource banResource) {
        Ban banEntity = banRepository.save(MAPPER.fromBanResource(banResource));
        banResource.setId(banEntity.getId());
        return banResource;
    }

    public List<BanResource> getAll() {
        return MAPPER.toBanResourceList(banRepository.findAll());
    }

    public BanResource get(Long id) {
        return MAPPER.toBanResource(banRepository.findById(id).orElseThrow());
    }

    public BanResource update(BanResource banResource) {
        Ban banEntity = banRepository.update(banResource.getReason(), banResource.getExpiresAt(), banResource.getId()).orElseThrow();
        return MAPPER.toBanResource(banEntity);
    }

    public void delete(Long id) {
        banRepository.deleteById(id);
    }
}
