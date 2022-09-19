package com.liaobei.pojo;

/**
 * @author whr
 * @description 对照friend表创建的pojo类
 */
public class Friend {
    private int mainId;
    private int friendId;

    public int getMainId() {
        return mainId;
    }

    public void setMainId(int mainId) {
        this.mainId = mainId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "mainId=" + mainId +
                ", friendId=" + friendId +
                '}';
    }
}
