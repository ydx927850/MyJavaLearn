package util;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * 提取word文档纯文本
 */
public class WordContentUtil {
    public static void extractContent(String srcPath,String destPath){
        try {
            InputStream in = Files.newInputStream(Paths.get(srcPath));
            HWPFDocument document = new HWPFDocument(in);
            Range range = document.getRange();
            String res = readTable(range);
            OutputStream out = Files.newOutputStream(Paths.get(destPath));
            out.write(Objects.requireNonNull(res).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 读表格
     * 每一个回车符代表一个段落，所以对于表格而言，每一个单元格至少包含一个段落，每行结束都是一个段落。
     * @param range
     * @return
     */
    private static String readTable(Range range) {
        TableIterator tableIter = new TableIterator(range);
        Table table;
        TableRow row;
        TableCell cell;
        StringBuilder res = new StringBuilder();
        while (tableIter.hasNext()) {
            table = tableIter.next();
            int rowNum = table.numRows();
            for (int j=0; j<rowNum; j++) {
                row = table.getRow(j);
                int cellNum = row.numCells();
                for (int k=0; k<cellNum; k++) {
                    cell = row.getCell(k);
                    String text = cell.text();
                    String reg = "[^a-zA-Z0-9\\u4e00-\\u9fa5]";
                    res.append(text.replaceAll(reg,""));
                    res.append(text);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

    }
}