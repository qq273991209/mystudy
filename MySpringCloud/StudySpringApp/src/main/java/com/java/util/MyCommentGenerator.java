package com.java.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Properties;


import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;

import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;



/**
 * 
 * @Title: MyCommentGenerator.java 
 * @Package com.java.util 
 * @Description: TODO(逆向生成实体，带中文注释) 
 * @author 刘云升  
 * @date 2019年5月20日 下午1:56:47 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class MyCommentGenerator implements CommentGenerator{

//	private Properties properties;
//    private Properties systemPro;
//    private boolean suppressDate;
//    private boolean suppressAllComments;
//    private String currentDateStr;
// 
//    public MyCommentGenerator() {
//        super();
//        properties = new Properties();
//        systemPro = System.getProperties();
//        suppressDate = false;
//        suppressAllComments = false;
//        currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
//    }
// 
//    @Override
//    public void addJavaFileComment(CompilationUnit compilationUnit) {
//        // add no file level comments by default
//        return;
//    }
// 
//    /**
//     * Adds a suitable comment to warn users that the element was generated, and
//     * when it was generated.
//     */
//    @Override
//    public void addComment(XmlElement xmlElement) {
//        return;
//    }
// 
//    @Override
//    public void addRootComment(XmlElement rootElement) {
//        // add no document level comments by default
//        return;
//    }
// 
//  
// 
//    /**
//     * This method adds the custom javadoc tag for. You may do nothing if you do
//     * not wish to include the Javadoc tag - however, if you do not include the
//     * Javadoc tag then the Java merge capability of the eclipse plugin will
//     * break.
//     *
//     * @param javaElement the java element
//     */
//    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
//        javaElement.addJavaDocLine(" *");
//        StringBuilder sb = new StringBuilder();
//        sb.append(" * ");
//        sb.append(MergeConstants.NEW_ELEMENT_TAG);
//        if (markAsDoNotDelete) {
//            sb.append(" do_not_delete_during_merge");
//        }
//        String s = getDateString();
//        if (s != null) {
//            sb.append(' ');
//            sb.append(s);
//        }
//        javaElement.addJavaDocLine(sb.toString());
//    }
// 
//    /**
//     * This method returns a formated date string to include in the Javadoc tag
//     * and XML comments. You may return null if you do not want the date in
//     * these documentation elements.
//     *
//     * @return a string representing the current timestamp, or null
//     */
//    protected String getDateString() {
//        String result = null;
//        if (!suppressDate) {
//            result = currentDateStr;
//        }
//        return result;
//    }
// 
//    @Override
//    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
//        if (suppressAllComments) {
//            return;
//        }
//        StringBuilder sb = new StringBuilder();
//        innerClass.addJavaDocLine("/**");
//        sb.append(" * ");
//        sb.append(introspectedTable.getFullyQualifiedTable());
//        sb.append(" ");
//        sb.append(getDateString());
//        innerClass.addJavaDocLine(sb.toString());
//        innerClass.addJavaDocLine(" */");
//    }
// 
//    @Override
//    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
//        if (suppressAllComments) {
//            return;
//        }
// 
//        StringBuilder sb = new StringBuilder();
// 
//        innerEnum.addJavaDocLine("/**");
//        //      addJavadocTag(innerEnum, false);
//        sb.append(" * ");
//        sb.append(introspectedTable.getFullyQualifiedTable());
//        innerEnum.addJavaDocLine(sb.toString());
//        innerEnum.addJavaDocLine(" */");
//    }
// 
//    @Override
//    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
//                                IntrospectedColumn introspectedColumn) {
//        if (suppressAllComments) {
//            return;
//        }
// 
//        StringBuilder sb = new StringBuilder();
// 
//        field.addJavaDocLine("/**");
//        sb.append(" * ");
//        sb.append(introspectedColumn.getRemarks());
//        field.addJavaDocLine(sb.toString());
// 
//        //      addJavadocTag(field, false);
// 
//        field.addJavaDocLine(" */");
//    }
// 
//    @Override
//    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
//        if (suppressAllComments) {
//            return;
//        }
// 
//        StringBuilder sb = new StringBuilder();
// 
//        field.addJavaDocLine("/**");
//        sb.append(" * ");
//        sb.append(introspectedTable.getFullyQualifiedTable());
//        field.addJavaDocLine(sb.toString());
//        field.addJavaDocLine(" */");
//    }
// 
//    @Override
//    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
// 
//    }
// 
//    @Override
//    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
//        if (suppressAllComments) {
//            return;
//        }
//        //      method.addJavaDocLine("/**");
//        //      addJavadocTag(method, false);
//        //      method.addJavaDocLine(" */");
//    }
// 
//    @Override
//    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
//                                 IntrospectedColumn introspectedColumn) {
//        if (suppressAllComments) {
//            return;
//        }
// 
//        method.addJavaDocLine("/**");
// 
//        StringBuilder sb = new StringBuilder();
//        sb.append(" * ");
//        sb.append(introspectedColumn.getRemarks());
//        method.addJavaDocLine(sb.toString());
// 
//        sb.setLength(0);
//        sb.append(" * @return ");
//        sb.append(introspectedColumn.getActualColumnName());
//        sb.append(" ");
//        sb.append(introspectedColumn.getRemarks());
//        method.addJavaDocLine(sb.toString());
// 
//        //      addJavadocTag(method, false);
// 
//        method.addJavaDocLine(" */");
//    }
// 
//    @Override
//    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
//                                 IntrospectedColumn introspectedColumn) {
//        if (suppressAllComments) {
//            return;
//        }
// 
// 
//        method.addJavaDocLine("/**");
//        StringBuilder sb = new StringBuilder();
//        sb.append(" * ");
//        sb.append(introspectedColumn.getRemarks());
//        method.addJavaDocLine(sb.toString());
// 
//        Parameter parm = method.getParameters().get(0);
//        sb.setLength(0);
//        sb.append(" * @param ");
//        sb.append(parm.getName());
//        sb.append(" ");
//        sb.append(introspectedColumn.getRemarks());
//        method.addJavaDocLine(sb.toString());
// 
//        //      addJavadocTag(method, false);
// 
//        method.addJavaDocLine(" */");
//    }
// 
//    @Override
//    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
//        if (suppressAllComments) {
//            return;
//        }
// 
//        StringBuilder sb = new StringBuilder();
// 
//        innerClass.addJavaDocLine("/**");
//        sb.append(" * ");
//        sb.append(introspectedTable.getFullyQualifiedTable());
//        innerClass.addJavaDocLine(sb.toString());
// 
//        sb.setLength(0);
//        sb.append(" * @author ");
//        sb.append(systemPro.getProperty("user.name"));
//        sb.append(" ");
//        sb.append(currentDateStr);
// 
//        //      addJavadocTag(innerClass, markAsDoNotDelete);
// 
//        innerClass.addJavaDocLine(" */");
//    }
//
//	@Override
//	public void addConfigurationProperties(Properties arg0) {
//		// TODO Auto-generated method stub
//		
//	}

	/**
     * properties�����ļ�
    */
   private Properties properties;
   /**
     * properties�����ļ�
    */
   private Properties systemPro;
   
   /*
    * ����ʱ��
    */
   private boolean suppressDate;
   
   /**
    * ��������ע��
    */
   private boolean suppressAllComments;
   
   /**
    * ��ǰʱ��
    */
   private String currentDateStr;
   
   public MyCommentGenerator() {
       super();
       properties = new Properties();
       systemPro = System.getProperties();
       suppressDate = false;
       suppressAllComments = false;
       currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
   }
   
   /**
    * Java�����ע��
    */
	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
       if (suppressAllComments) {
           return;
       }

       StringBuilder sb = new StringBuilder();
       innerClass.addJavaDocLine("/**");
       sb.append(" * ");
       sb.append(introspectedTable.getFullyQualifiedTable());
       sb.append(" ");
       sb.append(getDateString());
       innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
       innerClass.addJavaDocLine(" */");
	}

	/**
	 * Ϊ�����ע��
	 */
	@Override
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
		if (suppressAllComments) {
           return;
       }
       StringBuilder sb = new StringBuilder();
       innerClass.addJavaDocLine("/**");
       sb.append(" * ");
       sb.append(" * ");
       sb.append(introspectedTable.getFullyQualifiedTable());
       innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
       sb.setLength(0);
       sb.append(" * @author ");
       sb.append(systemPro.getProperty("user.name"));
       sb.append(" ");
       sb.append(currentDateStr);
       innerClass.addJavaDocLine(" */");
	}

	
	/**
	 * Mybatis��Mapper.xml�ļ������ע��
	 */
	@Override
	public void addComment(XmlElement xmlElement) {
		
	}

	/**
	 * 
	 *@Title addConfigurationProperties 
	 *@Description: �Ӹ������е��κ�������Ӵ�ʵ��������CommentGenerator���á�
	 *              ������������κ���������֮ǰ�����á�
	 *@Author fendo
	 *@Date 2017��10��5�� ����3:45:58
	 *@return
	 *@throws
	 */
	@Override
	public void addConfigurationProperties(Properties properties) {
		this.properties.putAll(properties);
       //suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
       //suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
	}

	/*private boolean isTrue(String property) {
		// TODO Auto-generated method stub
		return false;
	}*/

	/**
	 * 
	 *@Title getDateString 
	 *@Description: �˷������ظ�ʽ���������ַ����԰�����Javadoc����к�XMLע�͡� ���������Ҫ���ڣ�����Է���null����Щ�ĵ�Ԫ���С�
	 *@Author fendo
	 *@Date 2017��10��5�� ����3:45:58
	 *@return
	 *@throws
	 */
   protected String getDateString() {
       String result = null;
       if (!suppressDate) {
           result = currentDateStr;
       }
       return result;
   }
   
   /**
    * 
    *@Title addJavadocTag 
    *@Description: �˷���Ϊ��������Զ���javadoc��ǩ��
    *@Author fendo
    *@Date 2017��10��5�� ����3:49:05
    *@param javaElement
    *@param markAsDoNotDelete
    *@throws
    */
	protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
       javaElement.addJavaDocLine(" *");
       StringBuilder sb = new StringBuilder();
       sb.append(" * ");
       sb.append(MergeConstants.NEW_ELEMENT_TAG);
       if (markAsDoNotDelete) {
           sb.append(" do_not_delete_during_merge");
       }
       String s = getDateString();
       if (s != null) {
           sb.append(' ');
           sb.append(s);
       }
       javaElement.addJavaDocLine(sb.toString());
   }
	
	
	/**
	 * Ϊö�����ע��
	 */
	@Override
	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
           return;
       }
       StringBuilder sb = new StringBuilder();
       innerEnum.addJavaDocLine("/**");
       sb.append(" * ");
       sb.append(introspectedTable.getFullyQualifiedTable());
       innerEnum.addJavaDocLine(sb.toString().replace("\n", " "));
       innerEnum.addJavaDocLine(" */");
	}

	/**
	 * Java����ע��
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
		if (suppressAllComments) {
           return;
       }
       StringBuilder sb = new StringBuilder();
       field.addJavaDocLine("/**");
       sb.append(" * ");
       sb.append(introspectedTable.getFullyQualifiedTable());
       field.addJavaDocLine(sb.toString().replace("\n", " "));
       field.addJavaDocLine(" */");
       
       
       
	}

	/**
	 * Ϊ�ֶ����ע��
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
           return;
       }
       StringBuilder sb = new StringBuilder();
       field.addJavaDocLine("/**");
       sb.append(" * ");
       sb.append(introspectedColumn.getRemarks());
       field.addJavaDocLine(sb.toString().replace("\n", " "));
       field.addJavaDocLine(" */");
	}

	/**
	 * ��ͨ������ע�ͣ�������Ҫ��XXXMapper.java����Ľӿڷ�����ע��
	 */
	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
	  if (suppressAllComments) {
       return;
     }
     method.addJavaDocLine("/**");
     addJavadocTag(method, false);
     method.addJavaDocLine(" */");
	}

	
	/**
	 * ��getter������ע��
	 */
	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn) {
	    if (suppressAllComments) {
           return;
       }
       method.addJavaDocLine("/**");
       StringBuilder sb = new StringBuilder();
       sb.append(" * ");
       sb.append(introspectedColumn.getRemarks());
       method.addJavaDocLine(sb.toString().replace("\n", " "));
       sb.setLength(0);
       sb.append(" * @return ");
       sb.append(introspectedColumn.getActualColumnName());
       sb.append(" ");
       sb.append(introspectedColumn.getRemarks());
       method.addJavaDocLine(sb.toString().replace("\n", " "));
       method.addJavaDocLine(" */");
	}

	/**
	 * ��Java�ļ���ע�ͣ����ע�������ļ��Ķ�����Ҳ����package���档
	 */
	@Override
	public void addJavaFileComment(CompilationUnit compilationUnit) {
   	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
   	compilationUnit.addFileCommentLine("/*");
   	compilationUnit.addFileCommentLine("*");
   	compilationUnit.addFileCommentLine("* "+compilationUnit.getType().getShortName()+".java");
   	compilationUnit.addFileCommentLine("* Copyright(C) 2017-2020 fendo��˾");
   	compilationUnit.addFileCommentLine("* @date "+sdf.format(new Date())+"");
   	compilationUnit.addFileCommentLine("*/");
	}

	/**
	 * Ϊģ�������ע��
	 */
	@Override
	public void addModelClassComment(TopLevelClass arg0, IntrospectedTable arg1) {
		
	}

	/**
	 * Ϊ���ô˷�����Ϊ��Ԫ�صĵ�һ���ӽڵ����ע�͡�
	 */
	@Override
	public void addRootComment(XmlElement arg0) {
		
	}

	
	/**
	 * ��setter������ע��
	 */
	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn) {
		if (suppressAllComments) {
           return;
       }
       method.addJavaDocLine("/**");
       StringBuilder sb = new StringBuilder();
       sb.append(" * ");
       sb.append(introspectedColumn.getRemarks());
       method.addJavaDocLine(sb.toString().replace("\n", " "));
       Parameter parm = method.getParameters().get(0);
       sb.setLength(0);
       sb.append(" * @param ");
       sb.append(parm.getName());
       sb.append(" ");
       sb.append(introspectedColumn.getRemarks());
       method.addJavaDocLine(sb.toString().replace("\n", " "));
       method.addJavaDocLine(" */");
	}
}
