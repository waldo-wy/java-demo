package org.waldo.demo.foundation.io;

/**
 * 文件路径相关方法
 *
 * @author waldo.wy 2017/2/28 12:28
 */
public class FilePath {

    public static void main(String[] args) {
        System.out.println(FilePath.class.getResource(""));
        System.out.println(FilePath.class.getResource("/"));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));  // 推荐使用
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("/"));  // 无效
        System.out.println(FilePath.class.getClassLoader().getResource(""));
        System.out.println(FilePath.class.getClassLoader().getResource("/"));  // 无效
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println(ClassLoader.getSystemResource("/")); // 无效
        // Web应用中
        // ServletContext.getRealPath("")
    }

}
