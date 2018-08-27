package pers.hanchao.basiccodeguideline.easypoi.export.basic;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: 学生-导出类</P>
 *
 * @author hanchao
 * @date 2018/8/9 下午3:28
 */
@Data
@AllArgsConstructor
public class StudentExportEntity implements Serializable {
    /**
     * id
     **/
    private String id;
    /**
     * 姓名
     **/
    @Excel(name = "姓名")
    private String name;
    /**
     * 性别
     **/
    @Excel(name = "性别", replace = {"1_男,2_女"}, suffix = "生")
    private Integer sex;
    /**
     * 生日
     **/
    @Excel(name = "生日")
    private String birthday;

    public static void main(String[] args) {
        List<StudentExportEntity> list = ImmutableList
                .of(new StudentExportEntity("S01", "张三", 1, "20180611"),
                        new StudentExportEntity("S02", "李四", 1, "20180611"),
                        new StudentExportEntity("S03", "王五", 2, "20180511"),
                        new StudentExportEntity("S04", "钱六", 1, "20180601"),
                        new StudentExportEntity("S05", "赵七", 2, "20170611"),
                        new StudentExportEntity("S06", "周八", 2, "20180211"),
                        new StudentExportEntity("S07", "孙九", 1, "20180311"))
                .asList();

        for (StudentExportEntity student : list) {
            System.out.println(student.toString());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("学生清单", "一年级"), StudentExportEntity.class, list);
        System.out.println(1);

    }

}
