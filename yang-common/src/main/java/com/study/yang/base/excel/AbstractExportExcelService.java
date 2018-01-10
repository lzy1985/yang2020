package com.study.yang.base.excel;

import com.study.yang.base.util.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/10/19 上午6:32
 * @Description excle导出，集成此抽象类，实现exportData方法
 */
@Slf4j
public abstract class AbstractExportExcelService {
    /**
     * @param fileName    EXCEL文件名称
     * @param title       行列标题集合
     * @param listContent 正文数据集合
     * @return
     */
    public final String exportExcel(String fileName, String[] title, List<?> listContent) {
        String result = fileName;
        HSSFWorkbook workbook = null;
        OutputStream os = null;
        try {
            os = new FileOutputStream(fileName);
            workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Sheet1");
            exportData(sheet, title, listContent, workbook);

        } catch (Exception e) {
            result = "系统提示：Excel文件导出失败，原因：" + e.toString();
            log.error("导出excel错误，导出数据集：{}，错误信息：{}", JSONUtils.toJson(listContent), e.getMessage());
        } finally {
            if (null != workbook) {
                try {
                    workbook.write(os);
                    if (null != os) {
                        os.flush();
                        os.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    /**
     * 设置样式-居中-加粗
     *
     */
    protected HSSFCellStyle styleTitileCenter(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);// 设置背景色
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 10);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        // 把字体应用到当前的样式
        style.setFont(font);
        return style;
    }

    /**
     * 设置样式-居中
     *
     */
    protected HSSFCellStyle styleTextCenter(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 10);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);

        // 把字体应用到当前的样式
        style.setFont(font);
        return style;
    }

    /**
     * 创建cell
     *
     * @param row
     * @param j
     * @param value
     * @param styleTextCenter
     */
    protected void createCell(HSSFRow row, int j, String value, HSSFCellStyle styleTextCenter) {
        HSSFCell cell = row.createCell(j++);
        cell.setCellValue(value);
        cell.setCellStyle(styleTextCenter);
    }

    protected String fmtMicrometer(BigDecimal decimal) {
        if (null == decimal) {
            return "0.00";
        }
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return df.format(decimal.doubleValue());
    }

    protected String strFormat(String str) {
        return null != str ? str : "";
    }

    /**
     * 导出excel拼装数据
     *
     * @param sheet
     * @param title       行列标题集合
     * @param listContent 正文数据集合
     * @param workbook
     */
    public abstract void exportData(HSSFSheet sheet, String[] title, List<?> listContent, HSSFWorkbook workbook);
}
