package indi.yanss.jpa.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @AUTHUR guichen01
 * @DATE 2019-05-15
 **/
public enum UserState {
    NORMAL,
    ARREAR,
    DELETED;

    public static final List<UserState> VISIBLE_STATE = new LinkedList<UserState>() {
        {
            add(UserState.NORMAL);
            add(UserState.ARREAR);
        }
    };
}
