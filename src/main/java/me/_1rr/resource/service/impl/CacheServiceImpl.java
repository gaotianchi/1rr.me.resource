package me._1rr.resource.service.impl;

import me._1rr.resource.dao.CoreDao;
import me._1rr.resource.dto.LinkDto;
import me._1rr.resource.service.CacheService;
import me._1rr.resource.vo.LinkCoreVo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author gaotianchi
 * @since 2025/2/16 上午10:39
 **/
@Service("CacheService")
public class CacheServiceImpl implements CacheService {

    private final CoreDao coreDao;

    public CacheServiceImpl(CoreDao coreDao) {
        this.coreDao = coreDao;
    }

    @Override
    @Cacheable(value = "link", key = "#code")
    public LinkCoreVo getCoreLinkByCode(String code) {
        return coreDao.getLinkCoreByCode(code);
    }

    @Override
    @CachePut(value = "link", key = "#linkDto.code")
    public void updateCoreLinkByCode(LinkDto linkDto) {
        coreDao.updateLinkCoreByCode(linkDto);
    }

    @Override
    @CacheEvict(value = "link", key = "#code")
    public void deleteCoreLinkByCode(String code) {
        coreDao.deleteLinkCoreByCode(code);
    }
}
