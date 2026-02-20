package com.eazybytes.profile.query.projection;

import com.eazybytes.profile.service.IProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileProjection {

    private final IProfileService iProfileService;

}
