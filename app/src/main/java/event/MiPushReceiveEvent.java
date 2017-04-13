package event;

/**
 * Description :收到小米推送的消息事件
 * Created by NiceStars on 2017/4/11.
 * Email:NiceStars.cn@gmail.com
 */

public class MiPushReceiveEvent {
    private String  mMsg;
    private boolean mReceive;

    public MiPushReceiveEvent(String msg,boolean receive ) {
        // TODO Auto-generated constructor stub
        mMsg = msg;
        mReceive=receive;
    }

    public String getMsg() {

        return mMsg;
    }
    public boolean getReceive(){
        return mReceive;
    }

}

