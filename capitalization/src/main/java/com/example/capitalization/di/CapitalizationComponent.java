package com.example.capitalization.di;

import com.example.capitalization.CapitalizationService;
import dagger.Component;

@Component(modules = CapitalizatonModule.class)
public interface CapitalizationComponent {

    CapitalizationService capitalizationService();
}
