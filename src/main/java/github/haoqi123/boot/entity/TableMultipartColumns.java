package github.haoqi123.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableMultipartColumns {
    private Integer id;

    private String name1;

    private String name2;

    private String name3;
}