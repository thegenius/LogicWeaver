package com.lvonce.logicweaver.examples;

/*****************************************************************************************
We strongly recommend that you set all the config attributes to final, and never change it.
If you wanna something that will change, store it in entity attributes.
 *****************************************************************************************/
public final class PersonConfig {
    public final int x;
    public final String y;

    public PersonConfig(int x, String y) {
        this.x = x;
        this.y = y;
    }
}
