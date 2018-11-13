package com.kotall;

import com.kotall.rms.common.utils.IdKit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author zpwang
 * @version 1.0.0
 */
public class IdKitTest {

    public static void main(String[] args) throws Exception {
        System.out.println(IdKit.getId("/litemall"));
//        FileReader fr = new FileReader(new File("E:\\gitrepos\\rms-boot\\src\\test\\resources\\tmp.txt"));
//
//        BufferedReader br = new BufferedReader(fr);
//
//        String tmp = br.readLine();
//
//        while (tmp != null) {
//            String sql = tmp.trim();
//            System.out.println("INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES (1, "+sql+");");
//            tmp = br.readLine();
//        }


    }


}
