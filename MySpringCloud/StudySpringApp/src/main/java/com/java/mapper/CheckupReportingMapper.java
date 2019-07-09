/*
*
* CheckupReportingMapper.java
* Copyright(C) 2017-2020 fendo��˾
* @date 2019-07-03
*/
package com.java.mapper;

import com.java.entity.CheckupReporting;

public interface CheckupReportingMapper {
    /**
     *
     * @mbg.generated 2019-07-03
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-07-03
     */
    int insert(CheckupReporting record);

    /**
     *
     * @mbg.generated 2019-07-03
     */
    int insertSelective(CheckupReporting record);

    /**
     *
     * @mbg.generated 2019-07-03
     */
    CheckupReporting selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2019-07-03
     */
    int updateByPrimaryKeySelective(CheckupReporting record);

    /**
     *
     * @mbg.generated 2019-07-03
     */
    int updateByPrimaryKey(CheckupReporting record);
}