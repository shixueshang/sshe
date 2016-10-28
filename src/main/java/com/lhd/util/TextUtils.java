package com.lhd.util;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {

    private static final String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
    private static final String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
    private static final String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|＼n";//定义空格回车换行符
	
	/**
	 * 从Properties文件中读取配置项
	 * @param key
	 * @param object
	 * @return
	 */
	public static String getConfig(String key, Object object){
		 InputStream inputStream = object.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		  Properties p = new Properties();
		  try {
			  p.load(inputStream);
		  } catch (IOException e1) {
			  e1.printStackTrace();
		  }
		  
		return p.getProperty(key);
	}
	/**
	 * 获取纯文本
	 * @param htmlStr
	 * @return
	 */
	public static String delHTMLTag(String htmlStr){

        Pattern p_script= Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style= Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签

        return htmlStr.trim(); //返回文本字符串 
    }



    public static String generateRandomString(int length){

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<length;i++){
            int currentLetter = (int) (Math.random() * 10);
            sb.append(currentLetter);
        }
        return sb.toString();
    }
}
