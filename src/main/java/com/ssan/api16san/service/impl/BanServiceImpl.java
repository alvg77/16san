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

    @Override
    public List<BanResource> getAll() {
        return MAPPER.toBanResourceList(banRepository.findAll());
    }

    @Override
    public BanResource getById(Long id) {
        return MAPPER.toBanResource(banRepository.findById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {
        banRepository.deleteById(id);
    }


    @Override
    public BanResource update(BanResource banResource, Long id) {
        Ban ban = banRepository.getReferenceById(id);

        if (ban == null) {
            throw new EntityNotFoundException("Cannot find a ban with such id.");
        }

        ban.setReason(banResource.getReason());
        ban.setExpiresAt(banResource.getExpiresAt());

        return MAPPER.toBanResource(banRepository.save(ban));
    }
}
