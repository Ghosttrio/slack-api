package com.ghosttrio.withslack.service.impl;

import com.ghosttrio.withslack.service.CustomMessageInterface;

public class CustomMessageInterfaceImpl implements CustomMessageInterface {
    @Override
    public void send() {
        System.out.println("test");
    }
}
