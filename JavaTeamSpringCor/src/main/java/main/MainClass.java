package main;

import Model.Member;
import config.Config;
import data.DataManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;


public class MainClass {


    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        DataManager dataManager = (DataManager) context.getBean("dataManager");


/*        try {
            Connection c = dataManager.connect();
            if (c != null) {
                System.out.println("Success!!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }*/


        Scanner sc = new Scanner(System.in);
        System.out.print("Sorgunuzu daxil edin ==>:");
        String operation = sc.next();

        try {
            List<Member> members = null;

            switch (operation) {
                case "select":
                    members = dataManager.getMemberList();
                    for (Member member : members) {
                        System.out.println(member);

                    }
                    break;
                case "selectby":
                    System.out.print("SectorID-i seçin==>");
                    int sectorId = sc.nextInt();
                    members = dataManager.getMemberListbysector(sectorId);
                    for (Member member : members) {
                        System.out.println(member);

                    }
                    break;
                case "selectone":
                    System.out.print("MemberID-ni seçin==>");
                    int memberId = sc.nextInt();
                    Member member = dataManager.getMember(memberId);
                    System.out.println(member);

                    break;

                case "insert":
                    System.out.print("Name :");
                    String name = sc.next();
                    System.out.print("Surname :");
                    String surname = sc.next();
                    System.out.print("Dob (dd.MM.yyyy):");
                    String dob = sc.next();
                    System.out.print("Sectorid :");
                    String sectorid = sc.next();
                    System.out.print("Active :");
                    int active = sc.nextInt();

                    Member uzv =new Member();
                    uzv.setName(name);
                    uzv.setSurname(surname);
                    uzv.setDob(simpleDateFormat.parse(dob));
                    uzv.setSectorId(sectorid);
                    uzv.setActive(active);
                    dataManager.addMember(uzv);
                    System.out.println("Tələbə uğurla əlavə olundu!");


                    break;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
