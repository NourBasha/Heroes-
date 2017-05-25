package com.heroes.pc.heroes1.groups;

/**
 * Created by pc on 4/26/2016.
 */
public class GroupObject {


    private String group_name;
    private String doctor_name;
    private String group_members;
    private String group_games;
    private String group_performance;
    private String group_top_ten;


    public GroupObject(String doctor_name, String group_name, String group_members, String group_games,String group_performance ,String group_top_ten) {
        this.doctor_name = doctor_name;
        this.group_games = group_games;
        this.group_members = group_members;
        this.group_name = group_name;
        this.group_performance=group_performance;
        this.group_top_ten = group_top_ten;

    }

    public String getGroup_performance() {
        return group_performance;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public String getGroup_games() {
        return group_games;
    }

    public String getGroup_members() {
        return group_members;
    }

    public String getGroup_name() {
        return group_name;
    }

    public String getGroup_top_ten() {
        return group_top_ten;
    }
}
