package info.zzdirty.main;

/**
 * {
 *     "status": "error",
 * 	   "message": "type:信息"
 * }
 * @author ZZDirty
 */
public class StatusMsgBean {

    private String status;

    private String message;

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}