package project.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import project.report.resolver.Resolver;

import java.util.List;

/**
 * Created by slava23 on 12/16/2016.
 */
@Data
@AllArgsConstructor(staticName = "of")
public class ReportConfig {

    private String reportName;
    private String location;
    private List<TabConfig> tabs;
    private String subject;
    private List<String> to;

}
