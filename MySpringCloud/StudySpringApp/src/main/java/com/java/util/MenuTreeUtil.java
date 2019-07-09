package com.java.util;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.java.entity.SystemMenuAndChildrenVO;
/**
 * 
 * @Title: MenuTreeUtil.java 
 * @Package com.amt.util 
 * @Description: 递归构造树型结构
 * @author lys 
 * @date 2019年5月15日 上午11:31:54 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class MenuTreeUtil {
    //保存菜单
    public List<SystemMenuAndChildrenVO> menuCommon; 
    //数据结果绑定生成结果集合
    public List<Object> list = new ArrayList<Object>();  
    /**
     * 
     * @description: 
     * @param menu 所有需要组装的数据集合
     * @return 组装为树形结构的集合数据
     */
    public List<Object> menuList(List<SystemMenuAndChildrenVO> menu){      
        this.menuCommon = menu;  
        for (SystemMenuAndChildrenVO x : menu) {     
            Map<String,Object> mapArr = new LinkedHashMap<String, Object>();  
            if(x.getPid()!=null&&x.getPid()==0){  
                mapArr.put("id", x.getId());  
                mapArr.put("name", x.getName());    
                mapArr.put("pid", x.getPid());    
                mapArr.put("children", menuChild(x.getId()));    
                list.add(mapArr);  
            }  
        }
        return list;  
    }  
    /**
     * 
     * @description:  用于获取子类方法
     * @param id 父类Id
     * @return 子类集合
     */
    public List<?> menuChild(Long id){  
        List<Object> lists = new ArrayList<Object>();  
        for(SystemMenuAndChildrenVO a:menuCommon){  
            Map<String,Object> childArray = new LinkedHashMap<String, Object>();  
            if(a.getPid()!=null&&a.getPid() == id){  
                childArray.put("id", a.getId());  
                childArray.put("name", a.getName());  
                childArray.put("pid", a.getPid());  
                childArray.put("children", menuChild(a.getId()));
                lists.add(childArray);  
            }  
        }  
        return lists; 
    }  

}
