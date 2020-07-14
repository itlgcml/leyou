package com.leyou.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class ItemFree {
    public boolean phoneItemFree(Map map) throws IOException, TemplateException {
        //1创建一个配置对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        //2设置模板所在的目录
        configuration.setDirectoryForTemplateLoading(new File("E:\\ideaWorkspace\\LGworkspace\\parent-demo\\freemarker-demo\\src\\main\\resources"));
        //3设置字符集
        configuration.setDefaultEncoding("utf-8");
        //4获取对象模板
        Template template = configuration.getTemplate("demo.ftl");
        //5创建数据模型（可以实对象也可以是map）

        //6创建一个输出对象
        Writer out = new FileWriter("E:\\ideaWorkspace\\LGworkspace\\parent-demo\\freemarker-demo\\src\\main\\resources\\demo.html");//输出文件的保存路径
        //7输出
        template.process(map,out);
        //8关闭out
        out.close();
        return true;
    }
}
