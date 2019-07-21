package com.example.capitalization.di;

import com.example.capitalization.FooService;
import com.example.capitalization.FooServiceImpl;
import dagger.Module;
import dagger.Provides;

@Module
public class CapitalizatonModule {

    @Provides static FooService provideFooService(FooServiceImpl fooServiceImpl) {
        return fooServiceImpl;
    }

}
