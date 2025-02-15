package com.gaotianchi.wtf.service.impl;

import com.gaotianchi.wtf.service.CoreService;
import org.springframework.stereotype.Service;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:23
 **/
@Service("CoreService")
public class CoreServiceImpl implements CoreService {
    @Override
    public String getOriginalUrl(
            String code,
            String password
    ) {
        return "";
    }
}
