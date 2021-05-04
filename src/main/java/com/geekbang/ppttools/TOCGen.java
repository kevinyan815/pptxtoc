package com.geekbang.ppttools;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.util.List;

public class TOCGen {

    public static final String pptxPath = FileSystems.getDefault().getPath(".").toString() + "/src/main/resources/ppts";

    public static void main(String[] args) throws Exception {


        String toc = genTocFromPPTX(pptxPath);

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("toc.md"), StandardCharsets.UTF_8));

        pw.println(toc);
        pw.flush();
        pw.close();
    }

    private static String genTocFromPPTX(String s) throws Exception {
        File rootDir = new File(s);
        StringBuilder ret = new StringBuilder("# 0.自我介绍\n\n");
        for (File pptx : rootDir.listFiles()) {
            if (isThePPT(pptx)) {
                ret.append('\n').append(PPTXUtils.getToc(pptx)).append('\n');
            }
        }

        return ret.toString();
    }

    private static boolean isThePPT(File pptx) {
        String pptxName = pptx.getName();
        if (!pptxName.endsWith("pptx")) {
            return false;
        }
        for (char ch : pptxName.substring(0, pptxName.indexOf('.')).toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

}
