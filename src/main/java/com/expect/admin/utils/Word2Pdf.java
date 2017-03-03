package com.expect.admin.utils;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class Word2Pdf {
    private static final int wdFormatPDF = 17;// word转PDF 格式  
    private static final Logger log = LoggerFactory.getLogger(Word2Pdf.class);
    
    public static void wordToPDF(String sfileName,String toFileName){    
        
//        System.out.println("启动Word...");      
//        long start = System.currentTimeMillis();      
        ActiveXComponent app = null;  
        Dispatch doc = null;  
        try {      
            app = new ActiveXComponent("Word.Application");      
            app.setProperty("Visible", new Variant(false));  
            Dispatch docs = app.getProperty("Documents").toDispatch();    
            doc = Dispatch.call(docs,  "Open" , sfileName).toDispatch();  
//            System.out.println("打开文档..." + sfileName);  
//            System.out.println("转换文档到PDF..." + toFileName);      
            File tofile = new File(toFileName);
            //如果文件已经存在就不在生成
            if (tofile.exists()) {      
//                tofile.delete(); 
                return;
            }      
            Dispatch.call(doc,      
                          "SaveAs",      
                          toFileName, // FileName      
                          wdFormatPDF);      
//            long end = System.currentTimeMillis();      
//            System.out.println("转换完成..用时：" + (end - start) + "ms.");  
              
                
        } catch (Exception e) {      
//            System.out.println("========Error:文档转换失败：" + e.getMessage());      
            log.error("word转PDF失败", e);
        } finally {  
            Dispatch.call(doc,"Close",false);  
//            System.out.println("关闭文档");  
            if (app != null)      
                app.invoke("Quit", new Variant[] {});      
            }  
          //如果没有这句话,winword.exe进程将不会关闭  
           ComThread.Release();     
    }  

//    public static void main(String[] args) {
//        wordToPDF("C:\\Users\\zcz\\Desktop\\OA反馈2017.02.21.docx",
//                "C:\\Users\\zcz\\Desktop\\c.pdf");
////        wordToPDF("C:/Users/zcz/git/transitOA/attachment/402897815a8391db015a83af22360006.doc",
////                "C:/Users/zcz/git/transitOA/attachment/convertToPdf/402897815a8391db015a83af22360006.pdf");
//    }
}
