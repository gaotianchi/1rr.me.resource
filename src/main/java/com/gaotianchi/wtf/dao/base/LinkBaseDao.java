package com.gaotianchi.wtf.dao.base;

import com.gaotianchi.wtf.entity.Link;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gaotianchi
 * @since 2025-02-14 11:33:24
 */
@Mapper
public interface LinkBaseDao {

    void insertLink(Link link);

    void insertLinkInBatches(@Param("entities") List<Link> entities);

    void insertOrUpdateLinkInBatches(@Param("entities") List<Link> entities);

    void updateLink(Link link);

    void deleteLinkById(Integer id);

    Link selectLinkById(Integer id);

    List<Link> selectLinkByPage(@Param("entity") Link link, @Param("pageable") Pageable pageable);

    long count(Link link);
}

