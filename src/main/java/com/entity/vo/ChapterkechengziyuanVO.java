package com.entity.vo;

import com.entity.ChapterkechengziyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 课程资源章节表
 * @author 
 * @email 
 * @date 2025-03-29 21:36:17
 */
public class ChapterkechengziyuanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 章节数
	 */
	
	private Integer chapternum;
		
	/**
	 * 章节标题
	 */
	
	private String chaptertitle;
		
	/**
	 * 章节内容
	 */
	
	private String content;
				
	
	/**
	 * 设置：章节数
	 */
	 
	public void setChapternum(Integer chapternum) {
		this.chapternum = chapternum;
	}
	
	/**
	 * 获取：章节数
	 */
	public Integer getChapternum() {
		return chapternum;
	}
				
	
	/**
	 * 设置：章节标题
	 */
	 
	public void setChaptertitle(String chaptertitle) {
		this.chaptertitle = chaptertitle;
	}
	
	/**
	 * 获取：章节标题
	 */
	public String getChaptertitle() {
		return chaptertitle;
	}
				
	
	/**
	 * 设置：章节内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：章节内容
	 */
	public String getContent() {
		return content;
	}
			
}
