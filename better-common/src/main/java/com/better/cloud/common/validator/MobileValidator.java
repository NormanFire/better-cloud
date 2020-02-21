package com.better.cloud.common.validator;

import com.better.cloud.common.annotation.valid.IsMobile;
import com.better.cloud.common.constant.RegexpConstant;
import com.better.cloud.common.utils.BetterUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author lius
 * @description
 * @date 2020/2/21
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return BetterUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
