package com.gaotianchi.wtf.service.impl;

import com.gaotianchi.wtf.service.LinkService;
import org.springframework.stereotype.Service;

/**
 * @author gaotianchi
 * @since 2025/2/13 10:50
 **/
@Service("linkService")
public class LinkServiceImpl implements LinkService {
    @Override
    public boolean validateCode(String code) {
        return false;
    }
}
