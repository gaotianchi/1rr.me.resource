package com.gaotianchi.wtf.service.impl;

import com.gaotianchi.wtf.service.ShortLinkService;
import org.springframework.stereotype.Service;

/**
 * @author gaotianchi
 * @since 2025/2/13 10:50
 **/
@Service("shortLinkService")
public class ShortLinkServiceImpl implements ShortLinkService {
    @Override
    public boolean validateCode(String code) {
        return false;
    }
}
