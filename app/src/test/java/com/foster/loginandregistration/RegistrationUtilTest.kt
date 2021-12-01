package com.foster.loginandregistration

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    //methodName_someCondition_expectedResult
    @Test
    fun validatePassword_emptyPassword_returnsFalse(){
        val result = RegistrationUtil.validatePassword("","")
        // assertThat(actualValue).isEqual(desiredValue)
        assertThat(result).isFalse()
    }

    @Test
    fun validatePassword_passwordsDontMatch_returnsFalse() {
        val result = RegistrationUtil.validatePassword("i","i")
        assertThat(result).isFalse()
    }
}