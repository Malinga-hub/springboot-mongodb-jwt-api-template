package spring.security.api.Pojos;

import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
public class ResponsePayload {

    private String status;
    private int code;
    private int records;
    private Object data;

    public ResponsePayload() {
    }

    public ResponsePayload(String status, int code, int records, Object data) {
        this.status = status;
        this.code = code;
        this.records = records;
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public int getRecords() {
        return records;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ResponsePayload{" +
                "status='" + status + '\'' +
                ", code=" + code +
                ", records=" + records +
                ", data=" + data +
                '}';
    }
}
