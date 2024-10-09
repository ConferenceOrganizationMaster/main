package com.bulatmain.accountservice.domain.user.value;

public interface Password<T extends Password> {
    boolean equals(T password);
}
