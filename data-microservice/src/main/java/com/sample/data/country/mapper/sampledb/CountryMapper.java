package com.sample.data.country.mapper.sampledb;

import com.sample.data.country.model.Country;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
@CacheNamespace
public interface CountryMapper {

    @Options(useCache = true, flushCache = Options.FlushCachePolicy.FALSE)
    @Select("SELECT ID as id, NAME as name, CODE as code,  CREATED_BY as createdBy, " +
            " MODIFIED_BY as modifiedBy, IS_DELETED as deleted " +
            " from DBO_SAMPLE.REF_COUNTRY WHERE IS_DELETED=0")
    List<Country> list();

    void insertCountry(Country country);

    int updateCountry(Country country);

    int deleteCountry(@Param("id") Integer id, @Param("modifiedBy") String modifiedBy);

}
