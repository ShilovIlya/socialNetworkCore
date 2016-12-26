package ru.sbrf.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sbrf.course.domain.UserData;
import ru.sbrf.course.domain.UserGroup;
import ru.sbrf.course.services.UserGroupService;

import java.util.Iterator;
import java.util.Set;


@Controller
public class UserGroupController {
    private UserGroupService userGroupService;

    @Autowired
    public void setUserGroupService(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @RequestMapping(value = "groups", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("groups", userGroupService.listAllUserGroups());
        return "groups";
    }


    @RequestMapping("group/{usergroupId}")
    public String showGroup(@PathVariable Long usergroupId, Model model){
        UserGroup userGroup = userGroupService.getUserGroupById(usergroupId);
        Set<UserData> userDataSet = userGroup.getUserDataSet();
        model.addAttribute("userdataset", userDataSet);
        Iterator iterator = userDataSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        return "groupInfo";
    }
}