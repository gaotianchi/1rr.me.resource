package me._1rr.resource.dao;

import me._1rr.resource.dto.LinkDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gaotianchi
 * @since 2025/2/16 上午10:11
 **/
@Mapper
public interface CoreDao {

    /**
     * 获取的关键数据包括：原始链接，有效期以及密码
     *
     * @param code 短链接编码
     * @author gaotianchi
     * @since 2025/2/16 上午10:16
     **/
    LinkDto getLinkCoreByCode(String code);

    void updateLinkCoreByCode(LinkDto linkDto);

    void deleteLinkCoreByCode(String code);
}
