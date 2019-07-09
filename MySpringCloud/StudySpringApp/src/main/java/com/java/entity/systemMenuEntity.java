/*
*
* systemMenuEntity.java
* Copyright(C) 2017-2020 fendo��˾
* @date 2019-06-14
*/
package com.java.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "system_menu")
public class systemMenuEntity {
    /**
     * 编号
     */
    private Long id;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long pid;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String href;

    /**
     * 授权(如：user:list)
     */
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Short type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date updateTime;

    /**
     * 是否展开 0：否  1：是
     */
    private Byte isSpread;

    /**
     * 编号
     * @return id 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 编号
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 父菜单ID，一级菜单为0
     * @return pid 父菜单ID，一级菜单为0
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 父菜单ID，一级菜单为0
     * @param pid 父菜单ID，一级菜单为0
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 菜单名称
     * @return name 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单名称
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 菜单URL
     * @return href 菜单URL
     */
    public String getHref() {
        return href;
    }

    /**
     * 菜单URL
     * @param href 菜单URL
     */
    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    /**
     * 授权(如：user:list)
     * @return perms 授权(如：user:list)
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 授权(如：user:list)
     * @param perms 授权(如：user:list)
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * 类型   0：目录   1：菜单   2：按钮
     * @return type 类型   0：目录   1：菜单   2：按钮
     */
    public Short getType() {
        return type;
    }

    /**
     * 类型   0：目录   1：菜单   2：按钮
     * @param type 类型   0：目录   1：菜单   2：按钮
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 菜单图标
     * @return icon 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 菜单图标
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 排序
     * @return order_num 排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 排序
     * @param orderNum 排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后更新时间
     * @return update_time 最后更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 最后更新时间
     * @param updateTime 最后更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否展开 0：否  1：是
     * @return is_spread 是否展开 0：否  1：是
     */
    public Byte getIsSpread() {
        return isSpread;
    }

    /**
     * 是否展开 0：否  1：是
     * @param isSpread 是否展开 0：否  1：是
     */
    public void setIsSpread(Byte isSpread) {
        this.isSpread = isSpread;
    }
}