package com.prototype.architecture.layer_03_domain.userrole;

import com.prototype.architecture.layer_03_domain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class UserRolePk {

    private UserId userId;

    private UserRoleType roleType;

}
