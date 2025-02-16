package com.gaotianchi.wtf.service;

import com.gaotianchi.wtf.exception.InvalidPasswordException;
import com.gaotianchi.wtf.exception.LinkExpiredException;
import com.gaotianchi.wtf.exception.LinkNotFoundException;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:19
 **/
public interface CoreService {
    String getOriginalUrl(
            String code,
            String password
    ) throws LinkExpiredException, LinkNotFoundException, InvalidPasswordException;
}
