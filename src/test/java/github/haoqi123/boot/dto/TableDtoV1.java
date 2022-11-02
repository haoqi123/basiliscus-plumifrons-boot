package github.haoqi123.boot.dto;

import github.haoqi123.boot.annos.SelectionKeys;
import github.haoqi123.boot.annos.SelectionKeysEnum;
import github.haoqi123.boot.entity.TableMultipartColumns;

public class TableDtoV1 extends TableMultipartColumns {

    @SelectionKeys(SelectionKeysEnum.EQ)
    public String getName1() {
        return super.getName1();
    }


    @SelectionKeys(SelectionKeysEnum.LIKE)
    public String getName2() {
        return super.getName2();
    }

}
