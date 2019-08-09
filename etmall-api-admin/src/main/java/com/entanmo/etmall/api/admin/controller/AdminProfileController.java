package com.entanmo.etmall.api.admin.controller;

import com.entanmo.etmall.core.util.JacksonUtil;
import com.entanmo.etmall.core.util.ResponseUtil;
import com.entanmo.etmall.core.util.bcrypt.BCryptPasswordEncoder;
import com.entanmo.etmall.db.domain.EtmallAdmin;
import com.entanmo.etmall.db.service.EtmallAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.entanmo.etmall.db.constant.AdminResponseConstant.ADMIN_INVALID_ACCOUNT;

@RestController
@RequestMapping("/admin/profile")
@Validated
public class AdminProfileController {
//    private final Log logger = LogFactory.getLog(AdminProfileController.class);

//    @Autowired
    private EtmallAdminService adminService;

    @RequiresAuthentication
    @PostMapping("/password")
    public Object create(@RequestBody String body) {
        String oldPassword = JacksonUtil.parseString(body, "oldPassword");
        String newPassword = JacksonUtil.parseString(body, "newPassword");
        if (StringUtils.isEmpty(oldPassword)) {
            return ResponseUtil.badArgument();
        }
        if (StringUtils.isEmpty(newPassword)) {
            return ResponseUtil.badArgument();
        }

        Subject currentUser = SecurityUtils.getSubject();
        EtmallAdmin admin = (EtmallAdmin) currentUser.getPrincipal();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(oldPassword, admin.getPassword())) {
            return ResponseUtil.fail(ADMIN_INVALID_ACCOUNT, "账号密码不对");
        }

        String encodedNewPassword = encoder.encode(newPassword);
        admin.setPassword(encodedNewPassword);

        adminService.updateById(admin);
        return ResponseUtil.ok();
    }

}
