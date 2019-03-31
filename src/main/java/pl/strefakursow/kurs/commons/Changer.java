package pl.strefakursow.kurs.commons;

import org.springframework.stereotype.Component;

public interface Changer<F,T> {
    T map(F from);
}
