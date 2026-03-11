package com.creatip.lms.service;

import java.util.Set;

import com.creatip.lms.service.dto.MenuDTO;

public interface MenuService {

    MenuDTO getMenuForUser(Set<String> roleCodes);
    
}
