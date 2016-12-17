package project.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by slava23 on 12/16/2016.
 */

@Data
@AllArgsConstructor(staticName = "of")

public class TabConfig {

    private List<String> columnNames;
    private String content;

}
