package com.example.capitalization;

import javax.inject.Inject;

public class FooServiceImpl implements FooService {
    @Inject
    public FooServiceImpl(){}

    @Override
    public int doFoo(){
        return 72;
    }
}
