package com.morrs.domain.values.user;

import com.morrs.domain.values.BaseValueObject;

public class ProfilePhotoLink extends BaseValueObject<String> {
    public ProfilePhotoLink(String value) {
        super(value);
    }

    @Override
    public void validate() {

    }
}
