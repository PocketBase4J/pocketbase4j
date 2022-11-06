package lol.hub.pocketbase.models;

import lombok.ToString;

@ToString(callSuper = true)
public class Admin extends Account {
    int avatar;

    public int avatar() {
        return avatar;
    }
}
